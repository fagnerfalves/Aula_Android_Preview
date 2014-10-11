package com.app.fagner.myapplication.modelo;

/**
 * Created by eccard on 10/11/14.
 */
public class Curso {
    String nome;
    int codigo;

    public Curso(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
