package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import com.wits.ksw.R;

public final class AudiMib3LanguageItemBinding implements ViewBinding {
    public final RadioButton languageRadioButton;
    private final RadioButton rootView;

    private AudiMib3LanguageItemBinding(RadioButton rootView2, RadioButton languageRadioButton2) {
        this.rootView = rootView2;
        this.languageRadioButton = languageRadioButton2;
    }

    @Override // android.viewbinding.ViewBinding
    public RadioButton getRoot() {
        return this.rootView;
    }

    public static AudiMib3LanguageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AudiMib3LanguageItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.audi_mib3_language_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AudiMib3LanguageItemBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new AudiMib3LanguageItemBinding((RadioButton) rootView2, (RadioButton) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
