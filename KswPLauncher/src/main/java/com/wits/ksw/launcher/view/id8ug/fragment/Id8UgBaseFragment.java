package com.wits.ksw.launcher.view.id8ug.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.launcher.view.id8ug.Id8UgEditActivity;
import com.wits.ksw.launcher.view.id8ug.Id8UgLauncherViewModel;
import com.wits.ksw.launcher.view.id8ug.listener.Id8UgLongClickListener;
import com.wits.ksw.launcher.view.id8ug.listener.Id8UgOnDragListener;

public abstract class Id8UgBaseFragment<T extends ViewBinding> extends Fragment {
    protected static String TAG = Id8UgBaseFragment.class.getName();
    protected String fragmentTag;
    protected Id8UgLauncherViewModel mViewModel;

    /* access modifiers changed from: protected */
    public abstract T createDataBinding(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract String setFragmentTag();

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        T binding = createDataBinding(inflater, container);
        initBaseData();
        if (getActivity() == null || !(getActivity() instanceof Id8UgEditActivity)) {
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgBaseFragment$W4CmVwF6dlDP7LuY7utzAcAjpu4 */

                public final boolean onLongClick(View view) {
                    return Id8UgBaseFragment.this.lambda$onCreateView$0$Id8UgBaseFragment(view);
                }
            });
            initMainActivityData();
        } else {
            setDragListener(binding.getRoot(), this.fragmentTag);
        }
        return binding.getRoot();
    }

    public /* synthetic */ boolean lambda$onCreateView$0$Id8UgBaseFragment(View v) {
        startActivity(new Intent(getContext(), Id8UgEditActivity.class).addFlags(268435456));
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: LandroverTwoFragment");
        Id8UgLauncherViewModel id8UgLauncherViewModel = (Id8UgLauncherViewModel) ViewModelProviders.of(getActivity()).get(Id8UgLauncherViewModel.class);
        this.mViewModel = id8UgLauncherViewModel;
        id8UgLauncherViewModel.setActivity(getActivity());
        this.mViewModel.initData();
    }

    /* access modifiers changed from: protected */
    public void initMainActivityData() {
    }

    /* access modifiers changed from: protected */
    public void initBaseData() {
        this.fragmentTag = setFragmentTag();
    }

    /* access modifiers changed from: protected */
    public void setDragListener(View view, String fragmentTag2) {
        view.setOnDragListener(new Id8UgOnDragListener(fragmentTag2, (Id8UgEditActivity) getActivity()));
        view.setOnLongClickListener(new Id8UgLongClickListener(view, fragmentTag2));
    }
}
