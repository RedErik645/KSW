package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    public boolean handles(Bitmap source, Options options) {
        return true;
    }

    public Resource<Bitmap> decode(Bitmap source, int width, int height, Options options) {
        return new NonOwnedBitmapResource(source);
    }

    /* access modifiers changed from: private */
    public static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap bitmap;

        NonOwnedBitmapResource(Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Bitmap get() {
            return this.bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.getBitmapByteSize(this.bitmap);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }
    }
}
