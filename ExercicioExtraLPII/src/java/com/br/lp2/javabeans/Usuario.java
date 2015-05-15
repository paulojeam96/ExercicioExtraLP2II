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
public class Usuario {
    private String nome;
    private String email;
    private int id;

    public Usuario(String nome, String email, int id) {
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", id=" + id + '}';
    }
    
    
    
    
}
