package android.arch.persistence.db.framework;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final OpenHelper mDelegate;

    FrameworkSQLiteOpenHelper(Context context, String name, SupportSQLiteOpenHelper.Callback callback) {
        this.mDelegate = createDelegate(context, name, callback);
    }

    private OpenHelper createDelegate(Context context, String name, SupportSQLiteOpenHelper.Callback callback) {
        return new OpenHelper(context, name, new FrameworkSQLiteDatabase[1], callback);
    }

    @Override // android.arch.persistence.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // android.arch.persistence.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.mDelegate.setWriteAheadLoggingEnabled(enabled);
    }

    @Override // android.arch.persistence.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.mDelegate.getWritableSupportDatabase();
    }

    @Override // android.arch.persistence.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.mDelegate.getReadableSupportDatabase();
    }

    @Override // android.arch.persistence.db.SupportSQLiteOpenHelper
    public void close() {
        this.mDelegate.close();
    }

    /* access modifiers changed from: package-private */
    public static class OpenHelper extends SQLiteOpenHelper {
        final SupportSQLiteOpenHelper.Callback mCallback;
        final FrameworkSQLiteDatabase[] mDbRef;
        private boolean mMigrated;

        OpenHelper(Context context, String name, final FrameworkSQLiteDatabase[] dbRef, final SupportSQLiteOpenHelper.Callback callback) {
            super(context, name, null, callback.version, new DatabaseErrorHandler() {
                /* class android.arch.persistence.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.AnonymousClass1 */

                public void onCorruption(SQLiteDatabase dbObj) {
                    FrameworkSQLiteDatabase db = dbRef[0];
                    if (db != null) {
                        callback.onCorruption(db);
                    }
                }
            });
            this.mCallback = callback;
            this.mDbRef = dbRef;
        }

        /* access modifiers changed from: package-private */
        public synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase db = super.getWritableDatabase();
            if (this.mMigrated) {
                close();
                return getWritableSupportDatabase();
            }
            return getWrappedDb(db);
        }

        /* access modifiers changed from: package-private */
        public synchronized SupportSQLiteDatabase getReadableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase db = super.getReadableDatabase();
            if (this.mMigrated) {
                close();
                return getReadableSupportDatabase();
            }
            return getWrappedDb(db);
        }

        /* access modifiers changed from: package-private */
        public FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sqLiteDatabase) {
            if (this.mDbRef[0] == null) {
                this.mDbRef[0] = new FrameworkSQLiteDatabase(sqLiteDatabase);
            }
            return this.mDbRef[0];
        }

        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            this.mCallback.onCreate(getWrappedDb(sqLiteDatabase));
        }

        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(sqLiteDatabase), oldVersion, newVersion);
        }

        public void onConfigure(SQLiteDatabase db) {
            this.mCallback.onConfigure(getWrappedDb(db));
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            this.mMigrated = true;
            this.mCallback.onDowngrade(getWrappedDb(db), oldVersion, newVersion);
        }

        public void onOpen(SQLiteDatabase db) {
            if (!this.mMigrated) {
                this.mCallback.onOpen(getWrappedDb(db));
            }
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.mDbRef[0] = null;
        }
    }
}
