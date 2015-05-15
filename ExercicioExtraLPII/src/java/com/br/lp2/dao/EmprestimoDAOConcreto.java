/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.ConnectionFactory.ConnectionFactory;
import com.br.lp2.javabeans.Emprestimo;
import com.br.lp2.javabeans.Obra;
import com.br.lp2.javabeans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public class EmprestimoDAOConcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;

    public EmprestimoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insert(Object o) {
        Emprestimo e = (Emprestimo)o;
        
        boolean resultado = false;

        try {
            String sql = "INSERT INTO emprestimo (id_obra, id_usuario) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, e.getUsuario().getId());
            statement.setInt(2, e.getObra().getId());
            //rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object readByTitulo(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(int id, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM emprestimo WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int r = statement.executeUpdate();
            if (r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(String nome) {
        boolean res = false;
        try{
            String sql = "DELETE FROM emprestimo WHERE obra=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            int r = statement.executeUpdate();
            if (r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
    }
    
}
