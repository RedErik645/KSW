package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlCheckBox;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;
import com.wits.ksw.settings.utlis_view.RtlTextView;

public final class FactoryCarConfigBinding implements ViewBinding {
    public final RadioGroup audiHomeLeftRadioGroup;
    public final RtlTextView audiHomeLeftWidgetTextview;
    public final RadioGroup audiHomeRightRadioGroup;
    public final RtlTextView audiHomeRightWidgetTextview;
    public final RtlCheckBox cboxAcControl;
    public final RtlCheckBox cboxAirCon;
    public final RtlCheckBox cboxBencAux;
    public final RtlCheckBox cboxBencPank;
    public final RadioGroup cboxBencPankRgd;
    public final LinearLayout cboxBencPankRoot;
    public final RtlCheckBox cboxCanBus;
    public final RtlCheckBox cboxDcld;
    public final RtlCheckBox cboxOemFm;
    public final RtlTextView ccciDTextView;
    public final RtlRadioButton rdbAuxsw1;
    public final RtlRadioButton rdbAuxsw2;
    public final RtlRadioButton rdbCcciD1;
    public final RtlRadioButton rdbCcciD2;
    public final RtlRadioButton rdbNbtauxsw1;
    public final RtlRadioButton rdbNbtauxsw2;
    public final RtlRadioButton rdbNbtauxsw3;
    public final RadioGroup rdgAuxsw;
    public final RadioGroup rdgCamera360;
    public final RadioGroup rdgCan;
    public final RtlRadioButton rdgCan1;
    public final RtlRadioButton rdgCan2;
    public final RadioGroup rdgCardoor;
    public final RtlRadioButton rdgCardoor1;
    public final RtlRadioButton rdgCardoor2;
    public final RtlRadioButton rdgCardoor3;
    public final RadioGroup rdgCcciD;
    public final RadioGroup rdgFactoryCarseep;
    public final RtlRadioButton rdgFactoryCarseep1;
    public final RtlRadioButton rdgFactoryCarseep2;
    public final RtlRadioButton rdgFactoryCarseep3;
    public final RtlRadioButton rdgFactoryCarseep4;
    public final RadioGroup rdgFactoryFrontleft;
    public final RtlRadioButton rdgFactoryFrontleft1;
    public final RtlRadioButton rdgFactoryFrontleft2;
    public final RadioGroup rdgFactoryGear;
    public final RtlRadioButton rdgFactoryGear1;
    public final RtlRadioButton rdgFactoryGear2;
    public final RtlRadioButton rdgFactoryGear3;
    public final RadioGroup rdgFactoryMapkey;
    public final RtlRadioButton rdgFactoryMapkey1;
    public final RtlRadioButton rdgFactoryMapkey2;
    public final RadioGroup rdgFactoryModekey;
    public final RtlRadioButton rdgFactoryModekey1;
    public final RtlRadioButton rdgFactoryModekey2;
    public final RadioGroup rdgFactoryPhone;
    public final RtlRadioButton rdgFactoryPhone1;
    public final RtlRadioButton rdgFactoryPhone2;
    public final RtlRadioButton rdgFactoryPhone3;
    public final RadioGroup rdgFactorySpeedtype;
    public final RtlRadioButton rdgFactorySpeedtype1;
    public final RtlRadioButton rdgFactorySpeedtype2;
    public final RadioGroup rdgFactoryYuyinkey;
    public final RtlRadioButton rdgFactoryYuyinkey1;
    public final RtlRadioButton rdgFactoryYuyinkey2;
    public final RtlRadioButton rdgFactoryYuyinkey3;
    public final RtlRadioButton rdgFactoryYuyinkey4;
    public final RtlRadioButton rdgFactoryYuyinkey5;
    public final RadioGroup rdgInternalExternal;
    public final RtlRadioButton rdgMicExternal;
    public final RtlRadioButton rdgMicInternal;
    public final RadioGroup rdgNbtauxsw;
    public final RtlRadioButton rdgNoCamera;
    public final RadioGroup rdgNumdoor;
    public final RtlRadioButton rdgNumdoor1;
    public final RtlRadioButton rdgNumdoor2;
    public final RtlRadioButton rdgOriginalCarCamera;
    public final RadioGroup rdgOriginalRadar;
    public final RtlRadioButton rdgRadarNormal;
    public final RtlRadioButton rdgRadarReverse;
    public final RtlRadioButton rdgRetrofitCamera;
    public final RtlRadioButton rdgRetrofitControlled;
    public final RadioGroup rdgTrack;
    public final RtlRadioButton rdgTrack1;
    public final RtlRadioButton rdgTrack2;
    public final RadioGroup rdgTurnSignal;
    public final RtlRadioButton rdgUncontrolled;
    private final ScrollView rootView;

