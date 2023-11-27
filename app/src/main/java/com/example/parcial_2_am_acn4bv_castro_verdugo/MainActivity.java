package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    public void irAInicioSesion(View view){
        Intent intent = new Intent(getApplicationContext(), InicioSesion.class);
        startActivity(intent);

    }

    public void irARegistrarme(View view){
        Intent intent = new Intent(getApplicationContext(),Registro.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast t1 = new Toast(getApplicationContext());
            t1.setText("Bienvenido usuario: " + currentUser.getEmail());
            t1.show();
            Intent intent = new Intent(getApplicationContext(), Noticias.class);
            startActivity(intent);

        }
        else {
            Intent intent = new Intent(getApplicationContext(), InicioSesion.class);
            startActivity(intent);
        }
    }
}