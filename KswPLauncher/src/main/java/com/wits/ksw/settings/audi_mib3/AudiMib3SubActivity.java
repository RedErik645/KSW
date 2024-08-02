package com.wits.ksw.settings.audi_mib3;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.wits.ksw.R;
import com.wits.ksw.settings.BaseActivity;

public class AudiMib3SubActivity extends BaseActivity {
    RelativeLayout contentLayout;
    public TextView tv_title_set;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audi_mib3_sub);
        this.tv_title_set = (TextView) findViewById(R.id.tv_title_set);
        ButterKnife.inject(this);
    }
}
