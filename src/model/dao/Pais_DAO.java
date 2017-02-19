/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Pais;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Pais_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Pais pais){
        boolean teste = false;
        
        
        sql = "{CALL PROC_PAIS(NULL, ?,?,'I')}";
        if(pais.getPais_sn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, pais.getPais_Descricao());
            stmt.setString(2, pais.getPais_sn_principal());
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Pais_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Pais pais){
        boolean teste = false;
        
        principal();
        connection = ConnectionFactory.getConnection();
        sql = "{CALL PROC_PAIS(?, ?,?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, pais.getPais_Codigo());
            stmt.setString(2, pais.getPais_Descricao());
            stmt.setString(3, pais.getPais_sn_principal());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pais_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    public boolean principal (){
        //TORNANDO DOS PAIS NÃO PRINCIPAIS
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_PAIS(NULL, NULL,NULL,'P')}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pais_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int pais){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_PAIS(?, NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, pais);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pais_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Pais> getPaisList(String str_pais){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_pais.equals("")){
                sql = "{CALL PROC_PAIS(NULL, NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_PAIS(NULL, ?,NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_pais);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Pais pais = new Pais();
                pais.setPais_Codigo(resulSet.getInt(1));
                pais.setPais_Descricao(resulSet.getString(2));
                pais.setPais_sn_principal(resulSet.getString(3));
                lista.add(pais);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pais_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
} //fim da classes
