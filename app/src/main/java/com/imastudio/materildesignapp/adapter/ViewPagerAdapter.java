package com.imastudio.materildesignapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imastudio.materildesignapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerAdapter extends PagerAdapter {

    Activity act;
    String[] nama_buah;
    int[] gambar_buah;
    int[] suara_buah;

    public ViewPagerAdapter(Activity galeryActivity, String[] nama_buah, int[] gambar_buah) {
        act = galeryActivity;
        this.gambar_buah = gambar_buah;
        this.nama_buah = nama_buah;
//this.suara_buah=suara_buah;
    }

    @Override
    public int getCount() {
        return nama_buah.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) act.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.tampilangalery, container, false);
       ViewHolder holder = new ViewHolder(view);
       holder.txtnama.setText(nama_buah[position]);
       holder.imggambar.setImageResource(gambar_buah[position]);
        ((ViewPager)container).addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        ((ViewPager)container).removeView(((LinearLayout) object));

    }


    static
    class ViewHolder {
        @BindView(R.id.imggambar)
        ImageView imggambar;
        @BindView(R.id.txtnama)
        TextView txtnama;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
