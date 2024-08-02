package com.wits.ksw.settings.romeo.layout_one;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.romeo.interfaces.IUpdateListBg;
import com.wits.ksw.settings.romeo.interfaces.IUpdateTwoLayout;

public class RomeoSetTimeLayout extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private LinearLayout romeo_time_ll;
    private TextView tv_timeSync;
    private TextView tv_timeZhis;
    private IUpdateListBg updateListBg;
    private IUpdateTwoLayout updateTwoLayout;

    public void registIUpdateTwoLayout(IUpdateTwoLayout twoLayout) {
        this.updateTwoLayout = twoLayout;
    }

    public RomeoSetTimeLayout(Context context2) {
        super(context2);
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(R.layout.romeo_layout_set_time, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    public void registIUpdateListBg(IUpdateListBg updateListBg2) {
        this.updateListBg = updateListBg2;
    }

    private void changeItemBg(final ViewGroup viewGroup, Context context2) {
        for (final int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetTimeLayout.AnonymousClass1 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int[] locW = new int[2];
                    viewGroup.getChildAt(i).getLocationInWindow(locW);
                    if (motionEvent.getAction() == 0) {
                        RomeoSetTimeLayout.this.updateListBg.updateListBg(locW[1] - 78, 2);
                    } else if (motionEvent.getAction() == 1) {
                        RomeoSetTimeLayout.this.updateListBg.updateListBg(locW[1] - 78, 0);
                    } else if (motionEvent.getAction() == 3) {
                        RomeoSetTimeLayout.this.updateListBg.updateListBg(locW[1] - 78, 0);
                    }
                    return false;
                }
            });
            viewGroup.getChildAt(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetTimeLayout.AnonymousClass2 */

                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        int[] locW = new int[2];
                        viewGroup.getChildAt(i).getLocationInWindow(locW);
                        RomeoSetTimeLayout.this.updateListBg.updateListBg(locW[1] - 78, 1);
                        return;
                    }
                    RomeoSetTimeLayout.this.updateListBg.updateListBg(0, 0);
                }
            });
        }
    }

    private void initData() {
    }

    private void initView(View view) {
        this.tv_timeSync = (TextView) view.findViewById(R.id.tv_timeSync);
        this.tv_timeZhis = (TextView) view.findViewById(R.id.tv_timeZhis);
        this.romeo_time_ll = (LinearLayout) view.findViewById(R.id.romeo_time_ll);
        this.tv_timeSync.setOnClickListener(this);
        this.tv_timeZhis.setOnClickListener(this);
        changeItemBg(this.romeo_time_ll, getContext());
    }

    public void resetTextColor() {
        this.tv_timeSync.setTextColor(Color.argb(255, 172, 216, 255));
        this.tv_timeZhis.setTextColor(-1);
        IUpdateTwoLayout iUpdateTwoLayout = this.updateTwoLayout;
        if (iUpdateTwoLayout != null) {
            iUpdateTwoLayout.updateTwoLayout(4, 0);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_timeSync /*{ENCODED_INT: 2131232802}*/:
                this.tv_timeSync.setTextColor(Color.argb(255, 172, 216, 255));
                this.tv_timeZhis.setTextColor(-1);
                IUpdateTwoLayout iUpdateTwoLayout = this.updateTwoLayout;
                if (iUpdateTwoLayout != null) {
                    iUpdateTwoLayout.updateTwoLayout(4, 0);
                    return;
                }
                return;
            case R.id.tv_timeZhis /*{ENCODED_INT: 2131232803}*/:
                this.tv_timeZhis.setTextColor(Color.argb(255, 172, 216, 255));
                this.tv_timeSync.setTextColor(-1);
                IUpdateTwoLayout iUpdateTwoLayout2 = this.updateTwoLayout;
                if (iUpdateTwoLayout2 != null) {
                    iUpdateTwoLayout2.updateTwoLayout(4, 1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
