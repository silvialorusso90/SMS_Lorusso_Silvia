package com.example.sms_lorusso_silvia.mMySQL;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mDataObject.Carrello;
import com.example.sms_lorusso_silvia.mDataObject.Piatti;

import java.util.ArrayList;

class Adapter_v_c extends RecyclerView.Adapter<MyHolder_v_c>{

    Context c;
    ArrayList<Carrello> mCarrello;
    LayoutInflater inflater;

    public Adapter_v_c(Context c, ArrayList<Carrello> carrello) {
        this.c = c;
        this.mCarrello = carrello;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyHolder_v_c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.m_comande, viewGroup, false);
        return new MyHolder_v_c(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder_v_c holder, final int position) {

        holder.telefono.setText(mCarrello.get(position).getTelefono());
        holder.nome.setText(mCarrello.get(position).getNomeP());
        holder.tipo.setText(mCarrello.get(position).getTipoP());
        holder.prezzo.setText(mCarrello.get(position).getPrezzoP());
        holder.orac.setText(mCarrello.get(position).getOraC());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(c,mCarrello.get(position).getNomeP(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCarrello.size();
    }

}
