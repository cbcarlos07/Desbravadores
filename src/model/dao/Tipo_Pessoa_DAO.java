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
import model.beans.Tipo_Pessoa;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Tipo_Pessoa_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Tipo_Pessoa tipo_Pessoa){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_TIPO_PESSOA(NULL, ?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, tipo_Pessoa.getTipo_Pessoa_Descricao());
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Tipo_Pessoa_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Tipo_Pessoa tipo_Pessoa){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_TIPO_PESSOA(?, ?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, tipo_Pessoa.getTipo_Pessoa_Codigo());
            stmt.setString(2, tipo_Pessoa.getTipo_Pessoa_Descricao());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Pessoa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean excluir (int tipo_Pessoa){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_TIPO_PESSOA(?, NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, tipo_Pessoa);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Pessoa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Tipo_Pessoa> getTipo_PessoaList(String str_tipo_Pessoa){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_tipo_Pessoa.equals("")){
                sql = "{CALL PROC_TIPO_PESSOA(NULL, NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_TIPO_PESSOA(NULL, ?,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_tipo_Pessoa);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Tipo_Pessoa tipo_Pessoa = new Tipo_Pessoa();
                tipo_Pessoa.setTipo_Pessoa_Codigo(resulSet.getInt(1));
                tipo_Pessoa.setTipo_Pessoa_Descricao(resulSet.getString(2));
                
                lista.add(tipo_Pessoa);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Pessoa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
} //fim da classes
