package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    public ModelCache() {
        this(250);
    }

    public ModelCache(long size) {
        this.cache = new LruCache<ModelKey<A>, B>(size) {
            /* class com.bumptech.glide.load.model.ModelCache.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.bumptech.glide.util.LruCache
            public /* bridge */ /* synthetic */ void onItemEvicted(Object obj, Object obj2) {
                onItemEvicted((ModelKey) ((ModelKey) obj), obj2);
            }

            /* access modifiers changed from: protected */
            public void onItemEvicted(ModelKey<A> key, B b) {
                key.release();
            }
        };
    }

    public B get(A model, int width, int height) {
        ModelKey<A> key = ModelKey.get(model, width, height);
        B result = this.cache.get(key);
        key.release();
        return result;
    }

    public void put(A model, int width, int height, B value) {
        this.cache.put(ModelKey.get(model, width, height), value);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    /* access modifiers changed from: package-private */
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        static <A> ModelKey<A> get(A model2, int width2, int height2) {
            ModelKey<?> poll;
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new ModelKey();
            }
            poll.init(model2, width2, height2);
            return poll;
        }

        private ModelKey() {
        }

        private void init(A model2, int width2, int height2) {
            this.model = model2;
            this.width = width2;
            this.height = height2;
        }

        public void release() {
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object o) {
            if (!(o instanceof ModelKey)) {
                return false;
            }
            ModelKey<A> other = (ModelKey) o;
            if (this.width == other.width && this.height == other.height && this.model.equals(other.model)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }
    }
}
