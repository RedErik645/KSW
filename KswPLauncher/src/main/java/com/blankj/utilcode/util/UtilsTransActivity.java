package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import com.blankj.utilcode.util.Utils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UtilsTransActivity extends AppCompatActivity {
    private static final Map<UtilsTransActivity, TransActivityDelegate> CALLBACK_MAP = new HashMap();
    protected static final String EXTRA_DELEGATE = "extra_delegate";

    public static void start(TransActivityDelegate delegate) {
        start(null, null, delegate, UtilsTransActivity.class);
    }

    public static void start(Utils.Consumer<Intent> consumer, TransActivityDelegate delegate) {
        start(null, consumer, delegate, UtilsTransActivity.class);
    }

    public static void start(Activity activity, TransActivityDelegate delegate) {
        start(activity, null, delegate, UtilsTransActivity.class);
    }

    public static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate delegate) {
        start(activity, consumer, delegate, UtilsTransActivity.class);
    }

    protected static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate delegate, Class<?> cls) {
        if (delegate != null) {
            Intent starter = new Intent(Utils.getApp(), cls);
            starter.putExtra(EXTRA_DELEGATE, delegate);
            if (consumer != null) {
                consumer.accept(starter);
            }
            if (activity == null) {
                starter.addFlags(268435456);
                Utils.getApp().startActivity(starter);
                return;
            }
            activity.startActivity(starter);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        Serializable extra = getIntent().getSerializableExtra(EXTRA_DELEGATE);
        if (!(extra instanceof TransActivityDelegate)) {
            super.onCreate(savedInstanceState);
            finish();
            return;
        }
        TransActivityDelegate delegate = (TransActivityDelegate) extra;
        CALLBACK_MAP.put(this, delegate);
        delegate.onCreateBefore(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        delegate.onCreated(this, savedInstanceState);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        super.onStart();
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onStarted(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onResumed(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onPaused(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onStopped(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onSaveInstanceState(this, outState);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, TransActivityDelegate> map = CALLBACK_MAP;
        TransActivityDelegate callback = map.get(this);
        if (callback != null) {
            callback.onDestroy(this);
            map.remove(this);
        }
    }

    @Override // android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback, android.support.v4.app.FragmentActivity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback != null) {
            callback.onActivityResult(this, requestCode, resultCode, data);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        TransActivityDelegate callback = CALLBACK_MAP.get(this);
        if (callback == null) {
            return super.dispatchTouchEvent(ev);
        }
        if (callback.dispatchTouchEvent(this, ev)) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    public static abstract class TransActivityDelegate implements Serializable {
        public void onCreateBefore(UtilsTransActivity activity, Bundle savedInstanceState) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onCreated(UtilsTransActivity activity, Bundle savedInstanceState) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onStarted(UtilsTransActivity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onDestroy(UtilsTransActivity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onResumed(UtilsTransActivity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onPaused(UtilsTransActivity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onStopped(UtilsTransActivity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onSaveInstanceState(UtilsTransActivity activity, Bundle outState) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onRequestPermissionsResult(UtilsTransActivity activity, int requestCode, String[] permissions, int[] grantResults) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onActivityResult(UtilsTransActivity activity, int requestCode, int resultCode, Intent data) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public boolean dispatchTouchEvent(UtilsTransActivity activity, MotionEvent ev) {
            if (activity != null) {
                return false;
            }
            throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }
}
