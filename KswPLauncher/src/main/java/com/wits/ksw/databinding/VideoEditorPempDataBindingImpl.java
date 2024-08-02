package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class VideoEditorPempDataBindingImpl extends VideoEditorPempDataBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout, 2);
    }

    public VideoEditorPempDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private VideoEditorPempDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RelativeLayout) bindings[2]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        setRootTag(root);
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
        if (16 != variableId) {
            return false;
        }
        setMediaViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.VideoEditorPempDataBinding
    public void setMediaViewModel(LauncherViewModel MediaViewModel) {
        this.mMediaViewModel = MediaViewModel;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeMediaViewModelBThirdVideo((ObservableField) object, fieldId);
            case 1:
                return onChangeMediaViewModelMediaInfoVideoPlay((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeMediaViewModelBThirdVideo(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoVideoPlay(ObservableField<Boolean> observableField, int fieldId) {
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
        Boolean mediaViewModelBThirdVideoGet = null;
        Boolean mediaViewModelMediaInfoVideoPlayGet = null;
        ObservableField<Boolean> mediaViewModelMediaInfoVideoPlay = null;
        int mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE = 0;
        Drawable mediaViewModelMediaInfoVideoPlayMboundView1AndroidDrawablePempId8MainEditIconVideoPauseMboundView1AndroidDrawablePempId8MainEditIconVideoPlay = null;
        if ((dirtyFlags & 9) != 0) {
            ObservableField<Boolean> mediaViewModelBThirdVideo = LauncherViewModel.bThirdVideo;
            int i = 0;
            updateRegistration(0, mediaViewModelBThirdVideo);
            if (mediaViewModelBThirdVideo != null) {
                mediaViewModelBThirdVideoGet = mediaViewModelBThirdVideo.get();
            }
            boolean mediaViewModelBThirdVideoBooleanTrue = ViewDataBinding.safeUnbox(mediaViewModelBThirdVideoGet);
            if ((dirtyFlags & 9) != 0) {
                if (mediaViewModelBThirdVideoBooleanTrue) {
                    dirtyFlags |= 32;
                } else {
                    dirtyFlags |= 16;
                }
            }
            if (mediaViewModelBThirdVideoBooleanTrue) {
                i = 8;
            }
            mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE = i;
        }
        if ((dirtyFlags & 10) != 0) {
            MediaInfo mediaViewModelMediaInfo = LauncherViewModel.mediaInfo;
            if (mediaViewModelMediaInfo != null) {
                mediaViewModelMediaInfoVideoPlay = mediaViewModelMediaInfo.videoPlay;
            }
            updateRegistration(1, mediaViewModelMediaInfoVideoPlay);
            if (mediaViewModelMediaInfoVideoPlay != null) {
                mediaViewModelMediaInfoVideoPlayGet = mediaViewModelMediaInfoVideoPlay.get();
            }
            boolean androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoVideoPlayGet = ViewDataBinding.safeUnbox(mediaViewModelMediaInfoVideoPlayGet);
            if ((dirtyFlags & 10) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoVideoPlayGet) {
                    dirtyFlags |= 128;
                } else {
                    dirtyFlags |= 64;
                }
            }
            mediaViewModelMediaInfoVideoPlayMboundView1AndroidDrawablePempId8MainEditIconVideoPauseMboundView1AndroidDrawablePempId8MainEditIconVideoPlay = AppCompatResources.getDrawable(this.mboundView1.getContext(), androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoVideoPlayGet ? R.drawable.pemp_id8_main_edit_icon_video_pause : R.drawable.pemp_id8_main_edit_icon_video_play);
        }
        if ((dirtyFlags & 10) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView1, mediaViewModelMediaInfoVideoPlayMboundView1AndroidDrawablePempId8MainEditIconVideoPauseMboundView1AndroidDrawablePempId8MainEditIconVideoPlay);
        }
        if ((dirtyFlags & 9) != 0) {
            this.mboundView1.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
        }
    }
}
