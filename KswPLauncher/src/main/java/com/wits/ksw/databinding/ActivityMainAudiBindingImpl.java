package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.model.AudiViewModel;
import com.wits.ksw.launcher.view.DateView;
import com.wits.ksw.launcher.view.LoopRotarySwitchView;

public class ActivityMainAudiBindingImpl extends ActivityMainAudiBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final AudiRightWeatherBinding mboundView01;
    private final AudiRightCarinfoBinding mboundView02;
    private final AudiRightNaviBinding mboundView03;
    private final AudiRightMediaBinding mboundView04;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(38);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"audi_right_weather", "audi_right_carinfo", "audi_right_navi", "audi_right_media"}, new int[]{4, 5, 6, 7}, new int[]{R.layout.audi_right_weather, R.layout.audi_right_carinfo, R.layout.audi_right_navi, R.layout.audi_right_media});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_navi, 8);
        sparseIntArray.put(R.id.iv_navi, 9);
        sparseIntArray.put(R.id.tv_navi, 10);
        sparseIntArray.put(R.id.rl_bt, 11);
        sparseIntArray.put(R.id.iv_bt, 12);
        sparseIntArray.put(R.id.tv_bt, 13);
        sparseIntArray.put(R.id.rl_music, 14);
        sparseIntArray.put(R.id.iv_music, 15);
        sparseIntArray.put(R.id.tv_music, 16);
        sparseIntArray.put(R.id.rl_settings, 17);
        sparseIntArray.put(R.id.iv_settings, 18);
        sparseIntArray.put(R.id.tv_settings, 19);
        sparseIntArray.put(R.id.rl_video, 20);
        sparseIntArray.put(R.id.iv_video, 21);
        sparseIntArray.put(R.id.tv_video, 22);
        sparseIntArray.put(R.id.rl_dashboard, 23);
        sparseIntArray.put(R.id.iv_dashboard, 24);
        sparseIntArray.put(R.id.rl_easyconnection, 25);
        sparseIntArray.put(R.id.iv_easyconnection, 26);
        sparseIntArray.put(R.id.tv_easyconnection, 27);
        sparseIntArray.put(R.id.rl_dvr, 28);
        sparseIntArray.put(R.id.iv_dvr, 29);
        sparseIntArray.put(R.id.tv_dvr, 30);
        sparseIntArray.put(R.id.rl_car, 31);
        sparseIntArray.put(R.id.iv_car, 32);
        sparseIntArray.put(R.id.tv_car, 33);
        sparseIntArray.put(R.id.rl_apps, 34);
        sparseIntArray.put(R.id.iv_apps, 35);
        sparseIntArray.put(R.id.tv_apps, 36);
        sparseIntArray.put(R.id.date, 37);
    }

    public ActivityMainAudiBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 38, sIncludes, sViewsWithIds));
    }

    private ActivityMainAudiBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (LoopRotarySwitchView) bindings[2], (DateView) bindings[37], (ImageView) bindings[35], (ImageView) bindings[12], (ImageView) bindings[32], (ImageView) bindings[24], (ImageView) bindings[29], (ImageView) bindings[26], (ImageView) bindings[1], (ImageView) bindings[15], (ImageView) bindings[9], (ImageView) bindings[18], (ImageView) bindings[21], (ImageView) bindings[3], (RelativeLayout) bindings[34], (RelativeLayout) bindings[11], (RelativeLayout) bindings[31], (RelativeLayout) bindings[23], (RelativeLayout) bindings[28], (RelativeLayout) bindings[25], (RelativeLayout) bindings[14], (RelativeLayout) bindings[8], (RelativeLayout) bindings[17], (RelativeLayout) bindings[20], (TextView) bindings[36], (TextView) bindings[13], (TextView) bindings[33], (TextView) bindings[30], (TextView) bindings[27], (TextView) bindings[16], (TextView) bindings[10], (TextView) bindings[19], (TextView) bindings[22]);
        this.mDirtyFlags = -1;
        this.MLoopRotarySwitchView.setTag(null);
        this.ivGuang.setTag(null);
        this.kswA4LAudiChe.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        AudiRightWeatherBinding audiRightWeatherBinding = (AudiRightWeatherBinding) bindings[4];
        this.mboundView01 = audiRightWeatherBinding;
        setContainedBinding(audiRightWeatherBinding);
        AudiRightCarinfoBinding audiRightCarinfoBinding = (AudiRightCarinfoBinding) bindings[5];
        this.mboundView02 = audiRightCarinfoBinding;
        setContainedBinding(audiRightCarinfoBinding);
        AudiRightNaviBinding audiRightNaviBinding = (AudiRightNaviBinding) bindings[6];
        this.mboundView03 = audiRightNaviBinding;
        setContainedBinding(audiRightNaviBinding);
        AudiRightMediaBinding audiRightMediaBinding = (AudiRightMediaBinding) bindings[7];
        this.mboundView04 = audiRightMediaBinding;
        setContainedBinding(audiRightMediaBinding);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.mboundView01.invalidateAll();
        this.mboundView02.invalidateAll();
        this.mboundView03.invalidateAll();
        this.mboundView04.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.mboundView02.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.mboundView03.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r4.mboundView04.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView01.hasPendingBindings() == false) goto L_0x0016;
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
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0033 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            com.wits.ksw.databinding.AudiRightWeatherBinding r0 = r4.mboundView01
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            com.wits.ksw.databinding.AudiRightCarinfoBinding r0 = r4.mboundView02
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            com.wits.ksw.databinding.AudiRightNaviBinding r0 = r4.mboundView03
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r1
        L_0x0028:
            com.wits.ksw.databinding.AudiRightMediaBinding r0 = r4.mboundView04
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r1
        L_0x0031:
            r0 = 0
            return r0
        L_0x0033:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.ActivityMainAudiBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (37 != variableId) {
            return false;
        }
        setVm((AudiViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityMainAudiBinding
    public void setVm(AudiViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView01.setLifecycleOwner(lifecycleOwner);
        this.mboundView02.setLifecycleOwner(lifecycleOwner);
        this.mboundView03.setLifecycleOwner(lifecycleOwner);
        this.mboundView04.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmCarPicId((ObservableInt) object, fieldId);
            case 1:
                return onChangeVmCarBgPicId((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmCarPicId(ObservableInt VmCarPicId, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmCarBgPicId(ObservableInt VmCarBgPicId, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int vmCarBgPicIdGet = 0;
        AudiViewModel vm = this.mVm;
        LoopRotarySwitchView.OnItemSelectedListener vmOnItemSelectedListener = null;
        ObservableInt vmCarPicId = null;
        LoopRotarySwitchView.OnItemClickListener vmOnItemClickListener = null;
        int vmCarPicIdGet = 0;
        ObservableInt vmCarBgPicId = null;
        if ((15 & dirtyFlags) != 0) {
            if (!((dirtyFlags & 12) == 0 || vm == null)) {
                vmOnItemSelectedListener = vm.OnItemSelectedListener;
                vmOnItemClickListener = vm.onItemClickListener;
            }
            if ((dirtyFlags & 13) != 0) {
                if (vm != null) {
                    vmCarPicId = vm.carPicId;
                }
                updateRegistration(0, vmCarPicId);
                if (vmCarPicId != null) {
                    vmCarPicIdGet = vmCarPicId.get();
                }
            }
            if ((dirtyFlags & 14) != 0) {
                if (vm != null) {
                    vmCarBgPicId = vm.carBgPicId;
                }
                updateRegistration(1, vmCarBgPicId);
                if (vmCarBgPicId != null) {
                    vmCarBgPicIdGet = vmCarBgPicId.get();
                }
            }
        }
        if ((dirtyFlags & 12) != 0) {
            this.MLoopRotarySwitchView.setOnItemClickListener(vmOnItemClickListener);
            this.MLoopRotarySwitchView.setOnItemSelectedListener(vmOnItemSelectedListener);
            this.mboundView01.setVm(vm);
            this.mboundView02.setVm(vm);
            this.mboundView03.setVm(vm);
            this.mboundView04.setVm(vm);
        }
        if ((14 & dirtyFlags) != 0) {
            BaseBindingModel.srcImage(this.ivGuang, vmCarBgPicIdGet);
        }
        if ((dirtyFlags & 13) != 0) {
            BaseBindingModel.srcImage(this.kswA4LAudiChe, vmCarPicIdGet);
        }
        executeBindingsOn(this.mboundView01);
        executeBindingsOn(this.mboundView02);
        executeBindingsOn(this.mboundView03);
        executeBindingsOn(this.mboundView04);
    }
}