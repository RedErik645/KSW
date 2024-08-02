package com.wits.ksw.settings.benz_mbux_2021.bean;

public class BenzMbuxSettingsMainBean {
    private int mBgId;
    private int mColor;
    private int mIconId;
    private String mTitle;

    public BenzMbuxSettingsMainBean(String title, int iconId, int bgId, int color) {
        this.mTitle = title;
        this.mIconId = iconId;
        this.mBgId = bgId;
        this.mColor = color;
    }

    public BenzMbuxSettingsMainBean(String title, int bgId) {
        this.mTitle = title;
        this.mBgId = bgId;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setIconId(int iconId) {
        this.mIconId = iconId;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public void setBgId(int bgId) {
        this.mBgId = bgId;
    }

    public int getBgId() {
        return this.mBgId;
    }

    public void setmColor(int color) {
        this.mColor = color;
    }

    public int getmColor() {
        return this.mColor;
    }
}
