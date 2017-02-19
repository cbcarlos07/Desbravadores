/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Uniao;
import model.dao.Uniao_DAO;

/**
 *
 * @author Gysa
 */
public class Uniao_Controller {
    Uniao_DAO ud = new Uniao_DAO();
    List lista;
    Uniao uniao = new Uniao();
    boolean teste;
    public boolean inserir (Uniao uniao){
        teste = ud.inserir(uniao);
        return teste;
    }
    
    public boolean alterar(Uniao uniao){
        teste = ud.alterar(uniao);
        return teste;
    }
    
    public boolean excluir(int uniao){
        teste = ud.excluir(uniao);
        return teste;
    }
    
    public List<Uniao> getUniaoList(String uniao){
        lista = ud.getUniaoList(uniao);
        return lista;
    }
    
    public List<Uniao> getSiglaList(String uniao){
        lista = ud.getSiglaList(uniao);
        return lista;
    }
    
    public Uniao getUniao(int codigo){
        uniao = ud.getUniao(codigo);
        return uniao;
    }
    
}
