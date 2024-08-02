package com.wits.ksw.settings.romeo.layout_one;

import android.content.Context;
import android.content.Intent;
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

public class RomeoSetToAndSysLayout extends RelativeLayout {
    private IUpdateListBg updateListBg;

    public RomeoSetToAndSysLayout(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.romeo_layout_set_none, (ViewGroup) null);
        ((TextView) view.findViewById(R.id.tv_oneDefaul)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetToAndSysLayout.AnonymousClass1 */

            public void onClick(View view) {
                context.startActivity(new Intent("android.settings.SETTINGS"));
            }
        });
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        changeItemBg((LinearLayout) view.findViewById(R.id.romeo_settosys_ll), getContext());
    }

    private void changeItemBg(final ViewGroup viewGroup, Context context) {
        for (final int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetToAndSysLayout.AnonymousClass2 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int[] locW = new int[2];
                    viewGroup.getChildAt(i).getLocationInWindow(locW);
                    if (motionEvent.getAction() == 0) {
                        RomeoSetToAndSysLayout.this.updateListBg.updateListBg(locW[1] - 78, 2);
                    } else if (motionEvent.getAction() == 1) {
                        RomeoSetToAndSysLayout.this.updateListBg.updateListBg(locW[1] - 78, 0);
                    } else if (motionEvent.getAction() == 3) {
                        RomeoSetToAndSysLayout.this.updateListBg.updateListBg(locW[1] - 78, 0);
                    }
                    return false;
                }
            });
            viewGroup.getChildAt(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetToAndSysLayout.AnonymousClass3 */

                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        int[] locW = new int[2];
                        viewGroup.getChildAt(i).getLocationInWindow(locW);
                        RomeoSetToAndSysLayout.this.updateListBg.updateListBg(locW[1] - 78, 1);
                        return;
                    }
                    RomeoSetToAndSysLayout.this.updateListBg.updateListBg(0, 0);
                }
            });
        }
    }

    public void registIUpdateListBg(IUpdateListBg updateListBg2) {
        this.updateListBg = updateListBg2;
    }
}
