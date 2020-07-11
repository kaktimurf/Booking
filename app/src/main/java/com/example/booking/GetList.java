package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.booking.DateBaseLayer.mDataBase;

import java.util.ArrayList;

public class GetList extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> myAdapter;
   ArrayList<String> values;
    mDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_list);
        listView=findViewById(R.id.listview);
        values =new ArrayList<>();
        db=new mDataBase(this,"ilanlar",null,2);

        myAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getStringData());
        listView.setAdapter(myAdapter);
    }
    String baslik,ucret,sehir,adres;
    public ArrayList<String> getStringData(){
        SQLiteDatabase sqLiteDatabase=db.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM Advertisements",null);
       int IndexSehir=cursor.getColumnIndex("il");
       int IndexUcret=cursor.getColumnIndex("aylikucret");
       int IndexAdres=cursor.getColumnIndex("adres");

       while (cursor.moveToNext()){
            baslik =cursor.getString(2);
            ucret=cursor.getString(IndexSehir);
            sehir=cursor.getString(IndexUcret);
            adres=cursor.getString(IndexAdres);
           values.add("["+baslik+"]"+"   "+ucret+"   "+sehir+" "+adres);
       }
       return values;
    }
}