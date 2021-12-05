package com.example.tugas7praktikum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_pelabuhan";
    private static final String tb_pelabuhan = "tb_pelabuhan";
    private static final String tb_pelabuhan_id = "id";
    private static final String tb_pelabuhan_nama = "nama";
    private static final String tb_pelabuhan_asal = "asal";
    private static final String tb_pelabuhan_tujuan = "tujuan";
    private static final String CREATE_TABLE_PELABUHAN = "CREATE TABLE " + tb_pelabuhan + "(" + tb_pelabuhan_id + " INTEGER PRIMARY KEY ," + tb_pelabuhan_nama + " TEXT," + tb_pelabuhan_asal + " TEXT," + tb_pelabuhan_tujuan + " TEXT " + ")";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PELABUHAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }

    public void CreatePelabuhan(PelabuhanPenyeberangan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pelabuhan_id, mdNotif.get_id());
        values.put(tb_pelabuhan_nama, mdNotif.get_namaorang());
        values.put(tb_pelabuhan_asal, mdNotif.get_asal());
        values.put(tb_pelabuhan_tujuan, mdNotif.get_tujuan());
        db.insert(tb_pelabuhan, null, values);
        db.close();
    }

    public List<PelabuhanPenyeberangan> ReadPelabuhanPenyeberangan() {
        List<PelabuhanPenyeberangan> judulModelList = new ArrayList<PelabuhanPenyeberangan>();
        String selectQuery = "SELECT * FROM " + tb_pelabuhan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                PelabuhanPenyeberangan mdKontak = new PelabuhanPenyeberangan();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_namaorang(cursor.getString(1));
                mdKontak.set_asal(cursor.getString(2));
                mdKontak.set_tujuan(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdatePelabuhanPenyeberangan(PelabuhanPenyeberangan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pelabuhan_nama, mdNotif.get_namaorang());
        values.put(tb_pelabuhan_asal, mdNotif.get_asal());
        values.put(tb_pelabuhan_tujuan, mdNotif.get_tujuan());
        return db.update(tb_pelabuhan, values, tb_pelabuhan_id + " = ?",
                new String[]{
                        String.valueOf(mdNotif.get_id())});
    }

    public void DeletePelabuhanPenyeberangan(PelabuhanPenyeberangan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_pelabuhan, tb_pelabuhan_id + " = ?", new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
