package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.LinearGradientID9Progress;

public class BmwId9DashboardLayoutNewBindingImpl extends BmwId9DashboardLayoutNewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mViewModelDashboardMusicLayAndroidViewViewOnClickListener;
    private OnClickListenerImpl mViewModelDashboardWeatherLayAndroidViewViewOnClickListener;
    private final ImageView mboundView10;
    private final ImageView mboundView11;
    private final ImageView mboundView12;
    private final ImageView mboundView13;
    private final ImageView mboundView14;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;
    private final ImageView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(18);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(15, new String[]{"bmw_id9_dashboard_music_layout", "bmw_id8_dashboard_weather_layout"}, new int[]{16, 17}, new int[]{R.layout.bmw_id9_dashboard_music_layout, R.layout.bmw_id8_dashboard_weather_layout});
    }

    public BmwId9DashboardLayoutNewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private BmwId9DashboardLayoutNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 15, (RelativeLayout) bindings[0], (RelativeLayout) bindings[15], (BmwId9DashboardMusicLayoutBinding) bindings[16], (LinearGradientID9Progress) bindings[2], (LinearGradientID9Progress) bindings[1], (BmwId8DashboardWeatherLayoutBinding) bindings[17]);
        this.mDirtyFlags = -1;
        this.bmwId9DashboardLay.setTag(null);
        this.bmwId9DashboardMidLay.setTag(null);
        setContainedBinding(this.bmwId9DashboardMusicLay);
        this.bmwId9DashboardRotateProgress.setTag(null);
        this.bmwId9DashboardSpeedProgress.setTag(null);
        setContainedBinding(this.bmwId9DashboardWeatherLay);
        ImageView imageView = (ImageView) bindings[10];
        this.mboundView10 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[11];
        this.mboundView11 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[12];
        this.mboundView12 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[13];
        this.mboundView13 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[14];
        this.mboundView14 = imageView5;
        imageView5.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[6];
        this.mboundView6 = textView4;
        textView4.setTag(null);
        ImageView imageView6 = (ImageView) bindings[7];
        this.mboundView7 = imageView6;
        imageView6.setTag(null);
        ImageView imageView7 = (ImageView) bindings[8];
        this.mboundView8 = imageView7;
        imageView7.setTag(null);
        ImageView imageView8 = (ImageView) bindings[9];
        this.mboundView9 = imageView8;
        imageView8.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        this.bmwId9DashboardMusicLay.invalidateAll();
        this.bmwId9DashboardWeatherLay.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.bmwId9DashboardWeatherLay.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.bmwId9DashboardMusicLay.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0021 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.wits.ksw.databinding.BmwId9DashboardMusicLayoutBinding r0 = r4.bmwId9DashboardMusicLay
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            com.wits.ksw.databinding.BmwId8DashboardWeatherLayoutBinding r0 = r4.bmwId9DashboardWeatherLay
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.BmwId9DashboardLayoutNewBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (36 != variableId) {
            return false;
        }
        setViewModel((DashboardViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId9DashboardLayoutNewBinding
    public void setViewModel(DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bmwId9DashboardMusicLay.setLifecycleOwner(lifecycleOwner);
        this.bmwId9DashboardWeatherLay.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 1:
                return onChangeViewModelCarInfoCarImage((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelCarInfoFrDoorState((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelCarInfoOilValue((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelDashBoardMusicShow((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelCarInfoRlDoorState((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelCarInfoRrDoorState((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelCarInfoSpeedUnit((ObservableField) object, fieldId);
            case 9:
                return onChangeBmwId9DashboardWeatherLay((BmwId8DashboardWeatherLayoutBinding) object, fieldId);
            case 10:
                return onChangeViewModelCarInfoFlDoorState((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 12:
                return onChangeViewModelCarInfoBDoorState((ObservableField) object, fieldId);
            case 13:
                return onChangeBmwId9DashboardMusicLay((BmwId9DashboardMusicLayoutBinding) object, fieldId);
            case 14:
                return onChangeViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelCarInfoTurnSpeed(ObservableInt ViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoCarImage(ObservableBoolean ViewModelCarInfoCarImage, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelDashBoardMusicShow(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeedUnit(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeBmwId9DashboardWeatherLay(BmwId8DashboardWeatherLayoutBinding BmwId9DashboardWeatherLay, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeed(ObservableInt ViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeBmwId9DashboardMusicLay(BmwId9DashboardMusicLayoutBinding BmwId9DashboardMusicLay, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v12 'viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE'  int: [D('viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE' int), D('viewModelCarInfoBrakeValueViewVISIBLEViewGONE' int)] */
    /* JADX INFO: Multiple debug info for r0v14 int: [D('viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE' int), D('viewModelCarInfoOilValueGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v16 'viewModelCarInfoSpeedUnitGet'  java.lang.String: [D('viewModelCarInfoSpeedUnitGet' java.lang.String), D('viewModelCarInfoOilValueGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v18 java.lang.String: [D('viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoSpeedUnitGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v20 'viewModelDashBoardMusicShowViewGONEViewVISIBLE'  int: [D('viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelDashBoardMusicShowViewGONEViewVISIBLE' int)] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0463  */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 1447
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.BmwId9DashboardLayoutNewBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private DashboardViewModel value;

        public OnClickListenerImpl setValue(DashboardViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.dashboardWeatherLay(arg0);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private DashboardViewModel value;

        public OnClickListenerImpl1 setValue(DashboardViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.dashboardMusicLay(arg0);
        }
    }
}
