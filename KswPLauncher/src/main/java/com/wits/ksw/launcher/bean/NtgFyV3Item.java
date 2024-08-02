package com.wits.ksw.launcher.bean;

import android.graphics.drawable.Drawable;

public class NtgFyV3Item {
    public Drawable appIcon;
    public String appLable;
    public String apppkg;
    public String className;
    public int id;

    public String getApppkg() {
        return this.apppkg;
    }

    public void setApppkg(String apppkg2) {
        this.apppkg = apppkg2;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className2) {
        this.className = className2;
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
