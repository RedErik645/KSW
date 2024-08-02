package com.wits.ksw.launcher.bmw_id8_ui.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecycleHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews = new SparseArray<>();

    public RecycleHolder(View itemView) {
        super(itemView);
    }

    public <T extends View> T findView(int ViewId) {
        T t = (T) this.mViews.get(ViewId);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(ViewId);
        this.mViews.put(ViewId, t2);
        return t2;
    }

    public RecycleHolder setText(int viewId, String text) {
        ((TextView) findView(viewId)).setText(text);
        return this;
    }

    public RecycleHolder setText(int viewId, int text) {
        ((TextView) findView(viewId)).setText(text);
        return this;
    }

    public RecycleHolder setImageResource(int viewId, int ImageId) {
        ((ImageView) findView(viewId)).setImageResource(ImageId);
        return this;
    }

    public RecycleHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ((ImageView) findView(viewId)).setImageBitmap(bitmap);
        return this;
    }
}
