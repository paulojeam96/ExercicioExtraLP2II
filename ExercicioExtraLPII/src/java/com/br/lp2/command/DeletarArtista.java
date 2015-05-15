/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.command;

import com.br.lp2.dao.ArtistaDAOConcreto;
import com.br.lp2.dao.GenericDAO;
import com.br.lp2.javabeans.Artista;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class DeletarArtista implements Command{
    private String nome;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        
        
        GenericDAO aDao = new ArtistaDAOConcreto();
        ArrayList<Object> aux = aDao.read();
        String correto = null;
        
        for (Object aux1 : aux) {
            Artista a = (Artista)aux1;
            if(a.getNome().equals(this.nome)){
                correto = a.getNome();
            }
        }
        
        boolean operacao = aDao.delete(correto);
        
        
        try {
            if (operacao) {
                response.sendRedirect("sucesso.jsp");
            } else {
                response.sendRedirect("fail.jsp");
            }
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }
   
    }
    
}
