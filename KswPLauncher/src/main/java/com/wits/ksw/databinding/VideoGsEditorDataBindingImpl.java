package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class VideoGsEditorDataBindingImpl extends VideoGsEditorDataBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final ProgressBar mboundView6;
    private final LinearLayout mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id8_gs_video_edit, 10);
        sparseIntArray.put(R.id.gs_id8_icon_edit_bg, 11);
    }

    public VideoGsEditorDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private VideoGsEditorDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (ImageView) bindings[11], (ImageView) bindings[10], (TextView) bindings[5], (TextView) bindings[8], (TextView) bindings[9], (ImageView) bindings[4], (ImageView) bindings[3], (ImageView) bindings[2]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[6];
        this.mboundView6 = progressBar;
        progressBar.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[7];
        this.mboundView7 = linearLayout;
        linearLayout.setTag(null);
        this.tvSongTitle.setTag(null);
        this.tvStrTime.setTag(null);
        this.tvTotalTime.setTag(null);
        this.videoId8GsNext.setTag(null);
        this.videoId8GsPlayPause.setTag(null);
        this.videoId8GsPrev.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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

    @Override // com.wits.ksw.databinding.VideoGsEditorDataBinding
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
            case 2:
                return onChangeMediaViewModelMediaInfoProgressPercentVideo((ObservableInt) object, fieldId);
            case 3:
                return onChangeMediaViewModelMediaInfoCurrentTimeVideo((ObservableField) object, fieldId);
            case 4:
                return onChangeMediaViewModelMediaInfoTotalTimeVideo((ObservableField) object, fieldId);
            case 5:
                return onChangeMediaViewModelMediaInfoVideoName((ObservableField) object, fieldId);
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

    private boolean onChangeMediaViewModelMediaInfoProgressPercentVideo(ObservableInt MediaViewModelMediaInfoProgressPercentVideo, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoCurrentTimeVideo(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoTotalTimeVideo(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoVideoName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int mediaViewModelMediaInfoProgressPercentVideoGet;
        Drawable mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN;
        String mediaViewModelMediaInfoVideoNameJavaLangObjectNullTvSongTitleAndroidStringUnkonwMediaViewModelMediaInfoVideoName;
        ObservableField<String> mediaViewModelMediaInfoVideoName;
        ObservableField<String> mediaViewModelMediaInfoTotalTimeVideo;
        ObservableField<String> mediaViewModelMediaInfoCurrentTimeVideo;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean mediaViewModelBThirdVideoBooleanTrue = false;
        boolean mediaViewModelMediaInfoVideoNameJavaLangObjectNull = false;
        String mediaViewModelMediaInfoTotalTimeVideoGet = null;
        Boolean mediaViewModelBThirdVideoGet = null;
        String mediaViewModelMediaInfoCurrentTimeVideoGet = null;
        int mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE = 0;
        ObservableField<Boolean> mediaViewModelMediaInfoVideoPlay = null;
        ObservableInt mediaViewModelMediaInfoProgressPercentVideo = null;
        String mediaViewModelMediaInfoVideoNameGet = null;
        Drawable mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN2 = null;
        Boolean mediaViewModelMediaInfoVideoPlayGet = null;
        int mediaViewModelMediaInfoProgressPercentVideoGet2 = 0;
        if ((dirtyFlags & 129) != 0) {
            ObservableField<Boolean> mediaViewModelBThirdVideo = LauncherViewModel.bThirdVideo;
            updateRegistration(0, mediaViewModelBThirdVideo);
            if (mediaViewModelBThirdVideo != null) {
                mediaViewModelBThirdVideoGet = mediaViewModelBThirdVideo.get();
            }
            mediaViewModelBThirdVideoBooleanTrue = ViewDataBinding.safeUnbox(mediaViewModelBThirdVideoGet);
            if ((dirtyFlags & 129) != 0) {
                if (mediaViewModelBThirdVideoBooleanTrue) {
                    dirtyFlags |= 512;
                } else {
                    dirtyFlags |= 256;
                }
            }
            mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE = mediaViewModelBThirdVideoBooleanTrue ? 8 : 0;
        }
        if ((dirtyFlags & 190) != 0) {
            MediaInfo mediaViewModelMediaInfo = LauncherViewModel.mediaInfo;
            if ((dirtyFlags & 130) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoVideoPlay = mediaViewModelMediaInfo.videoPlay;
                }
                updateRegistration(1, mediaViewModelMediaInfoVideoPlay);
                if (mediaViewModelMediaInfoVideoPlay != null) {
                    mediaViewModelMediaInfoVideoPlayGet = mediaViewModelMediaInfoVideoPlay.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoVideoPlayGet = ViewDataBinding.safeUnbox(mediaViewModelMediaInfoVideoPlayGet);
                if ((dirtyFlags & 130) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoVideoPlayGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                }
                mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN2 = androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoVideoPlayGet ? AppCompatResources.getDrawable(this.videoId8GsPlayPause.getContext(), R.drawable.gs_id8_main_icon_music_btn_pause_n) : AppCompatResources.getDrawable(this.videoId8GsPlayPause.getContext(), R.drawable.gs_id8_main_icon_music_btn_play_n);
            }
            if ((dirtyFlags & 132) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoProgressPercentVideo = mediaViewModelMediaInfo.progressPercentVideo;
                }
                updateRegistration(2, mediaViewModelMediaInfoProgressPercentVideo);
                if (mediaViewModelMediaInfoProgressPercentVideo != null) {
                    mediaViewModelMediaInfoProgressPercentVideoGet2 = mediaViewModelMediaInfoProgressPercentVideo.get();
                }
            }
            if ((dirtyFlags & 136) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoCurrentTimeVideo = mediaViewModelMediaInfo.currentTimeVideo;
                } else {
                    mediaViewModelMediaInfoCurrentTimeVideo = null;
                }
                updateRegistration(3, mediaViewModelMediaInfoCurrentTimeVideo);
                if (mediaViewModelMediaInfoCurrentTimeVideo != null) {
                    mediaViewModelMediaInfoCurrentTimeVideoGet = mediaViewModelMediaInfoCurrentTimeVideo.get();
                }
            }
            if ((dirtyFlags & 144) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoTotalTimeVideo = mediaViewModelMediaInfo.totalTimeVideo;
                } else {
                    mediaViewModelMediaInfoTotalTimeVideo = null;
                }
                updateRegistration(4, mediaViewModelMediaInfoTotalTimeVideo);
                if (mediaViewModelMediaInfoTotalTimeVideo != null) {
                    mediaViewModelMediaInfoTotalTimeVideoGet = mediaViewModelMediaInfoTotalTimeVideo.get();
                }
            }
            if ((dirtyFlags & 160) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoVideoName = mediaViewModelMediaInfo.videoName;
                } else {
                    mediaViewModelMediaInfoVideoName = null;
                }
                updateRegistration(5, mediaViewModelMediaInfoVideoName);
                if (mediaViewModelMediaInfoVideoName != null) {
                    mediaViewModelMediaInfoVideoNameGet = mediaViewModelMediaInfoVideoName.get();
                }
                mediaViewModelMediaInfoVideoNameJavaLangObjectNull = mediaViewModelMediaInfoVideoNameGet == null;
                if ((dirtyFlags & 160) == 0) {
                    mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN = mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN2;
                    mediaViewModelMediaInfoProgressPercentVideoGet = mediaViewModelMediaInfoProgressPercentVideoGet2;
                } else if (mediaViewModelMediaInfoVideoNameJavaLangObjectNull) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN = mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN2;
                    mediaViewModelMediaInfoProgressPercentVideoGet = mediaViewModelMediaInfoProgressPercentVideoGet2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN = mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN2;
                    mediaViewModelMediaInfoProgressPercentVideoGet = mediaViewModelMediaInfoProgressPercentVideoGet2;
                }
            } else {
                mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN = mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN2;
                mediaViewModelMediaInfoProgressPercentVideoGet = mediaViewModelMediaInfoProgressPercentVideoGet2;
            }
        } else {
            mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN = null;
            mediaViewModelMediaInfoProgressPercentVideoGet = 0;
        }
        if ((dirtyFlags & 160) != 0) {
            mediaViewModelMediaInfoVideoNameJavaLangObjectNullTvSongTitleAndroidStringUnkonwMediaViewModelMediaInfoVideoName = mediaViewModelMediaInfoVideoNameJavaLangObjectNull ? this.tvSongTitle.getResources().getString(R.string.unkonw) : mediaViewModelMediaInfoVideoNameGet;
        } else {
            mediaViewModelMediaInfoVideoNameJavaLangObjectNullTvSongTitleAndroidStringUnkonwMediaViewModelMediaInfoVideoName = null;
        }
        if ((dirtyFlags & 129) != 0) {
            this.mboundView1.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
            this.mboundView6.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
            this.mboundView7.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
            this.tvSongTitle.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
            this.videoId8GsNext.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
            this.videoId8GsPlayPause.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
            this.videoId8GsPrev.setVisibility(mediaViewModelBThirdVideoBooleanTrueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 132) != 0) {
            this.mboundView6.setProgress(mediaViewModelMediaInfoProgressPercentVideoGet);
        }
        if ((dirtyFlags & 160) != 0) {
            TextViewBindingAdapter.setText(this.tvSongTitle, mediaViewModelMediaInfoVideoNameJavaLangObjectNullTvSongTitleAndroidStringUnkonwMediaViewModelMediaInfoVideoName);
        }
        if ((dirtyFlags & 136) != 0) {
            TextViewBindingAdapter.setText(this.tvStrTime, mediaViewModelMediaInfoCurrentTimeVideoGet);
        }
        if ((dirtyFlags & 144) != 0) {
            TextViewBindingAdapter.setText(this.tvTotalTime, mediaViewModelMediaInfoTotalTimeVideoGet);
        }
        if ((dirtyFlags & 130) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.videoId8GsPlayPause, mediaViewModelMediaInfoVideoPlayVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPauseNVideoId8GsPlayPauseAndroidDrawableGsId8MainIconMusicBtnPlayN);
        }
    }
}