    private FactoryCarConfigBinding(ScrollView rootView2, RadioGroup audiHomeLeftRadioGroup2, RtlTextView audiHomeLeftWidgetTextview2, RadioGroup audiHomeRightRadioGroup2, RtlTextView audiHomeRightWidgetTextview2, RtlCheckBox cboxAcControl2, RtlCheckBox cboxAirCon2, RtlCheckBox cboxBencAux2, RtlCheckBox cboxBencPank2, RadioGroup cboxBencPankRgd2, LinearLayout cboxBencPankRoot2, RtlCheckBox cboxCanBus2, RtlCheckBox cboxDcld2, RtlCheckBox cboxOemFm2, RtlTextView ccciDTextView2, RtlRadioButton rdbAuxsw12, RtlRadioButton rdbAuxsw22, RtlRadioButton rdbCcciD12, RtlRadioButton rdbCcciD22, RtlRadioButton rdbNbtauxsw12, RtlRadioButton rdbNbtauxsw22, RtlRadioButton rdbNbtauxsw32, RadioGroup rdgAuxsw2, RadioGroup rdgCamera3602, RadioGroup rdgCan3, RtlRadioButton rdgCan12, RtlRadioButton rdgCan22, RadioGroup rdgCardoor4, RtlRadioButton rdgCardoor12, RtlRadioButton rdgCardoor22, RtlRadioButton rdgCardoor32, RadioGroup rdgCcciD2, RadioGroup rdgFactoryCarseep5, RtlRadioButton rdgFactoryCarseep12, RtlRadioButton rdgFactoryCarseep22, RtlRadioButton rdgFactoryCarseep32, RtlRadioButton rdgFactoryCarseep42, RadioGroup rdgFactoryFrontleft3, RtlRadioButton rdgFactoryFrontleft12, RtlRadioButton rdgFactoryFrontleft22, RadioGroup rdgFactoryGear4, RtlRadioButton rdgFactoryGear12, RtlRadioButton rdgFactoryGear22, RtlRadioButton rdgFactoryGear32, RadioGroup rdgFactoryMapkey3, RtlRadioButton rdgFactoryMapkey12, RtlRadioButton rdgFactoryMapkey22, RadioGroup rdgFactoryModekey3, RtlRadioButton rdgFactoryModekey12, RtlRadioButton rdgFactoryModekey22, RadioGroup rdgFactoryPhone4, RtlRadioButton rdgFactoryPhone12, RtlRadioButton rdgFactoryPhone22, RtlRadioButton rdgFactoryPhone32, RadioGroup rdgFactorySpeedtype3, RtlRadioButton rdgFactorySpeedtype12, RtlRadioButton rdgFactorySpeedtype22, RadioGroup rdgFactoryYuyinkey6, RtlRadioButton rdgFactoryYuyinkey12, RtlRadioButton rdgFactoryYuyinkey22, RtlRadioButton rdgFactoryYuyinkey32, RtlRadioButton rdgFactoryYuyinkey42, RtlRadioButton rdgFactoryYuyinkey52, RadioGroup rdgInternalExternal2, RtlRadioButton rdgMicExternal2, RtlRadioButton rdgMicInternal2, RadioGroup rdgNbtauxsw2, RtlRadioButton rdgNoCamera2, RadioGroup rdgNumdoor3, RtlRadioButton rdgNumdoor12, RtlRadioButton rdgNumdoor22, RtlRadioButton rdgOriginalCarCamera2, RadioGroup rdgOriginalRadar2, RtlRadioButton rdgRadarNormal2, RtlRadioButton rdgRadarReverse2, RtlRadioButton rdgRetrofitCamera2, RtlRadioButton rdgRetrofitControlled2, RadioGroup rdgTrack3, RtlRadioButton rdgTrack12, RtlRadioButton rdgTrack22, RadioGroup rdgTurnSignal2, RtlRadioButton rdgUncontrolled2) {
        this.rootView = rootView2;
        this.audiHomeLeftRadioGroup = audiHomeLeftRadioGroup2;
        this.audiHomeLeftWidgetTextview = audiHomeLeftWidgetTextview2;
        this.audiHomeRightRadioGroup = audiHomeRightRadioGroup2;
        this.audiHomeRightWidgetTextview = audiHomeRightWidgetTextview2;
        this.cboxAcControl = cboxAcControl2;
        this.cboxAirCon = cboxAirCon2;
        this.cboxBencAux = cboxBencAux2;
        this.cboxBencPank = cboxBencPank2;
        this.cboxBencPankRgd = cboxBencPankRgd2;
        this.cboxBencPankRoot = cboxBencPankRoot2;
        this.cboxCanBus = cboxCanBus2;
        this.cboxDcld = cboxDcld2;
        this.cboxOemFm = cboxOemFm2;
        this.ccciDTextView = ccciDTextView2;
        this.rdbAuxsw1 = rdbAuxsw12;
        this.rdbAuxsw2 = rdbAuxsw22;
        this.rdbCcciD1 = rdbCcciD12;
        this.rdbCcciD2 = rdbCcciD22;
        this.rdbNbtauxsw1 = rdbNbtauxsw12;
        this.rdbNbtauxsw2 = rdbNbtauxsw22;
        this.rdbNbtauxsw3 = rdbNbtauxsw32;
        this.rdgAuxsw = rdgAuxsw2;
        this.rdgCamera360 = rdgCamera3602;
        this.rdgCan = rdgCan3;
        this.rdgCan1 = rdgCan12;
        this.rdgCan2 = rdgCan22;
        this.rdgCardoor = rdgCardoor4;
        this.rdgCardoor1 = rdgCardoor12;
        this.rdgCardoor2 = rdgCardoor22;
        this.rdgCardoor3 = rdgCardoor32;
        this.rdgCcciD = rdgCcciD2;
        this.rdgFactoryCarseep = rdgFactoryCarseep5;
        this.rdgFactoryCarseep1 = rdgFactoryCarseep12;
        this.rdgFactoryCarseep2 = rdgFactoryCarseep22;
        this.rdgFactoryCarseep3 = rdgFactoryCarseep32;
        this.rdgFactoryCarseep4 = rdgFactoryCarseep42;
        this.rdgFactoryFrontleft = rdgFactoryFrontleft3;
        this.rdgFactoryFrontleft1 = rdgFactoryFrontleft12;
        this.rdgFactoryFrontleft2 = rdgFactoryFrontleft22;
        this.rdgFactoryGear = rdgFactoryGear4;
        this.rdgFactoryGear1 = rdgFactoryGear12;
        this.rdgFactoryGear2 = rdgFactoryGear22;
        this.rdgFactoryGear3 = rdgFactoryGear32;
        this.rdgFactoryMapkey = rdgFactoryMapkey3;
        this.rdgFactoryMapkey1 = rdgFactoryMapkey12;
        this.rdgFactoryMapkey2 = rdgFactoryMapkey22;
        this.rdgFactoryModekey = rdgFactoryModekey3;
        this.rdgFactoryModekey1 = rdgFactoryModekey12;
        this.rdgFactoryModekey2 = rdgFactoryModekey22;
        this.rdgFactoryPhone = rdgFactoryPhone4;
        this.rdgFactoryPhone1 = rdgFactoryPhone12;
        this.rdgFactoryPhone2 = rdgFactoryPhone22;
        this.rdgFactoryPhone3 = rdgFactoryPhone32;
        this.rdgFactorySpeedtype = rdgFactorySpeedtype3;
        this.rdgFactorySpeedtype1 = rdgFactorySpeedtype12;
        this.rdgFactorySpeedtype2 = rdgFactorySpeedtype22;
        this.rdgFactoryYuyinkey = rdgFactoryYuyinkey6;
        this.rdgFactoryYuyinkey1 = rdgFactoryYuyinkey12;
        this.rdgFactoryYuyinkey2 = rdgFactoryYuyinkey22;
        this.rdgFactoryYuyinkey3 = rdgFactoryYuyinkey32;
        this.rdgFactoryYuyinkey4 = rdgFactoryYuyinkey42;
        this.rdgFactoryYuyinkey5 = rdgFactoryYuyinkey52;
        this.rdgInternalExternal = rdgInternalExternal2;
        this.rdgMicExternal = rdgMicExternal2;
        this.rdgMicInternal = rdgMicInternal2;
        this.rdgNbtauxsw = rdgNbtauxsw2;
        this.rdgNoCamera = rdgNoCamera2;
        this.rdgNumdoor = rdgNumdoor3;
        this.rdgNumdoor1 = rdgNumdoor12;
        this.rdgNumdoor2 = rdgNumdoor22;
        this.rdgOriginalCarCamera = rdgOriginalCarCamera2;
        this.rdgOriginalRadar = rdgOriginalRadar2;
        this.rdgRadarNormal = rdgRadarNormal2;
        this.rdgRadarReverse = rdgRadarReverse2;
        this.rdgRetrofitCamera = rdgRetrofitCamera2;
        this.rdgRetrofitControlled = rdgRetrofitControlled2;
        this.rdgTrack = rdgTrack3;
        this.rdgTrack1 = rdgTrack12;
        this.rdgTrack2 = rdgTrack22;
        this.rdgTurnSignal = rdgTurnSignal2;
        this.rdgUncontrolled = rdgUncontrolled2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FactoryCarConfigBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FactoryCarConfigBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.factory_car_config, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -128
        	at java.util.BitSet.get(Unknown Source)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static com.wits.ksw.databinding.FactoryCarConfigBinding bind(android.view.View r167) {
        /*
        // Method dump skipped, instructions count: 1364
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.FactoryCarConfigBinding.bind(android.view.View):com.wits.ksw.databinding.FactoryCarConfigBinding");
    }
}
