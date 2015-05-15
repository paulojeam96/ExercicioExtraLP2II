/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.command;

import com.br.lp2.dao.ArtistaDAOConcreto;
import com.br.lp2.dao.GenericDAO;
import com.br.lp2.dao.ObraDAOConcreto;
import com.br.lp2.javabeans.Artista;
import com.br.lp2.javabeans.Obra;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class InserirObra implements Command{
    private String titulo;
    private int id_artista;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        titulo = request.getParameter("titulo");
        id_artista = Integer.parseInt(request.getParameter("id_artista"));
        System.out.println(id_artista>0);
        GenericDAO art = new ArtistaDAOConcreto();

        Artista artista = new Artista(id_artista, "Anonimo");
        
        for (Object obj : art.read()) {
            Artista a = (Artista)obj;
            System.out.println(a.getId()+" - "+id_artista);
            if(a.getId()==id_artista){
                artista = new Artista(a.getId(), a.getNome());
            }
        }
        
        GenericDAO oDao = new ObraDAOConcreto();
        Obra obra = new Obra(titulo, artista);
        boolean operacao = oDao.insert(obra);
        
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
