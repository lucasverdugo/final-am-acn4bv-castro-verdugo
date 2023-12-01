package com.example.parcial_2_am_acn4bv_castro_verdugo;

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
        TextView tituloNoticia = findViewById(R.id.tituloNoticia);
        ImageView imagenNoticia = findViewById(R.id.img_nota);
        TextView contenido1 = findViewById(R.id.content1);
        TextView contenido2 = findViewById(R.id.content2);;
        tituloNoticia.setText(R.string.tituloNoticia);
        imagenNoticia.setImageResource(R.drawable.chiquimafia);
        contenido1.setText(R.string.content1);
        contenido2.setText(R.string.content2);
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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);

            DescargaImgBoca downloadImageTask = new DescargaImgBoca(imagenNoticia);
            downloadImageTask.execute(imageUrl);

            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaBoca);
            contenido1.setText(R.string.contenido1Boca);
            imagenNoticia.setImageResource(R.drawable.bocaimg);
            contenido2.setText(R.string.contenido2Boca);

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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);
            DescargaImgRiver downloadImageTask = new DescargaImgRiver(imagenNoticia);
            downloadImageTask.execute(imageUrl);
            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaRiver);
            contenido1.setText(R.string.contenido1River);
            imagenNoticia.setImageResource(R.drawable.riverimg);
            contenido2.setText(R.string.contenido2River);
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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);
            DescargaImgRosario downloadImageTask = new DescargaImgRosario(imagenNoticia);
            downloadImageTask.execute(imageUrl);
            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaRosario);
            contenido1.setText(R.string.contenido1Rosario);
            imagenNoticia.setImageResource(R.drawable.rosarioimg);
            contenido2.setText(R.string.contenido2Rosario);
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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);
            DescargaImgDefensa downloadImageTask = new DescargaImgDefensa(imagenNoticia);
            downloadImageTask.execute(imageUrl);
            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaDefensa);
            contenido1.setText(R.string.contenido1Defensa);
            imagenNoticia.setImageResource(R.drawable.defensaimg);
            contenido2.setText(R.string.contenido2Defensa);
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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);
            DescargaImgIndependiente downloadImageTask = new DescargaImgIndependiente(imagenNoticia);
            downloadImageTask.execute(imageUrl);
            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaIndependiente);
            contenido1.setText(R.string.contenido1Independiente);
            imagenNoticia.setImageResource(R.drawable.independientenoticia);
            contenido2.setText(R.string.contenido2Independiente);
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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);
            DescargaImgRacing downloadImageTask = new DescargaImgRacing(imagenNoticia);
            downloadImageTask.execute(imageUrl);
            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaRacing);
            contenido1.setText(R.string.contenido1Racing);
            imagenNoticia.setImageResource(R.drawable.racingnoticia);
            contenido2.setText(R.string.contenido2Racing);
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

            TextView tituloNoticia = findViewById(R.id.tituloNoticia);
            ImageView imagenNoticia = findViewById(R.id.img_nota);
            DescargaImgNewells downloadImageTask = new DescargaImgNewells(imagenNoticia);
            downloadImageTask.execute(imageUrl);
            TextView contenido1 = findViewById(R.id.content1);
            TextView contenido2 = findViewById(R.id.content2);

            tituloNoticia.setText(R.string.tituloNoticiaNewells);
            contenido1.setText(R.string.contenido1Newells);
            imagenNoticia.setImageResource(R.drawable.newellsnoticia);
            contenido2.setText(R.string.contenido2Newells);
        }
        else{
            Toast.makeText(Noticias.this, "Su conexión con internet se perdió. Acitve sus datos o vuelva a una zona con conexión.", Toast.LENGTH_SHORT).show();
        }
    }
}