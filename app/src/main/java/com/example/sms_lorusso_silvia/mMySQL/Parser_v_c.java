package com.example.sms_lorusso_silvia.mMySQL;

import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.mDataObject.Carrello;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Parser_v_c extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String jsonData;
    RecyclerView rv;


    ProgressDialog pd;
    public ArrayList<Carrello> carrello =new ArrayList<>();

    public Parser_v_c(Context c, String jsonData, RecyclerView rv) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if(result==0)
        {
            Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();
        }
        else {
            //ADAPTER
            Adapter_v_c adapter=new Adapter_v_c(c, carrello);
            rv.setAdapter(adapter);
        }
    }

    private int parseData() {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            carrello.clear();
            Carrello s=null;

            for(int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);

                String telefono = jo.getString("Telefono");
                String nome=jo.getString("Piatto");
                String portata=jo.getString("Portata");
                String prezzo=jo.getString("Prezzo");
                String ora = jo.getString("Ora");

                s = new Carrello();
                s.setTelefono(telefono);
                s.setNomeP(nome);
                s.setTipoP(portata);
                s.setPrezzoP(prezzo);
                s.setOraC(ora);

                carrello.add(s);

            }
            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
