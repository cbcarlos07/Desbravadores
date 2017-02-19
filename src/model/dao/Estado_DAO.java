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
import model.beans.Estado;
import model.beans.Pais;
import servicos.MensagemErro;
import model.connection.ConnectionFactory;

/**
 *
 * @author Gysa
 */
public class Estado_DAO {
    List lista;
    PreparedStatement stmt;
    ResultSet resulSet;
    Connection connection;
    String sql;
    
    
    public boolean inserir (Estado estado){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ESTADO(NULL, ?,?,?,?,'I')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setString(1, estado.getEstado_Nome());
            stmt.setString(2, estado.getEstado_Sigla());
            stmt.setString(3, estado.getEstado_sn_principal());
            stmt.setInt(4, estado.getPais().getPais_Codigo());
            
            
            stmt.execute();
            teste = true; //inserido com sucesso
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
            MensagemErro.mensagem = ex.getMessage();
        }
        return teste;
    }
    
    
    public boolean alterar (Estado estado){
        boolean teste = false;
        principal(estado.getPais().getPais_Codigo());
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ESTADO(?, ?,?,?,?,'A')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, estado.getEstado_Codigo());
            stmt.setString(2, estado.getEstado_Nome());
            stmt.setString(3, estado.getEstado_Sigla());
            stmt.setString(4, estado.getEstado_sn_principal());
            stmt.setInt(5, estado.getPais().getPais_Codigo());
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public boolean principal (int pais){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ESTADO(NULL, NULL,NULL,NULL,?,'P')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, pais);
            stmt.execute();
            teste = true; //alterado com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    public boolean excluir (int estado){
        boolean teste = false;
        connection = ConnectionFactory.getConnection();
        
        sql = "{CALL PROC_ESTADO(?, NULL,NULL,NULL,'E')}";
        
        try {
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, estado);
            stmt.execute();
            teste = true; //excluido com sucesso
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public List<Estado> getEstadoList(String str_estado){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_estado.equals("")){
                sql = "{CALL PROC_ESTADO(NULL, NULL,NULL, NULL,NULL, 'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_ESTADO(NULL, ?,NULL,NULL,NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_estado);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Estado estado = new Estado();
                estado.setEstado_Codigo(resulSet.getInt(1));
                estado.setEstado_Nome(resulSet.getString(2));
                estado.setEstado_Sigla(resulSet.getString(3));
                estado.setPais(new Pais());
                estado.getPais().setPais_Codigo(resulSet.getInt(4));
                estado.getPais().setPais_Descricao(resulSet.getString(7));
                estado.setEstado_sn_principal(resulSet.getString(5));
                lista.add(estado);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    public List<Estado> getEstadoSiglaList(String str_estado){
        lista = new ArrayList();
        connection =  ConnectionFactory.getConnection();
        try {
            if(str_estado.equals("")){
                sql = "{CALL PROC_ESTADO(NULL, NULL,NULL, NULL, NULL,'T')}";
                stmt = connection.prepareCall(sql);
                
            }else{
                sql = "{CALL PROC_ESTADO(NULL, NULL,?,NULL,NULL,'N')}";
                stmt = connection.prepareCall(sql);
                stmt.setString(1, str_estado);
            }
            resulSet = stmt.executeQuery();
            while(resulSet.next()){
                Estado estado = new Estado();
                estado.setEstado_Codigo(resulSet.getInt(1));
                estado.setEstado_Nome(resulSet.getString(2));
                estado.setEstado_Sigla(resulSet.getString(3));
                estado.setPais(new Pais());
                estado.getPais().setPais_Codigo(resulSet.getInt(4));
                estado.getPais().setPais_Descricao(resulSet.getString(7));
                estado.setEstado_sn_principal(resulSet.getString(5));
                lista.add(estado);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public Estado getEstado(int cd_estado){
        System.out.println("getEstado dao: "+cd_estado);
        Estado estado = null;
        connection =  ConnectionFactory.getConnection();
        try {
            
                sql = "{CALL PROC_ESTADO(?, NULL,NULL, NULL, NULL, 'C')}";
                stmt = connection.prepareCall(sql);
                stmt.setInt(1, cd_estado);
            
            resulSet = stmt.executeQuery();
            if(resulSet.next()){
                estado = new Estado();
                estado.setEstado_Codigo(resulSet.getInt(1));
                estado.setEstado_Nome(resulSet.getString(2));
                estado.setEstado_Sigla(resulSet.getString(3));
                estado.setPais(new Pais());
                estado.getPais().setPais_Codigo(resulSet.getInt(4));
                estado.getPais().setPais_Descricao(resulSet.getString(7));
                estado.setEstado_sn_principal(resulSet.getString(5));
                
                
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estado;
    }
    
} //fim da classes
