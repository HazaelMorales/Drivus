package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro_Direccion extends AppCompatActivity {
    EditText etCalle, etNumCasa, etColonia, etCodigoPostal;
    Button bnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__direccion);

        etCalle = (EditText) findViewById(R.id.editCalle);
        etNumCasa = (EditText) findViewById(R.id.editNumCasa);
        etColonia = (EditText) findViewById(R.id.editColonia);
        etCodigoPostal = (EditText) findViewById(R.id.editCodigoPostal);
        bnSiguiente = (Button) findViewById(R.id.btnNext);

        bnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calle_user = etCalle.getText().toString().trim();
                String numCasa_user = etNumCasa.getText().toString().trim();
                String colonia_user = etColonia.getText().toString().trim();
                String cp_user = etCodigoPostal.getText().toString().trim();

                if(calle_user.isEmpty()){
                    etCalle.setError("Ingrese el dato correspondiente.");
                }else if(numCasa_user.isEmpty()){
                    etNumCasa.setError("Ingrese el dato correspondiente.");
                } else if(colonia_user.isEmpty()){
                    etColonia.setError("Ingrese el dato correspondiente.");
                }else if(cp_user.isEmpty()){
                    etCodigoPostal.setError("Ingrese el dato correspondiente.");
                }else{
                    String nombre_usr = getIntent().getStringExtra("nombre(s)_usr_2");
                    String ApellidoP_usr = getIntent().getStringExtra("apellidoP_usr_2");
                    String ApellidoM_usr = getIntent().getStringExtra("apellidoM_usr_2");
                    String fecha_usr = getIntent().getStringExtra("fecha_usr_2");
                    String genero_usr = getIntent().getStringExtra("genero_usr_2");

                    Intent telefono_pestaña = new Intent(Registro_Direccion.this, Registro_Telefono.class);
                    telefono_pestaña.putExtra("nombre(s)_usr_3",nombre_usr);
                    telefono_pestaña.putExtra("apellidoP_usr_3",ApellidoP_usr);
                    telefono_pestaña.putExtra("apellidoM_usr_3",ApellidoM_usr);
                    telefono_pestaña.putExtra("fecha_usr_3",fecha_usr);
                    telefono_pestaña.putExtra("genero_usr_3",genero_usr);
                    telefono_pestaña.putExtra("calle_usr_3",calle_user);
                    telefono_pestaña.putExtra("numCasa_usr_3", numCasa_user);
                    telefono_pestaña.putExtra("colonia_usr_3",colonia_user);
                    telefono_pestaña.putExtra("cp_usr_3",cp_user);
                    startActivity(telefono_pestaña);
                }
            }
        });


    }
}