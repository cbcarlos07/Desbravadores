/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Associacao;
import model.dao.Associacao_DAO;

/**
 *
 * @author Gysa
 */
public class Associacao_Controller {
    Associacao_DAO ud = new Associacao_DAO();
    List lista;
    Associacao associacao = new Associacao();
    boolean teste;
    public boolean inserir (Associacao associacao){
        teste = ud.inserir(associacao);
        return teste;
    }
    
    public boolean alterar(Associacao associacao){
        teste = ud.alterar(associacao);
        return teste;
    }
    
    public boolean excluir(int associacao){
        teste = ud.excluir(associacao);
        return teste;
    }
    
    public List<Associacao> getAssociacaoList(String associacao){
        lista = ud.getAssocList(associacao);
        return lista;
    }
    
    public List<Associacao> getSiglaList(String associacao){
        lista = ud.getSiglaList(associacao);
        return lista;
    }
    
    public Associacao getAssociacao(int codigo){
        associacao = ud.getAssociacao(codigo);
        return associacao;
    }
    
}
