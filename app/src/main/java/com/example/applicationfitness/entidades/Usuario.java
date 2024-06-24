package com.example.applicationfitness.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String genero;
    private String meta;
    private boolean diaTreinoDomingo;
    private boolean diaTreinoSegunda;
    private boolean diaTreinoTerca;
    private boolean diaTreinoQuarta;
    private boolean diaTreinoQuinta;
    private boolean diaTreinoSexta;
    private boolean diaTreinoSabado;
    private float peso;

    public Usuario(String nome, String genero, String meta, boolean diaTreinoDomingo, boolean diaTreinoSegunda, boolean diaTreinoTerca, boolean diaTreinoQuarta, boolean diaTreinoQuinta, boolean diaTreinoSexta, boolean diaTreinoSabado, float peso) {
        this.nome = nome;
        this.genero = genero;
        this.meta = meta;
        this.diaTreinoDomingo = diaTreinoDomingo;
        this.diaTreinoSegunda = diaTreinoSegunda;
        this.diaTreinoTerca = diaTreinoTerca;
        this.diaTreinoQuarta = diaTreinoQuarta;
        this.diaTreinoQuinta = diaTreinoQuinta;
        this.diaTreinoSexta = diaTreinoSexta;
        this.diaTreinoSabado = diaTreinoSabado;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getMeta() {
        return meta;
    }

    public boolean isDiaTreinoDomingo() {
        return diaTreinoDomingo;
    }

    public boolean isDiaTreinoSegunda() {
        return diaTreinoSegunda;
    }

    public boolean isDiaTreinoTerca() {
        return diaTreinoTerca;
    }

    public boolean isDiaTreinoQuarta() {
        return diaTreinoQuarta;
    }

    public boolean isDiaTreinoQuinta() {
        return diaTreinoQuinta;
    }

    public boolean isDiaTreinoSexta() {
        return diaTreinoSexta;
    }

    public boolean isDiaTreinoSabado() {
        return diaTreinoSabado;
    }

    public float getPeso() {
        return peso;
    }
}
