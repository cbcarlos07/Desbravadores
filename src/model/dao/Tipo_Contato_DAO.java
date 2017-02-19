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
import model.beans.Tipo_Contato;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Tipo_Contato_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Tipo_Contato tipo_Contato){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_TIPO_CONTATO(NULL, ?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, tipo_Contato.getTipo_Contato_Descricao());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Tipo_Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Tipo_Contato tipo_Contato){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_TIPO_CONTATO(?, ?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, tipo_Contato.getTipo_Contato_Codigo());
            stmt.setString(2, tipo_Contato.getTipo_Contato_Descricao());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int tipo_Contato){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_TIPO_CONTATO(?, NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, tipo_Contato);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Tipo_Contato> getTipo_ContatoList(String str_tipo_Contato){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_tipo_Contato.equals("")){
                sql = "{CALL PROC_TIPO_CONTATO(NULL, NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_TIPO_CONTATO(NULL, ?,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_tipo_Contato);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Tipo_Contato tipo_Contato = new Tipo_Contato();
                tipo_Contato.setTipo_Contato_Codigo(resulSet.getInt(1));
                tipo_Contato.setTipo_Contato_Descricao(resulSet.getString(2));
                
                lista.add(tipo_Contato);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
} //fim da classes
