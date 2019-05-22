package com.example.sms_lorusso_silvia.mMySQL;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mDataObject.Piatti;

public class Adapter_v_m extends RecyclerView.Adapter<MyHolder_v_m>{

    Context c;
    ArrayList<Piatti> mPiatti;
    LayoutInflater inflater;

    public Adapter_v_m(Context c, ArrayList<Piatti> piatti) {
        this.c = c;
        this.mPiatti = piatti;

        //INITIALIZZA
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyHolder_v_m onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.m_piatti, viewGroup, false);
        return new MyHolder_v_m(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder_v_m holder, final int position) {

        holder.nome.setText(mPiatti.get(position).getNome());
        holder.tipo.setText(mPiatti.get(position).getTipo());
        holder.prezzo.setText(mPiatti.get(position).getPrezzo());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                //Toast.makeText(c,mPiatti.get(position).getNome(),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mPiatti.size();
    }


}
