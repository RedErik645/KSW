package com.wits.ksw.settings.view_adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.id7.bean.DevBean;
import java.util.List;

public class ListPlayAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DevBean> mapBanList;
    private IrbtCheckListener rbtCheckListener;

    public interface IrbtCheckListener {
        void checkListener(int i);
    }

    public interface OnItemClickLisen {
        void ItemClickLisen(int i);
    }

    public ListPlayAdapter(Context context2, List<DevBean> data) {
        this.context = context2;
        this.mapBanList = data;
    }

    public void registCheckListener(IrbtCheckListener listener) {
        this.rbtCheckListener = listener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.navi_settings_adpter_layout, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Drawable drawable;
        if (this.mapBanList.get(position).getAppicon() == null) {
            drawable = this.context.getDrawable(R.mipmap.ic_launcher);
        } else {
            drawable = this.mapBanList.get(position).getAppicon();
        }
        drawable.setBounds(0, 0, 40, 40);
        holder.rbt_navi.setCompoundDrawables(drawable, null, null, null);
        holder.marqueeTextView.setText(this.mapBanList.get(position).getName());
        holder.rbt_navi.setCompoundDrawablePadding(10);
        holder.rbt_navi.setEnabled(true);
        holder.rbt_navi.setTextColor(ContextCompat.getColor(this.context, R.color.color1));
        holder.rbt_navi.setChecked(this.mapBanList.get(position).isCheck());
        if (this.rbtCheckListener != null) {
            holder.rbt_navi.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.view_adapter.ListPlayAdapter.AnonymousClass1 */

                public void onClick(View view) {
                    for (DevBean mpb : ListPlayAdapter.this.mapBanList) {
                        mpb.setCheck(false);
                    }
                    ((DevBean) ListPlayAdapter.this.mapBanList.get(position)).setCheck(true);
                    ListPlayAdapter.this.notifyDataSetChanged();
                    ListPlayAdapter.this.rbtCheckListener.checkListener(position);
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<DevBean> list = this.mapBanList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        MarqueeTextView marqueeTextView;
        RadioButton rbt_navi;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.rbt_navi = (RadioButton) itemView.findViewById(R.id.rbt_navi);
            this.marqueeTextView = (MarqueeTextView) itemView.findViewById(R.id.mtv_tv);
        }
    }
}
