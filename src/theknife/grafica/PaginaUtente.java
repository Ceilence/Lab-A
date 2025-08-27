/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife.grafica;

import theknife.utili.ValidaReg;
import theknife.grafica.RisList;
import theknife.essenziali.Preferito;
import theknife.essenziali.Ristorante;
import theknife.essenziali.Utente;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;


/**
 *
 * @author Alefr
 */
public class PaginaUtente extends javax.swing.JFrame {

    private GestoreArchivi gestore; 
    private RisList risList;
    private ImageIcon showPass, hidePass;
    private String originale;
    
    
    
    public PaginaUtente(GestoreArchivi gestore, RisList risList) {
        this.gestore = gestore;
        this.risList = risList;
        
        initComponents();
        creaImmagine();
        contenitorePreferiti.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        impostaModifiche();
        //Setta il pulsante che si attiva con invio su aggiorna
        getRootPane().setDefaultButton(aggiorna);
        
        //Pannello di destra, all'apertura mostra dettagli utente
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
    }
    
    private void mostraPreferiti(){
        contenitorePreferiti.removeAll();
        Utente u = gestore.getArchivioUtenti().getUtenteAttuale();
        
        for(Preferito p : gestore.getArchivioPreferiti().getPreferiti()){
            if(p.getIdUtente() == u.getIdUtente()) {
                contenitorePreferiti.add(new PannelloPreferiti(gestore, gestore.getArchivioRis().getRistorante(p.getIdRis()),PaginaUtente.this, risList, contenitorePreferiti));
            }
        }
    }
    
    public void generaCommentiUtente() {
        contenitoreRec.removeAll();
        int idUtente = gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente();
        ArrayList<CommentiRistoranti> lista = gestore.getArchivioCommenti().getCommentiPerUtente(idUtente);
        for (CommentiRistoranti c : lista) {
            contenitoreRec.add(new PannelloRecensionePersonale(gestore, c, PaginaUtente.this, risList));
            
            if (c.haRisposta()) {
                PannelloRisposta panRisposta = new PannelloRisposta(gestore, c);
                panRisposta.setPreferredSize(new Dimension(650,80));
                panRisposta.setMaximumSize(new Dimension(650,80));
                
                contenitoreRec.add(panRisposta);
            }
            contenitoreRec.add(Box.createVerticalStrut(2));
            
        }   
        contenitoreRec.revalidate();
        contenitoreRec.repaint();
    }
    
    private void impostaModifiche() {
        //Dati dell'utente non modificabili
        Utente u=gestore.getArchivioUtenti().getUtenteAttuale();
        nome.setText(u.getNomeUtente());
        nome.setEditable(false);
        cognome.setText(u.getCognomeUtente());
        cognome.setEditable(false);
        email.setText(u.getEmailUtente());
        email.setEditable(false);
        username.setText(u.getUsernameUtente());
        username.setEditable(false);
        posizione.setText(u.getPosizioneUtente());
        posizione.setEditable(false);
        password.setText(u.getPassUtente());
        password.setEditable(false);
        statoUtente.setSelectedItem(u.getStatoUtente());
        statoUtente.setEditable(false);
        
        //Dati dell'utente modificabili
        nome1.setText(u.getNomeUtente());
        nome1.setEditable(true);
        cognome1.setText(u.getCognomeUtente());
        cognome1.setEditable(true);
        email1.setText(u.getEmailUtente());
        email1.setEditable(true);
        username1.setText(u.getUsernameUtente());
        username1.setEditable(true);
        posizione1.setText(u.getPosizioneUtente());
        posizione1.setEditable(true);
        password1.setText(u.getPassUtente());
        password1.setEditable(true);
        statoUtente1.setSelectedItem(u.getStatoUtente());
        statoUtente1.setEditable(true);
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contenitore = new javax.swing.JPanel();
        testa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        menu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        detUtenteLabel = new javax.swing.JLabel();
        modDatiLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        prefLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        recLabel = new javax.swing.JLabel();
        pannelloDestra = new javax.swing.JPanel();
        dettagliUtente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        cognome = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        posizione = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        eyePass = new javax.swing.JToggleButton();
        logout = new javax.swing.JButton();
        statoUtente = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        modificaDati = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nome1 = new javax.swing.JTextField();
        cognome1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        posizione1 = new javax.swing.JTextField();
        username1 = new javax.swing.JTextField();
        eyePass1 = new javax.swing.JToggleButton();
        aggiorna = new javax.swing.JButton();
        statoUtente1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        preferiti = new javax.swing.JScrollPane();
        contenitorePreferiti = new javax.swing.JPanel();
        modificaPreferiti = new javax.swing.JScrollPane();
        recensioni = new javax.swing.JScrollPane();
        contenitoreRec = new javax.swing.JPanel();
        modRecensioni = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(1110, 700));
        setUndecorated(true);
        setSize(new java.awt.Dimension(500, 400));

