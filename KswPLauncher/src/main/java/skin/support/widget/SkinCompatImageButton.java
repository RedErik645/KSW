package skin.support.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

public class SkinCompatImageButton extends AppCompatImageButton implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper mBackgroundTintHelper;
    private SkinCompatImageHelper mImageHelper;

    public SkinCompatImageButton(Context context) {
        this(context, null);
    }

    public SkinCompatImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageButtonStyle);
    }

    public SkinCompatImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.loadFromAttributes(attrs, defStyleAttr);
        SkinCompatImageHelper skinCompatImageHelper = new SkinCompatImageHelper(this);
        this.mImageHelper = skinCompatImageHelper;
        skinCompatImageHelper.loadFromAttributes(attrs, defStyleAttr);
    }

    @Override // android.support.v7.widget.AppCompatImageButton
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.onSetBackgroundResource(resId);
        }
    }

    @Override // android.support.v7.widget.AppCompatImageButton
    public void setImageResource(int resId) {
        SkinCompatImageHelper skinCompatImageHelper = this.mImageHelper;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.setImageResource(resId);
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.applySkin();
        }
        SkinCompatImageHelper skinCompatImageHelper = this.mImageHelper;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.applySkin();
        }
    }
}
