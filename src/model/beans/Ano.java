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
public class Ano {
    private int ano_Codigo;
    private String desc_Ano;

    public int getAno_Codigo() {
        return ano_Codigo;
    }

    public void setAno_Codigo(int ano_Codigo) {
        this.ano_Codigo = ano_Codigo;
    }

    public String getDesc_Ano() {
        return desc_Ano;
    }

    public void setDesc_Ano(String desc_Ano) {
        this.desc_Ano = desc_Ano;
    }
    
    public String toString(){
        return desc_Ano;
    }
}
