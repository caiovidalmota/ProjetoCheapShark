package com.example.projetocheapshark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ResJogo extends AppCompatActivity {
    String PesqJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_jogo);

        ImageView imgjogo2 = findViewById(R.id.IMGJogo2);
        TextView valjogo2 = findViewById(R.id.txtValor2);
        ImageView imgjogo3 = findViewById(R.id.IMGJogo3);
        TextView valjogo3 = findViewById(R.id.txtValor3);

        try {
            Post();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String Post() throws IOException, JSONException {
        Intent intent = getIntent();
        PesqJogo = intent.getStringExtra(MainActivity.MESSAGE1);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://cheapshark-game-deals.p.rapidapi.com/games?limit=60&title=batman&exact=0")
                .get()
                .addHeader("x-rapidapi-host", "cheapshark-game-deals.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "5ea54b2169msh2c625c75c362c66p1b5773jsnfc390e76d6ae")
                .build();

        Response response = client.newCall(request).execute();
        String jsonDeResposta = response.body().string();
        JSONObject dadosjson = new JSONObject(jsonDeResposta);
        String cheapest = dadosjson.get("cheapest").toString();
        TextView valjogo1 = findViewById(R.id.txtValor1);
        valjogo1.setText(cheapest);
        return response.body().string();
    }
}