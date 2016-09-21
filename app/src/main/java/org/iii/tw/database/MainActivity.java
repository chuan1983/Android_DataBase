package org.iii.tw.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    public void intert(){

    }
    public void delete(){

    }
    public void update(){

    }
    public void query(){
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
