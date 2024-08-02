package com.squareup.picasso;

import android.graphics.Bitmap;
import com.squareup.picasso.Picasso;

/* access modifiers changed from: package-private */
public class FetchAction extends Action<Object> {
    private Callback callback;
    private final Object target = new Object();

    FetchAction(Picasso picasso, Request data, int memoryPolicy, int networkPolicy, Object tag, String key, Callback callback2) {
        super(picasso, null, data, memoryPolicy, networkPolicy, 0, null, key, tag, false);
        this.callback = callback2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    public void complete(Bitmap result, Picasso.LoadedFrom from) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSuccess();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    public void error() {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onError();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    public void cancel() {
        super.cancel();
        this.callback = null;
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    public Object getTarget() {
        return this.target;
    }
}
