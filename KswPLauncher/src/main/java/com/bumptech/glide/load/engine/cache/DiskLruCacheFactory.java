package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(final String diskCacheFolder, long diskCacheSize2) {
        this(new CacheDirectoryGetter() {
            /* class com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass1 */

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(diskCacheFolder);
            }
        }, diskCacheSize2);
    }

    public DiskLruCacheFactory(final String diskCacheFolder, final String diskCacheName, long diskCacheSize2) {
        this(new CacheDirectoryGetter() {
            /* class com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass2 */

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(diskCacheFolder, diskCacheName);
            }
        }, diskCacheSize2);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter2, long diskCacheSize2) {
        this.diskCacheSize = diskCacheSize2;
        this.cacheDirectoryGetter = cacheDirectoryGetter2;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDir = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDir == null) {
            return null;
        }
        if (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory())) {
            return DiskLruCacheWrapper.create(cacheDir, this.diskCacheSize);
        }
        return null;
    }
}
