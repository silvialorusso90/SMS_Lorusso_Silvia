package com.example.sms_lorusso_silvia.mMySQL;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mDataObject.Piatti;

public class Adapter_Ordina_Pi extends RecyclerView.Adapter<MyHolder_o_i_p>{

    String url="http://spacecrafts.altervista.org/ScritturaDati/scrivi_carrello.php";

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

        //INITIALIZZA
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder_o_i_p onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.m_piatti, viewGroup, false);
        return new MyHolder_o_i_p(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder_o_i_p holder, final int position) {
        holder.nomeTxt.setText(mPiatti.get(position).getNome());
        holder.tipoTxt.setText(mPiatti.get(position).getTipo());
        holder.prezzoTxt.setText(mPiatti.get(position).getPrezzo());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                PopupMenu popupMenu = new PopupMenu(c, holder.nomeTxt);
                popupMenu.inflate(R.menu.aggiungi_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Sender_o_i_p s=new Sender_o_i_p(c, url, mTel, mPiatti.get(position).getNome(), mPiatti.get(position).getTipo(), mPiatti.get(position).getPrezzo(), mOrac);
                        s.execute();

                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mPiatti.size();
    }
}
