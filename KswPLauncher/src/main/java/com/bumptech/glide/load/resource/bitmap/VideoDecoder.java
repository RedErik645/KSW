package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() {
        /* class com.bumptech.glide.load.resource.bitmap.VideoDecoder.AnonymousClass2 */
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        public void update(byte[] keyBytes, Integer value, MessageDigest messageDigest) {
            if (value != null) {
                messageDigest.update(keyBytes);
                synchronized (this.buffer) {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putInt(value.intValue()).array());
                }
            }
        }
    });
    private static final String TAG = "VideoDecoder";
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() {
        /* class com.bumptech.glide.load.resource.bitmap.VideoDecoder.AnonymousClass1 */
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        public void update(byte[] keyBytes, Long value, MessageDigest messageDigest) {
            messageDigest.update(keyBytes);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(value.longValue()).array());
            }
        }
    });
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaMetadataRetrieverInitializer<T> initializer;

    interface MediaMetadataRetrieverInitializer<T> {
        void initialize(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ParcelFileDescriptorInitializer());
    }

    VideoDecoder(BitmapPool bitmapPool2, MediaMetadataRetrieverInitializer<T> initializer2) {
        this(bitmapPool2, initializer2, DEFAULT_FACTORY);
    }

    VideoDecoder(BitmapPool bitmapPool2, MediaMetadataRetrieverInitializer<T> initializer2, MediaMetadataRetrieverFactory factory2) {
        this.bitmapPool = bitmapPool2;
        this.initializer = initializer2;
        this.factory = factory2;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(T t, Options options) {
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: com.bumptech.glide.load.Options */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(T resource, int outWidth, int outHeight, Options options) throws IOException {
        Integer frameOption;
        DownsampleStrategy downsampleStrategy;
        RuntimeException e;
        RuntimeException e2;
        long frameTimeMicros = ((Long) options.get(TARGET_FRAME)).longValue();
        if (frameTimeMicros >= 0 || frameTimeMicros == -1) {
            Integer frameOption2 = (Integer) options.get(FRAME_OPTION);
            if (frameOption2 == null) {
                frameOption = 2;
            } else {
                frameOption = frameOption2;
            }
            DownsampleStrategy downsampleStrategy2 = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
            if (downsampleStrategy2 == null) {
                downsampleStrategy = DownsampleStrategy.DEFAULT;
            } else {
                downsampleStrategy = downsampleStrategy2;
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.factory.build();
            try {
                try {
                    this.initializer.initialize(mediaMetadataRetriever, resource);
                    Bitmap result = decodeFrame(mediaMetadataRetriever, frameTimeMicros, frameOption.intValue(), outWidth, outHeight, downsampleStrategy);
                    mediaMetadataRetriever.release();
                    return BitmapResource.obtain(result, this.bitmapPool);
                } catch (RuntimeException e3) {
                    e2 = e3;
                    try {
                        throw new IOException(e2);
                    } catch (Throwable th) {
                        e = th;
                        mediaMetadataRetriever.release();
                        throw e;
                    }
                }
            } catch (RuntimeException e4) {
                e2 = e4;
                throw new IOException(e2);
            } catch (Throwable th2) {
                e = th2;
                mediaMetadataRetriever.release();
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + frameTimeMicros);
        }
    }

    private static Bitmap decodeFrame(MediaMetadataRetriever mediaMetadataRetriever, long frameTimeMicros, int frameOption, int outWidth, int outHeight, DownsampleStrategy strategy) {
        Bitmap result = null;
        if (!(Build.VERSION.SDK_INT < 27 || outWidth == Integer.MIN_VALUE || outHeight == Integer.MIN_VALUE || strategy == DownsampleStrategy.NONE)) {
            result = decodeScaledFrame(mediaMetadataRetriever, frameTimeMicros, frameOption, outWidth, outHeight, strategy);
        }
        if (result == null) {
            return decodeOriginalFrame(mediaMetadataRetriever, frameTimeMicros, frameOption);
        }
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeScaledFrame(android.media.MediaMetadataRetriever r14, long r15, int r17, int r18, int r19, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r20) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.decodeScaledFrame(android.media.MediaMetadataRetriever, long, int, int, int, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy):android.graphics.Bitmap");
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long frameTimeMicros, int frameOption) {
        return mediaMetadataRetriever.getFrameAtTime(frameTimeMicros, frameOption);
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    private static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        public void initialize(MediaMetadataRetriever retriever, AssetFileDescriptor data) {
            retriever.setDataSource(data.getFileDescriptor(), data.getStartOffset(), data.getLength());
        }
    }

    static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        public void initialize(MediaMetadataRetriever retriever, ParcelFileDescriptor data) {
            retriever.setDataSource(data.getFileDescriptor());
        }
    }
}
