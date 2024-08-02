package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import com.wits.ksw.R;

public final class AudiMib3SeekbarBinding implements ViewBinding {
    public final SeekBar audioSeekbar;
    public final TextView audioSeekbarLeftText;
    public final TextView audioSeekbarRightText;
    public final TextView audioSeekbarTitle;
    private final LinearLayout rootView;
    public final Space space;

    private AudiMib3SeekbarBinding(LinearLayout rootView2, SeekBar audioSeekbar2, TextView audioSeekbarLeftText2, TextView audioSeekbarRightText2, TextView audioSeekbarTitle2, Space space2) {
        this.rootView = rootView2;
        this.audioSeekbar = audioSeekbar2;
        this.audioSeekbarLeftText = audioSeekbarLeftText2;
        this.audioSeekbarRightText = audioSeekbarRightText2;
        this.audioSeekbarTitle = audioSeekbarTitle2;
        this.space = space2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AudiMib3SeekbarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AudiMib3SeekbarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.audi_mib3_seekbar, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AudiMib3SeekbarBinding bind(View rootView2) {
        int id = R.id.audio_seekbar;
        SeekBar audioSeekbar2 = (SeekBar) rootView2.findViewById(R.id.audio_seekbar);
        if (audioSeekbar2 != null) {
            id = R.id.audio_seekbar_left_text;
            TextView audioSeekbarLeftText2 = (TextView) rootView2.findViewById(R.id.audio_seekbar_left_text);
            if (audioSeekbarLeftText2 != null) {
                id = R.id.audio_seekbar_right_text;
                TextView audioSeekbarRightText2 = (TextView) rootView2.findViewById(R.id.audio_seekbar_right_text);
                if (audioSeekbarRightText2 != null) {
                    id = R.id.audio_seekbar_title;
                    TextView audioSeekbarTitle2 = (TextView) rootView2.findViewById(R.id.audio_seekbar_title);
                    if (audioSeekbarTitle2 != null) {
                        id = R.id.space;
                        Space space2 = (Space) rootView2.findViewById(R.id.space);
                        if (space2 != null) {
                            return new AudiMib3SeekbarBinding((LinearLayout) rootView2, audioSeekbar2, audioSeekbarLeftText2, audioSeekbarRightText2, audioSeekbarTitle2, space2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
