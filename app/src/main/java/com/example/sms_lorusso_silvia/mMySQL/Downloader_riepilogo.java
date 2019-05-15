package com.example.sms_lorusso_silvia.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Downloader_riepilogo extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    RecyclerView rv;
    String tel;

    ProgressDialog pd;

    public Downloader_riepilogo(Context c, String urlAddress, String tel, RecyclerView rv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.rv = rv;
        this.tel = tel;
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
            ParserRiepilogo parser = new ParserRiepilogo(c, s, rv);
            parser.execute();
        }
    }

    private String downloadData(){

        HttpURLConnection con = ConnectorP.connect(urlAddress);
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
