package android.databinding.adapters;

import android.support.v7.widget.SwitchCompat;

public class SwitchCompatBindingAdapter {
    public static void setSwitchTextAppearance(SwitchCompat view, int value) {
        view.setSwitchTextAppearance(null, value);
    }
}
