package com.wits.ksw.launcher.view.id9als;

public class Id9ChangeModelBean {
    public static int ITEM_TYPE_MODEL = 1;
    public static int ITEM_TYPE_WALLPAPER = 2;
    private int bgResId;
    private boolean isSelect;
    private int itemType;
    private String modelId;
    private String title;

    public Id9ChangeModelBean(int itemType2) {
        this.itemType = itemType2;
    }

    public Id9ChangeModelBean(int bgResId2, String title2, String modelId2, int itemType2) {
        this.itemType = itemType2;
        this.modelId = modelId2;
        this.title = title2;
        this.bgResId = bgResId2;
    }

    public int getBgResId() {
        return this.bgResId;
    }

    public void setBgResId(int bgResId2) {
        this.bgResId = bgResId2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }

    public void setItemType(int itemType2) {
        this.itemType = itemType2;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getModelId() {
        return this.modelId;
    }

    public void setModelId(String modelId2) {
        this.modelId = modelId2;
    }
}
