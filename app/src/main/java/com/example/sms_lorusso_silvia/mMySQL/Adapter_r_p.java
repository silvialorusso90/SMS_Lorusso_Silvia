package com.example.sms_lorusso_silvia.mMySQL;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.sms_lorusso_silvia.DetailActivity;
import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mDataObject.Piatti;

public class Adapter_r_p extends RecyclerView.Adapter<MyHolder_r_p>{

    String  url="http://spacecrafts.altervista.org/ScritturaDati/elimina_piatto.php";

    Context c;
    ArrayList<Piatti> mPiatti;
    LayoutInflater inflater;

    public Adapter_r_p(Context c, ArrayList<Piatti> mPiatti) {
        this.c = c;
        this.mPiatti = mPiatti;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyHolder_r_p onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.m_piatti, viewGroup, false);
        return new MyHolder_r_p(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder_r_p holder, final int position) {

        holder.nome.setText(mPiatti.get(position).getNome());
        holder.tipo.setText(mPiatti.get(position).getTipo());
        holder.prezzo.setText(mPiatti.get(position).getPrezzo());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {

                PopupMenu popupMenu = new PopupMenu(c, holder.nome);
                popupMenu.inflate(R.menu.options_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String nome = mPiatti.get(position).getNome();

                        //FAR PARTIRE DA QUI LA RIMOZIONE DEL PIATTO DAL DATABASE
                        final String urll = url+"?Nome="+nome;

                        Sender_r_pi s=new Sender_r_pi(c, urll, nome);
                        s.execute();

                        return false;
                    }
                });
                popupMenu.show();

                //openPiattoActivity(mPiatti.get(position).getNome(), mPiatti.get(position).getTipo(), mPiatti.get(position).getPrezzo());
            }
        });


    }

    @Override
    public int getItemCount() {
        return mPiatti.size();
    }

    /*
    private void openPiattoActivity(String nomeP, String tipoP, String prezzoP){
        Intent i = new Intent(c, DetailActivity.class);

        //PACK DATA
        i.putExtra("Nome", nomeP);
        i.putExtra("Tipo", tipoP);
        i.putExtra("Prezzo", prezzoP);

        //OPEN ACTIVITY
        c.startActivity(i);
    }
    */

}
