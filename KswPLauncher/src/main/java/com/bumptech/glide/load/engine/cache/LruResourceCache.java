package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource put(Key key, Resource resource) {
        return (Resource) super.put((Object) key, (Object) resource);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource remove(Key key) {
        return (Resource) super.remove((Object) key);
    }

    public LruResourceCache(long size) {
        super(size);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(Key key, Resource<?> item) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.listener;
        if (resourceRemovedListener != null && item != null) {
            resourceRemovedListener.onResourceRemoved(item);
        }
    }

    /* access modifiers changed from: protected */
    public int getSize(Resource<?> item) {
        if (item == null) {
            return super.getSize((Object) null);
        }
        return item.getSize();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int level) {
        if (level >= 40) {
            clearMemory();
        } else if (level >= 20 || level == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }
}
