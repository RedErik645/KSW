package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class Id5FragmentOneBinding implements ViewBinding {
    public final CheckBox id5ItemBrowser;
    public final ImageView id5ItemBrowserCursor;
    public final CheckBox id5ItemBt;
    public final ImageView id5ItemBtCursor;
    public final CheckBox id5ItemCar;
    public final ImageView id5ItemCarCursor;
    public final ImageView id5ItemDashCursor;
    public final CheckBox id5ItemFile;
    public final CheckBox id5ItemMusic;
    public final ImageView id5ItemMusicCursor;
    public final CheckBox id5ItemNavi;
    public final ImageView id5ItemNaviCursor;
    public final ImageView imageView7;
    private final ConstraintLayout rootView;
    public final TextView textView10;
    public final TextView textView5;
    public final TextView textView6;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView textView9;

    private Id5FragmentOneBinding(ConstraintLayout rootView2, CheckBox id5ItemBrowser2, ImageView id5ItemBrowserCursor2, CheckBox id5ItemBt2, ImageView id5ItemBtCursor2, CheckBox id5ItemCar2, ImageView id5ItemCarCursor2, ImageView id5ItemDashCursor2, CheckBox id5ItemFile2, CheckBox id5ItemMusic2, ImageView id5ItemMusicCursor2, CheckBox id5ItemNavi2, ImageView id5ItemNaviCursor2, ImageView imageView72, TextView textView102, TextView textView52, TextView textView62, TextView textView72, TextView textView82, TextView textView92) {
        this.rootView = rootView2;
        this.id5ItemBrowser = id5ItemBrowser2;
        this.id5ItemBrowserCursor = id5ItemBrowserCursor2;
        this.id5ItemBt = id5ItemBt2;
        this.id5ItemBtCursor = id5ItemBtCursor2;
        this.id5ItemCar = id5ItemCar2;
        this.id5ItemCarCursor = id5ItemCarCursor2;
        this.id5ItemDashCursor = id5ItemDashCursor2;
        this.id5ItemFile = id5ItemFile2;
        this.id5ItemMusic = id5ItemMusic2;
        this.id5ItemMusicCursor = id5ItemMusicCursor2;
        this.id5ItemNavi = id5ItemNavi2;
        this.id5ItemNaviCursor = id5ItemNaviCursor2;
        this.imageView7 = imageView72;
        this.textView10 = textView102;
        this.textView5 = textView52;
        this.textView6 = textView62;
        this.textView7 = textView72;
        this.textView8 = textView82;
        this.textView9 = textView92;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Id5FragmentOneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Id5FragmentOneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.id5_fragment_one, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Id5FragmentOneBinding bind(View rootView2) {
        int id = R.id.id5_item_browser;
        CheckBox id5ItemBrowser2 = (CheckBox) rootView2.findViewById(R.id.id5_item_browser);
        if (id5ItemBrowser2 != null) {
            id = R.id.id5_item_browser_cursor;
            ImageView id5ItemBrowserCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_browser_cursor);
            if (id5ItemBrowserCursor2 != null) {
                id = R.id.id5_item_bt;
                CheckBox id5ItemBt2 = (CheckBox) rootView2.findViewById(R.id.id5_item_bt);
                if (id5ItemBt2 != null) {
                    id = R.id.id5_item_bt_cursor;
                    ImageView id5ItemBtCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_bt_cursor);
                    if (id5ItemBtCursor2 != null) {
                        id = R.id.id5_item_car;
                        CheckBox id5ItemCar2 = (CheckBox) rootView2.findViewById(R.id.id5_item_car);
                        if (id5ItemCar2 != null) {
                            id = R.id.id5_item_car_cursor;
                            ImageView id5ItemCarCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_car_cursor);
                            if (id5ItemCarCursor2 != null) {
                                id = R.id.id5_item_dash_cursor;
                                ImageView id5ItemDashCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_dash_cursor);
                                if (id5ItemDashCursor2 != null) {
                                    id = R.id.id5_item_file;
                                    CheckBox id5ItemFile2 = (CheckBox) rootView2.findViewById(R.id.id5_item_file);
                                    if (id5ItemFile2 != null) {
                                        id = R.id.id5_item_music;
                                        CheckBox id5ItemMusic2 = (CheckBox) rootView2.findViewById(R.id.id5_item_music);
                                        if (id5ItemMusic2 != null) {
                                            id = R.id.id5_item_music_cursor;
                                            ImageView id5ItemMusicCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_music_cursor);
                                            if (id5ItemMusicCursor2 != null) {
                                                id = R.id.id5_item_navi;
                                                CheckBox id5ItemNavi2 = (CheckBox) rootView2.findViewById(R.id.id5_item_navi);
                                                if (id5ItemNavi2 != null) {
                                                    id = R.id.id5_item_navi_cursor;
                                                    ImageView id5ItemNaviCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_navi_cursor);
                                                    if (id5ItemNaviCursor2 != null) {
                                                        id = R.id.imageView7;
                                                        ImageView imageView72 = (ImageView) rootView2.findViewById(R.id.imageView7);
                                                        if (imageView72 != null) {
                                                            id = R.id.textView10;
                                                            TextView textView102 = (TextView) rootView2.findViewById(R.id.textView10);
                                                            if (textView102 != null) {
                                                                id = R.id.textView5;
                                                                TextView textView52 = (TextView) rootView2.findViewById(R.id.textView5);
                                                                if (textView52 != null) {
                                                                    id = R.id.textView6;
                                                                    TextView textView62 = (TextView) rootView2.findViewById(R.id.textView6);
                                                                    if (textView62 != null) {
                                                                        id = R.id.textView7;
                                                                        TextView textView72 = (TextView) rootView2.findViewById(R.id.textView7);
                                                                        if (textView72 != null) {
                                                                            id = R.id.textView8;
                                                                            TextView textView82 = (TextView) rootView2.findViewById(R.id.textView8);
                                                                            if (textView82 != null) {
                                                                                id = R.id.textView9;
                                                                                TextView textView92 = (TextView) rootView2.findViewById(R.id.textView9);
                                                                                if (textView92 != null) {
                                                                                    return new Id5FragmentOneBinding((ConstraintLayout) rootView2, id5ItemBrowser2, id5ItemBrowserCursor2, id5ItemBt2, id5ItemBtCursor2, id5ItemCar2, id5ItemCarCursor2, id5ItemDashCursor2, id5ItemFile2, id5ItemMusic2, id5ItemMusicCursor2, id5ItemNavi2, id5ItemNaviCursor2, imageView72, textView102, textView52, textView62, textView72, textView82, textView92);
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
