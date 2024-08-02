package com.wits.ksw.launcher.view.id8ug.fragment;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentEvoid8MainModelBinding;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id8UgCarModelFragment extends Id8UgBaseFragment {
    private FragmentEvoid8MainModelBinding binding;
    IContentObserver illObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarModelFragment.AnonymousClass2 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            if (Id8UgCarModelFragment.this.binding.evoid8ModelAuto.isSelected()) {
                Id8UgCarModelFragment.this.loadSkin();
            }
        }
    };
    private int volumeInt;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public String setFragmentTag() {
        return Id8UgConstants.ID8UG_FRAGMENT_CAR_MODEL;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public ViewBinding createDataBinding(LayoutInflater inflater, ViewGroup container) {
        FragmentEvoid8MainModelBinding inflate = FragmentEvoid8MainModelBinding.inflate(inflater, container, false);
        this.binding = inflate;
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initMainActivityData() {
        super.initMainActivityData();
        initVolume();
        setListener();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void setListener() {
        char c;
        String cardStr = SpfUtils.getString(Id8UgConstants.ID8UG_CAR_MODEL_TYPE, "");
        switch (cardStr.hashCode()) {
            case 99228:
                if (cardStr.equals("day")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3005871:
                if (cardStr.equals("auto")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 104817688:
                if (cardStr.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                initViewChange(1);
                break;
            case 1:
                initViewChange(3);
                break;
            case 2:
                initViewChange(2);
                break;
            default:
                initViewChange(1);
                break;
        }
        this.binding.evoid8ModelAuto.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarModelFragment$TB9zSp7KjPR0ar1VbrJN2nZr_ak */

            public final void onClick(View view) {
                Id8UgCarModelFragment.this.lambda$setListener$0$Id8UgCarModelFragment(view);
            }
        });
        this.binding.evoid8ModelDay.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarModelFragment$5smMqgmbb8KVSfmBS4opq7qeWA */

            public final void onClick(View view) {
                Id8UgCarModelFragment.this.lambda$setListener$1$Id8UgCarModelFragment(view);
            }
        });
        this.binding.evoid8ModelNight.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarModelFragment$x9Wmaghhu9D6bs5e1V4yoEF54Oc */

            public final void onClick(View view) {
                Id8UgCarModelFragment.this.lambda$setListener$2$Id8UgCarModelFragment(view);
            }
        });
        this.binding.evoid8ModelVolumeSub.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarModelFragment$YW0Z8ieptp3TirzVv7VBBikr9M */

            public final void onClick(View view) {
                Id8UgCarModelFragment.this.lambda$setListener$3$Id8UgCarModelFragment(view);
            }
        });
        this.binding.evoid8ModelVolumeAdd.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarModelFragment$dTgo0kZL5fcSngGvdKOyEJ0s6pU */

            public final void onClick(View view) {
                Id8UgCarModelFragment.this.lambda$setListener$4$Id8UgCarModelFragment(view);
            }
        });
        this.binding.evoid8ModelVolume.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarModelFragment$ihK7JKjHN90EPUsGBU7pOl4eJp0 */

            public final void onClick(View view) {
                Id8UgCarModelFragment.this.lambda$setListener$5$Id8UgCarModelFragment(view);
            }
        });
        PowerManagerApp.registerIContentObserver("ill", this.illObserver);
    }

    public /* synthetic */ void lambda$setListener$0$Id8UgCarModelFragment(View v) {
        initViewChange(1);
        SpfUtils.saveData(Id8UgConstants.ID8UG_CAR_MODEL_TYPE, "auto");
        loadSkin();
    }

    public /* synthetic */ void lambda$setListener$1$Id8UgCarModelFragment(View v) {
        initViewChange(3);
        SpfUtils.saveData(Id8UgConstants.ID8UG_CAR_MODEL_TYPE, "day");
        Settings.System.putString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL, Id8UgConstants.ID8UG_SELECT_MODEL_DAYTIME);
    }

    public /* synthetic */ void lambda$setListener$2$Id8UgCarModelFragment(View v) {
        initViewChange(2);
        SpfUtils.saveData(Id8UgConstants.ID8UG_CAR_MODEL_TYPE, Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT);
        Settings.System.putString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL, Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT);
    }

    public /* synthetic */ void lambda$setListener$3$Id8UgCarModelFragment(View v) {
        int i = this.volumeInt - 1;
        this.volumeInt = i;
        FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, i);
    }

    public /* synthetic */ void lambda$setListener$4$Id8UgCarModelFragment(View v) {
        int i = this.volumeInt + 1;
        this.volumeInt = i;
        FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, i);
    }

    public /* synthetic */ void lambda$setListener$5$Id8UgCarModelFragment(View v) {
        if (this.volumeInt == 0) {
            FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, 20);
        } else {
            FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, 0);
        }
    }

    private void initVolume() {
        updateVolume();
        getActivity().getApplicationContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.ANDROID_MEDIA_VOL), true, new ContentObserver(new Handler()) {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarModelFragment.AnonymousClass1 */

            public void onChange(boolean selfChange) {
                Log.i(Id8UgBaseFragment.TAG, "KeyConfig.ANDROID_MEDIA_VOL onChange ");
                Id8UgCarModelFragment.this.updateVolume();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateVolume() {
        try {
            this.volumeInt = PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_MEDIA_VOL);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.binding.evoid8ModelVolumeText.setText(((int) ((((float) this.volumeInt) / 40.0f) * 100.0f)) + "%");
        if (this.volumeInt == 0) {
            this.binding.evoid8ModelVolume.setImageResource(R.drawable.evoid8_volume_mute);
        } else {
            this.binding.evoid8ModelVolume.setImageResource(R.drawable.evoid8_volume_default);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadSkin() {
        boolean isIllOn = false;
        try {
            boolean z = true;
            if (PowerManagerApp.getStatusInt("ill") != 1) {
                z = false;
            }
            isIllOn = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!isIllOn) {
            Settings.System.putString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL, Id8UgConstants.ID8UG_SELECT_MODEL_DAYTIME);
        } else {
            Settings.System.putString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL, Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT);
        }
    }

    private void initViewChange(int type) {
        switch (type) {
            case 1:
                this.binding.evoid8ModelAuto.setSelected(true);
                this.binding.evoid8ModelDay.setSelected(false);
                this.binding.evoid8ModelNight.setSelected(false);
                return;
            case 2:
                this.binding.evoid8ModelAuto.setSelected(false);
                this.binding.evoid8ModelDay.setSelected(false);
                this.binding.evoid8ModelNight.setSelected(true);
                return;
            case 3:
                this.binding.evoid8ModelAuto.setSelected(false);
                this.binding.evoid8ModelDay.setSelected(true);
                this.binding.evoid8ModelNight.setSelected(false);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PowerManagerApp.unRegisterIContentObserver(this.illObserver);
    }
}
