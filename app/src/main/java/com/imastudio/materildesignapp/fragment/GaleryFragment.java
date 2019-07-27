package com.imastudio.materildesignapp.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imastudio.materildesignapp.R;
import com.imastudio.materildesignapp.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaleryFragment extends Fragment {

    String[] nama_buah = {"apple", "durian", "cerry", "manggis", "strawberry", "alpukat"};
    int[] gambar_buah = {R.drawable.apel, R.drawable.durian, R.drawable.ceri, R.drawable.manggis, R.drawable.strawberry, R.drawable.alpukat};
    int[] suara_buah = {R.raw.apel, R.raw.durian, R.raw.ceri, R.raw.manggis, R.raw.strawberry, R.raw.alpukat};
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;
    private MediaPlayer BG;


    public GaleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galery, container, false);
        unbinder = ButterKnife.bind(this, view);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(),nama_buah,gambar_buah);

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(player);
        viewPager.setCurrentItem(0);
        BG = MediaPlayer.create(getActivity(), suara_buah[0]);
//        BG.setLooping(true);
        BG.setVolume(100, 100);
        BG.start();
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        BG.start();
    }

    private MediaPlayer mp;
    ViewPager.OnPageChangeListener player = new     ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageSelected(int arg0)
        {
            mp = MediaPlayer.create(getActivity(), suara_buah[arg0]);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
