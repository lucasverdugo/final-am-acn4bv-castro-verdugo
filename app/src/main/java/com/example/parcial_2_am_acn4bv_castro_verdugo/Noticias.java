package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Noticias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
    }
    public void cerrarSesion(View view){
        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    }
}