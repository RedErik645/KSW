package com.wits.ksw.launcher.view;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.wits.ksw.MainActivity;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.KswUtils;

public class CustomBcImageView extends ImageView implements View.OnFocusChangeListener {
    private static final String TAG = "KswApplication";
    private int itemHalfWidth;
    private int itemRightPostionX;
    int leftX;
    private int moveItemViewHalfWidth;

    public CustomBcImageView(Context context) {
        this(context, null);
    }

    public CustomBcImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.leftX = 0;
        this.itemHalfWidth = 0;
        Log.i("KswApplication", "CustomBcImageView: " + getWidth());
        setOnFocusChangeListener(this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.itemHalfWidth = getWidth() / 2;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (event.getAction() == 0) {
            if (keyCode == 19 || keyCode == 20) {
                return true;
            }
        } else if (event.getAction() == 1) {
            if (keyCode == 20) {
                sendKeyDownUpSync(22);
                Log.i("KswApplication", "dispatchKeyEvent: KEYCODE_DPAD_UP---->>>KEYCODE_DPAD_RIGHT");
                return true;
            } else if (keyCode == 19) {
                sendKeyDownUpSync(21);
                Log.i("KswApplication", "dispatchKeyEvent: KEYCODE_DPAD_DOWN---->>>KEYCODE_DPAD_LEFT");
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public static void sendKeyDownUpSync(final int key) {
        new Handler().post(new Runnable() {
            /* class com.wits.ksw.launcher.view.CustomBcImageView.AnonymousClass1 */

            public void run() {
                new Thread(new Runnable() {
                    /* class com.wits.ksw.launcher.view.CustomBcImageView.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(key);
                    }
                }).start();
            }
        });
    }

    public void scaleSmail(View view) {
        view.startAnimation((ScaleAnimation) AnimationUtils.loadAnimation(view.getContext(), R.anim.scale_out));
    }

    public void scaleBig(View view) {
        view.startAnimation((ScaleAnimation) AnimationUtils.loadAnimation(view.getContext(), R.anim.scale_in));
    }

    public void onFocusChange(View view, boolean hasFocus) {
        Log.i("KswApplication", "onFocusChange: ");
        if (hasFocus) {
            scaleBig(view);
            int X = getItemLocationOnScreenX(view);
            Log.i("KswApplication", "onFocusChange: view[" + X + "," + getItemLocationOnScreenY(view) + "]");
            translationX(view);
            return;
        }
        scaleSmail(view);
    }

    public void translationX(View view) {
        int i = this.leftX;
        calculateRightPostionX(view);
        int itemLocationOnScreenX = getItemLocationOnScreenX(view);
        Log.i("KswApplication", "translationX: itemLocationOnScreenX=" + itemLocationOnScreenX);
        if (itemLocationOnScreenX <= this.leftX) {
            Log.i("KswApplication", "translationX: 最左端");
            itemLocationOnScreenX = this.leftX;
        }
        int itemCenterPointX = itemCenterPoint(itemLocationOnScreenX);
        Log.i("KswApplication", "translationX: itemCenterPoint=" + itemCenterPointX);
        if (itemCenterPointX >= this.itemRightPostionX) {
            Log.i("KswApplication", "translationX: 最右端");
            itemCenterPointX = this.itemRightPostionX;
        } else if (itemLocationOnScreenX <= this.leftX) {
            Log.i("KswApplication", "translationX: 最左端");
            itemCenterPointX = itemCenterPoint(itemLocationOnScreenX);
        }
        try {
            int width = MainActivity.mainActivity.bcMainActivity.CustomBcItemBgImageView.getWidth() / 2;
            this.moveItemViewHalfWidth = width;
            MainActivity.mainActivity.bcMainActivity.CustomBcItemBgImageView.translationX(itemCenterPointX - width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int itemCenterPoint(int itemLocationOnScreenX) {
        return this.itemHalfWidth + itemLocationOnScreenX;
    }

    private void calculateRightPostionX(View view) {
        this.itemRightPostionX = KswUtils.screenWidth(view.getContext()) - this.itemHalfWidth;
        Log.i("KswApplication", "calculateRightPostionX: calculateRightPostionX=" + this.itemRightPostionX);
    }

    private int getItemLocationOnScreenX(View view) {
        int[] postion = new int[2];
        view.getLocationOnScreen(postion);
        return postion[0];
    }

    private int getItemLocationOnScreenY(View view) {
        int[] postion = new int[2];
        view.getLocationOnScreen(postion);
        int y = postion[1];
        Log.i("KswApplication", "getItemLocationOnScreenY: " + y);
        return y;
    }
}
