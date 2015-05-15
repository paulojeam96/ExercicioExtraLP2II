/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.ConnectionFactory.ConnectionFactory;
import com.br.lp2.javabeans.Artista;
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
public class ArtistaDAOConcreto implements GenericDAO{
    
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;

    public ArtistaDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insert(Object o) {
        boolean resultado = false;
        Artista a = (Artista)o;
        try {
            String sql = "INSERT INTO artista (nome) VALUES(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, a.getNome());
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
            String sql = "SELECT * FROM artista";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                Artista a= new Artista(rs.getString("nome"));
                a.setId(rs.getInt("pk"));
                lista.add(a);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        
        
        return lista;
    }

    @Override
    public Object readById(int id) {
        Artista u = null;
        try {
            String sql = "SELECT * FROM artista WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                u = new Artista(rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return u;
    }

    @Override
    public Object readByTitulo(String nome) {
        Artista a = null;
        
            try {
                String sql = "SELECT * FROM artista WHERE nome=?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, nome);
                rs = statement.executeQuery();
                
                while (rs.next()) {
                a = new Artista(rs.getString("nome"));
                }
            } catch (SQLException sQLException) {
                System.out.println(sQLException.getMessage());
            }
            return a;
    }

    @Override
    public boolean update(int id, Object o) {
        Artista a = (Artista)o;
        boolean resultado = false;
        try {
            String sql = "UPDATE artista SET nome=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, a.getNome());
            statement.setInt(3, id);
            int r = statement.executeUpdate();
            if(r > 0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteById(int id) {
        boolean resultado = false;
        
        try {
            String sql = "DELETE FROM artista WHERE pk=?";
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
            String sql = "DELETE FROM artista WHERE nome=?";
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
