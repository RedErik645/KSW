package com.wits.ksw.launcher.dabebase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public abstract class AppInfoRoomDatabase extends RoomDatabase {
    private static volatile AppInfoRoomDatabase INSTANCE;

    public abstract AppInfoDao getAppInfoDao();

    public static AppInfoRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppInfoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = (AppInfoRoomDatabase) Room.databaseBuilder(context, AppInfoRoomDatabase.class, "appList").build();
                }
            }
        }
        return INSTANCE;
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.persistence.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.persistence.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override // android.arch.persistence.room.RoomDatabase
    public void clearAllTables() {
    }
}
