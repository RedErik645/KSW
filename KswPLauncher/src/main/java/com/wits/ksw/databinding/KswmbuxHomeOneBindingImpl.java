package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.ug.UgHomeImageView;

public class KswmbuxHomeOneBindingImpl extends KswmbuxHomeOneBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback466;
    private final View.OnClickListener mCallback467;
    private final View.OnClickListener mCallback468;
    private long mDirtyFlags;
    private final TextView mboundView5;

    public KswmbuxHomeOneBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private KswmbuxHomeOneBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ConstraintLayout) bindings[0], (UgHomeImageView) bindings[4], (UgHomeImageView) bindings[1], (UgHomeImageView) bindings[3], (TextView) bindings[2]);
        this.mDirtyFlags = -1;
        this.carConstraintLayout.setTag(null);
        this.kswmbuxHomeBtVaiw.setTag(null);
        this.kswmbuxHomeMusicVaiw.setTag(null);
        this.kswmbuxHomeNaviVaiw.setTag(null);
        TextView textView = (TextView) bindings[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        this.tvMusic.setTag(null);
        setRootTag(root);
        this.mCallback468 = new OnClickListener(this, 3);
        this.mCallback467 = new OnClickListener(this, 2);
        this.mCallback466 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (36 != variableId) {
            return false;
        }
        setViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.KswmbuxHomeOneBinding
    public void setViewModel(LauncherViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelBtState((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> viewModelBtState = null;
        ObservableField<String> viewModelMediaInfoMusicName = null;
        String viewModelMediaInfoMusicNameGet = null;
        LauncherViewModel viewModel = this.mViewModel;
        boolean viewModelMediaInfoMusicNameJavaLangObjectNull = false;
        String viewModelBtStateGet = null;
        String viewModelMediaInfoMusicNameJavaLangObjectNullTvMusicAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = null;
        if ((dirtyFlags & 10) != 0) {
            MediaInfo viewModelMediaInfo = LauncherViewModel.mediaInfo;
            if (viewModelMediaInfo != null) {
                viewModelMediaInfoMusicName = viewModelMediaInfo.musicName;
            }
            boolean z = true;
            updateRegistration(1, viewModelMediaInfoMusicName);
            if (viewModelMediaInfoMusicName != null) {
                viewModelMediaInfoMusicNameGet = viewModelMediaInfoMusicName.get();
            }
            if (viewModelMediaInfoMusicNameGet != null) {
                z = false;
            }
            viewModelMediaInfoMusicNameJavaLangObjectNull = z;
            if ((dirtyFlags & 10) != 0) {
                dirtyFlags = viewModelMediaInfoMusicNameJavaLangObjectNull ? dirtyFlags | 32 : dirtyFlags | 16;
            }
        }
        if ((dirtyFlags & 13) != 0) {
            if (viewModel != null) {
                viewModelBtState = viewModel.btState;
            }
            updateRegistration(0, viewModelBtState);
            if (viewModelBtState != null) {
                viewModelBtStateGet = viewModelBtState.get();
            }
        }
        if ((dirtyFlags & 10) != 0) {
            viewModelMediaInfoMusicNameJavaLangObjectNullTvMusicAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = viewModelMediaInfoMusicNameJavaLangObjectNull ? this.tvMusic.getResources().getString(R.string.ksw_idf7_unkonw_soung) : viewModelMediaInfoMusicNameGet;
        }
        if ((8 & dirtyFlags) != 0) {
            this.kswmbuxHomeBtVaiw.setOnClickListener(this.mCallback468);
            this.kswmbuxHomeMusicVaiw.setOnClickListener(this.mCallback466);
            this.kswmbuxHomeNaviVaiw.setOnClickListener(this.mCallback467);
        }
        if ((dirtyFlags & 13) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, viewModelBtStateGet);
        }
        if ((dirtyFlags & 10) != 0) {
            TextViewBindingAdapter.setText(this.tvMusic, viewModelMediaInfoMusicNameJavaLangObjectNullTvMusicAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean viewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel viewModel = this.mViewModel;
                if (viewModel == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LauncherViewModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openBtApp(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
