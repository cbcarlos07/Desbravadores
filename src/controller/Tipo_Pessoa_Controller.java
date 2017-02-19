/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.beans.Tipo_Pessoa;
import model.dao.Tipo_Pessoa_DAO;

/**
 *
 * @author Gysa
 */
public class Tipo_Pessoa_Controller {
    Tipo_Pessoa_DAO ad = new Tipo_Pessoa_DAO();
    List lista;
    Tipo_Pessoa tipo_Pessoa = new Tipo_Pessoa();
    boolean teste;
    public boolean inserir (Tipo_Pessoa tipo_Pessoa){
        teste = ad.inserir(tipo_Pessoa);
        return teste;
    }
    
    public boolean alterar(Tipo_Pessoa tipo_Pessoa){
        teste = ad.alterar(tipo_Pessoa);
        return teste;
    }
    
    public boolean excluir(int tipo_Pessoa){
        teste = ad.excluir(tipo_Pessoa);
        return teste;
    }
    
    public List<Tipo_Pessoa> getTipo_PessoaList(String tipo_Pessoa){
        lista = ad.getTipo_PessoaList(tipo_Pessoa);
        return lista;
    }
    
}
