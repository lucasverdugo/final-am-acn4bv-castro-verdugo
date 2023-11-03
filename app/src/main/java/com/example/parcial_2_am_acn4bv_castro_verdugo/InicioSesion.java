package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }
    public void irANoticias(View view){
        Controlador c1 = new Controlador();
        List<Usuario> u1 = c1.listarUsuarios();
        EditText editText1 = findViewById(R.id.editTextText);
        String usuario = editText1.getText().toString();
        EditText editText2 = findViewById(R.id.editTextText2);
        String password = editText2.getText().toString();
        String nombreUsuario = null;
        boolean autenticacionOK = false;

        for (Usuario u : u1) {
            if(u.getUsuario().equals(usuario) && u.getPassword().equals(password)){
                autenticacionOK = true;
                nombreUsuario = u.getNombre();
            }
        }
        if(autenticacionOK){
            Intent intent = new Intent(this, Noticias.class);
            intent.putExtra("nombreUsuario", nombreUsuario);
            startActivity(intent);
        }
        else {
            Toast t1 = new Toast(this);
            t1.setText("Usuario y contraseñas incorrectos.");
            t1.show();
        }

    }

    public void irARegistrarme(View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}