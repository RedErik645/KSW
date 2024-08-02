package com.wits.ksw.launcher.view.id9als.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.DialogId9MainSettingBinding;
import com.wits.ksw.databinding.DialogId9MainSettingRtlBinding;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.listener.Id9DialogFocusLeaveListener;
import com.wits.ksw.launcher.view.id9als.listener.Id9DialogOnClickListener;
import com.wits.ksw.launcher.view.ug.WiewFocusUtils;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id9MainSettingDialog extends Dialog {
    private static final String TAG = "Id9MainSettingDialog";
    private TextView camSettingView;
    private FrameLayout frameLayout = null;
    private boolean isLayoutModelRtl = false;
    private View layoutView;
    private Id9DialogFocusLeaveListener leaveListener;
    private CountDownTimer mAutoPlayTimer;
    private Context mContext;
    private TextView timeSettingView;
    private TextView unitSettingView;
    private View[] views = new View[3];

    public Id9MainSettingDialog(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        try {
            this.isLayoutModelRtl = Id9AlsConstants.ID9ALS_LAYOUT_MODEL_RTL.equals(PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_LAYOUT_MODEL));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.isLayoutModelRtl) {
            DialogId9MainSettingRtlBinding id9RtlBinding = DialogId9MainSettingRtlBinding.inflate(getLayoutInflater());
            this.layoutView = id9RtlBinding.getRoot();
            this.frameLayout = id9RtlBinding.id9SettingFl;
            this.timeSettingView = id9RtlBinding.id9SettingTime;
            this.unitSettingView = id9RtlBinding.id9SettingUnit;
            this.camSettingView = id9RtlBinding.id9SettingCamera;
        } else {
            DialogId9MainSettingBinding id9LtrBinding = DialogId9MainSettingBinding.inflate(getLayoutInflater());
            this.layoutView = id9LtrBinding.getRoot();
            this.frameLayout = id9LtrBinding.id9SettingFl;
            this.timeSettingView = id9LtrBinding.id9SettingTime;
            this.unitSettingView = id9LtrBinding.id9SettingUnit;
            this.camSettingView = id9LtrBinding.id9SettingCamera;
        }
        setContentView(this.layoutView);
        View[] viewArr = this.views;
        viewArr[0] = this.timeSettingView;
        viewArr[1] = this.unitSettingView;
        viewArr[2] = this.camSettingView;
        WindowManager manager = getWindow().getWindowManager();
        manager.getDefaultDisplay().getMetrics(this.mContext.getResources().getDisplayMetrics());
        Display d = manager.getDefaultDisplay();
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams params = window.getAttributes();
        Log.e(TAG, "crateDialog: " + params.width + "  " + params.height + "  " + d.getWidth() + "  " + d.getHeight());
        params.height = d.getHeight();
        params.width = KswUtils.dip2px(KswApplication.appContext, 400.0f);
        if (this.isLayoutModelRtl) {
            params.gravity = GravityCompat.START;
        } else {
            params.gravity = GravityCompat.END;
        }
        params.alpha = 0.99f;
        window.setType(2003);
        window.setAttributes(params);
        Id9MainSettingTimeView timeView = new Id9MainSettingTimeView(this.mContext);
        if (timeView.mViewModel != null) {
            timeView.mViewModel.setItemClickListener(new Id9DialogOnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$SuEP5rz0sf2cw9O60vKKzBqAzOA */

                @Override // com.wits.ksw.launcher.view.id9als.listener.Id9DialogOnClickListener
                public final void onItemClickListener(View view) {
                    Id9MainSettingDialog.this.lambda$initView$0$Id9MainSettingDialog(view);
                }
            });
        }
        Id9MainSettingUnitView unitView = new Id9MainSettingUnitView(this.mContext);
        if (unitView.mViewModel != null) {
            unitView.mViewModel.setItemClickListener(new Id9DialogOnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$N25NtHi6w4SLNQXihAvKxPqq8 */

                @Override // com.wits.ksw.launcher.view.id9als.listener.Id9DialogOnClickListener
                public final void onItemClickListener(View view) {
                    Id9MainSettingDialog.this.lambda$initView$1$Id9MainSettingDialog(view);
                }
            });
        }
        Id9MainSettingCameraView cameraView = new Id9MainSettingCameraView(this.mContext);
        if (cameraView.mViewModel != null) {
            cameraView.mViewModel.setItemClickListener(new Id9DialogOnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$aP0086BQOyCDenCpVBT0erHzg */

                @Override // com.wits.ksw.launcher.view.id9als.listener.Id9DialogOnClickListener
                public final void onItemClickListener(View view) {
                    Id9MainSettingDialog.this.lambda$initView$2$Id9MainSettingDialog(view);
                }
            });
        }
        this.frameLayout.removeAllViews();
        this.frameLayout.addView(timeView);
        this.timeSettingView.setOnClickListener(new View.OnClickListener(timeView) {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$3O8EgiyYIJBJZmGOl_uqYAlg */
            public final /* synthetic */ Id9MainSettingTimeView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id9MainSettingDialog.this.lambda$initView$3$Id9MainSettingDialog(this.f$1, view);
            }
        });
        this.unitSettingView.setOnClickListener(new View.OnClickListener(unitView) {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$ZbV18EiImUNEaxoNPzSb2suTfWU */
            public final /* synthetic */ Id9MainSettingUnitView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id9MainSettingDialog.this.lambda$initView$4$Id9MainSettingDialog(this.f$1, view);
            }
        });
        this.camSettingView.setOnClickListener(new View.OnClickListener(cameraView) {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$nVDPR7Ho0LUdn9SpZk2lF7WA2o4 */
            public final /* synthetic */ Id9MainSettingCameraView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id9MainSettingDialog.this.lambda$initView$5$Id9MainSettingDialog(this.f$1, view);
            }
        });
        setNextFocusId(0);
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$0GKy_dGhB72RbcxaCLJgypGeG_g */

            public final void onDismiss(DialogInterface dialogInterface) {
                Id9MainSettingDialog.this.lambda$initView$6$Id9MainSettingDialog(dialogInterface);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$Id9MainSettingDialog(View view) {
        startAutoTimer();
        viewRequestFocus(view.getId());
    }

    public /* synthetic */ void lambda$initView$1$Id9MainSettingDialog(View view) {
        startAutoTimer();
        viewRequestFocus(view.getId());
    }

    public /* synthetic */ void lambda$initView$2$Id9MainSettingDialog(View view) {
        startAutoTimer();
        viewRequestFocus(view.getId());
    }

    public /* synthetic */ void lambda$initView$3$Id9MainSettingDialog(Id9MainSettingTimeView timeView, View view) {
        this.frameLayout.removeAllViews();
        this.frameLayout.addView(timeView);
        startAutoTimer();
        setNextFocusId(0);
        viewRequestFocus(view.getId());
    }

    public /* synthetic */ void lambda$initView$4$Id9MainSettingDialog(Id9MainSettingUnitView unitView, View view) {
        this.frameLayout.removeAllViews();
        this.frameLayout.addView(unitView);
        startAutoTimer();
        setNextFocusId(1);
        viewRequestFocus(view.getId());
    }

    public /* synthetic */ void lambda$initView$5$Id9MainSettingDialog(Id9MainSettingCameraView cameraView, View view) {
        this.frameLayout.removeAllViews();
        this.frameLayout.addView(cameraView);
        startAutoTimer();
        setNextFocusId(2);
        viewRequestFocus(view.getId());
    }

    public /* synthetic */ void lambda$initView$6$Id9MainSettingDialog(DialogInterface dialog) {
        cancelAutoTimer();
    }

    public void setButtonSelected(View view) {
        View[] viewArr = this.views;
        int length = viewArr.length;
        for (int i = 0; i < length; i++) {
            View mView = viewArr[i];
            if (mView instanceof TextView) {
                ((TextView) mView).setTextColor(this.mContext.getResources().getColor(view == mView ? R.color.id9_card_title : R.color.id9_font_white));
            }
        }
    }

    private void setNextFocusId(int type) {
        switch (type) {
            case 0:
                if (this.isLayoutModelRtl) {
                    this.timeSettingView.setNextFocusRightId(R.id.bmw_id8_settings_time_car);
                    this.unitSettingView.setNextFocusRightId(R.id.bmw_id8_settings_time_car);
                    this.camSettingView.setNextFocusRightId(R.id.bmw_id8_settings_time_car);
                } else {
                    this.timeSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_time_car);
                    this.unitSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_time_car);
                    this.camSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_time_car);
                }
                setButtonSelected(this.timeSettingView);
                return;
            case 1:
                if (this.isLayoutModelRtl) {
                    this.timeSettingView.setNextFocusRightId(R.id.bmw_id8_settings_system_fuel_l);
                    this.unitSettingView.setNextFocusRightId(R.id.bmw_id8_settings_system_fuel_l);
                    this.camSettingView.setNextFocusRightId(R.id.bmw_id8_settings_system_fuel_l);
                } else {
                    this.timeSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_system_fuel_l);
                    this.unitSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_system_fuel_l);
                    this.camSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_system_fuel_l);
                }
                setButtonSelected(this.unitSettingView);
                return;
            case 2:
                if (this.isLayoutModelRtl) {
                    this.timeSettingView.setNextFocusRightId(R.id.bmw_id8_settings_system_camera_after);
                    this.unitSettingView.setNextFocusRightId(R.id.bmw_id8_settings_system_camera_after);
                    this.camSettingView.setNextFocusRightId(R.id.bmw_id8_settings_system_camera_after);
                } else {
                    this.timeSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_system_camera_after);
                    this.unitSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_system_camera_after);
                    this.camSettingView.setNextFocusLeftId(R.id.bmw_id8_settings_system_camera_after);
                }
                setButtonSelected(this.camSettingView);
                return;
            default:
                return;
        }
    }

    public void show() {
        super.show();
        startAutoTimer();
        new Handler().postDelayed(new Runnable() {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9MainSettingDialog$VwudE1puQlTKwZJNkgh__9VxFk4 */

            public final void run() {
                Id9MainSettingDialog.this.lambda$show$7$Id9MainSettingDialog();
            }
        }, 120);
    }

    public /* synthetic */ void lambda$show$7$Id9MainSettingDialog() {
        viewRequestFocus(R.id.id9_setting_time);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        Id9DialogFocusLeaveListener id9DialogFocusLeaveListener;
        Id9DialogFocusLeaveListener id9DialogFocusLeaveListener2;
        int type = event.getKeyCode();
        startAutoTimer();
        View currentFocus = getWindow().getCurrentFocus();
        if (currentFocus == null) {
            viewRequestFocus(R.id.id9_setting_time);
            return true;
        }
        int requestViewId = 0;
        int currentFocusId = currentFocus.getId();
        switch (type) {
            case 19:
                requestViewId = currentFocus.getNextFocusUpId();
                break;
            case 20:
                requestViewId = currentFocus.getNextFocusDownId();
                break;
            case 21:
                if (this.isLayoutModelRtl || currentFocusId == R.id.id9_setting_time || currentFocusId == R.id.id9_setting_unit || currentFocusId == R.id.id9_setting_camera || (id9DialogFocusLeaveListener = this.leaveListener) == null) {
                    requestViewId = currentFocus.getNextFocusLeftId();
                    break;
                } else {
                    id9DialogFocusLeaveListener.onFocusLeaveListener(currentFocus);
                    dismiss();
                    return true;
                }
            case 22:
                if (!this.isLayoutModelRtl || currentFocusId == R.id.id9_setting_time || currentFocusId == R.id.id9_setting_unit || currentFocusId == R.id.id9_setting_camera || (id9DialogFocusLeaveListener2 = this.leaveListener) == null) {
                    requestViewId = currentFocus.getNextFocusRightId();
                    break;
                } else {
                    id9DialogFocusLeaveListener2.onFocusLeaveListener(currentFocus);
                    dismiss();
                    return true;
                }
            case 66:
                setViewClickEvent();
                return true;
        }
        if (requestViewId > 0) {
            viewRequestFocus(requestViewId);
        }
        return super.dispatchKeyEvent(event);
    }

    public void setId9DialogFocusLeaveListener(Id9DialogFocusLeaveListener listener) {
        this.leaveListener = listener;
    }

    private void viewRequestFocus(int resId) {
        if (this.layoutView != null) {
            Log.i(TAG, "viewRequestFocus: " + resId);
            WiewFocusUtils.setViewRequestFocus(this.layoutView.findViewById(resId));
        }
    }

    public void startAutoTimer() {
        Log.d(TAG, "startAutoTimer");
        cancelAutoTimer();
        if (this.mAutoPlayTimer == null) {
            this.mAutoPlayTimer = new CountDownTimer(10000, 1000) {
                /* class com.wits.ksw.launcher.view.id9als.fragment.Id9MainSettingDialog.AnonymousClass1 */

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    Log.i(Id9MainSettingDialog.TAG, "startAutoTimer onFinish: ");
                    Id9MainSettingDialog.this.dismiss();
                }
            };
        }
        this.mAutoPlayTimer.start();
    }

    public void cancelAutoTimer() {
        Log.d(TAG, "cancelAutoTimer");
        CountDownTimer countDownTimer = this.mAutoPlayTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void setViewClickEvent() {
        View currentFocus = getWindow().getCurrentFocus();
        if (currentFocus != null) {
            long downTime = SystemClock.uptimeMillis();
            int[] ints = new int[2];
            MotionEvent downEvent = MotionEvent.obtain(downTime, downTime, 0, (float) (ints[0] + 5), (float) (ints[1] + 5), 0);
            long downTime2 = downTime + 1000;
            MotionEvent upEvent = MotionEvent.obtain(downTime2, downTime2, 1, (float) (ints[0] + 5), (float) (ints[1] + 5), 0);
            currentFocus.onTouchEvent(downEvent);
            currentFocus.onTouchEvent(upEvent);
            downEvent.recycle();
            upEvent.recycle();
        }
    }
}
