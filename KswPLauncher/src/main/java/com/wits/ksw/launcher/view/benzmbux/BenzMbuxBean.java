package com.wits.ksw.launcher.view.benzmbux;

import android.graphics.drawable.Drawable;

public class BenzMbuxBean {
    public Drawable appIcon;
    public String appLable;
    public int id;
    public Drawable subIcon1;
    public Drawable subIcon2;

    public Drawable getSubIcon1() {
        return this.subIcon1;
    }

    public void setSubIcon1(Drawable subIcon12) {
        this.subIcon1 = subIcon12;
    }

    public Drawable getSubIcon2() {
        return this.subIcon2;
    }

    public void setSubIcon2(Drawable subIcon22) {
        this.subIcon2 = subIcon22;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id2) {
        this.id = id2;
    }

    public String getAppLable() {
        return this.appLable;
    }

    public void setAppLable(String appLable2) {
        this.appLable = appLable2;
    }

    public Drawable getAppIcon() {
        return this.appIcon;
    }

    public void setAppIcon(Drawable appIcon2) {
        this.appIcon = appIcon2;
    }
}
