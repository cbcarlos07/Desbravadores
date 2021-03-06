/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Estado_Controller;
import controller.Bairro_Controller;
import controller.Cidade_Controller;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import model.beans.Estado;
import model.beans.Bairro;
import model.beans.Cidade;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import servicos.Maiusculas;
import servicos.MensagemErro;

/**
 *
 * @author Gysa
 */
public class TelaCadBairro extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadBairro
     * @param codigo
     */
    public TelaCadBairro(int codigo) {
        initComponents();
        jt_campo.setDocument(new Maiusculas());
        
        preencherCombo2();
        combo_dados.addItem("SELECIONE");
        
        
        AutoCompleteDecorator.decorate(combo_dados);
        AutoCompleteDecorator.decorate(combo_dados1);
        
        if(codigo > 0){
            codigoBairro = codigo;
            setTitle("Alterar Cadastro Bairro");
            preencherDados(codigo);
        }else{
            setTitle("Novo Cadastro Bairro");
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
        jt_campo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo_dados = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        combo_dados1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jb_salvar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setTitle("Cadastrar Distrito");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Bairro");

        jLabel3.setText("Cidade");

        jLabel4.setText("Estado");

        combo_dados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_dados1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_dados, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_dados1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_dados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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

    private void combo_dados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_dados1ActionPerformed
        preencherCombo();
    }//GEN-LAST:event_combo_dados1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_dados;
    private javax.swing.JComboBox combo_dados1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JTextField jt_campo;
    // End of variables declaration//GEN-END:variables
    int codigoBairro = 0;
    Bairro bairro;
    Bairro_Controller bairro_Controller;
    
    private void acao(){
        if(codigoBairro > 0){
            alterar();
        }else{
            salvar();
        }
    }
    
    private void salvar(){
        bairro_Controller = new Bairro_Controller();
        bairro = new Bairro();
        
        bairro.setNm_bairro(jt_campo.getText());
        Cidade cidade = (Cidade) combo_dados.getSelectedItem();
        bairro.setCidade_Codigo(cidade.getCidade_Codigo());
        
        boolean teste = bairro_Controller.inserir(bairro);
        if(teste){
            TelaAdmBairro.pesquisaBairro("");
            mensagem("Cadastro efetuado com sucesso! Cadastrar outro?", "Parabéns", 1);
        }else{
            
            mensagem(MensagemErro.mensagem, "Opa!", 3);
        }
    }
    
    private void alterar(){
        bairro_Controller = new Bairro_Controller();
        bairro = new Bairro();
        
        bairro.setCd_bairro(codigoBairro);
        bairro.setNm_bairro(jt_campo.getText());
        Cidade cidade = (Cidade) combo_dados.getSelectedItem();
        bairro.setCidade_Codigo(cidade.getCidade_Codigo());
        
        boolean teste = bairro_Controller.alterar(bairro);
        if(teste){
            TelaAdmBairro.pesquisaBairro("");
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
          jt_campo.setText("");
          jt_campo.requestFocus();
          
      }
      
      private void preencherDados(int codigo){
        bairro = new Bairro();
        bairro_Controller = new Bairro_Controller();
        bairro = bairro_Controller.getBairro(codigo);
        jt_campo.setText(bairro.getNm_bairro());
        Cidade_Controller cc = new Cidade_Controller();
       // System.out.println("TelaCadBairro: cidade: "+bairro.getCidade_Codigo());
        int cd_estado = cc.getCdEstado(bairro.getCidade_Codigo());
         // System.out.println("TelaCadBairro: estado: "+cd_estado);
        
        Estado estado = new Estado();
        Estado_Controller ec = new Estado_Controller();
        estado = ec.getEstado(cd_estado);
          //System.out.println("Estado: "+estado.getEstado_Nome());
        
        int x = 0;
        for (int i = 0; i < combo_dados1.getItemCount(); i++){
           String combo = combo_dados1.getItemAt(i).toString();
           if(combo.equals(estado.getEstado_Nome())){
               x = i;
               break;
           }
        }
        
        int j = 0;
        for (int i = 0; i < combo_dados.getItemCount(); i++){
           String combo = combo_dados.getItemAt(i).toString();
           if(combo.equals(bairro.getCidade_Descricao())){
               j = i;
               break;
           }
        }
        combo_dados1.setSelectedIndex(x);
        combo_dados.setSelectedIndex(j);
    }
      
      private void preencherCombo(){
          combo_dados.removeAllItems();
          Cidade cidade = null;
          Cidade_Controller cidade_Controller = new Cidade_Controller();
          Estado estado = (Estado) combo_dados1.getSelectedItem();
          int cd_estado = estado.getEstado_Codigo();
          List list = cidade_Controller.getCidadeList("",cd_estado);
          Iterator iterator = list.iterator();
          while(iterator.hasNext()){
              cidade = (Cidade) iterator.next();
              combo_dados.addItem(cidade);
          }
      }
      
      private void preencherCombo2(){
          Estado estado = null;
          Estado_Controller estado_Controller = new Estado_Controller();
          List list = estado_Controller.getEstadoList("");
          Iterator iterator = list.iterator();
          while(iterator.hasNext()){
              estado = (Estado) iterator.next();
              combo_dados1.addItem(estado);
          }
      }
} // fim do arquivo
