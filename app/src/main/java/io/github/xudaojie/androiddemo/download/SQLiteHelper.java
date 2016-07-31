package io.github.xudaojie.androiddemo.download;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by xdj on 16/7/28.
 */

public class SQLiteHelper {
    public static void m1() {
        SQLiteDatabase.create(new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
                return null;
            }
        });
    }
}
