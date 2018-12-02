package com.bwie.sunli20181130.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class HistoryDao {

    private static HistoryDao instance;
    private final SqlitHelper helper;
    private final SQLiteDatabase sb;

    public HistoryDao(Context context) {
        helper = new SqlitHelper(context);
        sb = helper.getWritableDatabase();
    }

    public static HistoryDao getInstance(Context context) {
        if (instance == null) {
            instance = new HistoryDao(context);
        }
        return instance;
    }

    //增
    public void add(HistoryBean bean) {
        ContentValues values = new ContentValues();
        values.put("history", bean.getHistory());
        sb.insert("historylists", null, values);
    }

}
