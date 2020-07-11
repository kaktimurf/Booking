package com.example.booking.DateBaseLayer;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mDataBase extends SQLiteOpenHelper {


    public mDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase mdb) {
        mdb.execSQL("CREATE TABLE IF NOT EXISTS Advertisements " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,adres VARCHAR ,baslik VARCHAR ,mulktipi VARCHAR ,aylikucret VARCHAR ," +
                "odasayisi VARCHAR,isitma VARCHAR,kat VARCHAR,il VARCHAR,ilce VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Advertisements");
        onCreate(db);
    }
}
