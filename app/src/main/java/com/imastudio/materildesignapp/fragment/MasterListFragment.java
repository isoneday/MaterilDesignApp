package com.imastudio.materildesignapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.imastudio.materildesignapp.R;
import com.imastudio.materildesignapp.adapter.MasterListAdapter;
import com.imastudio.materildesignapp.data.AndroidImageAssets;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {


    @BindView(R.id.images_grid_view)
    GridView imagesGridView;
    @BindView(R.id.next_button)
    Button nextButton;
    Unbinder unbinder;

    public MasterListFragment() {
        // Required empty public constructor
    }

    public  interface  OnImageClickListener{
        void onImageSelected(int position);
    }
    OnImageClickListener clickListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        imagesGridView.setAdapter(adapter);
        imagesGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickListener.onImageSelected(position);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.next_button)
    public void onViewClicked() {
    }
}
