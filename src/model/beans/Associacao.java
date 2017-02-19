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
public class Associacao {
    private int assoc_Codigo;
    private String assoc_Nome;
    private String assoc_Sigla;
    private Uniao uniao;
    private String assoc_sn_principal;
    

    public int getAssoc_Codigo() {
        return assoc_Codigo;
    }

    public void setAssoc_Codigo(int assoc_Codigo) {
        this.assoc_Codigo = assoc_Codigo;
    }

    public String getAssoc_Nome() {
        return assoc_Nome;
    }

    public void setAssoc_Nome(String assoc_Nome) {
        this.assoc_Nome = assoc_Nome;
    }

    public String getAssoc_Sigla() {
        return assoc_Sigla;
    }

    public void setAssoc_Sigla(String assoc_Sigla) {
        this.assoc_Sigla = assoc_Sigla;
    }

    public Uniao getUniao() {
        return uniao;
    }

    public void setUniao(Uniao uniao) {
        this.uniao = uniao;
    }
    
    @Override
    public String toString(){
        return assoc_Nome;
    }

    public String getAssoc_sn_principal() {
        return assoc_sn_principal;
    }

    public void setAssoc_sn_principal(String assoc_sn_principal) {
        this.assoc_sn_principal = assoc_sn_principal;
    }
}
