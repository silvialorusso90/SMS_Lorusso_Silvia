package com.example.sms_lorusso_silvia.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.mDataObject.Piatti;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parser_r_p extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String jsonData;
    RecyclerView rv;


    ProgressDialog pd;
    public ArrayList<Piatti> piatti =new ArrayList<>();

    public Parser_r_p(Context c, String jsonData, RecyclerView rv) {
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
            Adapter_r_p adapter=new Adapter_r_p(c, piatti);
            rv.setAdapter(adapter);
        }
    }

    private int parseData() {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            piatti.clear();
            Piatti s=null;

            for(int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);

                String nome=jo.getString("Nome");
                String tipo=jo.getString("Portata");
                String prezzo=jo.getString("Prezzo");

                s=new Piatti();
                s.setNome(nome);
                s.setTipo(tipo);
                s.setPrezzo(prezzo);

                piatti.add(s);

            }
            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
