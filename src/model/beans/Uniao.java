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
public class Uniao {
    private int uniao_Codigo;
    private String uniao_Nome;
    private String uniao_Sigla;
    private Divisao divisao;
    private String sn_principal;
    
    

    public int getUniao_Codigo() {
        return uniao_Codigo;
    }

    public void setUniao_Codigo(int uniao_Codigo) {
        this.uniao_Codigo = uniao_Codigo;
    }

    public String getUniao_Nome() {
        return uniao_Nome;
    }

    public void setUniao_Nome(String uniao_Nome) {
        this.uniao_Nome = uniao_Nome;
    }

    public String getUniao_Sigla() {
        return uniao_Sigla;
    }

    public void setUniao_Sigla(String uniao_Sigla) {
        this.uniao_Sigla = uniao_Sigla;
    }

    public Divisao getDivisao() {
        return divisao;
    }

    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
    }
    
    @Override
    public String toString(){
        return uniao_Nome;
    }

    public String getSn_principal() {
        return sn_principal;
    }

    public void setSn_principal(String sn_principal) {
        this.sn_principal = sn_principal;
    }
            
}
