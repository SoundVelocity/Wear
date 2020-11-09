package com.example.mywear;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends WearableActivity {

    private ListView li;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li = (ListView) findViewById(R.id.List);

        List<String> list = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        li.setAdapter(adapter);

        list.add("12");
        list.add("10");
        list.add("5");
        list.add("19");

        ok = (Button) findViewById(R.id.okbtn);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"확인", Toast.LENGTH_LONG).show();
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}
