package com.wits.ksw.generated.callback;

import android.view.View;

public final class OnLongClickListener implements View.OnLongClickListener {
    final Listener mListener;
    final int mSourceId;

    public interface Listener {
        boolean _internalCallbackOnLongClick(int i, View view);
    }

    public OnLongClickListener(Listener listener, int sourceId) {
        this.mListener = listener;
        this.mSourceId = sourceId;
    }

    public boolean onLongClick(View callbackArg_0) {
        return this.mListener._internalCallbackOnLongClick(this.mSourceId, callbackArg_0);
    }
}
