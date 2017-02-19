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
import model.beans.Associacao;
import model.beans.Distrito;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Distrito_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Distrito distrito){
        boolean teste = false;
        if(distrito.getSn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DISTRITO(NULL, ?,?,?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, distrito.getDistrito());
            stmt.setString(2, distrito.getSn_principal());
            stmt.setInt(3, distrito.getAssociacao().getAssoc_Codigo());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Distrito_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Distrito distrito){
        boolean teste = false;
        if(distrito.getSn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DISTRITO(?,?,?,?, 'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, distrito.getCodigo());
            stmt.setString(2, distrito.getDistrito());
            stmt.setString(3, distrito.getSn_principal());
            stmt.setInt(4, distrito.getAssociacao().getAssoc_Codigo());
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Distrito_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    public boolean principal (){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DISTRITO(NULL,NULL,NULL,NULL, 'S')}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Distrito_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    public boolean excluir (int distrito){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DISTRITO(?, NULL,NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, distrito);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Distrito_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public List<Distrito> getDistritoList(String str_distrito){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_distrito.equals("")){
                sql = "{CALL PROC_DISTRITO(NULL, NULL,NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                
                sql = "{CALL PROC_DISTRITO(NULL,?,NULL, NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_distrito);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Distrito distrito = new Distrito();
                distrito.setCodigo(resulSet.getInt(1));
                distrito.setDistrito(resulSet.getString(2));
                distrito.setAssociacao(new Associacao());
                distrito.getAssociacao().setAssoc_Codigo(resulSet.getInt(3));
                distrito.getAssociacao().setAssoc_Nome(resulSet.getString(6));
                distrito.setSn_principal(resulSet.getString(4));
                
                lista.add(distrito);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Distrito_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    
    public Distrito getDistrito(int codigo){
        Distrito distrito = new Distrito();
        sql = "{CALL PROC_DISTRITO(?,NULL,NULL,NULL,'C')}";
        connection =  ConnectionFactory.getConnection();
        try {
            stmt = connection.prepareCall(sql);
            stmt.setObject(1, codigo);
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                
                distrito.setCodigo(resulSet.getInt(1));
                distrito.setDistrito(resulSet.getString(2));
                distrito.setAssociacao(new Associacao());
                distrito.getAssociacao().setAssoc_Codigo(resulSet.getInt(3));
                distrito.getAssociacao().setAssoc_Nome(resulSet.getString(6));
                distrito.setSn_principal(resulSet.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Distrito_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return distrito;
    }
    
} //fim da classes
