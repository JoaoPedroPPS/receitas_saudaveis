package com.example.receitassaudveis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<receitaModel> receitaModels = new ArrayList<>();
    int[] receitasImagens = {R.drawable.panqueca_aveia, R.drawable.coxinha_fit, R.drawable.crepioca,
    R.drawable.torta_frango,R.drawable.torta_tapioca, R.drawable.manjar_light_coco,
    R.drawable.strogonoff_vegano, R.drawable.bolo_chocolate_diet, R.drawable.brigadeiro_fit_batata,
    R.drawable.chips_mandioca};

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.receitasRecyclerView);

        setUpReceitaModels();

        Receitas_RecyclerViewAdapter adapter = new Receitas_RecyclerViewAdapter(this,
                receitaModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpReceitaModels(){
        String[] receitaTitulos = getResources().getStringArray(R.array.titulos_receitas);
        String[] receitaDescricoes = getResources().getStringArray(R.array.descricoes_receitas);

        for(i = 0; i < receitaTitulos.length; i++){
            receitaModels.add(new receitaModel(receitaTitulos[i],
                    receitaDescricoes[i],receitasImagens[i]));

        }


    }

}