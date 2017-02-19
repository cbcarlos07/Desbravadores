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
import model.beans.Uniao;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Uniao_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Uniao uniao){
        boolean teste = false;
        if(uniao.getSn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_UNIAO(NULL, ?,?,?,?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, uniao.getUniao_Nome());
            stmt.setString(2, uniao.getUniao_Sigla());
            stmt.setInt(3, uniao.getDivisao().getDiv_Codigo());   
            stmt.setString(4, uniao.getSn_principal());
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Uniao uniao){
        boolean teste = false;
        if(uniao.getSn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_UNIAO(?,?,?,?,?, 'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, uniao.getUniao_Codigo());
            stmt.setString(2, uniao.getUniao_Nome());
            stmt.setString(3, uniao.getUniao_Sigla());
            stmt.setInt(4, uniao.getDivisao().getDiv_Codigo());
            stmt.setString(5, uniao.getSn_principal());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    public boolean principal (){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_UNIAO(NULL,NULL,NULL,NULL,NULL, 'P')}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    public boolean excluir (int uniao){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_UNIAO(?, NULL,NULL,NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, uniao);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public List<Uniao> getUniaoList(String str_uniao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_uniao.equals("")){
                sql = "{CALL PROC_UNIAO(NULL, NULL,NULL,NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                //System.out.println("Proc: {CALL PROC_UNIAO(NULL,?,NULL,NULL, 'N')}: "+str_uniao);
                sql = "{CALL PROC_UNIAO(NULL,?,NULL,NULL,NULL, 'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_uniao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Uniao uniao = new Uniao();
                uniao.setUniao_Codigo(resulSet.getInt(1));
                uniao.setUniao_Nome(resulSet.getString(2));
                uniao.setUniao_Sigla(resulSet.getString(3));
                uniao.setDivisao(new Divisao());
                uniao.getDivisao().setDiv_Codigo(resulSet.getInt(4));
                uniao.getDivisao().setDiv_Nome(resulSet.getString(7));
                uniao.setSn_principal(resulSet.getString(5));
                lista.add(uniao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public List<Uniao> getSiglaList(String str_uniao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_uniao.equals("")){
                sql = "{CALL PROC_UNIAO(NULL, NULL,NULL,NULL,NULL, 'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                System.out.println("Proc: {CALL PROC_UNIAO(NULL, NULL,?,NULL,NULL,'S')}  : "+str_uniao);
                sql = "{CALL PROC_UNIAO(NULL, NULL,?,NULL,NULL,'S')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_uniao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Uniao uniao = new Uniao();
                uniao.setUniao_Codigo(resulSet.getInt(1));
                uniao.setUniao_Nome(resulSet.getString(2));
                uniao.setUniao_Sigla(resulSet.getString(3));
                uniao.setDivisao(new Divisao());
                uniao.getDivisao().setDiv_Codigo(resulSet.getInt(4));
                uniao.getDivisao().setDiv_Nome(resulSet.getString(7));
                uniao.setSn_principal(resulSet.getString(5));
                lista.add(uniao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public Uniao getUniao(int codigo){
        Uniao uniao = new Uniao();
        sql = "{CALL PROC_UNIAO(?,NULL,NULL,NULL,NULL,'C')}";
        connection =  ConnectionFactory.getConnection();
        try {
            stmt = connection.prepareCall(sql);
            stmt.setObject(1, codigo);
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                uniao.setUniao_Codigo(resulSet.getInt(1));
                uniao.setUniao_Nome(resulSet.getString(2));
                uniao.setUniao_Sigla(resulSet.getString(3));
                uniao.setDivisao(new Divisao());
                uniao.getDivisao().setDiv_Codigo(resulSet.getInt(4));
                uniao.getDivisao().setDiv_Nome(resulSet.getString(7));
                uniao.setSn_principal(resulSet.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Uniao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uniao;
    }
    
} //fim da classes
