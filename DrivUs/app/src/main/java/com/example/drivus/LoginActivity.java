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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout etLogin_Email, etLogin_Pass;
    MaterialButton bnLogin, bnSignUp;
    String new_passwordUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        etLogin_Email = (TextInputLayout) findViewById(R.id.editEmail);
        etLogin_Pass = (TextInputLayout) findViewById(R.id.editPassword);
        bnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        bnSignUp = (MaterialButton) findViewById(R.id.btnSignUp);

        bnLogin.setOnClickListener(this);
        bnSignUp.setOnClickListener(this);
    }

    private void validar_usuarios(String URL){
        String User_Email = etLogin_Email.getEditText().getText().toString().trim();
        String User_Pass = etLogin_Pass.getEditText().getText().toString().trim();

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
                        String emailUser = login.getString("email");
                        String passwordUser = login.getString("password");
                        try {
                            MessageDigest digest = MessageDigest.getInstance("SHA-1");
                            digest.reset();
                            digest.update(User_Pass.getBytes("utf8"));
                            new_passwordUser = String.format("%040x", new BigInteger(1, digest.digest()));
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        if (emailUser.equals(User_Email) && passwordUser.equals(new_passwordUser)) {
                            Intent inicio_activity = new Intent(LoginActivity.this, Inicio_Prueba.class);
                            startActivity(inicio_activity);
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        Toast.makeText(LoginActivity.this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
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
                validar_usuarios("https://drivussystem.000webhostapp.com/drivus_php_app/login.php");
                break;

            case R.id.btnSignUp:
                Intent registro_activity = new Intent(LoginActivity.this, Registro_Nombre.class);
                startActivity(registro_activity);
                break;
        }
    }
}