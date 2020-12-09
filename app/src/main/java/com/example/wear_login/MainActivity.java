package com.example.wear_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends WearableActivity {

    private EditText id, password;
    private Button login;

    private String name,pass;
    private String[] usersN = {"1234","douner"};
    private String[] usersP = {"1234","ghdl"};
    private String idv,pav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         id = (EditText) findViewById(R.id.id);
         password = (EditText) findViewById(R.id.pass);

         login = (Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idv = id.getText().toString();
                pav = password.getText().toString();
                Intent i = new Intent(MainActivity.this,list.class);
                for(int k=0; k<usersN.length;k++) {
                    if (idv.equals(usersN[k]) && pav.equals(usersP[k])){

                        i.putExtra("name", idv);
                        startActivity(i);
                        break;
                    }else {
                        Toast.makeText(getApplicationContext(), "없는 직원이거나 비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}
