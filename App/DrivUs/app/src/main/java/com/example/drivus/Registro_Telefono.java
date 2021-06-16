package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.toolbox.StringRequest;

public class Registro_Telefono extends AppCompatActivity {
    EditText etTel_user;
    Button btnSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_telefono);

        etTel_user = (EditText) findViewById(R.id.editTelefono);
        btnSiguiente = (Button) findViewById(R.id.btnNext);



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviando_datos();
            }
        });
    }
    private void enviando_datos(){
        String tel_user = etTel_user.getText().toString().trim();

        if(tel_user.isEmpty()){
            etTel_user.setError("Ingrese Telefono");
        } else{
            String nombre_user = getIntent().getStringExtra("nombre(s)_usr_3");
            String ApellidoP_user = getIntent().getStringExtra("apellidoP_usr_3");
            String ApellidoM_user = getIntent().getStringExtra("apellidoM_usr_3");
            String fecha_user = getIntent().getStringExtra("fecha_usr_3");
            String genero_user = getIntent().getStringExtra("genero_usr_3");
            String calle_user = getIntent().getStringExtra("calle_usr_3");
            String numCasa_user = getIntent().getStringExtra("numCasa_usr_3");
            String colonia_user = getIntent().getStringExtra("colonia_usr_3");
            String cp_user = getIntent().getStringExtra("cp_usr_3");

            Intent email_pestaña = new Intent(Registro_Telefono.this, RegistroFinalUsuarioEmail.class);
            email_pestaña.putExtra("nombre(s)_usr_4",nombre_user);
            email_pestaña.putExtra("apellidoP_usr_4",ApellidoP_user);
            email_pestaña.putExtra("apellidoM_usr_4",ApellidoM_user);
            email_pestaña.putExtra("fecha_usr_4",fecha_user);
            email_pestaña.putExtra("genero_usr_4",genero_user);
            email_pestaña.putExtra("calle_usr_4",calle_user);
            email_pestaña.putExtra("numCasa_usr_4",numCasa_user);
            email_pestaña.putExtra("colonia_usr_4",colonia_user);
            email_pestaña.putExtra("cp_usr_4",cp_user);
            email_pestaña.putExtra("tel_usr_4",tel_user);
            startActivity(email_pestaña);
        }
    }
}