package com.wits.ksw.settings.romeo.layout_one;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.ExceptionPrint;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.romeo.interfaces.IUpdateListBg;
import com.wits.ksw.settings.romeo.interfaces.IUpdateTwoLayout;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class RomeoSetSystemLayout extends RelativeLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private String TAG = "SetSystemLayout";
    private CheckBox cbox_sysDcgj;
    private CheckBox cbox_sysDcjy;
    private CheckBox cbox_sysDcld;
    private CheckBox cbox_sysHjs;
    private CheckBox cbox_sysXcjz;
    private int cheVideo = 0;
    private Context context;
    private int dcgj = 0;
    private int dcjy = 0;
    private int dcld = 0;
    private int downY;
    private int housi = 0;
    private Handler mHandler = new Handler() {
        /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetSystemLayout.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(RomeoSetSystemLayout.this.TAG, "handleMessage downY=" + RomeoSetSystemLayout.this.downY);
            int count = RomeoSetSystemLayout.this.downY / 107;
            if (RomeoSetSystemLayout.this.downY % 107 > 53) {
                count++;
            }
            RomeoSetSystemLayout.this.set_system_scroll.scrollTo(0, count * 107);
        }
    };
    private int nbauxsw = 0;
    private LinearLayout set_system_ll;
    private ScrollView set_system_scroll;
    private TextView tempUnitView;
    private TextView tv_music_app;
    private TextView tv_sysBgld;
    private TextView tv_sysCaux;
    private TextView tv_sysDcsxt;
    private TextView tv_video_app;
    private IUpdateListBg updateListBg;
    private IUpdateTwoLayout updateTwoLayout;

    public void registIUpdateTwoLayout(IUpdateTwoLayout twoLayout) {
        this.updateTwoLayout = twoLayout;
    }

    public void registIUpdateListBg(IUpdateListBg updateListBg2) {
        this.updateListBg = updateListBg2;
    }

    public RomeoSetSystemLayout(Context context2) {
        super(context2);
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(R.layout.romeo_layout_set_system, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
        this.set_system_scroll = (ScrollView) view.findViewById(R.id.set_system_scroll);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.set_system_ll);
        this.set_system_ll = linearLayout;
        changeItemBg(linearLayout, getContext());
        this.set_system_scroll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetSystemLayout.AnonymousClass2 */

            public void onGlobalLayout() {
                if (RomeoSetSystemLayout.this.set_system_ll != null) {
                    Log.d(RomeoSetSystemLayout.this.TAG, "onGlobalLayout///");
                    RomeoSetSystemLayout romeoSetSystemLayout = RomeoSetSystemLayout.this;
                    romeoSetSystemLayout.changeDistance(romeoSetSystemLayout.set_system_ll, RomeoSetSystemLayout.this.getContext());
                }
            }
        });
        this.set_system_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetSystemLayout.AnonymousClass3 */

            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                Log.d(RomeoSetSystemLayout.this.TAG, "onScrollChange///" + i1);
                for (int n = 0; n < RomeoSetSystemLayout.this.set_system_ll.getChildCount(); n++) {
                    RomeoSetSystemLayout.this.set_system_ll.getChildAt(n).getY();
                    float top = (float) RomeoSetSystemLayout.this.set_system_ll.getChildAt(n).getTop();
                    RomeoSetSystemLayout.this.set_system_ll.getChildAt(n).getLocationInWindow(new int[2]);
                    RomeoSetSystemLayout.this.set_system_ll.getChildAt(n).getLocationOnScreen(new int[2]);
                    RomeoSetSystemLayout romeoSetSystemLayout = RomeoSetSystemLayout.this;
                    romeoSetSystemLayout.changeDistance(romeoSetSystemLayout.set_system_ll, RomeoSetSystemLayout.this.getContext());
                    if (RomeoSetSystemLayout.this.mHandler.hasMessages(0)) {
                        RomeoSetSystemLayout.this.mHandler.removeMessages(0);
                    }
                    RomeoSetSystemLayout.this.downY = i1;
                    RomeoSetSystemLayout.this.mHandler.sendEmptyMessageDelayed(0, 200);
                }
            }
        });
    }

    private void changeItemBg(final ViewGroup viewGroup, Context context2) {
        Log.d(this.TAG, "changeItemBg");
        for (final int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetSystemLayout.AnonymousClass4 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Log.d(RomeoSetSystemLayout.this.TAG, "changeItemBg onTouch i=" + i + " action=" + motionEvent.getAction());
                    int[] locW = new int[2];
                    viewGroup.getChildAt(i).getLocationInWindow(locW);
                    Log.d(RomeoSetSystemLayout.this.TAG, "use updateListBg=" + RomeoSetSystemLayout.this.updateListBg);
                    if (motionEvent.getAction() == 0) {
                        RomeoSetSystemLayout.this.downY = (int) motionEvent.getY();
                        RomeoSetSystemLayout.this.updateListBg.updateListBg(locW[1] - 78, 2);
                    } else if (motionEvent.getAction() == 1) {
                        RomeoSetSystemLayout.this.updateListBg.updateListBg(locW[1] - 78, 0);
                    } else if (motionEvent.getAction() == 3) {
                        RomeoSetSystemLayout.this.updateListBg.updateListBg(locW[1] - 78, 0);
                    }
                    return false;
                }
            });
            viewGroup.getChildAt(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetSystemLayout.AnonymousClass5 */

                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        Log.d(RomeoSetSystemLayout.this.TAG, "changeItemBg onFocusChange i=" + i + " downY=" + RomeoSetSystemLayout.this.downY);
                        int[] locW = new int[2];
                        viewGroup.getChildAt(i).getLocationInWindow(locW);
                        RomeoSetSystemLayout.this.updateListBg.updateListBg(locW[1] - 78, 1);
                        return;
                    }
                    RomeoSetSystemLayout.this.updateListBg.updateListBg(0, 0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeDistance(ViewGroup viewGroup, Context context2) {
        Log.d("SetSystemLayout", "calculateTranslate count=" + viewGroup.getChildCount());
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            int[] locW = new int[2];
            viewGroup.getChildAt(i).getLocationInWindow(locW);
            int pad = KswUtils.calculateTranslate2(locW[1] - 78, KswUtils.dip2px(context2, 428.0f), i, context2);
            viewGroup.getChildAt(i).setPadding(pad, 0, pad, 0);
            Log.d("SetSystemLayout", "calculateTranslate i=" + i + " pad=" + pad + " locW[1]=" + (locW[1] - 78));
        }
    }

    private void initData() {
        try {
            this.housi = PowerManagerApp.getSettingsInt(KeyConfig.HOU_SHI_SX);
            this.cheVideo = PowerManagerApp.getSettingsInt(KeyConfig.XING_CHE_JZSP);
            this.dcgj = PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_GJ);
            this.dcld = PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_LD);
            this.dcjy = PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_JY);
            this.nbauxsw = PowerManagerApp.getSettingsInt(KeyConfig.NBT_AUX_SW);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initView(View view) {
        this.tempUnitView = (TextView) view.findViewById(R.id.tv_sysTempUnit);
        this.tv_sysDcsxt = (TextView) view.findViewById(R.id.tv_sysDcsxt);
        this.tv_sysBgld = (TextView) view.findViewById(R.id.tv_sysBgld);
        this.cbox_sysHjs = (CheckBox) view.findViewById(R.id.cbox_sysHjs);
        this.cbox_sysXcjz = (CheckBox) view.findViewById(R.id.cbox_sysXcjz);
        this.cbox_sysDcgj = (CheckBox) view.findViewById(R.id.cbox_sysDcgj);
        this.cbox_sysDcld = (CheckBox) view.findViewById(R.id.cbox_sysDcld);
        this.tv_sysCaux = (TextView) view.findViewById(R.id.tv_sysCaux);
        this.cbox_sysDcjy = (CheckBox) view.findViewById(R.id.cbox_sysDcjy);
        boolean z = true;
        this.cbox_sysHjs.setChecked(this.housi != 0);
        this.cbox_sysXcjz.setChecked(this.cheVideo != 0);
        this.cbox_sysDcgj.setChecked(this.dcgj != 0);
        this.cbox_sysDcld.setChecked(this.dcld != 0);
        CheckBox checkBox = this.cbox_sysDcjy;
        if (this.dcjy == 0) {
            z = false;
        }
        checkBox.setChecked(z);
        this.tv_sysDcsxt.setOnClickListener(this);
        this.tv_sysBgld.setOnClickListener(this);
        this.tv_sysCaux.setOnClickListener(this);
        this.tempUnitView.setOnClickListener(this);
        this.cbox_sysHjs.setOnCheckedChangeListener(this);
        this.cbox_sysXcjz.setOnCheckedChangeListener(this);
        this.cbox_sysDcgj.setOnCheckedChangeListener(this);
        this.cbox_sysDcld.setOnCheckedChangeListener(this);
        this.cbox_sysDcjy.setOnCheckedChangeListener(this);
        if (this.nbauxsw == 3) {
            this.tv_sysCaux.setVisibility(0);
        } else {
            this.tv_sysCaux.setVisibility(8);
        }
        this.tv_music_app = (TextView) view.findViewById(R.id.tv_music_app);
        this.tv_video_app = (TextView) view.findViewById(R.id.tv_video_app);
        this.tv_music_app.setOnClickListener(this);
        this.tv_video_app.setOnClickListener(this);
    }

    public void resetTextColor() {
        this.tv_sysDcsxt.setTextColor(-1);
        this.tv_sysBgld.setTextColor(-1);
        this.tempUnitView.setTextColor(-1);
        this.tv_music_app.setTextColor(-1);
        this.tv_video_app.setTextColor(-1);
        IUpdateTwoLayout iUpdateTwoLayout = this.updateTwoLayout;
        if (iUpdateTwoLayout != null) {
            iUpdateTwoLayout.updateTwoLayout(1, 0);
        }
    }

    public void onClick(View v) {
        if (this.updateTwoLayout == null) {
            ExceptionPrint.print("updateTwoLayout is null");
            return;
        }
        resetTextColor();
        switch (v.getId()) {
            case R.id.tv_music_app /*{ENCODED_INT: 2131232767}*/:
                this.tv_music_app.setTextColor(Color.argb(255, 172, 216, 255));
                this.updateTwoLayout.updateTwoLayout(1, 6);
                return;
            case R.id.tv_sysBgld /*{ENCODED_INT: 2131232791}*/:
                this.tv_sysBgld.setTextColor(Color.argb(255, 172, 216, 255));
                this.updateTwoLayout.updateTwoLayout(1, 2);
                return;
            case R.id.tv_sysCaux /*{ENCODED_INT: 2131232792}*/:
                this.updateTwoLayout.updateTwoLayout(1, 3);
                return;
            case R.id.tv_sysDcsxt /*{ENCODED_INT: 2131232793}*/:
                this.tv_sysDcsxt.setTextColor(Color.argb(255, 172, 216, 255));
                this.updateTwoLayout.updateTwoLayout(1, 1);
                return;
            case R.id.tv_sysTempUnit /*{ENCODED_INT: 2131232795}*/:
                this.tempUnitView.setTextColor(Color.argb(255, 172, 216, 255));
                this.updateTwoLayout.updateTwoLayout(1, 4);
                return;
            case R.id.tv_video_app /*{ENCODED_INT: 2131232809}*/:
                this.tv_video_app.setTextColor(Color.argb(255, 172, 216, 255));
                this.updateTwoLayout.updateTwoLayout(1, 7);
                return;
            default:
                return;
        }
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cbox_sysDcgj /*{ENCODED_INT: 2131231333}*/:
                FileUtils.savaData(KeyConfig.DAO_CHE_GJ, isChecked);
                return;
            case R.id.cbox_sysDcjy /*{ENCODED_INT: 2131231334}*/:
                FileUtils.savaData(KeyConfig.DAO_CHE_JY, isChecked);
                return;
            case R.id.cbox_sysDcld /*{ENCODED_INT: 2131231335}*/:
                FileUtils.savaData(KeyConfig.DAO_CHE_LD, isChecked);
                return;
            case R.id.cbox_sysHjs /*{ENCODED_INT: 2131231336}*/:
                FileUtils.savaData(KeyConfig.HOU_SHI_SX, isChecked);
                return;
            case R.id.cbox_sysXcjz /*{ENCODED_INT: 2131231337}*/:
                FileUtils.savaData(KeyConfig.XING_CHE_JZSP, isChecked);
                return;
            default:
                return;
        }
    }
}
