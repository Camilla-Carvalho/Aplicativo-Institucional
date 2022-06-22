package com.camillacarvalho.projetos.aplicativo_institucional.model;

public class Visao {

    private long id;
    private String título;
    private String conteudo;

    public Visao(long id, String título, String conteudo) {
        this.id = id;
        this.título = título;
        this.conteudo = conteudo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
