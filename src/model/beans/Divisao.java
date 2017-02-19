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
public class Divisao {
    private int div_Codigo;
    private String div_Nome;
    private String div_Sigla;
    private String sn_principal;
    
   

    public int getDiv_Codigo() {
        return div_Codigo;
    }

    public void setDiv_Codigo(int div_Codigo) {
        this.div_Codigo = div_Codigo;
    }

    public String getDiv_Nome() {
        return div_Nome;
    }

    public void setDiv_Nome(String div_Nome) {
        this.div_Nome = div_Nome;
    }

    public String getDiv_Sigla() {
        return div_Sigla;
    }

    public void setDiv_Sigla(String div_Sigla) {
        this.div_Sigla = div_Sigla;
    }
    
    @Override
    public String toString(){
        return div_Nome;
    }

    public String getSn_principal() {
        return sn_principal;
    }

    public void setSn_principal(String sn_principal) {
        this.sn_principal = sn_principal;
    }
}
