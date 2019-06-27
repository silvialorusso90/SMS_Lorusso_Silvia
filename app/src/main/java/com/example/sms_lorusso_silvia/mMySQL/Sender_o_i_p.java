package com.example.sms_lorusso_silvia.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import com.example.sms_lorusso_silvia.mDataObject.Carrello;

public class Sender_o_i_p extends AsyncTask<Void,Void,String> {

    Context c;
    String url, tel, nomeP, tipoP, prezzoP, oraC;
    Carrello carrello;

    ProgressDialog pd;

    public Sender_o_i_p(Context c, String url, String tel, String nomeP, String tipoP, String prezzoP, String oraC) {
        this.c = c;
        this.url = url;
        this.tel = tel;
        this.nomeP = nomeP;
        this.tipoP = tipoP;
        this.prezzoP = prezzoP;
        this.oraC = oraC;

        carrello = new Carrello();

        carrello.setTelefono(tel);
        carrello.setNomeP(nomeP);
        carrello.setTipoP(tipoP);
        carrello.setPrezzoP(prezzoP);
        carrello.setOraC(oraC);

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
    protected String doInBackground(Void... params) {
        return this.send();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();

        if(s==null) {

            Toast.makeText(c,"Unsuccessful,Null returned",Toast.LENGTH_SHORT).show();
        }
        else{
            if(s=="Bad Response") {
                Toast.makeText(c,"Unsuccessful,Bad Response returned",Toast.LENGTH_SHORT).show();
            }
            else {
                //Toast.makeText(c,"Successfully Saved",Toast.LENGTH_SHORT).show();
                showDialog("Piatto aggiunto al carrello", "Successo", android.R.drawable.ic_dialog_info);

            }
        }

    }

    private String send() {
        HttpURLConnection con=ConnectorP.connect(url);
        if(con==null) {
            return null;
        }
        try {

            OutputStream os=con.getOutputStream();

            //SCRIVI
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new Packager_o_i_p(carrello).packData());

            bw.flush();

            //RILASCIA
            bw.close();
            os.close();

            //SUCCESSO O NO??
            int responseCode=con.getResponseCode();
            if(responseCode==con.HTTP_OK)
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response=new StringBuffer();

                String line;
                while ((line=br.readLine()) != null) {
                    response.append(line);
                }

                br.close();

                return response.toString();
            }
            else {
                return "Bad Response";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void showDialog(String message, String title, int icon){
        new AlertDialog.Builder(c)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(icon)
                .show();
    }
}
