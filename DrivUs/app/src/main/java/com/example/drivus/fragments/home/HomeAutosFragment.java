package com.example.drivus.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drivus.R;
import com.example.drivus.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;


public class HomeAutosFragment extends Fragment {

    ViewPagerAdapter MyAdapter;
    ViewPager2 viewPager2;

    public HomeAutosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Colocar Codigo de funcionalidad aqui.

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_autos, container, false);

        viewPager2 = view.findViewById(R.id.viewpager2_inicio);

        MyAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), getLifecycle());

        //Fragmentos a los que mandamos a llamar(AGREGAMOS FRAGMENTOS.).
        MyAdapter.addFragment(new TodosAutosFragment());
        MyAdapter.addFragment(new MasRentadosFragment());
        MyAdapter.addFragment(new AutosRecomendadosFragment());

        viewPager2.setAdapter(MyAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tablalayout_inicio);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Todos");
                        break;
                    case 1:
                        tab.setText("Mas Rentados");
                        break;
                    case 2:
                        tab.setText("Recomendados");
                        break;
                }
            }
        }).attach();
        return view;
    }
}