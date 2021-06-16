package com.example.drivus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.annotation.Native;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    List<elementos_listas_carros> mData;

    public ListAdapter(List<elementos_listas_carros> listaCarros){
        this.mData = listaCarros;
    }


    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_listas_carros,parent, false );
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.nombre.setText(mData.get(position).getNombre());
        holder.precio.setText(mData.get(position).getPrecio());
        holder.año.setText(mData.get(position).getAnioo());
        holder.combustible.setText(mData.get(position).getCombustible());
        holder.cambios.setText(mData.get(position).getCambios());
        holder.kilometraje.setText(mData.get(position).getKilometraje());

        if(mData.get(position).getImagen()!=null){
            holder.imagenCarro.setImageBitmap(mData.get(position).getImagen());
        }else{
            holder.imagenCarro.setImageResource(R.drawable.home_selector);
        }
    }
    public void setItems(List<elementos_listas_carros> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenCarro;
        TextView nombre,precio,año,combustible,cambios,kilometraje;

        public ViewHolder(View itemView){
            super(itemView);
            imagenCarro = (ImageView) itemView.findViewById(R.id.imagen_auto);
            nombre = (TextView) itemView.findViewById(R.id.auto_nombre);
            precio =  (TextView) itemView.findViewById(R.id.auto_precio);
            año =  (TextView) itemView.findViewById(R.id.auto_año);
            combustible  = (TextView) itemView.findViewById(R.id.auto_combustible);
            cambios = (TextView) itemView.findViewById(R.id.auto_cambios);
            kilometraje = (TextView) itemView.findViewById(R.id.auto_kilometraje);
        }
    }
}
