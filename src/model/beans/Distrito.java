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
public class Distrito {
    private int codigo;
    private String distrito;
    private Associacao associacao;
    private String sn_principal;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Associacao getAssociacao() {
        return associacao;
    }

    public void setAssociacao(Associacao associacao) {
        this.associacao = associacao;
    }
    
    public String toString(){
        return distrito;
    }

    public String getSn_principal() {
        return sn_principal;
    }

    public void setSn_principal(String sn_principal) {
        this.sn_principal = sn_principal;
    }
    
}
