package com.example.drivus.fragments.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drivus.ListAdapter;
import com.example.drivus.R;
import com.example.drivus.elementos_listas_carros;

import java.util.ArrayList;
import java.util.List;


public class AutosRecomendadosFragment extends Fragment {
    List<elementos_listas_carros> elementos_carros;

    public AutosRecomendadosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_autos_recomendados, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_autos_recomendados);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AutosRecomendadosFragment.super.getContext());

        init(recyclerView);
        return view;
    }

    public void init(RecyclerView v) {
        elementos_carros = new ArrayList<>();
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));
        elementos_carros.add(new elementos_listas_carros("Toyota", "toyota","$50000", "2009", "15000KM/H", "gasolina", "automatico", ".", ".", "."));

        ListAdapter listAdapter = new ListAdapter(elementos_carros, AutosRecomendadosFragment.super.getContext());
        v.setHasFixedSize(true);
        v.setLayoutManager(new LinearLayoutManager(AutosRecomendadosFragment.super.getContext()));
        v.setAdapter(listAdapter);

    }
}