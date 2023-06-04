package com.example.receitassaudveis;

public class receitaModel {
    String tituloReceita;
    String decricaoReceita;

    String ingredientesReceita;

    String passoAPassoReceita;



    String videoYtUrl;
    int imagem;


    public receitaModel(String tituloReceita, String decricaoReceita, int imagem,
                        String ingredientesReceita, String passoAPassoReceita, String videoYtUrl) {
        this.tituloReceita = tituloReceita;
        this.decricaoReceita = decricaoReceita;
        this.imagem = imagem;
        this.ingredientesReceita = ingredientesReceita;
        this.passoAPassoReceita = passoAPassoReceita;
        this.videoYtUrl = videoYtUrl;
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

    public String getIngredientesReceita() {
        return ingredientesReceita;
    }

    public void setIngredientesReceita(String ingredientesReceita) {
        this.ingredientesReceita = ingredientesReceita;
    }

    public String getPassoAPassoReceita() {
        return passoAPassoReceita;
    }

    public void setPassoAPassoReceita(String passoAPassoReceita) {
        this.passoAPassoReceita = passoAPassoReceita;
    }

    public String getVideoYtUrl() {
        return videoYtUrl;
    }

    public void setVideoYtUrl(String videoYtUrl) {
        this.videoYtUrl = videoYtUrl;
    }
}
