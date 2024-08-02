package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel;

public class ActivityId9SelectWallpaperBindingImpl extends ActivityId9SelectWallpaperBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.theme_main_bg, 4);
        sparseIntArray.put(R.id.id9_menu_ll, 5);
        sparseIntArray.put(R.id.id9_devices_loc_ib, 6);
        sparseIntArray.put(R.id.model_title_tv, 7);
        sparseIntArray.put(R.id.recyclerView, 8);
    }

    public ActivityId9SelectWallpaperBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private ActivityId9SelectWallpaperBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (ImageButton) bindings[6], (ImageButton) bindings[3], (ImageButton) bindings[1], (ImageButton) bindings[2], (LinearLayout) bindings[5], (TextView) bindings[7], (RecyclerView) bindings[8], (RelativeLayout) bindings[4]);
        this.mDirtyFlags = -1;
        this.id9DevicesSdIb.setTag(null);
        this.id9DevicesUsb1Ib.setTag(null);
        this.id9DevicesUsb2Ib.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
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
        if (23 != variableId) {
            return false;
        }
        setThemeViewModel((WallpaperSelectViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityId9SelectWallpaperBinding
    public void setThemeViewModel(WallpaperSelectViewModel ThemeViewModel) {
        this.mThemeViewModel = ThemeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeThemeViewModelUsb2StorageField((ObservableField) object, fieldId);
            case 1:
                return onChangeThemeViewModelSdStorageField((ObservableField) object, fieldId);
            case 2:
                return onChangeThemeViewModelUsb1StorageField((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeThemeViewModelUsb2StorageField(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeThemeViewModelSdStorageField(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeThemeViewModelUsb1StorageField(ObservableField<String> observableField, int fieldId) {
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
        ObservableField<String> themeViewModelUsb1StorageField;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        WallpaperSelectViewModel themeViewModel = this.mThemeViewModel;
        String themeViewModelUsb2StorageFieldGet = null;
        ObservableField<String> themeViewModelUsb2StorageField = null;
        ObservableField<String> themeViewModelSdStorageField = null;
        int textUtilsIsEmptyThemeViewModelUsb1StorageFieldViewGONEViewVISIBLE = 0;
        int textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE = 0;
        int textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE = 0;
        String themeViewModelSdStorageFieldGet = null;
        String themeViewModelUsb1StorageFieldGet = null;
        if ((dirtyFlags & 31) != 0) {
            int i = 8;
            if ((dirtyFlags & 25) != 0) {
                if (themeViewModel != null) {
                    themeViewModelUsb2StorageField = themeViewModel.usb2StorageField;
                }
                updateRegistration(0, themeViewModelUsb2StorageField);
                if (themeViewModelUsb2StorageField != null) {
                    themeViewModelUsb2StorageFieldGet = themeViewModelUsb2StorageField.get();
                }
                boolean textUtilsIsEmptyThemeViewModelUsb2StorageField = TextUtils.isEmpty(themeViewModelUsb2StorageFieldGet);
                if ((dirtyFlags & 25) != 0) {
                    if (textUtilsIsEmptyThemeViewModelUsb2StorageField) {
                        dirtyFlags |= 256;
                    } else {
                        dirtyFlags |= 128;
                    }
                }
                textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE = textUtilsIsEmptyThemeViewModelUsb2StorageField ? 8 : 0;
            }
            if ((dirtyFlags & 26) != 0) {
                if (themeViewModel != null) {
                    themeViewModelSdStorageField = themeViewModel.sdStorageField;
                }
                updateRegistration(1, themeViewModelSdStorageField);
                if (themeViewModelSdStorageField != null) {
                    themeViewModelSdStorageFieldGet = themeViewModelSdStorageField.get();
                }
                boolean textUtilsIsEmptyThemeViewModelSdStorageField = TextUtils.isEmpty(themeViewModelSdStorageFieldGet);
                if ((dirtyFlags & 26) != 0) {
                    if (textUtilsIsEmptyThemeViewModelSdStorageField) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= 512;
                    }
                }
                textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE = textUtilsIsEmptyThemeViewModelSdStorageField ? 8 : 0;
            }
            if ((dirtyFlags & 28) != 0) {
                if (themeViewModel != null) {
                    themeViewModelUsb1StorageField = themeViewModel.usb1StorageField;
                } else {
                    themeViewModelUsb1StorageField = null;
                }
                updateRegistration(2, themeViewModelUsb1StorageField);
                if (themeViewModelUsb1StorageField != null) {
                    themeViewModelUsb1StorageFieldGet = themeViewModelUsb1StorageField.get();
                }
                boolean textUtilsIsEmptyThemeViewModelUsb1StorageField = TextUtils.isEmpty(themeViewModelUsb1StorageFieldGet);
                if ((dirtyFlags & 28) != 0) {
                    if (textUtilsIsEmptyThemeViewModelUsb1StorageField) {
                        dirtyFlags |= 64;
                    } else {
                        dirtyFlags |= 32;
                    }
                }
                if (!textUtilsIsEmptyThemeViewModelUsb1StorageField) {
                    i = 0;
                }
                textUtilsIsEmptyThemeViewModelUsb1StorageFieldViewGONEViewVISIBLE = i;
            }
        }
        if ((dirtyFlags & 26) != 0) {
            this.id9DevicesSdIb.setVisibility(textUtilsIsEmptyThemeViewModelSdStorageFieldViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 28) != 0) {
            this.id9DevicesUsb1Ib.setVisibility(textUtilsIsEmptyThemeViewModelUsb1StorageFieldViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 25) != 0) {
            this.id9DevicesUsb2Ib.setVisibility(textUtilsIsEmptyThemeViewModelUsb2StorageFieldViewGONEViewVISIBLE);
        }
    }
}
