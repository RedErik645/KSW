package com.wits.ksw.launcher.view.id8ug;

public class ShortcutAppEntity {
    private String className;
    private String pagName;

    public ShortcutAppEntity() {
    }

    public ShortcutAppEntity(String pagName2, String className2) {
        this.pagName = pagName2;
        this.className = className2;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className2) {
        this.className = className2;
    }

    public String getPagName() {
        return this.pagName;
    }

    public void setPagName(String pagName2) {
        this.pagName = pagName2;
    }
}
