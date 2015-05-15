/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.command;

import com.br.lp2.dao.GenericDAO;
import com.br.lp2.dao.UsuarioDAOConcreto;
import com.br.lp2.javabeans.Usuario;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class CriarUsuario implements Command{
    private String nome;
    private String email;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        email = request.getParameter("email");
        
        Usuario u = new Usuario(nome, email);
        GenericDAO uDao = new UsuarioDAOConcreto();
        boolean operacao = uDao.insert(u);
        
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
