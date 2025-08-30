/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife.grafica;
import theknife.grafica.PaginaRistoratore;
import theknife.grafica.RisList;
import java.awt.*;
import javax.swing.*;
import theknife.gestori.GestoreArchivi;

/**
 * La classe Login rappresenta la finestra grafica per l'accesso 
 * degli utenti registrati o per l'accesso come ospite all'applicazione.
 * <p>
 * Consente di effettuare il login come cliente oppure ristoratore,
 * oppure di entrare come ospite inserendo la propria posizione e lo stato.
 * </p>
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class Login extends javax.swing.JFrame {
    
    /**
     * Icona utilizzata per mostrare o nascondere la password nel campo di input. {@code showPass} e {@code hidePass}
     */
    private ImageIcon showPass, hidePass;
    
    /**
     * Gestore degli archivi che permette di accedere e gestire utenti, ristoranti, preferiti e commenti. {@code gestore}
     */
    private GestoreArchivi gestore;
    
    /**
     * Riferimento alla finestra contenente la lista dei ristoranti. {@code risList}
     */
    private final RisList risList;
    
    /**
     * Costruttore della finestra di login.
     *
     * @param gestore il {@link GestoreArchivi} utilizzato per gestire utenti e dati
     * @param risList la finestra {@link RisList} con l'elenco dei ristoranti
     */
    public Login(GestoreArchivi gestore, RisList risList) {
        this.gestore = gestore;
        this.risList = risList;
        initComponents();
        creaImmagini();
        
        //Setta il pulsante che si attiva con invio su LoginButton
        getRootPane().setDefaultButton(LoginButton);
    }
    
    //Generated code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Dati = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logMail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        logPass = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        registratiButton = new javax.swing.JButton();
        guestButton = new javax.swing.JButton();
        eyePass = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TheKnife");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setBackground(new java.awt.Color(204, 204, 204));
        Login.setPreferredSize(new java.awt.Dimension(800, 500));
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setBackground(new java.awt.Color(0, 102, 102));
        Logo.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setText("jLabel6");
        jLabel6.setPreferredSize(new java.awt.Dimension(761, 721));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TheKnife.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TheKnife");

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addGroup(LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogoLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)))
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addGroup(LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogoLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogoLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Login.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Dati.setBackground(new java.awt.Color(255, 255, 255));
        Dati.setPreferredSize(new java.awt.Dimension(400, 500));
        Dati.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Dati.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 55, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Email:");
        Dati.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 154, 113, -1));

        logMail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logMail.setMargin(new java.awt.Insets(6, 6, 6, 6));
        logMail.setSelectionStart(6);
        Dati.add(logMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 183, 340, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Password:");
        Dati.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 237, 113, -1));

        logPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logPass.setPreferredSize(new java.awt.Dimension(73, 22));
        Dati.add(logPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 268, 340, 30));

        LoginButton.setBackground(new java.awt.Color(0, 102, 102));
        LoginButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.setFocusPainted(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        Dati.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 81, 29));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Non hai un account?");
        Dati.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 325, 130, -1));

        registratiButton.setBackground(new java.awt.Color(0, 102, 102));
        registratiButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        registratiButton.setForeground(new java.awt.Color(255, 255, 255));
        registratiButton.setText("Registrati!");
        registratiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registratiButton.setFocusPainted(false);
        registratiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registratiButtonActionPerformed(evt);
            }
        });
        Dati.add(registratiButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, 30));

        guestButton.setBackground(new java.awt.Color(0, 102, 102));
        guestButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        guestButton.setForeground(new java.awt.Color(255, 255, 255));
        guestButton.setText("Accedi come ospite");
        guestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guestButton.setFocusPainted(false);
        guestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestButtonActionPerformed(evt);
            }
        });
        Dati.add(guestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        eyePass.setBorder(null);
        eyePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePassActionPerformed(evt);
            }
        });
        Dati.add(eyePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 25, 25));

        jLabel8.setText("Oppure:");
        Dati.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 90, -1));

        Login.add(Dati, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Gestisce l'evento di click sul pulsante di login.
     * <p>
     * Verifica le credenziali inserite e, in base al ruolo dell'utente,
     * apre la finestra dedicata al cliente o al ristoratore.
     * </p>
     *
     * @param evt evento generato dal pulsante
     */
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        if (gestore.getArchivioUtenti().esisteUtente(logMail.getText(), logPass.getText())) {
                int idUtente = gestore.getArchivioUtenti().getId(logMail.getText(), logPass.getText());
                gestore.getArchivioUtenti().setUtenteAttuale(idUtente);
                
            if(gestore.getArchivioUtenti().getUtenteAttuale().getRuoloUtente().equals("cliente")){
                risList.versioneGuest();
                risList.filtraPosizione(gestore.getArchivioUtenti().getUtenteAttuale().getPosizioneUtente(), 10);
                risList.setVisible(true);
                risList.pack();
                risList.setLocationRelativeTo(null);
                risList.creaFiltro();
                this.dispose();
            } else{
                PaginaRistoratore rg = new PaginaRistoratore(gestore, risList);
                rg.setVisible(true);
                rg.setLocationRelativeTo(null);
                this.dispose();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Email o password errati");
            logPass.setText("");
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    /**
     * Gestisce l'evento di click sul pulsante "Accedi come guest".
     * <p>
     * Permette di inserire una posizione e uno stato tramite una finestra di dialogo,
     * quindi mostra la lista dei ristoranti in modalità guest.
     * </p>
     *
     * @param evt evento generato dal pulsante
     */
    private void guestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestButtonActionPerformed
        gestore.getArchivioUtenti().setUtenteAttuale(0);
        risList.creaFiltro();
                                  
        //JDialog
        JDialog dialog = new JDialog(this, "Inserisci posizione e stato", true);
        
        //Text field, Combo box e Bottone conferma
        JTextField posizione = new JTextField(15);
        JComboBox<String> stato = new JComboBox<>(new String[]{"Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam"});
        stato.setSelectedIndex(-1);
        JButton conferma = new JButton("Conferma");

        //Contenitore
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        //Grandezza e allineamento componenti
        posizione.setPreferredSize(new Dimension(250, 30));
        posizione.setMaximumSize(new Dimension(250, 30));
        posizione.setAlignmentX(Component.CENTER_ALIGNMENT);
        stato.setPreferredSize(new Dimension(250, 30));
        stato.setMaximumSize(new Dimension(250, 30));
        stato.setAlignmentX(Component.CENTER_ALIGNMENT);
        conferma.setAlignmentX(Component.CENTER_ALIGNMENT);
        conferma.setPreferredSize(new Dimension(150, 40));
        conferma.setMaximumSize(new Dimension(130, 40));
        conferma.setFont(new Font("Arial", Font.BOLD, 14));
        conferma.setBackground(new Color(0, 102, 102));
        conferma.setForeground(new Color(255, 255, 255));
        

        JLabel labelPosizione = new JLabel("Posizione:");
        labelPosizione.setFont(new Font("Arial", Font.BOLD, 18));
        labelPosizione.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelPosizione);
        panel.add(posizione);
        panel.add(Box.createVerticalStrut(15)); 

        JLabel labelStato = new JLabel("Stato:");
        labelStato.setFont(new Font("Arial", Font.BOLD, 18));
        labelStato.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelStato);
        panel.add(stato);
        panel.add(Box.createVerticalStrut(15)); 

        panel.add(conferma);

        dialog.add(panel);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(this);

        //Bottone conferma
        conferma.addActionListener(e -> {
            String p = posizione.getText();
            String s = (String) stato.getSelectedItem();
            gestore.getArchivioUtenti().getUtenteAttuale().setStatoUtente(s);

            if (p.isEmpty() || s == null) {
                JOptionPane.showMessageDialog(dialog, "Compila i campi obbligatori", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                dialog.dispose();  
                this.dispose(); 
                GestoreArchivi.RisListFrame.filtraPosizione(p, 10);
                GestoreArchivi.RisListFrame.versioneGuest();
                GestoreArchivi.RisListFrame.setVisible(true);
                GestoreArchivi.RisListFrame.pack();
                GestoreArchivi.RisListFrame.setLocationRelativeTo(null);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_guestButtonActionPerformed

    
    /**
     * Gestisce l'evento di click sul pulsante "Registrati".
     * <p>
     * Apre la finestra {@link SelezioneTipoUtente} per registrare un nuovo utente.
     * </p>
     *
     * @param evt evento generato dal pulsante
     */
    private void registratiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registratiButtonActionPerformed
        SelezioneTipoUtente Reg1Frame = new SelezioneTipoUtente(gestore, risList);
        Reg1Frame.setVisible(true);
        Reg1Frame.pack();
        Reg1Frame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_registratiButtonActionPerformed

    /**
     * Gestisce l'evento sul pulsante a forma di occhio accanto al campo password.
     * <p>
     * Alterna tra la visualizzazione e l'oscuramento della password
     * modificando l'icona e il carattere.
     * </p>
     *
     * @param evt evento generato dal pulsante
     */
    private void eyePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePassActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            logPass.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            logPass.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePassActionPerformed

    /**
     * Inizializza e ridimensiona le icone {@code showPass} e {@code hidePass}
     * per il pulsante che mostra/nasconde la password.
     */
    public void creaImmagini() {
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
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dati;
    private javax.swing.JPanel Login;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel Logo;
    private javax.swing.JToggleButton eyePass;
    private javax.swing.JButton guestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField logMail;
    private javax.swing.JPasswordField logPass;
    private javax.swing.JButton registratiButton;
    // End of variables declaration//GEN-END:variables
}
