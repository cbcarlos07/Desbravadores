/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Associacao_Controller;
import controller.Uniao_Controller;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import model.beans.Associacao;
import model.beans.Uniao;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import servicos.Maiusculas;
import servicos.MensagemErro;

/**
 *
 * @author Gysa
 */
public class TelaCadAssociacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadAssociacao
     * @param codigo
     */
    public TelaCadAssociacao(int codigo) {
        initComponents();
        jt_associacao.setDocument(new Maiusculas());
        jt_sigla.setDocument(new Maiusculas());
        preencherCombo();
        AutoCompleteDecorator.decorate(comboUniao);
        
        if(codigo > 0){
            codigoAssociacao = codigo;
            setTitle("Alterar Cadastro Associação");
            preencherDados(codigo);
        }else{
            setTitle("Novo Cadastro Associação");
        }
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
        jLabel2 = new javax.swing.JLabel();
        jt_associacao = new javax.swing.JTextField();
        jt_sigla = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboUniao = new javax.swing.JComboBox();
        jchck_principal = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jb_salvar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setTitle("Cadastrar Divisão");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Associação:");

        jLabel2.setText("Sigla:");

        jLabel3.setText("União:");

        jchck_principal.setText("Principal?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboUniao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_associacao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jt_sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jchck_principal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_associacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jt_sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchck_principal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboUniao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboUniao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jchck_principal;
    private javax.swing.JTextField jt_associacao;
    private javax.swing.JTextField jt_sigla;
    // End of variables declaration//GEN-END:variables
    int codigoAssociacao = 0;
    Associacao associacao;
    Associacao_Controller associacao_Controller;
    
    private void acao(){
        if(codigoAssociacao > 0){
            alterar();
        }else{
            salvar();
        }
    }
    
    private void salvar(){
        associacao_Controller = new Associacao_Controller();
        associacao = new Associacao();
        
        associacao.setAssoc_Nome(jt_associacao.getText());
        associacao.setAssoc_Sigla(jt_sigla.getText());
        associacao.setUniao(new Uniao());
        Uniao uniao = (Uniao) comboUniao.getSelectedItem();
        associacao.getUniao().setUniao_Codigo(uniao.getUniao_Codigo());
        associacao.setAssoc_sn_principal(getChecked());
        boolean teste = associacao_Controller.inserir(associacao);
        if(teste){
            TelaAdmAssociacao.pesquisaAssociacao("");
            mensagem("Cadastro efetuado com sucesso! Cadastrar outro?", "Parabéns", 1);
        }else{
            
            mensagem(MensagemErro.mensagem, "Opa!", 3);
        }
    }
    
    private void alterar(){
        associacao_Controller = new Associacao_Controller();
        associacao = new Associacao();
        associacao.setAssoc_Codigo(codigoAssociacao);
        associacao.setAssoc_Nome(jt_associacao.getText());
        associacao.setAssoc_Sigla(jt_sigla.getText());
        associacao.setUniao(new Uniao());
        Uniao uniao = (Uniao) comboUniao.getSelectedItem();
        associacao.getUniao().setUniao_Codigo(uniao.getUniao_Codigo());
        associacao.setAssoc_sn_principal(getChecked());
        boolean teste = associacao_Controller.alterar(associacao);
        if(teste){
            TelaAdmAssociacao.pesquisaAssociacao("");
            mensagem("Alteração efetuada com sucesso!", "Parabéns!", 2);
        }else{
            String mensagem = "<html><center>Verifique os dados cadastrados<br>"+MensagemErro.mensagem+"</center></html>";
            mensagem(mensagem, "Opa!", 3);
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
          jt_associacao.setText("");
          jt_associacao.requestFocus();
          jt_sigla.setText("");
      }
      
      private void preencherDados(int codigo){
        associacao = new Associacao();
        associacao_Controller = new Associacao_Controller();
        associacao = associacao_Controller.getAssociacao(codigo);
        jt_associacao.setText(associacao.getAssoc_Nome());
        jt_sigla.setText(associacao.getAssoc_Sigla());
        if(associacao.getAssoc_sn_principal().equals("S"))
        {
            jchck_principal.setSelected(true);
        }
        
        int j = 0;
        for (int i = 0; i < comboUniao.getItemCount(); i++){
           String combo = comboUniao.getItemAt(i).toString();
           if(combo.equals(associacao.getUniao().getUniao_Nome())){
               j = i;
               break;
           }
        }
        
        comboUniao.setSelectedIndex(j);
    }
      
      private void preencherCombo(){
          Uniao uniao = null;
          Uniao_Controller uniao_Controller = new Uniao_Controller();
          List list = uniao_Controller.getUniaoList("");
          Iterator iterator = list.iterator();
          while(iterator.hasNext()){
              uniao = (Uniao) iterator.next();
              comboUniao.addItem(uniao);
          }
      }
      public String getChecked(){
          if(jchck_principal.isSelected()){
              return "S";
          }
          else
          {
              return "N";
          }
      }
} // fim do arquivo
