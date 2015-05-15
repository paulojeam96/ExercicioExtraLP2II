/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.command;

import com.br.lp2.dao.GenericDAO;
import com.br.lp2.dao.ObraDAOConcreto;
import com.br.lp2.javabeans.Obra;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class DeletarObra implements Command{
    private String titulo;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        titulo = request.getParameter("titulo");
        
        GenericDAO gDao = new ObraDAOConcreto();
        ArrayList<Object> aux = gDao.read();
        String correto = null;
        
        for (Object aux1 : aux) {
            Obra o = (Obra)aux1;
            if(o.getTitulo().equals(this.titulo)){
                correto = o.getTitulo();
            }
        }
        
        boolean operacao = gDao.delete(correto);
        
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
