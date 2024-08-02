package com.bumptech.glide.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int hashCode;

    @Override // android.support.v4.util.SimpleArrayMap
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public V setValueAt(int index, V value) {
        this.hashCode = 0;
        return (V) super.setValueAt(index, value);
    }

    @Override // android.support.v4.util.SimpleArrayMap, java.util.Map
    public V put(K key, V value) {
        this.hashCode = 0;
        return (V) super.put(key, value);
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.hashCode = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public V removeAt(int index) {
        this.hashCode = 0;
        return (V) super.removeAt(index);
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }
}