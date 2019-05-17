package com.example.sms_lorusso_silvia.mMySQL;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mMySQL.ItemClickListener;

public class MyHolder_v_c extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView telefono, nome, tipo, prezzo, orac;
    ItemClickListener itemClickListener;

    public MyHolder_v_c(View itemView)  {
        super(itemView);

        //itemView è l’oggetto che rappresenta ogni singola View, quindi è su esso che andrà collegato il listener
        telefono = (TextView) itemView.findViewById(R.id.telTxt);
        nome = (TextView) itemView.findViewById(R.id.nomeTxt);
        tipo = (TextView) itemView.findViewById(R.id.tipoTxt);
        prezzo = (TextView) itemView.findViewById(R.id.prezzoTxt);
        orac = (TextView) itemView.findViewById(R.id.oracTxt);
        itemView.setOnClickListener(this);

    }
    public  void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(getLayoutPosition());
    }
}
