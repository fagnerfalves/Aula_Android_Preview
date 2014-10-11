package com.app.fagner.myapplication.modelo;

/**
 * Created by eccard on 10/11/14.
 */
public class Noticia {
    int codigo;
    String titulo;
    String conteudo;
    String data;
    String hora;

    public Noticia(int codigo, String titulo, String conteudo, String data, String hora) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
        this.hora = hora;
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
