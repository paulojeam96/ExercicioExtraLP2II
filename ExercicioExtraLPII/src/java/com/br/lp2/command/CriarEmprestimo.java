/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.command;

import com.br.lp2.dao.GenericDAO;
import com.br.lp2.dao.ObraDAOConcreto;
import com.br.lp2.dao.UsuarioDAOConcreto;
import com.br.lp2.javabeans.Emprestimo;
import com.br.lp2.javabeans.Obra;
import com.br.lp2.javabeans.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class CriarEmprestimo implements Command{
    private String obra;
    private String usuario;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        obra = request.getParameter("obra");
        usuario = request.getParameter("usuario");
        
        //Pega a Obra no BD
        GenericDAO ob = new ObraDAOConcreto();
        ArrayList<Object> lista = ob.read();
        Obra b = null;
        
        for (Object obra : lista) {
            Obra a = (Obra)obra;
            if(a.getTitulo().equals(this.obra)){
                b = new Obra(a.getTitulo(), a.getArtista());
            }
        }
        
        GenericDAO us = new UsuarioDAOConcreto();
        ArrayList<Object> listaUsuario = us.read();
        Usuario u = null;
        
        for (Object usuarios : listaUsuario) {
            Usuario usu = (Usuario)usuarios;
            if(usu.getNome().equals(this.usuario)){
                u = new Usuario(usu.getNome(), usu.getEmail());
            }
        }
        
        
        
        Emprestimo e = new Emprestimo(b, u);
    }
    
}
