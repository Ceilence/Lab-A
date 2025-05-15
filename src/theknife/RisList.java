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
public class RisList extends javax.swing.JFrame {
    private final ImageIcon logoIcona;
    private final ImageIcon freccia;
    private GestoreArchivi gestore;
    
    
    public RisList(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();
        
        //Immagine per mostrare il logo ridimensionato ed applicato.
        ImageIcon tkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\TheKnife.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        logo.setIcon(tk3);
        this.logoIcona = tk3;
        
        ImageIcon fgIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\freccine.png"));
        Image fg1 = fgIcon.getImage();
        Image fg2 = fg1.getScaledInstance(frecciagiu.getWidth(), frecciagiu.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fg3 = new ImageIcon(fg2);
        logo.setIcon(fg3);
        this.freccia = fg3;
        
        
        /*JPanel pannello = new JPanel();
        pannello.setLayout(new BoxLayout(pannello, BoxLayout.Y_AXIS));

        for (int i = 0; i < 10; i++) {
            pannello.add(new JLabel("Elemento numero " + i));
        }

        jScrollPane1.setViewportView(pannello);*/
        
        PannelloRis pannelloDinamico = new PannelloRis(jScrollPane1, gestore);
        jScrollPane1.setViewportView(pannelloDinamico);

    }
    
    //Generated code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        frecciagiu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        barraRicerca = new javax.swing.JTextField();
        ricerca = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(frecciagiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 40));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1482, 760));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(864, 674));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 90, 870, 670));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel4.add(ricerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 6, 50, 45));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 500, 57));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraRicercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraRicercaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barraRicercaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraRicerca;
    private javax.swing.JLabel frecciagiu;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton ricerca;
    // End of variables declaration//GEN-END:variables
}
