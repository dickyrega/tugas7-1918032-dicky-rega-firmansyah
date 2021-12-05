package com.example.tugas7praktikum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Easal, Etujuan;
    private String Snama, Sasal, Stujuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_namaorang);
        Easal = (EditText) findViewById(R.id.create_asal);
        Etujuan = (EditText) findViewById(R.id.create_tujuan);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sasal = String.valueOf(Easal.getText());
                Stujuan = String.valueOf(Etujuan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama lengkap anda", Toast.LENGTH_SHORT).show();
                } else if (Easal.equals("")){
                    Easal.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi asal kota anda", Toast.LENGTH_SHORT).show();
                } else if (Stujuan.equals("")) {
                    Etujuan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tujuan anda",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Easal.setText("");
                    Etujuan.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreatePelabuhan (new PelabuhanPenyeberangan(null, Snama, Sasal ,Stujuan));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
