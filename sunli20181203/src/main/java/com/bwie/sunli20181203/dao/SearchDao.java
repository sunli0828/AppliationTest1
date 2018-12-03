package com.bwie.sunli20181203.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bwie.sunli20181203.bean.SearchBean;
import com.bwie.sunli20181203.sqlite.SqlitHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchDao  {

    SqlitHelper sqlitHelper;
    SQLiteDatabase sb;

    public SearchDao(Context context) {
        sqlitHelper = new SqlitHelper(context);
        sb = sqlitHelper.getReadableDatabase();
    }

    //增
    public void add(String title, String uuid) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("uuid", uuid);
        sb.insert("searchs", null, values);
    }

    //清空历史
    public void delAll(String uuid) {
        sb.delete("searchs", "uuid = ?" , new String[]{uuid});
    }

    //查询
    public List<SearchBean> select() {
        List<SearchBean> list = new ArrayList<>();
        Cursor query = sb.query("searchs", null, null, null, null, null, null);
        while (query.moveToNext()) {
            String title = query.getString(query.getColumnIndex("title"));
            String uuid = query.getString(query.getColumnIndex("uuid"));
            SearchBean bean = new SearchBean(title, uuid);
            list.add(bean);
        }
        return list;
    }
}
