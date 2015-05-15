/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 31448471
 */
public class ConnectionFactory {

    private final String driver = "org.apache.derby.jdbc.ClientDriver";
    private final String protocolo = "jdbc:derby:";
    private final String dbname = "exercicioBD";
    private final String dominio = "//localhost:1527/";
    private Connection connection;

    public ConnectionFactory() {

    }

    public Connection getConnection(String tipo) {
        if (tipo.equalsIgnoreCase("derby")) {
            try {

                Class.forName(driver).newInstance();
                try {
                    connection = DriverManager.getConnection(protocolo + dominio + dbname, "Paulo", "paulo");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException classNotFoundException) {
            }
        }
    return connection;
    }

}
