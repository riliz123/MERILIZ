package com.example.pesanmakanriliz;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView id, date, total;
    private Database SQLite = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.inputname);
        date = findViewById(R.id.tanggalpesan);
        total = findViewById(R.id.submit);

        getDatabase();
    }

    private void getDatabase() {
        try {
            SQLiteDatabase db = SQLite.getReadableDatabase();
            Cursor c = db.rawQuery("select * from db_pesanmakanmeriliz.db", null);
            c.moveToFirst();
            id.setText(String.valueOf(c.getString(1)));
            date.setText(String.valueOf(c.getString(2)));
            total.setText(String.valueOf(c.getString(3)));
            db.close();
        }catch (Exception e){
            Log.e("Err : ", e.getMessage());
        }
    }
}
