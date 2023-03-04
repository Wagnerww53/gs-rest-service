package com.prova.prefeitura.fila.entidades;

public class Pessoa {
	private String nome;
    private int idade;
    private int posicaoNaFila;    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPosicaoNaFila() {
        return posicaoNaFila;
    }

    public void setPosicaoNaFila(int posicaoNaFila) {
        this.posicaoNaFila = posicaoNaFila;
    }
}

