package com.example.receitassaudveis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BookmarksActivity extends AppCompatActivity {
    private String tituloFav;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tituloTextView = findViewById(R.id.favReceitaTitle);


        setContentView(R.layout.activity_bookmarks);
        SharedPreferences sharedPreferences = getSharedPreferences("BookmarkPrefs", Context.MODE_PRIVATE);
        tituloFav = sharedPreferences.getString("chaveTitulo","");

        tituloTextView.setText(tituloFav.toString());

    }
}