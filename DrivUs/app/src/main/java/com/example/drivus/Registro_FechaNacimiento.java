package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Registro_FechaNacimiento extends AppCompatActivity implements View.OnClickListener {
    EditText etFecha;
    Button bnFecha, bnSiguiente;
    private int dias,mes,ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__fecha_nacimiento);

        etFecha = (EditText) findViewById(R.id.editFechaNacimiento);
        bnFecha = (Button) findViewById(R.id.btnFecha);
        bnSiguiente = (Button) findViewById(R.id.btnNext);

        etFecha.setFocusable(false);
        etFecha.setEnabled(false);

        bnFecha.setOnClickListener(this);
        bnSiguiente.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnFecha:
                final Calendar c= Calendar.getInstance();
                ano = c.get(Calendar.YEAR);
                dias = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Registro_FechaNacimiento.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etFecha.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                }
                        ,ano,mes,dias);
                datePickerDialog.show();
                break;

            case R.id.btnNext:
                String fecha = etFecha.getText().toString().trim();
                if(fecha.isEmpty()){
                    etFecha.setError("Seleccione Fecha.");
                }else{
                    String nombre_usr = getIntent().getStringExtra("nombre(s)_user");
                    String ApellidoP_usr = getIntent().getStringExtra("apellidoP_user");
                    String ApellidoM_usr = getIntent().getStringExtra("apellidoM_user");

                    Intent genero_activity = new Intent(Registro_FechaNacimiento.this,Registro_Genero.class);
                    genero_activity.putExtra("nombre(s)_usr_1",nombre_usr);
                    genero_activity.putExtra("apellidoP_usr_1",ApellidoP_usr);
                    genero_activity.putExtra("apellidoM_usr_1",ApellidoM_usr);
                    genero_activity.putExtra("fecha_usr_1",fecha);
                    startActivity(genero_activity);
                }
                break;
        }
    }
}