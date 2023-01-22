package com.example.gymapp.Classes;

public class Avaliacao {
    private String gordura_corpural, massa_muscular,peso,altura,massa_gorda;

    public Avaliacao(String gordura_corpural, String massa_muscular, String peso,String altura, String massa_gorda) {
        this.gordura_corpural=gordura_corpural;
        this.massa_muscular=massa_muscular;
        this.peso=peso;
        this.altura=altura;
        this.massa_gorda=massa_gorda;
    }

    public Avaliacao(int anInt) {
    }

    public String getGordura_corpural() {
        return gordura_corpural;
    }

    public void setGordura_corpural(String gordura_corpural) {
        this.gordura_corpural = gordura_corpural;
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
