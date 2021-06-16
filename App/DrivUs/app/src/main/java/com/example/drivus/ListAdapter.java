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
    private List<elementos_listas_carros> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<elementos_listas_carros> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.elementos_listas_carros, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }
    public void setItems(List<elementos_listas_carros> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenCarro;
        TextView nombre,precio,año,combustible,cambios,kilometraje;

        ViewHolder(View itemView){
            super(itemView);
            imagenCarro = itemView.findViewById(R.id.imagen_auto);
            nombre = itemView.findViewById(R.id.auto_nombre);
            precio = itemView.findViewById(R.id.auto_precio);
            año = itemView.findViewById(R.id.auto_año);
            combustible = itemView.findViewById(R.id.auto_combustible);
            cambios = itemView.findViewById(R.id.auto_cambios);
            kilometraje = itemView.findViewById(R.id.auto_kilometraje);
        }

        void bindData(final elementos_listas_carros item){
            nombre.setText(item.getNombre());
            precio.setText(item.getPrecio());
            año.setText(item.getAnioo());
            combustible.setText(item.getCombustible());
            cambios.setText(item.getCambios());
            kilometraje.setText(item.getKilometraje());
        }
    }
}
