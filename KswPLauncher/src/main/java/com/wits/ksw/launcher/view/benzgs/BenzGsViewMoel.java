package com.wits.ksw.launcher.view.benzgs;

import android.database.ContentObserver;
import android.databinding.ObservableInt;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;

public class BenzGsViewMoel extends BcVieModel {
    private ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.benzgs.BenzGsViewMoel.AnonymousClass1 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            BenzGsViewMoel benzGsViewMoel = BenzGsViewMoel.this;
            benzGsViewMoel.setIndex(BenzConfig.getIndex(benzGsViewMoel.context));
        }
    };
    public ObservableInt index = new ObservableInt(-1);
    public ObservableInt pageIndex = new ObservableInt(0);

    public BenzGsViewMoel() {
        setIndex(BenzConfig.getIndex(this.context));
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(BenzConfig.INDEX), false, this.contentObserver);
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.ViewModel, com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.LauncherViewModel
    public void onCleared() {
        super.onCleared();
        this.context.getContentResolver().unregisterContentObserver(this.contentObserver);
    }

    public void setIndex(int v) {
        this.index.set(v);
        Log.i(TAG, "setIndex: " + v);
    }

    public void onClick(int index2) {
        BenzConfig.saveIndex(this.context, index2);
        setIndex(index2);
        if (index2 == 0) {
            openNaviApp(null);
        } else if (index2 == 1) {
            openMusicMulti(null);
        } else if (index2 == 2) {
            openBtApp(null);
        } else if (index2 == 3) {
            openCar(null);
        } else if (index2 == 4) {
            openSettings(null);
        } else if (index2 == 5) {
            openVideoMulti(null);
        } else if (index2 == 6) {
            openFileManager(null);
        } else if (index2 == 7) {
            openShouJiHuLian(null);
        } else if (index2 == 8) {
            openDashboard(null);
        } else if (index2 == 9) {
            openApps(null);
        }
    }

    public void setCurrentItem(View view, int page) {
        this.pageIndex.set(page);
    }

    public static void setOliText(TextView textView, String value) {
        textView.setText(textView.getResources().getString(R.string.oil_size, "" + value));
    }
}
