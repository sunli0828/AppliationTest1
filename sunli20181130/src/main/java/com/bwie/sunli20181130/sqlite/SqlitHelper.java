package com.bwie.sunli20181130.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlitHelper extends SQLiteOpenHelper {

    private String CREA ="create table historylists(id integer primary key autoincrement," +
            "history text)";

    public SqlitHelper(Context context) {
        super(context, "Historylist.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
