package com.example.receitassaudveis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements RecyclerViewInterface{

    ArrayList<receitaModel> receitaModels = new ArrayList<>();
    int[] receitasImagens = {R.drawable.panqueca_aveia, R.drawable.coxinha_fit, R.drawable.crepioca,
    R.drawable.torta_frango,R.drawable.torta_tapioca, R.drawable.manjar_light_coco,
    R.drawable.strogonoff_vegano, R.drawable.bolo_chocolate_diet, R.drawable.brigadeiro_fit_batata,
    R.drawable.chips_mandioca};


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
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.receitasRecyclerView);

        setUpReceitaModels();

        Receitas_RecyclerViewAdapter adapter = new Receitas_RecyclerViewAdapter(this,
                receitaModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpReceitaModels(){
        String[] receitaTitulos = getResources().getStringArray(R.array.titulos_receitas);
        String[] receitaDescricoes = getResources().getStringArray(R.array.descricoes_receitas);
        String[] receitaIngredientes = getResources().getStringArray(R.array.ingredientes_receitas);
        String[] receitaPassoAPasso = getResources().getStringArray(R.array.passoAPasso_receitas);
        String[] receitaVideoUrl = getResources().getStringArray(R.array.videos_receitas);
        for(i = 0; i < receitaTitulos.length; i++){
            receitaModels.add(new receitaModel(receitaTitulos[i],
                    receitaDescricoes[i],receitasImagens[i], receitaIngredientes[i],
                    receitaPassoAPasso[i], receitaVideoUrl[i]));

        }


    }

    @Override
    public void onItemClick(int pos) {
        Intent intent = new Intent(this, detail_receita_Activity.class);

        intent.putExtra("TITULO", receitaModels.get(pos).getTituloReceita());
        intent.putExtra("INGREDIENTES", receitaModels.get(pos).getIngredientesReceita());
        intent.putExtra("PASSO_A_PASSO", receitaModels.get(pos).getPassoAPassoReceita());
        intent.putExtra("VIDEO_URL", receitaModels.get(pos).getVideoYtUrl());


        startActivity(intent);
    }

}