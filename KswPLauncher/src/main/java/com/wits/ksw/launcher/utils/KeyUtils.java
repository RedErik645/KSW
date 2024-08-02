package com.wits.ksw.launcher.utils;

import android.app.Instrumentation;

public class KeyUtils {
    public static void pressKey(final int keycode) {
        new Thread() {
            /* class com.wits.ksw.launcher.utils.KeyUtils.AnonymousClass1 */

            public void run() {
                new Instrumentation().sendKeyDownUpSync(keycode);
            }
        }.start();
    }
}
