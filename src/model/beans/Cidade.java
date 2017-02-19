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
public class Cidade {
    private int cidade_Codigo;
    private String cidade_Descricao;
    private Estado estado;
    private String cidade_sn_principal;
    

    public int getCidade_Codigo() {
        return cidade_Codigo;
    }

    public void setCidade_Codigo(int cidade_Codigo) {
        this.cidade_Codigo = cidade_Codigo;
    }

    public String getCidade_Descricao() {
        return cidade_Descricao;
    }

    public void setCidade_Descricao(String cidade_Descricao) {
        this.cidade_Descricao = cidade_Descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return cidade_Descricao;
    }

    public String getCidade_sn_principal() {
        return cidade_sn_principal;
    }

    public void setCidade_sn_principal(String cidade_sn_principal) {
        this.cidade_sn_principal = cidade_sn_principal;
    }
}
