/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.javabeans.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface UsuarioDAO {
    //CRUD
    
    //CREATE
    public boolean insertUsuario(Usuario u);
    
    //READ
    public ArrayList<Usuario> readUsuarios();
    public Usuario readUsuariosById(int id);
    public Usuario readUsuariosByNome(String nome);
    
    //UPDATE
    public boolean updateUsuario(int id, Usuario u);
    
    //DELETE
    public boolean deleteUsuarioById(int id);
    public boolean deleteUsuarioByNome(String nome);
    
}
