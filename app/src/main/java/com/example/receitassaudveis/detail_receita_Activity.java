package com.example.receitassaudveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


import java.util.Objects;

public class detail_receita_Activity extends AppCompatActivity {






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_bookmarks) {
            // Handle button click (e.g., go to the screen about bookmarked posts)
            Intent intent = new Intent(this, BookmarksActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detail_receita);


        VideoView video = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);

        String videoPath = "file:///android_asset/manjar_de_coco_mp4.mp4";
        video.setVideoPath(videoPath);

        String titulo = getIntent().getStringExtra("TITULO");
        String ingredientes = getIntent().getStringExtra("INGREDIENTES");
        String passo_a_passo = getIntent().getStringExtra("PASSO_A_PASSO");

        Button btnFavoritar = findViewById(R.id.btn_Favorite);
        TextView tituloTextView = findViewById(R.id.tituloReceita_textView);
        TextView ingredientesTextView = findViewById(R.id.ingredientes_textView);
        TextView passo_a_passoTextView = findViewById(R.id.passoAPasso_textView);

        tituloTextView.setText(titulo);
        ingredientesTextView.setText(ingredientes);
        passo_a_passoTextView.setText(passo_a_passo);

        btnFavoritar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(detail_receita_Activity.this,
                        "Receita adicionada aos Favoritos!", Toast.LENGTH_SHORT).show();

                // Get the existing list of bookmarked posts from SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("BookmarkPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("chaveTitulo", titulo.toString());
                editor.apply();




            }
        });
    }
}