package com.example.parcial_2_am_acn4bv_castro_verdugo;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiObtenerNoticias extends AsyncTask<String, Integer, String> {

    private Noticias noticiasActivity;
    int index;

    public ApiObtenerNoticias(Noticias noticiasActivity, int index) {
        this.noticiasActivity = noticiasActivity;
        this.index = index;
    }
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String response = "";
        try {
            response = run(url);
            JSONArray noticias = new JSONArray(response);
            response = noticias.get(index).toString();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        noticiasActivity.cargarDatosDesdeAsyncTask(s);
    }
}

