/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Ano_Controller;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.beans.Ano;
import servicos.MensagemErro;

/**
 *
 * @author Gysa
 */
public class TelaCadAno extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadAno
     * @param codigo
     * @param div
     * @param sig
     */
    public TelaCadAno(int codigo, String year) {
        initComponents();
        if(codigo > 0){
            codigoAno = codigo;
            setTitle("Alterar Cadastro");
            preencherDados(year);
        }else{
            setTitle("Novo Cadastro");
        }
    }
    
    private void preencherDados(String year){
        jt_ano.setText(year);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jt_ano = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_salvar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setTitle("Cadastrar Divisão");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ano:");

        jt_ano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_anoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jt_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jb_salvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });

        jb_limpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limparActionPerformed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_salvar)
                .addGap(58, 58, 58)
                .addComponent(jb_limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jb_cancelar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_salvar)
                    .addComponent(jb_limpar)
                    .addComponent(jb_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        acao();
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
       dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limparActionPerformed
        limpar();
    }//GEN-LAST:event_jb_limparActionPerformed

    private void jt_anoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_anoKeyPressed
       // System.out.println("Enter: "+KeyEvent.VK_ENTER);
        if(evt.getKeyCode() == 10){
            jb_salvar.doClick();
        }
    }//GEN-LAST:event_jt_anoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JTextField jt_ano;
    // End of variables declaration//GEN-END:variables
    int codigoAno = 0;
    Ano ano;
    Ano_Controller ano_Controller;
    
    private void acao(){
        if(codigoAno > 0){
            alterar();
        }else{
            salvar();
        }
    }
    
    private void salvar(){
        ano_Controller = new Ano_Controller();
        ano = new Ano();
        
        ano.setDesc_Ano(jt_ano.getText());
        
       
        boolean teste = ano_Controller.inserir(ano);
        if(teste){
            TelaAdmAno.pesquisaAno("");
            mensagem("Cadastro efetuado com sucesso! Cadastrar outro?", "Parabéns", 1);
        }else{
            
            mensagem(MensagemErro.mensagem, "Opa!", 3);
        }
    }
    
    private void alterar(){
        ano_Controller = new Ano_Controller();
        ano = new Ano();
        ano.setAno_Codigo(codigoAno);
        ano.setDesc_Ano(jt_ano.getText());
        
       
        boolean teste = ano_Controller.alterar(ano);
        if(teste){
            TelaAdmAno.pesquisaAno("");
            mensagem("Alteração efetuada com sucesso!", "Parabéns!", 2);
        }else{
            mensagem("Verifique os dados cadastrados", "Opa!", 3);
        }
    }
    
    
      private void mensagem(String mensagem, String titulo, int opcao){
          switch(opcao){
              case 1:
                  int option = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                  if(option == JOptionPane.YES_OPTION){
                     limpar();
                  }else{
                      dispose();
                  }
                  break;
              case 2:
                  JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
                  dispose();
                  break;
              case 3:
                  JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
                  break;
          }
      }
      
      private void limpar(){
          jt_ano.setText("");
          jt_ano.requestFocus();
        
      }
} // fim do arquivo