        contenitore.setBackground(new java.awt.Color(0, 102, 102));
        contenitore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        contenitore.setMaximumSize(new java.awt.Dimension(1110, 700));
        contenitore.setMinimumSize(new java.awt.Dimension(1110, 700));
        contenitore.setPreferredSize(new java.awt.Dimension(1110, 700));
        contenitore.setLayout(new java.awt.GridBagLayout());

        testa.setBackground(new java.awt.Color(0, 102, 102));
        testa.setForeground(new java.awt.Color(0, 102, 102));
        testa.setMaximumSize(new java.awt.Dimension(1098, 62));
        testa.setMinimumSize(new java.awt.Dimension(1098, 62));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiudi(evt);
            }
        });

        javax.swing.GroupLayout testaLayout = new javax.swing.GroupLayout(testa);
        testa.setLayout(testaLayout);
        testaLayout.setHorizontalGroup(
            testaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 999, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );
        testaLayout.setVerticalGroup(
            testaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 8);
        contenitore.add(testa, gridBagConstraints);

        menu.setMaximumSize(new java.awt.Dimension(309, 620));
        menu.setMinimumSize(new java.awt.Dimension(309, 620));
        menu.setPreferredSize(new java.awt.Dimension(309, 620));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel9.setText("Pagina utente:");

        detUtenteLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        detUtenteLabel.setText("Dettagli utente");
        detUtenteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detUtenteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detUtenteLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                detUtenteLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                detUtenteLabelMouseExited(evt);
            }
        });

        modDatiLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modDatiLabel.setText("Modifica dati");
        modDatiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modDatiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modDatiLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modDatiLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modDatiLabelMouseExited(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setMaximumSize(new java.awt.Dimension(50, 10));

        prefLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        prefLabel.setText("Preferiti");
        prefLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prefLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prefLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prefLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prefLabelMouseExited(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));

        recLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        recLabel.setText("Le mie recensioni");
        recLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detUtenteLabel)
                            .addComponent(modDatiLabel)
                            .addComponent(prefLabel)
                            .addComponent(recLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detUtenteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modDatiLabel)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prefLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recLabel)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 8, 0);
        contenitore.add(menu, gridBagConstraints);

        pannelloDestra.setMaximumSize(new java.awt.Dimension(783, 620));
        pannelloDestra.setMinimumSize(new java.awt.Dimension(783, 620));
        pannelloDestra.setPreferredSize(new java.awt.Dimension(783, 620));
        pannelloDestra.setLayout(new java.awt.CardLayout());

        dettagliUtente.setMaximumSize(new java.awt.Dimension(783, 620));
        dettagliUtente.setMinimumSize(new java.awt.Dimension(783, 620));
        dettagliUtente.setPreferredSize(new java.awt.Dimension(783, 620));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Dettagli utente");

        nome.setBackground(new java.awt.Color(204, 204, 204));
        nome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nome.setMaximumSize(new java.awt.Dimension(64, 22));

        cognome.setBackground(new java.awt.Color(204, 204, 204));
        cognome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome.setMaximumSize(new java.awt.Dimension(64, 22));

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email.setMaximumSize(new java.awt.Dimension(64, 22));

        username.setBackground(new java.awt.Color(204, 204, 204));
        username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        username.setMaximumSize(new java.awt.Dimension(64, 22));

        posizione.setBackground(new java.awt.Color(204, 204, 204));
        posizione.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        posizione.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cognome");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("E-mail");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Posizione");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Username");

        password.setBackground(new java.awt.Color(204, 204, 204));
        password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password.setMaximumSize(new java.awt.Dimension(64, 22));

        eyePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass.setMaximumSize(new java.awt.Dimension(30, 30));
        eyePass.setMinimumSize(new java.awt.Dimension(30, 30));
        eyePass.setPreferredSize(new java.awt.Dimension(30, 30));
        eyePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePassActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(0, 102, 102));
        logout.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        statoUtente.setBackground(new java.awt.Color(204, 204, 204));
        statoUtente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statoUtente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam" }));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Stato");

        javax.swing.GroupLayout dettagliUtenteLayout = new javax.swing.GroupLayout(dettagliUtente);
        dettagliUtente.setLayout(dettagliUtenteLayout);
        dettagliUtenteLayout.setHorizontalGroup(
            dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dettagliUtenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(dettagliUtenteLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout)
                            .addGroup(dettagliUtenteLayout.createSequentialGroup()
                                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(statoUtente, 0, 285, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(posizione, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dettagliUtenteLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cognome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(dettagliUtenteLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(dettagliUtenteLayout.createSequentialGroup()
                                                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(eyePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        dettagliUtenteLayout.setVerticalGroup(
            dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dettagliUtenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eyePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dettagliUtenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posizione, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statoUtente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logout)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pannelloDestra.add(dettagliUtente, "dettagli");

        modificaDati.setMaximumSize(new java.awt.Dimension(783, 620));
        modificaDati.setMinimumSize(new java.awt.Dimension(783, 620));
        modificaDati.setPreferredSize(new java.awt.Dimension(783, 620));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel12.setText("Modifica dati utente");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Nome");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Cognome");

        nome1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nome1.setMaximumSize(new java.awt.Dimension(64, 22));

        cognome1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome1.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("E-mail");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Password");

        email1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email1.setMaximumSize(new java.awt.Dimension(64, 22));

        password1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password1.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Posizione");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Username");

        posizione1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        posizione1.setMaximumSize(new java.awt.Dimension(64, 22));

        username1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        username1.setMaximumSize(new java.awt.Dimension(64, 22));

        eyePass1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass1.setMaximumSize(new java.awt.Dimension(30, 30));
        eyePass1.setMinimumSize(new java.awt.Dimension(30, 30));
        eyePass1.setPreferredSize(new java.awt.Dimension(30, 30));
        eyePass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePass1ActionPerformed(evt);
            }
        });

        aggiorna.setBackground(new java.awt.Color(0, 102, 102));
        aggiorna.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        aggiorna.setForeground(new java.awt.Color(255, 255, 255));
        aggiorna.setText("Aggiorna");
        aggiorna.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiornaActionPerformed(evt);
            }
        });

        statoUtente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statoUtente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam" }));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Stato");

        javax.swing.GroupLayout modificaDatiLayout = new javax.swing.GroupLayout(modificaDati);
        modificaDati.setLayout(modificaDatiLayout);
        modificaDatiLayout.setHorizontalGroup(
            modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificaDatiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(modificaDatiLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statoUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(modificaDatiLayout.createSequentialGroup()
                                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(posizione1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cognome1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(modificaDatiLayout.createSequentialGroup()
                                        .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eyePass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(aggiorna)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        modificaDatiLayout.setVerticalGroup(
            modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificaDatiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eyePass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posizione1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statoUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aggiorna)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pannelloDestra.add(modificaDati, "modifica");

        preferiti.setMaximumSize(new java.awt.Dimension(783, 620));
        preferiti.setMinimumSize(new java.awt.Dimension(783, 620));
        preferiti.setPreferredSize(new java.awt.Dimension(783, 620));

        contenitorePreferiti.setBackground(new java.awt.Color(255, 255, 255));
        contenitorePreferiti.setLayout(new javax.swing.BoxLayout(contenitorePreferiti, javax.swing.BoxLayout.Y_AXIS));
        preferiti.setViewportView(contenitorePreferiti);

        pannelloDestra.add(preferiti, "preferiti");

        modificaPreferiti.setMaximumSize(new java.awt.Dimension(783, 620));
        modificaPreferiti.setMinimumSize(new java.awt.Dimension(783, 620));
        modificaPreferiti.setPreferredSize(new java.awt.Dimension(783, 620));
        modificaPreferiti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificaPreferitiMouseClicked(evt);
            }
        });
        pannelloDestra.add(modificaPreferiti, "modificaPreferiti");

        contenitoreRec.setBackground(new java.awt.Color(255, 255, 255));
        contenitoreRec.setLayout(new javax.swing.BoxLayout(contenitoreRec, javax.swing.BoxLayout.Y_AXIS));
        recensioni.setViewportView(contenitoreRec);

        pannelloDestra.add(recensioni, "recensioni");
        pannelloDestra.add(modRecensioni, "modRecensioni");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 8, 8);
        contenitore.add(pannelloDestra, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenitore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenitore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Bottone per tornare alla pagina principale
    private void chiudi(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiudi
        risList.setEnabled(true);
        this.dispose();
        risList.setVisible(true);
    }//GEN-LAST:event_chiudi

    private void eyePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePassActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            password.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePassActionPerformed

    //Apre pagina dettagli utente se cliccato
    private void detUtenteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detUtenteLabelMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
    }//GEN-LAST:event_detUtenteLabelMouseClicked

    //Apre pagina modifica dati utente se cliccato
    private void modDatiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modDatiLabelMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "modifica");
    }//GEN-LAST:event_modDatiLabelMouseClicked
    
    //Eventi per sottolineare label nel menù
    private void detUtenteLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detUtenteLabelMouseEntered
        originale = detUtenteLabel.getText();
        detUtenteLabel.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_detUtenteLabelMouseEntered

    private void detUtenteLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detUtenteLabelMouseExited
        detUtenteLabel.setText(originale);
    }//GEN-LAST:event_detUtenteLabelMouseExited

    private void modDatiLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modDatiLabelMouseEntered
        originale = modDatiLabel.getText();
        modDatiLabel.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_modDatiLabelMouseEntered

    private void modDatiLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modDatiLabelMouseExited
        modDatiLabel.setText(originale);
    }//GEN-LAST:event_modDatiLabelMouseExited

    private void eyePass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePass1ActionPerformed
         if (eyePass1.isSelected()) {
            eyePass1.setIcon(hidePass);
            password1.setEchoChar((char)0);
        } else {
            eyePass1.setIcon(showPass);
            password1.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePass1ActionPerformed

    private void aggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiornaActionPerformed
        if (!(ValidaReg.campiPieni(nome1.getText(), cognome1.getText(), username1.getText(), email1.getText(), password1.getText(), posizione1.getText(), gestore.getArchivioUtenti().getUtenteAttuale().getStatoUtente()))) {
            JOptionPane.showMessageDialog(null, "Inserisci i campi obbligatori");
        } else if (!ValidaReg.mailValida(email1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Formato mail non valido");
        } else if (!ValidaReg.passValida(password1.getText().trim())) { 
            JOptionPane.showMessageDialog(null, "Formato password non valido");
        }else{
            //Aggiorna il file utenti con i dati aggiornati
            Utente u = gestore.getArchivioUtenti().getUtenteAttuale();
            u.setNomeUtente(nome1.getText());
            u.setCognomeUtente(cognome1.getText());
            u.setEmailUtente(email1.getText());
            u.setPassUtente(password1.getText());
            u.setUsernameUtente(username1.getText());
            u.setPosizioneUtente(posizione1.getText());
            u.setStatoUtente((String) statoUtente1.getSelectedItem());
            gestore.getArchivioUtenti().aggiornaUtenti();
            
            nome.setText(nome1.getText());
            cognome.setText(cognome1.getText());
            email.setText(email1.getText());
            password.setText(password1.getText());
            username.setText(username1.getText());
            posizione.setText(posizione1.getText());
            statoUtente.setSelectedItem(statoUtente1.getSelectedItem());
            
            JOptionPane.showMessageDialog(this, "Dati aggiornati con successo!");
            
            CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
            cl.show(pannelloDestra, "dettagli");
        }
    }//GEN-LAST:event_aggiornaActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        gestore.getArchivioUtenti().setUtenteAttuale(0);
        risList.setEnabled(true);
        risList.setVisible(false);
        risList.chiudiFiltro();
        
        risList.creaLogin();
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void prefLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prefLabelMouseEntered
        originale = prefLabel.getText();
        prefLabel.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_prefLabelMouseEntered

    private void prefLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prefLabelMouseExited
        prefLabel.setText(originale);
    }//GEN-LAST:event_prefLabelMouseExited

    private void prefLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prefLabelMouseClicked
        mostraPreferiti();
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "preferiti");
    }//GEN-LAST:event_prefLabelMouseClicked

    private void modificaPreferitiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificaPreferitiMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "modificaPreferiti");
    }//GEN-LAST:event_modificaPreferitiMouseClicked

    private void recLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recLabelMouseEntered
        originale = recLabel.getText();
        recLabel.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_recLabelMouseEntered

    private void recLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recLabelMouseExited
        recLabel.setText(originale);
    }//GEN-LAST:event_recLabelMouseExited

    private void recLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recLabelMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "recensioni");
        generaCommentiUtente();
    }//GEN-LAST:event_recLabelMouseClicked

    private void creaImmagine() {
        //Immagine per mostrare la password ridimensionata ed applicata.
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\show_pass.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        eyePass.setIcon(sp3);
        eyePass1.setIcon(sp3);
        this.showPass = sp3;  
        
         //Immagine per nascondere la password ridimensionata.
        ImageIcon hpIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\hide_pass.png"));
        Image hp1 = hpIcon.getImage();
        Image hp2 = hp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hp3 = new ImageIcon(hp2); 
        this.hidePass = hp3;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiorna;
    private javax.swing.JTextField cognome;
    private javax.swing.JTextField cognome1;
    private javax.swing.JPanel contenitore;
    private javax.swing.JPanel contenitorePreferiti;
    private javax.swing.JPanel contenitoreRec;
    private javax.swing.JLabel detUtenteLabel;
    private javax.swing.JPanel dettagliUtente;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JToggleButton eyePass;
    private javax.swing.JToggleButton eyePass1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton logout;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel modDatiLabel;
    private javax.swing.JScrollPane modRecensioni;
    private javax.swing.JPanel modificaDati;
    private javax.swing.JScrollPane modificaPreferiti;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nome1;
    private javax.swing.JPanel pannelloDestra;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField posizione;
    private javax.swing.JTextField posizione1;
    private javax.swing.JLabel prefLabel;
    private javax.swing.JScrollPane preferiti;
    private javax.swing.JLabel recLabel;
    private javax.swing.JScrollPane recensioni;
    private javax.swing.JComboBox<String> statoUtente;
    private javax.swing.JComboBox<String> statoUtente1;
    private javax.swing.JPanel testa;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables
}
