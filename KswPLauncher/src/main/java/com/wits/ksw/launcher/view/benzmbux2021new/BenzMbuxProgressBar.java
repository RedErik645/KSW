package com.wits.ksw.launcher.view.benzmbux2021new;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;

public class BenzMbuxProgressBar extends View {
    private static final String TAG = "BenzMbuxProgressBar";
    private Bitmap bgBitmap;
    private Paint bgPatin;
    public ContentObserver contentObserver;
    private Rect dstRect;
    private int height;
    private OnTouchChangeListener mTouchChangeListener;
    private OnValueChangeListener mValueChangeListener;
    private int max;
    private int offsetX;
    private float progress;
    private Bitmap progressAngeBitmap;
    private Bitmap progressAngeBitmapBlue;
    private Bitmap progressAngeBitmapRed;
    private Bitmap progressAngeBitmapYellow;
    private Bitmap progressBitmap;
    private Bitmap progressBitmapBlue;
    private Bitmap progressBitmapRed;
    private Bitmap progressBitmapYellow;
    private Rect srcRect;
    private Bitmap thumbBitmap;
    private int value;
    private int width;

    public interface OnTouchChangeListener {
        void onStartTrackingTouch(BenzMbuxProgressBar benzMbuxProgressBar);

        void onStopTrackingTouch(BenzMbuxProgressBar benzMbuxProgressBar);
    }

    public interface OnValueChangeListener {
        void onValueChange(BenzMbuxProgressBar benzMbuxProgressBar, int i, float f);
    }

    public BenzMbuxProgressBar(Context context) {
        this(context, null);
    }

    public BenzMbuxProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BenzMbuxProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.contentObserver = new ContentObserver(new Handler()) {
            /* class com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.AnonymousClass1 */

            public void onChange(boolean selfChange, Uri uri) {
                Log.d(BenzMbuxProgressBar.TAG, "onChange: 11111111111");
                BenzMbuxProgressBar.this.configSkinResources();
                BenzMbuxProgressBar.this.invalidate();
            }
        };
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BenzMbuxProgressBar);
        this.max = typedArray.getInt(0, 100);
        this.value = typedArray.getInt(1, 80);
        this.thumbBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg_thumb);
        this.bgBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_bg);
        this.progressBitmapYellow = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg);
        this.progressAngeBitmapYellow = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg_thumb);
        this.progressBitmapBlue = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg);
        this.progressAngeBitmapBlue = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg_thumb);
        this.progressBitmapRed = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg);
        this.progressAngeBitmapRed = BitmapFactory.decodeResource(context.getResources(), R.drawable.mbux_settings_icon_bar_pg_thumb);
        configSkinResources();
        this.offsetX = this.thumbBitmap.getWidth();
        this.srcRect = new Rect(0, 0, this.progressBitmap.getWidth(), this.progressBitmap.getHeight());
        Paint paint = new Paint();
        this.bgPatin = paint;
        paint.setAntiAlias(true);
        setValue(this.value);
        registerSkinObserver(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void configSkinResources() {
        String skinName = ID8LauncherConstants.loadCurrentSkin();
        Log.w(TAG, "ID8ProgressBar: " + skinName);
        if (ID8LauncherConstants.ID8_SKIN_SPORT.equals(skinName)) {
            this.progressBitmap = this.progressBitmapRed;
            this.progressAngeBitmap = this.progressAngeBitmapRed;
        } else if ("blue".equals(skinName)) {
            this.progressBitmap = this.progressBitmapBlue;
            this.progressAngeBitmap = this.progressAngeBitmapBlue;
        } else {
            this.progressBitmap = this.progressBitmapYellow;
            this.progressAngeBitmap = this.progressAngeBitmapYellow;
        }
    }

    private void registerSkinObserver(Context context) {
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor(ID8LauncherConstants.ID8_SKIN), true, this.contentObserver);
    }

    public void setMax(int max2) {
        this.max = max2;
        invalidate();
    }

    public void setValue(int i) {
        if (i <= this.max && i >= 0) {
            this.value = i;
            setProgressBySet(i);
        }
    }

    private void setProgressBySet(int value2) {
        float percent = ((float) value2) / ((float) this.max);
        if (percent < 0.0f) {
            percent = 0.0f;
        }
        if (percent > 1.0f) {
            percent = 1.0f;
        }
        this.progress = percent;
        OnValueChangeListener onValueChangeListener = this.mValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, value2, percent);
        }
        invalidate();
    }

    private void setProgressByDrag(float x) {
        float percent = x / ((float) (this.width - this.offsetX));
        if (percent < 0.0f) {
            percent = 0.0f;
        }
        if (percent > 1.0f) {
            percent = 1.0f;
        }
        int i = this.max;
        int i2 = (int) (((float) i) * percent);
        this.value = i2;
        float percent2 = ((float) i2) / ((float) i);
        this.progress = percent2;
        OnValueChangeListener onValueChangeListener = this.mValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, i2, percent2);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = this.bgBitmap.getWidth();
        int height2 = this.bgBitmap.getHeight();
        this.height = height2;
        setMeasuredDimension(this.width, height2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.bgBitmap, 0.0f, 0.0f, this.bgPatin);
        float f = this.progress;
        int currentPosition = (int) (((float) (this.width - this.offsetX)) * f);
        if (f == 0.0f) {
            canvas.drawBitmap(this.thumbBitmap, 0.0f, 0.0f, this.bgPatin);
            return;
        }
        Rect rect = new Rect(0, 0, currentPosition, this.height);
        this.dstRect = rect;
        canvas.drawBitmap(this.progressBitmap, this.srcRect, rect, this.bgPatin);
        if (this.progress != 0.0f) {
            canvas.drawBitmap(this.progressAngeBitmap, (float) (currentPosition - 3), 0.0f, this.bgPatin);
        }
        canvas.drawBitmap(this.thumbBitmap, (float) currentPosition, 0.0f, this.bgPatin);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float x;
        OnTouchChangeListener onTouchChangeListener;
        if (event.getAction() == 0 && (onTouchChangeListener = this.mTouchChangeListener) != null) {
            onTouchChangeListener.onStartTrackingTouch(this);
        }
        float x2 = event.getX();
        if (x2 < 0.0f) {
            return true;
        }
        int i = this.offsetX;
        if (x2 < ((float) i)) {
            x = 0.0f;
        } else {
            x = x2 - ((float) i);
        }
        Log.w(TAG, "onTouchEvent: x : " + x);
        setProgressByDrag(x);
        return true;
    }

    public boolean isClickable() {
        return true;
    }

    public boolean hasFocusable() {
        return true;
    }

    public void setOnValueChangeListener(OnValueChangeListener listener) {
        this.mValueChangeListener = listener;
    }

    public void setOnTouchChangeListener(OnTouchChangeListener listener) {
        this.mTouchChangeListener = listener;
    }

    public int getValue() {
        return this.value;
    }
}
