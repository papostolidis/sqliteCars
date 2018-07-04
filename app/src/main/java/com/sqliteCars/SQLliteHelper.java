package com.sqliteCars;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cars_db.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CARS= "cars";
    public static final String COLUMN_BRAND = "brand";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_COLOR = "color";

    private static  final String DATABASE_CREATE_CARS= "CREATE TABLE "+TABLE_CARS+" (" +
            "id integer primary key autoincrement, " +
            COLUMN_BRAND+" text not null, " +
            COLUMN_MODEL+" text not null, " +
            COLUMN_COLOR+" not null)";

    public SQLliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_CARS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
