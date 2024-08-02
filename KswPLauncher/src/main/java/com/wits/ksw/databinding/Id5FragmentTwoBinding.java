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

public final class Id5FragmentTwoBinding implements ViewBinding {
    public final CheckBox id5ItemApps;
    public final ImageView id5ItemAppsCursor;
    public final CheckBox id5ItemDash;
    public final ImageView id5ItemDashCursor;
    public final CheckBox id5ItemJly;
    public final ImageView id5ItemJlyCursor;
    public final CheckBox id5ItemSet;
    public final ImageView id5ItemSetCursor;
    public final CheckBox id5ItemSjhl;
    public final ImageView id5ItemSjhlCursor;
    public final CheckBox id5ItemVideo;
    public final ImageView id5ItemVideoCursor;
    public final ImageView imageView8;
    private final ConstraintLayout rootView;
    public final TextView textView11;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView textView14;
    public final TextView textView15;
    public final TextView textView16;

    private Id5FragmentTwoBinding(ConstraintLayout rootView2, CheckBox id5ItemApps2, ImageView id5ItemAppsCursor2, CheckBox id5ItemDash2, ImageView id5ItemDashCursor2, CheckBox id5ItemJly2, ImageView id5ItemJlyCursor2, CheckBox id5ItemSet2, ImageView id5ItemSetCursor2, CheckBox id5ItemSjhl2, ImageView id5ItemSjhlCursor2, CheckBox id5ItemVideo2, ImageView id5ItemVideoCursor2, ImageView imageView82, TextView textView112, TextView textView122, TextView textView132, TextView textView142, TextView textView152, TextView textView162) {
        this.rootView = rootView2;
        this.id5ItemApps = id5ItemApps2;
        this.id5ItemAppsCursor = id5ItemAppsCursor2;
        this.id5ItemDash = id5ItemDash2;
        this.id5ItemDashCursor = id5ItemDashCursor2;
        this.id5ItemJly = id5ItemJly2;
        this.id5ItemJlyCursor = id5ItemJlyCursor2;
        this.id5ItemSet = id5ItemSet2;
        this.id5ItemSetCursor = id5ItemSetCursor2;
        this.id5ItemSjhl = id5ItemSjhl2;
        this.id5ItemSjhlCursor = id5ItemSjhlCursor2;
        this.id5ItemVideo = id5ItemVideo2;
        this.id5ItemVideoCursor = id5ItemVideoCursor2;
        this.imageView8 = imageView82;
        this.textView11 = textView112;
        this.textView12 = textView122;
        this.textView13 = textView132;
        this.textView14 = textView142;
        this.textView15 = textView152;
        this.textView16 = textView162;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Id5FragmentTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Id5FragmentTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.id5_fragment_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Id5FragmentTwoBinding bind(View rootView2) {
        int id = R.id.id5_item_apps;
        CheckBox id5ItemApps2 = (CheckBox) rootView2.findViewById(R.id.id5_item_apps);
        if (id5ItemApps2 != null) {
            id = R.id.id5_item_apps_cursor;
            ImageView id5ItemAppsCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_apps_cursor);
            if (id5ItemAppsCursor2 != null) {
                id = R.id.id5_item_dash;
                CheckBox id5ItemDash2 = (CheckBox) rootView2.findViewById(R.id.id5_item_dash);
                if (id5ItemDash2 != null) {
                    id = R.id.id5_item_dash_cursor;
                    ImageView id5ItemDashCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_dash_cursor);
                    if (id5ItemDashCursor2 != null) {
                        id = R.id.id5_item_jly;
                        CheckBox id5ItemJly2 = (CheckBox) rootView2.findViewById(R.id.id5_item_jly);
                        if (id5ItemJly2 != null) {
                            id = R.id.id5_item_jly_cursor;
                            ImageView id5ItemJlyCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_jly_cursor);
                            if (id5ItemJlyCursor2 != null) {
                                id = R.id.id5_item_set;
                                CheckBox id5ItemSet2 = (CheckBox) rootView2.findViewById(R.id.id5_item_set);
                                if (id5ItemSet2 != null) {
                                    id = R.id.id5_item_set_cursor;
                                    ImageView id5ItemSetCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_set_cursor);
                                    if (id5ItemSetCursor2 != null) {
                                        id = R.id.id5_item_sjhl;
                                        CheckBox id5ItemSjhl2 = (CheckBox) rootView2.findViewById(R.id.id5_item_sjhl);
                                        if (id5ItemSjhl2 != null) {
                                            id = R.id.id5_item_sjhl_cursor;
                                            ImageView id5ItemSjhlCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_sjhl_cursor);
                                            if (id5ItemSjhlCursor2 != null) {
                                                id = R.id.id5_item_video;
                                                CheckBox id5ItemVideo2 = (CheckBox) rootView2.findViewById(R.id.id5_item_video);
                                                if (id5ItemVideo2 != null) {
                                                    id = R.id.id5_item_video_cursor;
                                                    ImageView id5ItemVideoCursor2 = (ImageView) rootView2.findViewById(R.id.id5_item_video_cursor);
                                                    if (id5ItemVideoCursor2 != null) {
                                                        id = R.id.imageView8;
                                                        ImageView imageView82 = (ImageView) rootView2.findViewById(R.id.imageView8);
                                                        if (imageView82 != null) {
                                                            id = R.id.textView11;
                                                            TextView textView112 = (TextView) rootView2.findViewById(R.id.textView11);
                                                            if (textView112 != null) {
                                                                id = R.id.textView12;
                                                                TextView textView122 = (TextView) rootView2.findViewById(R.id.textView12);
                                                                if (textView122 != null) {
                                                                    id = R.id.textView13;
                                                                    TextView textView132 = (TextView) rootView2.findViewById(R.id.textView13);
                                                                    if (textView132 != null) {
                                                                        id = R.id.textView14;
                                                                        TextView textView142 = (TextView) rootView2.findViewById(R.id.textView14);
                                                                        if (textView142 != null) {
                                                                            id = R.id.textView15;
                                                                            TextView textView152 = (TextView) rootView2.findViewById(R.id.textView15);
                                                                            if (textView152 != null) {
                                                                                id = R.id.textView16;
                                                                                TextView textView162 = (TextView) rootView2.findViewById(R.id.textView16);
                                                                                if (textView162 != null) {
                                                                                    return new Id5FragmentTwoBinding((ConstraintLayout) rootView2, id5ItemApps2, id5ItemAppsCursor2, id5ItemDash2, id5ItemDashCursor2, id5ItemJly2, id5ItemJlyCursor2, id5ItemSet2, id5ItemSetCursor2, id5ItemSjhl2, id5ItemSjhlCursor2, id5ItemVideo2, id5ItemVideoCursor2, imageView82, textView112, textView122, textView132, textView142, textView152, textView162);
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
