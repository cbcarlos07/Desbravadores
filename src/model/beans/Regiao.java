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
public class Regiao {
       private int regiao_Codigo;
       private String nome_Regiao;
       private Distrito distrito;
       private String sn_principal;
       

    public int getRegiao_Codigo() {
        return regiao_Codigo;
    }

    public void setRegiao_Codigo(int regiao_Codigo) {
        this.regiao_Codigo = regiao_Codigo;
    }

    public String getNome_Regiao() {
        return nome_Regiao;
    }

    public void setNome_Regiao(String nome_Regiao) {
        this.nome_Regiao = nome_Regiao;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getSn_principal() {
        return sn_principal;
    }

    public void setSn_principal(String sn_principal) {
        this.sn_principal = sn_principal;
    }
       
       
}
