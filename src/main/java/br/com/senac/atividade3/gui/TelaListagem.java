package br.com.senac.atividade3.gui;

import br.com.senac.atividade3.persistencia.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Renato Rodrigues
 */
/* Tela da tabela. Também serve para excluir dados. - TDS */
public class TelaListagem extends javax.swing.JFrame {


    public TelaListagem() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFilmes = new javax.swing.JTable();
        btnPrec = new javax.swing.JButton();
        btnEncerrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filmes em cartaz");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 255));
        jLabel1.setText("CENAFLIX");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("FILMES EM CARTAZ");

        tblFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblFilmes);

        btnPrec.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnPrec.setText("Preços e horários");
        btnPrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecActionPerformed(evt);
            }
        });

        btnEncerrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEncerrar.setText("Encerrar filme");
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarActionPerformed(evt);
            }
        });

        btnVoltar.setText("< Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSair.setForeground(new java.awt.Color(255, 51, 51));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEncerrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrec))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnVoltar)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (TelaInicial.conf == 0) { btnEncerrar.setVisible(false); btnVoltar.setVisible(false); }
        if (TelaInicial.conf == 1) { btnEncerrar.setEnabled(false); }
        
        FilmesBD filmesBD = new FilmesBD();
        List<Filmes> filmes = filmesBD.listar();
          
        preencheTabela(filmes);
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnPrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecActionPerformed
try{ if(tblFilmes.getSelectedRow() >= 0){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<String> query = em.createQuery("SELECT status FROM Filmes WHERE id = :id", String.class);
        query.setParameter("id", tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 0));
        
        List<String> resultados = query.getResultList();
        if (resultados.get(0).equals("Em cartaz")) {
        
        String idS = (String)tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 0);    
        int id = Integer.parseInt(idS);
        TelaEscolha TE = new TelaEscolha(id);
        TE.setVisible(true);
        dispose(); } else { JOptionPane. showMessageDialog(this, "Não há sessões deste filme! Filme encerrado ou não designado."); }             
    } else { JOptionPane. showMessageDialog(this, "Selecione um filme!"); }
      }catch(Exception e){
          System.out.println("Ocorreu uma falha:\n" + e.getMessage());
      }

    }//GEN-LAST:event_btnPrecActionPerformed

    private void btnEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarActionPerformed
              try{
    if(tblFilmes.getSelectedRow() >= 0){ 
        if(!tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 5).equals("Encerrado")) {
              String id = (String)tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 0);
              String titulo = (String)tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 1);
              int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo encerrar o filme " + titulo + "?");
              if(resposta == 0)
              {   
                  FilmesBD filmesBD = new FilmesBD();            
                  filmesBD.encerrar(Integer.parseInt(id));
                  JOptionPane. showMessageDialog(this, "Filme encerrado com sucesso, obrigado por assistirem!");
              }
} else { JOptionPane. showMessageDialog(this, "Este filme já está encerrado."); }
    } else { JOptionPane. showMessageDialog(this, "Selecione um filme!"); }
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
      }
    }//GEN-LAST:event_btnEncerrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaSelecao TS = new TelaSelecao();
        TS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
      TelaInicial TI = new TelaInicial();
      Usuario u = new Usuario();
      u.setLogin(null); u.setNome(null); u.setSenha(null); u.setTipo(null);
      TI.setVisible(true);
      dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnPrec;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFilmes;
    // End of variables declaration//GEN-END:variables

public void preencheTabela(List<Filmes> filmes){ 
    if (TelaInicial.conf == 0 ) {
    String columns[] = {"Id", "Título", "Duração", "Gênero", "Tipo"};
    String dados[][] = new String[filmes.size()][columns.length];
      
      int i=0;
      for(Filmes f: filmes){
          dados[i] = new String[]{ 
              String.valueOf(f.getId()), 
              f.getTitulo(),
              f.getDuracao(),
              f.getGenero(),
              f.getTipo()};              
          i++;
      }
      
      DefaultTableModel model = new DefaultTableModel(dados, columns);
      tblFilmes.setModel(model); }
    else {
    String columns[] = {"Id", "Título", "Duração", "Gênero", "Tipo", "Status"};
    String dados[][] = new String[filmes.size()][columns.length];
      
      int i=0;
      for(Filmes f: filmes){
          dados[i] = new String[]{ 
              String.valueOf(f.getId()), 
              f.getTitulo(),
              f.getDuracao(),
              f.getGenero(),
              f.getTipo(),
              f.getStatus()};              
          i++;
      }
      
      DefaultTableModel model = new DefaultTableModel(dados, columns);
      tblFilmes.setModel(model); }
    }

}
