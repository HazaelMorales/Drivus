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

import java.util.HashMap;
import java.util.Map;

public class RegistroFinalUsuarioEmail extends AppCompatActivity {
    EditText etEmail, etPassword, etPasswordConfirm;
    Button bnConfirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_final_usuario_email);

        etEmail = (EditText) findViewById(R.id.editEmail);
        etPassword = (EditText) findViewById(R.id.editPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.editPasswordConfirm);
        bnConfirmar = (Button) findViewById(R.id.btnEnviar);

        bnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar_datos("http://192.168.1.74/drivus_app_php/registro_ususariosp.php");
            }
        });
    }
    private void ingresar_datos(String URL) {
        String etUser_Email = etEmail.getText().toString().trim();
        String etUser_password = etPassword.getText().toString().trim();
        String etUser_password_confirm = etPasswordConfirm.getText().toString().trim();

        if (etUser_Email.isEmpty()) {
            etEmail.setError("Ingresa Email");
        } else if (etUser_password.isEmpty()) {
            etPassword.setError("Ingresa Contraseña");
        } else if (etUser_password_confirm.isEmpty()) {
            etPasswordConfirm.setError("Compruebe Contraseña");
        } else {
            if (etUser_password.equals(etUser_password_confirm)) {
                String nombre_user = getIntent().getStringExtra("nombre(s)_usr_4");
                String ApellidoP_user = getIntent().getStringExtra("apellidoP_usr_4");
                String ApellidoM_user = getIntent().getStringExtra("apellidoM_usr_4");
                String fecha_user = getIntent().getStringExtra("fecha_usr_4");
                String genero_user = getIntent().getStringExtra("genero_usr_4");
                String calle_user = getIntent().getStringExtra("calle_usr_4");
                String numCasa_user = getIntent().getStringExtra("numCasa_usr_4");
                String colonia_user = getIntent().getStringExtra("colonia_usr_4");
                String cp_user = getIntent().getStringExtra("cp_usr_4");
                String telefono_user = getIntent().getStringExtra("tel_usr_4");

                StringRequest respuesta = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("1")){
                            Intent i = new Intent(RegistroFinalUsuarioEmail.this, Inicio_Prueba.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(RegistroFinalUsuarioEmail.this,"eror al registrarse",Toast.LENGTH_SHORT).show();
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
                        parametros.put("apellidop", ApellidoP_user);
                        parametros.put("apellidom", ApellidoM_user);
                        parametros.put("fecha_nac", fecha_user);
                        parametros.put("genero", genero_user);
                        parametros.put("calle",calle_user);
                        parametros.put("num_casa",numCasa_user);
                        parametros.put("colonia",colonia_user);
                        parametros.put("cpostal",cp_user);
                        parametros.put("telefono", telefono_user);
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