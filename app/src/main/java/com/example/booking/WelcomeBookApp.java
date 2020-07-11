package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import  android.view.Menu;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.booking.DateBaseLayer.DateBase;

public class WelcomeBookApp extends AppCompatActivity {
    DateBase users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        TextView textView=findViewById(R.id.UserName);
        textView.setText(getUserName());

    }
    private String getUserName(){
        users=new DateBase(getApplicationContext());
        SQLiteDatabase db=users.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM Register ",null);
        String isim="";
        String soyisim="";
        while (cursor.moveToNext()){
            isim=cursor.getString(1);
            soyisim=cursor.getString(2);
        }
        return isim+" "+soyisim+" HOŞGELDİN";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=new MenuInflater(this);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.ilanver){
            Intent intent=new Intent(WelcomeBookApp.this,AddedActivity.class);
            startActivityIfNeeded(intent,1);
        }
         if(item.getItemId()==R.id.listele){
            Intent intent=new Intent(WelcomeBookApp.this,GetList.class);
            startActivity(intent);
        }
         if (item.getItemId()==R.id.cıkıs){
             Intent intent=new Intent(WelcomeBookApp.this,MainActivity.class);
             startActivity(intent);
             finish();
         }
        return super.onOptionsItemSelected(item);
    }
}