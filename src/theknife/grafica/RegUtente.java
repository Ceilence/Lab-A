/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;
import theknife.essenziali.Utente;
import java.awt.*;
import javax.swing.*;
import theknife.gestori.GestoreArchivi;
import theknife.utili.ValidaReg;



/**
 * Finestra per la registrazione di un utente generico nel sistema.
 * 
 * Include controlli come:
 * <ul>
 *   <li>Verifica dei campi obbligatori</li>
 *   <li>Validazione dell’email e della password</li>
 *   <li>Mostrare/nascondere la password</li>
 *   <li>Tornare alla selezione del tipo di utente</li>
 * </ul>
 * 
 * @see GestoreArchivi
 * @see RisList
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class RegUtente extends javax.swing.JFrame {
    
    /** Immagine per mostrare la password. {@code showPass} */
    private ImageIcon showPass;
    
    /** Immagine per nascondere la password. {@code hidePass} */
    private ImageIcon hidePass;
    
     /** Riferimento al gestore degli archivi. {@code gestore} */
    private GestoreArchivi gestore;
    
    /** Lista dei ristoranti collegata all’interfaccia. {@code risList} */
    private final RisList risList;
   
    /**
     * Costruttore della finestra di registrazione utente.
     * Inizializza componenti grafici, icone e stato iniziale dei messaggi.
     * 
     * @param gestore Riferimento al gestore degli archivi {@link GestoreArchivi}.
     * @param risList Lista dei ristoranti collegata all’interfaccia {@link RisList}
     */
    public RegUtente(GestoreArchivi gestore, RisList risList) {
        this.gestore = gestore;
        this.risList = risList;
        
        //Inizializzazione vari componenti e Lable.
        initComponents();
        creaImmagini();
        accediErrore.setVisible(false);
        erroreEmail.setVisible(false);
        infoPassPane.setVisible(false);
        infoPass.setVisible(false);
        
        statoUtente.setSelectedIndex(-1);
        
        getRootPane().setDefaultButton(regCliente);
        
    }
    
    //Generated Code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        infoPassPane = new javax.swing.JScrollPane();
        infoPass = new javax.swing.JTextPane();
        eyePass = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        cognomeCliente = new javax.swing.JTextField();
        regCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        posizioneCliente = new javax.swing.JTextField();
        passwordCliente = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        emailCliente = new javax.swing.JTextField();
        erroreEmail = new javax.swing.JLabel();
        accediErrore = new javax.swing.JLabel();
        qmLabel = new javax.swing.JLabel();
        statoUtente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backArrow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoPassPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        infoPass.setEditable(false);
        infoPass.setText("- Da 4 a 20 caratteri.  \n- Almeno una lettera maiuscola.   \n- Almeno una lettera minuscola.   \n- Almeno una cifra.   \n- Nessuna \"@\".");
        infoPassPane.setViewportView(infoPass);

        jPanel3.add(infoPassPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 210, 90));

        eyePass.setBorder(null);
        eyePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePassActionPerformed(evt);
            }
        });
        jPanel3.add(eyePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 20, 20));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("REGISTRAZIONE");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 30, 300, 40));
        jPanel3.add(cognomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 288, -1));

        regCliente.setBackground(new java.awt.Color(0, 102, 102));
        regCliente.setForeground(new java.awt.Color(255, 255, 255));
        regCliente.setText("Registrati");
        regCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regClienteActionPerformed(evt);
            }
        });
        jPanel3.add(regCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 90, 30));

        jLabel2.setText("Username:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 79, -1));

        jLabel3.setText("Cognome:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 82, -1));
        jPanel3.add(usernameCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 288, -1));

        jLabel4.setText("Password:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 70, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel6.setText("cliente ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 110, 26));

        jLabel8.setText("Città:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 75, -1));
        jPanel3.add(posizioneCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 135, -1));
        jPanel3.add(passwordCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 288, -1));

        jLabel10.setText("Nome:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 49, -1));
        jPanel3.add(nomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 288, -1));

        jLabel9.setText("Email:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 68, -1));
        jPanel3.add(emailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 288, -1));

        erroreEmail.setText("Email già registrata.");
        jPanel3.add(erroreEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        accediErrore.setForeground(new java.awt.Color(0, 0, 255));
        accediErrore.setText("Accedi");
        accediErrore.setToolTipText("");
        accediErrore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accediErrore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accediErroreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accediErroreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accediErroreMouseExited(evt);
            }
        });
        jPanel3.add(accediErrore, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        qmLabel.setText("qm");
        qmLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        qmLabel.setFocusable(false);
        qmLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                qmLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                qmLabelMouseReleased(evt);
            }
        });
        jPanel3.add(qmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 20, -1));

        statoUtente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam" }));
        statoUtente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(statoUtente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 135, 20));

        jLabel11.setText("Stato:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TheKnife.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TheKnife");

        backArrow.setBorder(null);
        backArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backArrowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(139, 139, 139))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Codice per il bottone "freccia" per tornare al Frame precedente.
     */
    private void backArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backArrowActionPerformed
        SelezioneTipoUtente Reg1Frame = new SelezioneTipoUtente(gestore, risList);
        Reg1Frame.setVisible(true);
        Reg1Frame.pack();
        Reg1Frame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_backArrowActionPerformed

    /**
     * Gestisce la registrazione dell’utente controllando che tutti i campi siano compilati e validi.
     */
    private void regClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regClienteActionPerformed
        if (!(ValidaReg.campiPieni(nomeCliente.getText(), cognomeCliente.getText(), usernameCliente.getText(), emailCliente.getText(), passwordCliente.getText(), posizioneCliente.getText(), (String)statoUtente.getSelectedItem()))) {
             JOptionPane.showMessageDialog(null, "Inserisci i campi obbligatori");
        } else if (!ValidaReg.mailValida(emailCliente.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Formato mail non valido");
        } else if (!ValidaReg.passValida(passwordCliente.getText().trim())) { 
            JOptionPane.showMessageDialog(null, "Formato password non valido");
        } else if (!gestore.getArchivioUtenti().esisteMail(emailCliente.getText().trim())) {
            gestore.getArchivioUtenti().aggiungiUtente(new Utente(nomeCliente.getText().trim(), cognomeCliente.getText().trim(), usernameCliente.getText().trim(), emailCliente.getText().trim(), passwordCliente.getText().trim(), posizioneCliente.getText().trim(), (String) statoUtente.getSelectedItem(), gestore.getArchivioUtenti().creaID(), "cliente"));
            
            risList.creaLogin();
            this.dispose();
            
            erroreEmail.setVisible(false);
            accediErrore.setVisible(false);
        }else{
            erroreEmail.setVisible(true);
            accediErrore.setVisible(true);
            emailCliente.setText("");
        }
        
    }//GEN-LAST:event_regClienteActionPerformed

    private void accediErroreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accediErroreMouseClicked
        
    }//GEN-LAST:event_accediErroreMouseClicked
    
     /**
     * Rimuove sottolineamento dal testo "Accedi" al passaggio del mouse.
     */
    private void accediErroreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accediErroreMouseExited
         String accedi = "<html> Accedi </html>";
        accediErrore.setText(accedi);
    }//GEN-LAST:event_accediErroreMouseExited

     /**
     * Sottolinea il testo "Accedi" al passaggio del mouse.
     */
    private void accediErroreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accediErroreMouseEntered
        String accedi = "<html><u> Accedi </u></html>";
        accediErrore.setText(accedi);
    }//GEN-LAST:event_accediErroreMouseEntered
    
    /**
     * Mostra le informazioni sulla password al click del mouse.
     */
    private void qmLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qmLabelMousePressed
         infoPass.setVisible(true);
         infoPassPane.setVisible(true);
    }//GEN-LAST:event_qmLabelMousePressed

    
    /**
     * Nasconde le informazioni sulla password al rilascio del mouse.
     */
    private void qmLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qmLabelMouseReleased
        infoPass.setVisible(false);
        infoPassPane.setVisible(false);
    }//GEN-LAST:event_qmLabelMouseReleased
    
    /**
     * Toggle per mostrare o nascondere la password.
     */
    private void eyePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePassActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            passwordCliente.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            passwordCliente.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePassActionPerformed
    
    /**
     * Carica e ridimensiona le icone della finestra.
     */
    private void creaImmagini() {
        //Immagine punto di domanda per le informazioni password ridimensionata ed applicata.
        ImageIcon qmIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\qm.png"));
        Image qm1 = qmIcon.getImage();
        Image qm2 = qm1.getScaledInstance(qmLabel.getWidth(), qmLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon qm3 = new ImageIcon(qm2);
        qmLabel.setIcon(qm3); 
        
        //Immagine per mostrare la password ridimensionata ed applicata.
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\show_pass.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        eyePass.setIcon(sp3);
        this.showPass = sp3;  
        
        //Immagine per nascondere la password ridimensionata.
        ImageIcon hpIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\hide_pass.png"));
        Image hp1 = hpIcon.getImage();
        Image hp2 = hp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hp3 = new ImageIcon(hp2); 
        this.hidePass = hp3;  
        
        //Immagine per pulsante indietro ridimensionata ed applicata.
        ImageIcon backArr = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\backArrow.png"));
        Image ba1 = backArr.getImage();
        Image ba2 = ba1.getScaledInstance(backArrow.getWidth(), backArrow.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ba3 = new ImageIcon(ba2); 
        backArrow.setIcon(ba3);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accediErrore;
    private javax.swing.JButton backArrow;
    private javax.swing.JTextField cognomeCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JLabel erroreEmail;
    private javax.swing.JToggleButton eyePass;
    private javax.swing.JTextPane infoPass;
    private javax.swing.JScrollPane infoPassPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JPasswordField passwordCliente;
    private javax.swing.JTextField posizioneCliente;
    private javax.swing.JLabel qmLabel;
    private javax.swing.JButton regCliente;
    private javax.swing.JComboBox<String> statoUtente;
    private javax.swing.JTextField usernameCliente;
    // End of variables declaration//GEN-END:variables
}
