package com.example.drivus.fragments.home;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drivus.ListAdapter;
import com.example.drivus.R;
import com.example.drivus.elementos_listas_carros;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TodosAutosFragment extends Fragment implements Response.ErrorListener, Response.Listener<JSONObject> {
    RecyclerView recyclerViewTodosAutos;
    List<elementos_listas_carros> elementos_carros;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    ProgressDialog progress;



    public TodosAutosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todos_autos, container, false);

        elementos_carros = new ArrayList<>();

        recyclerViewTodosAutos = view.findViewById(R.id.recycler_autos);
        recyclerViewTodosAutos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewTodosAutos.setHasFixedSize(true);

        requestQueue = Volley.newRequestQueue(getContext());

        cargarCarros();

        return view;
    }

    private void cargarCarros(){
        progress = new ProgressDialog(getContext());
        progress.setMessage("Consultando...");
        progress.show();

        String url = "http://192.168.1.74/drivus_app_php/mostrar_vehiculos.php";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);

        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error){
        Toast.makeText(getContext(),"No se puede contectar"+error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("Error: ", error.toString());
        progress.hide();
    }

    @Override
    public void onResponse(JSONObject response) {
        elementos_listas_carros autos = null;

        JSONArray json_array = response.optJSONArray("vehiculos");

        try {
            for (int i=0; i<json_array.length();i++){
                autos = new elementos_listas_carros();
                JSONObject jsonObject=null;
                jsonObject = json_array.getJSONObject(i);

                autos.setId(jsonObject.optString("id"));
                autos.setNombre(jsonObject.optString("modelo"));
                autos.setMarca(jsonObject.optString("marca"));
                autos.setColor(jsonObject.optString("color"));
                autos.setPlacas(jsonObject.optString("placas"));
                autos.setAnioo(jsonObject.optString("año"));
                autos.setKilometraje(jsonObject.optString("velocidad")+"Km/h");
                autos.setPrecio("$"+ jsonObject.optString("precio"));
                autos.setDato(jsonObject.optString("imagen"));
                elementos_carros.add(autos);
            }
            progress.hide();
            ListAdapter adapter = new ListAdapter(elementos_carros);
            recyclerViewTodosAutos.setAdapter(adapter);

        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(TodosAutosFragment.super.getContext(), "No se ha podido establecer conexion con el servidor" + " " + response, Toast.LENGTH_LONG).show();
            progress.hide();
        }
    }
}