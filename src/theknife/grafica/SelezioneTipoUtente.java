/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.Image;
import javax.swing.ImageIcon;
import theknife.gestori.GestoreArchivi;
import theknife.grafica.Login;
import theknife.grafica.RegUtente;

/**
 * Finestra di selezione del tipo di utente per la registrazione.
 * Permette di scegliere se registrarsi come cliente o come ristoratore.
 * 
 * @see GestoreArchivi
 * @see RisList
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class SelezioneTipoUtente extends javax.swing.JFrame {
    
     /** Gestore degli archivi dell’applicazione. {@code gestore} */
    private GestoreArchivi gestore;
    
    /** Riferimento alla lista dei ristoranti e all'interfaccia principale. {@code risList} */   
    private final RisList risList;
    
    /**
     * Costruttore della classe SelezioneTipoUtente. Inizializza la finestra con le opzioni di registrazione.
     * 
     * @param gestore Gestore degli archivi dell’applicazione {@link GestoreArchivi}
     * @param risList Riferimento alla lista dei ristoranti {@link RisList}
     */
    public SelezioneTipoUtente(GestoreArchivi gestore, RisList risList) {
        
        this.gestore = gestore;
        this.risList = risList;
        initComponents();
        //Ridimensionamento icona logo.
        ImageIcon tkIcon = new ImageIcon(getClass().getResource("/theknife/resources/images/logo.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(iconaLogo.getWidth(), iconaLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        iconaLogo.setIcon(tk3);
        
        //Ridimensionamento icona utente
        ImageIcon utenteIcon = new ImageIcon(getClass().getResource("/theknife/resources/images/Omino_stilizzato.png"));
        Image u1 = utenteIcon.getImage();
        Image u2 = u1.getScaledInstance(utente.getWidth(), utente.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon u3 = new ImageIcon(u2);
        utente.setIcon(u3);
        
        //Ridimensionamento icona ristoratore
        ImageIcon ristoratoreIcon = new ImageIcon(getClass().getResource("/theknife/resources/images/depositphotos_665030182-stock-illustration-cook-line-color-filled-icons.png"));
        Image r1 = utenteIcon.getImage();
        Image r2 = r1.getScaledInstance(utente.getWidth(), utente.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon r3 = new ImageIcon(r2);
        utente.setIcon(r3);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        iconaLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ristoratore = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        utente = new javax.swing.JLabel();
        regClienteButton = new javax.swing.JButton();
        indietro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

        iconaLogo.setText("jLabel7");

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TheKnife");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(iconaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel5)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(iconaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(139, 139, 139))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("REGISTRAZIONE");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 35, -1, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 287, 394, 16));
        jPanel3.add(ristoratore, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 309, 153, 141));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ristoratore");
        jButton1.setAlignmentY(0.6F);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 456, -1, -1));
        jPanel3.add(utente, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 83, 109, 157));

        regClienteButton.setBackground(new java.awt.Color(0, 102, 102));
        regClienteButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        regClienteButton.setForeground(new java.awt.Color(255, 255, 255));
        regClienteButton.setText("Cliente");
        regClienteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regClienteButtonActionPerformed(evt);
            }
        });
        jPanel3.add(regClienteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 246, -1, -1));

        indietro.setBackground(new java.awt.Color(204, 204, 204));
        indietro.setText("X");
        indietro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        indietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroActionPerformed(evt);
            }
        });
        jPanel3.add(indietro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Apre il frame per la registrazione come ristoratore.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegRistoratore RegRistoratoreFrame = new RegRistoratore(gestore, risList);
        RegRistoratoreFrame.setVisible(true);
        RegRistoratoreFrame.pack();
        RegRistoratoreFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Apre il frame per la registrazione come cliente.
     */
    private void regClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regClienteButtonActionPerformed
        RegUtente RegClienteFrame = new RegUtente(gestore, risList);
        RegClienteFrame.setVisible(true);
        RegClienteFrame.pack();
        RegClienteFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_regClienteButtonActionPerformed

    /**
     * Torna alla schermata di login.
     */
    private void indietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroActionPerformed
        Login LoginFrame = new Login(gestore, risList);
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_indietroActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconaLogo;
    private javax.swing.JButton indietro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton regClienteButton;
    private javax.swing.JLabel ristoratore;
    private javax.swing.JLabel utente;
    // End of variables declaration//GEN-END:variables
}
