package com.example.sms_lorusso_silvia.mMySQL;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.R;
import com.example.sms_lorusso_silvia.mDataObject.Carrello;

import java.util.ArrayList;

public class AdapterRiepilogo extends RecyclerView.Adapter<MyHolderRiepilogo>{

    String  url="http://spacecrafts.altervista.org/ScritturaDati/rimuovi_piatto_carrello.php";

    Context c;
    ArrayList<Carrello> mCarrello;
    LayoutInflater inflater;

    public AdapterRiepilogo(Context c, ArrayList<Carrello> carrello) {

        this.c = c;
        this.mCarrello = carrello;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolderRiepilogo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.m_ordine, viewGroup, false);
        return new MyHolderRiepilogo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolderRiepilogo holder, final int position) {
        holder.nomeTxt.setText(mCarrello.get(position).getNomeP());
        holder.tipoTxt.setText(mCarrello.get(position).getTipoP());
        holder.prezzoTxt.setText(mCarrello.get(position).getPrezzoP());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(final int pos) {

                //Display option menu
                PopupMenu popupMenu = new PopupMenu(c, holder.nomeTxt);
                popupMenu.inflate(R.menu.options_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String tel = mCarrello.get(position).getTelefono();
                        String nome = mCarrello.get(position).getNomeP();

                        //FAR PARTIRE DA QUI LA RIMOZIONE DEL PIATTO DAL DATABASE
                        //final String urll = url+"?Telefono="+tel+"&Piatto="+nome;
                        final String urll = url+"?Telefono="+tel+"&Piatto="+nome;
                        Toast.makeText(c, urll, Toast.LENGTH_LONG).show();

                        Sender_r_o s=new Sender_r_o(c, urll);
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
        return mCarrello.size();
    }
}
