package com.blankj.utilcode.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class ReflectUtils {
    private final Object object;
    private final Class<?> type;

    private ReflectUtils(Class<?> type2) {
        this(type2, type2);
    }

    private ReflectUtils(Class<?> type2, Object object2) {
        this.type = type2;
        this.object = object2;
    }

    public static ReflectUtils reflect(String className) throws ReflectException {
        return reflect(forName(className));
    }

    public static ReflectUtils reflect(String className, ClassLoader classLoader) throws ReflectException {
        return reflect(forName(className, classLoader));
    }

    public static ReflectUtils reflect(Class<?> clazz) throws ReflectException {
        return new ReflectUtils(clazz);
    }

    public static ReflectUtils reflect(Object object2) throws ReflectException {
        return new ReflectUtils(object2 == null ? Object.class : object2.getClass(), object2);
    }

    private static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String name, ClassLoader classLoader) {
        try {
            return Class.forName(name, true, classLoader);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils newInstance() {
        return newInstance(new Object[0]);
    }

    public ReflectUtils newInstance(Object... args) {
        Class<?>[] types = getArgsType(args);
        try {
            return newInstance(type().getDeclaredConstructor(types), args);
        } catch (NoSuchMethodException e) {
            List<Constructor<?>> list = new ArrayList<>();
            Constructor<?>[] declaredConstructors = type().getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructors) {
                if (match(constructor.getParameterTypes(), types)) {
                    list.add(constructor);
                }
            }
            if (!list.isEmpty()) {
                sortConstructors(list);
                return newInstance(list.get(0), args);
            }
            throw new ReflectException(e);
        }
    }

    private Class<?>[] getArgsType(Object... args) {
        if (args == null) {
            return new Class[0];
        }
        Class<?>[] result = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            Object value = args[i];
            result[i] = value == null ? NULL.class : value.getClass();
        }
        return result;
    }

    private void sortConstructors(List<Constructor<?>> list) {
        Collections.sort(list, new Comparator<Constructor<?>>() {
            /* class com.blankj.utilcode.util.ReflectUtils.AnonymousClass1 */

            public int compare(Constructor<?> o1, Constructor<?> o2) {
                Class<?>[] types1 = o1.getParameterTypes();
                Class<?>[] types2 = o2.getParameterTypes();
                int len = types1.length;
                for (int i = 0; i < len; i++) {
                    if (!types1[i].equals(types2[i])) {
                        if (ReflectUtils.this.wrapper(types1[i]).isAssignableFrom(ReflectUtils.this.wrapper(types2[i]))) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });
    }

    private ReflectUtils newInstance(Constructor<?> constructor, Object... args) {
        try {
            return new ReflectUtils(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(args));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils field(String name) {
        try {
            Field field = getField(name);
            return new ReflectUtils(field.getType(), field.get(this.object));
        } catch (IllegalAccessException e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils field(String name, Object value) {
        try {
            getField(name).set(this.object, unwrap(value));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field getField(String name) throws IllegalAccessException {
        Field field = getAccessibleField(name);
        if ((field.getModifiers() & 16) == 16) {
            try {
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & -17);
            } catch (NoSuchFieldException e) {
                field.setAccessible(true);
            }
        }
        return field;
    }

    private Field getAccessibleField(String name) {
        Class<?> type2 = type();
        try {
            return (Field) accessible(type2.getField(name));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(type2.getDeclaredField(name));
                } catch (NoSuchFieldException e2) {
                    type2 = type2.getSuperclass();
                    if (type2 != null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type2 != null);
            throw new ReflectException(e);
        }
    }

    private Object unwrap(Object object2) {
        if (object2 instanceof ReflectUtils) {
            return ((ReflectUtils) object2).get();
        }
        return object2;
    }

    public ReflectUtils method(String name) throws ReflectException {
        return method(name, new Object[0]);
    }

    public ReflectUtils method(String name, Object... args) throws ReflectException {
        Class<?>[] types = getArgsType(args);
        try {
            return method(exactMethod(name, types), this.object, args);
        } catch (NoSuchMethodException e) {
            try {
                return method(similarMethod(name, types), this.object, args);
            } catch (NoSuchMethodException e1) {
                throw new ReflectException(e1);
            }
        }
    }

    private ReflectUtils method(Method method, Object obj, Object... args) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return reflect(method.invoke(obj, args));
            }
            method.invoke(obj, args);
            return reflect(obj);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Method exactMethod(String name, Class<?>[] types) throws NoSuchMethodException {
        Class<?> type2 = type();
        try {
            return type2.getMethod(name, types);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    return type2.getDeclaredMethod(name, types);
                } catch (NoSuchMethodException e2) {
                    type2 = type2.getSuperclass();
                    if (type2 != null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type2 != null);
            throw new NoSuchMethodException();
        }
    }

    private Method similarMethod(String name, Class<?>[] types) throws NoSuchMethodException {
        Class<?> type2 = type();
        List<Method> methods = new ArrayList<>();
        Method[] methods2 = type2.getMethods();
        for (Method method : methods2) {
            if (isSimilarSignature(method, name, types)) {
                methods.add(method);
            }
        }
        if (!methods.isEmpty()) {
            sortMethods(methods);
            return methods.get(0);
        }
        do {
            Method[] declaredMethods = type2.getDeclaredMethods();
            for (Method method2 : declaredMethods) {
                if (isSimilarSignature(method2, name, types)) {
                    methods.add(method2);
                }
            }
            if (!methods.isEmpty()) {
                sortMethods(methods);
                return methods.get(0);
            }
            type2 = type2.getSuperclass();
        } while (type2 != null);
        throw new NoSuchMethodException("No similar method " + name + " with params " + Arrays.toString(types) + " could be found on type " + type() + ".");
    }

    private void sortMethods(List<Method> methods) {
        Collections.sort(methods, new Comparator<Method>() {
            /* class com.blankj.utilcode.util.ReflectUtils.AnonymousClass2 */

            public int compare(Method o1, Method o2) {
                Class<?>[] types1 = o1.getParameterTypes();
                Class<?>[] types2 = o2.getParameterTypes();
                int len = types1.length;
                for (int i = 0; i < len; i++) {
                    if (!types1[i].equals(types2[i])) {
                        if (ReflectUtils.this.wrapper(types1[i]).isAssignableFrom(ReflectUtils.this.wrapper(types2[i]))) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });
    }

    private boolean isSimilarSignature(Method possiblyMatchingMethod, String desiredMethodName, Class<?>[] desiredParamTypes) {
        return possiblyMatchingMethod.getName().equals(desiredMethodName) && match(possiblyMatchingMethod.getParameterTypes(), desiredParamTypes);
    }

    private boolean match(Class<?>[] declaredTypes, Class<?>[] actualTypes) {
        if (declaredTypes.length != actualTypes.length) {
            return false;
        }
        for (int i = 0; i < actualTypes.length; i++) {
            if (!(actualTypes[i] == NULL.class || wrapper(declaredTypes[i]).isAssignableFrom(wrapper(actualTypes[i])))) {
                return false;
            }
        }
        return true;
    }

    private <T extends AccessibleObject> T accessible(T accessible) {
        if (accessible == null) {
            return null;
        }
        if (accessible instanceof Member) {
            Member member = (Member) accessible;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return accessible;
            }
        }
        if (!accessible.isAccessible()) {
            accessible.setAccessible(true);
        }
        return accessible;
    }

    public <P> P proxy(Class<P> proxyType) {
        final boolean isMap = this.object instanceof Map;
        InvocationHandler handler = new InvocationHandler() {
            /* class com.blankj.utilcode.util.ReflectUtils.AnonymousClass3 */

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object proxy, Method method, Object[] args) {
                String name = method.getName();
                try {
                    return ReflectUtils.reflect(ReflectUtils.this.object).method(name, args).get();
                } catch (ReflectException e) {
                    if (isMap) {
                        Map<String, Object> map = (Map) ReflectUtils.this.object;
                        int length = args == null ? 0 : args.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(ReflectUtils.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(ReflectUtils.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(ReflectUtils.property(name.substring(3)), args[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        };
        return (P) Proxy.newProxyInstance(proxyType.getClassLoader(), new Class[]{proxyType}, handler);
    }

    /* access modifiers changed from: private */
    public static String property(String string) {
        int length = string.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return string.toLowerCase();
        }
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    private Class<?> type() {
        return this.type;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Class<?> wrapper(Class<?> type2) {
        if (type2 == null) {
            return null;
        }
        if (type2.isPrimitive()) {
            if (Boolean.TYPE == type2) {
                return Boolean.class;
            }
            if (Integer.TYPE == type2) {
                return Integer.class;
            }
            if (Long.TYPE == type2) {
                return Long.class;
            }
            if (Short.TYPE == type2) {
                return Short.class;
            }
            if (Byte.TYPE == type2) {
                return Byte.class;
            }
            if (Double.TYPE == type2) {
                return Double.class;
            }
            if (Float.TYPE == type2) {
                return Float.class;
            }
            if (Character.TYPE == type2) {
                return Character.class;
            }
            if (Void.TYPE == type2) {
                return Void.class;
            }
        }
        return type2;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectUtils) && this.object.equals(((ReflectUtils) obj).get());
    }

    public String toString() {
        return this.object.toString();
    }

    /* access modifiers changed from: private */
    public static class NULL {
        private NULL() {
        }
    }

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String message) {
            super(message);
        }

        public ReflectException(String message, Throwable cause) {
            super(message, cause);
        }

        public ReflectException(Throwable cause) {
            super(cause);
        }
    }
}
