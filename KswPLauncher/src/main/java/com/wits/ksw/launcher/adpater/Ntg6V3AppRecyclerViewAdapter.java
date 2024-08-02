package com.wits.ksw.launcher.adpater;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.utils.KeyUtils;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.view.benzntg6fy.BenzNtg6v3FyAppEditActivity;
import java.util.List;

public class Ntg6V3AppRecyclerViewAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {
    private final String TAG = "Ntg6V3AppRecyclerViewAdapter";
    private LinearLayoutManager linearLayout;
    private ItemClickListener mItemClickListener;
    private ItemKeyListener mItemKeyListener;

    public interface ItemClickListener {
        void onItemClick(View view, AppInfo appInfo);
    }

    public interface ItemKeyListener {
        void onItemKey();
    }

    public Ntg6V3AppRecyclerViewAdapter(List<AppInfo> data, LinearLayoutManager layoutManager) {
        super(R.layout.ntg6v3_all_app_item, data);
        this.linearLayout = layoutManager;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final AppInfo item) {
        helper.setImageDrawable(R.id.nameImageView, item.getAppIcon()).setText(R.id.textView, item.getAppLable());
        helper.itemView.findViewById(R.id.ntgfyv3_item_iv).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter.AnonymousClass1 */

            public void onClick(View view) {
                Ntg6V3AppRecyclerViewAdapter.this.mItemClickListener.onItemClick(view, item);
            }
        });
        helper.itemView.findViewById(R.id.ntgfyv3_item_iv).setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter.AnonymousClass2 */

            public boolean onLongClick(View view) {
                if (item.getClassName().contains("Ntg6V3")) {
                    Toast.makeText(view.getContext(), view.getContext().getString(R.string.ksw_id7_system_app_not_uninstall), 0).show();
                    return true;
                }
                Ntg6V3AppRecyclerViewAdapter.this.onItemLongClick(view, item);
                return true;
            }
        });
        helper.itemView.findViewById(R.id.ntgfyv3_item_iv).setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter.AnonymousClass3 */

            public boolean onKey(View view, int keyCode, KeyEvent event) {
                Log.d("Ntg6V3AppRecyclerViewAdapter", "onKey  " + keyCode + ", action: " + event.getAction());
                int position = Ntg6V3AppRecyclerViewAdapter.this.getData().indexOf(item);
                if (keyCode == 20 && event.getAction() == 0) {
                    if (position == 4) {
                        KeyUtils.pressKey(61);
                    } else {
                        KeyUtils.pressKey(22);
                    }
                    return true;
                } else if (keyCode != 19 || event.getAction() != 0) {
                    return false;
                } else {
                    if (position == 5) {
                        View tiemview = Ntg6V3AppRecyclerViewAdapter.this.linearLayout.findViewByPosition(4);
                        if (view != null) {
                            tiemview.requestFocus();
                        }
                    } else if (position == 0) {
                        Ntg6V3AppRecyclerViewAdapter.this.mItemKeyListener.onItemKey();
                    } else {
                        KeyUtils.pressKey(21);
                    }
                    return true;
                }
            }
        });
        helper.itemView.findViewById(R.id.ntgfyv3_item_rl).setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter.AnonymousClass4 */

            public boolean onLongClick(View view) {
                Intent intent = new Intent(Ntg6V3AppRecyclerViewAdapter.this.mContext, BenzNtg6v3FyAppEditActivity.class);
                intent.addFlags(268435456);
                Ntg6V3AppRecyclerViewAdapter.this.mContext.startActivity(intent);
                return true;
            }
        });
    }

    public void onItemLongClick(View view, AppInfo item) {
        if (TextUtils.equals(item.getApppkg(), "AUX_Type") || TextUtils.equals(item.getApppkg(), "DTV_Type") || TextUtils.equals(item.getApppkg(), "DVR_Type") || KswUtils.isSystemapp(item.getApppkg()) || TextUtils.equals(item.getApppkg(), "Front_view_camera")) {
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.ksw_id7_system_app_not_uninstall), 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + item.getApppkg()));
        intent.setFlags(268435456);
        view.getContext().startActivity(intent);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setItemKeyListener(ItemKeyListener itemKeyListener) {
        this.mItemKeyListener = itemKeyListener;
    }
}
