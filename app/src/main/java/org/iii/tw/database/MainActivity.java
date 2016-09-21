package org.iii.tw.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyDBHelper dbHelper;
    private SQLiteDatabase db;
    private TextView mesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBHelper(this,"brad",null,1);
        db = dbHelper.getReadableDatabase();
        mesg = (TextView)findViewById(R.id.mesg);
    }
    public void intert(View v){
        ContentValues data = new ContentValues();
        data.put("cname","chuan");
        data.put("tel","123");
        data.put("birthday","1999-01-02");
        db.insert("cust",null,data);
        query(null);
    }
    public void delete(View v){

    }
    public void update(View v){

    }
    public void query(View v){
        mesg.setText("");
        Cursor c = db.query("cust",null,null,null,null,null,null);
        while (c.moveToNext()){
            String id = c.getString(c.getColumnIndex("id"));
            String cname = c.getString(c.getColumnIndex("cname"));
            String tel = c.getString(c.getColumnIndex("tel"));
            String birthday = c.getString(c.getColumnIndex("birthday"));
            mesg.append(id+":"+cname+":"+tel+":"+birthday+"\n");
        }
    }
}
