package com.wits.ksw.launcher.view.benzmbux2021new.bean;

import android.graphics.drawable.Drawable;

public class BenzCardItem {
    private String content;
    private int iconLeft;
    private int iconRight;
    private int imgBg;
    private Drawable imgSrc;
    private boolean isThird;
    private String name;
    private int number;
    private String title;

    public BenzCardItem() {
    }

    public BenzCardItem(int number2, String name2, String title2, String content2, int imgBg2, Drawable imgSrc2, int iconLeft2, int iconRight2, boolean isThird2) {
        this.number = number2;
        this.name = name2;
        this.title = title2;
        this.content = content2;
        this.imgBg = imgBg2;
        this.imgSrc = imgSrc2;
        this.iconLeft = iconLeft2;
        this.iconRight = iconRight2;
        this.isThird = isThird2;
    }

    public void setNumber(int number2) {
        this.number = number2;
    }

    public int getNumber() {
        return this.number;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public String getContent() {
        return this.content;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getName() {
        return this.name;
    }

    public void setIconLeft(int iconLeft2) {
        this.iconLeft = iconLeft2;
    }

    public int getIconLeft() {
        return this.iconLeft;
    }

    public void setIconRight(int iconRight2) {
        this.iconRight = iconRight2;
    }

    public int getIconRight() {
        return this.iconRight;
    }

    public void setThird(boolean third) {
        this.isThird = third;
    }

    public boolean isThird() {
        return this.isThird;
    }

    public void setImgBg(int imgBg2) {
        this.imgBg = imgBg2;
    }

    public int getImgBg() {
        return this.imgBg;
    }

    public void setImgSrc(Drawable imgSrc2) {
        this.imgSrc = imgSrc2;
    }

    public Drawable getImgSrc() {
        return this.imgSrc;
    }

    public String toString() {
        return "BenzCardItem{number=" + this.number + ", name='" + this.name + '\'' + ", title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", imgBg=" + this.imgBg + ", imgSrc=" + this.imgSrc + ", iconLeft=" + this.iconLeft + ", iconRight=" + this.iconRight + ", isThird=" + this.isThird + '}';
    }
}
