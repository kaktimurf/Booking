package com.example.booking.DateBaseLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DateBase extends SQLiteOpenHelper {
    public DateBase( Context context ) {
        super(context,  "Booking", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Register (email text primary key,firstName text,lastName text,password text,phoneNumber text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
     db.execSQL("Drop table if exists Register");

    }

    public boolean insert(String email,String firstName,String lastName,String password,String phoneNumber){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("firstName",firstName);
        contentValues.put("lastName",lastName);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("phoneNumber",phoneNumber);
        long ins=db.insert("Register",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;


    }
    public Boolean chkemail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM Register WHERE email=?",new String[] {email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM Register WHERE email=? and password=?",new
                String[]{email,password});
        if(cursor.getCount()>0) return  true;
        else return false;
    }
}
