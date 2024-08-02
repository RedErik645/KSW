package com.wits.ksw.launcher.bmw_id8_ui.fragment;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bmw_id8_ui.ID8EditActivity;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardOnClickListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardOnDragListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.DragClickListener;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.utils.AppInfoUtils;

public class ID8Fragment3rdApp extends Fragment {
    private static final String TAG = "ID8Fragment3rdApp";
    public static final int iconResId = -1;
    public static final int nameResId = -1;
    private final String cls;
    private TrdAppRemoveListener listener;
    private final String pkg;
    private final String tag;

    public interface TrdAppRemoveListener {
        void onTrdAppRemove();
    }

    public ID8Fragment3rdApp(String tag2, TrdAppRemoveListener listener2) {
        this.listener = listener2;
        this.tag = tag2;
        String[] split = tag2.substring(4).split(",");
        this.pkg = split[0];
        this.cls = split[1];
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean z = false;
        View view = inflater.inflate(R.layout.fragment_3rd_edit, container, false);
        view.setOnDragListener(new CardOnDragListener(TAG, this, (ID8EditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, this.tag, -1, -1));
        view.setOnClickListener(new CardOnClickListener((ID8EditActivity) getActivity()));
        view.setTag(this.tag);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        ImageView remove = (ImageView) view.findViewById(R.id.remove);
        if (!setFactoryAppCardView(this.pkg, tvName, iv)) {
            ResolveInfo resolveInfo = AppInfoUtils.findAppByPkgAndCls(KswApplication.appContext, this.pkg, this.cls);
            PackageManager pm = KswApplication.appContext.getPackageManager();
            StringBuilder append = new StringBuilder().append("get3rdAppView: resolveInfo == null");
            if (resolveInfo == null) {
                z = true;
            }
            Log.w(TAG, append.append(z).append(", pkg : ").append(this.pkg).append(", cls : ").append(this.cls).toString());
            if (resolveInfo == null) {
                tvName.setText(this.cls);
                iv.setImageDrawable(null);
            } else {
                tvName.setText(resolveInfo.loadLabel(pm).toString());
                iv.setImageDrawable(resolveInfo.loadIcon(pm));
            }
        }
        remove.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.fragment.ID8Fragment3rdApp.AnonymousClass1 */

            public void onClick(View view) {
                ID8LauncherConstants.removeCard(ID8Fragment3rdApp.this.tag);
                if (ID8Fragment3rdApp.this.listener != null) {
                    ID8Fragment3rdApp.this.listener.onTrdAppRemove();
                }
            }
        });
        return view;
    }

    private boolean setFactoryAppCardView(String pkg2, TextView titleView, ImageView iconImg) {
        if ("DTV_Type".equals(pkg2)) {
            titleView.setText(AppsLoaderTask.dtvLable);
            iconImg.setImageDrawable(AppsLoaderTask.dtvIcon);
            return true;
        } else if ("Front_view_camera".equals(pkg2)) {
            titleView.setText(AppsLoaderTask.fcamLable);
            iconImg.setImageDrawable(AppsLoaderTask.fcamIcon);
            return true;
        } else if ("AUX_Type".equals(pkg2)) {
            titleView.setText(AppsLoaderTask.auxLable);
            iconImg.setImageDrawable(AppsLoaderTask.auxIcon);
            return true;
        } else if (!"DVR_Type".equals(pkg2)) {
            return false;
        } else {
            titleView.setText(AppsLoaderTask.dvrLable);
            iconImg.setImageDrawable(AppsLoaderTask.dvrIcon);
            return true;
        }
    }
}