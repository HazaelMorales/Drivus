package com.example.drivus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.drivus.R;
import com.example.drivus.fragments.Autos_Rentados.RentasAutosFragment;
import com.example.drivus.fragments.home.HomeAutosFragment;
import com.example.drivus.fragments.perfil.PerfilAutosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Inicio_Prueba extends AppCompatActivity {

    Toolbar toolbar_main;
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio__prueba);

        toolbar_main = (Toolbar) findViewById(R.id.toolbar_inicio);
        navView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_inicio);

        setSupportActionBar(toolbar_main);
        navView.setItemIconTintList(null);
        navView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_inicio, new HomeAutosFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.homeAutosFragment:
                    selectedFragment = new HomeAutosFragment();
                    break;
                case R.id.rentasAutosFragment:
                    selectedFragment = new RentasAutosFragment();
                    break;
                case R.id.perfilAutosFragment:
                    selectedFragment = new PerfilAutosFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_inicio, selectedFragment).commit();
            return true;
        }
    };

}