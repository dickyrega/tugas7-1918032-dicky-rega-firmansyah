package com.example.tugas7praktikum;

public class PelabuhanPenyeberangan {
    private String _id, _namaorang, _asal, _tujuan;
    public PelabuhanPenyeberangan (String id, String nama, String asal, String tujuan) {
        this._id = id;
        this._namaorang = nama;
        this._asal = asal;
        this._tujuan = tujuan;
    }
    public PelabuhanPenyeberangan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_namaorang() {
        return _namaorang;
    }
    public void set_namaorang(String _namaorang) {
        this._namaorang = _namaorang;
    }
    public String get_asal() {
        return _asal;
    }
    public void set_asal(String _asal) {
        this._asal = _asal;
    }
    public String get_tujuan() {
        return _tujuan;
    }
    public void set_tujuan(String _tujuan) {
        this._tujuan = _tujuan;
    }
}