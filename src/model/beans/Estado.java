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
public class Estado {
    private int estado_Codigo;
    private String estado_Nome;
    private String estado_Sigla;
    private Pais pais;
    private String estado_sn_principal;

    public int getEstado_Codigo() {
        return estado_Codigo;
    }

    public void setEstado_Codigo(int estado_Codigo) {
        this.estado_Codigo = estado_Codigo;
    }

    public String getEstado_Nome() {
        return estado_Nome;
    }

    public void setEstado_Nome(String estado_Nome) {
        this.estado_Nome = estado_Nome;
    }

    public String getEstado_Sigla() {
        return estado_Sigla;
    }

    public void setEstado_Sigla(String estado_Sigla) {
        this.estado_Sigla = estado_Sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString(){
        return estado_Nome;
    }

    public String getEstado_sn_principal() {
        return estado_sn_principal;
    }

    public void setEstado_sn_principal(String estado_sn_principal) {
        this.estado_sn_principal = estado_sn_principal;
    }
    
}
