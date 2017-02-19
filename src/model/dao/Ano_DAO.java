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
import model.beans.Ano;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Ano_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Ano ano){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ANO(NULL, ?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, ano.getDesc_Ano());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Ano_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Ano ano){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ANO(?, ?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, ano.getAno_Codigo());
            stmt.setString(2, ano.getDesc_Ano());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ano_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int ano){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ANO(?, NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, ano);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ano_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Ano> getAnoList(String str_ano){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_ano.equals("")){
                sql = "{CALL PROC_ANO(NULL, NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_ANO(NULL, ?,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_ano);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Ano ano = new Ano();
                ano.setAno_Codigo(resulSet.getInt(1));
                ano.setDesc_Ano(resulSet.getString(2));
                
                lista.add(ano);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ano_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
} //fim da classes
