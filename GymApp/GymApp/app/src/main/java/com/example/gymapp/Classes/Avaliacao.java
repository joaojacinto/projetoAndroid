package com.example.gymapp.Classes;

public class Avaliacao {
    private int id;
    private String gordura_corporal, massa_muscular,peso,altura,massa_gorda;

    public Avaliacao(String gordura_corporal, String massa_muscular, String peso,String altura, String massa_gorda) {
        this.gordura_corporal =gordura_corporal;
        this.massa_muscular=massa_muscular;
        this.peso=peso;
        this.altura=altura;
        this.massa_gorda=massa_gorda;
    }


    public Avaliacao(String gordura_corporal) {
        this.gordura_corporal = gordura_corporal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGordura_corporal() {
        return gordura_corporal;
    }

    public void setGordura_corporal(String gordura_corporal) {
        this.gordura_corporal = gordura_corporal;
    }

    public String getMassa_muscular() {
        return massa_muscular;
    }

    public void setMassa_muscular(String massa_muscular) {
        this.massa_muscular = massa_muscular;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getMassa_gorda() {
        return massa_gorda;
    }

    public void setMassa_gorda(String massa_gorda) {
        this.massa_gorda = massa_gorda;
    }
}
