package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
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
            String uid = currentUser.getUid();
            db.collection("users")
                    .whereEqualTo("uidAuth",uid)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot document: task.getResult()){
                                    String nombre = document.getString("nombre");
                                    Toast.makeText(getApplicationContext(), "Bienvenido: " + nombre, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Noticias.class);
                                    intent.putExtra("nombreUsuario", nombre);
                                    startActivity(intent);
                                }
                            }
                        }
                    });
        }
        else {
            Intent intent = new Intent(getApplicationContext(), InicioSesion.class);
            startActivity(intent);
        }
    }
}