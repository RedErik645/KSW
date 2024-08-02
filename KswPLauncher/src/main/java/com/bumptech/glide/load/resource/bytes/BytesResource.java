package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bytes2) {
        this.bytes = (byte[]) Preconditions.checkNotNull(bytes2);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public byte[] get() {
        return this.bytes;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
