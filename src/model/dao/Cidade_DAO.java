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
import model.beans.Cidade;
import model.beans.Estado;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Cidade_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Cidade cidade){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        if(cidade.getCidade_sn_principal().equals("S")){
            principal();
        }
        sql = "{CALL PROC_CIDADE(NULL, ?,?,? 'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, cidade.getCidade_Descricao());
            stmt.setString(2, cidade.getCidade_sn_principal());
            stmt.setInt(3, cidade.getEstado().getEstado_Codigo());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    
    public boolean alterar (Cidade cidade){
        boolean teste = false;
        if(cidade.getCidade_sn_principal().equals("S")){
            principal();
        }
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_CIDADE(?, ?,?,?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, cidade.getCidade_Codigo());
            stmt.setString(2, cidade.getCidade_Descricao());
            stmt.setString(3, cidade.getCidade_sn_principal());
            stmt.setInt(4, cidade.getEstado().getEstado_Codigo());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    public boolean principal (){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_CIDADE(NULL, NULL,NULL,NULL,'S')}";
        
        try {
            stmt = connection.prepareCall(sql);
            
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    public boolean excluir (int cidade){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_CIDADE(?, NULL,NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, cidade);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Cidade> getCidadeList(String str_cidade){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_cidade.equals("")){
                sql = "{CALL PROC_CIDADE(NULL, NULL,NULL,NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_CIDADE(NULL, ?,NULL,NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_cidade);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Cidade cidade = new Cidade();
                cidade.setCidade_Codigo(resulSet.getInt(1));
                cidade.setCidade_Descricao(resulSet.getString(2));
                cidade.setEstado(new Estado());
                cidade.getEstado().setEstado_Codigo(resulSet.getInt(3));
                cidade.getEstado().setEstado_Nome(resulSet.getString(6));
                cidade.setCidade_sn_principal(resulSet.getString(4));
                lista.add(cidade);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public List<Cidade> getCidadeList(String str_cidade, int estado){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_cidade.equals("")){
                sql = "{CALL PROC_CIDADE(NULL, NULL,NULL,?,'P')}";
                stmt = connection.prepareCall(sql);
                stmt.setInt(1, estado);
                
            }else{
                sql = "{CALL PROC_CIDADE(NULL, ?,NULL,?,'B')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_cidade);
                stmt.setInt(2, estado);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Cidade cidade = new Cidade();
                cidade.setCidade_Codigo(resulSet.getInt(1));
                cidade.setCidade_Descricao(resulSet.getString(2));
                cidade.setEstado(new Estado());
                cidade.getEstado().setEstado_Codigo(resulSet.getInt(3));
                cidade.getEstado().setEstado_Nome(resulSet.getString(6));
                cidade.setCidade_sn_principal(resulSet.getString(4));
                
                lista.add(cidade);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    
    public Cidade getCidade(int str_cidade){
        Cidade cidade = null;
        connection =  ConnectionFactory.getConnection();
        try {
            
                sql = "{CALL PROC_CIDADE(?, NULL,NULL,NULL,'C')}";
                stmt = connection.prepareCall(sql);
                stmt.setInt(1, str_cidade);
            
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                cidade = new Cidade();
                cidade.setCidade_Codigo(resulSet.getInt(1));
                cidade.setCidade_Descricao(resulSet.getString(2));
                cidade.setEstado(new Estado());
                cidade.getEstado().setEstado_Codigo(resulSet.getInt(3));
                cidade.getEstado().setEstado_Nome(resulSet.getString(6));
                cidade.setCidade_sn_principal(resulSet.getString(4));
                
               
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cidade;
    }
    
    public int getCdEstado(int cd_cidade){
        int cd = 0;
       // System.out.println("Dao. cd cidade: "+cd_cidade );
        connection = ConnectionFactory.getConnection();
        sql = "SELECT C.CD_ESTADO FROM CIDADE C WHERE C.CD_CIDADE = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cd_cidade);
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                cd = resulSet.getInt(1);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cidade_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cd;
    }
    
} //fim da classes
