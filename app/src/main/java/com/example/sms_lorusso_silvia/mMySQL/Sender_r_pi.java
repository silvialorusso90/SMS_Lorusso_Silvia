package com.example.sms_lorusso_silvia.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.RistoratoreActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class Sender_r_pi extends AsyncTask<Void,Void,String> {

    Context c;
    String url;
    String nome;

    ProgressDialog pd;

    public Sender_r_pi(Context c, String url, String nome) {
        this.c = c;
        this.url = url;
        this.nome = nome;
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
                Toast.makeText(c,"Successfully Delete",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(c, RistoratoreActivity.class);
                c.startActivity(i);
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

            OutputStream os=con.getOutputStream();

            //WRITE
            //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            //bw.write(new Packager_a_p(piatti).packData());

            //bw.flush();
            //RELEASE
            //bw.close();
            os.close();

            //SUCCESS OR NOT??
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
}
