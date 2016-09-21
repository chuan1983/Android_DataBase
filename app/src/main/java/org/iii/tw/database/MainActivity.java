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
        //INSERT INTO cust (cname,tel,birthday) VALUES ('chuan','123','1999-01-02')
        ContentValues data = new ContentValues();
        data.put("cname","Eric");
        data.put("tel","789");
        data.put("birthday","1999-01-04");
        db.insert("cust",null,data);
        query(null);
    }
    public void delete(View v){
        //DELETE FROM cust WHERE id = 3 and cname = 'brad'
        db.delete("cust", "id = ? and cname = ?", new String[]{"3","chuan"});
        query(null);

    }
    public void update(View v){
        // UPDATE cust SET cname='Kevin', tel='2222' WHERE id=5;
        ContentValues data = new ContentValues();
        data.put("cname","kevin");
        data.put("tel","2222");
        db.update("cust",data,"id = ?", new String[]{"5",});
        query(null);

    }
    public void query(View v){
        mesg.setText("");
        // SELECT * FROM cust
//        Cursor c = db.query("cust",null,null,null,null,null,null);

        // SELECT * FROM cust ORDER BY cname
        //Cursor c = db.query("cust",null,null,null,null,null,"cname,tel");

        // SELECT * FROM cust WHERE birthday > '1999-02-01' ORDER BY cname
//        Cursor c = db.query("cust",null,"birthday > ?",new String[]{"1999-02-01"},
//                null,null,"cname,tel");

        // SELECT cname, tel, birthday FROM cust WHERE birthday > '1999-02-01' ORDER BY cname
        Cursor c = db.query("cust",new String[]{"cname","tel","birthday"},
                "birthday > ?",new String[]{"1999-02-01"},
                null,null,"cname,tel");
        while (c.moveToNext()){
            String id = c.getString(c.getColumnIndex("id"));
            String cname = c.getString(c.getColumnIndex("cname"));
            String tel = c.getString(c.getColumnIndex("tel"));
            String birthday = c.getString(c.getColumnIndex("birthday"));
            mesg.append(id+":"+cname+":"+tel+":"+birthday+"\n");
        }
    }
}
