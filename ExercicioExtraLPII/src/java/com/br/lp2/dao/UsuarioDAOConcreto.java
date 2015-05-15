/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.ConnectionFactory.ConnectionFactory;
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
public class UsuarioDAOConcreto implements GenericDAO {

    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;

    public UsuarioDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insert(Object o) {
        boolean resultado = false;
        Usuario us = (Usuario)o;

        try {
            String sql = "INSERT INTO usuario (nome,email) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, us.getNome());
            statement.setString(2, us.getEmail());
            //rs = statement.executeQuery();
            int resultado2 = statement.executeUpdate();
            if(resultado2 > 0){
                resultado = true;
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> read() {
        ArrayList<Object> lista = new ArrayList();

        try {
            String sql = "SELECT * FROM usuario";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("nome"), rs.getString("email"));
                lista.add(u);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Object readById(int id) {
        Usuario u = null;
        try {
            String sql = "SELECT * FROM usuario WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            while (rs.next()) {
                u = new Usuario(rs.getString("nome"), rs.getString("email"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return u;
    }

    @Override
    public Object readByTitulo(String nome) {
        Usuario u = null;

        try {
            String sql = "SELECT * FROM usuario WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();

            while (rs.next()) {
                u = new Usuario(rs.getString("nome"), rs.getString("email"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return u;
    }

    @Override
    public boolean update(int id, Object u) {
        boolean resultado = false;
        Usuario us = (Usuario)u;
        try {
            String sql = "UPDATE usuario SET nome=?, email=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, us.getNome());
            statement.setString(2, us.getEmail());
            statement.setInt(3, id);
            int r = statement.executeUpdate();
            if (r > 0) {
                resultado = true;
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteById(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM usuario WHERE pk=?";
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
        try {
            String sql = "DELETE FROM usuario WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            int r = statement.executeUpdate();
            if (r > 0) {
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

}
