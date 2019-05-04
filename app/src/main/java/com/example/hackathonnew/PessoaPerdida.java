package com.example.hackathonnew;

public class PessoaPerdida {
    private String nome;
    private String partida;

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
        return Chegada;
    }

    public void setChegada(String chegada) {
        Chegada = chegada;
    }

    public PessoaPerdida(String nome, String partida, String chegada) {
        this.nome = nome;
        this.partida = partida;
        Chegada = chegada;
    }

    private String Chegada;
}
