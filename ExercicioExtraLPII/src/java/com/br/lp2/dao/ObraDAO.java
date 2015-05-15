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
public interface ObraDAO {
    //CRUD
    
    //CREATE
    public boolean insertObra(Obra o);
    
    //READ
    public ArrayList<Obra> readObras();
    public Obra readObraById(int id);
    public Obra readObraByTitulo(String nome);
    
    //UPDATE
    public boolean updateObra(int id, Obra o);
    
    //DELETE
    public boolean deleteObraById(int id);
    public boolean deleteObraByTitulo(String nome);
}
