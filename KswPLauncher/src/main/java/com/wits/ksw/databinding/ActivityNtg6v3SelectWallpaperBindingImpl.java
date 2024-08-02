package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3WallpaperSelectViewModel;

public class ActivityNtg6v3SelectWallpaperBindingImpl extends ActivityNtg6v3SelectWallpaperBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback213;
    private final View.OnClickListener mCallback214;
    private final View.OnClickListener mCallback215;
    private final View.OnClickListener mCallback216;
    private final View.OnClickListener mCallback217;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ntg6v3_wallpaper_bg_iv, 11);
        sparseIntArray.put(R.id.ntg6v3_change_theme_main_bg, 12);
        sparseIntArray.put(R.id.menu_ll, 13);
        sparseIntArray.put(R.id.recyclerView, 14);
    }

    public ActivityNtg6v3SelectWallpaperBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private ActivityNtg6v3SelectWallpaperBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (LinearLayout) bindings[13], (RelativeLayout) bindings[12], (LinearLayout) bindings[1], (LinearLayout) bindings[3], (LinearLayout) bindings[9], (LinearLayout) bindings[5], (LinearLayout) bindings[7], (TextView) bindings[2], (ImageView) bindings[4], (ImageView) bindings[10], (ImageView) bindings[6], (ImageView) bindings[8], (ImageView) bindings[11], (RecyclerView) bindings[14]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.ntg6v3DevicesLlAll.setTag(null);
        this.ntg6v3DevicesLlLoc.setTag(null);
        this.ntg6v3DevicesLlSd.setTag(null);
        this.ntg6v3DevicesLlUsb1.setTag(null);
        this.ntg6v3DevicesLlUsb2.setTag(null);
        this.ntg6v3DevicesTvAll.setTag(null);
        this.ntg6v3DevicesTvLoc.setTag(null);
        this.ntg6v3DevicesTvSd.setTag(null);
        this.ntg6v3DevicesTvUsb1.setTag(null);
        this.ntg6v3DevicesTvUsb2.setTag(null);
        setRootTag(root);
        this.mCallback217 = new OnClickListener(this, 5);
        this.mCallback213 = new OnClickListener(this, 1);
        this.mCallback214 = new OnClickListener(this, 2);
        this.mCallback215 = new OnClickListener(this, 3);
        this.mCallback216 = new OnClickListener(this, 4);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        if (23 != variableId) {
            return false;
        }
        setThemeViewModel((Ntg6v3WallpaperSelectViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityNtg6v3SelectWallpaperBinding
    public void setThemeViewModel(Ntg6v3WallpaperSelectViewModel ThemeViewModel) {
        this.mThemeViewModel = ThemeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeThemeViewModelSdStorageField((ObservableField) object, fieldId);
            case 1:
                return onChangeThemeViewModelWallpaperLeftModel((ObservableInt) object, fieldId);
            case 2:
                return onChangeThemeViewModelUsb2StorageField((ObservableField) object, fieldId);
            case 3:
                return onChangeThemeViewModelUsb1StorageField((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeThemeViewModelSdStorageField(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeThemeViewModelWallpaperLeftModel(ObservableInt ThemeViewModelWallpaperLeftModel, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeThemeViewModelUsb2StorageField(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeThemeViewModelUsb1StorageField(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v4 int: [D('constantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1' int), D('themeViewModel' com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3WallpaperSelectViewModel)] */
    /* JADX INFO: Multiple debug info for r6v4 int: [D('constantsNTG6V3THEMEWALLPAPERDEVICESMODELALL' int), D('themeViewModelUsb2StorageFieldGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r8v4 int: [D('textUtilsIsEmptyThemeViewModelSdStorageField' boolean), D('constantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2' int)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE;
        int textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE;
        boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2;
        boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC;
        boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1;
        boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD;
        ObservableField<String> themeViewModelUsb1StorageField;
        ObservableField<String> themeViewModelUsb2StorageField;
        ObservableInt themeViewModelWallpaperLeftModel;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Ntg6v3WallpaperSelectViewModel themeViewModel = this.mThemeViewModel;
        String themeViewModelUsb2StorageFieldGet = null;
        boolean textUtilsIsEmptyThemeViewModelSdStorageField = false;
        int constantsNTG6V3THEMEWALLPAPERDEVICESMODELSD = 0;
        ObservableField<String> themeViewModelSdStorageField = null;
        boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELALL = false;
        int textUtilsIsEmptyThemeViewModelUsb1StorageFieldViewGONEViewVISIBLE = 0;
        String themeViewModelSdStorageFieldGet = null;
        int themeViewModelWallpaperLeftModelGet = 0;
        int textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE2 = 0;
        int textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE2 = 0;
        String themeViewModelUsb1StorageFieldGet = null;
        if ((dirtyFlags & 63) != 0) {
            int i = 8;
            if ((dirtyFlags & 49) != 0) {
                if (themeViewModel != null) {
                    themeViewModelSdStorageField = themeViewModel.sdStorageField;
                }
                updateRegistration(0, themeViewModelSdStorageField);
                if (themeViewModelSdStorageField != null) {
                    themeViewModelSdStorageFieldGet = themeViewModelSdStorageField.get();
                }
                textUtilsIsEmptyThemeViewModelSdStorageField = TextUtils.isEmpty(themeViewModelSdStorageFieldGet);
                if ((dirtyFlags & 49) != 0) {
                    if (textUtilsIsEmptyThemeViewModelSdStorageField) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                }
                textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE2 = textUtilsIsEmptyThemeViewModelSdStorageField ? 8 : 0;
            }
            if ((dirtyFlags & 50) != 0) {
                if (themeViewModel != null) {
                    themeViewModelWallpaperLeftModel = themeViewModel.wallpaperLeftModel;
                } else {
                    themeViewModelWallpaperLeftModel = null;
                }
                updateRegistration(1, themeViewModelWallpaperLeftModel);
                if (themeViewModelWallpaperLeftModel != null) {
                    themeViewModelWallpaperLeftModelGet = themeViewModelWallpaperLeftModel.get();
                }
            }
            if ((dirtyFlags & 52) != 0) {
                if (themeViewModel != null) {
                    themeViewModelUsb2StorageField = themeViewModel.usb2StorageField;
                } else {
                    themeViewModelUsb2StorageField = null;
                }
                updateRegistration(2, themeViewModelUsb2StorageField);
                if (themeViewModelUsb2StorageField != null) {
                    themeViewModelUsb2StorageFieldGet = themeViewModelUsb2StorageField.get();
                }
                boolean textUtilsIsEmptyThemeViewModelUsb2StorageField = TextUtils.isEmpty(themeViewModelUsb2StorageFieldGet);
                if ((dirtyFlags & 52) != 0) {
                    if (textUtilsIsEmptyThemeViewModelUsb2StorageField) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE2 = textUtilsIsEmptyThemeViewModelUsb2StorageField ? 8 : 0;
            }
            if ((dirtyFlags & 56) != 0) {
                if (themeViewModel != null) {
                    themeViewModelUsb1StorageField = themeViewModel.usb1StorageField;
                } else {
                    themeViewModelUsb1StorageField = null;
                }
                updateRegistration(3, themeViewModelUsb1StorageField);
                if (themeViewModelUsb1StorageField != null) {
                    themeViewModelUsb1StorageFieldGet = themeViewModelUsb1StorageField.get();
                }
                boolean textUtilsIsEmptyThemeViewModelUsb1StorageField = TextUtils.isEmpty(themeViewModelUsb1StorageFieldGet);
                if ((dirtyFlags & 56) != 0) {
                    if (textUtilsIsEmptyThemeViewModelUsb1StorageField) {
                        dirtyFlags |= 128;
                    } else {
                        dirtyFlags |= 64;
                    }
                }
                if (!textUtilsIsEmptyThemeViewModelUsb1StorageField) {
                    i = 0;
                }
                textUtilsIsEmptyThemeViewModelUsb1StorageFieldViewGONEViewVISIBLE = i;
                textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE = textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE2;
                textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE = textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE2;
            } else {
                textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE = textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE2;
                textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE = textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE2;
            }
        } else {
            textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE = 0;
            textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE = 0;
        }
        if ((dirtyFlags & 50) != 0) {
            int constantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC = Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_LOC;
            constantsNTG6V3THEMEWALLPAPERDEVICESMODELSD = Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_SD;
            int constantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1 = Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB1;
            int constantsNTG6V3THEMEWALLPAPERDEVICESMODELALL = Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_ALL;
            int constantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2 = Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB2;
            boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC2 = themeViewModelWallpaperLeftModelGet == constantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC;
            boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD2 = themeViewModelWallpaperLeftModelGet == constantsNTG6V3THEMEWALLPAPERDEVICESMODELSD;
            boolean themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB12 = themeViewModelWallpaperLeftModelGet == constantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELALL = themeViewModelWallpaperLeftModelGet == constantsNTG6V3THEMEWALLPAPERDEVICESMODELALL;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD = themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD2;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1 = themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB12;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2 = themeViewModelWallpaperLeftModelGet == constantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC = themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC2;
        } else {
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD = false;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1 = false;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2 = false;
            themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC = false;
        }
        if ((dirtyFlags & 32) != 0) {
            this.ntg6v3DevicesLlAll.setOnClickListener(this.mCallback213);
            this.ntg6v3DevicesLlLoc.setOnClickListener(this.mCallback214);
            this.ntg6v3DevicesLlSd.setOnClickListener(this.mCallback217);
            this.ntg6v3DevicesLlUsb1.setOnClickListener(this.mCallback215);
            this.ntg6v3DevicesLlUsb2.setOnClickListener(this.mCallback216);
        }
        if ((dirtyFlags & 50) != 0) {
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesLlAll, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELALL);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesLlLoc, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesLlSd, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesLlUsb1, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesLlUsb2, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesTvAll, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELALL);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesTvLoc, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELLOC);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesTvSd, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELSD);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesTvUsb1, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB1);
            Ntg6v3WallpaperSelectViewModel.setWallpaperLeftViewSelect(this.ntg6v3DevicesTvUsb2, themeViewModelWallpaperLeftModelConstantsNTG6V3THEMEWALLPAPERDEVICESMODELUSB2);
        }
        if ((dirtyFlags & 49) != 0) {
            this.ntg6v3DevicesLlSd.setVisibility(textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 56) != 0) {
            this.ntg6v3DevicesLlUsb1.setVisibility(textUtilsIsEmptyThemeViewModelUsb1StorageFieldViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 52) != 0) {
            this.ntg6v3DevicesLlUsb2.setVisibility(textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean themeViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                Ntg6v3WallpaperSelectViewModel themeViewModel = this.mThemeViewModel;
                if (themeViewModel == null) {
                    themeViewModelJavaLangObjectNull = false;
                }
                if (themeViewModelJavaLangObjectNull) {
                    themeViewModel.onWallpaperModelIvClick(callbackArg_0, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_ALL);
                    return;
                }
                return;
            case 2:
                Ntg6v3WallpaperSelectViewModel themeViewModel2 = this.mThemeViewModel;
                if (themeViewModel2 == null) {
                    themeViewModelJavaLangObjectNull = false;
                }
                if (themeViewModelJavaLangObjectNull) {
                    themeViewModel2.onWallpaperModelIvClick(callbackArg_0, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_LOC);
                    return;
                }
                return;
            case 3:
                Ntg6v3WallpaperSelectViewModel themeViewModel3 = this.mThemeViewModel;
                if (themeViewModel3 == null) {
                    themeViewModelJavaLangObjectNull = false;
                }
                if (themeViewModelJavaLangObjectNull) {
                    themeViewModel3.onWallpaperModelIvClick(callbackArg_0, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB1);
                    return;
                }
                return;
            case 4:
                Ntg6v3WallpaperSelectViewModel themeViewModel4 = this.mThemeViewModel;
                if (themeViewModel4 == null) {
                    themeViewModelJavaLangObjectNull = false;
                }
                if (themeViewModelJavaLangObjectNull) {
                    themeViewModel4.onWallpaperModelIvClick(callbackArg_0, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB2);
                    return;
                }
                return;
            case 5:
                Ntg6v3WallpaperSelectViewModel themeViewModel5 = this.mThemeViewModel;
                if (themeViewModel5 == null) {
                    themeViewModelJavaLangObjectNull = false;
                }
                if (themeViewModelJavaLangObjectNull) {
                    themeViewModel5.onWallpaperModelIvClick(callbackArg_0, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_SD);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
