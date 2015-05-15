/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.javabeans.Obra;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface GenericDAO {
    //CRUD
    
    //CREATE
    public boolean insert(Object o);
    
    //READ
    public ArrayList<Object> read();
    public Object readById(int id);
    public Object readByTitulo(String nome);
    
    //UPDATE
    public boolean update(int id, Object o);
    
    //DELETE
    public boolean deleteById(int id);
    public boolean delete(String nome);
}
