package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
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
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomizeSeekBar;
import com.wits.ksw.launcher.view.MarqueeTextView;

public class ViewId9AlsMusicBindingImpl extends ViewId9AlsMusicBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback57;
    private final View.OnClickListener mCallback58;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView5;
    private final CustomizeSeekBar mboundView8;

    public ViewId9AlsMusicBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private ViewId9AlsMusicBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ConstraintLayout) bindings[0], (TextView) bindings[2], (ImageView) bindings[1], (ImageView) bindings[7], (ImageView) bindings[6], (MarqueeTextView) bindings[3], (TextView) bindings[4]);
        this.mDirtyFlags = -1;
        this.id9CardView.setTag(null);
        this.id9HomeMusicTitleTv.setTag(null);
        this.id9MusicIcon.setTag(null);
        this.id9MusicNext.setTag(null);
        this.id9MusicPrev.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[5];
        this.mboundView5 = constraintLayout;
        constraintLayout.setTag(null);
        CustomizeSeekBar customizeSeekBar = (CustomizeSeekBar) bindings[8];
        this.mboundView8 = customizeSeekBar;
        customizeSeekBar.setTag(null);
        this.tvTitle.setTag(null);
        this.tvTotalTime.setTag(null);
        setRootTag(root);
        this.mCallback57 = new OnClickListener(this, 1);
        this.mCallback58 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (12 != variableId) {
            return false;
        }
        setId9ViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ViewId9AlsMusicBinding
    public void setId9ViewModel(LauncherViewModel Id9ViewModel) {
        this.mId9ViewModel = Id9ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeId9ViewModelMediaInfoMusicAtist((ObservableField) object, fieldId);
            case 1:
                return onChangeId9ViewModelBThirdMusic((ObservableField) object, fieldId);
            case 2:
                return onChangeId9ViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            case 3:
                return onChangeId9ViewModelMediaInfoPic((ObservableField) object, fieldId);
            case 4:
                return onChangeId9ViewModelMediaInfoProgressPercent((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeId9ViewModelMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeId9ViewModelBThirdMusic(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeId9ViewModelMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeId9ViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeId9ViewModelMediaInfoProgressPercent(ObservableInt Id9ViewModelMediaInfoProgressPercent, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        long dirtyFlags2;
        int id9ViewModelBThirdMusicBooleanTrueViewVISIBLEViewGONE;
        boolean z;
        Drawable id9ViewModelMediaInfoPicJavaLangObjectNullId9MusicIconAndroidDrawableId9HomeMusicPicId9ViewModelMediaInfoPic;
        String id9ViewModelMediaInfoMusicAtistJavaLangObjectNullTvTotalTimeAndroidStringKswIdf7UnknowArtisId9ViewModelMediaInfoMusicAtist;
        String id9ViewModelMediaInfoMusicNameJavaLangObjectNullTvTitleAndroidStringKswIdf7UnkonwSoungId9ViewModelMediaInfoMusicName;
        ObservableInt id9ViewModelMediaInfoProgressPercent;
        ObservableField<String> id9ViewModelMediaInfoMusicName;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int id9ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = 0;
        ObservableField<String> id9ViewModelMediaInfoMusicAtist = null;
        int id9ViewModelMediaInfoProgressPercentGet = 0;
        boolean id9ViewModelMediaInfoMusicNameJavaLangObjectNull = false;
        boolean id9ViewModelMediaInfoPicJavaLangObjectNull = false;
        String id9ViewModelMediaInfoMusicAtistGet = null;
        String id9ViewModelMediaInfoMusicNameGet = null;
        BitmapDrawable id9ViewModelMediaInfoPicGet = null;
        Boolean id9ViewModelBThirdMusicGet = null;
        LauncherViewModel launcherViewModel = this.mId9ViewModel;
        ObservableField<BitmapDrawable> id9ViewModelMediaInfoPic = null;
        boolean id9ViewModelMediaInfoMusicAtistJavaLangObjectNull = false;
        if ((dirtyFlags & 66) != 0) {
            ObservableField<Boolean> id9ViewModelBThirdMusic = LauncherViewModel.bThirdMusic;
            updateRegistration(1, id9ViewModelBThirdMusic);
            if (id9ViewModelBThirdMusic != null) {
                id9ViewModelBThirdMusicGet = id9ViewModelBThirdMusic.get();
            }
            z = true;
            boolean id9ViewModelBThirdMusicBooleanTrue = ViewDataBinding.safeUnbox(id9ViewModelBThirdMusicGet);
            if ((dirtyFlags & 66) != 0) {
                if (id9ViewModelBThirdMusicBooleanTrue) {
                    dirtyFlags = dirtyFlags | 256 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                } else {
                    dirtyFlags = dirtyFlags | 128 | 512;
                }
            }
            int i = 8;
            int id9ViewModelBThirdMusicBooleanTrueViewVISIBLEViewGONE2 = id9ViewModelBThirdMusicBooleanTrue ? 0 : 8;
            if (!id9ViewModelBThirdMusicBooleanTrue) {
                i = 0;
            }
            id9ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = i;
            id9ViewModelBThirdMusicBooleanTrueViewVISIBLEViewGONE = id9ViewModelBThirdMusicBooleanTrueViewVISIBLEViewGONE2;
            dirtyFlags2 = dirtyFlags;
        } else {
            z = true;
            id9ViewModelBThirdMusicBooleanTrueViewVISIBLEViewGONE = 0;
            dirtyFlags2 = dirtyFlags;
        }
        if ((dirtyFlags2 & 93) != 0) {
            MediaInfo id9ViewModelMediaInfo = LauncherViewModel.mediaInfo;
            if ((dirtyFlags2 & 65) != 0) {
                if (id9ViewModelMediaInfo != null) {
                    id9ViewModelMediaInfoMusicAtist = id9ViewModelMediaInfo.musicAtist;
                }
                updateRegistration(0, id9ViewModelMediaInfoMusicAtist);
                if (id9ViewModelMediaInfoMusicAtist != null) {
                    id9ViewModelMediaInfoMusicAtistGet = id9ViewModelMediaInfoMusicAtist.get();
                }
                id9ViewModelMediaInfoMusicAtistJavaLangObjectNull = id9ViewModelMediaInfoMusicAtistGet == null ? z : false;
                if ((dirtyFlags2 & 65) != 0) {
                    if (id9ViewModelMediaInfoMusicAtistJavaLangObjectNull) {
                        dirtyFlags2 |= PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        dirtyFlags2 |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                }
            }
            if ((dirtyFlags2 & 68) != 0) {
                if (id9ViewModelMediaInfo != null) {
                    id9ViewModelMediaInfoMusicName = id9ViewModelMediaInfo.musicName;
                } else {
                    id9ViewModelMediaInfoMusicName = null;
                }
                updateRegistration(2, id9ViewModelMediaInfoMusicName);
                if (id9ViewModelMediaInfoMusicName != null) {
                    id9ViewModelMediaInfoMusicNameGet = id9ViewModelMediaInfoMusicName.get();
                }
                boolean id9ViewModelMediaInfoMusicNameJavaLangObjectNull2 = id9ViewModelMediaInfoMusicNameGet == null;
                if ((dirtyFlags2 & 68) == 0) {
                    id9ViewModelMediaInfoMusicNameJavaLangObjectNull = id9ViewModelMediaInfoMusicNameJavaLangObjectNull2;
                } else if (id9ViewModelMediaInfoMusicNameJavaLangObjectNull2) {
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    id9ViewModelMediaInfoMusicNameJavaLangObjectNull = id9ViewModelMediaInfoMusicNameJavaLangObjectNull2;
                } else {
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    id9ViewModelMediaInfoMusicNameJavaLangObjectNull = id9ViewModelMediaInfoMusicNameJavaLangObjectNull2;
                }
            }
            if ((dirtyFlags2 & 72) != 0) {
                if (id9ViewModelMediaInfo != null) {
                    id9ViewModelMediaInfoPic = id9ViewModelMediaInfo.pic;
                }
                updateRegistration(3, id9ViewModelMediaInfoPic);
                if (id9ViewModelMediaInfoPic != null) {
                    id9ViewModelMediaInfoPicGet = id9ViewModelMediaInfoPic.get();
                }
                boolean id9ViewModelMediaInfoPicJavaLangObjectNull2 = id9ViewModelMediaInfoPicGet == null;
                if ((dirtyFlags2 & 72) == 0) {
                    id9ViewModelMediaInfoPicJavaLangObjectNull = id9ViewModelMediaInfoPicJavaLangObjectNull2;
                } else if (id9ViewModelMediaInfoPicJavaLangObjectNull2) {
                    id9ViewModelMediaInfoPicJavaLangObjectNull = id9ViewModelMediaInfoPicJavaLangObjectNull2;
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                } else {
                    id9ViewModelMediaInfoPicJavaLangObjectNull = id9ViewModelMediaInfoPicJavaLangObjectNull2;
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
            }
            if ((dirtyFlags2 & 80) != 0) {
                if (id9ViewModelMediaInfo != null) {
                    id9ViewModelMediaInfoProgressPercent = id9ViewModelMediaInfo.progressPercent;
                } else {
                    id9ViewModelMediaInfoProgressPercent = null;
                }
                updateRegistration(4, id9ViewModelMediaInfoProgressPercent);
                if (id9ViewModelMediaInfoProgressPercent != null) {
                    id9ViewModelMediaInfoProgressPercentGet = id9ViewModelMediaInfoProgressPercent.get();
                }
            }
        }
        if ((dirtyFlags2 & 72) != 0) {
            id9ViewModelMediaInfoPicJavaLangObjectNullId9MusicIconAndroidDrawableId9HomeMusicPicId9ViewModelMediaInfoPic = id9ViewModelMediaInfoPicJavaLangObjectNull ? AppCompatResources.getDrawable(this.id9MusicIcon.getContext(), R.drawable.id9_home_music_pic) : id9ViewModelMediaInfoPicGet;
        } else {
            id9ViewModelMediaInfoPicJavaLangObjectNullId9MusicIconAndroidDrawableId9HomeMusicPicId9ViewModelMediaInfoPic = null;
        }
        if ((dirtyFlags2 & 65) != 0) {
            id9ViewModelMediaInfoMusicAtistJavaLangObjectNullTvTotalTimeAndroidStringKswIdf7UnknowArtisId9ViewModelMediaInfoMusicAtist = id9ViewModelMediaInfoMusicAtistJavaLangObjectNull ? this.tvTotalTime.getResources().getString(R.string.ksw_idf7_unknow_artis) : id9ViewModelMediaInfoMusicAtistGet;
        } else {
            id9ViewModelMediaInfoMusicAtistJavaLangObjectNullTvTotalTimeAndroidStringKswIdf7UnknowArtisId9ViewModelMediaInfoMusicAtist = null;
        }
        if ((dirtyFlags2 & 68) != 0) {
            id9ViewModelMediaInfoMusicNameJavaLangObjectNullTvTitleAndroidStringKswIdf7UnkonwSoungId9ViewModelMediaInfoMusicName = id9ViewModelMediaInfoMusicNameJavaLangObjectNull ? this.tvTitle.getResources().getString(R.string.ksw_idf7_unkonw_soung) : id9ViewModelMediaInfoMusicNameGet;
        } else {
            id9ViewModelMediaInfoMusicNameJavaLangObjectNullTvTitleAndroidStringKswIdf7UnkonwSoungId9ViewModelMediaInfoMusicName = null;
        }
        if ((dirtyFlags2 & 66) != 0) {
            this.id9HomeMusicTitleTv.setVisibility(id9ViewModelBThirdMusicBooleanTrueViewVISIBLEViewGONE);
            this.id9MusicIcon.setVisibility(id9ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView5.setVisibility(id9ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.tvTitle.setVisibility(id9ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.tvTotalTime.setVisibility(id9ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags2 & 72) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.id9MusicIcon, id9ViewModelMediaInfoPicJavaLangObjectNullId9MusicIconAndroidDrawableId9HomeMusicPicId9ViewModelMediaInfoPic);
        }
        if ((dirtyFlags2 & 64) != 0) {
            this.id9MusicNext.setOnClickListener(this.mCallback58);
            this.id9MusicPrev.setOnClickListener(this.mCallback57);
        }
        if ((dirtyFlags2 & 80) != 0) {
            CustomizeSeekBar.setProgress(this.mboundView8, id9ViewModelMediaInfoProgressPercentGet);
        }
        if ((dirtyFlags2 & 68) != 0) {
            TextViewBindingAdapter.setText(this.tvTitle, id9ViewModelMediaInfoMusicNameJavaLangObjectNullTvTitleAndroidStringKswIdf7UnkonwSoungId9ViewModelMediaInfoMusicName);
        }
        if ((dirtyFlags2 & 65) != 0) {
            TextViewBindingAdapter.setText(this.tvTotalTime, id9ViewModelMediaInfoMusicAtistJavaLangObjectNullTvTotalTimeAndroidStringKswIdf7UnknowArtisId9ViewModelMediaInfoMusicAtist);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean id9ViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel id9ViewModel = this.mId9ViewModel;
                if (id9ViewModel == null) {
                    id9ViewModelJavaLangObjectNull = false;
                }
                if (id9ViewModelJavaLangObjectNull) {
                    id9ViewModel.id8GsPreMusic(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel id9ViewModel2 = this.mId9ViewModel;
                if (id9ViewModel2 == null) {
                    id9ViewModelJavaLangObjectNull = false;
                }
                if (id9ViewModelJavaLangObjectNull) {
                    id9ViewModel2.id8GsNextMusic(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
