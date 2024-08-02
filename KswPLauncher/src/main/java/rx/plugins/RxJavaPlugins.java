package rx.plugins;

import com.ibm.icu.text.PluralRules;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {
        /* class rx.plugins.RxJavaPlugins.AnonymousClass1 */
    };
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    RxJavaPlugins() {
    }

    public void reset() {
        RxJavaPlugins rxJavaPlugins = INSTANCE;
        rxJavaPlugins.errorHandler.set(null);
        rxJavaPlugins.observableExecutionHook.set(null);
        rxJavaPlugins.singleExecutionHook.set(null);
        rxJavaPlugins.completableExecutionHook.set(null);
        rxJavaPlugins.schedulersHook.set(null);
    }

    public RxJavaErrorHandler getErrorHandler() {
        if (this.errorHandler.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
            if (impl == null) {
                this.errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
            } else {
                this.errorHandler.compareAndSet(null, (RxJavaErrorHandler) impl);
            }
        }
        return this.errorHandler.get();
    }

    public void registerErrorHandler(RxJavaErrorHandler impl) {
        if (!this.errorHandler.compareAndSet(null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
        }
    }

    public RxJavaObservableExecutionHook getObservableExecutionHook() {
        if (this.observableExecutionHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
            if (impl == null) {
                this.observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
            } else {
                this.observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook) impl);
            }
        }
        return this.observableExecutionHook.get();
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook impl) {
        if (!this.observableExecutionHook.compareAndSet(null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
        }
    }

    public RxJavaSingleExecutionHook getSingleExecutionHook() {
        if (this.singleExecutionHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, System.getProperties());
            if (impl == null) {
                this.singleExecutionHook.compareAndSet(null, RxJavaSingleExecutionHookDefault.getInstance());
            } else {
                this.singleExecutionHook.compareAndSet(null, (RxJavaSingleExecutionHook) impl);
            }
        }
        return this.singleExecutionHook.get();
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook impl) {
        if (!this.singleExecutionHook.compareAndSet(null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    public RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        if (this.completableExecutionHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaCompletableExecutionHook.class, System.getProperties());
            if (impl == null) {
                this.completableExecutionHook.compareAndSet(null, new RxJavaCompletableExecutionHook() {
                    /* class rx.plugins.RxJavaPlugins.AnonymousClass2 */
                });
            } else {
                this.completableExecutionHook.compareAndSet(null, (RxJavaCompletableExecutionHook) impl);
            }
        }
        return this.completableExecutionHook.get();
    }

    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook impl) {
        if (!this.completableExecutionHook.compareAndSet(null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    static Object getPluginImplementationViaProperty(Class<?> pluginClass, Properties propsIn) {
        String classSuffix;
        ClassCastException e;
        ClassNotFoundException e2;
        InstantiationException e3;
        IllegalAccessException e4;
        Properties props = (Properties) propsIn.clone();
        String classSimpleName = pluginClass.getSimpleName();
        String implementingClass = props.getProperty("rxjava.plugin." + classSimpleName + ".implementation");
        if (implementingClass == null) {
            Iterator i$ = props.entrySet().iterator();
            while (true) {
                if (!i$.hasNext()) {
                    break;
                }
                Map.Entry<Object, Object> e5 = (Map.Entry) i$.next();
                String key = e5.getKey().toString();
                if (key.startsWith("rxjava.plugin.") && key.endsWith(".class") && classSimpleName.equals(e5.getValue().toString())) {
                    String implKey = "rxjava.plugin." + key.substring(0, key.length() - ".class".length()).substring("rxjava.plugin.".length()) + ".impl";
                    String implementingClass2 = props.getProperty(implKey);
                    if (implementingClass2 != null) {
                        classSuffix = implementingClass2;
                    } else {
                        throw new IllegalStateException("Implementing class declaration for " + classSimpleName + " missing: " + implKey);
                    }
                }
            }
        }
        classSuffix = implementingClass;
        if (classSuffix == null) {
            return null;
        }
        try {
            try {
                return Class.forName(classSuffix).asSubclass(pluginClass).newInstance();
            } catch (ClassCastException e6) {
                e = e6;
                throw new IllegalStateException(classSimpleName + " implementation is not an instance of " + classSimpleName + PluralRules.KEYWORD_RULE_SEPARATOR + classSuffix, e);
            } catch (ClassNotFoundException e7) {
                e2 = e7;
                throw new IllegalStateException(classSimpleName + " implementation class not found: " + classSuffix, e2);
            } catch (InstantiationException e8) {
                e3 = e8;
                throw new IllegalStateException(classSimpleName + " implementation not able to be instantiated: " + classSuffix, e3);
            } catch (IllegalAccessException e9) {
                e4 = e9;
                throw new IllegalStateException(classSimpleName + " implementation not able to be accessed: " + classSuffix, e4);
            }
        } catch (ClassCastException e10) {
            e = e10;
            throw new IllegalStateException(classSimpleName + " implementation is not an instance of " + classSimpleName + PluralRules.KEYWORD_RULE_SEPARATOR + classSuffix, e);
        } catch (ClassNotFoundException e11) {
            e2 = e11;
            throw new IllegalStateException(classSimpleName + " implementation class not found: " + classSuffix, e2);
        } catch (InstantiationException e12) {
            e3 = e12;
            throw new IllegalStateException(classSimpleName + " implementation not able to be instantiated: " + classSuffix, e3);
        } catch (IllegalAccessException e13) {
            e4 = e13;
            throw new IllegalStateException(classSimpleName + " implementation not able to be accessed: " + classSuffix, e4);
        }
    }

    public RxJavaSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
            if (impl == null) {
                this.schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
            } else {
                this.schedulersHook.compareAndSet(null, (RxJavaSchedulersHook) impl);
            }
        }
        return this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxJavaSchedulersHook impl) {
        if (!this.schedulersHook.compareAndSet(null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
        }
    }
}
