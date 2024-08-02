package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public class Benz2021FragmentTwoImpl extends Benz2021FragmentTwo {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final BenzMbuxItemView mboundView3;
    private final BenzMbuxItemView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.video_rl, 7);
        sparseIntArray.put(R.id.video_tv, 8);
        sparseIntArray.put(R.id.bt_tip, 9);
        sparseIntArray.put(R.id.iv_video1, 10);
        sparseIntArray.put(R.id.space1, 11);
        sparseIntArray.put(R.id.iv_video2, 12);
        sparseIntArray.put(R.id.music_rl, 13);
        sparseIntArray.put(R.id.music_tv, 14);
        sparseIntArray.put(R.id.iv_music1, 15);
        sparseIntArray.put(R.id.space2, 16);
        sparseIntArray.put(R.id.iv_music2, 17);
        sparseIntArray.put(R.id.car_rl, 18);
        sparseIntArray.put(R.id.set_tv, 19);
        sparseIntArray.put(R.id.set_tip, 20);
        sparseIntArray.put(R.id.iv_set1, 21);
        sparseIntArray.put(R.id.space, 22);
        sparseIntArray.put(R.id.iv_set2, 23);
    }

    public Benz2021FragmentTwoImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private Benz2021FragmentTwoImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (TextView) bindings[9], (RelativeLayout) bindings[18], (LinearLayout) bindings[0], (ImageView) bindings[15], (ImageView) bindings[17], (ImageView) bindings[21], (ImageView) bindings[23], (ImageView) bindings[10], (ImageView) bindings[12], (FrameLayout) bindings[2], (RelativeLayout) bindings[13], (TextView) bindings[5], (TextView) bindings[14], (BenzMbuxItemView) bindings[6], (TextView) bindings[20], (TextView) bindings[19], (View) bindings[22], (View) bindings[11], (View) bindings[16], (BenzMbuxItemView) bindings[1], (RelativeLayout) bindings[7], (TextView) bindings[8]);
        this.mDirtyFlags = -1;
        this.fragmentTwoLl.setTag(null);
        BenzMbuxItemView benzMbuxItemView = (BenzMbuxItemView) bindings[3];
        this.mboundView3 = benzMbuxItemView;
        benzMbuxItemView.setTag(null);
        BenzMbuxItemView benzMbuxItemView2 = (BenzMbuxItemView) bindings[4];
        this.mboundView4 = benzMbuxItemView2;
        benzMbuxItemView2.setTag(null);
        this.musicItemview.setTag(null);
        this.musicTip.setTag(null);
        this.setItemview.setTag(null);
        this.videoItemview.setTag(null);
        setRootTag(root);
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
        if (36 != variableId) {
            return false;
        }
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Benz2021FragmentTwo
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelMediaInfoSongInfo((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelIsYO((ObservableBoolean) object, fieldId);
            case 3:
                return onChangeViewModelMediaInfoPicZoom((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelMediaInfoPic((ObservableField) object, fieldId);
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

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsYO(ObservableBoolean ViewModelIsYO, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoPicZoom(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r69v0, types: [com.wits.ksw.databinding.Benz2021FragmentTwoImpl] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1;
        MediaInfo viewModelMediaInfo;
        int viewModelMediaInfoPicJavaLangObjectNullViewVISIBLEViewGONE;
        String viewModelMediaInfoSongInfoGet;
        Drawable viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom;
        String viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo;
        Drawable viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom2;
        Drawable viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector12;
        Drawable viewModelItemIconClassicalViewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector2;
        Drawable viewModelMediaInfoPicZoomGet;
        Drawable viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom;
        Drawable drawable;
        ObservableBoolean viewModelIsYO;
        Drawable viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector13;
        Drawable viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector14;
        int i;
        Context context;
        int i2;
        Context context2;
        ObservableField<BitmapDrawable> viewModelMediaInfoPicZoom;
        String viewModelMediaInfoSongInfoGet2;
        ObservableField<String> viewModelMediaInfoSongInfo;
        ObservableField<BitmapDrawable> viewModelMediaInfoPic;
        long dirtyFlags2;
        int i3;
        Context context3;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = 0;
        Drawable viewModelItemIconClassicalViewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector2 = null;
        Drawable viewModelMediaInfoPicZoomGet2 = null;
        ObservableBoolean viewModelItemIconClassical = null;
        BitmapDrawable viewModelMediaInfoPicGet = null;
        boolean viewModelIsYOGet = false;
        Drawable viewModelMediaInfoPicJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector = null;
        boolean viewModelMediaInfoPicJavaLangObjectNull = false;
        Drawable viewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2 = null;
        Drawable viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2 = null;
        boolean viewModelMediaInfoSongInfoJavaLangObjectNull = false;
        boolean viewModelItemIconClassicalGet = false;
        Drawable viewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1 = null;
        Drawable viewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1 = null;
        BcVieModel viewModel = ((Benz2021FragmentTwoImpl) this).mViewModel;
        String viewModelMediaInfoSongInfoGet3 = null;
        if ((dirtyFlags & 127) != 0) {
            MediaInfo viewModelMediaInfo2 = BcVieModel.mediaInfo;
            if ((dirtyFlags & 65) != 0) {
                if (viewModelMediaInfo2 != null) {
                    viewModelMediaInfoSongInfo = viewModelMediaInfo2.songInfo;
                } else {
                    viewModelMediaInfoSongInfo = null;
                }
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1 = null;
                updateRegistration(0, viewModelMediaInfoSongInfo);
                if (viewModelMediaInfoSongInfo != null) {
                    viewModelMediaInfoSongInfoGet2 = viewModelMediaInfoSongInfo.get();
                } else {
                    viewModelMediaInfoSongInfoGet2 = null;
                }
                viewModelMediaInfoSongInfoJavaLangObjectNull = viewModelMediaInfoSongInfoGet2 == null;
                if ((dirtyFlags & 65) != 0) {
                    dirtyFlags = viewModelMediaInfoSongInfoJavaLangObjectNull ? dirtyFlags | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : dirtyFlags | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
            } else {
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1 = null;
                viewModelMediaInfoSongInfo = null;
                viewModelMediaInfoSongInfoGet2 = null;
            }
            if ((dirtyFlags & 126) != 0) {
                if (viewModelMediaInfo2 != null) {
                    viewModelMediaInfoPic = viewModelMediaInfo2.pic;
                } else {
                    viewModelMediaInfoPic = null;
                }
                updateRegistration(4, viewModelMediaInfoPic);
                if (viewModelMediaInfoPic != null) {
                    viewModelMediaInfoPicGet = viewModelMediaInfoPic.get();
                }
                viewModelMediaInfoPicJavaLangObjectNull = viewModelMediaInfoPicGet == null;
                if ((dirtyFlags & 80) != 0) {
                    if (viewModelMediaInfoPicJavaLangObjectNull) {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | 1073741824;
                    } else {
                        dirtyFlags = dirtyFlags | 512 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 536870912;
                    }
                }
                if ((dirtyFlags & 122) != 0) {
                    if (viewModelMediaInfoPicJavaLangObjectNull) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                }
                if ((dirtyFlags & 126) != 0) {
                    if (viewModelMediaInfoPicJavaLangObjectNull) {
                        dirtyFlags |= 67108864;
                    } else {
                        dirtyFlags |= 33554432;
                    }
                }
                if ((dirtyFlags & 80) != 0) {
                    viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelMediaInfoPicJavaLangObjectNull ? 8 : 0;
                    if (viewModelMediaInfoPicJavaLangObjectNull) {
                        context3 = ((Benz2021FragmentTwoImpl) this).musicItemview.getContext();
                        dirtyFlags2 = dirtyFlags;
                        i3 = R.drawable.transp;
                    } else {
                        dirtyFlags2 = dirtyFlags;
                        context3 = ((Benz2021FragmentTwoImpl) this).musicItemview.getContext();
                        i3 = R.drawable.benz_mbux_2021_album_selector;
                    }
                    viewModelMediaInfoPicJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector = AppCompatResources.getDrawable(context3, i3);
                    viewModelMediaInfoPicJavaLangObjectNullViewVISIBLEViewGONE = viewModelMediaInfoPicJavaLangObjectNull ? 0 : 8;
                    viewModelMediaInfo = viewModelMediaInfo2;
                    dirtyFlags = dirtyFlags2;
                    viewModelMediaInfoSongInfoGet3 = viewModelMediaInfoSongInfoGet2;
                } else {
                    viewModelMediaInfoPicJavaLangObjectNullViewVISIBLEViewGONE = 0;
                    viewModelMediaInfo = viewModelMediaInfo2;
                    viewModelMediaInfoSongInfoGet3 = viewModelMediaInfoSongInfoGet2;
                }
            } else {
                viewModelMediaInfoPicJavaLangObjectNullViewVISIBLEViewGONE = 0;
                viewModelMediaInfo = viewModelMediaInfo2;
                viewModelMediaInfoSongInfoGet3 = viewModelMediaInfoSongInfoGet2;
            }
        } else {
            viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1 = null;
            viewModelMediaInfo = null;
            viewModelMediaInfoPicJavaLangObjectNullViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 102) != 0) {
            if (viewModel != null) {
                viewModelItemIconClassical = viewModel.itemIconClassical;
            }
            viewModelMediaInfoSongInfoGet = viewModelMediaInfoSongInfoGet3;
            updateRegistration(1, viewModelItemIconClassical);
            if (viewModelItemIconClassical != null) {
                viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
            }
            if ((dirtyFlags & 102) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE | 268435456;
                } else {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_URI | 134217728;
                }
            }
            if ((dirtyFlags & 67108864) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags |= 4194304;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                }
            }
        } else {
            viewModelMediaInfoSongInfoGet = viewModelMediaInfoSongInfoGet3;
        }
        if ((dirtyFlags & 65) == 0) {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom = null;
            viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = null;
        } else if (viewModelMediaInfoSongInfoJavaLangObjectNull) {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom = null;
            viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = ((Benz2021FragmentTwoImpl) this).musicTip.getResources().getString(R.string.ksw_idf7_unkonw_soung);
        } else {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom = null;
            viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = viewModelMediaInfoSongInfoGet;
        }
        if ((dirtyFlags & 33556480) != 0) {
            if (viewModelMediaInfo != null) {
                viewModelMediaInfoPicZoom = viewModelMediaInfo.picZoom;
            } else {
                viewModelMediaInfoPicZoom = null;
            }
            updateRegistration(3, viewModelMediaInfoPicZoom);
            if (viewModelMediaInfoPicZoom != null) {
                viewModelMediaInfoPicZoomGet2 = (BitmapDrawable) viewModelMediaInfoPicZoom.get();
            }
        }
        if ((dirtyFlags & 67112960) != 0) {
            if (viewModel != null) {
                viewModelItemIconClassical = viewModel.itemIconClassical;
            }
            updateRegistration(1, viewModelItemIconClassical);
            if (viewModelItemIconClassical != null) {
                viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
            }
            if ((dirtyFlags & 102) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE | 268435456;
                } else {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_URI | 134217728;
                }
            }
            if ((dirtyFlags & 67108864) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags |= 4194304;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
                viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_home_music_selector1 : R.drawable.benz_mbux_2021_home_music_selector2);
            }
        }
        if ((dirtyFlags & 122) != 0) {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom2 = viewModelMediaInfoPicJavaLangObjectNull ? viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2 : viewModelMediaInfoPicZoomGet2;
        } else {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom2 = viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom;
        }
        if ((dirtyFlags & 268713984) != 0) {
            if (viewModel != null) {
                viewModelIsYO = viewModel.isYO;
            } else {
                viewModelIsYO = null;
            }
            updateRegistration(2, viewModelIsYO);
            if (viewModelIsYO != null) {
                viewModelIsYOGet = viewModelIsYO.get();
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                if (viewModelIsYOGet) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                if (viewModelIsYOGet) {
                    dirtyFlags |= 16777216;
                } else {
                    dirtyFlags |= 8388608;
                }
            }
            if ((dirtyFlags & 268435456) != 0) {
                if (viewModelIsYOGet) {
                    dirtyFlags |= 4294967296L;
                } else {
                    dirtyFlags |= 2147483648L;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                if (viewModelIsYOGet) {
                    context2 = ((Benz2021FragmentTwoImpl) this).setItemview.getContext();
                    i2 = R.drawable.benz_mbux_yo_home_setting_selector1;
                } else {
                    context2 = ((Benz2021FragmentTwoImpl) this).setItemview.getContext();
                    i2 = R.drawable.benz_mbux_2021_home_setting_selector1;
                }
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector13 = AppCompatResources.getDrawable(context2, i2);
            } else {
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector13 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1;
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                if (viewModelIsYOGet) {
                    context = this.mboundView3.getContext();
                    viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector14 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector13;
                    i = R.drawable.benz_mbux_yo_home_music_selector1;
                } else {
                    viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector14 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector13;
                    context = this.mboundView3.getContext();
                    i = R.drawable.benz_mbux_2021_home_music_selector1;
                }
                viewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1 = AppCompatResources.getDrawable(context, i);
            } else {
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector14 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector13;
            }
            if ((dirtyFlags & 268435456) != 0) {
                viewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1 = AppCompatResources.getDrawable(((Benz2021FragmentTwoImpl) this).videoItemview.getContext(), viewModelIsYOGet ? R.drawable.benz_mbux_yo_home_video_selector1 : R.drawable.benz_mbux_2021_home_video_selector1);
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector12 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector14;
            } else {
                viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector12 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector14;
            }
        } else {
            viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector12 = viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1;
        }
        if ((dirtyFlags & 102) != 0) {
            viewModelItemIconClassicalViewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector2 = viewModelItemIconClassicalGet ? viewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector12 : AppCompatResources.getDrawable(((Benz2021FragmentTwoImpl) this).setItemview.getContext(), R.drawable.benz_mbux_2021_home_setting_selector2);
            viewModelItemIconClassicalViewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector2 = viewModelItemIconClassicalGet ? viewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1 : AppCompatResources.getDrawable(((Benz2021FragmentTwoImpl) this).videoItemview.getContext(), R.drawable.benz_mbux_2021_home_video_selector2);
        } else {
            viewModelItemIconClassicalViewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector2 = null;
        }
        if ((dirtyFlags & 67108864) != 0) {
            if (viewModelItemIconClassicalGet) {
                viewModelMediaInfoPicZoomGet = viewModelMediaInfoPicZoomGet2;
                drawable = viewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1;
            } else {
                viewModelMediaInfoPicZoomGet = viewModelMediaInfoPicZoomGet2;
                drawable = AppCompatResources.getDrawable(this.mboundView3.getContext(), R.drawable.benz_mbux_2021_home_music_selector2);
            }
            viewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2 = drawable;
        } else {
            viewModelMediaInfoPicZoomGet = viewModelMediaInfoPicZoomGet2;
        }
        if ((dirtyFlags & 126) != 0) {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom = viewModelMediaInfoPicJavaLangObjectNull ? viewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2 : viewModelMediaInfoPicZoomGet;
        } else {
            viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom = null;
        }
        if ((dirtyFlags & 126) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalViewModelIsYOMboundView3AndroidDrawableBenzMbuxYoHomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView3AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom);
        }
        if ((dirtyFlags & 80) != 0) {
            this.mboundView3.setVisibility(viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE);
            this.mboundView4.setVisibility(viewModelMediaInfoPicJavaLangObjectNullViewVISIBLEViewGONE);
            ViewBindingAdapter.setBackground(((Benz2021FragmentTwoImpl) this).musicItemview, viewModelMediaInfoPicJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector);
        }
        if ((dirtyFlags & 122) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelMediaInfoPicJavaLangObjectNullViewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021HomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021HomeMusicSelector2ViewModelMediaInfoPicZoom2);
        }
        if ((dirtyFlags & 65) != 0) {
            TextViewBindingAdapter.setText(((Benz2021FragmentTwoImpl) this).musicTip, viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo);
        }
        if ((dirtyFlags & 102) != 0) {
            ImageViewBindingAdapter.setImageDrawable(((Benz2021FragmentTwoImpl) this).setItemview, viewModelItemIconClassicalViewModelIsYOSetItemviewAndroidDrawableBenzMbuxYoHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021HomeSettingSelector2);
            ImageViewBindingAdapter.setImageDrawable(((Benz2021FragmentTwoImpl) this).videoItemview, viewModelItemIconClassicalViewModelIsYOVideoItemviewAndroidDrawableBenzMbuxYoHomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector1VideoItemviewAndroidDrawableBenzMbux2021HomeVideoSelector2);
        }
    }
}
