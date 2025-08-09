/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author SSSSUGOI
 */
/*public class rislistvecchio extends javax.swing.JFrame {
    private final ImageIcon logoIcona;
    private final ImageIcon freccia;
    private final ImageIcon prefAdd;
    private final ImageIcon prefRem;
    private GestoreArchivi gestore;
    
    
    public rislistvecchio(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();
        pack();
        setLocationRelativeTo(null);
        
        //Immagine per mostrare il logo ridimensionato ed applicato.
        ImageIcon tkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\TheKnife.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        logo.setIcon(tk3);
        this.logoIcona = tk3;
        
        ImageIcon fgIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\freccine.png"));
        Image fg1 = fgIcon.getImage();
        Image fg2 = fg1.getScaledInstance(theknife.getWidth(), theknife.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fg3 = new ImageIcon(fg2);
        logo.setIcon(fg3);
        this.freccia = fg3;
        
        ImageIcon paIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Aggiungi.png"));
        Image pa1 = paIcon.getImage();
        Image pa2 = pa1.getScaledInstance(preferiti.getWidth(), preferiti.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pa3 = new ImageIcon(pa2);
        this.prefAdd = pa3;
        
        ImageIcon ptIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Togli.png"));
        Image pt1 = fgIcon.getImage();
        Image pt2 = fg1.getScaledInstance(preferiti.getWidth(), preferiti.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pt3 = new ImageIcon(fg2);
        this.prefRem = pt3;
        
        
        JPanel pannello = new JPanel();
        pannello.setLayout(new BoxLayout(pannello, BoxLayout.Y_AXIS));

        for (int i = 0; i < 10; i++) {
            pannello.add(new JLabel("Elemento numero " + i));
        }

        jScrollPane1.setViewportView(pannello);
        
        PannelloRis pannelloDinamico = new PannelloRis(jScrollPane1, gestore, dettaglioPanel, dettaglioNome, dettaglioCucina, dettaglioImmagine, labelDescrizione);
        jScrollPane1.setViewportView(pannelloDinamico);
        

    }
    
    //Generated code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        dettaglioPanel = new javax.swing.JPanel();
        dettaglioNome = new javax.swing.JLabel();
        dettaglioCucina = new javax.swing.JLabel();
        dettaglioImmagine = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelDescrizione = new javax.swing.JLabel();
        preferiti = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        barraRicerca = new javax.swing.JTextField();
        ricerca = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        theknife = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1482, 760));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dettaglioPanel.setBackground(new java.awt.Color(255, 255, 255));
        dettaglioPanel.setPreferredSize(new java.awt.Dimension(864, 674));
        dettaglioPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dettaglioNome.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dettaglioNome.setText("jLabel1");
        dettaglioPanel.add(dettaglioNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        dettaglioCucina.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dettaglioCucina.setText("jLabel1");
        dettaglioPanel.add(dettaglioCucina, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 52, -1, -1));

        dettaglioImmagine.setBackground(new java.awt.Color(255, 255, 255));
        dettaglioImmagine.setForeground(new java.awt.Color(255, 255, 255));
        dettaglioImmagine.setText("jlabel");
        dettaglioPanel.add(dettaglioImmagine, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 70));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        labelDescrizione.setBackground(new java.awt.Color(204, 204, 204));
        labelDescrizione.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDescrizione.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescrizione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescrizione)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dettaglioPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 110, -1, -1));

        preferiti.setText("jButton1");
        preferiti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferitiActionPerformed(evt);
            }
        });
        dettaglioPanel.add(preferiti, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jPanel2.add(dettaglioPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 90, -1, 670));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setMaximumSize(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(738, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 153, 500, 607));

        logo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 72, 72));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraRicerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraRicercaActionPerformed(evt);
            }
        });
        jPanel4.add(barraRicerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 329, 45));

        ricerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/51658.png"))); // NOI18N
        ricerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ricercaActionPerformed(evt);
            }
        });
        jPanel4.add(ricerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 6, 50, 45));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 500, 57));

        theknife.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel2.add(theknife, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraRicercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraRicercaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barraRicercaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ricercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ricercaActionPerformed
        
    }//GEN-LAST:event_ricercaActionPerformed

    private void preferitiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferitiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferitiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraRicerca;
    private javax.swing.JLabel dettaglioCucina;
    private javax.swing.JLabel dettaglioImmagine;
    private javax.swing.JLabel dettaglioNome;
    private javax.swing.JPanel dettaglioPanel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescrizione;
    private javax.swing.JLabel logo;
    private javax.swing.JButton preferiti;
    private javax.swing.JButton ricerca;
    private javax.swing.JLabel theknife;
    // End of variables declaration//GEN-END:variables
}
*/