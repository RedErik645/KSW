package com.wits.ksw.settings.audi;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiReverCameraBinding;
import com.wits.ksw.settings.audi.vm.AudiSystemViewModel;

public class AudiReverCameraActivity extends AudiSubActivity implements View.OnKeyListener {
    private AudiSystemViewModel viewModel;
    private View[] views = new View[4];

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi.AudiSubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiReverCameraBinding binding = (AudiReverCameraBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_rever_camera, null, false);
        this.contentLayout.addView(binding.getRoot(), -1, -1);
        this.tv_title_set.setText(getResources().getString(R.string.set_text5));
        AudiSystemViewModel audiSystemViewModel = AudiSettingMainActivity.getInstance.viewModel;
        this.viewModel = audiSystemViewModel;
        binding.setVm(audiSystemViewModel);
        this.views[0] = binding.RadioButton1;
        this.views[1] = binding.RadioButton2;
        this.views[2] = binding.RadioButton3;
        this.views[3] = binding.RadioButton4;
        setOnKeyListener();
        setSelected(this.views[this.viewModel.reverCamera.get()]);
    }

    private void setOnKeyListener() {
        for (View mView : this.views) {
            mView.setOnKeyListener(this);
        }
    }

    public void setSelected(View view) {
        View[] viewArr = this.views;
        int length = viewArr.length;
        for (int i = 0; i < length; i++) {
            View mView = viewArr[i];
            mView.setSelected(mView == view);
        }
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        setSelected(v);
        return false;
    }
}
