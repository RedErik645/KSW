package com.wits.ksw.databinding;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomizeSeekBar;
import com.wits.ksw.launcher.view.MarqueeTextView;

public class MusicEditorPempDataBindingImpl extends MusicEditorPempDataBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final CustomizeSeekBar mboundView3;
    private final RelativeLayout mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout, 8);
    }

    public MusicEditorPempDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private MusicEditorPempDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (ImageView) bindings[1], (LinearLayout) bindings[8], (ImageView) bindings[7], (TextView) bindings[5], (MarqueeTextView) bindings[4]);
        this.mDirtyFlags = -1;
        this.ivMainIconMusic.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        CustomizeSeekBar customizeSeekBar = (CustomizeSeekBar) bindings[3];
        this.mboundView3 = customizeSeekBar;
        customizeSeekBar.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) bindings[6];
        this.mboundView6 = relativeLayout2;
        relativeLayout2.setTag(null);
        this.pempId8MusicPlay.setTag(null);
        this.tvSinger.setTag(null);
        this.tvSongTitle.setTag(null);
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

    @Override // com.wits.ksw.databinding.MusicEditorPempDataBinding
    public void setMediaViewModel(LauncherViewModel MediaViewModel) {
        this.mMediaViewModel = MediaViewModel;
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
        BitmapDrawable mediaViewModelMediaInfoPicGet;
        int mediaViewModelMediaInfoProgressPercentGet;
        int mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE;
        Boolean mediaViewModelBThirdMusicGet;
        ObservableField<Boolean> mediaViewModelMediaInfoMusicPlay;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN = null;
        Boolean mediaViewModelBThirdMusicGet2 = null;
        ObservableField<BitmapDrawable> mediaViewModelMediaInfoPic = null;
        String mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName = null;
        ObservableInt mediaViewModelMediaInfoProgressPercent = null;
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
        if ((dirtyFlags & 183) != 0) {
            MediaInfo mediaViewModelMediaInfo = LauncherViewModel.mediaInfo;
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
                mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN = androidDatabindingViewDataBindingSafeUnboxMediaViewModelMediaInfoMusicPlayGet ? AppCompatResources.getDrawable(this.pempId8MusicPlay.getContext(), R.drawable.pemp_id8_main_icon_music_btn_pause_n) : AppCompatResources.getDrawable(this.pempId8MusicPlay.getContext(), R.drawable.pemp_id8_main_icon_music_btn_play_n);
                mediaViewModelMediaInfoProgressPercentGet = mediaViewModelMediaInfoProgressPercentGet2;
                mediaViewModelMediaInfoPicGet = mediaViewModelMediaInfoPicGet2;
            } else {
                mediaViewModelMediaInfoProgressPercentGet = mediaViewModelMediaInfoProgressPercentGet2;
                mediaViewModelMediaInfoPicGet = mediaViewModelMediaInfoPicGet2;
            }
        } else {
            mediaViewModelMediaInfoProgressPercentGet = 0;
            mediaViewModelMediaInfoPicGet = null;
        }
        if ((dirtyFlags & 136) != 0) {
            ObservableField<Boolean> mediaViewModelBThirdMusic = LauncherViewModel.bThirdMusic;
            updateRegistration(3, mediaViewModelBThirdMusic);
            if (mediaViewModelBThirdMusic != null) {
                mediaViewModelBThirdMusicGet = mediaViewModelBThirdMusic.get();
            } else {
                mediaViewModelBThirdMusicGet = null;
            }
            boolean androidDatabindingViewDataBindingSafeUnboxMediaViewModelBThirdMusicGet = ViewDataBinding.safeUnbox(mediaViewModelBThirdMusicGet);
            boolean mediaViewModelBThirdMusicBooleanTrue = true;
            if (!androidDatabindingViewDataBindingSafeUnboxMediaViewModelBThirdMusicGet) {
                mediaViewModelBThirdMusicBooleanTrue = false;
            }
            if ((dirtyFlags & 136) != 0) {
                if (mediaViewModelBThirdMusicBooleanTrue) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                }
            }
            int mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2 = mediaViewModelBThirdMusicBooleanTrue ? 8 : 0;
            mediaViewModelBThirdMusicGet2 = mediaViewModelBThirdMusicGet;
            mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2;
        } else {
            mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = 0;
        }
        if ((dirtyFlags & 132) != 0) {
            mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName = mediaViewModelMediaInfoMusicNameJavaLangObjectNull ? this.tvSongTitle.getResources().getString(R.string.ksw_idf7_unkonw_soung) : mediaViewModelMediaInfoMusicNameGet;
        }
        if ((dirtyFlags & 144) != 0) {
            mediaViewModelMediaInfoMusicAtistJavaLangObjectNullTvSingerAndroidStringKswIdf7UnknowArtisMediaViewModelMediaInfoMusicAtist = mediaViewModelMediaInfoMusicAtistJavaLangObjectNull ? this.tvSinger.getResources().getString(R.string.ksw_idf7_unknow_artis) : mediaViewModelMediaInfoMusicAtistGet;
        }
        if ((dirtyFlags & 136) != 0) {
            this.ivMainIconMusic.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView2.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView3.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView6.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.tvSinger.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.tvSongTitle.setVisibility(mediaViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 129) != 0) {
            BaseBindingModel.setID8AlbumIcon(this.ivMainIconMusic, mediaViewModelMediaInfoPicGet);
        }
        if ((dirtyFlags & 130) != 0) {
            CustomizeSeekBar.setProgress(this.mboundView3, mediaViewModelMediaInfoProgressPercentGet);
        }
        if ((dirtyFlags & 160) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.pempId8MusicPlay, mediaViewModelMediaInfoMusicPlayPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPauseNPempId8MusicPlayAndroidDrawablePempId8MainIconMusicBtnPlayN);
        }
        if ((dirtyFlags & 144) != 0) {
            TextViewBindingAdapter.setText(this.tvSinger, mediaViewModelMediaInfoMusicAtistJavaLangObjectNullTvSingerAndroidStringKswIdf7UnknowArtisMediaViewModelMediaInfoMusicAtist);
        }
        if ((dirtyFlags & 132) != 0) {
            TextViewBindingAdapter.setText(this.tvSongTitle, mediaViewModelMediaInfoMusicNameJavaLangObjectNullTvSongTitleAndroidStringKswIdf7UnkonwSoungMediaViewModelMediaInfoMusicName);
        }
    }
}
