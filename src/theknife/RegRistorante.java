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
    private static GestoreArchivi gestore;
    
    public RegRistorante(GestoreArchivi gestore) { 
        //Inizializzazione vari componenti e Lable.
        initComponents();  
        
        this.gestore = gestore;
        boolean delivery;
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        backArrow = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        dettagliUtente2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        nome3 = new javax.swing.JTextField();
        cognome2 = new javax.swing.JTextField();
        email2 = new javax.swing.JTextField();
        username2 = new javax.swing.JTextField();
        posizione2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        password2 = new javax.swing.JPasswordField();
        eyePass2 = new javax.swing.JToggleButton();
        logout2 = new javax.swing.JButton();
        modificaDati = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nome4 = new javax.swing.JTextField();
        cognome3 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        email3 = new javax.swing.JTextField();
        password3 = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        posizione3 = new javax.swing.JTextField();
        username3 = new javax.swing.JTextField();
        eyePass3 = new javax.swing.JToggleButton();
        aggiorna = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        città = new javax.swing.JTextField();
        regRis = new javax.swing.JButton();
        locRist = new javax.swing.JLabel();
        indRist = new javax.swing.JLabel();
        indirizzo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        nomeRist = new javax.swing.JLabel();
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
        cuisRist = new javax.swing.JLabel();
        cucina = new javax.swing.JTextField();
        prezzoBox = new javax.swing.JComboBox<>();
        priceRist = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1110, 700));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel9.setText("Pagina ristoratore");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setMaximumSize(new java.awt.Dimension(50, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Dettagli ristoratore");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Modifica dati");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel35.setText("Dettagli ristoratore");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel35))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backArrow.setBorder(null);
        backArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backArrowActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel4.setLayout(new java.awt.CardLayout());

        dettagliUtente2.setMaximumSize(new java.awt.Dimension(783, 620));
        dettagliUtente2.setMinimumSize(new java.awt.Dimension(783, 620));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel21.setText("Dettagli ristoratore");

        nome3.setBackground(new java.awt.Color(204, 204, 204));
        nome3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nome3.setMaximumSize(new java.awt.Dimension(64, 22));
        nome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome3ActionPerformed(evt);
            }
        });

        cognome2.setBackground(new java.awt.Color(204, 204, 204));
        cognome2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome2.setMaximumSize(new java.awt.Dimension(64, 22));
        cognome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cognome2ActionPerformed(evt);
            }
        });

        email2.setBackground(new java.awt.Color(204, 204, 204));
        email2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email2.setMaximumSize(new java.awt.Dimension(64, 22));

        username2.setBackground(new java.awt.Color(204, 204, 204));
        username2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        username2.setMaximumSize(new java.awt.Dimension(64, 22));

        posizione2.setBackground(new java.awt.Color(204, 204, 204));
        posizione2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        posizione2.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Nome");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Cognome");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("E-mail");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setText("Password");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Posizione");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Username");

        password2.setBackground(new java.awt.Color(204, 204, 204));
        password2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password2.setMaximumSize(new java.awt.Dimension(64, 22));
        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });

        eyePass2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass2.setMaximumSize(new java.awt.Dimension(30, 30));
        eyePass2.setMinimumSize(new java.awt.Dimension(30, 30));
        eyePass2.setPreferredSize(new java.awt.Dimension(30, 30));
        eyePass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePass2ActionPerformed(evt);
            }
        });

        logout2.setBackground(new java.awt.Color(0, 102, 102));
        logout2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        logout2.setForeground(new java.awt.Color(255, 255, 255));
        logout2.setText("Logout");
        logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dettagliUtente2Layout = new javax.swing.GroupLayout(dettagliUtente2);
        dettagliUtente2.setLayout(dettagliUtente2Layout);
        dettagliUtente2Layout.setHorizontalGroup(
            dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dettagliUtente2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(dettagliUtente2Layout.createSequentialGroup()
                        .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(email2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(posizione2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dettagliUtente2Layout.createSequentialGroup()
                                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(username2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eyePass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cognome2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(logout2))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        dettagliUtente2Layout.setVerticalGroup(
            dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dettagliUtente2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eyePass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dettagliUtente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posizione2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(logout2)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jPanel4.add(dettagliUtente2, "dettagli");

        modificaDati.setMaximumSize(new java.awt.Dimension(783, 620));
        modificaDati.setMinimumSize(new java.awt.Dimension(783, 620));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel28.setText("Modifica dati ristoratore");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setText("Nome");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setText("Cognome");

        nome4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nome4.setMaximumSize(new java.awt.Dimension(64, 22));
        nome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome4ActionPerformed(evt);
            }
        });

        cognome3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome3.setMaximumSize(new java.awt.Dimension(64, 22));
        cognome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cognome3ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setText("E-mail");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setText("Password");

        email3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email3.setMaximumSize(new java.awt.Dimension(64, 22));

        password3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password3.setMaximumSize(new java.awt.Dimension(64, 22));
        password3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password3ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setText("Posizione");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setText("Username");

        posizione3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        posizione3.setMaximumSize(new java.awt.Dimension(64, 22));

        username3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        username3.setMaximumSize(new java.awt.Dimension(64, 22));

        eyePass3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass3.setMaximumSize(new java.awt.Dimension(30, 30));
        eyePass3.setMinimumSize(new java.awt.Dimension(30, 30));
        eyePass3.setPreferredSize(new java.awt.Dimension(30, 30));
        eyePass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePass3ActionPerformed(evt);
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

        javax.swing.GroupLayout modificaDatiLayout = new javax.swing.GroupLayout(modificaDati);
        modificaDati.setLayout(modificaDatiLayout);
        modificaDatiLayout.setHorizontalGroup(
            modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificaDatiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(modificaDatiLayout.createSequentialGroup()
                        .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome4, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(email3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(posizione3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(modificaDatiLayout.createSequentialGroup()
                                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(username3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eyePass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cognome3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(aggiorna))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        modificaDatiLayout.setVerticalGroup(
            modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificaDatiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eyePass3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posizione3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aggiorna)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jPanel4.add(modificaDati, "modifica");

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setText("REGISTRAZIONE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 300, 40));
        jPanel2.add(città, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 290, -1));

        regRis.setBackground(new java.awt.Color(0, 102, 102));
        regRis.setForeground(new java.awt.Color(255, 255, 255));
        regRis.setText("Registra");
        regRis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regRisActionPerformed(evt);
            }
        });
        jPanel2.add(regRis, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 90, 30));

        locRist.setText("Città:");
        jPanel2.add(locRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 79, -1));

        indRist.setText("indirizzo:");
        jPanel2.add(indRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 82, -1));
        jPanel2.add(indirizzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 290, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel14.setText("ristorante ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 160, 26));

        nomeRist.setText("Nome:");
        jPanel2.add(nomeRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 49, -1));
        jPanel2.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 290, -1));

        lonRist.setText("Longitudine:");
        jPanel2.add(lonRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 68, -1));
        jPanel2.add(longitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 135, -1));
        jPanel2.add(latitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 135, -1));

        latRist.setText("Latitudine:");
        jPanel2.add(latRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 68, -1));
        jPanel2.add(descrizione, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 290, -1));

        desRist.setText("Descrizione:");
        jPanel2.add(desRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));
        jPanel2.add(delcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, -1, -1));
        jPanel2.add(prencheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, -1, -1));

        deliveryRist.setText("Delivery:");
        jPanel2.add(deliveryRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        prenOnl.setText("Prenotazione:");
        jPanel2.add(prenOnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        cuisRist.setText("Tipo Cucina:");
        jPanel2.add(cuisRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 70, -1));
        jPanel2.add(cucina, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 290, -1));

        prezzoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$", "$$", "$$$", "$$$$" }));
        jPanel2.add(prezzoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 70, 20));

        priceRist.setText("Fascia prezzo:");
        jPanel2.add(priceRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));

        jPanel4.add(jPanel2, "card4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        gestore.getArchivioRis().aggiungiRis(new Ristorante(nome.getText(), indirizzo.getText(), città.getText(), (String)prezzoBox.getSelectedItem(), cucina.getText(), Double.parseDouble(longitudine.getText().trim()), Double.parseDouble(latitudine.getText().trim()), " ", 0, delcheck.isSelected(), prencheck.isSelected(), descrizione.getText(), gestore.getArchivioRis().creaID()));
    }//GEN-LAST:event_regRisActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        originale = jLabel10.getText();
        jLabel10.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setText(originale);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "modifica");
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        originale = jLabel11.getText();
        jLabel11.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel11.setText(originale);
    }//GEN-LAST:event_jLabel12MouseExited

    private void nome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome3ActionPerformed

    private void cognome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cognome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cognome2ActionPerformed

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    private void eyePass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePass2ActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            password.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePass2ActionPerformed

    private void logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout2ActionPerformed

    }//GEN-LAST:event_logout2ActionPerformed

    private void nome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome4ActionPerformed

    private void cognome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cognome3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cognome3ActionPerformed

    private void password3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password3ActionPerformed

    private void eyePass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePass3ActionPerformed
        if (eyePass1.isSelected()) {
            eyePass1.setIcon(hidePass);
            password1.setEchoChar((char)0);
        } else {
            eyePass1.setIcon(showPass);
            password1.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePass3ActionPerformed

    private void aggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiornaActionPerformed
        if (!(ValidaReg.campiPieni(nome1.getText(), cognome1.getText(), username1.getText(), email1.getText(), password1.getText(), posizione1.getText()))) {
            JOptionPane.showMessageDialog(null, "Inserisci i campi obbligatori");
        } else if (!ValidaReg.mailValida(email1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Formato mail non valido");
        } else if (!ValidaReg.passValida(password1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Formato password non valido");
        }else{
            Utente u = gestore.getArchivioUtenti().getUtenteAttuale();
            u.setNomeUtente(nome1.getText());
            u.setCognomeUtente(cognome1.getText());
            u.setEmailUtente(email1.getText());
            u.setPassUtente(password1.getText());
            u.setUsernameUtente(username1.getText());
            u.setPosizioneUtente(posizione1.getText());
            gestore.getArchivioUtenti().aggiornaUtenti();

            JOptionPane.showMessageDialog(this, "Dati aggiornati con successo!");

            CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
            cl.show(pannelloDestra, "dettagli");
        }

    }//GEN-LAST:event_aggiornaActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseExited
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegRistorante(gestore).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiorna;
    private javax.swing.JButton backArrow;
    private javax.swing.JTextField città;
    private javax.swing.JTextField cognome2;
    private javax.swing.JTextField cognome3;
    private javax.swing.JTextField cucina;
    private javax.swing.JLabel cuisRist;
    private javax.swing.JCheckBox delcheck;
    private javax.swing.JLabel deliveryRist;
    private javax.swing.JLabel desRist;
    private javax.swing.JTextField descrizione;
    private javax.swing.JPanel dettagliUtente2;
    private javax.swing.JTextField email2;
    private javax.swing.JTextField email3;
    private javax.swing.JToggleButton eyePass2;
    private javax.swing.JToggleButton eyePass3;
    private javax.swing.JLabel indRist;
    private javax.swing.JTextField indirizzo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel latRist;
    private javax.swing.JTextField latitudine;
    private javax.swing.JLabel locRist;
    private javax.swing.JButton logout2;
    private javax.swing.JLabel lonRist;
    private javax.swing.JTextField longitudine;
    private javax.swing.JPanel modificaDati;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nome3;
    private javax.swing.JTextField nome4;
    private javax.swing.JLabel nomeRist;
    private javax.swing.JPasswordField password2;
    private javax.swing.JPasswordField password3;
    private javax.swing.JTextField posizione2;
    private javax.swing.JTextField posizione3;
    private javax.swing.JLabel prenOnl;
    private javax.swing.JCheckBox prencheck;
    private javax.swing.JComboBox<String> prezzoBox;
    private javax.swing.JLabel priceRist;
    private javax.swing.JButton regRis;
    private javax.swing.JTextField username2;
    private javax.swing.JTextField username3;
    // End of variables declaration//GEN-END:variables

}
