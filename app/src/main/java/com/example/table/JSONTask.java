package com.example.table;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... urls) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("user_id", "androidTest");
            jsonObject.accumulate("name", "yun");

            HttpURLConnection con = null;
            BufferedReader reader = null;

            try{
                //URL url = new URL("http://192.168.25.16:3000/users");
                URL url = new URL(urls[0]);
                con = (HttpURLConnection) url.openConnection();
                con.connect();

                InputStream stream = con.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                return buffer.toString();
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(con != null){
                    con.disconnect();
                }
                try {
                    if(reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //tableN.setText(result);
    }
}

