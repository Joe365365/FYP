package com.example.subintel.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sub.class}, version = 1)
public abstract class SubDatabase extends RoomDatabase {

    public abstract SubDao subDao();

    private static SubDatabase INSTANCE;

    public static SubDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SubDatabase.class) {
                if (INSTANCE == null) {INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        SubDatabase.class, "sub_database")
                        .fallbackToDestructiveMigration()
                        .build();
                }
            }
        }
        return INSTANCE;
    }


}
