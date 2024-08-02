package com.wits.ksw.launcher.bmw_id8_ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bmw_id8_ui.ID8PempEditActivity;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnClickListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnDragListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.DragClickListener;

public class ID8PempFragmentNavigate extends Fragment {
    private static final String TAG = "ID8PempFragmentNavigate";
    public static final int iconResId = 2131169648;
    public static final String name = "NAVIGATE";
    public static final int nameResId = 2131493237;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pemp_navigate_edit, container, false);
        view.setOnDragListener(new CardId8PempOnDragListener(TAG, this, (ID8PempEditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, "NAVIGATE", R.drawable.pemp_id8_main_left_icon_navi, R.string.ksw_id8_abbr_tel_navigate));
        view.setOnClickListener(new CardId8PempOnClickListener((ID8PempEditActivity) getActivity()));
        view.setTag("NAVIGATE");
        return view;
    }
}
