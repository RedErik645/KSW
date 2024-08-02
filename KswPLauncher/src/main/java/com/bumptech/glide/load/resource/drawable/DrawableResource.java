package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T drawable;

    public DrawableResource(T drawable2) {
        this.drawable = (T) ((Drawable) Preconditions.checkNotNull(drawable2));
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T get() {
        Drawable.ConstantState state = this.drawable.getConstantState();
        return state == null ? this.drawable : (T) state.newDrawable();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        T t = this.drawable;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).getFirstFrame().prepareToDraw();
        }
    }
}
