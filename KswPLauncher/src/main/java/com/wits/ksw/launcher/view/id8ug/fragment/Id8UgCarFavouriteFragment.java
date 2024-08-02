package com.wits.ksw.launcher.view.id8ug.fragment;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentEvoid8MainFavouriteBinding;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;

public class Id8UgCarFavouriteFragment extends Id8UgBaseFragment {
    private static final String TAG = Id8UgCarFavouriteFragment.class.getName();
    private FragmentEvoid8MainFavouriteBinding binding;
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarFavouriteFragment.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Id8UgCarFavouriteFragment.this.setCardViewBg();
            Id8UgCarFavouriteFragment.this.mViewModel.updateShortcutAdapterData();
        }
    };

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public String setFragmentTag() {
        return Id8UgConstants.ID8UG_FRAGMENT_CAR_FAVOUR;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public ViewBinding createDataBinding(LayoutInflater inflater, ViewGroup container) {
        this.binding = FragmentEvoid8MainFavouriteBinding.inflate(inflater, container, false);
        setCardViewBg();
        return this.binding;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initBaseData() {
        super.initBaseData();
        this.mViewModel.setRecyclerView(this.binding.recyclerView);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initMainActivityData() {
        super.initMainActivityData();
        if (getContext() != null) {
            getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (getContext() != null) {
                getContext().getContentResolver().unregisterContentObserver(this.contentObserver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCardViewBg() {
        this.binding.id8UgCardViewBgIv.setBackground(ContextCompat.getDrawable(KswApplication.appContext, TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, Settings.System.getString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL)) ? R.drawable.evoid8_favourite_bg_shape_night : R.drawable.evoid8_favourite_bg_shape));
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        this.mViewModel.updateShortcutAdapterData();
    }
}
