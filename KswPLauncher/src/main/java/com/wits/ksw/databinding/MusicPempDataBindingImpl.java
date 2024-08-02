package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomizeSeekBar;
import com.wits.ksw.launcher.view.MarqueeTextView;

public class MusicPempDataBindingImpl extends MusicPempDataBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback128;
    private final View.OnClickListener mCallback129;
    private final View.OnClickListener mCallback130;
    private final View.OnClickListener mCallback131;
    private long mDirtyFlags;
    private final ImageView mboundView3;
    private final CustomizeSeekBar mboundView4;
    private final RelativeLayout mboundView7;

    public MusicPempDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private MusicPempDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (ImageView) bindings[1], (ImageView) bindings[2], (RelativeLayout) bindings[0], (ImageView) bindings[10], (ImageView) bindings[9], (ImageView) bindings[8], (TextView) bindings[6], (MarqueeTextView) bindings[5]);
        this.mDirtyFlags = -1;
        this.ivMask.setTag(null);
        this.ivMusicAlbum.setTag(null);
        this.llContainer.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        CustomizeSeekBar customizeSeekBar = (CustomizeSeekBar) bindings[4];
        this.mboundView4 = customizeSeekBar;
        customizeSeekBar.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[7];
        this.mboundView7 = relativeLayout;
        relativeLayout.setTag(null);
        this.pempId8MusicNext.setTag(null);
        this.pempId8MusicPlay.setTag(null);
        this.pempId8MusicPrev.setTag(null);
        this.tvSinger.setTag(null);
        this.tvSongTitle.setTag(null);
        setRootTag(root);
        this.mCallback128 = new OnClickListener(this, 1);
        this.mCallback130 = new OnClickListener(this, 3);
        this.mCallback129 = new OnClickListener(this, 2);
        this.mCallback131 = new OnClickListener(this, 4);
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

    @Override // com.wits.ksw.databinding.MusicPempDataBinding
    public void setMediaViewModel(LauncherViewModel MediaViewModel) {
        this.mMediaViewModel = MediaViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
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
                return onChangeMediaViewModelMediaInfoProgressPercent((ObservableInt) object, fieldId);
            case 2:
                return onChangeMediaViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            case 3:
                return onChangeMediaViewModelBThirdMusic((ObservableField) object, fieldId);
            case 4:
                return onChangeMediaViewModelMediaInfoMusicAtist((ObservableField) object, fieldId);
            case 5:
                return onChangeMediaViewModelMediaInfoMusicPlay((ObservableField) object, fieldId);
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

    private boolean onChangeMediaViewModelMediaInfoProgressPercent(ObservableInt MediaViewModelMediaInfoProgressPercent, int fieldId) {
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

    private boolean onChangeMediaViewModelBThirdMusic(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeMediaViewModelMediaInfoMusicPlay(ObservableField<Boolean> observableField, int fieldId) {
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
        Boolean mediaViewModelBThirdMusicGet;
        BitmapDrawable mediaViewModelMediaInfoPicGet;
        int mediaViewModelMediaInfoProgressPercentGet;
        Drawable mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN;
        String mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName;
        int mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE;
        View.OnFocusChangeListener mediaViewModelMusicViewFocusChangeListener;
        String mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName2;
        ObservableField<Boolean> mediaViewModelMediaInfoMusicPlay;
        long dirtyFlags2;
        int i;
        Context context;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<BitmapDrawable> mediaViewModelMediaInfoPic = null;
        ObservableInt mediaViewModelMediaInfoProgressPercent = null;
        MediaInfo mediaViewModelMediaInfo = null;
        ObservableField<String> mediaViewModelMediaInfoMusicName = null;
        String mediaViewModelMediaInfoMusicAtistJavaLangObjectNullTvSingerAndroidStringKswIdf7UnknowArtisMediaViewModelMediaInfoMusicAtist = null;
        ObservableField<String> mediaViewModelMediaInfoMusicAtist = null;
        String mediaViewModelMediaInfoMusicNameGet = null;
        int mediaViewModelMediaInfoProgressPercentGet2 = 0;
        boolean mediaViewModelMediaInfoMusicAtistJavaLangObjectNull = false;
        BitmapDrawable mediaViewModelMediaInfoPicGet2 = null;
        Boolean mediaViewModelMediaInfoMusicPlayGet = null;
        String mediaViewModelMediaInfoMusicAtistGet = null;
        boolean mediaViewModelMediaInfoMusicNameJavaLangObjectNull = false;
        LauncherViewModel mediaViewModel = this.mMediaViewModel;
        if ((dirtyFlags & 183) != 0) {
            mediaViewModelMediaInfo = LauncherViewModel.mediaInfo;
            if ((dirtyFlags & 129) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoPic = mediaViewModelMediaInfo.pic;
                }
                updateRegistration(0, mediaViewModelMediaInfoPic);
                if (mediaViewModelMediaInfoPic != null) {
                    mediaViewModelMediaInfoPicGet2 = mediaViewModelMediaInfoPic.get();
                }
            }
            if ((dirtyFlags & 130) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoProgressPercent = mediaViewModelMediaInfo.progressPercent;
                }
                updateRegistration(1, mediaViewModelMediaInfoProgressPercent);
                if (mediaViewModelMediaInfoProgressPercent != null) {
                    mediaViewModelMediaInfoProgressPercentGet2 = mediaViewModelMediaInfoProgressPercent.get();
                }
            }
            if ((dirtyFlags & 132) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoMusicName = mediaViewModelMediaInfo.musicName;
                }
                updateRegistration(2, mediaViewModelMediaInfoMusicName);
                if (mediaViewModelMediaInfoMusicName != null) {
                    mediaViewModelMediaInfoMusicNameGet = mediaViewModelMediaInfoMusicName.get();
                }
                boolean mediaViewModelMediaInfoMusicNameJavaLangObjectNull2 = mediaViewModelMediaInfoMusicNameGet == null;
                if ((dirtyFlags & 132) == 0) {
                    mediaViewModelMediaInfoMusicNameJavaLangObjectNull = mediaViewModelMediaInfoMusicNameJavaLangObjectNull2;
                } else if (mediaViewModelMediaInfoMusicNameJavaLangObjectNull2) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    mediaViewModelMediaInfoMusicNameJavaLangObjectNull = mediaViewModelMediaInfoMusicNameJavaLangObjectNull2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    mediaViewModelMediaInfoMusicNameJavaLangObjectNull = mediaViewModelMediaInfoMusicNameJavaLangObjectNull2;
                }
            }
            if ((dirtyFlags & 144) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoMusicAtist = mediaViewModelMediaInfo.musicAtist;
                }
                updateRegistration(4, mediaViewModelMediaInfoMusicAtist);
                if (mediaViewModelMediaInfoMusicAtist != null) {
                    mediaViewModelMediaInfoMusicAtistGet = mediaViewModelMediaInfoMusicAtist.get();
                }
                boolean mediaViewModelMediaInfoMusicAtistJavaLangObjectNull2 = mediaViewModelMediaInfoMusicAtistGet == null;
                if ((dirtyFlags & 144) == 0) {
                    mediaViewModelMediaInfoMusicAtistJavaLangObjectNull = mediaViewModelMediaInfoMusicAtistJavaLangObjectNull2;
                } else if (mediaViewModelMediaInfoMusicAtistJavaLangObjectNull2) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    mediaViewModelMediaInfoMusicAtistJavaLangObjectNull = mediaViewModelMediaInfoMusicAtistJavaLangObjectNull2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    mediaViewModelMediaInfoMusicAtistJavaLangObjectNull = mediaViewModelMediaInfoMusicAtistJavaLangObjectNull2;
                }
            }
            if ((dirtyFlags & 160) != 0) {
                if (mediaViewModelMediaInfo != null) {
                    mediaViewModelMediaInfoMusicPlay = mediaViewModelMediaInfo.musicPlay;
                } else {
                    mediaViewModelMediaInfoMusicPlay = null;
                }
                updateRegistration(5, mediaViewModelMediaInfoMusicPlay);
                if (mediaViewModelMediaInfoMusicPlay != null) {
                    mediaViewModelMediaInfoMusicPlayGet = mediaViewModelMediaInfoMusicPlay.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoMusicPlayGet = ViewDataBinding.safeUnbox(mediaViewModelMediaInfoMusicPlayGet);
                if ((dirtyFlags & 160) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoMusicPlayGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoMusicPlayGet) {
                    context = this.pempId8MusicPlay.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.pemp_id8_main_icon_music_btn_pause_n;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.pempId8MusicPlay.getContext();
                    i = R.drawable.pemp_id8_main_icon_music_btn_play_n;
                }
                mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN = AppCompatResources.getDrawable(context, i);
                dirtyFlags = dirtyFlags2;
                mediaViewModelMediaInfoProgressPercentGet = mediaViewModelMediaInfoProgressPercentGet2;
                mediaViewModelBThirdMusicGet = null;
                mediaViewModelMediaInfoPicGet = mediaViewModelMediaInfoPicGet2;
            } else {
                mediaViewModelMediaInfoProgressPercentGet = mediaViewModelMediaInfoProgressPercentGet2;
                mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN = null;
                mediaViewModelBThirdMusicGet = null;
                mediaViewModelMediaInfoPicGet = mediaViewModelMediaInfoPicGet2;
            }
        } else {
            mediaViewModelMediaInfoProgressPercentGet = 0;
            mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN = null;
            mediaViewModelBThirdMusicGet = null;
            mediaViewModelMediaInfoPicGet = null;
        }
        if ((dirtyFlags & 136) != 0) {
            ObservableField<Boolean> mediaViewModelBThirdMusic = LauncherViewModel.bThirdMusic;
            updateRegistration(3, mediaViewModelBThirdMusic);
            if (mediaViewModelBThirdMusic != null) {
                mediaViewModelBThirdMusicGet = mediaViewModelBThirdMusic.get();
            }
            mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName = null;
            boolean mediaViewModelBThirdMusicBooleanTrue = true;
            if (!ViewDataBinding.safeUnbox(mediaViewModelBThirdMusicGet)) {
                mediaViewModelBThirdMusicBooleanTrue = false;
            }
            if ((dirtyFlags & 136) != 0) {
                if (mediaViewModelBThirdMusicBooleanTrue) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                }
            }
            mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = mediaViewModelBThirdMusicBooleanTrue ? 8 : 0;
        } else {
            mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName = null;
            mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = 0;
        }
        if ((dirtyFlags & 192) == 0 || mediaViewModel == null) {
            mediaViewModelMusicViewFocusChangeListener = null;
        } else {
            mediaViewModelMusicViewFocusChangeListener = mediaViewModel.musicViewFocusChangeListener;
        }
        if ((dirtyFlags & 132) != 0) {
            mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName2 = mediaViewModelMediaInfoMusicNameJavaLangObjectNull ? this.tvSongTitle.getResources().getString(R.string.ksw_idf7_unkonw_soung) : mediaViewModelMediaInfoMusicNameGet;
        } else {
            mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName2 = mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName;
        }
        if ((dirtyFlags & 144) != 0) {
            mediaViewModelMediaInfoMusicAtistJavaLangObjectNullTvSingerAndroidStringKswIdf7UnknowArtisMediaViewModelMediaInfoMusicAtist = mediaViewModelMediaInfoMusicAtistJavaLangObjectNull ? this.tvSinger.getResources().getString(R.string.ksw_idf7_unknow_artis) : mediaViewModelMediaInfoMusicAtistGet;
        }
        if ((128 & dirtyFlags) != 0) {
            this.ivMask.setOnClickListener(this.mCallback128);
            this.pempId8MusicNext.setOnClickListener(this.mCallback131);
            this.pempId8MusicPlay.setOnClickListener(this.mCallback130);
            this.pempId8MusicPrev.setOnClickListener(this.mCallback129);
        }
        if ((dirtyFlags & 192) != 0) {
            this.ivMask.setOnFocusChangeListener(mediaViewModelMusicViewFocusChangeListener);
        }
        if ((dirtyFlags & 136) != 0) {
            this.ivMusicAlbum.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView3.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView4.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView7.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.tvSinger.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.tvSongTitle.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 129) != 0) {
            BaseBindingModel.setID8AlbumIcon(this.ivMusicAlbum, mediaViewModelMediaInfoPicGet);
        }
        if ((dirtyFlags & 130) != 0) {
            CustomizeSeekBar.setProgress(this.mboundView4, mediaViewModelMediaInfoProgressPercentGet);
        }
        if ((dirtyFlags & 160) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.pempId8MusicPlay, mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN);
        }
        if ((dirtyFlags & 144) != 0) {
            TextViewBindingAdapter.setText(this.tvSinger, mediaViewModelMediaInfoMusicAtistJavaLangObjectNullTvSingerAndroidStringKswIdf7UnknowArtisMediaViewModelMediaInfoMusicAtist);
        }
        if ((dirtyFlags & 132) != 0) {
            TextViewBindingAdapter.setText(this.tvSongTitle, mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName2);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean mediaViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel mediaViewModel = this.mMediaViewModel;
                if (mediaViewModel == null) {
                    mediaViewModelJavaLangObjectNull = false;
                }
                if (mediaViewModelJavaLangObjectNull) {
                    mediaViewModel.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel mediaViewModel2 = this.mMediaViewModel;
                if (mediaViewModel2 == null) {
                    mediaViewModelJavaLangObjectNull = false;
                }
                if (mediaViewModelJavaLangObjectNull) {
                    mediaViewModel2.id8GsPreMusic(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LauncherViewModel mediaViewModel3 = this.mMediaViewModel;
                if (mediaViewModel3 == null) {
                    mediaViewModelJavaLangObjectNull = false;
                }
                if (mediaViewModelJavaLangObjectNull) {
                    mediaViewModel3.id8GsOpenPauseMusic(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LauncherViewModel mediaViewModel4 = this.mMediaViewModel;
                if (mediaViewModel4 == null) {
                    mediaViewModelJavaLangObjectNull = false;
                }
                if (mediaViewModelJavaLangObjectNull) {
                    mediaViewModel4.id8GsNextMusic(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}