package skin.support.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import skin.support.R;
import skin.support.content.res.SkinCompatResources;

public class SkinCompatSpinner extends AppCompatSpinner implements SkinCompatSupportable {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {16843505};
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = SkinCompatSpinner.class.getSimpleName();
    private SkinCompatBackgroundHelper mBackgroundTintHelper;
    private int mPopupBackgroundResId;

    public SkinCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public SkinCompatSpinner(Context context, int mode) {
        this(context, null, R.attr.spinnerStyle, mode);
    }

    public SkinCompatSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.spinnerStyle);
    }

    public SkinCompatSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public SkinCompatSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        this(context, attrs, defStyleAttr, mode, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r2 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        r2.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (0 == 0) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SkinCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: skin.support.widget.SkinCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.support.v7.widget.AppCompatSpinner
    public void setPopupBackgroundResource(int resId) {
        super.setPopupBackgroundResource(resId);
        this.mPopupBackgroundResId = resId;
        applyPopupBackground();
    }

    private void applyPopupBackground() {
        int checkResourceId = SkinCompatHelper.checkResourceId(this.mPopupBackgroundResId);
        this.mPopupBackgroundResId = checkResourceId;
        if (checkResourceId != 0) {
            setPopupBackgroundDrawable(SkinCompatResources.getDrawableCompat(getContext(), this.mPopupBackgroundResId));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.applySkin();
        }
        applyPopupBackground();
    }
}
