package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomBmwMusicLayout;

public class Id7SubMusicViewBindingImpl extends Id7SubMusicViewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback250;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.nameImageView, 10);
        sparseIntArray.put(R.id.artistImageView, 11);
        sparseIntArray.put(R.id.albumImageView, 12);
    }

    public Id7SubMusicViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private Id7SubMusicViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (ImageView) bindings[12], (TextView) bindings[7], (ImageView) bindings[11], (TextView) bindings[6], (TextView) bindings[8], (CustomBmwMusicLayout) bindings[1], (ImageView) bindings[3], (ConstraintLayout) bindings[0], (ImageView) bindings[2], (ImageView) bindings[10], (TextView) bindings[5], (SeekBar) bindings[4], (TextView) bindings[9]);
        this.mDirtyFlags = -1;
        this.albumTextView.setTag(null);
        this.artistTextView.setTag(null);
        this.currentTimeTextView.setTag(null);
        this.imageFrameLayout.setTag(null);
        this.imageView6.setTag(null);
        this.musicConstraintLayout.setTag(null);
        this.musicImageView.setTag(null);
        this.nameTextView.setTag(null);
        this.seekBar.setTag(null);
        this.totalTimeTextView.setTag(null);
        setRootTag(root);
        this.mCallback250 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
        }
        requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (16 != variableId) {
            return false;
        }
        setMediaViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Id7SubMusicViewBinding
    public void setMediaViewModel(LauncherViewModel MediaViewModel) {
        this.mMediaViewModel = MediaViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeMediaViewModelMediaInfoPic((ObservableField) object, fieldId);
            case 1:
                return onChangeMediaViewModelMediaInfoMusicAlbum((ObservableField) object, fieldId);
            case 2:
                return onChangeMediaViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            case 3:
                return onChangeMediaViewModelMediaInfoMusicAtist((ObservableField) object, fieldId);
            case 4:
                return onChangeMediaViewModelMediaInfoTotalTime((ObservableField) object, fieldId);
            case 5:
                return onChangeMediaViewModelMediaInfoProgress((ObservableInt) object, fieldId);
            case 6:
                return onChangeMediaViewModelMediaInfoCurrentTime((ObservableField) object, fieldId);
            case 7:
                return onChangeMediaViewModelMediaInfoMaxProgress((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeMediaViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoMusicAlbum(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoTotalTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoProgress(ObservableInt MediaViewModelMediaInfoProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoCurrentTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoMaxProgress(ObservableInt MediaViewModelMediaInfoMaxProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 761
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.Id7SubMusicViewBindingImpl.executeBindings():void");
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel mediaViewModel = this.mMediaViewModel;
        if (mediaViewModel != null) {
            mediaViewModel.openMusicMulti(callbackArg_0);
        }
    }
}
