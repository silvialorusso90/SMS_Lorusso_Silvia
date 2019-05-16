package com.example.sms_lorusso_silvia.mMySQL;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sms_lorusso_silvia.R;

public class MyHolderRiepilogo extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView telTxt, nomeTxt, tipoTxt, prezzoTxt, oraCTxt;
    ItemClickListener itemClickListener;

    public MyHolderRiepilogo(View itemView)  {
        super(itemView);

        //itemView è l’oggetto che rappresenta ogni singola View, quindi è su esso che andrà collegato il listener
        nomeTxt = (TextView) itemView.findViewById(R.id.nomeTxt);
        tipoTxt = (TextView) itemView.findViewById(R.id.tipoTxt);
        prezzoTxt = (TextView) itemView.findViewById(R.id.prezzoTxt);
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
