package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public class Space extends View {
    @Deprecated
    public Space(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    @Deprecated
    public Space(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Deprecated
    public Space(Context context) {
        this(context, null);
    }

    @Deprecated
    public void draw(Canvas canvas) {
    }

    private static int getDefaultSize2(int size, int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case Integer.MIN_VALUE:
                return Math.min(size, specSize);
            case 0:
                return size;
            case 1073741824:
                return specSize;
            default:
                return size;
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize2(getSuggestedMinimumHeight(), heightMeasureSpec));
    }
}
