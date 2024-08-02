package com.blankj.utilcode.util;

import android.app.Application;
import android.support.v4.content.FileProvider;

public class UtilsFileProvider extends FileProvider {
    @Override // android.support.v4.content.FileProvider
    public boolean onCreate() {
        Utils.init((Application) getContext().getApplicationContext());
        return true;
    }
}
