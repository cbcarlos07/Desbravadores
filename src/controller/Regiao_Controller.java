/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Regiao;
import model.dao.Regiao_DAO;

/**
 *
 * @author Gysa
 */
public class Regiao_Controller {
    Regiao_DAO ud = new Regiao_DAO();
    List lista;
    Regiao regiao = new Regiao();
    boolean teste;
    public boolean inserir (Regiao regiao){
        teste = ud.inserir(regiao);
        return teste;
    }
    
    public boolean alterar(Regiao regiao){
        teste = ud.alterar(regiao);
        return teste;
    }
    
    public boolean excluir(int regiao){
        teste = ud.excluir(regiao);
        return teste;
    }
    
    public List<Regiao> getRegiaoList(String regiao){
        lista = ud.getRegiaoList(regiao);
        return lista;
    }
    
    public Regiao getRegiao(int codigo){
        regiao = ud.getRegiao(codigo);
        return regiao;
    }
    
}
