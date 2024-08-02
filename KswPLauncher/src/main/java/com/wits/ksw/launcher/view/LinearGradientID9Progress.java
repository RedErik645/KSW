package com.wits.ksw.launcher.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.BitmapUtil;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import skin.support.content.res.SkinCompatResources;
import skin.support.widget.SkinCompatSupportable;

public class LinearGradientID9Progress extends View implements SkinCompatSupportable {
    private static final String TAG = LinearGradientProgress.class.getSimpleName();
    private int[] colorArray;
    private final int colorArrayLength = 5;
    private float[] colorPosition;
    private LinearGradient linearGradient;
    private boolean linearVisible;
    private int mHeight;
    private int mOrientation;
    private int mScale = 0;
    private int mWidth;
    private Bitmap maskBitmap = null;
    private Drawable maskDrawable;
    private boolean maskVisible;
    private int maxScale = 100;
    private Paint paint;
    private Bitmap rulerBitmap = null;
    private Drawable rulerDrawable;
    private boolean rulerVisible;
    private Bitmap scaleBitmap = null;
    private Drawable scaleDrawable;
    private boolean scaleVisible;
    private TypedArray typedArray;

    public LinearGradientID9Progress(Context context) {
        super(context);
        Log.i(TAG, "init context");
        initView();
    }

