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
import model.beans.Bairro;
import model.beans.Cidade;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Bairro_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Bairro bairro){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_BAIRRO(NULL, ?,?, 'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, bairro.getNm_bairro());
            stmt.setInt(2, bairro.getCidade_Codigo());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Bairro_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Bairro bairro){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_BAIRRO(?, ?,?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, bairro.getCd_bairro());
            stmt.setString(2, bairro.getNm_bairro());
            stmt.setInt(3, bairro.getCidade_Codigo());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bairro_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int bairro){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_BAIRRO(?, NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, bairro);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bairro_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Bairro> getBairroList(String str_bairro){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_bairro.equals("")){
                sql = "{CALL PROC_BAIRRO(NULL, NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_BAIRRO(NULL, ?,NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_bairro);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Bairro bairro = new Bairro();
                bairro.setCd_bairro(resulSet.getInt(1));
                bairro.setNm_bairro(resulSet.getString(2));
                bairro.setCidade_Codigo(resulSet.getInt(3));
                bairro.setCidade_Descricao(resulSet.getString(5));
                
                lista.add(bairro);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bairro_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public List<Bairro> getBairroList(String str_bairro, int cidade){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_bairro.equals("")){
                sql = "{CALL PROC_BAIRRO(NULL, NULL,?,'P')}";
                stmt = connection.prepareCall(sql);
                stmt.setInt(1, cidade);
                
            }else{
                sql = "{CALL PROC_BAIRRO(NULL, ?,?,'B')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_bairro);
                stmt.setInt(2, cidade);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Bairro bairro = new Bairro();
                bairro.setCd_bairro(resulSet.getInt(1));
                bairro.setNm_bairro(resulSet.getString(2));
                bairro.setCidade_Codigo(resulSet.getInt(3));
                bairro.setCidade_Descricao(resulSet.getString(5));
                
                lista.add(bairro);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bairro_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    
    public Bairro getBairro(int str_bairro){
        Bairro bairro = null;
        connection =  ConnectionFactory.getConnection();
        try {
            
                sql = "{CALL PROC_BAIRRO(?, NULL,NULL,'C')}";
                stmt = connection.prepareCall(sql);
                stmt.setInt(1, str_bairro);
            
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                bairro = new Bairro();
                bairro.setCd_bairro(resulSet.getInt(1));
                bairro.setNm_bairro(resulSet.getString(2));
                bairro.setCidade_Codigo(resulSet.getInt(3));
                bairro.setCidade_Descricao(resulSet.getString(5));
               
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bairro_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bairro;
    }
    
} //fim da classes
