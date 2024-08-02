package com.blankj.utilcode.util;

import android.util.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public final class BusUtils {
    private static final Object NULL = "nULl";
    private static final String TAG = "BusUtils";
    private final Map<String, Set<Object>> mClassName_BusesMap;
    private final Map<String, Map<String, Object>> mClassName_Tag_Arg4StickyMap;
    private final Map<String, List<String>> mClassName_TagsMap;
    private final Map<String, List<BusInfo>> mTag_BusInfoListMap;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface Bus {
        int priority() default 0;

        boolean sticky() default false;

        String tag();

        ThreadMode threadMode() default ThreadMode.POSTING;
    }

    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    private BusUtils() {
        this.mTag_BusInfoListMap = new HashMap();
        this.mClassName_BusesMap = new ConcurrentHashMap();
        this.mClassName_TagsMap = new ConcurrentHashMap();
        this.mClassName_Tag_Arg4StickyMap = new ConcurrentHashMap();
        init();
    }

    private void init() {
    }

    private void registerBus(String tag, String className, String funName, String paramType, String paramName, boolean sticky, String threadMode) {
        registerBus(tag, className, funName, paramType, paramName, sticky, threadMode, 0);
    }

    private void registerBus(String tag, String className, String funName, String paramType, String paramName, boolean sticky, String threadMode, int priority) {
        List<BusInfo> busInfoList = this.mTag_BusInfoListMap.get(tag);
        if (busInfoList == null) {
            busInfoList = new ArrayList();
            this.mTag_BusInfoListMap.put(tag, busInfoList);
        }
        busInfoList.add(new BusInfo(className, funName, paramType, paramName, sticky, threadMode, priority));
    }

    public static void register(Object bus) {
        getInstance().registerInner(bus);
    }

    public static void unregister(Object bus) {
        getInstance().unregisterInner(bus);
    }

    public static void post(String tag) {
        post(tag, NULL);
    }

    public static void post(String tag, Object arg) {
        getInstance().postInner(tag, arg);
    }

    public static void postSticky(String tag) {
        postSticky(tag, NULL);
    }

    public static void postSticky(String tag, Object arg) {
        getInstance().postStickyInner(tag, arg);
    }

    public static void removeSticky(String tag) {
        getInstance().removeStickyInner(tag);
    }

    public static String toString_() {
        return getInstance().toString();
    }

    public String toString() {
        return "BusUtils: " + this.mTag_BusInfoListMap;
    }

    private static BusUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private void registerInner(Object bus) {
        if (bus != null) {
            Class aClass = bus.getClass();
            String className = aClass.getName();
            synchronized (this.mClassName_BusesMap) {
                Set<Object> buses = this.mClassName_BusesMap.get(className);
                if (buses == null) {
                    buses = new CopyOnWriteArraySet();
                    this.mClassName_BusesMap.put(className, buses);
                }
                buses.add(bus);
            }
            if (this.mClassName_TagsMap.get(className) == null) {
                synchronized (this.mClassName_TagsMap) {
                    if (this.mClassName_TagsMap.get(className) == null) {
                        List<String> tags = new CopyOnWriteArrayList<>();
                        for (Map.Entry<String, List<BusInfo>> entry : this.mTag_BusInfoListMap.entrySet()) {
                            for (BusInfo busInfo : entry.getValue()) {
                                try {
                                    if (Class.forName(busInfo.className).isAssignableFrom(aClass)) {
                                        tags.add(entry.getKey());
                                        busInfo.subClassNames.add(className);
                                    }
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        this.mClassName_TagsMap.put(className, tags);
                    }
                }
            }
            processSticky(bus);
        }
    }

    private void processSticky(Object bus) {
        Map<String, Object> tagArgMap = this.mClassName_Tag_Arg4StickyMap.get(bus.getClass().getName());
        if (tagArgMap != null) {
            synchronized (this.mClassName_Tag_Arg4StickyMap) {
                for (Map.Entry<String, Object> tagArgEntry : tagArgMap.entrySet()) {
                    postStickyInner(tagArgEntry.getKey(), tagArgEntry.getValue(), true);
                }
            }
        }
    }

    private void unregisterInner(Object bus) {
        if (bus != null) {
            String className = bus.getClass().getName();
            synchronized (this.mClassName_BusesMap) {
                Set<Object> buses = this.mClassName_BusesMap.get(className);
                if (buses != null) {
                    if (buses.contains(bus)) {
                        buses.remove(bus);
                        return;
                    }
                }
                Log.e(TAG, "The bus of <" + bus + "> was not registered before.");
            }
        }
    }

    private void postInner(String tag, Object arg) {
        postInner(tag, arg, false);
    }

    private void postInner(String tag, Object arg, boolean sticky) {
        List<BusInfo> busInfoList = this.mTag_BusInfoListMap.get(tag);
        if (busInfoList == null) {
            Log.e(TAG, "The bus of tag <" + tag + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : busInfoList) {
            invokeBus(tag, arg, busInfo, sticky);
        }
    }

    private void invokeBus(String tag, Object arg, BusInfo busInfo, boolean sticky) {
        if (busInfo.method == null) {
            Method method = getMethodByBusInfo(busInfo);
            if (method != null) {
                busInfo.method = method;
            } else {
                return;
            }
        }
        invokeMethod(tag, arg, busInfo, sticky);
    }

    private Method getMethodByBusInfo(BusInfo busInfo) {
        try {
            if ("".equals(busInfo.paramType)) {
                return Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, new Class[0]);
            }
            return Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, getClassName(busInfo.paramType));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private Class getClassName(String paramType) throws ClassNotFoundException {
        char c;
        switch (paramType.hashCode()) {
            case -1325958191:
                if (paramType.equals("double")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 104431:
                if (paramType.equals("int")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3039496:
                if (paramType.equals("byte")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3052374:
                if (paramType.equals("char")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3327612:
                if (paramType.equals("long")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 64711720:
                if (paramType.equals("boolean")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 97526364:
                if (paramType.equals("float")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 109413500:
                if (paramType.equals("short")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return Boolean.TYPE;
            case 1:
                return Integer.TYPE;
            case 2:
                return Long.TYPE;
            case 3:
                return Short.TYPE;
            case 4:
                return Byte.TYPE;
            case 5:
                return Double.TYPE;
            case 6:
                return Float.TYPE;
            case 7:
                return Character.TYPE;
            default:
                return Class.forName(paramType);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void invokeMethod(final String tag, final Object arg, final BusInfo busInfo, final boolean sticky) {
        char c;
        Runnable runnable = new Runnable() {
            /* class com.blankj.utilcode.util.BusUtils.AnonymousClass1 */

            public void run() {
                BusUtils.this.realInvokeMethod(tag, arg, busInfo, sticky);
            }
        };
        String str = busInfo.threadMode;
        switch (str.hashCode()) {
            case -1848936376:
                if (str.equals("SINGLE")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2342:
                if (str.equals("IO")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 66952:
                if (str.equals("CPU")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2358713:
                if (str.equals("MAIN")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1980249378:
                if (str.equals("CACHED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                ThreadUtils.runOnUiThread(runnable);
                return;
            case 1:
                ThreadUtils.getIoPool().execute(runnable);
                return;
            case 2:
                ThreadUtils.getCpuPool().execute(runnable);
                return;
            case 3:
                ThreadUtils.getCachedPool().execute(runnable);
                return;
            case 4:
                ThreadUtils.getSinglePool().execute(runnable);
                return;
            default:
                runnable.run();
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void realInvokeMethod(String tag, Object arg, BusInfo busInfo, boolean sticky) {
        Set<Object> buses = new HashSet<>();
        for (String subClassName : busInfo.subClassNames) {
            Set<Object> subBuses = this.mClassName_BusesMap.get(subClassName);
            if (subBuses != null && !subBuses.isEmpty()) {
                buses.addAll(subBuses);
            }
        }
        if (buses.size() != 0) {
            try {
                if (arg == NULL) {
                    for (Object bus : buses) {
                        busInfo.method.invoke(bus, new Object[0]);
                    }
                    return;
                }
                for (Object bus2 : buses) {
                    busInfo.method.invoke(bus2, arg);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else if (!sticky) {
            Log.e(TAG, "The bus of tag <" + tag + "> was not registered before.");
        }
    }

    private void postStickyInner(String tag, Object arg) {
        postStickyInner(tag, arg, false);
    }

    private void postStickyInner(String tag, Object arg, boolean isInvokeOnlySticky) {
        List<BusInfo> busInfoList = this.mTag_BusInfoListMap.get(tag);
        if (busInfoList == null) {
            Log.e(TAG, "The bus of tag <" + tag + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : busInfoList) {
            if (busInfo.sticky) {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map<String, Object> tagArgMap = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (tagArgMap == null) {
                        tagArgMap = new HashMap();
                        this.mClassName_Tag_Arg4StickyMap.put(busInfo.className, tagArgMap);
                    }
                    tagArgMap.put(tag, arg);
                }
                invokeBus(tag, arg, busInfo, true);
            } else if (!isInvokeOnlySticky) {
                invokeBus(tag, arg, busInfo, false);
            }
        }
    }

    private void removeStickyInner(String tag) {
        List<BusInfo> busInfoList = this.mTag_BusInfoListMap.get(tag);
        if (busInfoList == null) {
            Log.e(TAG, "The bus of tag <" + tag + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : busInfoList) {
            if (!busInfo.sticky) {
                Log.e(TAG, "The bus of tag <" + tag + "> is not sticky.");
                return;
            }
            synchronized (this.mClassName_Tag_Arg4StickyMap) {
                Map<String, Object> tagArgMap = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                if (tagArgMap != null) {
                    if (tagArgMap.containsKey(tag)) {
                        tagArgMap.remove(tag);
                    }
                }
                Log.e(TAG, "The sticky bus of tag <" + tag + "> didn't post.");
                return;
            }
        }
    }

    static void registerBus4Test(String tag, String className, String funName, String paramType, String paramName, boolean sticky, String threadMode, int priority) {
        getInstance().registerBus(tag, className, funName, paramType, paramName, sticky, threadMode, priority);
    }

    /* access modifiers changed from: private */
    public static final class BusInfo {
        String className;
        String funName;
        Method method;
        String paramName;
        String paramType;
        int priority;
        boolean sticky;
        List<String> subClassNames = new CopyOnWriteArrayList();
        String threadMode;

        BusInfo(String className2, String funName2, String paramType2, String paramName2, boolean sticky2, String threadMode2, int priority2) {
            this.className = className2;
            this.funName = funName2;
            this.paramType = paramType2;
            this.paramName = paramName2;
            this.sticky = sticky2;
            this.threadMode = threadMode2;
            this.priority = priority2;
        }

        public String toString() {
            return "BusInfo { desc: " + this.className + "#" + this.funName + ("".equals(this.paramType) ? "()" : "(" + this.paramType + " " + this.paramName + ")") + ", sticky: " + this.sticky + ", threadMode: " + this.threadMode + ", method: " + this.method + ", priority: " + this.priority + " }";
        }
    }

    /* access modifiers changed from: private */
    public static class LazyHolder {
        private static final BusUtils INSTANCE = new BusUtils();

        private LazyHolder() {
        }
    }
}
