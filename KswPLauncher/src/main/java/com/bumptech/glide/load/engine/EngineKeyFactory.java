package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* access modifiers changed from: package-private */
public class EngineKeyFactory {
    EngineKeyFactory() {
    }

    /* access modifiers changed from: package-private */
    public EngineKey buildKey(Object model, Key signature, int width, int height, Map<Class<?>, Transformation<?>> transformations, Class<?> resourceClass, Class<?> transcodeClass, Options options) {
        return new EngineKey(model, signature, width, height, transformations, resourceClass, transcodeClass, options);
    }
}