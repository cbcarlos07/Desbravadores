/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Pais;
import model.dao.Pais_DAO;

/**
 *
 * @author Gysa
 */
public class Pais_Controller {
    Pais_DAO ad = new Pais_DAO();
    List lista;
    Pais pais = new Pais();
    boolean teste;
    public boolean inserir (Pais pais){
        teste = ad.inserir(pais);
        return teste;
    }
    
    public boolean alterar(Pais pais){
        teste = ad.alterar(pais);
        return teste;
    }
    
    public boolean excluir(int pais){
        teste = ad.excluir(pais);
        return teste;
    }
    
    public List<Pais> getPaisList(String pais){
        lista = ad.getPaisList(pais);
        return lista;
    }
    
}
