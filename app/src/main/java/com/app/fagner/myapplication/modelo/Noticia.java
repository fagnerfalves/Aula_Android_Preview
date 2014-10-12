package com.app.fagner.myapplication.modelo;

import java.io.Serializable;

/**
 * Created by eccard on 10/11/14.
 */
public class Noticia implements Serializable{
    int codigo;
    String titulo;
    String conteudo;
    String data;
    String hora;
    int visualizar;

    public Noticia(int codigo, String titulo, String conteudo, String data, String hora) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
        this.hora = hora;
    }

    public int getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(int visualizar) {
        this.visualizar = visualizar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
