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
public class Emprestimo {
    private int id;
    private Obra obra;
    private Usuario usuario;

    public Emprestimo(int id, Obra obra, Usuario usuario) {
        this.id = id;
        this.obra = obra;
        this.usuario = usuario;
    }

    public Emprestimo(Obra obra, Usuario usuario) {
        this.obra = obra;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", obra=" + obra + ", usuario=" + usuario + '}';
    }
    
    
}
