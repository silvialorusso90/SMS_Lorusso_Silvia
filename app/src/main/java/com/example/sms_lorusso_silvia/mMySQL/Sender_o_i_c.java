package com.example.sms_lorusso_silvia.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.Ordina_Ins_Piatto_Activity;
import com.example.sms_lorusso_silvia.mDataObject.Utenti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;


public class Sender_o_i_c extends AsyncTask<Void,Void,String> {

    private static final String LOG_TAG = Sender_o_i_c.class.getSimpleName();

    Context c;
    String urlAddress;
    EditText nomeTxt, cognomeTxt, telefonoTxt, oraconsegnaTxt;
    Utenti utenti;

    ProgressDialog pd;

    public Sender_o_i_c(Context c, String urlAddress, EditText nomeTxt, EditText cognomeTxt, EditText telefonoTxt, EditText oraconsegnaTxt) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.nomeTxt = nomeTxt;
        this.cognomeTxt = cognomeTxt;
        this.telefonoTxt = telefonoTxt;
        this.oraconsegnaTxt = oraconsegnaTxt;

        utenti = new Utenti();

        utenti.setNome(nomeTxt.getText().toString());
        utenti.setCognome(cognomeTxt.getText().toString());
        utenti.setTelefono(telefonoTxt.getText().toString());
        utenti.setOraconsegna(oraconsegnaTxt.getText().toString());

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
                Toast.makeText(c,"Successfully Saved",Toast.LENGTH_SHORT).show();
                showDialog("Utente salvato con successo", "Successo", android.R.drawable.ic_dialog_info);

                //CLEAR UI
                nomeTxt.setText("");
                cognomeTxt.setText("");

                intent();

            }
        }
    }

    private void intent() {
        Intent i = new Intent(c, Ordina_Ins_Piatto_Activity.class);
        i.putExtra("Telefono", telefonoTxt.getText().toString());
        i.putExtra("OraConsegna", oraconsegnaTxt.getText().toString());
        c.startActivity(i);
    }

    private String send() {
        HttpURLConnection con=ConnectorP.connect(urlAddress);
        if(con==null) {
            return null;
        }
        try {

            OutputStream os=con.getOutputStream();

            //WRITE
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new Packager_o_i_c(utenti).packData());

            bw.flush();
            //RELEASE
            bw.close();
            os.close();

            //SUCCESS OR NOT??
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
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(icon)
                .show();
    }

}
