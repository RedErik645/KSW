package com.wits.ksw.settings.als_id7_ui_set.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.wits.ksw.R;
import com.wits.ksw.settings.id7.bean.MapBean;
import java.util.List;

public class AlsID7UiNaviAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<MapBean> mapBanList;
    private IrbtCheckListener rbtCheckListener;

    public interface IrbtCheckListener {
        void checkListener(int i);
    }

    public interface OnItemClickLisen {
        void ItemClickLisen(int i);
    }

    public AlsID7UiNaviAdapter(Context context2, List<MapBean> data) {
        this.context = context2;
        this.mapBanList = data;
    }

    public void registCheckListener(IrbtCheckListener listener) {
        this.rbtCheckListener = listener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.als_id7_ui_navi_adpter_layout, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Drawable drawable;
        if (this.mapBanList.get(position).getMapicon() == null) {
            drawable = this.context.getDrawable(R.mipmap.ic_launcher);
        } else {
            drawable = this.mapBanList.get(position).getMapicon();
        }
        drawable.setBounds(0, 0, 40, 40);
        holder.rbt_navi.setCompoundDrawables(drawable, null, null, null);
        holder.rbt_navi.setText(this.mapBanList.get(position).getName());
        Log.d("NaviAdapter", "appName: " + this.mapBanList.get(position).getName());
        holder.rbt_navi.setCompoundDrawablePadding(10);
        holder.rbt_navi.setEnabled(true);
        holder.rbt_navi.setTextColor(ContextCompat.getColor(this.context, R.color.color1));
        holder.rbt_navi.setChecked(this.mapBanList.get(position).isCheck());
        if (this.rbtCheckListener != null) {
            holder.rbt_navi.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.als_id7_ui_set.adapter.AlsID7UiNaviAdapter.AnonymousClass1 */

                public void onClick(View view) {
                    for (MapBean mpb : AlsID7UiNaviAdapter.this.mapBanList) {
                        mpb.setCheck(false);
                    }
                    ((MapBean) AlsID7UiNaviAdapter.this.mapBanList.get(position)).setCheck(true);
                    AlsID7UiNaviAdapter.this.notifyDataSetChanged();
                    AlsID7UiNaviAdapter.this.rbtCheckListener.checkListener(position);
                }
            });
        }
        holder.rbt_navi.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.adapter.AlsID7UiNaviAdapter.AnonymousClass2 */

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode != 20 || position != AlsID7UiNaviAdapter.this.getItemCount() - 1) {
                    return false;
                }
                Log.i("NaviAdapter", "onBindViewHolder: position" + position + ", count:" + AlsID7UiNaviAdapter.this.getItemCount());
                return true;
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MapBean> list = this.mapBanList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        RadioButton rbt_navi;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.rbt_navi = (RadioButton) itemView.findViewById(R.id.rbt_navi);
        }
    }
}
