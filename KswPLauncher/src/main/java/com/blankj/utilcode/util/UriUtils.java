package com.blankj.utilcode.util;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Uri res2Uri(String resPath) {
        return Uri.parse("android.resource://" + Utils.getApp().getPackageName() + "/" + resPath);
    }

    public static Uri file2Uri(File file) {
        if (file == null) {
            throw new NullPointerException("Argument 'file' of type File (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        } else {
            return FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.provider", file);
        }
    }

    public static File uri2File(Uri uri) {
        if (uri != null) {
            File file = uri2FileReal(uri);
            if (file != null) {
                return file;
            }
            return copyUri2Cache(uri);
        }
        throw new NullPointerException("Argument 'uri' of type Uri (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x027b A[Catch:{ Exception -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x027e A[Catch:{ Exception -> 0x02eb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File uri2FileReal(android.net.Uri r26) {
        /*
        // Method dump skipped, instructions count: 1186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.uri2FileReal(android.net.Uri):java.io.File");
    }

    private static File getFileFromUri(Uri uri, String code) {
        return getFileFromUri(uri, null, null, code);
    }

    private static File getFileFromUri(Uri uri, String selection, String[] selectionArgs, String code) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring("/QQBrowser".length(), path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor cursor = Utils.getApp().getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, null);
        if (cursor == null) {
            Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + code);
            return null;
        }
        try {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("_data");
                if (columnIndex > -1) {
                    return new File(cursor.getString(columnIndex));
                }
                Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + code);
                cursor.close();
                return null;
            }
            Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + code);
            cursor.close();
            return null;
        } catch (Exception e) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + code);
            return null;
        } finally {
            cursor.close();
        }
    }

    private static File copyUri2Cache(Uri uri) {
        Log.d("UriUtils", "copyUri2Cache() called");
        InputStream is = null;
        try {
            is = Utils.getApp().getContentResolver().openInputStream(uri);
            File file = new File(Utils.getApp().getCacheDir(), "" + System.currentTimeMillis());
            UtilsBridge.writeFileFromIS(file.getAbsolutePath(), is);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return file;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] uri2Bytes(Uri uri) {
        InputStream is = null;
        try {
            is = Utils.getApp().getContentResolver().openInputStream(uri);
            byte[] inputStream2Bytes = UtilsBridge.inputStream2Bytes(is);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return inputStream2Bytes;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            Log.d("UriUtils", "uri to bytes failed.");
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
