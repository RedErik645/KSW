package skin.support.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class SkinCompatButton extends AppCompatButton implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper mBackgroundTintHelper;
    private SkinCompatTextHelper mTextHelper;

    public SkinCompatButton(Context context) {
        this(context, null);
    }

    public SkinCompatButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);
    }

    public SkinCompatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.loadFromAttributes(attrs, defStyleAttr);
        SkinCompatTextHelper create = SkinCompatTextHelper.create(this);
        this.mTextHelper = create;
        create.loadFromAttributes(attrs, defStyleAttr);
    }

    @Override // android.support.v7.widget.AppCompatButton
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.onSetBackgroundResource(resId);
        }
    }

    public void setTextAppearance(int resId) {
        setTextAppearance(getContext(), resId);
    }

    @Override // android.support.v7.widget.AppCompatButton
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        SkinCompatTextHelper skinCompatTextHelper = this.mTextHelper;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.onSetTextAppearance(context, resId);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end, int bottom) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        SkinCompatTextHelper skinCompatTextHelper = this.mTextHelper;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.onSetCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        SkinCompatTextHelper skinCompatTextHelper = this.mTextHelper;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.onSetCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.applySkin();
        }
        SkinCompatTextHelper skinCompatTextHelper = this.mTextHelper;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.applySkin();
        }
    }
}