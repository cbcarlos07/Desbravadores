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
import model.beans.Uniao;
import model.beans.Associacao;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Associacao_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Associacao associacao){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        if(associacao.getAssoc_sn_principal().equals("S")){
            principal();
        }
        sql = "{CALL PROC_ASSOCIACAO(NULL, ?,?,?,?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, associacao.getAssoc_Nome());
            stmt.setString(2, associacao.getAssoc_Sigla());            
            stmt.setInt(3, associacao.getUniao().getUniao_Codigo());
            stmt.setString(4, associacao.getAssoc_sn_principal());
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Assoc_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Associacao associacao){
        boolean teste = false;
        if(associacao.getAssoc_sn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ASSOCIACAO(?,?,?,?, ?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, associacao.getAssoc_Codigo());
            stmt.setString(2, associacao.getAssoc_Nome());
            stmt.setString(3, associacao.getAssoc_Sigla());
            stmt.setInt(4, associacao.getUniao().getUniao_Codigo());
            stmt.setString(5, associacao.getAssoc_sn_principal());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Assoc_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    public boolean principal (){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ASSOCIACAO(NULL,NULL,NULL,NULL,NULL, 'P')}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Assoc_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    public boolean excluir (int associacao){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ASSOCIACAO(?, NULL,NULL,NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, associacao);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Assoc_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public List<Associacao> getAssocList(String str_associacao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_associacao.equals("")){
                sql = "{CALL PROC_ASSOCIACAO(NULL, NULL,NULL,NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                //System.out.println("Proc: {CALL PROC_ASSOCIACAO(NULL,?,NULL,NULL, 'N')}: "+str_associacao);
                sql = "{CALL PROC_ASSOCIACAO(NULL,?,NULL,NULL,NULL, 'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_associacao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Associacao associacao = new Associacao();
                associacao.setAssoc_Codigo(resulSet.getInt(1));
                associacao.setAssoc_Nome(resulSet.getString(2));
                associacao.setAssoc_Sigla(resulSet.getString(3));
                associacao.setUniao(new Uniao());
                associacao.getUniao().setUniao_Codigo(resulSet.getInt(4));
                associacao.getUniao().setUniao_Nome(resulSet.getString(7));
                associacao.setAssoc_sn_principal(resulSet.getString(5));
                lista.add(associacao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Associacao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public List<Associacao> getSiglaList(String str_associacao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_associacao.equals("")){
                sql = "{CALL PROC_ASSOCIACAO(NULL, NULL,NULL,NULL,NULL, 'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                System.out.println("Proc: {CALL PROC_ASSOCIACAO(NULL, NULL,?,NULL,NULL'S')}  : "+str_associacao);
                sql = "{CALL PROC_ASSOCIACAO(NULL, NULL,?,NULL,'S')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_associacao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Associacao associacao = new Associacao();
                associacao.setAssoc_Codigo(resulSet.getInt(1));
                associacao.setAssoc_Nome(resulSet.getString(2));
                associacao.setAssoc_Sigla(resulSet.getString(3));
                associacao.setUniao(new Uniao());
                associacao.getUniao().setUniao_Codigo(resulSet.getInt(4));
                associacao.getUniao().setUniao_Nome(resulSet.getString(7));
                associacao.setAssoc_sn_principal(resulSet.getString(5));
                lista.add(associacao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Associacao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public Associacao getAssociacao(int codigo){
        Associacao associacao = new Associacao();
        sql = "{CALL PROC_ASSOCIACAO(?,NULL,NULL,NULL,NULL,'C')}";
        connection =  ConnectionFactory.getConnection();
        try {
            stmt = connection.prepareCall(sql);
            stmt.setObject(1, codigo);
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                associacao.setAssoc_Codigo(resulSet.getInt(1));
                associacao.setAssoc_Nome(resulSet.getString(2));
                associacao.setAssoc_Sigla(resulSet.getString(3));
                associacao.setUniao(new Uniao());
                associacao.getUniao().setUniao_Codigo(resulSet.getInt(4));
                associacao.getUniao().setUniao_Nome(resulSet.getString(7));
                associacao.setAssoc_sn_principal(resulSet.getString(5));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Associacao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return associacao;
    }
    
} //fim da classes
