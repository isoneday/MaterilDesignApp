package com.imastudio.materildesignapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.imastudio.materildesignapp.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BagianTubuhFragment extends Fragment {

    List<Integer> dataGambar;
    int indexGambar;

    public BagianTubuhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bagian_tubuh, container, false);
        final ImageView gambartubuh = v.findViewById(R.id.imgbagiantubuh);
        gambartubuh.setImageResource(dataGambar.get(indexGambar));
        gambartubuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexGambar < dataGambar.size() - 1) {
                    indexGambar++;
                } else {
                    indexGambar = 0;
                }
                gambartubuh.setImageResource(dataGambar.get(indexGambar));
            }
        });
        return v;
    }

    public void setDataGambar(List<Integer> dataGambar) {
        this.dataGambar = dataGambar;
    }

    public void setIndexGambar(int indexGambar) {
        this.indexGambar = indexGambar;
    }

}
