package com.example.receitassaudveis;

public class receitaModel {
    String tituloReceita;
    String decricaoReceita;
    int imagem;


    public receitaModel(String tituloReceita, String decricaoReceita, int imagem) {
        this.tituloReceita = tituloReceita;
        this.decricaoReceita = decricaoReceita;
        this.imagem = imagem;
    }


    public String getTituloReceita() {
        return tituloReceita;
    }

    public void setTituloReceita(String tituloReceita) {
        this.tituloReceita = tituloReceita;
    }

    public String getDecricaoReceita() {
        return decricaoReceita;
    }

    public void setDecricaoReceita(String decricaoReceita) {
        this.decricaoReceita = decricaoReceita;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
