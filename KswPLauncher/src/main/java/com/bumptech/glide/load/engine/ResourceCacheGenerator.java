package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* access modifiers changed from: package-private */
public class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private Key sourceKey;

    ResourceCacheGenerator(DecodeHelper<?> helper2, DataFetcherGenerator.FetcherReadyCallback cb2) {
        this.helper = helper2;
        this.cb = cb2;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        List<Key> sourceIds = this.helper.getCacheKeys();
        boolean z = false;
        if (sourceIds.isEmpty()) {
            return false;
        }
        List<Class<?>> resourceClasses = this.helper.getRegisteredResourceClasses();
        if (!resourceClasses.isEmpty()) {
            while (true) {
                if (this.modelLoaders == null || !hasNextModelLoader()) {
                    int i = this.resourceClassIndex + 1;
                    this.resourceClassIndex = i;
                    if (i >= resourceClasses.size()) {
                        int i2 = this.sourceIdIndex + 1;
                        this.sourceIdIndex = i2;
                        if (i2 >= sourceIds.size()) {
                            return z;
                        }
                        int i3 = z ? 1 : 0;
                        int i4 = z ? 1 : 0;
                        int i5 = z ? 1 : 0;
                        int i6 = z ? 1 : 0;
                        int i7 = z ? 1 : 0;
                        this.resourceClassIndex = i3;
                    }
                    Key sourceId = sourceIds.get(this.sourceIdIndex);
                    Class<?> resourceClass = resourceClasses.get(this.resourceClassIndex);
                    this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), sourceId, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(resourceClass), resourceClass, this.helper.getOptions());
                    File file = this.helper.getDiskCache().get(this.currentKey);
                    this.cacheFile = file;
                    if (file != null) {
                        this.sourceKey = sourceId;
                        this.modelLoaders = this.helper.getModelLoaders(file);
                        z = false;
                        this.modelLoaderIndex = 0;
                    } else {
                        z = false;
                    }
                } else {
                    this.loadData = null;
                    boolean started = false;
                    while (!started && hasNextModelLoader()) {
                        List<ModelLoader<File, ?>> list = this.modelLoaders;
                        int i8 = this.modelLoaderIndex;
                        this.modelLoaderIndex = i8 + 1;
                        this.loadData = list.get(i8).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                        if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                            started = true;
                            this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        }
                    }
                    return started;
                }
            }
        } else if (File.class.equals(this.helper.getTranscodeClass())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());
        }
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> local = this.loadData;
        if (local != null) {
            local.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object data) {
        this.cb.onDataFetcherReady(this.sourceKey, data, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception e) {
        this.cb.onDataFetcherFailed(this.currentKey, e, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
