package com.fujitalabs.periodic_table;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Element.class}, version = 1, exportSchema = false)
public abstract class ElementsDatabase extends RoomDatabase {

    private static ElementsDatabase instance;
    public abstract ElementsDao elementsDao();
    private static final String ELEMENTS_TABLE_NAME = "elements";

    public static synchronized ElementsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, ElementsDatabase.class, ELEMENTS_TABLE_NAME)
                    .createFromAsset("databases/elements.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
