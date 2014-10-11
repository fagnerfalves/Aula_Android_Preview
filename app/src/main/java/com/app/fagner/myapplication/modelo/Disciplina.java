package com.app.fagner.myapplication.modelo;

/**
 * Created by eccard on 10/11/14.
 */
public class Disciplina {
    int codigo;
    int curso;
    String professor;
    String nome;
    int carga;
    int periodo;
    String horario;

    public Disciplina(int codigo, int curso, String professor, String nome, int carga, int periodo, String horario) {
        this.codigo = codigo;
        this.curso = curso;
        this.professor = professor;
        this.nome = nome;
        this.carga = carga;
        this.periodo = periodo;
        this.horario = horario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
