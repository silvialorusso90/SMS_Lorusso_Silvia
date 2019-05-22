package com.example.sms_lorusso_silvia.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.Ordina_Ins_Piatto_Activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class Sender_r_o extends AsyncTask<Void,Void,String>{

    Context c;
    String url;
    String tel;
    String ora;
    //String nome;

    ProgressDialog pd;

    public Sender_r_o(Context c, String url, String tel, String ora) {
        this.c = c;
        this.url = url;
        this.tel =tel;
        this.ora = ora;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Send");
        pd.setMessage("Sending...Please wait");
        pd.show();
    }


    @Override
    protected String doInBackground(Void... voids) {
        return this.send();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();

        if(s==null)
        {
            Toast.makeText(c,"Unsuccessful,Null returned",Toast.LENGTH_SHORT).show();
        }else
        {
            if(s=="Bad Response")
            {
                Toast.makeText(c,"Unsuccessful,Bad Response returned",Toast.LENGTH_SHORT).show();

            }else
            {
                showDialog("Piatto rimosso con successo", "Successo", android.R.drawable.ic_dialog_info);
                //Toast.makeText(c,"Successfully Delete",Toast.LENGTH_SHORT).show();
                intent();

            }
        }
    }

    private String send()
    {
        HttpURLConnection con= ConnectorP.connect(url);
        if(con==null)
        {
            return null;
        }
        try {

            //SUCCESSO O NO??
            int responseCode=con.getResponseCode();
            if(responseCode==con.HTTP_OK)
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response=new StringBuffer();

                String line;
                while ((line=br.readLine()) != null)
                {
                    response.append(line);
                }

                br.close();

                return response.toString();
            }else {
                return "Bad Response";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void intent() {
        Intent i = new Intent(c, Ordina_Ins_Piatto_Activity.class);
        i.putExtra("Telefono", tel);
        i.putExtra("OraConsegna", ora);
        c.startActivity(i);
    }

    private void showDialog(String message, String title, int icon){
        new AlertDialog.Builder(c)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(icon)
                .show();
    }
}
