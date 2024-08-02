package butterknife.internal;

import butterknife.internal.CollectionBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

final class ViewInjector {
    private final String className;
    private final String classPackage;
    private final Map<CollectionBinding, int[]> collectionBindings = new LinkedHashMap();
    private String parentInjector;
    private final String targetClass;
    private final Map<Integer, ViewInjection> viewIdMap = new LinkedHashMap();

    ViewInjector(String classPackage2, String className2, String targetClass2) {
        this.classPackage = classPackage2;
        this.className = className2;
        this.targetClass = targetClass2;
    }

    /* access modifiers changed from: package-private */
    public void addView(int id, ViewBinding binding) {
        getOrCreateViewInjection(id).addViewBinding(binding);
    }

    /* access modifiers changed from: package-private */
    public boolean addListener(int id, ListenerClass listener, ListenerMethod method, ListenerBinding binding) {
        ViewInjection viewInjection = getOrCreateViewInjection(id);
        if (viewInjection.hasListenerBinding(listener, method)) {
            return false;
        }
        viewInjection.addListenerBinding(listener, method, binding);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addCollection(int[] ids, CollectionBinding binding) {
        this.collectionBindings.put(binding, ids);
    }

    /* access modifiers changed from: package-private */
    public void setParentInjector(String parentInjector2) {
        this.parentInjector = parentInjector2;
    }

    private ViewInjection getOrCreateViewInjection(int id) {
        ViewInjection viewId = this.viewIdMap.get(Integer.valueOf(id));
        if (viewId != null) {
            return viewId;
        }
        ViewInjection viewId2 = new ViewInjection(id);
        this.viewIdMap.put(Integer.valueOf(id), viewId2);
        return viewId2;
    }

    /* access modifiers changed from: package-private */
    public String getFqcn() {
        return this.classPackage + "." + this.className;
    }

    /* access modifiers changed from: package-private */
    public String brewJava() {
        StringBuilder builder = new StringBuilder();
        builder.append("// Generated code from Butter Knife. Do not modify!\n");
        builder.append("package ").append(this.classPackage).append(";\n\n");
        builder.append("import android.view.View;\n");
        builder.append("import butterknife.ButterKnife.Finder;\n\n");
        builder.append("public class ").append(this.className).append(" {\n");
        emitInject(builder);
        builder.append('\n');
        emitReset(builder);
        builder.append("}\n");
        return builder.toString();
    }

    private void emitInject(StringBuilder builder) {
        builder.append("  public static void inject(Finder finder, final ").append(this.targetClass).append(" target, Object source) {\n");
        if (this.parentInjector != null) {
            builder.append("    ").append(this.parentInjector).append(".inject(finder, target, source);\n\n");
        }
        builder.append("    View view;\n");
        for (ViewInjection injection : this.viewIdMap.values()) {
            emitViewInjection(builder, injection);
        }
        for (Map.Entry<CollectionBinding, int[]> entry : this.collectionBindings.entrySet()) {
            emitCollectionBinding(builder, entry.getKey(), entry.getValue());
        }
        builder.append("  }\n");
    }

    private void emitCollectionBinding(StringBuilder builder, CollectionBinding binding, int[] ids) {
        builder.append("    target.").append(binding.getName()).append(" = ");
        switch (AnonymousClass1.$SwitchMap$butterknife$internal$CollectionBinding$Kind[binding.getKind().ordinal()]) {
            case 1:
                builder.append("Finder.arrayOf(");
                break;
            case 2:
                builder.append("Finder.listOf(");
                break;
            default:
                throw new IllegalStateException("Unknown kind: " + binding.getKind());
        }
        for (int i = 0; i < ids.length; i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append("\n        ");
            emitCastIfNeeded(builder, binding.getType());
            if (binding.isRequired()) {
                builder.append("finder.findRequiredView(source, ").append(ids[i]).append(", \"").append(binding.getName()).append("\")");
            } else {
                builder.append("finder.findOptionalView(source, ").append(ids[i]).append(")");
            }
        }
        builder.append("\n    );");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: butterknife.internal.ViewInjector$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$butterknife$internal$CollectionBinding$Kind;

        static {
            int[] iArr = new int[CollectionBinding.Kind.values().length];
            $SwitchMap$butterknife$internal$CollectionBinding$Kind = iArr;
            try {
                iArr[CollectionBinding.Kind.ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$butterknife$internal$CollectionBinding$Kind[CollectionBinding.Kind.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void emitViewInjection(StringBuilder builder, ViewInjection injection) {
        builder.append("    view = ");
        List<Binding> requiredBindings = injection.getRequiredBindings();
        if (requiredBindings.isEmpty()) {
            builder.append("finder.findOptionalView(source, ").append(injection.getId()).append(");\n");
        } else {
            builder.append("finder.findRequiredView(source, ").append(injection.getId()).append(", \"");
            emitHumanDescription(builder, requiredBindings);
            builder.append("\");\n");
        }
        emitViewBindings(builder, injection);
        emitListenerBindings(builder, injection);
    }

    private void emitViewBindings(StringBuilder builder, ViewInjection injection) {
        Collection<ViewBinding> viewBindings = injection.getViewBindings();
        if (!viewBindings.isEmpty()) {
            for (ViewBinding viewBinding : viewBindings) {
                builder.append("    target.").append(viewBinding.getName()).append(" = ");
                emitCastIfNeeded(builder, viewBinding.getType());
                builder.append("view;\n");
            }
        }
    }

    private void emitListenerBindings(StringBuilder builder, ViewInjection injection) {
        boolean needsCast;
        Map<ListenerMethod, ListenerBinding> methodBindings;
        ListenerClass listener;
        Map.Entry<ListenerClass, Map<ListenerMethod, ListenerBinding>> e;
        Map<ListenerClass, Map<ListenerMethod, ListenerBinding>> bindings = injection.getListenerBindings();
        if (!bindings.isEmpty()) {
            String extraIndent = "";
            boolean needsNullChecked = injection.getRequiredBindings().isEmpty();
            if (needsNullChecked) {
                builder.append("    if (view != null) {\n");
                extraIndent = "  ";
            }
            Iterator<Map.Entry<ListenerClass, Map<ListenerMethod, ListenerBinding>>> it = bindings.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ListenerClass, Map<ListenerMethod, ListenerBinding>> e2 = it.next();
                ListenerClass listener2 = e2.getKey();
                Map<ListenerMethod, ListenerBinding> methodBindings2 = e2.getValue();
                boolean needsCast2 = !"android.view.View".equals(listener2.targetType());
                builder.append(extraIndent).append("    ");
                if (needsCast2) {
                    builder.append("((").append(listener2.targetType());
                    if (listener2.genericArguments() > 0) {
                        builder.append(Typography.less);
                        for (int i = 0; i < listener2.genericArguments(); i++) {
                            if (i > 0) {
                                builder.append(", ");
                            }
                            builder.append('?');
                        }
                        builder.append(Typography.greater);
                    }
                    builder.append(") ");
                }
                builder.append("view");
                if (needsCast2) {
                    builder.append(')');
                }
                builder.append('.').append(listener2.setter()).append("(\n");
                builder.append(extraIndent).append("      new ").append(listener2.type()).append("() {\n");
                for (ListenerMethod method : getListenerMethods(listener2)) {
                    builder.append(extraIndent).append("        @Override public ").append(method.returnType()).append(' ').append(method.name()).append("(\n");
                    String[] parameterTypes = method.parameters();
                    int i2 = 0;
                    int count = parameterTypes.length;
                    while (i2 < count) {
                        builder.append(extraIndent).append("          ").append(parameterTypes[i2]).append(" p").append(i2);
                        if (i2 < count - 1) {
                            builder.append(',');
                        }
                        builder.append('\n');
                        i2++;
                        bindings = bindings;
                        it = it;
                    }
                    builder.append(extraIndent).append("        ) {\n");
                    builder.append(extraIndent).append("          ");
                    boolean hasReturnType = !"void".equals(method.returnType());
                    if (hasReturnType) {
                        builder.append("return ");
                    }
                    if (methodBindings2.containsKey(method)) {
                        ListenerBinding binding = methodBindings2.get(method);
                        builder.append("target.").append(binding.getName()).append('(');
                        List<Parameter> parameters = binding.getParameters();
                        String[] listenerParameters = method.parameters();
                        int count2 = parameters.size();
                        e = e2;
                        int i3 = 0;
                        while (i3 < count2) {
                            Parameter parameter = parameters.get(i3);
                            int listenerPosition = parameter.getListenerPosition();
                            emitCastIfNeeded(builder, listenerParameters[listenerPosition], parameter.getType());
                            builder.append('p').append(listenerPosition);
                            if (i3 < count2 - 1) {
                                builder.append(", ");
                            }
                            i3++;
                            listener2 = listener2;
                            methodBindings2 = methodBindings2;
                            needsCast2 = needsCast2;
                        }
                        listener = listener2;
                        methodBindings = methodBindings2;
                        needsCast = needsCast2;
                        builder.append(");");
                    } else {
                        e = e2;
                        listener = listener2;
                        methodBindings = methodBindings2;
                        needsCast = needsCast2;
                        if (hasReturnType) {
                            builder.append(method.defaultReturn()).append(';');
                        }
                    }
                    builder.append('\n');
                    builder.append(extraIndent).append("        }\n");
                    bindings = bindings;
                    it = it;
                    e2 = e;
                    listener2 = listener;
                    methodBindings2 = methodBindings;
                    needsCast2 = needsCast;
                }
                builder.append(extraIndent).append("      });\n");
                bindings = bindings;
                it = it;
            }
            if (needsNullChecked) {
                builder.append("    }\n");
            }
        }
    }

    static List<ListenerMethod> getListenerMethods(ListenerClass listener) {
        if (listener.method().length == 1) {
            return Arrays.asList(listener.method());
        }
        try {
            List<ListenerMethod> methods = new ArrayList<>();
            Class<? extends Enum<?>> callbacks = listener.callbacks();
            Enum<?>[] enumArr = (Enum[]) callbacks.getEnumConstants();
            for (Enum<?> callbackMethod : enumArr) {
                ListenerMethod method = (ListenerMethod) callbacks.getField(callbackMethod.name()).getAnnotation(ListenerMethod.class);
                if (method != null) {
                    methods.add(method);
                } else {
                    throw new IllegalStateException(String.format("@%s's %s.%s missing @%s annotation.", callbacks.getEnclosingClass().getSimpleName(), callbacks.getSimpleName(), callbackMethod.name(), ListenerMethod.class.getSimpleName()));
                }
            }
            return methods;
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    private void emitReset(StringBuilder builder) {
        builder.append("  public static void reset(").append(this.targetClass).append(" target) {\n");
        if (this.parentInjector != null) {
            builder.append("    ").append(this.parentInjector).append(".reset(target);\n\n");
        }
        for (ViewInjection injection : this.viewIdMap.values()) {
            for (ViewBinding viewBinding : injection.getViewBindings()) {
                builder.append("    target.").append(viewBinding.getName()).append(" = null;\n");
            }
        }
        for (CollectionBinding collectionBinding : this.collectionBindings.keySet()) {
            builder.append("    target.").append(collectionBinding.getName()).append(" = null;\n");
        }
        builder.append("  }\n");
    }

    static void emitCastIfNeeded(StringBuilder builder, String viewType) {
        emitCastIfNeeded(builder, "android.view.View", viewType);
    }

    static void emitCastIfNeeded(StringBuilder builder, String sourceType, String destinationType) {
        if (!sourceType.equals(destinationType)) {
            builder.append('(').append(destinationType).append(") ");
        }
    }

    static void emitHumanDescription(StringBuilder builder, List<Binding> bindings) {
        switch (bindings.size()) {
            case 1:
                builder.append(bindings.get(0).getDescription());
                return;
            case 2:
                builder.append(bindings.get(0).getDescription()).append(" and ").append(bindings.get(1).getDescription());
                return;
            default:
                int count = bindings.size();
                for (int i = 0; i < count; i++) {
                    Binding requiredField = bindings.get(i);
                    if (i != 0) {
                        builder.append(", ");
                    }
                    if (i == count - 1) {
                        builder.append("and ");
                    }
                    builder.append(requiredField.getDescription());
                }
                return;
        }
    }
}
