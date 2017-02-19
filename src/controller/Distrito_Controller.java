/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Distrito;
import model.dao.Distrito_DAO;

/**
 *
 * @author Gysa
 */
public class Distrito_Controller {
    Distrito_DAO ud = new Distrito_DAO();
    List lista;
    Distrito distrito = new Distrito();
    boolean teste;
    public boolean inserir (Distrito distrito){
        teste = ud.inserir(distrito);
        return teste;
    }
    
    public boolean alterar(Distrito distrito){
        teste = ud.alterar(distrito);
        return teste;
    }
    
    public boolean excluir(int distrito){
        teste = ud.excluir(distrito);
        return teste;
    }
    
    public List<Distrito> getDistritoList(String distrito){
        lista = ud.getDistritoList(distrito);
        return lista;
    }
    
    public Distrito getDistrito(int codigo){
        distrito = ud.getDistrito(codigo);
        return distrito;
    }
    
}
