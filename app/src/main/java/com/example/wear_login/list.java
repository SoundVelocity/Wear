package com.example.wear_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class list extends WearableActivity {

    private ListView lv;
    private Button ok;
    private String[] table = {"12번", "09번", "22번", "04번", "15번", "01번", "05번", "20번"};
    //String[] strDate = {"07 : 12 : 34", "07 : 12 : 42", "07 : 13 : 01", "07 : 13 : 22", "07 : 17 : 48", "07 : 20 : 04", "07 : 21 : 34", "07 : 22 : 00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent i2 = getIntent();

//       ArrayList<String> ota = new ArrayList<>();
//        for(int k=0;k<table.length;k++) {
//            ItemData ot = new ItemData();
//            ot.strTitle = table[k];
//            ot.strDate = strDate[k];
//            ota.add(ot);
//        }

        lv = (ListView) findViewById(R.id.List);
       // ListAdapter oot = new ListAdapter(ota);

        final List<String> ott = new ArrayList<>();


        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, table);
        lv.setAdapter(adapter);

        for(int k=0; k<table.length;k++){
            ott.add(table[k]);
        }

        ok = (Button)findViewById(R.id.okbtn);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = ott.get(0);
                ott.remove(0);
                Intent i3 = new Intent(list.this,list2.class);
                i3.putExtra("테이블" ,num);

                for(int j =0; j<table.length-1;j++){
                    table[j] = table[j+1];
                }

                lv.setAdapter(adapter);

                startActivity(i3);
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}
