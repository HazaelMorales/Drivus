package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro_Nombre extends AppCompatActivity{
    EditText editUsrNames, editUsrLastNameP,editUsrLastNameM;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_nombre);

        editUsrNames = (EditText) findViewById(R.id.editUsername);
        editUsrLastNameP = (EditText) findViewById(R.id.editLastnameP);
        editUsrLastNameM = (EditText) findViewById(R.id.editLastnameM);
        btnSiguiente = (Button) findViewById(R.id.btnNext);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacenar_datos();
            }
        });

    }
    private void almacenar_datos(){
        String nombre_usr = editUsrNames.getText().toString().trim();
        String apellidoPaterno_usr = editUsrLastNameP.getText().toString().trim();
        String apellidoMaterno_usr = editUsrLastNameM.getText().toString().trim();

        if(nombre_usr.isEmpty()){
            editUsrNames.setError("Ingrese nombre(s)");
        }else if (apellidoPaterno_usr.isEmpty()){
            editUsrLastNameP.setError("Ingrese Apellido Paterno");
        }else if(apellidoMaterno_usr.isEmpty()){
            editUsrLastNameM.setError("Ingrese Apellido Materno");
        }else{
            Intent Fecha_Nac = new Intent(Registro_Nombre.this,Registro_FechaNacimiento.class);
            Fecha_Nac.putExtra("nombre(s)_user",nombre_usr);
            Fecha_Nac.putExtra("apellidoP_user",apellidoPaterno_usr);
            Fecha_Nac.putExtra("apellidoM_user",apellidoMaterno_usr);
            startActivity(Fecha_Nac);
        }
    }
}