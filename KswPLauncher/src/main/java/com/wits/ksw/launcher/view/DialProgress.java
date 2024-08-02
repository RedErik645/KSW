package com.wits.ksw.launcher.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.MiscUtil;

public class DialProgress extends View {
    private static final String TAG = DialProgress.class.getSimpleName();
    private boolean antiAlias;
    private long mAnimTime;
    private ValueAnimator mAnimator;
    private Paint mArcPaint;
    private float mArcWidth;
    private int mBgArcColor;
    private Paint mBgArcPaint;
    private Point mCenterPoint;
    private Context mContext;
    private int mDefaultSize;
    private int mDialColor;
    private int mDialIntervalDegree;
    private Paint mDialPaint;
    private float mDialWidth;
    private int[] mGradientColors = {-16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
    private CharSequence mHint;
    private int mHintColor;
    private float mHintOffset;
    private TextPaint mHintPaint;
    private float mHintSize;
    private float mMaxValue;
    private float mPercent;
    private String mPrecisionFormat;
    private float mRadius;
    private RectF mRectF;
    private float mStartAngle;
    private float mSweepAngle;
    private float mTextOffsetPercentInRadius;
    private CharSequence mUnit;
    private int mUnitColor;
    private float mUnitOffset;
    private Paint mUnitPaint;
    private float mUnitSize;
    private float mValue;
    private int mValueColor;
    private float mValueOffset;
    private Paint mValuePaint;
    private float mValueSize;

    public DialProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        this.mDefaultSize = MiscUtil.dipToPx(context, 150.0f);
        this.mRectF = new RectF();
        this.mCenterPoint = new Point();
        initConfig(context, attrs);
        initPaint();
        setValue(this.mValue);
    }

