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
import model.beans.Distrito;
import model.beans.Regiao;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Regiao_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Regiao regiao){
        boolean teste = false;
        if(regiao.getSn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_REGIAO(NULL, ?,?,?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, regiao.getNome_Regiao());
            stmt.setString(2, regiao.getSn_principal());
            stmt.setInt(3, regiao.getDistrito().getCodigo());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Regiao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Regiao regiao){
        boolean teste = false;
        if(regiao.getSn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_REGIAO(?,?,?,?, 'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, regiao.getRegiao_Codigo());
            stmt.setString(2, regiao.getNome_Regiao());
            stmt.setString(3, regiao.getSn_principal());
            stmt.setInt(4, regiao.getDistrito().getCodigo());
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Regiao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean principal (){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_REGIAO(NULL,NULL,NULL,NULL, 'P')}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Regiao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    public boolean excluir (int regiao){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_REGIAO(?, NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, regiao);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Regiao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public List<Regiao> getRegiaoList(String str_regiao){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_regiao.equals("")){
                sql = "{CALL PROC_REGIAO(NULL, NULL,NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                
                sql = "{CALL PROC_REGIAO(NULL,?,NULL, NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_regiao);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Regiao regiao = new Regiao();
                regiao.setRegiao_Codigo(resulSet.getInt(1));
                regiao.setNome_Regiao(resulSet.getString(2));
                regiao.setDistrito(new Distrito());
                regiao.getDistrito().setCodigo(resulSet.getInt(3));
                regiao.getDistrito().setDistrito(resulSet.getString(6));
                regiao.setSn_principal(resulSet.getString(4));
                lista.add(regiao);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Regiao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    
    public Regiao getRegiao(int codigo){
        Regiao regiao = new Regiao();
        sql = "{CALL PROC_REGIAO(?,NULL,NULL,NULL,'C')}";
        connection =  ConnectionFactory.getConnection();
        try {
            stmt = connection.prepareCall(sql);
            stmt.setObject(1, codigo);
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                
                regiao.setRegiao_Codigo(resulSet.getInt(1));
                regiao.setNome_Regiao(resulSet.getString(2));
                regiao.setDistrito(new Distrito());
                regiao.getDistrito().setCodigo(resulSet.getInt(3));
                regiao.getDistrito().setDistrito(resulSet.getString(6));
                regiao.setSn_principal(resulSet.getString(4));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Regiao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return regiao;
    }
    
} //fim da classes
