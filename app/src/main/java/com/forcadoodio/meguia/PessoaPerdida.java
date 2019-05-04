package com.forcadoodio.meguia;

public class PessoaPerdida {
    private String nome;
    private String partida;
    private String chegada;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        chegada = chegada;
    }

    public PessoaPerdida(String nome, String partida, String chegada) {
        this.nome = nome;
        this.partida = partida;
        this.chegada = chegada;
    }




}
