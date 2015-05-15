/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.ConnectionFactory.ConnectionFactory;
import com.br.lp2.javabeans.Obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public class ObraDAOConcreto implements GenericDAO {

    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;

    public ObraDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insert(Object o) {
        boolean resultado = false;
        Obra a = (Obra)o;

        try {
            String sql = "INSERT INTO obra (titulo, id_artista) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, a.getTitulo());
            statement.setInt(2, a.getArtista().getId());
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
            String sql = "SELECT * FROM obra";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Obra o = new Obra(rs.getString("titulo"), rs.getInt("id_artista"));
                lista.add(o);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Object readById(int id) {
        Obra o = null;
        try {
            String sql = "SELECT * FROM obra WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            while (rs.next()) {
                o = new Obra(rs.getString("nome"), rs.getInt("id_artista"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return o;
    }

    @Override
    public Object readByTitulo(String titulo) {
        Obra o = null;

        try {
            String sql = "SELECT * FROM obra WHERE titulo=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, titulo);
            rs = statement.executeQuery();

            while (rs.next()) {
                o = new Obra(rs.getString("nome"), rs.getInt("id_artista"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return o;
    }

    @Override
    public boolean update(int id, Object o) {
        boolean resultado = false;
        Obra a = (Obra)o;
        try {
            String sql = "UPDATE obra SET titulo=?, id_artista=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, a.getTitulo());
            statement.setInt(2, a.getArtista().getId());
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
        boolean resultado = false;
        
        try {
            String sql = "DELETE FROM obra WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id); 
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean delete(String nome) {
        boolean res = false;
        try{
            String sql = "DELETE FROM obra WHERE titulo=?";
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
