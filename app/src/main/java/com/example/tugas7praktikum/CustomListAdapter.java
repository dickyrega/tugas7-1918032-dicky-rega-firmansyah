package com.example.tugas7praktikum;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<PelabuhanPenyeberangan> movieItems;
    public CustomListAdapter(Activity activity, List<PelabuhanPenyeberangan> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView text_namaorang = (TextView)
                convertView.findViewById(R.id.text_namaorang);
        TextView text_asal = (TextView)
                convertView.findViewById(R.id.text_asal);
        TextView text_tujuan = (TextView)
                convertView.findViewById(R.id.text_tujuan);
        PelabuhanPenyeberangan m = movieItems.get(position);
        text_namaorang.setText("Nama Lengkap : "+ m.get_namaorang());
        text_asal.setText("Asal : "+ m.get_asal());
        text_tujuan.setText("Tujuan Penyeberangan : "+ m.get_tujuan());
        return convertView;
    }
}
