package com.example.sms_lorusso_silvia.mMySQL;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import android.support.v7.widget.RecyclerView;

public class Downloader_v_c extends AsyncTask<Void,Void,String>{

    Context c;
    String url;
    RecyclerView rv;

    ProgressDialog pd;

    public Downloader_v_c(Context c, String url, RecyclerView rv) {
        this.c = c;
        this.url = url;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Fetch");
        pd.setMessage("Fetching...pease wait");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        if(s == null){
            Toast.makeText(c, "Unsuccessfull, null Returned", Toast.LENGTH_SHORT).show();
        }
        else {

            //CALL DATA PARSER
            Parser_v_c parser = new Parser_v_c(c, s, rv);
            parser.execute();
        }
    }

    private String downloadData() {
        HttpURLConnection con = ConnectorG.connect(url);
        if(con == null){
            return null;
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            StringBuffer response = new StringBuffer();
            if(br != null){
                while ((line = br.readLine())  != null){
                    response.append(line+"\n");
                }
                br.close();
            }
            else{
                return null;
            }
            return response.toString();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
