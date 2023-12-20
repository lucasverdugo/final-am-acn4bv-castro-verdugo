package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class InicioSesion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }
    public void login(String user, String password){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            mAuth.signInWithEmailAndPassword(user, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                String uid = mAuth.getCurrentUser().getUid();
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
                            }else{
                                Toast.makeText(InicioSesion.this, "El inicio de sesión fallo. Usuario y contraseña incorrecto.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ErrorInicioSesion.class);
                                startActivity(intent);
                            }
                        }
                    });
        }
        else {
            Toast.makeText(InicioSesion.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }

    }
    public void irANoticias(View view){

        EditText user = findViewById(R.id.user);
        EditText password = findViewById(R.id.password);
        String usuario = user.getText().toString();
        String clave = password.getText().toString();
        this.login(usuario, clave);
    }

    public void irARegistrarme(View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}