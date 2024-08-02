package com.wits.ksw;

import android.app.Activity;
import android.os.Bundle;
import com.wits.ksw.settings.utlis_view.DialogViews;

public class McuDialogActivity extends Activity {
    private DialogViews dialogViews;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dialogViews = new DialogViews(this);
    }

    public void onResume() {
        super.onResume();
        this.dialogViews.KswAPPupdateMcu(getString(R.string.update_mcu_file));
    }
}
