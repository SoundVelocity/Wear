package com.example.wear_login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class list2 extends WearableActivity {

    private TextView tv;
    private Button ok;
    private ImageView im;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i4 = getIntent();

        String num = i4.getStringExtra("테이블");

        tv = (TextView) findViewById(R.id.tv2);

        tv.setText("    " + num + " 테이블");

        im = (ImageView) findViewById(R.id.image2);
        Bitmap bt = BitmapFactory.decodeResource(getResources(),R.drawable.edi);
        im.setImageBitmap(bt);


        ok = (Button) findViewById(R.id.ok2);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        // Enables Always-on
        setAmbientEnabled();
    }
}
