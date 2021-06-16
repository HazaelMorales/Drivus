package com.example.drivus.fragments.Autos_Rentados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drivus.ListAdapter_etiquetas;
import com.example.drivus.R;
import com.example.drivus.elementos_listas_carros;

import java.util.ArrayList;
import java.util.List;


public class RentasAutosFragment extends Fragment {
    List<elementos_listas_carros> elementos_carros;

    public RentasAutosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rentas_autos, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_rentas_autos);
        init(recyclerView);
        return view;
    }
    public void init(RecyclerView v) {
        elementos_carros = new ArrayList<>();

        ListAdapter_etiquetas listAdapter = new ListAdapter_etiquetas(elementos_carros, RentasAutosFragment.super.getContext());
        v.setHasFixedSize(true);
        v.setLayoutManager(new LinearLayoutManager(RentasAutosFragment.super.getContext()));
        v.setAdapter(listAdapter);
    }
}