package com.example.pesanmakanriliz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_pesanmakanmeriliz.db";
    public static final int DB_VERSION = 1;
    public static final String TB_ORDER = "tb_order";
    public static final String COL_ID = "id";
    public static final String COL_DATE = "date";
    public static final String COL_TOTAL = "total";
    public static final String COL_DISCOUNT = "discount";
    public static final String COL_BELANJA = "belanja";
    public static final String TB_ITEMS = "items";
    public static final String COL_ITEM_ID = "item_id";
    public static final String COL_ITEM_NAME = "item_name";
    public static final String COL_ITEM_PRICE = "item_price";
    public static final String COL_ITEM_QUANTITY = "item_quantity";

    // Create constructor
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TB_ORDER + "("
                + COL_ID + " INTEGER PRIMARY KEY, "
                + COL_DATE + " TEXT NOT NULL, "
                + COL_TOTAL + " TEXT NOT NULL, "
                + COL_DISCOUNT + " TEXT, "
                + COL_BELANJA + " TEXT);";
        sqLiteDatabase.execSQL(sql);

        String itemsTable = "CREATE TABLE " + TB_ITEMS + "("
                + COL_ITEM_ID + " INTEGER PRIMARY KEY, "
                + COL_ITEM_NAME + " TEXT NOT NULL, "
                + COL_ITEM_PRICE + " TEXT NOT NULL, "
                + COL_ITEM_QUANTITY + " INTEGER NOT NULL);";
        sqLiteDatabase.execSQL(itemsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement upgrade logic here
    }
}