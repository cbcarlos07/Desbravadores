/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Pais_Controller;
import controller.Estado_Controller;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import model.beans.Pais;
import model.beans.Estado;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import servicos.Maiusculas;
import servicos.MensagemErro;

/**
 *
 * @author Gysa
 */
public class TelaCadEstado extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadEstado
     * @param codigo
     */
    public TelaCadEstado(int codigo) {
        initComponents();
        jt_estado.setDocument(new Maiusculas());
        jt_sigla.setDocument(new Maiusculas());
        
        preencherCombo();
        AutoCompleteDecorator.decorate(combo_dados);
        
        if(codigo > 0){
            codigoEstado = codigo;
            setTitle("Alterar Cadastro Estado");
            preencherDados(codigo);
        }else{
            setTitle("Novo Cadastro Estado");
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
        jt_estado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo_dados = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jt_sigla = new javax.swing.JTextField();
        jchecked = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jb_salvar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setTitle("Cadastrar Distrito");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Estado:");

        jLabel3.setText("País");

        jLabel2.setText("Sigla:");

        jchecked.setText("Principal?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_dados, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jt_sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jchecked)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jt_sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchecked))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JComboBox combo_dados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jchecked;
    private javax.swing.JTextField jt_estado;
    private javax.swing.JTextField jt_sigla;
    // End of variables declaration//GEN-END:variables
    int codigoEstado = 0;
    Estado estado;
    Estado_Controller estado_Controller;
    
    private void acao(){
        if(codigoEstado > 0){
            alterar();
        }else{
            salvar();
        }
    }
    
    private void salvar(){
        estado_Controller = new Estado_Controller();
        estado = new Estado();
        
        estado.setEstado_Nome(jt_estado.getText());
        estado.setEstado_Sigla(jt_sigla.getText());
        estado.setEstado_sn_principal(getChecked());
        estado.setPais(new Pais());
        Pais pais = (Pais) combo_dados.getSelectedItem();
        estado.getPais().setPais_Codigo(pais.getPais_Codigo());
        boolean teste = estado_Controller.inserir(estado);
        if(teste){
            TelaAdmEstado.pesquisaEstado("");
            mensagem("Cadastro efetuado com sucesso! Cadastrar outro?", "Parabéns", 1);
        }else{
            
            mensagem(MensagemErro.mensagem, "Opa!", 3);
        }
    }
    
    private void alterar(){
        estado_Controller = new Estado_Controller();
        estado = new Estado();
        
        estado.setEstado_Codigo(codigoEstado);
        estado.setEstado_Nome(jt_estado.getText());
        estado.setEstado_Sigla(jt_sigla.getText());
        estado.setEstado_sn_principal(getChecked());
        estado.setPais(new Pais());
        Pais pais = (Pais) combo_dados.getSelectedItem();
        estado.getPais().setPais_Codigo(pais.getPais_Codigo());
        boolean teste = estado_Controller.alterar(estado);
        if(teste){
            TelaAdmEstado.pesquisaEstado("");
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
          jt_estado.setText("");
          jt_estado.requestFocus();
          
      }
      
      private void preencherDados(int codigo){
        estado = new Estado();
        estado_Controller = new Estado_Controller();
        estado = estado_Controller.getEstado(codigo);
        jt_estado.setText(estado.getEstado_Nome());
        jt_sigla.setText(estado.getEstado_Sigla());
        
        if(estado.getEstado_sn_principal().equals("S")){
            jchecked.setSelected(true);
        }
        
        
        int j = 0;
        for (int i = 0; i < combo_dados.getItemCount(); i++){
           String combo = combo_dados.getItemAt(i).toString();
           if(combo.equals(estado.getPais().getPais_Descricao())){
               j = i;
               break;
           }
        }
        
        combo_dados.setSelectedIndex(j);
    }
      
      private void preencherCombo(){
          Pais pais = null;
          Pais_Controller pais_Controller = new Pais_Controller();
          List list = pais_Controller.getPaisList("");
          Iterator iterator = list.iterator();
          while(iterator.hasNext()){
              pais = (Pais) iterator.next();
              combo_dados.addItem(pais);
          }
      }
      
      private String getChecked(){
          String check = "N";
          if(jchecked.isSelected()){
              check = "S";
          }
          return check;
      }
} // fim do arquivo
