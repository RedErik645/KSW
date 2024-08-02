package com.wits.ksw.launcher.bean;

import java.io.Serializable;

public class WallpaperPicBean implements Serializable {
    private String path;
    private String picFormat;
    private String picName;

    public String getPath() {
        return this.path;
    }

    public void setPath(String path2) {
        this.path = path2;
    }

    public String getPicName() {
        return this.picName;
    }

    public void setPicName(String picName2) {
        this.picName = picName2;
    }

    public String getPicFormat() {
        return this.picFormat;
    }

    public void setPicFormat(String picFormat2) {
        this.picFormat = picFormat2;
    }
}
