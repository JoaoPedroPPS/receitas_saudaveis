package com.example.receitassaudveis;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Receitas_RecyclerViewAdapter extends RecyclerView.Adapter<Receitas_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<receitaModel> receitaModels;


    public Receitas_RecyclerViewAdapter(Context context, ArrayList<receitaModel> receitaModels,
                                        RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.receitaModels = receitaModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public Receitas_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);


        return new Receitas_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Receitas_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textViewTitulo.setText(receitaModels.get(position).getTituloReceita());
        holder.textViewDescricao.setText(receitaModels.get(position).getDecricaoReceita());
        holder.imageView.setImageResource(receitaModels.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        return receitaModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitulo;
        TextView textViewDescricao;


        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.receitaImageView);
            textViewTitulo = itemView.findViewById(R.id.favReceitaTitle);
            textViewDescricao = itemView.findViewById(R.id.receitaDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
