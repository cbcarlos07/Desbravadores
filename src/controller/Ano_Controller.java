/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Ano;
import model.dao.Ano_DAO;

/**
 *
 * @author Gysa
 */
public class Ano_Controller {
    Ano_DAO ad = new Ano_DAO();
    List lista;
    Ano ano = new Ano();
    boolean teste;
    public boolean inserir (Ano ano){
        teste = ad.inserir(ano);
        return teste;
    }
    
    public boolean alterar(Ano ano){
        teste = ad.alterar(ano);
        return teste;
    }
    
    public boolean excluir(int ano){
        teste = ad.excluir(ano);
        return teste;
    }
    
    public List<Ano> getAnoList(String ano){
        lista = ad.getAnoList(ano);
        return lista;
    }
    
}
