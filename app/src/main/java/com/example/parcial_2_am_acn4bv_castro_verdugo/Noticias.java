package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Noticias extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        Toast t1 = new Toast(this);
        t1.setText("Bienvenido a Ensobrad2: " + nombreUsuario + " !!!!!");
        t1.show();
    }
    public void cerrarSesion(View view){
        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    }
}