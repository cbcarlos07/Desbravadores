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
import model.beans.Divisao;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Divisao_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Divisao divisao){
        boolean teste = false;
        if(divisao.getSn_principal().equals("S")){
         principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DIVISAO(NULL, ?,?,?,?)}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, divisao.getDiv_Nome());
            stmt.setString(2, divisao.getDiv_Sigla());
            stmt.setString(3, divisao.getSn_principal());
            stmt.setString(4, "I");
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Divisao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Divisao divisao){
        boolean teste = false;
        if(divisao.getSn_principal().equals("S")){
         principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DIVISAO(?, ?,?,?,?)}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, divisao.getDiv_Codigo());
            stmt.setString(2, divisao.getDiv_Nome());
            stmt.setString(3, divisao.getDiv_Sigla());
            stmt.setString(4, divisao.getSn_principal());
            stmt.setString(5, "A");
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Divisao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean principal (){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DIVISAO(NULL, NULL,NULL,NULL,?)}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            stmt.setString(1, "P");
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Divisao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int divisao){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_DIVISAO(?, NULL,NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, divisao);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Divisao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Divisao> getDivisaoList(String str_divisao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_divisao.equals("")){
                sql = "{CALL PROC_DIVISAO(NULL, NULL,NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_DIVISAO(NULL, ?,NULL,NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_divisao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Divisao divisao = new Divisao();
                divisao.setDiv_Codigo(resulSet.getInt(1));
                divisao.setDiv_Nome(resulSet.getString(2));
                divisao.setDiv_Sigla(resulSet.getString(3));
                divisao.setSn_principal(resulSet.getString(4));
                lista.add(divisao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Divisao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public List<Divisao> getSiglaList(String str_divisao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_divisao.equals("")){
                sql = "{CALL PROC_DIVISAO(NULL, NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_DIVISAO(NULL, NULL,?,'S')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_divisao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Divisao divisao = new Divisao();
                divisao.setDiv_Codigo(resulSet.getInt(1));
                divisao.setDiv_Nome(resulSet.getString(2));
                divisao.setDiv_Sigla(resulSet.getString(3));
                divisao.setSn_principal(resulSet.getString(4));
                lista.add(divisao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Divisao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
} //fim da classes
