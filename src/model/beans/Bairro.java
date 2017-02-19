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
public class Bairro extends Cidade{
    private int cd_bairro;
    private String nm_bairro;

    public int getCd_bairro() {
        return cd_bairro;
    }

    public void setCd_bairro(int cd_bairro) {
        this.cd_bairro = cd_bairro;
    }

    public String getNm_bairro() {
        return nm_bairro;
    }

    public void setNm_bairro(String nm_bairro) {
        this.nm_bairro = nm_bairro;
    }
    
    @Override
    public String toString(){
        return nm_bairro;
    }
}
