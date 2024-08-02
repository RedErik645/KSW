package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
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
import android.support.v7.widget.CardView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.launcher.view.id8ug.Id8UgLauncherViewModel;

public class FragmentEvoid8MainMusicBindingImpl extends FragmentEvoid8MainMusicBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback576;
    private final View.OnClickListener mCallback577;
    private final View.OnClickListener mCallback578;
    private long mDirtyFlags;
    private final CardView mboundView0;
    private final TextView mboundView10;
    private final LinearLayout mboundView11;
    private final MarqueeTextView mboundView12;
    private final TextView mboundView13;
    private final ImageView mboundView4;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id8_ug_music_view, 14);
        sparseIntArray.put(R.id.id8_ug_change_ll, 15);
        sparseIntArray.put(R.id.id8_ug_change_music_iv, 16);
        sparseIntArray.put(R.id.id8_ug_change_bt_iv, 17);
        sparseIntArray.put(R.id.id8_ug_change_bt_up, 18);
    }

    public FragmentEvoid8MainMusicBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    private FragmentEvoid8MainMusicBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 18, (ImageView) bindings[2], (ImageView) bindings[3], (SeekBar) bindings[8], (TextView) bindings[1], (ImageView) bindings[17], (ImageView) bindings[18], (LinearLayout) bindings[15], (ImageView) bindings[16], (ConstraintLayout) bindings[5], (ConstraintLayout) bindings[14], (ImageView) bindings[7], (ImageView) bindings[6]);
        this.mDirtyFlags = -1;
        this.id8MusicIcon.setTag(null);
        this.id8MusicIcon1.setTag(null);
        this.id8MusicSeekBar.setTag(null);
        this.id8UgCardViewTitle.setTag(null);
        this.id8UgMusicBottomCl.setTag(null);
        this.id9MusicNext.setTag(null);
        this.id9MusicPrev.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[11];
        this.mboundView11 = linearLayout;
        linearLayout.setTag(null);
        MarqueeTextView marqueeTextView = (MarqueeTextView) bindings[12];
        this.mboundView12 = marqueeTextView;
        marqueeTextView.setTag(null);
        TextView textView2 = (TextView) bindings[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.mboundView4 = imageView;
        imageView.setTag(null);
        TextView textView3 = (TextView) bindings[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
        setRootTag(root);
        this.mCallback576 = new OnClickListener(this, 1);
        this.mCallback577 = new OnClickListener(this, 2);
        this.mCallback578 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
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
        if (10 != variableId) {
            return false;
        }
        setId8ViewModel((Id8UgLauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.FragmentEvoid8MainMusicBinding
    public void setId8ViewModel(Id8UgLauncherViewModel Id8ViewModel) {
        this.mId8ViewModel = Id8ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeId8ViewModelBtMusicMaxProgress((ObservableInt) object, fieldId);
            case 1:
                return onChangeId8ViewModelMediaInfoCurrentTime((ObservableField) object, fieldId);
            case 2:
                return onChangeId8ViewModelBtMusicAtist((ObservableField) object, fieldId);
            case 3:
                return onChangeId8ViewModelMediaInfoTotalTime((ObservableField) object, fieldId);
            case 4:
                return onChangeId8ViewModelId8MusicCardName((ObservableField) object, fieldId);
            case 5:
                return onChangeId8ViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            case 6:
                return onChangeId8ViewModelBtMusicCurrentTime((ObservableField) object, fieldId);
            case 7:
                return onChangeId8ViewModelMediaInfoMaxProgress((ObservableInt) object, fieldId);
            case 8:
                return onChangeId8ViewModelBtMusicName((ObservableField) object, fieldId);
            case 9:
                return onChangeId8ViewModelMediaInfoMusicPlay((ObservableField) object, fieldId);
            case 10:
                return onChangeId8ViewModelBtMusicProgress((ObservableInt) object, fieldId);
            case 11:
                return onChangeId8ViewModelMediaInfoProgress((ObservableInt) object, fieldId);
            case 12:
                return onChangeId8ViewModelMediaInfoMusicAtist((ObservableField) object, fieldId);
            case 13:
                return onChangeId8ViewModelMediaInfoPic((ObservableField) object, fieldId);
            case 14:
                return onChangeId8ViewModelId8BtMusicType((ObservableBoolean) object, fieldId);
            case 15:
                return onChangeId8ViewModelBThirdMusic((ObservableField) object, fieldId);
            case 16:
                return onChangeId8ViewModelBtMusicPlayStatus((ObservableBoolean) object, fieldId);
            case 17:
                return onChangeId8ViewModelBtMusicTotalTime((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeId8ViewModelBtMusicMaxProgress(ObservableInt Id8ViewModelBtMusicMaxProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoCurrentTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBtMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoTotalTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeId8ViewModelId8MusicCardName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBtMusicCurrentTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoMaxProgress(ObservableInt Id8ViewModelMediaInfoMaxProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBtMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoMusicPlay(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBtMusicProgress(ObservableInt Id8ViewModelBtMusicProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoProgress(ObservableInt Id8ViewModelMediaInfoProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeId8ViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeId8ViewModelId8BtMusicType(ObservableBoolean Id8ViewModelId8BtMusicType, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBThirdMusic(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBtMusicPlayStatus(ObservableBoolean Id8ViewModelBtMusicPlayStatus, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeId8ViewModelBtMusicTotalTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r7v3 com.wits.ksw.launcher.bean.MediaInfo: [D('id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE' int), D('id8ViewModelMediaInfo' com.wits.ksw.launcher.bean.MediaInfo)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable id8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector;
        ObservableField<String> id8ViewModelMediaInfoCurrentTime;
        int id8ViewModelId8BtMusicTypeViewVISIBLEViewGONE;
        String id8ViewModelId8MusicCardNameGet;
        int id8ViewModelId8BtMusicTypeViewGONEViewVISIBLE;
        String id8ViewModelBtMusicTotalTimeGet;
        int id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE;
        BitmapDrawable id8ViewModelMediaInfoPicGet;
        String id8ViewModelBtMusicTotalTimeGet2;
        String id8ViewModelBtMusicTotalTimeGet3;
        int id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2;
        String id8ViewModelBtMusicNameGet;
        int id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE3;
        String id8ViewModelId8BtMusicTypeId8ViewModelBtMusicCurrentTimeId8ViewModelMediaInfoCurrentTime;
        int id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE;
        int id8ViewModelId8BtMusicTypeId8ViewModelBtMusicMaxProgressId8ViewModelMediaInfoMaxProgress;
        Drawable id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector;
        int id8ViewModelId8BtMusicTypeId8ViewModelBtMusicProgressId8ViewModelMediaInfoProgress;
        Drawable id8ViewModelId8BtMusicTypeId8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelectorId8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector;
        String id8ViewModelId8BtMusicTypeId8ViewModelBtMusicTotalTimeId8ViewModelMediaInfoTotalTime;
        String id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNullMboundView13AndroidStringKswIdf7UnknowArtisId8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist;
        String id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNullMboundView12AndroidStringEvoid8MusicNotPlayId8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName;
        ObservableField<String> id8ViewModelMediaInfoCurrentTime2;
        ObservableField<String> id8ViewModelMediaInfoMusicAtist;
        ObservableInt id8ViewModelMediaInfoProgress;
        ObservableField<Boolean> id8ViewModelMediaInfoMusicPlay;
        long dirtyFlags2;
        Drawable drawable;
        ObservableInt id8ViewModelMediaInfoMaxProgress;
        ObservableField<String> id8ViewModelMediaInfoMusicName;
        String id8ViewModelBtMusicNameGet2;
        ObservableInt id8ViewModelBtMusicMaxProgress;
        ObservableField<String> id8ViewModelBtMusicTotalTime;
        ObservableBoolean id8ViewModelBtMusicPlayStatus;
        long dirtyFlags3;
        Drawable drawable2;
        ObservableInt id8ViewModelBtMusicProgress;
        ObservableField<String> id8ViewModelBtMusicName;
        ObservableField<String> id8ViewModelBtMusicCurrentTime;
        ObservableField<BitmapDrawable> id8ViewModelMediaInfoPic;
        ObservableBoolean id8ViewModelId8BtMusicType;
        ObservableField<String> id8ViewModelId8MusicCardName;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String id8ViewModelBtMusicNameGet3 = null;
        Drawable id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector2 = null;
        ObservableField<String> id8ViewModelBtMusicAtist = null;
        ObservableField<String> id8ViewModelMediaInfoTotalTime = null;
        int id8ViewModelMediaInfoMaxProgressGet = 0;
        String id8ViewModelBtMusicAtistGet = null;
        boolean id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNull = false;
        int id8ViewModelBtMusicProgressGet = 0;
        Id8UgLauncherViewModel id8ViewModel = this.mId8ViewModel;
        boolean id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNull = false;
        int id8ViewModelBtMusicMaxProgressGet = 0;
        String id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName = null;
        String id8ViewModelMediaInfoMusicNameGet = null;
        Boolean id8ViewModelBThirdMusicGet = null;
        String id8ViewModelId8MusicCardNameGet2 = null;
        String id8ViewModelBtMusicCurrentTimeGet = null;
        boolean id8ViewModelId8BtMusicTypeGet = false;
        Boolean id8ViewModelMediaInfoMusicPlayGet = null;
        int id8ViewModelMediaInfoProgressGet = 0;
        String id8ViewModelMediaInfoTotalTimeGet = null;
        boolean id8ViewModelBtMusicPlayStatusGet = false;
        String id8ViewModelMediaInfoCurrentTimeGet = null;
        String id8ViewModelMediaInfoMusicAtistGet = null;
        String id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist = null;
        if ((dirtyFlags & 1040383) != 0) {
            if ((dirtyFlags & 786448) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelId8MusicCardName = id8ViewModel.id8MusicCardName;
                } else {
                    id8ViewModelId8MusicCardName = null;
                }
                id8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = null;
                updateRegistration(4, id8ViewModelId8MusicCardName);
                if (id8ViewModelId8MusicCardName != null) {
                    id8ViewModelId8MusicCardNameGet2 = id8ViewModelId8MusicCardName.get();
                }
            } else {
                id8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = null;
            }
            if ((dirtyFlags & 1040367) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelId8BtMusicType = id8ViewModel.id8BtMusicType;
                } else {
                    id8ViewModelId8BtMusicType = null;
                }
                updateRegistration(14, id8ViewModelId8BtMusicType);
                if (id8ViewModelId8BtMusicType != null) {
                    id8ViewModelId8BtMusicTypeGet = id8ViewModelId8BtMusicType.get();
                }
                if ((dirtyFlags & 802882) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 134217728;
                    } else {
                        dirtyFlags |= 67108864;
                    }
                }
                if ((dirtyFlags & 802816) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags = dirtyFlags | 536870912 | 2199023255552L;
                    } else {
                        dirtyFlags = dirtyFlags | 268435456 | 1099511627776L;
                    }
                }
                if ((dirtyFlags & 835584) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 2147483648L;
                    } else {
                        dirtyFlags |= 1073741824;
                    }
                }
                if ((dirtyFlags & 802945) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 8589934592L;
                    } else {
                        dirtyFlags |= 4294967296L;
                    }
                }
                if ((dirtyFlags & 17592186847520L) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 137438953472L;
                    } else {
                        dirtyFlags |= 68719476736L;
                    }
                }
                if ((dirtyFlags & 805888) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 549755813888L;
                    } else {
                        dirtyFlags |= 274877906944L;
                    }
                }
                if ((dirtyFlags & 868864) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 8796093022208L;
                    } else {
                        dirtyFlags |= 4398046511104L;
                    }
                }
                if ((dirtyFlags & 17180676100L) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 140737488355328L;
                    } else {
                        dirtyFlags |= 70368744177664L;
                    }
                }
                if ((dirtyFlags & 933896) != 0) {
                    if (id8ViewModelId8BtMusicTypeGet) {
                        dirtyFlags |= 562949953421312L;
                    } else {
                        dirtyFlags |= 281474976710656L;
                    }
                }
                if ((dirtyFlags & 802816) != 0) {
                    id8ViewModelId8BtMusicTypeViewGONEViewVISIBLE = id8ViewModelId8BtMusicTypeGet ? 8 : 0;
                    id8ViewModelId8MusicCardNameGet = id8ViewModelId8MusicCardNameGet2;
                    id8ViewModelMediaInfoCurrentTime = null;
                    id8ViewModelId8BtMusicTypeViewVISIBLEViewGONE = id8ViewModelId8BtMusicTypeGet ? 0 : 8;
                } else {
                    id8ViewModelId8BtMusicTypeViewGONEViewVISIBLE = 0;
                    id8ViewModelId8MusicCardNameGet = id8ViewModelId8MusicCardNameGet2;
                    id8ViewModelMediaInfoCurrentTime = null;
                    id8ViewModelId8BtMusicTypeViewVISIBLEViewGONE = 0;
                }
            } else {
                id8ViewModelId8BtMusicTypeViewGONEViewVISIBLE = 0;
                id8ViewModelId8MusicCardNameGet = id8ViewModelId8MusicCardNameGet2;
                id8ViewModelMediaInfoCurrentTime = null;
                id8ViewModelId8BtMusicTypeViewVISIBLEViewGONE = 0;
            }
        } else {
            id8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = null;
            id8ViewModelId8BtMusicTypeViewGONEViewVISIBLE = 0;
            id8ViewModelId8MusicCardNameGet = null;
            id8ViewModelMediaInfoCurrentTime = null;
            id8ViewModelId8BtMusicTypeViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 532480) != 0) {
            id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = 0;
            MediaInfo id8ViewModelMediaInfo = Id8UgLauncherViewModel.mediaInfo;
            if (id8ViewModelMediaInfo != null) {
                id8ViewModelBtMusicTotalTimeGet = null;
                id8ViewModelMediaInfoPic = id8ViewModelMediaInfo.pic;
            } else {
                id8ViewModelBtMusicTotalTimeGet = null;
                id8ViewModelMediaInfoPic = null;
            }
            updateRegistration(13, id8ViewModelMediaInfoPic);
            id8ViewModelMediaInfoPicGet = id8ViewModelMediaInfoPic != null ? id8ViewModelMediaInfoPic.get() : null;
        } else {
            id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = 0;
            id8ViewModelBtMusicTotalTimeGet = null;
            id8ViewModelMediaInfoPicGet = null;
        }
        if ((dirtyFlags & 713179453718528L) != 0) {
            if ((dirtyFlags & 8589934592L) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicMaxProgress = id8ViewModel.btMusicMaxProgress;
                } else {
                    id8ViewModelBtMusicMaxProgress = null;
                }
                id8ViewModelBtMusicNameGet2 = null;
                updateRegistration(0, id8ViewModelBtMusicMaxProgress);
                if (id8ViewModelBtMusicMaxProgress != null) {
                    id8ViewModelBtMusicMaxProgressGet = id8ViewModelBtMusicMaxProgress.get();
                }
            } else {
                id8ViewModelBtMusicNameGet2 = null;
                id8ViewModelBtMusicMaxProgress = null;
            }
            if ((dirtyFlags & 140737488355328L) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicAtist = id8ViewModel.btMusicAtist;
                }
                updateRegistration(2, id8ViewModelBtMusicAtist);
                if (id8ViewModelBtMusicAtist != null) {
                    id8ViewModelBtMusicAtistGet = id8ViewModelBtMusicAtist.get();
                }
            }
            if ((dirtyFlags & 134217728) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicCurrentTime = id8ViewModel.btMusicCurrentTime;
                } else {
                    id8ViewModelBtMusicCurrentTime = null;
                }
                updateRegistration(6, id8ViewModelBtMusicCurrentTime);
                if (id8ViewModelBtMusicCurrentTime != null) {
                    id8ViewModelBtMusicCurrentTimeGet = id8ViewModelBtMusicCurrentTime.get();
                }
            }
            if ((137438953472L & dirtyFlags) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicName = id8ViewModel.btMusicName;
                } else {
                    id8ViewModelBtMusicName = null;
                }
                updateRegistration(8, id8ViewModelBtMusicName);
                if (id8ViewModelBtMusicName != null) {
                    id8ViewModelBtMusicNameGet2 = id8ViewModelBtMusicName.get();
                }
            }
            if ((dirtyFlags & 549755813888L) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicProgress = id8ViewModel.btMusicProgress;
                } else {
                    id8ViewModelBtMusicProgress = null;
                }
                updateRegistration(10, id8ViewModelBtMusicProgress);
                if (id8ViewModelBtMusicProgress != null) {
                    id8ViewModelBtMusicProgressGet = id8ViewModelBtMusicProgress.get();
                }
            }
            if ((dirtyFlags & 8796093022208L) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicPlayStatus = id8ViewModel.btMusicPlayStatus;
                } else {
                    id8ViewModelBtMusicPlayStatus = null;
                }
                updateRegistration(16, id8ViewModelBtMusicPlayStatus);
                if (id8ViewModelBtMusicPlayStatus != null) {
                    id8ViewModelBtMusicPlayStatusGet = id8ViewModelBtMusicPlayStatus.get();
                }
                if ((dirtyFlags & 8796093022208L) != 0) {
                    if (id8ViewModelBtMusicPlayStatusGet) {
                        dirtyFlags |= 8388608;
                    } else {
                        dirtyFlags |= 4194304;
                    }
                }
                if (id8ViewModelBtMusicPlayStatusGet) {
                    dirtyFlags3 = dirtyFlags;
                    drawable2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.evoid8_music_play_selector);
                } else {
                    dirtyFlags3 = dirtyFlags;
                    drawable2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.evoid8_music_pause_selector);
                }
                id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector2 = drawable2;
                dirtyFlags = dirtyFlags3;
            }
            if ((562949953421312L & dirtyFlags) != 0) {
                if (id8ViewModel != null) {
                    id8ViewModelBtMusicTotalTime = id8ViewModel.btMusicTotalTime;
                } else {
                    id8ViewModelBtMusicTotalTime = null;
                }
                updateRegistration(17, id8ViewModelBtMusicTotalTime);
                if (id8ViewModelBtMusicTotalTime != null) {
                    id8ViewModelBtMusicTotalTimeGet2 = id8ViewModelBtMusicTotalTime.get();
                    id8ViewModelBtMusicNameGet3 = id8ViewModelBtMusicNameGet2;
                } else {
                    id8ViewModelBtMusicTotalTimeGet2 = id8ViewModelBtMusicTotalTimeGet;
                    id8ViewModelBtMusicNameGet3 = id8ViewModelBtMusicNameGet2;
                }
            } else {
                id8ViewModelBtMusicTotalTimeGet2 = id8ViewModelBtMusicTotalTimeGet;
                id8ViewModelBtMusicNameGet3 = id8ViewModelBtMusicNameGet2;
            }
        } else {
            id8ViewModelBtMusicTotalTimeGet2 = id8ViewModelBtMusicTotalTimeGet;
        }
        if ((dirtyFlags & 1073741824) != 0) {
            ObservableField<Boolean> id8ViewModelBThirdMusic = Id8UgLauncherViewModel.bThirdMusic;
            id8ViewModelBtMusicTotalTimeGet3 = id8ViewModelBtMusicTotalTimeGet2;
            updateRegistration(15, id8ViewModelBThirdMusic);
            if (id8ViewModelBThirdMusic != null) {
                id8ViewModelBThirdMusicGet = id8ViewModelBThirdMusic.get();
            }
            boolean id8ViewModelBThirdMusicBooleanTrue = ViewDataBinding.safeUnbox(id8ViewModelBThirdMusicGet);
            if ((dirtyFlags & 1073741824) != 0) {
                if (id8ViewModelBThirdMusicBooleanTrue) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
            }
            id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2 = id8ViewModelBThirdMusicBooleanTrue ? 8 : 0;
        } else {
            id8ViewModelBtMusicTotalTimeGet3 = id8ViewModelBtMusicTotalTimeGet2;
            id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2 = id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE;
        }
        if ((dirtyFlags & 356589726859264L) != 0) {
            MediaInfo id8ViewModelMediaInfo2 = Id8UgLauncherViewModel.mediaInfo;
            if ((dirtyFlags & 67108864) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE3 = id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2;
                    id8ViewModelMediaInfoCurrentTime2 = id8ViewModelMediaInfo2.currentTime;
                } else {
                    id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE3 = id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2;
                    id8ViewModelMediaInfoCurrentTime2 = id8ViewModelMediaInfoCurrentTime;
                }
                id8ViewModelBtMusicNameGet = id8ViewModelBtMusicNameGet3;
                updateRegistration(1, id8ViewModelMediaInfoCurrentTime2);
                if (id8ViewModelMediaInfoCurrentTime2 != null) {
                    id8ViewModelMediaInfoCurrentTimeGet = id8ViewModelMediaInfoCurrentTime2.get();
                }
            } else {
                id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE3 = id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2;
                id8ViewModelBtMusicNameGet = id8ViewModelBtMusicNameGet3;
                id8ViewModelMediaInfoCurrentTime2 = id8ViewModelMediaInfoCurrentTime;
            }
            if ((dirtyFlags & 281474976710656L) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelMediaInfoTotalTime = id8ViewModelMediaInfo2.totalTime;
                }
                updateRegistration(3, id8ViewModelMediaInfoTotalTime);
                if (id8ViewModelMediaInfoTotalTime != null) {
                    id8ViewModelMediaInfoTotalTimeGet = id8ViewModelMediaInfoTotalTime.get();
                }
            }
            if ((dirtyFlags & 68719476736L) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelMediaInfoMusicName = id8ViewModelMediaInfo2.musicName;
                } else {
                    id8ViewModelMediaInfoMusicName = null;
                }
                updateRegistration(5, id8ViewModelMediaInfoMusicName);
                if (id8ViewModelMediaInfoMusicName != null) {
                    id8ViewModelMediaInfoMusicNameGet = id8ViewModelMediaInfoMusicName.get();
                }
            }
            if ((dirtyFlags & 4294967296L) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelMediaInfoMaxProgress = id8ViewModelMediaInfo2.maxProgress;
                } else {
                    id8ViewModelMediaInfoMaxProgress = null;
                }
                updateRegistration(7, id8ViewModelMediaInfoMaxProgress);
                if (id8ViewModelMediaInfoMaxProgress != null) {
                    id8ViewModelMediaInfoMaxProgressGet = id8ViewModelMediaInfoMaxProgress.get();
                }
            }
            if ((dirtyFlags & 4398046511104L) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelMediaInfoMusicPlay = id8ViewModelMediaInfo2.musicPlay;
                } else {
                    id8ViewModelMediaInfoMusicPlay = null;
                }
                updateRegistration(9, id8ViewModelMediaInfoMusicPlay);
                if (id8ViewModelMediaInfoMusicPlay != null) {
                    id8ViewModelMediaInfoMusicPlayGet = id8ViewModelMediaInfoMusicPlay.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxId8ViewModelMediaInfoMusicPlayGet = ViewDataBinding.safeUnbox(id8ViewModelMediaInfoMusicPlayGet);
                if ((dirtyFlags & 4398046511104L) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxId8ViewModelMediaInfoMusicPlayGet) {
                        dirtyFlags |= 33554432;
                    } else {
                        dirtyFlags |= 16777216;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxId8ViewModelMediaInfoMusicPlayGet) {
                    dirtyFlags2 = dirtyFlags;
                    drawable = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.evoid8_music_play_selector);
                } else {
                    dirtyFlags2 = dirtyFlags;
                    drawable = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.evoid8_music_pause_selector);
                }
                id8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = drawable;
                dirtyFlags = dirtyFlags2;
            }
            if ((dirtyFlags & 274877906944L) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelMediaInfoProgress = id8ViewModelMediaInfo2.progress;
                } else {
                    id8ViewModelMediaInfoProgress = null;
                }
                updateRegistration(11, id8ViewModelMediaInfoProgress);
                if (id8ViewModelMediaInfoProgress != null) {
                    id8ViewModelMediaInfoProgressGet = id8ViewModelMediaInfoProgress.get();
                }
            }
            if ((dirtyFlags & 70368744177664L) != 0) {
                if (id8ViewModelMediaInfo2 != null) {
                    id8ViewModelMediaInfoMusicAtist = id8ViewModelMediaInfo2.musicAtist;
                } else {
                    id8ViewModelMediaInfoMusicAtist = null;
                }
                updateRegistration(12, id8ViewModelMediaInfoMusicAtist);
                if (id8ViewModelMediaInfoMusicAtist != null) {
                    id8ViewModelMediaInfoMusicAtistGet = id8ViewModelMediaInfoMusicAtist.get();
                }
            }
        } else {
            id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE3 = id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE2;
            id8ViewModelBtMusicNameGet = id8ViewModelBtMusicNameGet3;
        }
        if ((dirtyFlags & 802882) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicCurrentTimeId8ViewModelMediaInfoCurrentTime = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicCurrentTimeGet : id8ViewModelMediaInfoCurrentTimeGet;
        } else {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicCurrentTimeId8ViewModelMediaInfoCurrentTime = null;
        }
        if ((dirtyFlags & 835584) != 0) {
            id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = id8ViewModelId8BtMusicTypeGet ? 0 : id8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE3;
        } else {
            id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE = 0;
        }
        if ((dirtyFlags & 802945) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicMaxProgressId8ViewModelMediaInfoMaxProgress = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicMaxProgressGet : id8ViewModelMediaInfoMaxProgressGet;
        } else {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicMaxProgressId8ViewModelMediaInfoMaxProgress = 0;
        }
        if ((dirtyFlags & 803104) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicNameGet : id8ViewModelMediaInfoMusicNameGet;
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNull = id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName == null;
            if ((dirtyFlags & 803104) != 0) {
                if (id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNull) {
                    dirtyFlags |= 35184372088832L;
                } else {
                    dirtyFlags |= 17592186044416L;
                }
            }
        }
        if ((dirtyFlags & 805888) != 0) {
            id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector2;
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicProgressId8ViewModelMediaInfoProgress = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicProgressGet : id8ViewModelMediaInfoProgressGet;
        } else {
            id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector2;
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicProgressId8ViewModelMediaInfoProgress = 0;
        }
        if ((dirtyFlags & 868864) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelectorId8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector : id8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector;
        } else {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelectorId8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector = null;
        }
        if ((dirtyFlags & 806916) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicAtistGet : id8ViewModelMediaInfoMusicAtistGet;
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNull = id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist == null;
            if ((dirtyFlags & 806916) != 0) {
                if (id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNull) {
                    dirtyFlags |= 34359738368L;
                } else {
                    dirtyFlags |= 17179869184L;
                }
            }
        }
        if ((dirtyFlags & 933896) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicTotalTimeId8ViewModelMediaInfoTotalTime = id8ViewModelId8BtMusicTypeGet ? id8ViewModelBtMusicTotalTimeGet3 : id8ViewModelMediaInfoTotalTimeGet;
        } else {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicTotalTimeId8ViewModelMediaInfoTotalTime = null;
        }
        if ((dirtyFlags & 806916) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNullMboundView13AndroidStringKswIdf7UnknowArtisId8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist = id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNull ? this.mboundView13.getResources().getString(R.string.ksw_idf7_unknow_artis) : id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist;
        } else {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNullMboundView13AndroidStringKswIdf7UnknowArtisId8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist = null;
        }
        if ((dirtyFlags & 803104) != 0) {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNullMboundView12AndroidStringEvoid8MusicNotPlayId8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName = id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNull ? this.mboundView12.getResources().getString(R.string.evoid8_music_not_play) : id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName;
        } else {
            id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNullMboundView12AndroidStringEvoid8MusicNotPlayId8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName = null;
        }
        if ((dirtyFlags & 802816) != 0) {
            this.id8MusicIcon.setVisibility(id8ViewModelId8BtMusicTypeViewGONEViewVISIBLE);
            this.id8MusicIcon1.setVisibility(id8ViewModelId8BtMusicTypeViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 532480) != 0) {
            Id8UgLauncherViewModel.setID8UgMusicAlbumIcon(this.id8MusicIcon, id8ViewModelMediaInfoPicGet);
        }
        if ((dirtyFlags & 802945) != 0) {
            this.id8MusicSeekBar.setMax(id8ViewModelId8BtMusicTypeId8ViewModelBtMusicMaxProgressId8ViewModelMediaInfoMaxProgress);
        }
        if ((dirtyFlags & 805888) != 0) {
            SeekBarBindingAdapter.setProgress(this.id8MusicSeekBar, id8ViewModelId8BtMusicTypeId8ViewModelBtMusicProgressId8ViewModelMediaInfoProgress);
        }
        if ((dirtyFlags & 786448) != 0) {
            TextViewBindingAdapter.setText(this.id8UgCardViewTitle, id8ViewModelId8MusicCardNameGet);
        }
        if ((dirtyFlags & 835584) != 0) {
            this.id8UgMusicBottomCl.setVisibility(id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView10.setVisibility(id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView11.setVisibility(id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView4.setVisibility(id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
            this.mboundView9.setVisibility(id8ViewModelId8BtMusicTypeViewVISIBLEId8ViewModelBThirdMusicBooleanTrueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
            this.id9MusicNext.setOnClickListener(this.mCallback578);
            this.id9MusicPrev.setOnClickListener(this.mCallback577);
            this.mboundView4.setOnClickListener(this.mCallback576);
        }
        if ((dirtyFlags & 933896) != 0) {
            TextViewBindingAdapter.setText(this.mboundView10, id8ViewModelId8BtMusicTypeId8ViewModelBtMusicTotalTimeId8ViewModelMediaInfoTotalTime);
        }
        if ((dirtyFlags & 803104) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, id8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicNameJavaLangObjectNullMboundView12AndroidStringEvoid8MusicNotPlayId8ViewModelId8BtMusicTypeId8ViewModelBtMusicNameId8ViewModelMediaInfoMusicName);
        }
        if ((dirtyFlags & 806916) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, id8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtistJavaLangObjectNullMboundView13AndroidStringKswIdf7UnknowArtisId8ViewModelId8BtMusicTypeId8ViewModelBtMusicAtistId8ViewModelMediaInfoMusicAtist);
        }
        if ((dirtyFlags & 868864) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, id8ViewModelId8BtMusicTypeId8ViewModelBtMusicPlayStatusMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelectorId8ViewModelMediaInfoMusicPlayMboundView4AndroidDrawableEvoid8MusicPlaySelectorMboundView4AndroidDrawableEvoid8MusicPauseSelector);
        }
        if ((dirtyFlags & 802882) != 0) {
            TextViewBindingAdapter.setText(this.mboundView9, id8ViewModelId8BtMusicTypeId8ViewModelBtMusicCurrentTimeId8ViewModelMediaInfoCurrentTime);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean id8ViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                Id8UgLauncherViewModel id8ViewModel = this.mId8ViewModel;
                if (id8ViewModel == null) {
                    id8ViewModelJavaLangObjectNull = false;
                }
                if (id8ViewModelJavaLangObjectNull) {
                    id8ViewModel.id8UgMusicPlayOrPause(callbackArg_0);
                    return;
                }
                return;
            case 2:
                Id8UgLauncherViewModel id8ViewModel2 = this.mId8ViewModel;
                if (id8ViewModel2 == null) {
                    id8ViewModelJavaLangObjectNull = false;
                }
                if (id8ViewModelJavaLangObjectNull) {
                    id8ViewModel2.id8UgMusicPre(callbackArg_0);
                    return;
                }
                return;
            case 3:
                Id8UgLauncherViewModel id8ViewModel3 = this.mId8ViewModel;
                if (id8ViewModel3 == null) {
                    id8ViewModelJavaLangObjectNull = false;
                }
                if (id8ViewModelJavaLangObjectNull) {
                    id8ViewModel3.id8UgMusicNext(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
