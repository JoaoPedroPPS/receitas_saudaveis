package com.example.receitassaudveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import java.util.Objects;

public class BookmarksActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        TextView tituloTextView = findViewById(R.id.favReceitaTitle);

        SharedPreferences sharedPreferences = getSharedPreferences("BookmarkPrefs", Context.MODE_PRIVATE);
        String tituloFav = sharedPreferences.getString("chaveTitulo", "");

        tituloTextView.setText(tituloFav);
    }

}