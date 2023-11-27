package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Noticias extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        mAuth = FirebaseAuth.getInstance();
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        Toast t1 = new Toast(this);
        t1.setText("Bienvenido a Ensobrad2: " + mAuth.getCurrentUser().getEmail() + " !!!!!");
        t1.show();
    }
    public void cerrarSesion(View view){

        mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}