    private void initConfig(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DialProgress);
        this.antiAlias = typedArray.getBoolean(1, true);
        this.mMaxValue = typedArray.getFloat(11, 100.0f);
        this.mValue = typedArray.getFloat(19, 25.0f);
        this.mValueSize = typedArray.getDimension(21, 15.0f);
        this.mValueColor = typedArray.getColor(20, ViewCompat.MEASURED_STATE_MASK);
        this.mDialIntervalDegree = typedArray.getInt(6, 10);
        this.mPrecisionFormat = MiscUtil.getPrecisionFormat(typedArray.getInt(12, 0));
        this.mUnit = typedArray.getString(16);
        this.mUnitColor = typedArray.getColor(17, ViewCompat.MEASURED_STATE_MASK);
        this.mUnitSize = typedArray.getDimension(18, 30.0f);
        this.mHint = typedArray.getString(8);
        this.mHintColor = typedArray.getColor(9, ViewCompat.MEASURED_STATE_MASK);
        this.mHintSize = typedArray.getDimension(10, 15.0f);
        this.mArcWidth = typedArray.getDimension(3, 15.0f);
        this.mStartAngle = typedArray.getFloat(13, 270.0f);
        this.mSweepAngle = typedArray.getFloat(14, 360.0f);
        this.mAnimTime = (long) typedArray.getInt(0, 1000);
        this.mBgArcColor = typedArray.getColor(4, -7829368);
        this.mDialWidth = typedArray.getDimension(7, 2.0f);
        this.mDialColor = typedArray.getColor(5, -1);
        this.mTextOffsetPercentInRadius = typedArray.getFloat(15, 0.33f);
        if (typedArray.getResourceId(2, 0) != 0) {
            try {
                this.mGradientColors[0] = Color.parseColor("#CE042C");
            } catch (Resources.NotFoundException e) {
                throw new Resources.NotFoundException("the give resource not found.");
            }
        }
        typedArray.recycle();
    }

    private void initPaint() {
        TextPaint textPaint = new TextPaint();
        this.mHintPaint = textPaint;
        textPaint.setAntiAlias(this.antiAlias);
        this.mHintPaint.setTextSize(this.mHintSize);
        this.mHintPaint.setColor(this.mHintColor);
        this.mHintPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint = new Paint();
        this.mValuePaint = paint;
        paint.setAntiAlias(this.antiAlias);
        this.mValuePaint.setTextSize(this.mValueSize);
        this.mValuePaint.setColor(this.mValueColor);
        this.mValuePaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint();
        this.mUnitPaint = paint2;
        paint2.setAntiAlias(this.antiAlias);
        this.mUnitPaint.setTextSize(this.mUnitSize);
        this.mUnitPaint.setColor(this.mUnitColor);
        this.mUnitPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint();
        this.mArcPaint = paint3;
        paint3.setAntiAlias(this.antiAlias);
        this.mArcPaint.setStyle(Paint.Style.STROKE);
        this.mArcPaint.setStrokeWidth(this.mArcWidth);
        this.mArcPaint.setStrokeCap(Paint.Cap.BUTT);
        Paint paint4 = new Paint();
        this.mBgArcPaint = paint4;
        paint4.setAntiAlias(this.antiAlias);
        this.mBgArcPaint.setStyle(Paint.Style.STROKE);
        this.mBgArcPaint.setStrokeWidth(this.mArcWidth);
        this.mBgArcPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mBgArcPaint.setColor(this.mBgArcColor);
        Paint paint5 = new Paint();
        this.mDialPaint = paint5;
        paint5.setAntiAlias(this.antiAlias);
        this.mDialPaint.setColor(this.mDialColor);
        this.mDialPaint.setStrokeWidth(this.mDialWidth);
    }

    private void updateArcPaint() {
        this.mArcPaint.setShader(new SweepGradient((float) this.mCenterPoint.x, (float) this.mCenterPoint.y, this.mGradientColors, (float[]) null));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MiscUtil.measure(widthMeasureSpec, this.mDefaultSize), MiscUtil.measure(heightMeasureSpec, this.mDefaultSize));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        String str = TAG;
        Log.d(str, "onSizeChanged: w = " + w + "; h = " + h + "; oldw = " + oldw + "; oldh = " + oldh);
        this.mRadius = (float) (Math.min(((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (((int) this.mArcWidth) * 2), ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - (((int) this.mArcWidth) * 2)) / 2);
        this.mCenterPoint.x = getMeasuredWidth() / 2;
        this.mCenterPoint.y = getMeasuredHeight() / 2;
        this.mRectF.left = (((float) this.mCenterPoint.x) - this.mRadius) - (this.mArcWidth / 2.0f);
        this.mRectF.top = (((float) this.mCenterPoint.y) - this.mRadius) - (this.mArcWidth / 2.0f);
        this.mRectF.right = ((float) this.mCenterPoint.x) + this.mRadius + (this.mArcWidth / 2.0f);
        this.mRectF.bottom = ((float) this.mCenterPoint.y) + this.mRadius + (this.mArcWidth / 2.0f);
        this.mValueOffset = ((float) this.mCenterPoint.y) + getBaselineOffsetFromY(this.mValuePaint);
        this.mHintOffset = (((float) this.mCenterPoint.y) - (this.mRadius * this.mTextOffsetPercentInRadius)) + getBaselineOffsetFromY(this.mHintPaint);
        this.mUnitOffset = ((float) this.mCenterPoint.y) + (this.mRadius * this.mTextOffsetPercentInRadius) + getBaselineOffsetFromY(this.mUnitPaint);
        updateArcPaint();
        Log.d(str, "onMeasure: 控件大小 = (" + getMeasuredWidth() + ", " + getMeasuredHeight() + ");圆心坐标 = " + this.mCenterPoint.toString() + ";圆半径 = " + this.mRadius + ";圆的外接矩形 = " + this.mRectF.toString());
    }

    private float getBaselineOffsetFromY(Paint paint) {
        return MiscUtil.measureTextHeight(paint) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas);
        drawDial(canvas);
        drawText(canvas);
    }

    private void drawArc(Canvas canvas) {
        float currentAngle = this.mSweepAngle * this.mPercent;
        canvas.save();
        canvas.rotate(this.mStartAngle, (float) this.mCenterPoint.x, (float) this.mCenterPoint.y);
        canvas.drawArc(this.mRectF, 0.0f, currentAngle, false, this.mArcPaint);
        canvas.restore();
    }

    private void drawDial(Canvas canvas) {
        int total = (int) (this.mSweepAngle / ((float) this.mDialIntervalDegree));
        canvas.save();
        canvas.rotate(this.mStartAngle, (float) this.mCenterPoint.x, (float) this.mCenterPoint.y);
        for (int i = 0; i <= total; i++) {
            canvas.drawLine(((float) this.mCenterPoint.x) + this.mRadius, (float) this.mCenterPoint.y, ((float) this.mCenterPoint.x) + this.mRadius + this.mArcWidth, (float) this.mCenterPoint.y, this.mDialPaint);
            canvas.rotate((float) this.mDialIntervalDegree, (float) this.mCenterPoint.x, (float) this.mCenterPoint.y);
        }
        canvas.restore();
    }

    private void drawText(Canvas canvas) {
        canvas.drawText(String.format(this.mPrecisionFormat, Float.valueOf(this.mValue)), (float) this.mCenterPoint.x, this.mValueOffset, this.mValuePaint);
        CharSequence charSequence = this.mUnit;
        if (charSequence != null) {
            canvas.drawText(charSequence.toString(), (float) this.mCenterPoint.x, this.mUnitOffset, this.mUnitPaint);
        }
        CharSequence charSequence2 = this.mHint;
        if (charSequence2 != null) {
            canvas.drawText(charSequence2.toString(), (float) this.mCenterPoint.x, this.mHintOffset, this.mHintPaint);
        }
    }

    public float getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(float maxValue) {
        this.mMaxValue = maxValue;
    }

    public void setValue(float value) {
        float f = this.mMaxValue;
        if (value > f) {
            value = this.mMaxValue;
        }
        startAnimator(this.mPercent, value / f, this.mAnimTime);
    }

    private void startAnimator(float start, float end, long animTime) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, end);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(animTime);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.wits.ksw.launcher.view.DialProgress.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator animation) {
                DialProgress.this.mPercent = ((Float) animation.getAnimatedValue()).floatValue();
                DialProgress dialProgress = DialProgress.this;
                dialProgress.mValue = dialProgress.mPercent * DialProgress.this.mMaxValue;
                DialProgress.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public int[] getGradientColors() {
        return this.mGradientColors;
    }

    public void setGradientColors(int[] gradientColors) {
        this.mGradientColors = gradientColors;
        updateArcPaint();
    }

    public void reset() {
        startAnimator(this.mPercent, 0.0f, 1000);
    }
}
