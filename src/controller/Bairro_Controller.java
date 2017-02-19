/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Bairro;
import model.dao.Bairro_DAO;

/**
 *
 * @author Gysa
 */
public class Bairro_Controller {
    Bairro_DAO ad = new Bairro_DAO();
    List lista;
    Bairro bairro = new Bairro();
    boolean teste;
    public boolean inserir (Bairro bairro){
        teste = ad.inserir(bairro);
        return teste;
    }
    
    public boolean alterar(Bairro bairro){
        teste = ad.alterar(bairro);
        return teste;
    }
    
    public boolean excluir(int bairro){
        teste = ad.excluir(bairro);
        return teste;
    }
    
    public List<Bairro> getBairroList(String bairro){
        lista = ad.getBairroList(bairro);
        return lista;
    }
    
    public List<Bairro> getBairroList(String bairro, int estado){
        lista = ad.getBairroList(bairro, estado);
        return lista;
    }
    
    public Bairro getBairro(int cid){
        bairro = ad.getBairro(cid);
        return bairro;
    }
    
}
