package com.blankj.utilcode.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.reflect.Field;

public final class KeyboardUtils {
    private static final int TAG_ON_GLOBAL_LAYOUT_LISTENER = -8;
    private static long millis;
    private static int sDecorViewDelta = 0;

    public interface OnSoftInputChangedListener {
        void onSoftInputChanged(int i);
    }

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void showSoftInput() {
        InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService("input_method");
        if (imm != null) {
            imm.toggleSoftInput(2, 1);
        }
    }

    public static void showSoftInput(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (!isSoftInputVisible(activity)) {
            toggleSoftInput();
        }
    }

    public static void showSoftInput(View view) {
        if (view != null) {
            showSoftInput(view, 0);
            return;
        }
        throw new NullPointerException("Argument 'view' of type View (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void showSoftInput(View view, int flags) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService("input_method");
            if (imm != null) {
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
                view.requestFocus();
                imm.showSoftInput(view, flags, new ResultReceiver(new Handler()) {
                    /* class com.blankj.utilcode.util.KeyboardUtils.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public void onReceiveResult(int resultCode, Bundle resultData) {
                        if (resultCode == 1 || resultCode == 3) {
                            KeyboardUtils.toggleSoftInput();
                        }
                    }
                });
                imm.toggleSoftInput(2, 1);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'view' of type View (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void hideSoftInput(Activity activity) {
        if (activity != null) {
            hideSoftInput(activity.getWindow());
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void hideSoftInput(Window window) {
        if (window != null) {
            View view = window.getCurrentFocus();
            if (view == null) {
                View decorView = window.getDecorView();
                View focusView = decorView.findViewWithTag("keyboardTagView");
                if (focusView == null) {
                    view = new EditText(window.getContext());
                    view.setTag("keyboardTagView");
                    ((ViewGroup) decorView).addView(view, 0, 0);
                } else {
                    view = focusView;
                }
                view.requestFocus();
            }
            hideSoftInput(view);
            return;
        }
        throw new NullPointerException("Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void hideSoftInput(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService("input_method");
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'view' of type View (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void hideSoftInputByToggle(Activity activity) {
        long nowMillis = System.currentTimeMillis();
        if (Math.abs(nowMillis - millis) > 500 && isSoftInputVisible(activity)) {
            toggleSoftInput();
        }
        millis = nowMillis;
    }

    public static void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService("input_method");
        if (imm != null) {
            imm.toggleSoftInput(0, 0);
        }
    }

    public static boolean isSoftInputVisible(Activity activity) {
        if (activity != null) {
            return getDecorViewInvisibleHeight(activity.getWindow()) > 0;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    /* access modifiers changed from: private */
    public static int getDecorViewInvisibleHeight(Window window) {
        if (window != null) {
            View decorView = window.getDecorView();
            Rect outRect = new Rect();
            decorView.getWindowVisibleDisplayFrame(outRect);
            Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - outRect.bottom));
            int delta = Math.abs(decorView.getBottom() - outRect.bottom);
            if (delta > UtilsBridge.getNavBarHeight() + UtilsBridge.getStatusBarHeight()) {
                return delta - sDecorViewDelta;
            }
            sDecorViewDelta = delta;
            return 0;
        }
        throw new NullPointerException("Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void registerSoftInputChangedListener(Activity activity, OnSoftInputChangedListener listener) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (listener != null) {
            registerSoftInputChangedListener(activity.getWindow(), listener);
        } else {
            throw new NullPointerException("Argument 'listener' of type OnSoftInputChangedListener (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void registerSoftInputChangedListener(final Window window, final OnSoftInputChangedListener listener) {
        if (window == null) {
            throw new NullPointerException("Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (listener != null) {
            if ((window.getAttributes().flags & 512) != 0) {
                window.clearFlags(512);
            }
            FrameLayout contentView = (FrameLayout) window.findViewById(16908290);
            final int[] decorViewInvisibleHeightPre = {getDecorViewInvisibleHeight(window)};
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.blankj.utilcode.util.KeyboardUtils.AnonymousClass2 */

                public void onGlobalLayout() {
                    int height = KeyboardUtils.getDecorViewInvisibleHeight(window);
                    if (decorViewInvisibleHeightPre[0] != height) {
                        listener.onSoftInputChanged(height);
                        decorViewInvisibleHeightPre[0] = height;
                    }
                }
            };
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
            contentView.setTag(TAG_ON_GLOBAL_LAYOUT_LISTENER, onGlobalLayoutListener);
        } else {
            throw new NullPointerException("Argument 'listener' of type OnSoftInputChangedListener (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void unregisterSoftInputChangedListener(Window window) {
        if (window != null) {
            FrameLayout contentView = (FrameLayout) window.findViewById(16908290);
            Object tag = contentView.getTag(TAG_ON_GLOBAL_LAYOUT_LISTENER);
            if ((tag instanceof ViewTreeObserver.OnGlobalLayoutListener) && Build.VERSION.SDK_INT >= 16) {
                contentView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void fixAndroidBug5497(Activity activity) {
        if (activity != null) {
            fixAndroidBug5497(activity.getWindow());
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void fixAndroidBug5497(final Window window) {
        if (window != null) {
            window.setSoftInputMode(window.getAttributes().softInputMode & -17);
            FrameLayout contentView = (FrameLayout) window.findViewById(16908290);
            final View contentViewChild = contentView.getChildAt(0);
            final int paddingBottom = contentViewChild.getPaddingBottom();
            final int[] contentViewInvisibleHeightPre5497 = {getContentViewInvisibleHeight(window)};
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.blankj.utilcode.util.KeyboardUtils.AnonymousClass3 */

                public void onGlobalLayout() {
                    int height = KeyboardUtils.getContentViewInvisibleHeight(window);
                    if (contentViewInvisibleHeightPre5497[0] != height) {
                        View view = contentViewChild;
                        view.setPadding(view.getPaddingLeft(), contentViewChild.getPaddingTop(), contentViewChild.getPaddingRight(), paddingBottom + KeyboardUtils.getDecorViewInvisibleHeight(window));
                        contentViewInvisibleHeightPre5497[0] = height;
                    }
                }
            });
            return;
        }
        throw new NullPointerException("Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    /* access modifiers changed from: private */
    public static int getContentViewInvisibleHeight(Window window) {
        View contentView = window.findViewById(16908290);
        if (contentView == null) {
            return 0;
        }
        Rect outRect = new Rect();
        contentView.getWindowVisibleDisplayFrame(outRect);
        Log.d("KeyboardUtils", "getContentViewInvisibleHeight: " + (contentView.getBottom() - outRect.bottom));
        int delta = Math.abs(contentView.getBottom() - outRect.bottom);
        if (delta <= UtilsBridge.getStatusBarHeight() + UtilsBridge.getNavBarHeight()) {
            return 0;
        }
        return delta;
    }

    public static void fixSoftInputLeaks(Activity activity) {
        if (activity != null) {
            fixSoftInputLeaks(activity.getWindow());
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void fixSoftInputLeaks(Window window) {
        if (window != null) {
            InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService("input_method");
            if (imm != null) {
                for (String leakView : new String[]{"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"}) {
                    try {
                        Field leakViewField = InputMethodManager.class.getDeclaredField(leakView);
                        if (!leakViewField.isAccessible()) {
                            leakViewField.setAccessible(true);
                        }
                        Object obj = leakViewField.get(imm);
                        if (obj instanceof View) {
                            if (((View) obj).getRootView() == window.getDecorView().getRootView()) {
                                leakViewField.set(imm, null);
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void clickBlankArea2HideSoftInput() {
        Log.i("KeyboardUtils", "Please refer to the following code.");
    }
}
