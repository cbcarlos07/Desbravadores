/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Tipo_Contato;
import model.dao.Tipo_Contato_DAO;

/**
 *
 * @author Gysa
 */
public class Tipo_Contato_Controller {
    Tipo_Contato_DAO ad = new Tipo_Contato_DAO();
    List lista;
    Tipo_Contato tipo_Contato = new Tipo_Contato();
    boolean teste;
    public boolean inserir (Tipo_Contato tipo_Contato){
        teste = ad.inserir(tipo_Contato);
        return teste;
    }
    
    public boolean alterar(Tipo_Contato tipo_Contato){
        teste = ad.alterar(tipo_Contato);
        return teste;
    }
    
    public boolean excluir(int tipo_Contato){
        teste = ad.excluir(tipo_Contato);
        return teste;
    }
    
    public List<Tipo_Contato> getTipo_ContatoList(String tipo_Contato){
        lista = ad.getTipo_ContatoList(tipo_Contato);
        return lista;
    }
    
}
