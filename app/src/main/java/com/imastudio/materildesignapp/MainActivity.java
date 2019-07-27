package com.imastudio.materildesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btngaleri)
    Button btngaleri;
    @BindView(R.id.btnvideo)
    Button btnvideo;
    @BindView(R.id.btnnavigation)
    Button btnnavigation;
    @BindView(R.id.btnandroid)
    Button btnandroid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btngaleri, R.id.btnvideo, R.id.btnnavigation, R.id.btnandroid})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btngaleri:
                startActivity(new Intent(MainActivity.this,GaleryActivity.class));
                break;
            case R.id.btnvideo:
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
                break;
            case R.id.btnnavigation:
                startActivity(new Intent(MainActivity.this,NavigationActivity.class));

                break;
            case R.id.btnandroid:
                startActivity(new Intent(MainActivity.this,AndroidActivity.class));

                break;
        }
    }
}
