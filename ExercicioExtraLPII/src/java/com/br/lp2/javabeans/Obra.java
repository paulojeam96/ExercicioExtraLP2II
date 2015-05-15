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
public class Obra {

    private int id;
    private String titulo;
    private Artista artista;
    private int id_artista;

    public Obra(int id, String titulo, Artista artista) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
    }

    public Obra(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public Obra(String titulo, int id_artista) {
        this.titulo = titulo;
        this.id_artista = id_artista;
    }

    public Obra(String titulo) {
        this.titulo = titulo;
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Obra{" + "id=" + id + ", titulo=" + titulo + ", artista=" + artista + '}';
    }

}
