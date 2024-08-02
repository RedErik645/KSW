package com.wits.ksw.launcher.bmw_id8_ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentPempWeatherEditBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8PempEditActivity;
import com.wits.ksw.launcher.bmw_id8_ui.PempID8LauncherConstants;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnClickListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnDragListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.DragClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ID8PempFragmentWeather extends Fragment {
    private static final String TAG = "ID8PempFragmentWeather";
    public static final int iconResId = 2131169651;
    public static final String name = "WEATHER";
    public static final int nameResId = 2131493272;
    private final WeatherRemoveListener listener;
    private FragmentPempWeatherEditBinding mEditBinding;
    private LauncherViewModel mViewModel;

    public interface WeatherRemoveListener {
        void onWeatherAppRemove();
    }

    public ID8PempFragmentWeather(WeatherRemoveListener listener2) {
        this.listener = listener2;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        FragmentPempWeatherEditBinding fragmentPempWeatherEditBinding = (FragmentPempWeatherEditBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_pemp_weather_edit, container, false);
        this.mEditBinding = fragmentPempWeatherEditBinding;
        fragmentPempWeatherEditBinding.setWeatherViewModel(this.mViewModel);
        View view = this.mEditBinding.getRoot();
        view.setOnDragListener(new CardId8PempOnDragListener(TAG, this, (ID8PempEditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, "WEATHER", R.drawable.pemp_id8_main_left_icon_weather, R.string.ksw_id8_weather));
        view.setOnClickListener(new CardId8PempOnClickListener((ID8PempEditActivity) getActivity()));
        view.setTag("WEATHER");
        ((ImageView) view.findViewById(R.id.remove)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.fragment.ID8PempFragmentWeather.AnonymousClass1 */

            public void onClick(View v) {
                PempID8LauncherConstants.removeCard("WEATHER");
                if (ID8PempFragmentWeather.this.listener != null) {
                    ID8PempFragmentWeather.this.listener.onWeatherAppRemove();
                }
            }
        });
        return view;
    }
}
