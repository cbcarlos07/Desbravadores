/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Cidade;
import model.dao.Cidade_DAO;

/**
 *
 * @author Gysa
 */
public class Cidade_Controller {
    Cidade_DAO ad = new Cidade_DAO();
    List lista;
    Cidade cidade = new Cidade();
    boolean teste;
    public boolean inserir (Cidade cidade){
        teste = ad.inserir(cidade);
        return teste;
    }
    
    public boolean alterar(Cidade cidade){
        teste = ad.alterar(cidade);
        return teste;
    }
    
    public boolean excluir(int cidade){
        teste = ad.excluir(cidade);
        return teste;
    }
    
    public List<Cidade> getCidadeList(String cidade){
        lista = ad.getCidadeList(cidade);
        return lista;
    }
    
    public List<Cidade> getCidadeList(String cidade, int estado){
        lista = ad.getCidadeList(cidade, estado);
        return lista;
    }
    
    public Cidade getCidade(int cid){
        cidade = ad.getCidade(cid);
        return cidade;
    }
    public int getCdEstado(int cd_cidade){
        int cd = ad.getCdEstado(cd_cidade);
        return cd;
    }
}
