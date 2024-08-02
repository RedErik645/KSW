package android.arch.persistence.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import java.io.File;

public interface SupportSQLiteOpenHelper {

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    public static abstract class Callback {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);

        public Callback(int version2) {
            this.version = version2;
        }

        public void onConfigure(SupportSQLiteDatabase db) {
        }

        public void onDowngrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
            throw new SQLiteException("Can't downgrade database from version " + oldVersion + " to " + newVersion);
        }

        public void onOpen(SupportSQLiteDatabase db) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (r0 != null) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
            r2 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
            if (r2.hasNext() != false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
            deleteDatabaseFile((java.lang.String) r2.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
            deleteDatabaseFile(r6.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0031 A[ExcHandler: all (r1v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v7 'attachedDbs' java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v5 'attachedDbs' java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v6 'attachedDbs' java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v6 'attachedDbs' java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v5 'attachedDbs' java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x002b, B:10:0x0034, B:11:?, B:6:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x002b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(android.arch.persistence.db.SupportSQLiteDatabase r6) {
            /*
            // Method dump skipped, instructions count: 128
            */
            throw new UnsupportedOperationException("Method not decompiled: android.arch.persistence.db.SupportSQLiteOpenHelper.Callback.onCorruption(android.arch.persistence.db.SupportSQLiteDatabase):void");
        }

        private void deleteDatabaseFile(String fileName) {
            if (!fileName.equalsIgnoreCase(":memory:") && fileName.trim().length() != 0) {
                Log.w(TAG, "deleting the database file: " + fileName);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        SQLiteDatabase.deleteDatabase(new File(fileName));
                        return;
                    }
                    try {
                        if (!new File(fileName).delete()) {
                            Log.e(TAG, "Could not delete the database file " + fileName);
                        }
                    } catch (Exception error) {
                        Log.e(TAG, "error while deleting corrupted database file", error);
                    }
                } catch (Exception e) {
                    Log.w(TAG, "delete failed: ", e);
                }
            }
        }
    }

    public static class Configuration {
        public final Callback callback;
        public final Context context;
        public final String name;

        Configuration(Context context2, String name2, Callback callback2) {
            this.context = context2;
            this.name = name2;
            this.callback = callback2;
        }

        public static Builder builder(Context context2) {
            return new Builder(context2);
        }

        public static class Builder {
            Callback mCallback;
            Context mContext;
            String mName;

            public Configuration build() {
                if (this.mCallback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.mContext != null) {
                    return new Configuration(this.mContext, this.mName, this.mCallback);
                } else {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
            }

            Builder(Context context) {
                this.mContext = context;
            }

            public Builder name(String name) {
                this.mName = name;
                return this;
            }

            public Builder callback(Callback callback) {
                this.mCallback = callback;
                return this;
            }
        }
    }
}
