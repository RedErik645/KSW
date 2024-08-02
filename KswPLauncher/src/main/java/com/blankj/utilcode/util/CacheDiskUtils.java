package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import com.blankj.utilcode.constant.CacheConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDiskUtils implements CacheConstants {
    private static final Map<String, CacheDiskUtils> CACHE_MAP = new HashMap();
    private static final String CACHE_PREFIX = "cdu_";
    private static final int DEFAULT_MAX_COUNT = Integer.MAX_VALUE;
    private static final long DEFAULT_MAX_SIZE = Long.MAX_VALUE;
    private static final String TYPE_BITMAP = "bi_";
    private static final String TYPE_BYTE = "by_";
    private static final String TYPE_DRAWABLE = "dr_";
    private static final String TYPE_JSON_ARRAY = "ja_";
    private static final String TYPE_JSON_OBJECT = "jo_";
    private static final String TYPE_PARCELABLE = "pa_";
    private static final String TYPE_SERIALIZABLE = "se_";
    private static final String TYPE_STRING = "st_";
    private final File mCacheDir;
    private final String mCacheKey;
    private DiskCacheManager mDiskCacheManager;
    private final int mMaxCount;
    private final long mMaxSize;

    public static CacheDiskUtils getInstance() {
        return getInstance("", Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static CacheDiskUtils getInstance(String cacheName) {
        return getInstance(cacheName, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static CacheDiskUtils getInstance(long maxSize, int maxCount) {
        return getInstance("", maxSize, maxCount);
    }

    public static CacheDiskUtils getInstance(String cacheName, long maxSize, int maxCount) {
        if (UtilsBridge.isSpace(cacheName)) {
            cacheName = "cacheUtils";
        }
        return getInstance(new File(Utils.getApp().getCacheDir(), cacheName), maxSize, maxCount);
    }

    public static CacheDiskUtils getInstance(File cacheDir) {
        if (cacheDir != null) {
            return getInstance(cacheDir, Long.MAX_VALUE, Integer.MAX_VALUE);
        }
        throw new NullPointerException("Argument 'cacheDir' of type File (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static CacheDiskUtils getInstance(File cacheDir, long maxSize, int maxCount) {
        Throwable th;
        if (cacheDir != null) {
            String cacheKey = cacheDir.getAbsoluteFile() + "_" + maxSize + "_" + maxCount;
            Map<String, CacheDiskUtils> map = CACHE_MAP;
            CacheDiskUtils cache = map.get(cacheKey);
            if (cache == null) {
                synchronized (CacheDiskUtils.class) {
                    try {
                        CacheDiskUtils cache2 = map.get(cacheKey);
                        if (cache2 == null) {
                            try {
                                cache = new CacheDiskUtils(cacheKey, cacheDir, maxSize, maxCount);
                                map.put(cacheKey, cache);
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        } else {
                            cache = cache2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
            }
            return cache;
        }
        throw new NullPointerException("Argument 'cacheDir' of type File (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private CacheDiskUtils(String cacheKey, File cacheDir, long maxSize, int maxCount) {
        this.mCacheKey = cacheKey;
        this.mCacheDir = cacheDir;
        this.mMaxSize = maxSize;
        this.mMaxCount = maxCount;
    }

    private DiskCacheManager getDiskCacheManager() {
        if (this.mCacheDir.exists()) {
            if (this.mDiskCacheManager == null) {
                this.mDiskCacheManager = new DiskCacheManager(this.mCacheDir, this.mMaxSize, this.mMaxCount);
            }
        } else if (this.mCacheDir.mkdirs()) {
            this.mDiskCacheManager = new DiskCacheManager(this.mCacheDir, this.mMaxSize, this.mMaxCount);
        } else {
            Log.e("CacheDiskUtils", "can't make dirs in " + this.mCacheDir.getAbsolutePath());
        }
        return this.mDiskCacheManager;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }

    public void put(String key, byte[] value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, byte[] value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_BYTE + key, value, saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private void realPutBytes(String key, byte[] value, int saveTime) {
        DiskCacheManager diskCacheManager;
        if (value != null && (diskCacheManager = getDiskCacheManager()) != null) {
            if (saveTime >= 0) {
                value = DiskCacheHelper.newByteArrayWithTime(saveTime, value);
            }
            File file = diskCacheManager.getFileBeforePut(key);
            UtilsBridge.writeFileFromBytes(file, value);
            diskCacheManager.updateModify(file);
            diskCacheManager.put(file);
        }
    }

    public byte[] getBytes(String key) {
        if (key != null) {
            return getBytes(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public byte[] getBytes(String key, byte[] defaultValue) {
        if (key != null) {
            return realGetBytes(TYPE_BYTE + key, defaultValue);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private byte[] realGetBytes(String key) {
        if (key != null) {
            return realGetBytes(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private byte[] realGetBytes(String key, byte[] defaultValue) {
        File file;
        if (key != null) {
            DiskCacheManager diskCacheManager = getDiskCacheManager();
            if (diskCacheManager == null || (file = diskCacheManager.getFileIfExists(key)) == null) {
                return defaultValue;
            }
            byte[] data = UtilsBridge.readFile2Bytes(file);
            if (DiskCacheHelper.isDue(data)) {
                diskCacheManager.removeByKey(key);
                return defaultValue;
            }
            diskCacheManager.updateModify(file);
            return DiskCacheHelper.getDataWithoutDueTime(data);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, String value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, String value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_STRING + key, UtilsBridge.string2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public String getString(String key) {
        if (key != null) {
            return getString(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public String getString(String key, String defaultValue) {
        if (key != null) {
            byte[] bytes = realGetBytes(TYPE_STRING + key);
            if (bytes == null) {
                return defaultValue;
            }
            return UtilsBridge.bytes2String(bytes);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, JSONObject value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, JSONObject value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_JSON_OBJECT + key, UtilsBridge.jsonObject2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public JSONObject getJSONObject(String key) {
        if (key != null) {
            return getJSONObject(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public JSONObject getJSONObject(String key, JSONObject defaultValue) {
        if (key != null) {
            byte[] bytes = realGetBytes(TYPE_JSON_OBJECT + key);
            if (bytes == null) {
                return defaultValue;
            }
            return UtilsBridge.bytes2JSONObject(bytes);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, JSONArray value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, JSONArray value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_JSON_ARRAY + key, UtilsBridge.jsonArray2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public JSONArray getJSONArray(String key) {
        if (key != null) {
            return getJSONArray(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public JSONArray getJSONArray(String key, JSONArray defaultValue) {
        if (key != null) {
            byte[] bytes = realGetBytes(TYPE_JSON_ARRAY + key);
            if (bytes == null) {
                return defaultValue;
            }
            return UtilsBridge.bytes2JSONArray(bytes);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Bitmap value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Bitmap value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_BITMAP + key, UtilsBridge.bitmap2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public Bitmap getBitmap(String key) {
        if (key != null) {
            return getBitmap(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public Bitmap getBitmap(String key, Bitmap defaultValue) {
        if (key != null) {
            byte[] bytes = realGetBytes(TYPE_BITMAP + key);
            if (bytes == null) {
                return defaultValue;
            }
            return UtilsBridge.bytes2Bitmap(bytes);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Drawable value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Drawable value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_DRAWABLE + key, UtilsBridge.drawable2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public Drawable getDrawable(String key) {
        if (key != null) {
            return getDrawable(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public Drawable getDrawable(String key, Drawable defaultValue) {
        if (key != null) {
            byte[] bytes = realGetBytes(TYPE_DRAWABLE + key);
            if (bytes == null) {
                return defaultValue;
            }
            return UtilsBridge.bytes2Drawable(bytes);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Parcelable value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Parcelable value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_PARCELABLE + key, UtilsBridge.parcelable2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public <T> T getParcelable(String key, Parcelable.Creator<T> creator) {
        if (key == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (creator != null) {
            return (T) getParcelable(key, creator, null);
        } else {
            throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public <T> T getParcelable(String key, Parcelable.Creator<T> creator, T defaultValue) {
        if (key == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (creator != null) {
            byte[] bytes = realGetBytes(TYPE_PARCELABLE + key);
            return bytes == null ? defaultValue : (T) UtilsBridge.bytes2Parcelable(bytes, creator);
        } else {
            throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public void put(String key, Serializable value) {
        if (key != null) {
            put(key, value, -1);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void put(String key, Serializable value, int saveTime) {
        if (key != null) {
            realPutBytes(TYPE_SERIALIZABLE + key, UtilsBridge.serializable2Bytes(value), saveTime);
            return;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public Object getSerializable(String key) {
        if (key != null) {
            return getSerializable(key, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public Object getSerializable(String key, Object defaultValue) {
        if (key != null) {
            byte[] bytes = realGetBytes(TYPE_SERIALIZABLE + key);
            if (bytes == null) {
                return defaultValue;
            }
            return UtilsBridge.bytes2Object(bytes);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public long getCacheSize() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return 0;
        }
        return diskCacheManager.getCacheSize();
    }

    public int getCacheCount() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return 0;
        }
        return diskCacheManager.getCacheCount();
    }

    public boolean remove(String key) {
        if (key != null) {
            DiskCacheManager diskCacheManager = getDiskCacheManager();
            if (diskCacheManager == null) {
                return true;
            }
            if (!diskCacheManager.removeByKey(TYPE_BYTE + key) || !diskCacheManager.removeByKey(TYPE_STRING + key) || !diskCacheManager.removeByKey(TYPE_JSON_OBJECT + key) || !diskCacheManager.removeByKey(TYPE_JSON_ARRAY + key) || !diskCacheManager.removeByKey(TYPE_BITMAP + key) || !diskCacheManager.removeByKey(TYPE_DRAWABLE + key) || !diskCacheManager.removeByKey(TYPE_PARCELABLE + key) || !diskCacheManager.removeByKey(TYPE_SERIALIZABLE + key)) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public boolean clear() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return true;
        }
        return diskCacheManager.clear();
    }

    /* access modifiers changed from: private */
    public static final class DiskCacheManager {
        private final AtomicInteger cacheCount;
        private final File cacheDir;
        private final AtomicLong cacheSize;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates;
        private final Thread mThread;
        private final long sizeLimit;

        private DiskCacheManager(final File cacheDir2, long sizeLimit2, int countLimit2) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = cacheDir2;
            this.sizeLimit = sizeLimit2;
            this.countLimit = countLimit2;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            Thread thread = new Thread(new Runnable() {
                /* class com.blankj.utilcode.util.CacheDiskUtils.DiskCacheManager.AnonymousClass1 */

                public void run() {
                    int size = 0;
                    int count = 0;
                    File[] cachedFiles = cacheDir2.listFiles(new FilenameFilter() {
                        /* class com.blankj.utilcode.util.CacheDiskUtils.DiskCacheManager.AnonymousClass1.AnonymousClass1 */

                        public boolean accept(File dir, String name) {
                            return name.startsWith(CacheDiskUtils.CACHE_PREFIX);
                        }
                    });
                    if (cachedFiles != null) {
                        for (File cachedFile : cachedFiles) {
                            size = (int) (((long) size) + cachedFile.length());
                            count++;
                            DiskCacheManager.this.lastUsageDates.put(cachedFile, Long.valueOf(cachedFile.lastModified()));
                        }
                        DiskCacheManager.this.cacheSize.getAndAdd((long) size);
                        DiskCacheManager.this.cacheCount.getAndAdd(count);
                    }
                }
            });
            this.mThread = thread;
            thread.start();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long getCacheSize() {
            wait2InitOk();
            return this.cacheSize.get();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private int getCacheCount() {
            wait2InitOk();
            return this.cacheCount.get();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private File getFileBeforePut(String key) {
            wait2InitOk();
            File file = new File(this.cacheDir, getCacheNameByKey(key));
            if (file.exists()) {
                this.cacheCount.addAndGet(-1);
                this.cacheSize.addAndGet(-file.length());
            }
            return file;
        }

        private void wait2InitOk() {
            try {
                this.mThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private File getFileIfExists(String key) {
            File file = new File(this.cacheDir, getCacheNameByKey(key));
            if (!file.exists()) {
                return null;
            }
            return file;
        }

        private String getCacheNameByKey(String key) {
            return CacheDiskUtils.CACHE_PREFIX + key.substring(0, 3) + key.substring(3).hashCode();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void put(File file) {
            this.cacheCount.addAndGet(1);
            this.cacheSize.addAndGet(file.length());
            while (true) {
                if (this.cacheCount.get() > this.countLimit || this.cacheSize.get() > this.sizeLimit) {
                    this.cacheSize.addAndGet(-removeOldest());
                    this.cacheCount.addAndGet(-1);
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void updateModify(File file) {
            Long millis = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(millis.longValue());
            this.lastUsageDates.put(file, millis);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean removeByKey(String key) {
            File file = getFileIfExists(key);
            if (file == null) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            this.cacheSize.addAndGet(-file.length());
            this.cacheCount.addAndGet(-1);
            this.lastUsageDates.remove(file);
            return true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean clear() {
            File[] files = this.cacheDir.listFiles(new FilenameFilter() {
                /* class com.blankj.utilcode.util.CacheDiskUtils.DiskCacheManager.AnonymousClass2 */

                public boolean accept(File dir, String name) {
                    return name.startsWith(CacheDiskUtils.CACHE_PREFIX);
                }
            });
            if (files == null || files.length <= 0) {
                return true;
            }
            boolean flag = true;
            for (File file : files) {
                if (!file.delete()) {
                    flag = false;
                } else {
                    this.cacheSize.addAndGet(-file.length());
                    this.cacheCount.addAndGet(-1);
                    this.lastUsageDates.remove(file);
                }
            }
            if (flag) {
                this.lastUsageDates.clear();
                this.cacheSize.set(0);
                this.cacheCount.set(0);
            }
            return flag;
        }

        private long removeOldest() {
            if (this.lastUsageDates.isEmpty()) {
                return 0;
            }
            Long oldestUsage = Long.MAX_VALUE;
            File oldestFile = null;
            Set<Map.Entry<File, Long>> entries = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                for (Map.Entry<File, Long> entry : entries) {
                    Long lastValueUsage = entry.getValue();
                    if (lastValueUsage.longValue() < oldestUsage.longValue()) {
                        oldestUsage = lastValueUsage;
                        oldestFile = entry.getKey();
                    }
                }
            }
            if (oldestFile == null) {
                return 0;
            }
            long fileSize = oldestFile.length();
            if (!oldestFile.delete()) {
                return 0;
            }
            this.lastUsageDates.remove(oldestFile);
            return fileSize;
        }
    }

    /* access modifiers changed from: private */
    public static final class DiskCacheHelper {
        static final int TIME_INFO_LEN = 14;

        private DiskCacheHelper() {
        }

        /* access modifiers changed from: private */
        public static byte[] newByteArrayWithTime(int second, byte[] data) {
            byte[] time = createDueTime(second).getBytes();
            byte[] content = new byte[(time.length + data.length)];
            System.arraycopy(time, 0, content, 0, time.length);
            System.arraycopy(data, 0, content, time.length, data.length);
            return content;
        }

        private static String createDueTime(int seconds) {
            return String.format(Locale.getDefault(), "_$%010d$_", Long.valueOf((System.currentTimeMillis() / 1000) + ((long) seconds)));
        }

        /* access modifiers changed from: private */
        public static boolean isDue(byte[] data) {
            long millis = getDueTime(data);
            return millis != -1 && System.currentTimeMillis() > millis;
        }

        private static long getDueTime(byte[] data) {
            if (!hasTimeInfo(data)) {
                return -1;
            }
            try {
                return Long.parseLong(new String(copyOfRange(data, 2, 12))) * 1000;
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        /* access modifiers changed from: private */
        public static byte[] getDataWithoutDueTime(byte[] data) {
            if (hasTimeInfo(data)) {
                return copyOfRange(data, 14, data.length);
            }
            return data;
        }

        private static byte[] copyOfRange(byte[] original, int from, int to) {
            int newLength = to - from;
            if (newLength >= 0) {
                byte[] copy = new byte[newLength];
                System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
                return copy;
            }
            throw new IllegalArgumentException(from + " > " + to);
        }

        private static boolean hasTimeInfo(byte[] data) {
            return data != null && data.length >= 14 && data[0] == 95 && data[1] == 36 && data[12] == 36 && data[13] == 95;
        }
    }
}