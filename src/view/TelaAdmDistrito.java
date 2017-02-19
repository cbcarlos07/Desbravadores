/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Distrito_Controller;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.beans.Distrito;
import servicos.Maiusculas;

/**
 *
 * @author Gysa
 */
public class TelaAdmDistrito extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDistrito
     */
    public TelaAdmDistrito() {
        initComponents();
        jt_pesquisar.setDocument(new Maiusculas());
        jt_pesquisar.requestFocus();
        setTitle("Distrito");
        pesquisaDistrito("");
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jt_pesquisar = new javax.swing.JTextField();
        jb_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setResizable(true);
        setTitle("Distrito");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_pesquisarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_pesquisarKeyReleased(evt);
            }
        });

        jb_pesquisar.setText("Pesquisar");
        jb_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_pesquisar)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_pesquisar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Distrito", "Associação", "Principal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(60);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela.getColumnModel().getColumn(0).setMaxWidth(70);
            tabela.getColumnModel().getColumn(1).setMinWidth(220);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(220);
            tabela.getColumnModel().getColumn(1).setMaxWidth(250);
            tabela.getColumnModel().getColumn(2).setMinWidth(217);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(217);
            tabela.getColumnModel().getColumn(2).setMaxWidth(240);
            tabela.getColumnModel().getColumn(3).setMinWidth(70);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jb_novo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_novo.setText("Novo");
        jb_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novoActionPerformed(evt);
            }
        });

        jb_alterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_alterar.setText("Alterar");
        jb_alterar.setEnabled(false);
        jb_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_alterarActionPerformed(evt);
            }
        });

        jb_excluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_excluir.setText("Excluir");
        jb_excluir.setEnabled(false);
        jb_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_excluirActionPerformed(evt);
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
                .addComponent(jb_novo)
                .addGap(45, 45, 45)
                .addComponent(jb_alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_excluir)
                .addGap(90, 90, 90)
                .addComponent(jb_cancelar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_novo)
                    .addComponent(jb_alterar)
                    .addComponent(jb_excluir)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisarActionPerformed
        pesquisaDistrito(jt_pesquisar.getText());
        ativaDesativa(0);
    }//GEN-LAST:event_jb_pesquisarActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        cadastro(0);
    }//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        ativaDesativa(0);
        cadastro(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
    }//GEN-LAST:event_jb_alterarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        ativaDesativa(1);
    }//GEN-LAST:event_tabelaMouseClicked

    private void jt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_pesquisarKeyReleased
        ativaDesativa(0);
    }//GEN-LAST:event_jt_pesquisarKeyReleased

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        opcaoExcluir();
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jt_pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_pesquisarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           jb_pesquisar.doClick();
           System.out.println("Enter :"+KeyEvent.VK_ENTER);
        }
        
    }//GEN-LAST:event_jt_pesquisarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_pesquisar;
    private javax.swing.JTextField jt_pesquisar;
    private static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
    static Distrito distrito;
    static Distrito_Controller distrito_Controller;
    static List lista;
    static Iterator iterator;
    String titulo =  "Distrito";
    
    
    
    public static void pesquisaDistrito(String texto){
        Cursor.getPredefinedCursor(3);
        distrito_Controller = new Distrito_Controller();
        lista = distrito_Controller.getDistritoList(texto);
        preencherTabela();
        Cursor.getDefaultCursor();
    }
    
    private static void preencherTabela(){
        DefaultTableModel linha = (DefaultTableModel) tabela.getModel();
        linha.setNumRows(0);
        iterator = lista.iterator();
        while(iterator.hasNext()){
            distrito = (Distrito) iterator.next();
            linha.addRow(new Object[]{
               distrito.getCodigo(),
               distrito.getDistrito(),
               distrito.getAssociacao().getAssoc_Nome(),
               distrito.getSn_principal()
               
            });
        }
    }
  private void cadastro(int codigo){
      TelaCadDistrito tela = new TelaCadDistrito(codigo);
      TelaPrincipal.desktop.add(tela);
      tela.show();
            
      
  }
  
  private void ativaDesativa(int op){
      if(op == 0){
          jb_alterar.setEnabled(false);
          jb_excluir.setEnabled(false);
      }
      else{
          jb_alterar.setEnabled(true);
          jb_excluir.setEnabled(true);
      }
  }
  
  private void excluir(){
      distrito_Controller =  new Distrito_Controller();
      boolean teste = distrito_Controller.excluir(
              Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
      if(teste){
          pesquisaDistrito("");
          mensagem("Item removido com sucesso!", "Muito bem!", JOptionPane.INFORMATION_MESSAGE);
          ativaDesativa(0);
      }
      else{
          mensagem("Um ocorreu, possivelmente existe cadastro associado a este item", "Erro", JOptionPane.ERROR_MESSAGE);
          ativaDesativa(0);
      }
  }
  
  private void mensagem(String mensagem, String titulo, int tipo){
      JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
  }
  private int mensagem1(String mensagem, String titulo, int tipo ){
      int op = JOptionPane.showConfirmDialog(null, mensagem, titulo,  JOptionPane.YES_NO_OPTION, tipo);
      return op;
  }
  
  private void opcaoExcluir(){
      int op = mensagem1("Tem certeza que deseja excluir?", "Confirmação", JOptionPane.QUESTION_MESSAGE);
      if(op == JOptionPane.YES_OPTION){
          excluir();
      }
  }
}//fim do arquivo