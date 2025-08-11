/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;
import java.awt.*;
import javax.swing.*;



/**
 *
 * @author davim Alefr AntoPar
 */
public class RegRistorante extends javax.swing.JFrame {
    //Dichiarazione variabili
    private GestoreArchivi gestore;
    private String nomeRis;
    private String indRis;
    private String locRis;
    private String priceRis;
    private String cuisRis;
    private double longRis;
    private double latRis;
    private String pnRis;
    private int mediaStelleRis;
    private boolean delivery;
    private boolean prenotaOnline;
    private String desRis;
    private int idRis;
   
    
    public RegRistorante(GestoreArchivi gestore, String nomeRis, String indRis, String locRis, String priceRis, String cuisRis, double longRis, double latRis, String pnRis, int mediaStelleRis, boolean delivery, boolean prenotaOnline, String desRis, int idRis) {
        this.gestore = gestore;
        this.nomeRis = nomeRis;
        this.indRis = indRis;
        this.locRis = locRis;
        this.priceRis = priceRis;
        this.cuisRis = cuisRis;
        this.longRis = longRis;
        this.latRis = latRis;
        this.pnRis = pnRis;
        this.mediaStelleRis = mediaStelleRis;
        this.delivery = delivery;
        this.prenotaOnline = prenotaOnline;
        this.desRis = desRis;
        this.idRis = idRis;
        
        //Inizializzazione vari componenti e Lable.
        initComponents();  
        
        //Immagine per pulsante indietro ridimensionata ed applicata.
        ImageIcon backArr = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\backArrow.png"));
        Image ba1 = backArr.getImage();
        Image ba2 = ba1.getScaledInstance(backArrow.getWidth(), backArrow.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ba3 = new ImageIcon(ba2); 
        backArrow.setIcon(ba3);
    }
    
    
    
    //Generated Code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        backArrow = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        città = new javax.swing.JTextField();
        regRis = new javax.swing.JButton();
        locRist = new javax.swing.JLabel();
        indRist = new javax.swing.JLabel();
        indirizzo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        NomeRist = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        lonRist = new javax.swing.JLabel();
        longitudine = new javax.swing.JTextField();
        latitudine = new javax.swing.JTextField();
        latRist = new javax.swing.JLabel();
        descrizione = new javax.swing.JTextField();
        desRist = new javax.swing.JLabel();
        delcheck = new javax.swing.JCheckBox();
        prencheck = new javax.swing.JCheckBox();
        deliveryRist = new javax.swing.JLabel();
        prenOnl = new javax.swing.JLabel();
        numerotel = new javax.swing.JTextField();
        cuisRist = new javax.swing.JLabel();
        cucina = new javax.swing.JTextField();
        pnRist = new javax.swing.JLabel();
        prezzoBox = new javax.swing.JComboBox<>();
        priceRist = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backArrow.setBorder(null);
        backArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backArrowActionPerformed(evt);
            }
        });
        jPanel2.add(backArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 30, 26));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setText("REGISTRAZIONE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 300, 40));

        città.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cittàActionPerformed(evt);
            }
        });
        jPanel2.add(città, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 135, -1));

        regRis.setBackground(new java.awt.Color(0, 102, 102));
        regRis.setForeground(new java.awt.Color(255, 255, 255));
        regRis.setText("Registra");
        regRis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regRisActionPerformed(evt);
            }
        });
        jPanel2.add(regRis, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 90, 30));

        locRist.setText("Città:");
        jPanel2.add(locRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 79, -1));

        indRist.setText("indirizzo:");
        jPanel2.add(indRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 82, -1));

        indirizzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indirizzoActionPerformed(evt);
            }
        });
        jPanel2.add(indirizzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 135, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel14.setText("ristorante ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 160, 26));

        NomeRist.setText("Nome:");
        jPanel2.add(NomeRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 49, -1));

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        jPanel2.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 288, -1));

        lonRist.setText("Longitudine:");
        jPanel2.add(lonRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 68, -1));

        longitudine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                longitudineActionPerformed(evt);
            }
        });
        jPanel2.add(longitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 135, -1));

        latitudine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latitudineActionPerformed(evt);
            }
        });
        jPanel2.add(latitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 135, -1));

        latRist.setText("Latitudine:");
        jPanel2.add(latRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 68, -1));

        descrizione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descrizioneActionPerformed(evt);
            }
        });
        jPanel2.add(descrizione, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 288, -1));

        desRist.setText("Descrizione:");
        jPanel2.add(desRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        delcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delcheckActionPerformed(evt);
            }
        });
        jPanel2.add(delcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));

        prencheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prencheckActionPerformed(evt);
            }
        });
        jPanel2.add(prencheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        deliveryRist.setText("Delivery:");
        jPanel2.add(deliveryRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        prenOnl.setText("Prenotazione:");
        jPanel2.add(prenOnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        numerotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numerotelActionPerformed(evt);
            }
        });
        jPanel2.add(numerotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 288, 20));

        cuisRist.setText("Tipo Cucina:");
        jPanel2.add(cuisRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 70, -1));

        cucina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cucinaActionPerformed(evt);
            }
        });
        jPanel2.add(cucina, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 288, -1));

        pnRist.setText("Numero di telefono:");
        jPanel2.add(pnRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        prezzoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$", "$$", "$$$", "$$$$" }));
        prezzoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prezzoBoxActionPerformed(evt);
            }
        });
        jPanel2.add(prezzoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 70, 20));

        priceRist.setText("Fascia di prezzo:");
        jPanel2.add(priceRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //Codice per il bottone "freccia" per tornare al Frame precedente.
    private void backArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backArrowActionPerformed
        Reg1 Reg1Frame = new Reg1(gestore);
        Reg1Frame.setVisible(true);
        Reg1Frame.pack();
        Reg1Frame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_backArrowActionPerformed

   
   
   
    private void regRisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regRisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regRisActionPerformed

    private void longitudineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_longitudineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_longitudineActionPerformed

    private void latitudineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latitudineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latitudineActionPerformed

    private void descrizioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descrizioneActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_descrizioneActionPerformed

    private void delcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delcheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delcheckActionPerformed

    private void prencheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prencheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prencheckActionPerformed

    private void indirizzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indirizzoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indirizzoActionPerformed

    private void numerotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numerotelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numerotelActionPerformed

    private void prezzoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prezzoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prezzoBoxActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void cucinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cucinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cucinaActionPerformed

    private void cittàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cittàActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cittàActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NomeRist;
    private javax.swing.JButton backArrow;
    private javax.swing.JTextField città;
    private javax.swing.JTextField cucina;
    private javax.swing.JLabel cuisRist;
    private javax.swing.JCheckBox delcheck;
    private javax.swing.JLabel deliveryRist;
    private javax.swing.JLabel desRist;
    private javax.swing.JTextField descrizione;
    private javax.swing.JLabel indRist;
    private javax.swing.JTextField indirizzo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel latRist;
    private javax.swing.JTextField latitudine;
    private javax.swing.JLabel locRist;
    private javax.swing.JLabel lonRist;
    private javax.swing.JTextField longitudine;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField numerotel;
    private javax.swing.JLabel pnRist;
    private javax.swing.JLabel prenOnl;
    private javax.swing.JCheckBox prencheck;
    private javax.swing.JComboBox<String> prezzoBox;
    private javax.swing.JLabel priceRist;
    private javax.swing.JButton regRis;
    // End of variables declaration//GEN-END:variables
}
