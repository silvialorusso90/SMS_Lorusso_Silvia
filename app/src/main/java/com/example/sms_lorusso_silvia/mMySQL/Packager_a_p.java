package com.example.sms_lorusso_silvia.mMySQL;

import com.example.sms_lorusso_silvia.mDataObject.Piatti;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class Packager_a_p {

    Piatti piatti;

    public Packager_a_p(Piatti piatti) {
        this.piatti = piatti;
    }

    public String packData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer sb=new StringBuffer();

        try {
            jo.put("Nome", piatti.getNome());
            jo.put("Tipo", piatti.getTipo());
            jo.put("Prezzo", piatti.getPrezzo());

            Boolean firstvalue=true;
            Iterator it=jo.keys();

            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();

                if(firstvalue)
                {
                    firstvalue=false;
                }else
                {
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
