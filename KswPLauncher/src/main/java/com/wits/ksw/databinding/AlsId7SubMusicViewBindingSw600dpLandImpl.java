package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.als_id7.model.AlsID7ViewModel;
import com.wits.ksw.launcher.als_id7.view.MusicSeekBar;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.view.CustomBmwMusicLayout;

public class AlsId7SubMusicViewBindingSw600dpLandImpl extends AlsId7SubMusicViewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback477;
    private final View.OnClickListener mCallback478;
    private final View.OnClickListener mCallback479;
    private final View.OnClickListener mCallback480;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.music_title, 12);
        sparseIntArray.put(R.id.music_sub_title, 13);
    }

    public AlsId7SubMusicViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private AlsId7SubMusicViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 9, (TextView) bindings[9], (TextView) bindings[8], (ImageView) bindings[6], (ImageView) bindings[5], (ImageView) bindings[4], (TextView) bindings[10], (CustomBmwMusicLayout) bindings[1], (ImageView) bindings[2], (ConstraintLayout) bindings[0], (TextView) bindings[13], (TextView) bindings[12], (TextView) bindings[7], (MusicSeekBar) bindings[3], (TextView) bindings[11]);
        this.mDirtyFlags = -1;
        this.albumTextView.setTag(null);
        this.artistTextView.setTag(null);
        this.btnMusicNext.setTag(null);
        this.btnMusicPause.setTag(null);
        this.btnMusicPrev.setTag(null);
        this.currentTimeTextView.setTag(null);
        this.imageFrameLayout.setTag(null);
        this.musicAlbumBg.setTag(null);
        this.musicConstraintLayout.setTag(null);
        this.nameTextView.setTag(null);
        this.seekBar.setTag(null);
        this.totalTimeTextView.setTag(null);
        setRootTag(root);
        this.mCallback479 = new OnClickListener(this, 3);
        this.mCallback480 = new OnClickListener(this, 4);
        this.mCallback477 = new OnClickListener(this, 1);
        this.mCallback478 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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
        if (18 != variableId) {
            return false;
        }
        setMusicPhoneViewModel((AlsID7ViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AlsId7SubMusicViewBinding
    public void setMusicPhoneViewModel(AlsID7ViewModel MusicPhoneViewModel) {
        this.mMusicPhoneViewModel = MusicPhoneViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeMusicPhoneViewModelMediaInfoMusicPlay((ObservableField) object, fieldId);
            case 1:
                return onChangeMusicPhoneViewModelMediaInfoMusicAtist((ObservableField) object, fieldId);
            case 2:
                return onChangeMusicPhoneViewModelMediaInfoProgress((ObservableInt) object, fieldId);
            case 3:
                return onChangeMusicPhoneViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            case 4:
                return onChangeMusicPhoneViewModelMediaInfoPic((ObservableField) object, fieldId);
            case 5:
                return onChangeMusicPhoneViewModelMediaInfoCurrentTime((ObservableField) object, fieldId);
            case 6:
                return onChangeMusicPhoneViewModelMediaInfoMaxProgress((ObservableInt) object, fieldId);
            case 7:
                return onChangeMusicPhoneViewModelMediaInfoTotalTime((ObservableField) object, fieldId);
            case 8:
                return onChangeMusicPhoneViewModelMediaInfoMusicAlbum((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoMusicPlay(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoProgress(ObservableInt MusicPhoneViewModelMediaInfoProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoCurrentTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoMaxProgress(ObservableInt MusicPhoneViewModelMediaInfoMaxProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoTotalTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeMusicPhoneViewModelMediaInfoMusicAlbum(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int musicPhoneViewModelMediaInfoMaxProgressGet;
        Drawable musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay;
        String musicPhoneViewModelMediaInfoTotalTimeGet;
        String musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNullArtistTextViewAndroidStringKswIdf7UnknowArtisMusicPhoneViewModelMediaInfoMusicAtist;
        String musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNullNameTextViewAndroidStringKswIdf7UnkonwSoungMusicPhoneViewModelMediaInfoMusicName;
        int musicPhoneViewModelMediaInfoProgressGet;
        int musicPhoneViewModelMediaInfoProgressGet2;
        ObservableField<String> musicPhoneViewModelMediaInfoMusicAlbum;
        ObservableField<String> musicPhoneViewModelMediaInfoTotalTime;
        ObservableInt musicPhoneViewModelMediaInfoMaxProgress;
        ObservableField<String> musicPhoneViewModelMediaInfoCurrentTime;
        ObservableField<BitmapDrawable> musicPhoneViewModelMediaInfoPic;
        ObservableField<String> musicPhoneViewModelMediaInfoMusicName;
        ObservableInt musicPhoneViewModelMediaInfoProgress;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int musicPhoneViewModelMediaInfoProgressGet3 = 0;
        View.OnFocusChangeListener musicPhoneViewModelMusicViewFocusChangeListener = null;
        BitmapDrawable musicPhoneViewModelMediaInfoPicGet = null;
        String musicPhoneViewModelMediaInfoCurrentTimeGet = null;
        AlsID7ViewModel musicPhoneViewModel = this.mMusicPhoneViewModel;
        boolean musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNull = false;
        String musicPhoneViewModelMediaInfoMusicAlbumGet = null;
        ObservableField<Boolean> musicPhoneViewModelMediaInfoMusicPlay = null;
        boolean musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNull = false;
        ObservableField<String> musicPhoneViewModelMediaInfoMusicAtist = null;
        String musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNullAlbumTextViewAndroidStringKswIdf7UnkonwAlbumMusicPhoneViewModelMediaInfoMusicAlbum = null;
        String musicPhoneViewModelMediaInfoTotalTimeGet2 = null;
        String musicPhoneViewModelMediaInfoMusicNameGet = null;
        boolean musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNull = false;
        String musicPhoneViewModelMediaInfoMusicAtistGet = null;
        Drawable musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay2 = null;
        int musicPhoneViewModelMediaInfoMaxProgressGet2 = 0;
        Boolean musicPhoneViewModelMediaInfoMusicPlayGet = null;
        if (!((dirtyFlags & 1536) == 0 || musicPhoneViewModel == null)) {
            musicPhoneViewModelMusicViewFocusChangeListener = musicPhoneViewModel.musicViewFocusChangeListener;
        }
        if ((dirtyFlags & 1535) != 0) {
            MediaInfo musicPhoneViewModelMediaInfo = AlsID7ViewModel.mediaInfo;
            if ((dirtyFlags & 1025) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoMusicPlay = musicPhoneViewModelMediaInfo.musicPlay;
                }
                updateRegistration(0, musicPhoneViewModelMediaInfoMusicPlay);
                if (musicPhoneViewModelMediaInfoMusicPlay != null) {
                    musicPhoneViewModelMediaInfoMusicPlayGet = musicPhoneViewModelMediaInfoMusicPlay.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxMusicPhoneViewModelMediaInfoMusicPlayGet = ViewDataBinding.safeUnbox(musicPhoneViewModelMediaInfoMusicPlayGet);
                if ((dirtyFlags & 1025) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxMusicPhoneViewModelMediaInfoMusicPlayGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                }
                musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay2 = androidDatabindingViewDataBindingSafeUnboxMusicPhoneViewModelMediaInfoMusicPlayGet ? AppCompatResources.getDrawable(this.btnMusicPause.getContext(), R.drawable.als_id7_main_music_btn_pause) : AppCompatResources.getDrawable(this.btnMusicPause.getContext(), R.drawable.als_id7_main_music_btn_play);
            }
            if ((dirtyFlags & 1026) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoMusicAtist = musicPhoneViewModelMediaInfo.musicAtist;
                }
                updateRegistration(1, musicPhoneViewModelMediaInfoMusicAtist);
                if (musicPhoneViewModelMediaInfoMusicAtist != null) {
                    musicPhoneViewModelMediaInfoMusicAtistGet = musicPhoneViewModelMediaInfoMusicAtist.get();
                }
                musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNull = musicPhoneViewModelMediaInfoMusicAtistGet == null;
                if ((dirtyFlags & 1026) != 0) {
                    if (musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNull) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                }
            }
            if ((dirtyFlags & 1028) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoProgress = musicPhoneViewModelMediaInfo.progress;
                } else {
                    musicPhoneViewModelMediaInfoProgress = null;
                }
                updateRegistration(2, musicPhoneViewModelMediaInfoProgress);
                musicPhoneViewModelMediaInfoProgressGet = musicPhoneViewModelMediaInfoProgress != null ? musicPhoneViewModelMediaInfoProgress.get() : 0;
            } else {
                musicPhoneViewModelMediaInfoProgressGet = 0;
            }
            if ((dirtyFlags & 1032) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoMusicName = musicPhoneViewModelMediaInfo.musicName;
                } else {
                    musicPhoneViewModelMediaInfoMusicName = null;
                }
                musicPhoneViewModelMediaInfoProgressGet2 = musicPhoneViewModelMediaInfoProgressGet;
                updateRegistration(3, musicPhoneViewModelMediaInfoMusicName);
                if (musicPhoneViewModelMediaInfoMusicName != null) {
                    musicPhoneViewModelMediaInfoMusicNameGet = musicPhoneViewModelMediaInfoMusicName.get();
                }
                musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNull = musicPhoneViewModelMediaInfoMusicNameGet == null;
                if ((dirtyFlags & 1032) != 0) {
                    if (musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNull) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                }
            } else {
                musicPhoneViewModelMediaInfoProgressGet2 = musicPhoneViewModelMediaInfoProgressGet;
            }
            if ((dirtyFlags & 1040) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoPic = musicPhoneViewModelMediaInfo.pic;
                } else {
                    musicPhoneViewModelMediaInfoPic = null;
                }
                updateRegistration(4, musicPhoneViewModelMediaInfoPic);
                if (musicPhoneViewModelMediaInfoPic != null) {
                    musicPhoneViewModelMediaInfoPicGet = musicPhoneViewModelMediaInfoPic.get();
                }
            }
            if ((dirtyFlags & 1056) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoCurrentTime = musicPhoneViewModelMediaInfo.currentTime;
                } else {
                    musicPhoneViewModelMediaInfoCurrentTime = null;
                }
                updateRegistration(5, musicPhoneViewModelMediaInfoCurrentTime);
                if (musicPhoneViewModelMediaInfoCurrentTime != null) {
                    musicPhoneViewModelMediaInfoCurrentTimeGet = musicPhoneViewModelMediaInfoCurrentTime.get();
                }
            }
            if ((dirtyFlags & 1088) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoMaxProgress = musicPhoneViewModelMediaInfo.maxProgress;
                } else {
                    musicPhoneViewModelMediaInfoMaxProgress = null;
                }
                updateRegistration(6, musicPhoneViewModelMediaInfoMaxProgress);
                if (musicPhoneViewModelMediaInfoMaxProgress != null) {
                    musicPhoneViewModelMediaInfoMaxProgressGet2 = musicPhoneViewModelMediaInfoMaxProgress.get();
                }
            }
            if ((dirtyFlags & 1152) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoTotalTime = musicPhoneViewModelMediaInfo.totalTime;
                } else {
                    musicPhoneViewModelMediaInfoTotalTime = null;
                }
                updateRegistration(7, musicPhoneViewModelMediaInfoTotalTime);
                if (musicPhoneViewModelMediaInfoTotalTime != null) {
                    musicPhoneViewModelMediaInfoTotalTimeGet2 = musicPhoneViewModelMediaInfoTotalTime.get();
                }
            }
            if ((dirtyFlags & 1280) != 0) {
                if (musicPhoneViewModelMediaInfo != null) {
                    musicPhoneViewModelMediaInfoMusicAlbum = musicPhoneViewModelMediaInfo.musicAlbum;
                } else {
                    musicPhoneViewModelMediaInfoMusicAlbum = null;
                }
                updateRegistration(8, musicPhoneViewModelMediaInfoMusicAlbum);
                if (musicPhoneViewModelMediaInfoMusicAlbum != null) {
                    musicPhoneViewModelMediaInfoMusicAlbumGet = musicPhoneViewModelMediaInfoMusicAlbum.get();
                }
                musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNull = musicPhoneViewModelMediaInfoMusicAlbumGet == null;
                if ((dirtyFlags & 1280) == 0) {
                    musicPhoneViewModelMediaInfoTotalTimeGet = musicPhoneViewModelMediaInfoTotalTimeGet2;
                    musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay = musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay2;
                    musicPhoneViewModelMediaInfoProgressGet3 = musicPhoneViewModelMediaInfoProgressGet2;
                    musicPhoneViewModelMediaInfoMaxProgressGet = musicPhoneViewModelMediaInfoMaxProgressGet2;
                } else if (musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNull) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    musicPhoneViewModelMediaInfoTotalTimeGet = musicPhoneViewModelMediaInfoTotalTimeGet2;
                    musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay = musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay2;
                    musicPhoneViewModelMediaInfoProgressGet3 = musicPhoneViewModelMediaInfoProgressGet2;
                    musicPhoneViewModelMediaInfoMaxProgressGet = musicPhoneViewModelMediaInfoMaxProgressGet2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    musicPhoneViewModelMediaInfoTotalTimeGet = musicPhoneViewModelMediaInfoTotalTimeGet2;
                    musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay = musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay2;
                    musicPhoneViewModelMediaInfoProgressGet3 = musicPhoneViewModelMediaInfoProgressGet2;
                    musicPhoneViewModelMediaInfoMaxProgressGet = musicPhoneViewModelMediaInfoMaxProgressGet2;
                }
            } else {
                musicPhoneViewModelMediaInfoTotalTimeGet = musicPhoneViewModelMediaInfoTotalTimeGet2;
                musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay = musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay2;
                musicPhoneViewModelMediaInfoProgressGet3 = musicPhoneViewModelMediaInfoProgressGet2;
                musicPhoneViewModelMediaInfoMaxProgressGet = musicPhoneViewModelMediaInfoMaxProgressGet2;
            }
        } else {
            musicPhoneViewModelMediaInfoTotalTimeGet = null;
            musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay = null;
            musicPhoneViewModelMediaInfoMaxProgressGet = 0;
        }
        if ((dirtyFlags & 1280) != 0) {
            musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNullAlbumTextViewAndroidStringKswIdf7UnkonwAlbumMusicPhoneViewModelMediaInfoMusicAlbum = musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNull ? this.albumTextView.getResources().getString(R.string.ksw_idf7_unkonw_album) : musicPhoneViewModelMediaInfoMusicAlbumGet;
        }
        if ((dirtyFlags & 1026) != 0) {
            musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNullArtistTextViewAndroidStringKswIdf7UnknowArtisMusicPhoneViewModelMediaInfoMusicAtist = musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNull ? this.artistTextView.getResources().getString(R.string.ksw_idf7_unknow_artis) : musicPhoneViewModelMediaInfoMusicAtistGet;
        } else {
            musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNullArtistTextViewAndroidStringKswIdf7UnknowArtisMusicPhoneViewModelMediaInfoMusicAtist = null;
        }
        if ((dirtyFlags & 1032) != 0) {
            musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNullNameTextViewAndroidStringKswIdf7UnkonwSoungMusicPhoneViewModelMediaInfoMusicName = musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNull ? this.nameTextView.getResources().getString(R.string.ksw_idf7_unkonw_soung) : musicPhoneViewModelMediaInfoMusicNameGet;
        } else {
            musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNullNameTextViewAndroidStringKswIdf7UnkonwSoungMusicPhoneViewModelMediaInfoMusicName = null;
        }
        if ((dirtyFlags & 1280) != 0) {
            TextViewBindingAdapter.setText(this.albumTextView, musicPhoneViewModelMediaInfoMusicAlbumJavaLangObjectNullAlbumTextViewAndroidStringKswIdf7UnkonwAlbumMusicPhoneViewModelMediaInfoMusicAlbum);
        }
        if ((dirtyFlags & 1026) != 0) {
            TextViewBindingAdapter.setText(this.artistTextView, musicPhoneViewModelMediaInfoMusicAtistJavaLangObjectNullArtistTextViewAndroidStringKswIdf7UnknowArtisMusicPhoneViewModelMediaInfoMusicAtist);
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) != 0) {
            this.btnMusicNext.setOnClickListener(this.mCallback480);
            this.btnMusicPause.setOnClickListener(this.mCallback479);
            this.btnMusicPrev.setOnClickListener(this.mCallback478);
            this.imageFrameLayout.setOnClickListener(this.mCallback477);
        }
        if ((dirtyFlags & 1025) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.btnMusicPause, musicPhoneViewModelMediaInfoMusicPlayBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPauseBtnMusicPauseAndroidDrawableAlsId7MainMusicBtnPlay);
        }
        if ((dirtyFlags & 1056) != 0) {
            TextViewBindingAdapter.setText(this.currentTimeTextView, musicPhoneViewModelMediaInfoCurrentTimeGet);
        }
        if ((dirtyFlags & 1536) != 0) {
            this.imageFrameLayout.setOnFocusChangeListener(musicPhoneViewModelMusicViewFocusChangeListener);
        }
        if ((dirtyFlags & 1040) != 0) {
            BaseBindingModel.setAlsID7AlbumIcon(this.musicAlbumBg, musicPhoneViewModelMediaInfoPicGet);
        }
        if ((dirtyFlags & 1032) != 0) {
            TextViewBindingAdapter.setText(this.nameTextView, musicPhoneViewModelMediaInfoMusicNameJavaLangObjectNullNameTextViewAndroidStringKswIdf7UnkonwSoungMusicPhoneViewModelMediaInfoMusicName);
        }
        if ((dirtyFlags & 1088) != 0) {
            this.seekBar.setMax(musicPhoneViewModelMediaInfoMaxProgressGet);
        }
        if ((dirtyFlags & 1028) != 0) {
            SeekBarBindingAdapter.setProgress(this.seekBar, musicPhoneViewModelMediaInfoProgressGet3);
        }
        if ((dirtyFlags & 1152) != 0) {
            TextViewBindingAdapter.setText(this.totalTimeTextView, musicPhoneViewModelMediaInfoTotalTimeGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean musicPhoneViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                AlsID7ViewModel musicPhoneViewModel = this.mMusicPhoneViewModel;
                if (musicPhoneViewModel == null) {
                    musicPhoneViewModelJavaLangObjectNull = false;
                }
                if (musicPhoneViewModelJavaLangObjectNull) {
                    musicPhoneViewModel.openMusic(callbackArg_0);
                    return;
                }
                return;
            case 2:
                AlsID7ViewModel musicPhoneViewModel2 = this.mMusicPhoneViewModel;
                if (musicPhoneViewModel2 == null) {
                    musicPhoneViewModelJavaLangObjectNull = false;
                }
                if (musicPhoneViewModelJavaLangObjectNull) {
                    musicPhoneViewModel2.btnMusicPrev(callbackArg_0);
                    return;
                }
                return;
            case 3:
                AlsID7ViewModel musicPhoneViewModel3 = this.mMusicPhoneViewModel;
                if (musicPhoneViewModel3 == null) {
                    musicPhoneViewModelJavaLangObjectNull = false;
                }
                if (musicPhoneViewModelJavaLangObjectNull) {
                    musicPhoneViewModel3.btnMusicPlayPause(callbackArg_0);
                    return;
                }
                return;
            case 4:
                AlsID7ViewModel musicPhoneViewModel4 = this.mMusicPhoneViewModel;
                if (musicPhoneViewModel4 == null) {
                    musicPhoneViewModelJavaLangObjectNull = false;
                }
                if (musicPhoneViewModelJavaLangObjectNull) {
                    musicPhoneViewModel4.btnMusicNext(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
