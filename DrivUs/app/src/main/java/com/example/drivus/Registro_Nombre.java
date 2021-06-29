package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class Registro_Nombre extends AppCompatActivity implements View.OnClickListener{

    TextInputLayout editUsrName, editUsrApellidoP, editUsrApellidoM, editUsrDate, editUsrAddCalle, editUsrAddNum, editUsrAddCol, editUsrAddCP, editUsrPhone;
    TextInputEditText editCalendario_calendario;
    RadioButton radioMujer, radioHombre;
    MaterialButton btnSiguiente;

    private int dias,mes,ano;
    String genero_usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_nombre);

        editUsrName = (TextInputLayout) findViewById(R.id.editUsername);
        editUsrApellidoP = (TextInputLayout) findViewById(R.id.editUserApellidoP);
        editUsrApellidoM = (TextInputLayout) findViewById(R.id.editUserApellidoM);
        editUsrDate = (TextInputLayout) findViewById(R.id.editCalendario);
        editCalendario_calendario = (TextInputEditText) findViewById(R.id.editCalendario_calendario);
        editUsrAddCalle = (TextInputLayout) findViewById(R.id.editCalle);
        editUsrAddNum = (TextInputLayout) findViewById(R.id.editNumCasa);
        editUsrAddCol = (TextInputLayout) findViewById(R.id.editColonia);
        editUsrAddCP = (TextInputLayout) findViewById(R.id.editNumCP);
        editUsrPhone = (TextInputLayout) findViewById(R.id.editTelefono);
        radioMujer = (RadioButton) findViewById(R.id.rbmujer);
        radioHombre = (RadioButton) findViewById(R.id.rbhombre);
        btnSiguiente = (MaterialButton) findViewById(R.id.btnNext);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        editCalendario_calendario.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);

    }
    private void almacenar_datos(){
        if(radioMujer.isChecked()){
            genero_usr ="hombre";
        } else if(radioHombre.isChecked()){
            genero_usr = "mujer";
        }
        String nombre_usr = editUsrName.getEditText().getText().toString().trim();
        String apellidop_usr = editUsrApellidoP.getEditText().getText().toString().trim();
        String apellidom_usr = editUsrApellidoM.getEditText().getText().toString().trim();
        String fecha_usr = editUsrDate.getEditText().getText().toString().trim();
        String calle_usr = editUsrAddCalle.getEditText().getText().toString().trim();
        String numCasa_usr = editUsrAddNum.getEditText().getText().toString().trim();
        String col_usr = editUsrAddCol.getEditText().getText().toString().trim();
        String cp_usr = editUsrAddCP.getEditText().getText().toString().trim();
        String phone_usr = editUsrPhone.getEditText().getText().toString().trim();

        if(nombre_usr.isEmpty()){
            editUsrName.setError("Ingrese nombre(s)");
        }else if (apellidop_usr.isEmpty()){
            editUsrApellidoP.setError("Ingrese Apellido Paterno");
        }else if (apellidom_usr.isEmpty()){
            editUsrApellidoM.setError("Ingrese Apellido Materno");
        }else if (fecha_usr.isEmpty()){
            editUsrDate.setError("Ingrese Fecha");
        }else if(calle_usr.isEmpty()){
            editUsrAddCalle.setError("Ingrese Calle");
        }else if(numCasa_usr.isEmpty()){
            editUsrAddNum.setError("Ingrese Calle");
        }else if(col_usr.isEmpty()){
            editUsrAddCol.setError("Ingrese Calle");
        }else if(cp_usr.isEmpty()){
            editUsrAddCP.setError("Ingrese Calle");
        }else if(phone_usr.isEmpty()){
            editUsrPhone.setError("Ingrese Calle");
        }else{
            Intent email = new Intent(Registro_Nombre.this,RegistroFinalUsuarioEmail.class);
            email.putExtra("nombre(s)_user",nombre_usr);
            email.putExtra("apellidop_user",apellidop_usr);
            email.putExtra("apellidom_user",apellidom_usr);
            email.putExtra("fecha_user",fecha_usr);
            email.putExtra("calle_user",calle_usr);
            email.putExtra("numCasa_user",numCasa_usr);
            email.putExtra("col_user",col_usr);
            email.putExtra("cp_user",cp_usr);
            email.putExtra("phone_user",phone_usr);
            email.putExtra("genero_user",genero_usr);
            startActivity(email);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editCalendario_calendario:
                final Calendar c= Calendar.getInstance();
                ano = c.get(Calendar.YEAR);
                dias = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Registro_Nombre.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editUsrDate.getEditText().setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },ano,mes,dias);
                datePickerDialog.show();

            break;
            case R.id.btnNext:
                almacenar_datos();
                break;
        }
    }
}