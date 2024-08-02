package com.wits.ksw.databinding;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentEvoid8MainModelBinding implements ViewBinding {
    public final TextView evoid8MainModelTitle;
    public final TextView evoid8MainVolumeTitle;
    public final ImageView evoid8ModelAuto;
    public final ImageView evoid8ModelDay;
    public final ImageView evoid8ModelNight;
    public final ImageView evoid8ModelVolume;
    public final ImageView evoid8ModelVolumeAdd;
    public final LinearLayout evoid8ModelVolumeLayout;
    public final ImageView evoid8ModelVolumeSub;
    public final TextView evoid8ModelVolumeText;
    private final CardView rootView;

    private FragmentEvoid8MainModelBinding(CardView rootView2, TextView evoid8MainModelTitle2, TextView evoid8MainVolumeTitle2, ImageView evoid8ModelAuto2, ImageView evoid8ModelDay2, ImageView evoid8ModelNight2, ImageView evoid8ModelVolume2, ImageView evoid8ModelVolumeAdd2, LinearLayout evoid8ModelVolumeLayout2, ImageView evoid8ModelVolumeSub2, TextView evoid8ModelVolumeText2) {
        this.rootView = rootView2;
        this.evoid8MainModelTitle = evoid8MainModelTitle2;
        this.evoid8MainVolumeTitle = evoid8MainVolumeTitle2;
        this.evoid8ModelAuto = evoid8ModelAuto2;
        this.evoid8ModelDay = evoid8ModelDay2;
        this.evoid8ModelNight = evoid8ModelNight2;
        this.evoid8ModelVolume = evoid8ModelVolume2;
        this.evoid8ModelVolumeAdd = evoid8ModelVolumeAdd2;
        this.evoid8ModelVolumeLayout = evoid8ModelVolumeLayout2;
        this.evoid8ModelVolumeSub = evoid8ModelVolumeSub2;
        this.evoid8ModelVolumeText = evoid8ModelVolumeText2;
    }

    @Override // android.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static FragmentEvoid8MainModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentEvoid8MainModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_evoid8_main_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentEvoid8MainModelBinding bind(View rootView2) {
        int id = R.id.evoid8_main_model_title;
        TextView evoid8MainModelTitle2 = (TextView) rootView2.findViewById(R.id.evoid8_main_model_title);
        if (evoid8MainModelTitle2 != null) {
            id = R.id.evoid8_main_volume_title;
            TextView evoid8MainVolumeTitle2 = (TextView) rootView2.findViewById(R.id.evoid8_main_volume_title);
            if (evoid8MainVolumeTitle2 != null) {
                id = R.id.evoid8_model_auto;
                ImageView evoid8ModelAuto2 = (ImageView) rootView2.findViewById(R.id.evoid8_model_auto);
                if (evoid8ModelAuto2 != null) {
                    id = R.id.evoid8_model_day;
                    ImageView evoid8ModelDay2 = (ImageView) rootView2.findViewById(R.id.evoid8_model_day);
                    if (evoid8ModelDay2 != null) {
                        id = R.id.evoid8_model_night;
                        ImageView evoid8ModelNight2 = (ImageView) rootView2.findViewById(R.id.evoid8_model_night);
                        if (evoid8ModelNight2 != null) {
                            id = R.id.evoid8_model_volume;
                            ImageView evoid8ModelVolume2 = (ImageView) rootView2.findViewById(R.id.evoid8_model_volume);
                            if (evoid8ModelVolume2 != null) {
                                id = R.id.evoid8_model_volume_add;
                                ImageView evoid8ModelVolumeAdd2 = (ImageView) rootView2.findViewById(R.id.evoid8_model_volume_add);
                                if (evoid8ModelVolumeAdd2 != null) {
                                    id = R.id.evoid8_model_volume_layout;
                                    LinearLayout evoid8ModelVolumeLayout2 = (LinearLayout) rootView2.findViewById(R.id.evoid8_model_volume_layout);
                                    if (evoid8ModelVolumeLayout2 != null) {
                                        id = R.id.evoid8_model_volume_sub;
                                        ImageView evoid8ModelVolumeSub2 = (ImageView) rootView2.findViewById(R.id.evoid8_model_volume_sub);
                                        if (evoid8ModelVolumeSub2 != null) {
                                            id = R.id.evoid8_model_volume_text;
                                            TextView evoid8ModelVolumeText2 = (TextView) rootView2.findViewById(R.id.evoid8_model_volume_text);
                                            if (evoid8ModelVolumeText2 != null) {
                                                return new FragmentEvoid8MainModelBinding((CardView) rootView2, evoid8MainModelTitle2, evoid8MainVolumeTitle2, evoid8ModelAuto2, evoid8ModelDay2, evoid8ModelNight2, evoid8ModelVolume2, evoid8ModelVolumeAdd2, evoid8ModelVolumeLayout2, evoid8ModelVolumeSub2, evoid8ModelVolumeText2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
