package com.wits.ksw.launcher.base;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bmw_id8_ui.view.ID8ProgressBar;
import com.wits.ksw.launcher.view.ColorArcProgressBar;
import com.wits.ksw.launcher.view.DragGridView;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import java.util.Locale;
import java.util.Random;
import skin.support.content.res.SkinCompatResources;

public class BaseBindingModel {
    public static void srcImage(ImageView imageView, Drawable resid) {
        imageView.setImageDrawable(resid);
    }

    public static void srcImage(ImageView imageView, int resid) {
        imageView.setImageResource(resid);
    }

    public static void setAdpater(GridView gridView, BaseListAdpater adapter) {
        gridView.setAdapter((ListAdapter) adapter);
    }

    public static void setID6MusicAlbumIcon(ImageView imageView, BitmapDrawable data) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder((int) R.drawable.id6_music_album_default)).error(R.drawable.id6_music_album_default)).into(imageView);
    }

    public static void setMusicAlbumIcon(ImageView imageView, BitmapDrawable data) {
        imageView.setAlpha(data != null ? 0.2f : 1.0f);
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder((int) R.drawable.id7_album_bk_big)).error(R.drawable.id7_album_bk_big)).into(imageView);
    }

    public static void setAlbumIcon(ImageView imageView, BitmapDrawable data) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder((int) R.drawable.id7_album_default)).error(R.drawable.id7_album_default)).into(imageView);
    }

    public static void setAlsID7AlbumIcon(ImageView imageView, BitmapDrawable data) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder((int) R.color.transparent)).error(R.color.transparent)).into(imageView);
    }

    public static void setID8AlbumIcon(ImageView imageView, BitmapDrawable data) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder(SkinCompatResources.getDrawable(imageView.getContext(), R.drawable.id8_main_icon_music_album))).error(SkinCompatResources.getDrawable(imageView.getContext(), R.drawable.id8_main_icon_music_album))).into(imageView);
    }

    public static void setID9AlbumIcon(ImageView imageView, BitmapDrawable data) {
        int[] imageResIds = {R.drawable.id9_main_icon_music_album_1, R.drawable.id9_main_icon_music_album_2, R.drawable.id9_main_icon_music_album_3, R.drawable.id9_main_icon_music_album_4, R.drawable.id9_main_icon_music_album_5, R.drawable.id9_main_icon_music_album_6, R.drawable.id9_main_icon_music_album_7};
        BitmapDrawable bitmapDrawable = new BitmapDrawable(imageView.getContext().getResources(), BitmapFactory.decodeResource(imageView.getContext().getResources(), imageResIds[new Random().nextInt(imageResIds.length)]));
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder(bitmapDrawable)).error(bitmapDrawable)).into(imageView);
    }

    public static void setOnItemChangerListener(DragGridView gridView, DragGridView.onItemChangerListener onItemChangerListener) {
        gridView.setOnItemChangeListener(onItemChangerListener);
    }

    public static void setTurnSpeedStr(TextView textView, int speed) {
        textView.setText(String.format(Locale.ENGLISH, "%.1f", Double.valueOf(((double) speed) * 0.001d)));
    }

    public static void setID8ProgressBarMax(ID8ProgressBar id8ProgressBar, int max) {
        id8ProgressBar.setMax(max);
    }

    public static void setID8ProgressBarValue(ID8ProgressBar id8ProgressBar, int value) {
        id8ProgressBar.setValue(value);
    }

    public static void setBenzMbuxProgressBarMax(BenzMbuxProgressBar benzMbuxProgressBar, int max) {
        benzMbuxProgressBar.setMax(max);
    }

    public static void setBenzMbuxProgressBarValue(BenzMbuxProgressBar benzMbuxProgressBar, int value) {
        benzMbuxProgressBar.setValue(value);
    }

    public static void setBmwId9ProgressBarValue(BmwId9ProgressBar bmwId9ProgressBar, int value) {
        bmwId9ProgressBar.setValue(value);
    }

    public static void setNtg6v3ArcProgressBarValue(ColorArcProgressBar progressBar, int value) {
        progressBar.setProgress((float) value);
    }

    public static void setNtg6v3ProgressDrawable(SeekBar seekBar, int value) {
        if (value == 0) {
            seekBar.setProgressDrawable(ContextCompat.getDrawable(seekBar.getContext(), R.drawable.ntg6v3_music_dashboard_seekbar_bg_orange));
        } else if (value == 1) {
            seekBar.setProgressDrawable(ContextCompat.getDrawable(seekBar.getContext(), R.drawable.ntg6v3_music_dashboard_seekbar_bg_yellow));
        } else if (value == 2) {
            seekBar.setProgressDrawable(ContextCompat.getDrawable(seekBar.getContext(), R.drawable.ntg6v3_music_dashboard_seekbar_bg_green));
        } else if (value == 3) {
            seekBar.setProgressDrawable(ContextCompat.getDrawable(seekBar.getContext(), R.drawable.ntg6v3_music_dashboard_seekbar_bg_blue));
        } else if (value == 4) {
            seekBar.setProgressDrawable(ContextCompat.getDrawable(seekBar.getContext(), R.drawable.ntg6v3_music_dashboard_seekbar_bg_purple));
        } else if (value == 5) {
            seekBar.setProgressDrawable(ContextCompat.getDrawable(seekBar.getContext(), R.drawable.ntg6v3_music_dashboard_seekbar_bg_red));
        }
    }
}
