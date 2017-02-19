/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Divisao;
import model.dao.Divisao_DAO;

/**
 *
 * @author Gysa
 */
public class Divisao_Controller {
    Divisao_DAO dd = new Divisao_DAO();
    List lista;
    Divisao divisao = new Divisao();
    boolean teste;
    public boolean inserir (Divisao divisao){
        teste = dd.inserir(divisao);
        return teste;
    }
    
    public boolean alterar(Divisao divisao){
        teste = dd.alterar(divisao);
        return teste;
    }
    
    public boolean excluir(int divisao){
        teste = dd.excluir(divisao);
        return teste;
    }
    
    public List<Divisao> getDivisaoList(String divisao){
        lista = dd.getDivisaoList(divisao);
        return lista;
    }
    
    public List<Divisao> getSiglaList(String divisao){
        lista = dd.getSiglaList(divisao);
        return lista;
    }
   
}
