package com.example.drivus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etLogin_Email, etLogin_Pass;
    Button btnLogin;
    TextView btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        etLogin_Email = (EditText) findViewById(R.id.editEmail);
        etLogin_Pass = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistrar = (TextView) findViewById(R.id.txtRegistrar);

        btnLogin.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    private void validar_usuarios(String URL){
        String User_Email = etLogin_Email.getText().toString().trim();
        String User_Pass = etLogin_Pass.getText().toString().trim();

        if(User_Email.isEmpty()){
            etLogin_Email.setError("Ingrese Correo");
        } else if(User_Pass.isEmpty()){
            etLogin_Pass.setError("Ingrese Contraseña");
        }else{
            StringRequest respuesta = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject login = new JSONObject(response);
                        String emailUser = login.getString("correo");
                        String passwordUser = login.getString("contraseña");
                        if (emailUser.equals(User_Email) && passwordUser.equals(User_Pass)) {
                            Intent inicio_activity = new Intent(LoginActivity.this, Inicio_Prueba.class);
                            startActivity(inicio_activity);
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("usr_correo", User_Email);
                    parametros.put("usr_password", User_Pass);
                    return parametros;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(respuesta);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                validar_usuarios("http://192.168.1.74/drivus_app_php/login.php");
                break;

            case R.id.txtRegistrar:
                Intent registro_activity = new Intent(LoginActivity.this, Registro_Nombre.class);
                startActivity(registro_activity);
                break;
        }
    }
}