package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.DateBaseLayer.mDataBase;

public class AddedActivity extends AppCompatActivity {
    EditText baslik,adres,mulk_tipi,aylik_ucret,oda_sayisi,isitma,kat,il,ilce;
    Button btnAdd;
    private mDataBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added);
        baslik=(EditText)findViewById(R.id.editTxtMulkBaslikAddedActivity);
        adres=(EditText)findViewById(R.id.editTxtAdresAddedActivity);
        mulk_tipi=(EditText)findViewById(R.id.editTxtMulkTipiAddedActivity);
        aylik_ucret=(EditText)findViewById(R.id.editTxtAylikUcretAddedActivity);
        oda_sayisi=(EditText)findViewById(R.id.editTxtOdaSayisiAddedActivty);
        isitma=(EditText)findViewById(R.id.editTxtIsitmaAddedActivty);
        kat=(EditText)findViewById(R.id.editTxtKatAddedActivity);
        il=(EditText)findViewById(R.id.editTxtilAddedActivity);
        ilce=(EditText)findViewById(R.id.editTxtilceAddedActivity);
        btnAdd=(Button)findViewById(R.id.btnilanVerAddedActivity);
        myBase=new mDataBase(this,"ilanlar",null,2);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _baslik=baslik.getText().toString();
                String _adres=adres.getText().toString();
                String _mulk_tipi=mulk_tipi.getText().toString();
                String _aylik_ucret=aylik_ucret.getText().toString();
                String _oda_sayisi=oda_sayisi.getText().toString();
                String _isitma=isitma.getText().toString();
                String _kat=kat.getText().toString();
                String _il=il.getText().toString();
                String _ilce=ilce.getText().toString();
                if(_baslik.equals("")||_adres.equals("")||_mulk_tipi.equals("")||
                  _aylik_ucret.equals("")||_isitma.equals("")||kat.equals("")||_il.equals("")||_ilce.equals("")){

                    Toast.makeText(getApplicationContext(),"Filds are empy",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        ilanEkle(_baslik,_adres,_mulk_tipi,_aylik_ucret,_oda_sayisi,_isitma,_kat,_il,_ilce);
                    }catch (Exception error){
                        error.printStackTrace();
                    }finally {
                        Intent intent=new Intent(AddedActivity.this,GetList.class);
                        startActivity(intent);
                        finish();
                    }
                } }});



    }
    private void ilanEkle(String baslik,String adres,String mulktipi,String aylikucret,String odasayisi,String isitma,String kat,String il,String ilce){
        SQLiteDatabase db=myBase.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("adres", adres);
        values.put("baslik", baslik);
        values.put("mulktipi", mulktipi);
        values.put("aylikucret", aylikucret);
        values.put("odasayisi", odasayisi);
        values.put("isitma", isitma);
        values.put("kat", kat);
        values.put("il", il);
        values.put("ilce", ilce);
        db.insertOrThrow("Advertisements",null,values);

    }

}