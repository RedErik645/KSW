package com.wits.ksw.launcher.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.wits.ksw.R;
import com.wits.ksw.databinding.Ntg630ControlPopupBinding;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.settings.utlis_view.UtilsInfo;
import com.wits.pms.statuscontrol.McuStatus;
import com.wits.pms.statuscontrol.WitsCommand;

public class Ntg630ControlView {
    private static final String TAG = ("KswApplication." + Ntg630ControlView.class.getSimpleName());
    private static Ntg630ControlView instance;
    private Ntg630ControlPopupBinding binding;
    private PopupWindow brightnessPopupWindow;
    private PopupWindow popupWindow;

    private Ntg630ControlView() {
    }

    public static synchronized Ntg630ControlView getInstance() {
        Ntg630ControlView ntg630ControlView;
        synchronized (Ntg630ControlView.class) {
            if (instance == null) {
                instance = new Ntg630ControlView();
            }
            ntg630ControlView = instance;
        }
        return ntg630ControlView;
    }

    public void showBenzControl(Context context, final LauncherViewModel launcherViewModel, View view) {
        int width = UtilsInfo.dip2px(context, 175.0f);
        int height = UtilsInfo.dip2px(context, 378.0f);
        Ntg630ControlPopupBinding ntg630ControlPopupBinding = (Ntg630ControlPopupBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ntg630_control_popup, null, false);
        this.binding = ntg630ControlPopupBinding;
        ntg630ControlPopupBinding.setLauncherViewModel(launcherViewModel);
        this.popupWindow = new PopupWindow(this.binding.getRoot(), width, height, true);
        if (UiThemeUtils.isUI_KSW_ID7(context) || UiThemeUtils.isUI_KSW_MBUX_1024(context)) {
            this.popupWindow.showAsDropDown(view, -view.getLeft(), (-view.getTop()) - view.getHeight());
        } else {
            this.popupWindow.showAsDropDown(view, -view.getLeft(), -view.getTop());
        }
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.wits.ksw.launcher.view.Ntg630ControlView.AnonymousClass1 */

            public void onDismiss() {
                launcherViewModel.controlBean.benzControlPanelState.set(false);
            }
        });
        launcherViewModel.controlBean.benzControlPanelState.set(true);
    }

    public void dismiss() {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.popupWindow = null;
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow2 = this.popupWindow;
        return popupWindow2 != null && popupWindow2.isShowing();
    }

    public void showBenzBrightnessDailog(Context context, McuStatus.BenzData benzData, final LauncherViewModel launcherViewModel, int light) {
        Log.d(TAG, " showBenzBrightnessDailog light " + light);
        View layout = LayoutInflater.from(context).inflate(R.layout.ntg6_brightness_control_popup, (ViewGroup) null);
        View closeImage = layout.findViewById(R.id.closeImage);
        View addBrImageView = layout.findViewById(R.id.addBrImageView);
        View subBrImageView = layout.findViewById(R.id.subBrImageView);
        PopupWindow popupWindow2 = new PopupWindow(layout, UtilsInfo.dip2px(context, 321.0f), UtilsInfo.dip2px(context, 225.0f), true);
        this.brightnessPopupWindow = popupWindow2;
        popupWindow2.setOutsideTouchable(false);
        this.brightnessPopupWindow.showAsDropDown(this.binding.controlBtn1, (this.binding.controlBtn1.getRight() / 2) + 20, this.binding.controlBtn1.getTop() - 20);
        this.brightnessPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.wits.ksw.launcher.view.Ntg630ControlView.AnonymousClass2 */

            public void onDismiss() {
                Log.i("", "onDismiss: " + launcherViewModel.controlBean.leftBrightnessAdjus.get());
                if (launcherViewModel.controlBean.leftBrightnessAdjus.get()) {
                    launcherViewModel.controlBean.leftBrightnessAdjus.set(false);
                } else if (launcherViewModel.controlBean.rightBrightnessAdjus.get()) {
                    launcherViewModel.controlBean.rightBrightnessAdjus.set(false);
                }
            }
        });
        addBrImageView.setOnClickListener(new View.OnClickListener(light, benzData) {
            /* class com.wits.ksw.launcher.view.$$Lambda$Ntg630ControlView$IN0wTN9g5eAtuEBmT3gM32DmCMA */
            public final /* synthetic */ int f$0;
            public final /* synthetic */ McuStatus.BenzData f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Ntg630ControlView.lambda$showBenzBrightnessDailog$0(this.f$0, this.f$1, view);
            }
        });
        subBrImageView.setOnClickListener(new View.OnClickListener(light, benzData) {
            /* class com.wits.ksw.launcher.view.$$Lambda$Ntg630ControlView$DDu6UhOC7_jSym1En6Nfr8StG1w */
            public final /* synthetic */ int f$0;
            public final /* synthetic */ McuStatus.BenzData f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Ntg630ControlView.lambda$showBenzBrightnessDailog$1(this.f$0, this.f$1, view);
            }
        });
        closeImage.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.$$Lambda$Ntg630ControlView$zq4Sp0exQbyUjWqBGx5097d2MO0 */

            public final void onClick(View view) {
                Ntg630ControlView.this.lambda$showBenzBrightnessDailog$2$Ntg630ControlView(view);
            }
        });
    }

    static /* synthetic */ void lambda$showBenzBrightnessDailog$0(int light, McuStatus.BenzData benzData, View v) {
        if (light == 1) {
            benzData.light1 = 1;
            benzData.light2 = 0;
        } else {
            benzData.light1 = 0;
            benzData.light2 = 1;
        }
        benzData.key3 = 0;
        WitsCommand.sendCommand(1, WitsCommand.SystemCommand.BENZ_CONTROL, benzData.getJson());
    }

    static /* synthetic */ void lambda$showBenzBrightnessDailog$1(int light, McuStatus.BenzData benzData, View v) {
        if (light == 1) {
            benzData.light1 = 255;
            benzData.light2 = 0;
        } else {
            benzData.light1 = 0;
            benzData.light2 = 255;
        }
        benzData.key3 = 0;
        WitsCommand.sendCommand(1, WitsCommand.SystemCommand.BENZ_CONTROL, benzData.getJson());
    }

    public /* synthetic */ void lambda$showBenzBrightnessDailog$2$Ntg630ControlView(View v) {
        this.brightnessPopupWindow.dismiss();
        this.brightnessPopupWindow = null;
    }
}
