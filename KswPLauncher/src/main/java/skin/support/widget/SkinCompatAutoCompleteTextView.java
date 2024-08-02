package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import skin.support.R;
import skin.support.content.res.SkinCompatResources;

public class SkinCompatAutoCompleteTextView extends AppCompatAutoCompleteTextView implements SkinCompatSupportable {
    private static final int[] TINT_ATTRS = {16843126};
    private SkinCompatBackgroundHelper mBackgroundTintHelper;
    private int mDropDownBackgroundResId;
    private SkinCompatTextHelper mTextHelper;

    public SkinCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.autoCompleteTextViewStyle);
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mDropDownBackgroundResId = 0;
        TypedArray a = context.obtainStyledAttributes(attrs, TINT_ATTRS, defStyleAttr, 0);
        if (a.hasValue(0)) {
            this.mDropDownBackgroundResId = a.getResourceId(0, 0);
        }
        a.recycle();
        applyDropDownBackgroundResource();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.loadFromAttributes(attrs, defStyleAttr);
        SkinCompatTextHelper create = SkinCompatTextHelper.create(this);
        this.mTextHelper = create;
        create.loadFromAttributes(attrs, defStyleAttr);
    }

    @Override // android.support.v7.widget.AppCompatAutoCompleteTextView
    public void setDropDownBackgroundResource(int resId) {
        super.setDropDownBackgroundResource(resId);
        this.mDropDownBackgroundResId = resId;
        applyDropDownBackgroundResource();
    }

    private void applyDropDownBackgroundResource() {
        Drawable drawable;
        int checkResourceId = SkinCompatHelper.checkResourceId(this.mDropDownBackgroundResId);
        this.mDropDownBackgroundResId = checkResourceId;
        if (checkResourceId != 0 && (drawable = SkinCompatResources.getDrawableCompat(getContext(), this.mDropDownBackgroundResId)) != null) {
            setDropDownBackgroundDrawable(drawable);
        }
    }

    @Override // android.support.v7.widget.AppCompatAutoCompleteTextView
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

    @Override // android.support.v7.widget.AppCompatAutoCompleteTextView
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
        applyDropDownBackgroundResource();
    }
}
