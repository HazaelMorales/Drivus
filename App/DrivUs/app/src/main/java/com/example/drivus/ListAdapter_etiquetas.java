package com.example.drivus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ListAdapter_etiquetas extends RecyclerView.Adapter<ListAdapter_etiquetas.ViewHolder> {
    private List<elementos_listas_carros> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter_etiquetas(List<elementos_listas_carros> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public ListAdapter_etiquetas.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.elementos_listas_carros_etiquetas, null);
        return new ListAdapter_etiquetas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter_etiquetas.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<elementos_listas_carros> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenCarro;
        TextView nombre,marca,status,hora,fecha;

        ViewHolder(View itemView){
            super(itemView);
            imagenCarro = itemView.findViewById(R.id.auto_foto_etiqueta);
            nombre = itemView.findViewById(R.id.nombre_auto);
            marca = itemView.findViewById(R.id.marca_auto);
            status = itemView.findViewById(R.id.estatus_renta);
            hora = itemView.findViewById(R.id.hora_renta);
            fecha = itemView.findViewById(R.id.fecha_renta);

        }

        void bindData(final elementos_listas_carros item){
            nombre.setText(item.getNombre());
            marca.setText(item.getMarca());
            status.setText(item.getStatus());
            hora.setText(item.getHora());
            fecha.setText(item.getFecha());
        }
    }
}
