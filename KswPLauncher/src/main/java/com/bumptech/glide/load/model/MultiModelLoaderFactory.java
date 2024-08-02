package com.bumptech.glide.load.model;

import android.support.v4.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {
    private static final Factory DEFAULT_FACTORY = new Factory();
    private static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = new EmptyModelLoader();
    private final Set<Entry<?, ?>> alreadyUsedEntries;
    private final List<Entry<?, ?>> entries;
    private final Factory factory;
    private final Pools.Pool<List<Throwable>> throwableListPool;

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> throwableListPool2) {
        this(throwableListPool2, DEFAULT_FACTORY);
    }

    MultiModelLoaderFactory(Pools.Pool<List<Throwable>> throwableListPool2, Factory factory2) {
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = throwableListPool2;
        this.factory = factory2;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void append(Class<Model> modelClass, Class<Data> dataClass, ModelLoaderFactory<? extends Model, ? extends Data> factory2) {
        add(modelClass, dataClass, factory2, true);
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void prepend(Class<Model> modelClass, Class<Data> dataClass, ModelLoaderFactory<? extends Model, ? extends Data> factory2) {
        add(modelClass, dataClass, factory2, false);
    }

    private <Model, Data> void add(Class<Model> modelClass, Class<Data> dataClass, ModelLoaderFactory<? extends Model, ? extends Data> factory2, boolean append) {
        Entry<?, ?> entry = new Entry<>(modelClass, dataClass, factory2);
        List<Entry<?, ?>> list = this.entries;
        list.add(append ? list.size() : 0, entry);
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(Class<Model> modelClass, Class<Data> dataClass, ModelLoaderFactory<? extends Model, ? extends Data> factory2) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> removed;
        removed = remove(modelClass, dataClass);
        append(modelClass, dataClass, factory2);
        return removed;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(Class<Model> modelClass, Class<Data> dataClass) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> factories;
        factories = new ArrayList<>();
        Iterator<Entry<?, ?>> iterator = this.entries.iterator();
        while (iterator.hasNext()) {
            Entry<?, ?> entry = iterator.next();
            if (entry.handles(modelClass, dataClass)) {
                iterator.remove();
                factories.add(getFactory(entry));
            }
        }
        return factories;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model> List<ModelLoader<Model, ?>> build(Class<Model> modelClass) {
        List<ModelLoader<Model, ?>> loaders;
        try {
            loaders = new ArrayList<>();
            for (Entry<?, ?> entry : this.entries) {
                if (!this.alreadyUsedEntries.contains(entry)) {
                    if (entry.handles(modelClass)) {
                        this.alreadyUsedEntries.add(entry);
                        loaders.add(build(entry));
                        this.alreadyUsedEntries.remove(entry);
                    }
                }
            }
        } catch (Throwable t) {
            this.alreadyUsedEntries.clear();
            throw t;
        }
        return loaders;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Class<?>> getDataClasses(Class<?> modelClass) {
        List<Class<?>> result;
        result = new ArrayList<>();
        for (Entry<?, ?> entry : this.entries) {
            if (!result.contains(entry.dataClass) && entry.handles(modelClass)) {
                result.add(entry.dataClass);
            }
        }
        return result;
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> modelClass, Class<Data> dataClass) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean ignoredAnyEntries = false;
            for (Entry<?, ?> entry : this.entries) {
                if (this.alreadyUsedEntries.contains(entry)) {
                    ignoredAnyEntries = true;
                } else if (entry.handles(modelClass, dataClass)) {
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                return this.factory.build(arrayList, this.throwableListPool);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (ignoredAnyEntries) {
                return emptyModelLoader();
            } else {
                throw new Registry.NoModelLoaderAvailableException(modelClass, dataClass);
            }
        } catch (Throwable t) {
            this.alreadyUsedEntries.clear();
            throw t;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data>, com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data> */
    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(Entry<?, ?> entry) {
        return (ModelLoaderFactory<? extends Model, ? extends Data>) entry.factory;
    }

    private <Model, Data> ModelLoader<Model, Data> build(Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.checkNotNull(entry.factory.build(this));
    }

    private static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        return (ModelLoader<Model, Data>) EMPTY_MODEL_LOADER;
    }

    /* access modifiers changed from: private */
    public static class Entry<Model, Data> {
        final Class<Data> dataClass;
        final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        private final Class<Model> modelClass;

        public Entry(Class<Model> modelClass2, Class<Data> dataClass2, ModelLoaderFactory<? extends Model, ? extends Data> factory2) {
            this.modelClass = modelClass2;
            this.dataClass = dataClass2;
            this.factory = factory2;
        }

        public boolean handles(Class<?> modelClass2, Class<?> dataClass2) {
            return handles(modelClass2) && this.dataClass.isAssignableFrom(dataClass2);
        }

        public boolean handles(Class<?> modelClass2) {
            return this.modelClass.isAssignableFrom(modelClass2);
        }
    }

    /* access modifiers changed from: package-private */
    public static class Factory {
        Factory() {
        }

        public <Model, Data> MultiModelLoader<Model, Data> build(List<ModelLoader<Model, Data>> modelLoaders, Pools.Pool<List<Throwable>> throwableListPool) {
            return new MultiModelLoader<>(modelLoaders, throwableListPool);
        }
    }

    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData<Object> buildLoadData(Object o, int width, int height, Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(Object o) {
            return false;
        }
    }
}
