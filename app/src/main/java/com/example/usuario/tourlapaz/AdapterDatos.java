package com.example.usuario.tourlapaz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.LugarViewholder> {
    List<Lugares> dataset;
    Context context;
    onLugarSelectedListener onLugarSelectedListener;

    public interface onLugarSelectedListener{

        void onLugarSelected(Lugares lugar);
    }
    public AdapterDatos(Context context, onLugarSelectedListener onLugarSelectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onLugarSelectedListener = onLugarSelectedListener;
    }

    @Override
    public LugarViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);
        return new LugarViewholder(view);
    }

    @Override
    public void onBindViewHolder(LugarViewholder holder, int position) {
        Lugares lugar = dataset.get(position);
        holder.nombre.setText(lugar.getNombre());
        holder.imagen.setImageResource(lugar.getFoto());

        holder.setOnLugarSelectedListener(lugar, onLugarSelectedListener);

    }

    @Override
    public int getItemCount() {return dataset.size();}

    public class LugarViewholder extends RecyclerView.ViewHolder {
        View cardView;
        ImageView imagen;
        TextView nombre;

        public LugarViewholder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.texto_item);
        }
        public void setOnLugarSelectedListener(final Lugares lugar, final onLugarSelectedListener onLugarSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onLugarSelectedListener.onLugarSelected(lugar);
                }
            });
        }

    }

    public void setDataset(List<Lugares> lugar) {
        if (lugar == null){
            dataset = new ArrayList<>();
        }
        else{
            dataset = lugar;
        }
        notifyDataSetChanged();
    }
}
