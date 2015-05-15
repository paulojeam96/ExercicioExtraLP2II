/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.javabeans;

/**
 *
 * @author 31448471
 */
public class Artista {
    private int id;
    private String nome;

    public Artista(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Artista(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
