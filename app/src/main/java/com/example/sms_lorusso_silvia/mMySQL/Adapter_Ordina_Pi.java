package com.example.sms_lorusso_silvia.mMySQL;

import android.content.Context;
import android.support.annotation.NonNull;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.FrameLayout;

import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mDataObject.Piatti;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class Adapter_Ordina_Pi extends RecyclerView.Adapter<MyHolder_o_i_p>{

    Context c;
    ArrayList<Piatti> mPiatti;
    LayoutInflater inflater;
    String mTel;
    String mOrac;

    public Adapter_Ordina_Pi(Context c, ArrayList<Piatti> piatti, String tel, String orac) {

        this.c = c;
        this.mPiatti = piatti;
        this.mTel = tel;
        this.mOrac = orac;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder_o_i_p onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.m_piatti, viewGroup, false);
        return new MyHolder_o_i_p(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder_o_i_p holder, final int position) {
        holder.nomeTxt.setText(mPiatti.get(position).getNome());
        holder.tipoTxt.setText(mPiatti.get(position).getTipo());
        holder.prezzoTxt.setText(mPiatti.get(position).getPrezzo());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(c,mPiatti.get(position).getNome(),Toast.LENGTH_SHORT).show();

                String url="http://spacecrafts.altervista.org/ScritturaDati/scrivi_carrello.php";

                Sender_o_i_p s=new Sender_o_i_p(c, url, mTel, mPiatti.get(position).getNome(), mPiatti.get(position).getTipo(), mPiatti.get(position).getPrezzo(), mOrac);
                s.execute();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mPiatti.size();
    }
}
