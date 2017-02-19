/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Estado;
import model.dao.Estado_DAO;

/**
 *
 * @author Gysa
 */
public class Estado_Controller {
    Estado_DAO ad = new Estado_DAO();
    List lista;
    Estado estado = new Estado();
    boolean teste;
    public boolean inserir (Estado estado){
        teste = ad.inserir(estado);
        return teste;
    }
    
    public boolean alterar(Estado estado){
        teste = ad.alterar(estado);
        return teste;
    }
    
    public boolean excluir(int estado){
        teste = ad.excluir(estado);
        return teste;
    }
    
    public List<Estado> getEstadoList(String estado){
        lista = ad.getEstadoList(estado);
        return lista;
    }
    
    public List<Estado> getEstadoSiglaList(String estado){
        lista = ad.getEstadoSiglaList(estado);
        return lista;
    }
    
    public Estado getEstado(int cd_estado){
        estado = ad.getEstado(cd_estado);
        return estado;
    }
}
