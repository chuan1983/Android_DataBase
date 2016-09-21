package org.iii.tw.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016/9/21.
 */
public class MyDBHelper extends SQLiteOpenHelper{         //是建立資料表   因為沒有無傳參數建構式所以要先建立建構式  兩個抽象類別方法

    private  final String createTabe1 =
            "CREATE TABLE cust (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ""+"cname TEXT,tel TEXT,birthday DATE)";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTabe1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
