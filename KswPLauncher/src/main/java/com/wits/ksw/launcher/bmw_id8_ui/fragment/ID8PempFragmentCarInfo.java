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

public class ID8PempFragmentCarInfo extends Fragment {
    private static final String TAG = "ID8PempFragmentCarInfo";
    public static final int iconResId = 2131169644;
    public static final String name = "CAR INFO";
    public static final int nameResId = 2131493214;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pemp_car_info_edit, container, false);
        view.setOnDragListener(new CardId8PempOnDragListener(TAG, this, (ID8PempEditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, "CAR INFO", R.drawable.pemp_id8_main_left_icon_car, R.string.ksw_id7_car));
        view.setOnClickListener(new CardId8PempOnClickListener((ID8PempEditActivity) getActivity()));
        view.setTag("CAR INFO");
        return view;
    }
}
