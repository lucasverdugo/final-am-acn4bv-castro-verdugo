package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    public void createUser(String user, String password, String nombre, String apellido){

        ConnectivityManager connMgr = (ConnectivityManager)
        getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            mAuth.createUserWithEmailAndPassword(user, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                String uid = mAuth.getCurrentUser().getUid();
                                Map<String, Object> userData = new HashMap<>();
                                userData.put("nombre", nombre);
                                userData.put("apellido", apellido);
                                userData.put("uidAuth", uid);
                                db.collection("users")
                                        .add(userData)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(Registro.this, "Usuario creado con éxito.", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), Noticias.class);
                                                startActivity(intent);
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(Registro.this, "Error al intentar el registro del usuario.", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), ErrorInicioSesion.class);
                                                startActivity(intent);
                                            }
                                        });

                            } else {
                                Toast.makeText(Registro.this, "Error al intentar el registro del usuario.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ErrorInicioSesion.class);
                                startActivity(intent);
                            }
                        }
                    });
        }
        else{
            Toast.makeText(Registro.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }

    public void registro(View view){
        EditText user = findViewById(R.id.usuario_registro_input);
        EditText password = findViewById(R.id.clave_registro_input);

        EditText fname = findViewById(R.id.nombre_registro_input);
        EditText lname = findViewById(R.id.apellido_registro_input);


        String usuario = user.getText().toString();
        String clave = password.getText().toString();

        String nombre = fname.getText().toString();
        String apellido = lname.getText().toString();

        this.createUser(usuario, clave, nombre, apellido);
    }

    public void irAInicioSesion(View view){
        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    }
}