package android.arch.persistence.db.framework;

import android.arch.persistence.db.SupportSQLiteProgram;
import android.database.sqlite.SQLiteProgram;

class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    FrameworkSQLiteProgram(SQLiteProgram delegate) {
        this.mDelegate = delegate;
    }

    @Override // android.arch.persistence.db.SupportSQLiteProgram
    public void bindNull(int index) {
        this.mDelegate.bindNull(index);
    }

    @Override // android.arch.persistence.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        this.mDelegate.bindLong(index, value);
    }

    @Override // android.arch.persistence.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        this.mDelegate.bindDouble(index, value);
    }

    @Override // android.arch.persistence.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        this.mDelegate.bindString(index, value);
    }

    @Override // android.arch.persistence.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        this.mDelegate.bindBlob(index, value);
    }

    @Override // android.arch.persistence.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}