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
import model.beans.Cep;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class CEP_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Cep cep){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_CEP_ENDERECO(?,?,?,?,?,?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, cep.getCep());
            stmt.setString(2, cep.getLogradouro());
            stmt.setString(3, cep.getTipo_logradouro());
            stmt.setString(4, cep.getComplemento());
            stmt.setInt(5, cep.getCidade().getCidade_Codigo());
            stmt.setInt(6, cep.getBairro().getCd_bairro());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Cep_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Cep cep){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_CEP_ENDERECO(?,?,?,?,?,?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
           
            stmt.setString(1, cep.getCep());
            stmt.setString(2, cep.getLogradouro());
            stmt.setString(3, cep.getTipo_logradouro());
            stmt.setString(4, cep.getComplemento());
            stmt.setInt(5, cep.getCidade().getCidade_Codigo());
            stmt.setInt(6, cep.getBairro().getCd_bairro());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int cep){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_CEP_ENDERECO(?,?,?,?,?,?,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, cep);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Cep> getCepList(int opcao, int cidade, int bairro, String texto){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(opcao == 1){
                if(cidade == 0){
                
                    sql = "{CALL PROC_CEP_ENDERECO(NULL,NULL,NULL,NULL,NULL,NULL,'T')}";
                    stmt = connection.prepareCall(sql);
                    
                 }else if(cidade > 0 && bairro == 0){
                    sql = "{CALL PROC_CEP_ENDERECO(?,NULL,NULL,NULL,?,NULL,'H')}";
                    stmt = connection.prepareCall(sql);
                    stmt.setString(1, texto);
                    stmt.setInt(2, cidade);
                }else if(cidade > 0 && bairro > 0){
                    sql = "{CALL PROC_CEP_ENDERECO(?,NULL,NULL,NULL,?,?,'P')}";
                    stmt = connection.prepareCall(sql);
                    stmt.setString(1, texto);
                    stmt.setInt(2, cidade);
                    stmt.setInt(3, bairro);
                }   
                    
             }else {
                if(cidade == 0){
                
                    sql = "{CALL PROC_CEP_ENDERECO(NULL,NULL,NULL,NULL,NULL,NULL,'T')}";
                    stmt = connection.prepareCall(sql);
                    
                 }else if(cidade > 0 && bairro == 0){
                    sql = "{CALL PROC_CEP_ENDERECO(NULL,?,NULL,NULL,?,NULL,'G')}";
                    stmt = connection.prepareCall(sql);
                    stmt.setString(1, texto);
                    stmt.setInt(2, cidade);
                }else if(cidade > 0 && bairro > 0){
                    sql = "{CALL PROC_CEP_ENDERECO(NULL,?,NULL,NULL,?,?,'F')}";
                    stmt = connection.prepareCall(sql);
                    stmt.setString(1, texto);
                    stmt.setInt(2, cidade);
                    stmt.setInt(3, bairro);
                }
            }
            
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Cep cep = new Cep();
                cep.setCep(resulSet.getString("DS_CEP"));
                cep.setLogradouro(resulSet.getString("DS_LOGRADOURO"));
                cep.setTipo_logradouro(resulSet.getString("TIPO_LOGRADOURO"));
                cep.setComplemento(resulSet.getString("DS_COMPLEMENTO"));
                
                lista.add(cep);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
} //fim da classes
