/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author Gysa
 */
public class Pais {
    private int pais_Codigo;
    private String pais_Descricao;
    private String pais_sn_principal;

    public int getPais_Codigo() {
        return pais_Codigo;
    }

    public void setPais_Codigo(int pais_Codigo) {
        this.pais_Codigo = pais_Codigo;
    }

    public String getPais_Descricao() {
        return pais_Descricao;
    }

    public void setPais_Descricao(String pais_Descricao) {
        this.pais_Descricao = pais_Descricao;
    }
    
    @Override
    public String toString(){
        return pais_Descricao;
    }

    public String getPais_sn_principal() {
        return pais_sn_principal;
    }

    public void setPais_sn_principal(String pais_sn_principal) {
        this.pais_sn_principal = pais_sn_principal;
    }
}
