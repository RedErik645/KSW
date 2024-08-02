package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isCacheable = true;
    private boolean isLocked;
    private boolean isScaleOnlyOrNoTransform = true;
    private boolean isTransformationAllowed = true;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Options options = new Options();
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority = Priority.NORMAL;
    private Class<?> resourceClass = Object.class;
    private Key signature = EmptySignature.obtain();
    private float sizeMultiplier = 1.0f;
    private Resources.Theme theme;
    private Map<Class<?>, Transformation<?>> transformations = new CachedHashCodeArrayMap();
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    private static boolean isSet(int fields2, int flag) {
        return (fields2 & flag) != 0;
    }

    public T sizeMultiplier(float sizeMultiplier2) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().sizeMultiplier(sizeMultiplier2);
        }
        if (sizeMultiplier2 < 0.0f || sizeMultiplier2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = sizeMultiplier2;
        this.fields |= 2;
        return selfOrThrowIfLocked();
    }

    public T useUnlimitedSourceGeneratorsPool(boolean flag) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().useUnlimitedSourceGeneratorsPool(flag);
        }
        this.useUnlimitedSourceGeneratorsPool = flag;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }

    public T useAnimationPool(boolean flag) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().useAnimationPool(flag);
        }
        this.useAnimationPool = flag;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    public T onlyRetrieveFromCache(boolean flag) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().onlyRetrieveFromCache(flag);
        }
        this.onlyRetrieveFromCache = flag;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    public T diskCacheStrategy(DiskCacheStrategy strategy) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().diskCacheStrategy(strategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(strategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    public T priority(Priority priority2) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().priority(priority2);
        }
        this.priority = (Priority) Preconditions.checkNotNull(priority2);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i = this.fields | 64;
        this.fields = i;
        this.placeholderId = 0;
        this.fields = i & -129;
        return selfOrThrowIfLocked();
    }

    public T placeholder(int resourceId) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().placeholder(resourceId);
        }
        this.placeholderId = resourceId;
        int i = this.fields | 128;
        this.fields = i;
        this.placeholderDrawable = null;
        this.fields = i & -65;
        return selfOrThrowIfLocked();
    }

    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i = this.fields | 8192;
        this.fields = i;
        this.fallbackId = 0;
        this.fields = i & -16385;
        return selfOrThrowIfLocked();
    }

    public T fallback(int resourceId) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().fallback(resourceId);
        }
        this.fallbackId = resourceId;
        int i = this.fields | 16384;
        this.fields = i;
        this.fallbackDrawable = null;
        this.fields = i & -8193;
        return selfOrThrowIfLocked();
    }

    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i = this.fields | 16;
        this.fields = i;
        this.errorId = 0;
        this.fields = i & -33;
        return selfOrThrowIfLocked();
    }

    public T error(int resourceId) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().error(resourceId);
        }
        this.errorId = resourceId;
        int i = this.fields | 32;
        this.fields = i;
        this.errorPlaceholder = null;
        this.fields = i & -17;
        return selfOrThrowIfLocked();
    }

    public T theme(Resources.Theme theme2) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().theme(theme2);
        }
        this.theme = theme2;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    public T skipMemoryCache(boolean skip) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().skipMemoryCache(true);
        }
        this.isCacheable = !skip;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    public T override(int width, int height) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().override(width, height);
        }
        this.overrideWidth = width;
        this.overrideHeight = height;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    public T override(int size) {
        return override(size, size);
    }

    public T signature(Key signature2) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().signature(signature2);
        }
        this.signature = (Key) Preconditions.checkNotNull(signature2);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    @Override // java.lang.Object
    public T clone() {
        try {
            T t = (T) ((BaseRequestOptions) super.clone());
            Options options2 = new Options();
            t.options = options2;
            options2.putAll(this.options);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.transformations = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public <Y> T set(Option<Y> option, Y value) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().set(option, value);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(value);
        this.options.set(option, value);
        return selfOrThrowIfLocked();
    }

    public T decode(Class<?> resourceClass2) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().decode(resourceClass2);
        }
        this.resourceClass = (Class) Preconditions.checkNotNull(resourceClass2);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public T encodeFormat(Bitmap.CompressFormat format) {
        return set((Option<Y>) BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(format));
    }

    public T encodeQuality(int quality) {
        return set((Option<Y>) BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(quality));
    }

    public T frame(long frameTimeMicros) {
        return set((Option<Y>) VideoDecoder.TARGET_FRAME, Long.valueOf(frameTimeMicros));
    }

    public T format(DecodeFormat format) {
        Preconditions.checkNotNull(format);
        return (T) set((Option<Y>) Downsampler.DECODE_FORMAT, format).set(GifOptions.DECODE_FORMAT, format);
    }

    public T disallowHardwareConfig() {
        return set((Option<Y>) Downsampler.ALLOW_HARDWARE_CONFIG, false);
    }

    public T downsample(DownsampleStrategy strategy) {
        return set((Option<Y>) DownsampleStrategy.OPTION, Preconditions.checkNotNull(strategy));
    }

    public T timeout(int timeoutMs) {
        return set((Option<Y>) HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(timeoutMs));
    }

    public T optionalCenterCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T centerCrop() {
        return transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T optionalFitCenter() {
        return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public T fitCenter() {
        return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public T optionalCenterInside() {
        return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T centerInside() {
        return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T optionalCircleCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    public T circleCrop() {
        return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    /* access modifiers changed from: package-private */
    public final T optionalTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    /* access modifiers changed from: package-private */
    public final T transform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    private T scaleOnlyTransform(DownsampleStrategy strategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(strategy, transformation, true);
    }

    private T optionalScaleOnlyTransform(DownsampleStrategy strategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(strategy, transformation, false);
    }

    private T scaleOnlyTransform(DownsampleStrategy strategy, Transformation<Bitmap> transformation, boolean isTransformationRequired2) {
        T transform = isTransformationRequired2 ? transform(strategy, transformation) : optionalTransform(strategy, transformation);
        transform.isScaleOnlyOrNoTransform = true;
        return transform;
    }

    public T transform(Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    public T transform(Transformation<Bitmap>... transformations2) {
        if (transformations2.length > 1) {
            return transform((Transformation<Bitmap>) new MultiTransformation(transformations2), true);
        }
        if (transformations2.length == 1) {
            return transform(transformations2[0]);
        }
        return selfOrThrowIfLocked();
    }

    @Deprecated
    public T transforms(Transformation<Bitmap>... transformations2) {
        return transform((Transformation<Bitmap>) new MultiTransformation(transformations2), true);
    }

    public T optionalTransform(Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bumptech.glide.load.Transformation<android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public T transform(Transformation<Bitmap> transformation, boolean isRequired) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().transform(transformation, isRequired);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, isRequired);
        transform(Bitmap.class, transformation, isRequired);
        transform(Drawable.class, drawableTransformation, isRequired);
        transform(BitmapDrawable.class, (Transformation<Y>) drawableTransformation.asBitmapDrawable(), isRequired);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), isRequired);
        return selfOrThrowIfLocked();
    }

    public <Y> T optionalTransform(Class<Y> resourceClass2, Transformation<Y> transformation) {
        return transform(resourceClass2, transformation, false);
    }

    /* access modifiers changed from: package-private */
    public <Y> T transform(Class<Y> resourceClass2, Transformation<Y> transformation, boolean isRequired) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().transform(resourceClass2, transformation, isRequired);
        }
        Preconditions.checkNotNull(resourceClass2);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(resourceClass2, transformation);
        int i = this.fields | 2048;
        this.fields = i;
        this.isTransformationAllowed = true;
        int i2 = i | 65536;
        this.fields = i2;
        this.isScaleOnlyOrNoTransform = false;
        if (isRequired) {
            this.fields = i2 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    public <Y> T transform(Class<Y> resourceClass2, Transformation<Y> transformation) {
        return transform(resourceClass2, transformation, true);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) clone().dontTransform();
        }
        this.transformations.clear();
        int i = this.fields & -2049;
        this.fields = i;
        this.isTransformationRequired = false;
        int i2 = i & -131073;
        this.fields = i2;
        this.isTransformationAllowed = false;
        this.fields = i2 | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    public T dontAnimate() {
        return set((Option<Y>) GifOptions.DISABLE_ANIMATION, true);
    }

    public T apply(BaseRequestOptions<?> o) {
        if (this.isAutoCloneEnabled) {
            return (T) clone().apply(o);
        }
        if (isSet(o.fields, 2)) {
            this.sizeMultiplier = o.sizeMultiplier;
        }
        if (isSet(o.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = o.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(o.fields, 1048576)) {
            this.useAnimationPool = o.useAnimationPool;
        }
        if (isSet(o.fields, 4)) {
            this.diskCacheStrategy = o.diskCacheStrategy;
        }
        if (isSet(o.fields, 8)) {
            this.priority = o.priority;
        }
        if (isSet(o.fields, 16)) {
            this.errorPlaceholder = o.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(o.fields, 32)) {
            this.errorId = o.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(o.fields, 64)) {
            this.placeholderDrawable = o.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(o.fields, 128)) {
            this.placeholderId = o.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(o.fields, 256)) {
            this.isCacheable = o.isCacheable;
        }
        if (isSet(o.fields, 512)) {
            this.overrideWidth = o.overrideWidth;
            this.overrideHeight = o.overrideHeight;
        }
        if (isSet(o.fields, 1024)) {
            this.signature = o.signature;
        }
        if (isSet(o.fields, 4096)) {
            this.resourceClass = o.resourceClass;
        }
        if (isSet(o.fields, 8192)) {
            this.fallbackDrawable = o.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(o.fields, 16384)) {
            this.fallbackId = o.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(o.fields, 32768)) {
            this.theme = o.theme;
        }
        if (isSet(o.fields, 65536)) {
            this.isTransformationAllowed = o.isTransformationAllowed;
        }
        if (isSet(o.fields, 131072)) {
            this.isTransformationRequired = o.isTransformationRequired;
        }
        if (isSet(o.fields, 2048)) {
            this.transformations.putAll(o.transformations);
            this.isScaleOnlyOrNoTransform = o.isScaleOnlyOrNoTransform;
        }
        if (isSet(o.fields, 524288)) {
            this.onlyRetrieveFromCache = o.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i = this.fields & -2049;
            this.fields = i;
            this.isTransformationRequired = false;
            this.fields = i & -131073;
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= o.fields;
        this.options.putAll(o.options);
        return selfOrThrowIfLocked();
    }

    public boolean equals(Object o) {
        if (!(o instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions<?> other = (BaseRequestOptions) o;
        if (Float.compare(other.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == other.errorId && Util.bothNullOrEqual(this.errorPlaceholder, other.errorPlaceholder) && this.placeholderId == other.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, other.placeholderDrawable) && this.fallbackId == other.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, other.fallbackDrawable) && this.isCacheable == other.isCacheable && this.overrideHeight == other.overrideHeight && this.overrideWidth == other.overrideWidth && this.isTransformationRequired == other.isTransformationRequired && this.isTransformationAllowed == other.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == other.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == other.onlyRetrieveFromCache && this.diskCacheStrategy.equals(other.diskCacheStrategy) && this.priority == other.priority && this.options.equals(other.options) && this.transformations.equals(other.transformations) && this.resourceClass.equals(other.resourceClass) && Util.bothNullOrEqual(this.signature, other.signature) && Util.bothNullOrEqual(this.theme, other.theme)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    public T lock() {
        this.isLocked = true;
        return self();
    }

    public T autoClone() {
        if (!this.isLocked || this.isAutoCloneEnabled) {
            this.isAutoCloneEnabled = true;
            return lock();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    private T selfOrThrowIfLocked() {
        if (!this.isLocked) {
            return self();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    /* access modifiers changed from: protected */
    public boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    /* access modifiers changed from: package-private */
    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    private boolean isSet(int flag) {
        return isSet(this.fields, flag);
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    private T self() {
        return this;
    }
}
