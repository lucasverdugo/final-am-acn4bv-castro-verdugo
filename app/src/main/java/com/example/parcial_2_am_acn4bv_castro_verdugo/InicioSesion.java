package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class InicioSesion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        mAuth = FirebaseAuth.getInstance();
    }

    public void login(String user, String password){
        mAuth.signInWithEmailAndPassword(user, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(getApplicationContext(), Noticias.class);
                            startActivity(intent);
                        }else{
                           Toast.makeText(InicioSesion.this, "El inicio de sesión fallo.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void irANoticias(View view){

        EditText user = findViewById(R.id.user);
        EditText password = findViewById(R.id.password);
        String usuario = user.getText().toString();
        String clave = password.getText().toString();

        this.login(usuario, clave);


        /*Controlador c1 = new Controlador();
        List<Usuario> u1 = c1.listarUsuarios();
        EditText editText1 = findViewById(R.id.user);
        String usuario = editText1.getText().toString();
        EditText editText2 = findViewById(R.id.password);
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
        }*/

    }

    public void irARegistrarme(View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}