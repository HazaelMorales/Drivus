package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class RegistroFinalUsuarioEmail extends AppCompatActivity {
    TextInputLayout editUsrEmail, editUsrPassword, editUsrPasswordConfirm;
    MaterialButton bnConfirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_final_usuario_email);

        editUsrEmail = (TextInputLayout) findViewById(R.id.editEmail);
        editUsrPassword = (TextInputLayout) findViewById(R.id.editPassword);
        editUsrPasswordConfirm = (TextInputLayout) findViewById(R.id.editPasswordConfirm);
        bnConfirmar = (MaterialButton) findViewById(R.id.btnConfirm);

        bnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar_datos("https://drivussystem.000webhostapp.com/drivus_php_app/registro_usuarios.php");
            }
        });
    }
    private void ingresar_datos(String URL) {
        String etUser_Email = editUsrEmail.getEditText().getText().toString().trim();
        String etUser_password = editUsrPassword.getEditText().getText().toString().trim();
        String etUser_password_confirm = editUsrPasswordConfirm.getEditText().getText().toString().trim();

        if (etUser_Email.isEmpty()) {
            editUsrEmail.setError("Ingresa Email");
        } else if (etUser_password.isEmpty()) {
            editUsrPassword.setError("Ingresa Contraseña");
        } else if (etUser_password_confirm.isEmpty()){
            editUsrPasswordConfirm.setError("Compruebe Contraseña");
        } else {
            if (etUser_password.equals(etUser_password_confirm)) {
                String nombre_user = getIntent().getStringExtra("nombre(s)_user");
                String apellidop_user = getIntent().getStringExtra("apellidop_user");
                String apellidom_user = getIntent().getStringExtra("apellidom_user");
                String fecha_user = getIntent().getStringExtra("fecha_user");
                String calle_user = getIntent().getStringExtra("calle_user");
                String numCasa_user = getIntent().getStringExtra("numCasa_user");
                String col_user = getIntent().getStringExtra("col_user");
                String cp_user = getIntent().getStringExtra("cp_user");
                String phone_user = getIntent().getStringExtra("phone_user");
                String genero_user = getIntent().getStringExtra("genero_user");



                StringRequest respuesta = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("1")){
                            Intent i = new Intent(RegistroFinalUsuarioEmail.this, Inicio_Prueba.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(RegistroFinalUsuarioEmail.this,"Error al ingresar",Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistroFinalUsuarioEmail.this, "Error al conectar con el servidor", Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parametros = new HashMap<String, String>();
                        parametros.put("nombre", nombre_user);
                        parametros.put("ApellidoP", apellidop_user);
                        parametros.put("ApellidoM", apellidom_user);
                        parametros.put("fecha_nac", fecha_user);
                        parametros.put("calle",calle_user);
                        parametros.put("num_casa",numCasa_user);
                        parametros.put("colonia",col_user);
                        parametros.put("cpostal",cp_user);
                        parametros.put("telefono", phone_user);
                        parametros.put("genero", genero_user);
                        parametros.put("correo", etUser_Email);
                        parametros.put("contraseña", etUser_password);
                        return parametros;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(respuesta);
            } else {
                Toast.makeText(RegistroFinalUsuarioEmail.this, "No coincide las contraseñas", Toast.LENGTH_LONG).show();
            }
        }
    }
}