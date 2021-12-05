package com.example.tugas7praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sasal, Stujuan;
    private EditText Enama, Easal, Etujuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sasal = i.getStringExtra("Iasal");
        Stujuan = i.getStringExtra("Itujuan");
        Enama = (EditText) findViewById(R.id.updel_namaorang);
        Easal = (EditText) findViewById(R.id.updel_asal);
        Etujuan = (EditText) findViewById(R.id.updel_tujuan);
        Enama.setText(Snama);
        Easal.setText(Sasal);
        Etujuan.setText(Stujuan);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sasal = String.valueOf(Easal.getText());
                Stujuan = String.valueOf(Etujuan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Sasal.equals("")){
                    Easal.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna", Toast.LENGTH_SHORT).show();
                } else if (Stujuan.equals("")){
                    Etujuan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna",
                            Toast.LENGTH_SHORT).show();
                } else {db.UpdatePelabuhanPenyeberangan(new PelabuhanPenyeberangan(Sid, Snama, Sasal, Stujuan));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePelabuhanPenyeberangan (new PelabuhanPenyeberangan(Sid, Snama, Sasal, Stujuan));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
