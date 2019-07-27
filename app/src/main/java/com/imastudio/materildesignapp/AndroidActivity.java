package com.imastudio.materildesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.imastudio.materildesignapp.fragment.MasterListFragment;

public class AndroidActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {


    int indexKepala;
    int indexBadan;
    int indexKaki;
    private boolean tablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        if (findViewById(R.id.android_linear_layout) != null) {

            tablet = true;
            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            Button button = findViewById(R.id.next_button);
            button.setVisibility(View.GONE);
        } else {
            tablet = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "anda memilih item :" + position, Toast.LENGTH_SHORT).show();
        int bagianTubuh = position / 12;
        int listdata = position - 21 * bagianTubuh;

        if (tablet == true) {

        } else {
            switch (bagianTubuh) {
                case 0:
                    indexKepala = listdata;
                    break;
                case 1:
                    indexBadan = listdata;
                    break;
                case 2:
                    indexKaki = listdata;
                    break;
            }
            Bundle b = new Bundle();
            b.putInt("indexKepala", indexKepala);
            b.putInt("indexBadan", indexBadan);
            b.putInt("indexKaki", indexKaki);
            final Intent intent = new Intent(AndroidActivity.this,DetailAndroidActivity.class);
            intent.putExtras(b);
            Button next = findViewById(R.id.next_button);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }


    }
}
