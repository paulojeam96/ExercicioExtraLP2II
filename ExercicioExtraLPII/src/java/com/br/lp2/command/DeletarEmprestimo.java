/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.command;

import com.br.lp2.dao.EmprestimoDAOConcreto;
import com.br.lp2.dao.GenericDAO;
import com.br.lp2.javabeans.Emprestimo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class DeletarEmprestimo implements Command{
    private int id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        id = Integer.parseInt(request.getParameter("id"));
        
        GenericDAO eDao = new EmprestimoDAOConcreto();
        ArrayList<Object> ids = eDao.read();
        int idCorreto = 0;
        
        for (Object id1 : ids) {
            Emprestimo em = (Emprestimo)id1;
            if(em.getId()==this.id){
                idCorreto = em.getId();
            }
        }
        
        boolean operacao = eDao.deleteById(idCorreto);
        
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
