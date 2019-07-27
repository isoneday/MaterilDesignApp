package com.imastudio.materildesignapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.imastudio.materildesignapp.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GaleryActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    String [] nama_buah ={"apple","durian","cerry","manggis","strawberry","alpukat"};
    int [] gambar_buah ={R.drawable.apel,R.drawable.durian,R.drawable.ceri,R.drawable.manggis,R.drawable.strawberry,R.drawable.alpukat};
    int [] suara_buah ={R.raw.apel,R.raw.durian,R.raw.ceri,R.raw.manggis,R.raw.strawberry,R.raw.alpukat};
    private MediaPlayer BG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        ButterKnife.bind(this);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this,nama_buah,gambar_buah);
    //isi data ke view
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(player);
        viewPager.setCurrentItem(0);
        BG = MediaPlayer.create(this, suara_buah[0]);
//        BG.setLooping(true);
        BG.setVolume(100, 100);
        BG.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        BG.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BG.start();
    }
    private MediaPlayer mp;

    ViewPager.OnPageChangeListener player = new     ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageSelected(int arg0)
        {
            mp = MediaPlayer.create(GaleryActivity.this, suara_buah[arg0]);
            mp.start();
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {
        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
        }
    };


}
