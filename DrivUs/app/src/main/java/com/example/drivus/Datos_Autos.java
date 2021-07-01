package com.example.drivus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;


public class Datos_Autos extends Fragment {
    TextView txt_nombre_auto,txt_marca_auto,txt_precio_auto,txt_year_auto,txt_cambios_auto,txt_combustible_auto,txt_aire_auto,txt_puertas_auto,txt_velocidad_auto,txt_motor_auto,txt_asientos_auto,txt_bolsa_auto,txt_color_auto,txt_descripcion_auto;
    ImageView img_auto;
    RequestQueue request;
    Button btnRentar;
    public Datos_Autos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("info_autos", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull @NotNull String requestKey, @NonNull @NotNull Bundle bundle) {
                String id_Auto = bundle.getString("id_auto");
                String nombre_Auto = bundle.getString("nombre_auto");
                String marca_Auto = bundle.getString("marca_auto");
                String precio_Auto = bundle.getString("precio_auto");
                String url_imagen_Auto = bundle.getString("url_auto");
                String year_Auto = bundle.getString("year_auto");
                String cambios_Auto = bundle.getString("cambios_auto");
                String combustible_Auto = bundle.getString("combustible_auto");
                String aire_Auto = bundle.getString("aire_auto");
                String puertas_Auto = bundle.getString("puertas_auto");
                String velocidad_Auto = bundle.getString("velocidad_auto");
                String motor_Auto = bundle.getString("motor_auto");
                String asientos_Auto = bundle.getString("asientos_auto");
                String bolsa_Auto = bundle.getString("bolsa_auto");
                String color_Auto = bundle.getString("color_auto");
                String descripcion_auto = bundle.getString("descripcion_auto");

                txt_nombre_auto.setText(nombre_Auto);
                txt_marca_auto.setText(marca_Auto);
                txt_precio_auto.setText(precio_Auto);
                txt_year_auto.setText(year_Auto);
                txt_cambios_auto.setText(cambios_Auto);
                txt_combustible_auto.setText(combustible_Auto);
                txt_aire_auto.setText(aire_Auto);
                txt_puertas_auto.setText(puertas_Auto);
                txt_velocidad_auto.setText(velocidad_Auto);
                txt_motor_auto.setText(motor_Auto);
                txt_asientos_auto.setText(asientos_Auto);
                txt_bolsa_auto.setText(bolsa_Auto);
                txt_color_auto.setText(color_Auto);
                txt_descripcion_auto.setText(descripcion_auto);

                request = Volley.newRequestQueue(getContext());
                if(url_imagen_Auto!=null){
                    //holder.imagenCarro.setImageBitmap(mData.get(position).getImagen());
                    cargarImagenAuto(url_imagen_Auto);
                }else{
                    img_auto.setImageResource(R.drawable.ic_photo_base);
                }

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_datos__autos, container, false);

        btnRentar = (Button) view.findViewById(R.id.button_rentar);
        btnRentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), renta_auto_licencia.class);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt_nombre_auto = view.findViewById(R.id.auto_nombre);
        txt_marca_auto = view.findViewById(R.id.auto_marca);
        txt_precio_auto = view.findViewById(R.id.auto_precio);
        txt_year_auto = view.findViewById(R.id.auto_año);
        txt_cambios_auto = view.findViewById(R.id.auto_cambios);
        txt_combustible_auto = view.findViewById(R.id.auto_combustible);
        txt_aire_auto = view.findViewById(R.id.auto_aire_acondicionado);
        txt_puertas_auto = view.findViewById(R.id.auto_puertas);
        txt_velocidad_auto = view.findViewById(R.id.auto_kilometraje);
        txt_motor_auto = view.findViewById(R.id.auto_motor);
        txt_asientos_auto = view.findViewById(R.id.auto_asientos);
        txt_bolsa_auto = view.findViewById(R.id.auto_bolsa_aire);
        txt_color_auto = view.findViewById(R.id.auto_color);
        txt_descripcion_auto = view.findViewById(R.id.auto_descripcion);
        img_auto = view.findViewById(R.id.imagen_auto_2);
    }

    private void cargarImagenAuto(String rutaImagen){
        String urlImagen=""+rutaImagen;
        urlImagen = urlImagen.replace(" ","%20");

        ImageRequest imageRequest =new ImageRequest(urlImagen, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                img_auto.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Error al cargar la imagen",Toast.LENGTH_LONG).show();
            }
        });
        request.add(imageRequest);
    }
}