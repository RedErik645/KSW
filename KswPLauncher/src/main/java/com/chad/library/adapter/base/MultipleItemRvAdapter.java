package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.chad.library.adapter.base.util.ProviderDelegate;
import java.util.List;

public abstract class MultipleItemRvAdapter<T, V extends BaseViewHolder> extends BaseQuickAdapter<T, V> {
    private SparseArray<BaseItemProvider> mItemProviders;
    private MultiTypeDelegate<T> mMultiTypeDelegate;
    protected ProviderDelegate mProviderDelegate;

    /* access modifiers changed from: protected */
    public abstract int getViewType(T t);

    public abstract void registerItemProvider();

    public MultipleItemRvAdapter(List<T> data) {
        super(data);
    }

    public void finishInitialize() {
        this.mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new MultiTypeDelegate<T>() {
            /* class com.chad.library.adapter.base.MultipleItemRvAdapter.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.util.MultiTypeDelegate
            public int getItemType(T t) {
                return MultipleItemRvAdapter.this.getViewType(t);
            }
        });
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        for (int i = 0; i < this.mItemProviders.size(); i++) {
            int key = this.mItemProviders.keyAt(i);
            BaseItemProvider provider = this.mItemProviders.get(key);
            provider.mData = this.mData;
            getMultiTypeDelegate().registerItemType(key, provider.layout());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(V baseViewHolder) {
        if (baseViewHolder != null) {
            bindClick(baseViewHolder);
            super.bindViewClickListener(baseViewHolder);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public V onCreateDefViewHolder(ViewGroup parent, int viewType) {
        if (getMultiTypeDelegate() != null) {
            return (V) createBaseViewHolder(parent, getMultiTypeDelegate().getLayoutId(viewType));
        }
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        if (getMultiTypeDelegate() != null) {
            return getMultiTypeDelegate().getDefItemViewType(this.mData, position);
        }
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(V helper, T item) {
        BaseItemProvider provider = this.mItemProviders.get(helper.getItemViewType());
        provider.mContext = ((BaseViewHolder) helper).itemView.getContext();
        provider.convert(helper, item, helper.getLayoutPosition() - getHeaderLayoutCount());
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convertPayloads(V helper, T item, List<Object> payloads) {
        this.mItemProviders.get(helper.getItemViewType()).convertPayloads(helper, item, helper.getLayoutPosition() - getHeaderLayoutCount(), payloads);
    }

    private void bindClick(final V helper) {
        BaseQuickAdapter.OnItemClickListener clickListener = getOnItemClickListener();
        BaseQuickAdapter.OnItemLongClickListener longClickListener = getOnItemLongClickListener();
        if (clickListener == null || longClickListener == null) {
            if (clickListener == null) {
                ((BaseViewHolder) helper).itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.chad.library.adapter.base.MultipleItemRvAdapter.AnonymousClass2 */

                    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.chad.library.adapter.base.provider.BaseItemProvider */
                    /* JADX WARN: Multi-variable type inference failed */
                    public void onClick(View v) {
                        int position = helper.getAdapterPosition();
                        if (position != -1) {
                            int position2 = position - MultipleItemRvAdapter.this.getHeaderLayoutCount();
                            ((BaseItemProvider) MultipleItemRvAdapter.this.mItemProviders.get(helper.getItemViewType())).onClick(helper, MultipleItemRvAdapter.this.mData.get(position2), position2);
                        }
                    }
                });
            }
            if (longClickListener == null) {
                ((BaseViewHolder) helper).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.chad.library.adapter.base.MultipleItemRvAdapter.AnonymousClass3 */

                    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.chad.library.adapter.base.provider.BaseItemProvider */
                    /* JADX WARN: Multi-variable type inference failed */
                    public boolean onLongClick(View v) {
                        int position = helper.getAdapterPosition();
                        if (position == -1) {
                            return false;
                        }
                        int position2 = position - MultipleItemRvAdapter.this.getHeaderLayoutCount();
                        return ((BaseItemProvider) MultipleItemRvAdapter.this.mItemProviders.get(helper.getItemViewType())).onLongClick(helper, MultipleItemRvAdapter.this.mData.get(position2), position2);
                    }
                });
            }
        }
    }

    public void setMultiTypeDelegate(MultiTypeDelegate<T> multiTypeDelegate) {
        this.mMultiTypeDelegate = multiTypeDelegate;
    }

    public MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }
}
