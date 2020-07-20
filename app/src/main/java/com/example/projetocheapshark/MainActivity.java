package com.example.projetocheapshark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE1 = "com.example.projetocheapshark.MESSAGE1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void PesqJogo (View view) {
        EditText txtPesq = findViewById(R.id.txtPesq);
        String pesq = txtPesq.getText().toString();
        Intent PesqJogo = new Intent(this, ResJogo.class);
        PesqJogo.putExtra(MESSAGE1,pesq);
        startActivity(PesqJogo);
    }

}