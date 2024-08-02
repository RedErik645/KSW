package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.BcVieModel;

public class BenzMbuxMusicCardBindingHdpi1920x720Impl extends BenzMbuxMusicCardBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback551;
    private final View.OnClickListener mCallback552;
    private final View.OnClickListener mCallback553;
    private final View.OnClickListener mCallback554;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final AppCompatImageView mboundView2;
    private final AppCompatImageView mboundView5;
    private final AppCompatImageView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.benz_mbux_local_card_title, 7);
    }

    public BenzMbuxMusicCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private BenzMbuxMusicCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (FrameLayout) bindings[1], (AppCompatTextView) bindings[4], (AppCompatTextView) bindings[7], (AppCompatImageView) bindings[3]);
        this.mDirtyFlags = -1;
        this.benzMbuxLocalCardBg.setTag(null);
        this.benzMbuxLocalCardContent.setTag(null);
        this.benzMbuxLocalMusicCardBg.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) bindings[2];
        this.mboundView2 = appCompatImageView;
        appCompatImageView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) bindings[5];
        this.mboundView5 = appCompatImageView2;
        appCompatImageView2.setTag(null);
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) bindings[6];
        this.mboundView6 = appCompatImageView3;
        appCompatImageView3.setTag(null);
        setRootTag(root);
        this.mCallback552 = new OnClickListener(this, 2);
        this.mCallback554 = new OnClickListener(this, 4);
        this.mCallback551 = new OnClickListener(this, 1);
        this.mCallback553 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (25 != variableId) {
            return false;
        }
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzMbuxMusicCardBinding
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelMediaInfoSongInfo((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelMediaInfoPicZoom((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelMediaInfoSongInfo(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoPicZoom(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE;
        int viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE2;
        String viewModelMediaInfoSongInfoJavaLangObjectNullBenzMbuxLocalCardContentAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo;
        ObservableBoolean viewModelItemIconClassical;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BcVieModel viewModel = this.mViewModel;
        Drawable viewModelItemIconClassicalBenzMbuxLocalMusicCardBgAndroidDrawableBenzMbux2021KswHomeMusicSelector1BenzMbuxLocalMusicCardBgAndroidDrawableBenzMbux2021KswHomeMusicSelector2 = null;
        BitmapDrawable viewModelMediaInfoPicZoomGet = null;
        ObservableField<String> viewModelMediaInfoSongInfo = null;
        ObservableField<BitmapDrawable> viewModelMediaInfoPicZoom = null;
        String viewModelMediaInfoSongInfoGet = null;
        boolean viewModelMediaInfoSongInfoJavaLangObjectNull = false;
        int viewModelMediaInfoPicZoomJavaLangObjectNullViewVISIBLEViewGONE = 0;
        boolean viewModelItemIconClassicalGet = false;
        if ((dirtyFlags & 28) != 0) {
            if (viewModel != null) {
                viewModelItemIconClassical = viewModel.itemIconClassical;
            } else {
                viewModelItemIconClassical = null;
            }
            updateRegistration(2, viewModelItemIconClassical);
            if (viewModelItemIconClassical != null) {
                viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
            }
            if ((dirtyFlags & 28) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if (viewModelItemIconClassicalGet) {
                viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE = 0;
                drawable = AppCompatResources.getDrawable(this.benzMbuxLocalMusicCardBg.getContext(), R.drawable.benz_mbux_2021_ksw_home_music_selector1);
            } else {
                viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE = 0;
                drawable = AppCompatResources.getDrawable(this.benzMbuxLocalMusicCardBg.getContext(), R.drawable.benz_mbux_2021_ksw_home_music_selector2);
            }
            viewModelItemIconClassicalBenzMbuxLocalMusicCardBgAndroidDrawableBenzMbux2021KswHomeMusicSelector1BenzMbuxLocalMusicCardBgAndroidDrawableBenzMbux2021KswHomeMusicSelector2 = drawable;
        } else {
            viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE = 0;
        }
        if ((19 & dirtyFlags) != 0) {
            MediaInfo viewModelMediaInfo = BcVieModel.mediaInfo;
            boolean viewModelMediaInfoPicZoomJavaLangObjectNull = true;
            int i = 0;
            if ((dirtyFlags & 17) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoSongInfo = viewModelMediaInfo.songInfo;
                }
                updateRegistration(0, viewModelMediaInfoSongInfo);
                if (viewModelMediaInfoSongInfo != null) {
                    viewModelMediaInfoSongInfoGet = viewModelMediaInfoSongInfo.get();
                }
                viewModelMediaInfoSongInfoJavaLangObjectNull = viewModelMediaInfoSongInfoGet == null;
                if ((dirtyFlags & 17) != 0) {
                    if (viewModelMediaInfoSongInfoJavaLangObjectNull) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                }
            }
            if ((dirtyFlags & 18) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoPicZoom = viewModelMediaInfo.picZoom;
                }
                updateRegistration(1, viewModelMediaInfoPicZoom);
                if (viewModelMediaInfoPicZoom != null) {
                    viewModelMediaInfoPicZoomGet = viewModelMediaInfoPicZoom.get();
                }
                if (viewModelMediaInfoPicZoomGet != null) {
                    viewModelMediaInfoPicZoomJavaLangObjectNull = false;
                }
                if ((dirtyFlags & 18) != 0) {
                    if (viewModelMediaInfoPicZoomJavaLangObjectNull) {
                        dirtyFlags = dirtyFlags | 64 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags = dirtyFlags | 32 | 512;
                    }
                }
                int viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE3 = viewModelMediaInfoPicZoomJavaLangObjectNull ? 8 : 0;
                if (!viewModelMediaInfoPicZoomJavaLangObjectNull) {
                    i = 8;
                }
                viewModelMediaInfoPicZoomJavaLangObjectNullViewVISIBLEViewGONE = i;
                viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE3;
            } else {
                viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE;
            }
        } else {
            viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE;
        }
        if ((dirtyFlags & 17) != 0) {
            viewModelMediaInfoSongInfoJavaLangObjectNullBenzMbuxLocalCardContentAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = viewModelMediaInfoSongInfoJavaLangObjectNull ? this.benzMbuxLocalCardContent.getResources().getString(R.string.ksw_idf7_unkonw_soung) : viewModelMediaInfoSongInfoGet;
        } else {
            viewModelMediaInfoSongInfoJavaLangObjectNullBenzMbuxLocalCardContentAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = null;
        }
        if ((dirtyFlags & 16) != 0) {
            this.benzMbuxLocalCardBg.setOnClickListener(this.mCallback551);
            this.benzMbuxLocalMusicCardBg.setOnClickListener(this.mCallback552);
            this.mboundView5.setOnClickListener(this.mCallback553);
            this.mboundView6.setOnClickListener(this.mCallback554);
        }
        if ((18 & dirtyFlags) != 0) {
            this.benzMbuxLocalCardBg.setVisibility(viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE2);
            this.benzMbuxLocalMusicCardBg.setVisibility(viewModelMediaInfoPicZoomJavaLangObjectNullViewVISIBLEViewGONE);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelMediaInfoPicZoomGet);
            this.mboundView2.setVisibility(viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE2);
        }
        if ((dirtyFlags & 17) != 0) {
            TextViewBindingAdapter.setText(this.benzMbuxLocalCardContent, viewModelMediaInfoSongInfoJavaLangObjectNullBenzMbuxLocalCardContentAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo);
        }
        if ((dirtyFlags & 28) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.benzMbuxLocalMusicCardBg, viewModelItemIconClassicalBenzMbuxLocalMusicCardBgAndroidDrawableBenzMbux2021KswHomeMusicSelector1BenzMbuxLocalMusicCardBgAndroidDrawableBenzMbux2021KswHomeMusicSelector2);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean viewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                BcVieModel viewModel = this.mViewModel;
                if (viewModel == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 2:
                BcVieModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 3:
                BcVieModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.btnMusicPrev();
                    return;
                }
                return;
            case 4:
                BcVieModel viewModel4 = this.mViewModel;
                if (viewModel4 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel4.btnMusicNext();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
