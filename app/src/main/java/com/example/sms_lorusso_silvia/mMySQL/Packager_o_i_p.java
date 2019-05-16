package com.example.sms_lorusso_silvia.mMySQL;

import com.example.sms_lorusso_silvia.mDataObject.Carrello;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class Packager_o_i_p {
    Carrello carrello;

    public Packager_o_i_p(Carrello carrello) {
        this.carrello = carrello;
    }

    public String packData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer sb=new StringBuffer();

        try {
            jo.put("Telefono", carrello.getTelefono());
            jo.put("Piatto", carrello.getNomeP());
            jo.put("Portata", carrello.getTipoP());
            jo.put("Prezzo", carrello.getPrezzoP());
            jo.put("Ora", carrello.getOraC());

            Boolean firstvalue=true;
            Iterator it=jo.keys();

            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();

                if(firstvalue) {
                    firstvalue=false;
                }
                else {
                    sb.append("&");
                }

                sb.append(URLEncoder.encode(key,"UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(value,"UTF-8"));

            }while (it.hasNext());

            return sb.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
