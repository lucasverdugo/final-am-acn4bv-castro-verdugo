package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
    }

    public void createUser(String user, String password){
        mAuth.createUserWithEmailAndPassword(user, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(getApplicationContext(), Noticias.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Registro.this, "Error al intentar el registro del usuario.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ErrorInicioSesion.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    public void registro(View view){
        EditText user = findViewById(R.id.usuario_registro_input);
        EditText password = findViewById(R.id.clave_registro_input);
        String usuario = user.getText().toString();
        String clave = password.getText().toString();
        this.createUser(usuario, clave);
    }

    public void irAInicioSesion(View view){
        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    }
}