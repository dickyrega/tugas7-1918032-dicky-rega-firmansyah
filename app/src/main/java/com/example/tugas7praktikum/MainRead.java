package com.example.tugas7praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<PelabuhanPenyeberangan> ListPelabuhanPenyeberangan = new ArrayList<PelabuhanPenyeberangan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPelabuhanPenyeberangan );
        mListView = (ListView) findViewById(R.id.list_pelabuhan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPelabuhanPenyeberangan.clear();
        List<PelabuhanPenyeberangan> contacts = db.ReadPelabuhanPenyeberangan();
        for (PelabuhanPenyeberangan cn : contacts) {
            PelabuhanPenyeberangan judulModel = new PelabuhanPenyeberangan();
            judulModel.set_id(cn.get_id());
            judulModel.set_namaorang(cn.get_namaorang());
            judulModel.set_asal(cn.get_asal());
            judulModel.set_tujuan(cn.get_tujuan());
            ListPelabuhanPenyeberangan.add(judulModel);
            if ((ListPelabuhanPenyeberangan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        PelabuhanPenyeberangan obj_itemDetails = (PelabuhanPenyeberangan) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_namaorang();
        String Swarna = obj_itemDetails.get_asal();
        String Sberat = obj_itemDetails.get_tujuan();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iwarna", Swarna);
        goUpdel.putExtra("Iberat", Sberat);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPelabuhanPenyeberangan.clear();
        mListView.setAdapter(adapter_off);
        List<PelabuhanPenyeberangan> contacts = db.ReadPelabuhanPenyeberangan();
        for (PelabuhanPenyeberangan cn : contacts) {
            PelabuhanPenyeberangan judulModel = new PelabuhanPenyeberangan();
            judulModel.set_id(cn.get_id());
            judulModel.set_namaorang(cn.get_namaorang());
            judulModel.set_asal(cn.get_asal());
            judulModel.set_tujuan(cn.get_tujuan());
            ListPelabuhanPenyeberangan.add(judulModel);
            if ((ListPelabuhanPenyeberangan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