    public LinearGradientID9Progress(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "init context attrs");
        initConfig(context, attrs);
        initView();
    }

    public LinearGradientID9Progress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, "init context attrs defStyleAttr");
        initConfig(context, attrs);
        initView();
    }

    private void initConfig(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Linear_Gradient_Progress);
        this.typedArray = obtainStyledAttributes;
        this.linearVisible = obtainStyledAttributes.getBoolean(0, true);
        this.rulerVisible = this.typedArray.getBoolean(6, false);
        this.maskVisible = this.typedArray.getBoolean(2, false);
        this.scaleVisible = this.typedArray.getBoolean(9, false);
        this.maxScale = this.typedArray.getInteger(3, 100);
        this.mScale = this.typedArray.getInteger(7, 0);
        this.mOrientation = this.typedArray.getInt(4, 0);
        this.rulerDrawable = this.typedArray.getDrawable(5);
        this.maskDrawable = this.typedArray.getDrawable(1);
        this.scaleDrawable = this.typedArray.getDrawable(8);
        if (SkinCompatResources.getInstance() != null) {
            this.rulerDrawable = SkinCompatResources.getInstance().getDrawable(this.typedArray.getResourceId(5, 5));
            this.maskDrawable = SkinCompatResources.getInstance().getDrawable(this.typedArray.getResourceId(1, 1));
            this.scaleDrawable = SkinCompatResources.getInstance().getDrawable(this.typedArray.getResourceId(8, 8));
        }
    }

    private void initView() {
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setDither(true);
        if (TextUtils.equals(Id9AlsConstants.ID9ALS_SKIN_MODEL, "1")) {
            this.colorArray = getResources().getIntArray(R.array.bmw_id9_dashboard_linear_noble);
        } else if (TextUtils.equals(Id9AlsConstants.ID9ALS_SKIN_MODEL, "1")) {
            this.colorArray = getResources().getIntArray(R.array.bmw_id9_dashboard_linear_noble);
        } else {
            this.colorArray = getResources().getIntArray(R.array.bmw_id9_dashboard_linear_noble);
        }
        this.colorPosition = new float[]{0.0f, 0.31f, 0.67f, 0.94f};
        this.rulerBitmap = BitmapUtil.drawableToBitmap(this.rulerDrawable);
        this.scaleBitmap = BitmapUtil.drawableToBitmap(this.scaleDrawable);
        this.maskBitmap = BitmapUtil.drawableToBitmap(this.maskDrawable);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(TAG, "onSizeChanged w " + w + " h " + h);
        this.mWidth = w;
        this.mHeight = h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        super.onDraw(canvas);
        Log.i(TAG, "onDraw");
        if (this.scaleVisible && (bitmap3 = this.scaleBitmap) != null) {
            canvas.drawBitmap(bitmap3, 0.0f, 0.0f, (Paint) null);
        }
        if (this.linearVisible && this.paint != null) {
            if (this.mOrientation == 0) {
                int i = this.mHeight;
                LinearGradient linearGradient2 = new LinearGradient(0.0f, (float) i, 0.0f, (float) (i - calcScale(this.mScale)), this.colorArray, this.colorPosition, Shader.TileMode.CLAMP);
                this.linearGradient = linearGradient2;
                this.paint.setShader(linearGradient2);
                canvas.drawRect(0.0f, (float) ((this.mHeight - calcScale(this.mScale)) - 34), (float) this.mWidth, (float) this.mHeight, this.paint);
            } else {
                LinearGradient linearGradient3 = new LinearGradient(0.0f, 0.0f, (float) calcScale(this.mScale), (float) this.mHeight, this.colorArray, this.colorPosition, Shader.TileMode.CLAMP);
                this.linearGradient = linearGradient3;
                this.paint.setShader(linearGradient3);
                canvas.drawRect(0.0f, 0.0f, (float) calcScale(this.mScale), (float) this.mHeight, this.paint);
            }
        }
        if (this.rulerVisible && (bitmap2 = this.rulerBitmap) != null) {
            if (this.mOrientation == 0) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, this.mWidth, bitmap2.getHeight(), true);
                this.rulerBitmap = createScaledBitmap;
                canvas.drawBitmap(createScaledBitmap, 0.0f, (float) ((this.mHeight - calcScale(this.mScale)) - 41), (Paint) null);
            } else {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap2, bitmap2.getWidth(), this.mHeight, true);
                this.rulerBitmap = createScaledBitmap2;
                canvas.drawBitmap(createScaledBitmap2, (float) calcScale(this.mScale), 0.0f, (Paint) null);
            }
        }
        if (this.maskVisible && (bitmap = this.maskBitmap) != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void setColorArray(int[] color) {
        if (color != null && color.length == 5) {
            this.colorArray = color;
            invalidate();
        }
    }

    public void setPositionArray(float[] position) {
        if (position != null && position.length == 5) {
            this.colorPosition = position;
            invalidate();
        }
    }

    public void setScale(int scale) {
        this.mScale = scale;
        if (scale < 0) {
            this.mScale = 0;
        }
        int i = this.mScale;
        int i2 = this.maxScale;
        if (i > i2) {
            this.mScale = i2;
        }
        invalidate();
    }

    private int calcScale(int scale) {
        int value;
        if (this.mOrientation == 0) {
            value = Math.min((scale * 532) / this.maxScale, 532);
        } else {
            int i = this.mWidth;
            value = Math.min((i * scale) / this.maxScale, i);
        }
        if (value < 0) {
            return 0;
        }
        return value;
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.i(TAG, "applySkin");
        if (TextUtils.equals(Id9AlsConstants.ID9ALS_SKIN_MODEL, "1")) {
            this.colorArray = getResources().getIntArray(R.array.bmw_id9_dashboard_linear_noble);
        } else if (TextUtils.equals(Id9AlsConstants.ID9ALS_SKIN_MODEL, "1")) {
            this.colorArray = getResources().getIntArray(R.array.bmw_id9_dashboard_linear_noble);
        } else {
            this.colorArray = getResources().getIntArray(R.array.bmw_id9_dashboard_linear_noble);
        }
        if (!(SkinCompatResources.getInstance() == null || this.typedArray == null)) {
            Drawable drawable = SkinCompatResources.getInstance().getDrawable(this.typedArray.getResourceId(1, 1));
            this.maskDrawable = drawable;
            this.maskBitmap = BitmapUtil.drawableToBitmap(drawable);
            Drawable drawable2 = SkinCompatResources.getInstance().getDrawable(this.typedArray.getResourceId(8, 8));
            this.scaleDrawable = drawable2;
            this.scaleBitmap = BitmapUtil.drawableToBitmap(drawable2);
        }
        invalidate();
    }
}
