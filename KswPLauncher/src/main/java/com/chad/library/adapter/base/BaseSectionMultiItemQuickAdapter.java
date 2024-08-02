package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import java.util.List;

public abstract class BaseSectionMultiItemQuickAdapter<T extends SectionMultiEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    protected static final int SECTION_HEADER_VIEW = 1092;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;
    protected int mSectionHeadResId;

    /* access modifiers changed from: protected */
    public abstract void convertHead(K k, T t);

    public BaseSectionMultiItemQuickAdapter(int sectionHeadResId, List<T> data) {
        super(data);
        this.mSectionHeadResId = sectionHeadResId;
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        SectionMultiEntity sectionMultiEntity = (SectionMultiEntity) this.mData.get(position);
        if (sectionMultiEntity != null) {
            return sectionMultiEntity.isHeader ? SECTION_HEADER_VIEW : sectionMultiEntity.getItemType();
        }
        return DEFAULT_VIEW_TYPE;
    }

    /* access modifiers changed from: protected */
    public void setDefaultViewTypeLayout(int layoutResId) {
        addItemType(DEFAULT_VIEW_TYPE, layoutResId);
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SECTION_HEADER_VIEW) {
            return createBaseViewHolder(getItemView(this.mSectionHeadResId, parent));
        }
        return createBaseViewHolder(parent, getLayoutId(viewType));
    }

    private int getLayoutId(int viewType) {
        return this.layouts.get(viewType, -404);
    }

    /* access modifiers changed from: protected */
    public void addItemType(int type, int layoutResId) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(type, layoutResId);
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int type) {
        return super.isFixedViewType(type) || type == SECTION_HEADER_VIEW;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter<T extends com.chad.library.adapter.base.entity.SectionMultiEntity, K extends com.chad.library.adapter.base.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(K holder, int position) {
        switch (holder.getItemViewType()) {
            case SECTION_HEADER_VIEW /*{ENCODED_INT: 1092}*/:
                setFullSpan(holder);
                convertHead(holder, (SectionMultiEntity) getItem(position - getHeaderLayoutCount()));
                return;
            default:
                super.onBindViewHolder((BaseViewHolder) holder, position);
                return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter<T extends com.chad.library.adapter.base.entity.SectionMultiEntity, K extends com.chad.library.adapter.base.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(int position) {
        if (this.mData != null && position >= 0 && position < this.mData.size()) {
            SectionMultiEntity sectionMultiEntity = (SectionMultiEntity) this.mData.get(position);
            if (sectionMultiEntity instanceof IExpandable) {
                removeAllChild((IExpandable) sectionMultiEntity, position);
            }
            removeDataFromParent(sectionMultiEntity);
            super.remove(position);
        }
    }

    /* access modifiers changed from: protected */
    public void removeAllChild(IExpandable parent, int parentPosition) {
        List<MultiItemEntity> chidChilds;
        if (!(!parent.isExpanded() || (chidChilds = parent.getSubItems()) == null || chidChilds.size() == 0)) {
            int childSize = chidChilds.size();
            for (int i = 0; i < childSize; i++) {
                remove(parentPosition + 1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeDataFromParent(T child) {
        int position = getParentPosition(child);
        if (position >= 0) {
            ((IExpandable) this.mData.get(position)).getSubItems().remove(child);
        }
    }
}
