package com.wits.ksw.launcher.view.benzmbux2021new.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class BenzCardMenu<T> implements MultiItemEntity {
    public static final int TYPE_LOCAL = 1;
    public static final int TYPE_THIRD = 2;
    private T benzCardItem;
    private int type;

    public BenzCardMenu(int type2, T item) {
        this.type = type2;
        this.benzCardItem = item;
    }

    public void setBenzCardItem(T benzCardItem2) {
        this.benzCardItem = benzCardItem2;
    }

    public T getBenzCardItem() {
        return this.benzCardItem;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public String toString() {
        return "BenzCardMenu{type=" + this.type + ", benzCardItem=" + ((Object) this.benzCardItem) + '}';
    }
}
