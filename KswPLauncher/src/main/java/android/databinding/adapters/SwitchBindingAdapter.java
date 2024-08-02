package android.databinding.adapters;

import android.widget.Switch;

public class SwitchBindingAdapter {
    public static void setSwitchTextAppearance(Switch view, int value) {
        view.setSwitchTextAppearance(null, value);
    }
}
