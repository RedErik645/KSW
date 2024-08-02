package com.wits.ksw.launcher.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

public class RoundRectImageView extends AppCompatImageView {
    private Paint paint;

    public RoundRectImageView(Context context) {
        this(context, null);
    }

    public RoundRectImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.paint = new Paint();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = getBitmapFromDrawable(drawable);
            Log.d("RoundRectImageView", "h: " + bitmap.getWidth() + " w: " + bitmap.getHeight() + " getW: " + getWidth() + " getH: " + getHeight());
            Bitmap bitmap2 = compositeBitmap(bitmap);
            Log.d("RoundRectImageView", "h: " + bitmap2.getWidth() + " w: " + bitmap2.getHeight() + " getW: " + getWidth() + " getH: " + getHeight());
            Bitmap b = getRoundBitmapByShader(bitmap2, getWidth(), getHeight(), 20, 0);
            Rect rectSrc = new Rect(0, 0, getWidth(), getHeight());
            Rect rectDest = new Rect(0, 0, getWidth(), getHeight());
            this.paint.reset();
            canvas.drawBitmap(b, rectSrc, rectDest, this.paint);
            return;
        }
        super.onDraw(canvas);
    }

    public Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap.Config config;
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        drawable.draw(canvas);
        return bitmap;
    }

    public Bitmap compositeBitmap(Bitmap secondBitmap) {
        Bitmap secondBitmap2 = scaleBitmap(secondBitmap, 54, 54);
        Bitmap firstBitmap = Bitmap.createBitmap(getWidth(), getHeight(), secondBitmap2.getConfig());
        Bitmap bitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap.getHeight(), firstBitmap.getConfig());
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawColor(-1);
        canvas.drawBitmap(firstBitmap, new Matrix(), null);
        canvas.drawBitmap(secondBitmap2, (float) ((getWidth() - secondBitmap2.getWidth()) / 2), (float) ((getHeight() - secondBitmap2.getHeight()) / 2), (Paint) null);
        return bitmap;
    }

    private Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        int height = origin.getHeight();
        int width = origin.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) newWidth) / ((float) width), ((float) newHeight) / ((float) height));
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, true);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return newBM;
    }

    public static Bitmap getRoundBitmapByShader(Bitmap bitmap, int outWidth, int outHeight, int radius, int boarder) {
        if (bitmap == null) {
            return null;
        }
        float heightScale = (((float) outHeight) * 1.0f) / ((float) bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.setScale((((float) outWidth) * 1.0f) / ((float) bitmap.getWidth()), heightScale);
        Bitmap desBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(desBitmap);
        Paint paint2 = new Paint(1);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint2.setShader(bitmapShader);
        RectF rect = new RectF((float) boarder, (float) boarder, (float) (outWidth - boarder), (float) (outHeight - boarder));
        canvas.drawRoundRect(rect, (float) radius, (float) radius, paint2);
        if (boarder > 0) {
            Paint boarderPaint = new Paint(1);
            boarderPaint.setColor(-16711936);
            boarderPaint.setStyle(Paint.Style.STROKE);
            boarderPaint.setStrokeWidth((float) boarder);
            canvas.drawRoundRect(rect, (float) radius, (float) radius, boarderPaint);
        }
        return desBitmap;
    }
}
