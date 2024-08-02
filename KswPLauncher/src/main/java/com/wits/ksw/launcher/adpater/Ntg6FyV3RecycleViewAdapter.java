package com.wits.ksw.launcher.adpater;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.Ntgfyv3ItemBinding;
import com.wits.ksw.databinding.Ntgfyv3OtherItemBinding;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.bean.NtgFyV3Item;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.view.PageRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Ntg6FyV3RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int ITEM_TYPE_NORMAL = 0;
    private static final int ITEM_TYPE_OTHER = 1;
    List<AppInfo> appInfos;
    List<NtgFyV3Item> bcItemList;
    private int currentPage = 1;
    private int itemWidth = 0;
    private LinearLayoutManager layoutManager;
    private int pageMargin = 0;
    private PageRecyclerView recyclerView;
    private int spanColumn = 5;
    private int spanRow = 2;
    private int totalPage = 0;
    private Ntg6v3LauncherViewModel viewModel;

    public Ntg6FyV3RecycleViewAdapter(Ntg6v3LauncherViewModel viewModel2, List<AppInfo> apps, LinearLayoutManager layoutManager2, PageRecyclerView recyclerView2) {
        this.viewModel = viewModel2;
        this.layoutManager = layoutManager2;
        this.recyclerView = recyclerView2;
        this.appInfos = apps;
        this.bcItemList = getBcItemList();
    }

    public void addAllApps(List<AppInfo> apps) {
        this.appInfos = apps;
        this.bcItemList = getBcItemList();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public List<NtgFyV3Item> getBcItemList() {
        List<NtgFyV3Item> bcItems = new ArrayList<>();
        for (int i = 0; i < Ntg6v3LauncherViewModel.resId.length + this.appInfos.size(); i++) {
            NtgFyV3Item bcItem = new NtgFyV3Item();
            if (i < Ntg6v3LauncherViewModel.resId.length) {
                bcItem.setId(i);
                bcItem.setAppIcon(KswApplication.appContext.getResources().getDrawable(Ntg6v3LauncherViewModel.resId[i]));
                bcItem.setAppLable(Ntg6v3LauncherViewModel.bcItemArrys[i]);
                bcItems.add(bcItem);
            } else {
                bcItem.setId(i);
                bcItem.setAppIcon(this.appInfos.get(i - Ntg6v3LauncherViewModel.resId.length).getAppIcon());
                bcItem.setAppLable(this.appInfos.get(i - Ntg6v3LauncherViewModel.resId.length).getAppLable());
                bcItem.setApppkg(this.appInfos.get(i - Ntg6v3LauncherViewModel.resId.length).getApppkg());
                bcItem.setClassName(this.appInfos.get(i - Ntg6v3LauncherViewModel.resId.length).getClassName());
                bcItems.add(bcItem);
            }
        }
        return bcItems;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position < Ntg6v3LauncherViewModel.resId.length) {
            return 0;
        }
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        if (this.itemWidth <= 0) {
            this.itemWidth = (viewGroup.getWidth() - (this.pageMargin * 2)) / this.spanColumn;
        }
        if (type == 1) {
            Ntgfyv3OtherItemBinding otherItemBinding = (Ntgfyv3OtherItemBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.ntgfyv3_other_item, viewGroup, false);
            otherItemBinding.setMappsVieModel(this.viewModel);
            ViewHolder viewHolder = new ViewHolder(otherItemBinding);
            viewHolder.itemView.getLayoutParams().width = this.itemWidth;
            return viewHolder;
        }
        Ntgfyv3ItemBinding dataBinding = (Ntgfyv3ItemBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.ntgfyv3_item, viewGroup, false);
        dataBinding.setMappsVieModel(this.viewModel);
        ViewHolder viewHolder2 = new ViewHolder(dataBinding);
        viewHolder2.itemView.getLayoutParams().width = this.itemWidth;
        return viewHolder2;
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (position < Ntg6v3LauncherViewModel.resId.length) {
            Ntgfyv3ItemBinding itemMvvmBinding = viewHolder.getNtgfyv3ItemBinding();
            itemMvvmBinding.setListItem(this.bcItemList.get(position));
            itemMvvmBinding.getRoot().setTag(Integer.valueOf(position));
            itemMvvmBinding.ntgfyv3ItemIv.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.wits.ksw.launcher.adpater.Ntg6FyV3RecycleViewAdapter.AnonymousClass1 */

                public boolean onLongClick(View view) {
                    Toast.makeText(view.getContext(), view.getContext().getString(R.string.ksw_id7_system_app_not_uninstall), 0).show();
                    return true;
                }
            });
            itemMvvmBinding.executePendingBindings();
            itemMvvmBinding.ntgfyv3ItemIv.setOnKeyListener(new View.OnKeyListener(position) {
                /* class com.wits.ksw.launcher.adpater.$$Lambda$Ntg6FyV3RecycleViewAdapter$izmps8meWvyi2kv_6MtKniaK2E */
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return Ntg6FyV3RecycleViewAdapter.this.lambda$onBindViewHolder$1$Ntg6FyV3RecycleViewAdapter(this.f$1, view, i, keyEvent);
                }
            });
            return;
        }
        Ntgfyv3OtherItemBinding itemMvvmBinding2 = viewHolder.getOhterNtgfyv3ItemBinding();
        if (position < this.bcItemList.size()) {
            itemMvvmBinding2.setListItem(this.bcItemList.get(position));
        } else {
            itemMvvmBinding2.setListItem(null);
        }
        itemMvvmBinding2.getRoot().setTag(Integer.valueOf(position));
        itemMvvmBinding2.ntgfyv3ItemIv.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.wits.ksw.launcher.adpater.Ntg6FyV3RecycleViewAdapter.AnonymousClass2 */

            public boolean onLongClick(View view) {
                Ntg6FyV3RecycleViewAdapter ntg6FyV3RecycleViewAdapter = Ntg6FyV3RecycleViewAdapter.this;
                ntg6FyV3RecycleViewAdapter.onItemLongClick(view, ntg6FyV3RecycleViewAdapter.bcItemList.get(position));
                return true;
            }
        });
        itemMvvmBinding2.executePendingBindings();
        itemMvvmBinding2.ntgfyv3ItemIv.setOnKeyListener(new View.OnKeyListener(position) {
            /* class com.wits.ksw.launcher.adpater.$$Lambda$Ntg6FyV3RecycleViewAdapter$BTkNl_9RtL_5UJA36GSRhQRuiWY */
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return Ntg6FyV3RecycleViewAdapter.this.lambda$onBindViewHolder$4$Ntg6FyV3RecycleViewAdapter(this.f$1, view, i, keyEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$onBindViewHolder$1$Ntg6FyV3RecycleViewAdapter(int position, View v, int keyCode, KeyEvent event) {
        if (position == 0 && keyCode == 21 && event.getAction() == 0) {
            return false;
        }
        if ((keyCode == 21 || keyCode == 19) && event.getAction() == 0) {
            if (position == 0) {
                return true;
            }
            View view = this.layoutManager.findViewByPosition(position - 1);
            if (view != null) {
                return view.requestFocus();
            }
        } else if ((keyCode == 22 || keyCode == 20) && event.getAction() == 0) {
            int nextPosition = position + 1;
            if (nextPosition == 10) {
                PageRecyclerView pageRecyclerView = this.recyclerView;
                pageRecyclerView.smoothScrollBy(pageRecyclerView.getWidth(), 0);
                PageRecyclerView pageRecyclerView2 = this.recyclerView;
                pageRecyclerView2.setSelectedPage(pageRecyclerView2.getCurrentPage() + 1);
                new Handler().postDelayed(new Runnable(nextPosition) {
                    /* class com.wits.ksw.launcher.adpater.$$Lambda$Ntg6FyV3RecycleViewAdapter$mlV6GRNyu6RkBdxu0yCQwXtiWa4 */
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Ntg6FyV3RecycleViewAdapter.this.lambda$onBindViewHolder$0$Ntg6FyV3RecycleViewAdapter(this.f$1);
                    }
                }, 150);
                return true;
            }
            View view2 = this.layoutManager.findViewByPosition(nextPosition);
            if (view2 != null) {
                return view2.requestFocus();
            }
        }
        return false;
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$Ntg6FyV3RecycleViewAdapter(int nextPosition) {
        View view = this.layoutManager.findViewByPosition(nextPosition);
        if (view != null) {
            view.requestFocus();
        }
    }

    public /* synthetic */ boolean lambda$onBindViewHolder$4$Ntg6FyV3RecycleViewAdapter(int position, View v, int keyCode, KeyEvent event) {
        if ((keyCode == 21 || keyCode == 19) && event.getAction() == 0) {
            int nextPosition = position - 1;
            if (nextPosition % 10 == 9) {
                PageRecyclerView pageRecyclerView = this.recyclerView;
                pageRecyclerView.smoothScrollBy(-pageRecyclerView.getWidth(), 0);
                PageRecyclerView pageRecyclerView2 = this.recyclerView;
                pageRecyclerView2.setSelectedPage(pageRecyclerView2.getCurrentPage() - 1);
                new Handler().postDelayed(new Runnable(nextPosition) {
                    /* class com.wits.ksw.launcher.adpater.$$Lambda$Ntg6FyV3RecycleViewAdapter$W2rry1XGfwsnRS7nAjQ7ziVRuxE */
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Ntg6FyV3RecycleViewAdapter.this.lambda$onBindViewHolder$2$Ntg6FyV3RecycleViewAdapter(this.f$1);
                    }
                }, 150);
                return true;
            }
            View view = this.layoutManager.findViewByPosition(nextPosition);
            if (view != null) {
                return view.requestFocus();
            }
        } else if ((keyCode == 22 || keyCode == 20) && event.getAction() == 0) {
            int nextPosition2 = position + 1;
            if (nextPosition2 >= this.bcItemList.size()) {
                return true;
            }
            if (nextPosition2 % 10 == 0) {
                PageRecyclerView pageRecyclerView3 = this.recyclerView;
                pageRecyclerView3.smoothScrollBy(pageRecyclerView3.getWidth(), 0);
                PageRecyclerView pageRecyclerView4 = this.recyclerView;
                pageRecyclerView4.setSelectedPage(pageRecyclerView4.getCurrentPage() + 1);
                new Handler().postDelayed(new Runnable(nextPosition2) {
                    /* class com.wits.ksw.launcher.adpater.$$Lambda$Ntg6FyV3RecycleViewAdapter$9McYQOhXEWsT21yNI3XKRkiDGY */
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Ntg6FyV3RecycleViewAdapter.this.lambda$onBindViewHolder$3$Ntg6FyV3RecycleViewAdapter(this.f$1);
                    }
                }, 150);
                return true;
            }
            View view2 = this.layoutManager.findViewByPosition(nextPosition2);
            if (view2 != null) {
                return view2.requestFocus();
            }
        }
        return false;
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$Ntg6FyV3RecycleViewAdapter(int nextPosition) {
        View view = this.layoutManager.findViewByPosition(nextPosition);
        if (view != null) {
            view.requestFocus();
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$3$Ntg6FyV3RecycleViewAdapter(int nextPosition) {
        View view = this.layoutManager.findViewByPosition(nextPosition);
        if (view != null) {
            view.requestFocus();
        }
    }

    public void onItemLongClick(View view, NtgFyV3Item item) {
        if (TextUtils.equals(item.getApppkg(), "AUX_Type") || TextUtils.equals(item.getApppkg(), "DTV_Type") || TextUtils.equals(item.getApppkg(), "DVR_Type") || KswUtils.isSystemapp(item.getApppkg()) || TextUtils.equals(item.getApppkg(), "Front_view_camera")) {
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.ksw_id7_system_app_not_uninstall), 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + item.getApppkg()));
        intent.setFlags(268435456);
        view.getContext().startActivity(intent);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<NtgFyV3Item> list = this.bcItemList;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return countIndicatorSize(this.bcItemList.size());
    }

    private int countIndicatorSize(int sum) {
        if (sum % 10 == 0) {
            return sum;
        }
        return ((sum / 10) * 10) + 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Ntgfyv3ItemBinding bcItemBinding;
        Ntgfyv3OtherItemBinding otherItemBinding;

        public ViewHolder(Ntgfyv3ItemBinding binding) {
            super(binding.getRoot());
            this.bcItemBinding = binding;
        }

        public ViewHolder(Ntgfyv3OtherItemBinding binding) {
            super(binding.getRoot());
            this.otherItemBinding = binding;
        }

        public Ntgfyv3ItemBinding getNtgfyv3ItemBinding() {
            return this.bcItemBinding;
        }

        public Ntgfyv3OtherItemBinding getOhterNtgfyv3ItemBinding() {
            return this.otherItemBinding;
        }
    }
}
