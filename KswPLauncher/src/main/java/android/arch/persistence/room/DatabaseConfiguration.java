package android.arch.persistence.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import java.util.List;
import java.util.Set;

public class DatabaseConfiguration {
    public final boolean allowMainThreadQueries;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final String name;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    public DatabaseConfiguration(Context context2, String name2, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory2, RoomDatabase.MigrationContainer migrationContainer2, List<RoomDatabase.Callback> callbacks2, boolean allowMainThreadQueries2, RoomDatabase.JournalMode journalMode2, boolean requireMigration2, Set<Integer> migrationNotRequiredFrom) {
        this.sqliteOpenHelperFactory = sqliteOpenHelperFactory2;
        this.context = context2;
        this.name = name2;
        this.migrationContainer = migrationContainer2;
        this.callbacks = callbacks2;
        this.allowMainThreadQueries = allowMainThreadQueries2;
        this.journalMode = journalMode2;
        this.requireMigration = requireMigration2;
        this.mMigrationNotRequiredFrom = migrationNotRequiredFrom;
    }

    public boolean isMigrationRequiredFrom(int version) {
        Set<Integer> set;
        return this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(version)));
    }
}
