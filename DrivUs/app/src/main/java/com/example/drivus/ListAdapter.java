package com.example.drivus;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.lang.annotation.Native;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    List<elementos_listas_carros> mData;
    RequestQueue request;
    Context context;

    public ListAdapter(List<elementos_listas_carros> listaCarros, Context context){
        this.mData = listaCarros;
        this.context = context;
        request = Volley.newRequestQueue(context);
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

        if(mData.get(position).getRutaImagen()!=null){
            //holder.imagenCarro.setImageBitmap(mData.get(position).getImagen());
            cargarImagenAuto(mData.get(position).getRutaImagen(),holder);
        }else{
            holder.imagenCarro.setImageResource(R.drawable.ic_photo_base);
        }
    }

    private void cargarImagenAuto(String rutaImagen, ListAdapter.ViewHolder holder){
        String urlImagen=""+rutaImagen;
        urlImagen = urlImagen.replace(" ","%20");

        ImageRequest imageRequest =new ImageRequest(urlImagen, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                holder.imagenCarro.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error al cargar la imagen",Toast.LENGTH_LONG).show();
            }
        });
        request.add(imageRequest);
    }

    public void setItems(List<elementos_listas_carros> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenCarro;
        TextView nombre,precio,año,combustible,cambios,kilometraje;
        Button btnDatosAuto;

        public ViewHolder(View itemView){
            super(itemView);
            imagenCarro = (ImageView) itemView.findViewById(R.id.imagen_auto);
            nombre = (TextView) itemView.findViewById(R.id.auto_nombre);
            precio =  (TextView) itemView.findViewById(R.id.auto_precio);
            año =  (TextView) itemView.findViewById(R.id.auto_año);
            combustible  = (TextView) itemView.findViewById(R.id.auto_combustible);
            cambios = (TextView) itemView.findViewById(R.id.auto_cambios);
            kilometraje = (TextView) itemView.findViewById(R.id.auto_kilometraje);
            btnDatosAuto = (Button) itemView.findViewById(R.id.button_rentar);
        }
    }
}
