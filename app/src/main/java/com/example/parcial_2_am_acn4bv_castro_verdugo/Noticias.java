package com.example.parcial_2_am_acn4bv_castro_verdugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONException;
import org.json.JSONObject;

public class Noticias extends AppCompatActivity {
    private TextView tit;
    private ImageView img;
    private TextView conte1;
    private TextView conte2;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        mAuth = FirebaseAuth.getInstance();

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        Toast.makeText(Noticias.this, "Hola " + nombreUsuario + " accede a las novedades de fútbol seleccionando un equipo!", Toast.LENGTH_SHORT).show();

        ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 0);
        noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        tit = findViewById(R.id.tituloNoticia);
        img = findViewById(R.id.img_nota);
        conte1 = findViewById(R.id.content1);
        conte2 = findViewById(R.id.content2);;
        tit.setText(R.string.tituloNoticia);
        img.setImageResource(R.drawable.chiquimafia);
        conte1.setText(R.string.content1);
        conte2.setText(R.string.content2);
        LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
        layoutEscudo.removeAllViews();
    }
    public void cerrarSesion(View view){

        mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void onClickBoca(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){

            String imageUrl = "https://img.lagaceta.com.ar/fotos/notas/2023/11/04/1200x800_boca-se-vuelve-brasil-manos-vacias-1012650-211843.webp";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoBoca = new ImageView(this);
            logoBoca.setImageResource(R.drawable.boca);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoBoca.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoBoca);
            layoutEscudo.setGravity(Gravity.CENTER);
            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 1);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");

        }else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickRiver(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            String imageUrl = "https://soydelmillo.com/wp-content/uploads/2023/10/River-1.png.webp";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoRiver = new ImageView(this);
            logoRiver.setImageResource(R.drawable.river);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoRiver.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoRiver);
            layoutEscudo.setGravity(Gravity.CENTER);

            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 2);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickRosario(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            String imageUrl = "https://img.lagaceta.com.ar/fotos/notas/2023/05/07/1200x796_festejo-jugadores-central-foto-tomada-de-twitter-rosariocentral-990282-181022.webp";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoRosario = new ImageView(this);
            logoRosario.setImageResource(R.drawable.rosariocentral);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoRosario.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoRosario);
            layoutEscudo.setGravity(Gravity.CENTER);

            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 3);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickDefensa(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            String imageUrl = "https://noticiar.com.ar/datos/fotos/2023/10/05/6466-10/imagen_6513.jpg";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoDefensa = new ImageView(this);
            logoDefensa.setImageResource(R.drawable.defensa);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoDefensa.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoDefensa);
            layoutEscudo.setGravity(Gravity.CENTER);

            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 4);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickIndependiente(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            String imageUrl = "https://www.elgrafico.com.ar/media/cache/pub_news_details_large/media/i/21/f0/21f0d353038dcedb3db2ee95298ca09e8fd5f244.jpg";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoIndependiente = new ImageView(this);
            logoIndependiente.setImageResource(R.drawable.independiente);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoIndependiente.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoIndependiente);
            layoutEscudo.setGravity(Gravity.CENTER);

            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 6);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickRacing(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            String imageUrl = "https://www.relatores.com.ar/datos/fotos/2021/05/31/1849-10/imagen_2050.jpg";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoRacing = new ImageView(this);
            logoRacing.setImageResource(R.drawable.racing);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoRacing.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoRacing);
            layoutEscudo.setGravity(Gravity.CENTER);

            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 8);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickNewells(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            String imageUrl = "https://relatores.com.ar/datos/fotos/2022/10/11/12665-10/imagen_14098.jpg";

            LinearLayout layoutEscudo = findViewById(R.id.layoutEscudo);
            ImageView logoNewells = new ImageView(this);
            logoNewells.setImageResource(R.drawable.newells);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(400, 400);
            logoNewells.setLayoutParams(layoutParams);
            layoutEscudo.removeAllViews();
            layoutEscudo.addView(logoNewells);
            layoutEscudo.setGravity(Gravity.CENTER);

            ApiObtenerNoticias noticia = new ApiObtenerNoticias(this, 5);
            noticia.execute("https://noticiasapi.lucas-pablopabl.repl.co/");
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }

    public void cargarDatosDesdeAsyncTask(String s) {
        try {
            JSONObject noticia = new JSONObject(s);
            String titulo = noticia.getString("titulo");
            String contenidoUno = noticia.getString("contenido1");
            String contenidoDos = noticia.getString("contenido2");
            String imageUrl = noticia.getString("img");
            tit.setText(titulo);
            conte1.setText(contenidoUno);
            conte2.setText(contenidoDos);
            img = findViewById(R.id.img_nota);
            DescargaImgNewells downloadImageTask = new DescargaImgNewells(img);

            downloadImageTask.execute(imageUrl);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}