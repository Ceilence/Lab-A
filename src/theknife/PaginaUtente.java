/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Alefr
 */
public class PaginaUtente extends javax.swing.JFrame {

    private GestoreArchivi gestore; 
    private RisList risList;
    private final ImageIcon showPass;
    private final ImageIcon hidePass;
    private String originale;
    
    
    public PaginaUtente(GestoreArchivi gestore, RisList risList) {
        this.gestore = gestore;
        this.risList = risList;
        
        initComponents();
        
        
        //Setta il pulsante che si attiva con invio su aggiorna
        getRootPane().setDefaultButton(aggiorna);
        
        //Per togliere sottolineatura
        
        //Pannello di destra, all'apertura mostra dettagli utente
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
        
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
        
        //Immagine per mostrare la password ridimensionata ed applicata.
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\show_pass.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        eyePass.setIcon(sp3);
        this.showPass = sp3;  
        
         //Immagine per nascondere la password ridimensionata.
        ImageIcon hpIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\hide_pass.png"));
        Image hp1 = hpIcon.getImage();
        Image hp2 = hp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hp3 = new ImageIcon(hp2); 
        this.hidePass = hp3;
        
    }
    
    public void mostraPreferiti(){
        // Pannello che conterrà i ristoranti preferiti
        JPanel contenitore = new JPanel();
        contenitore.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));
        contenitore.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Recupera l'utente attuale
        Utente u = gestore.getArchivioUtenti().getUtenteAttuale();
        
        for(Preferito p : gestore.getArchivioPreferiti().getPreferiti()){
            if(p.getIdUtente() == u.getIdUtente()){
                
                //Ottengo il ristorante con l'id segnato in ArchivioPreferiti
                Ristorante r = gestore.getArchivioRis().getRistorante(p.getIdRis());
                
                JPanel panelPreferiti = new JPanel(new BorderLayout());
                panelPreferiti.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                panelPreferiti.setBackground(new Color(245, 245, 245)); 
            
                panelPreferiti.setPreferredSize(new Dimension(preferiti.getViewport().getWidth() - 30, 80));
                panelPreferiti.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70)); // altezza fissa
                
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(false);
                panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
                
                
                
                //Restituisce il nome ristorante e lo aggiunge al panel
                JLabel nomeRisto = new JLabel(r.getNomeRis());
                nomeRisto.setFont(new Font("Arial", Font.BOLD, 16));
                panel.add(nomeRisto);
                
                //Restituisce il tipo di cucina e lo aggiunge al panel
                JLabel tipoCucina = new JLabel(r.getCuisRis());
                tipoCucina.setFont(new Font("Arial", Font.PLAIN, 14));
                tipoCucina.setForeground(Color.DARK_GRAY);
                panel.add(tipoCucina);
                
                
                
                //Bottone per rimuovere il preferito dal file
                JButton rimuovi = new JButton("Rimuovi");
                rimuovi.setPreferredSize(new Dimension(80, 10));
                rimuovi.setFocusPainted(false);
                rimuovi.setBackground(new Color(0,102,102));
                rimuovi.setForeground(Color.WHITE);
                
                rimuovi.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        rimuovi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                });
                
                JPanel bottone = new JPanel();
                bottone.setOpaque(false);
                bottone.setLayout(new BoxLayout(bottone, BoxLayout.Y_AXIS));
                bottone.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                
                
                
                //Action listener
                rimuovi.addActionListener(e -> {
                int conferma = JOptionPane.showOptionDialog(this, "Vuoi davvero rimuovere "+ r.getNomeRis() + " dai preferiti?", "Conferma", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sì", "No"}, "No");
                if(conferma == JOptionPane.YES_OPTION){
                    gestore.getArchivioPreferiti().setPrefAttuale(r.getIdRis(), u.getIdUtente());
                    gestore.getArchivioPreferiti().rimuoviPreferito();
                    gestore.getArchivioPreferiti().aggiornaPref();

                    //Cambia cursore quando ci si passa sopra
                    rimuovi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                    // Rimuovo il pannello
                    contenitore.remove(panelPreferiti);
                    contenitore.revalidate();
                    contenitore.repaint();
                }
                });
                
                
                //Aggiungo bottone al panel
                bottone.add(rimuovi);
                panelPreferiti.add(bottone, BorderLayout.EAST);
                panelPreferiti.add(panel, BorderLayout.CENTER);
                panelPreferiti.setBorder(BorderFactory.createCompoundBorder(panelPreferiti.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 20)));
                
                //Aggiungo il panel al contenitore
                contenitore.add(panelPreferiti);
                contenitore.add(Box.createVerticalStrut(10));
                
            }
        }
        // Metti il contenitore nello scrollPane
        preferiti.setViewportView(contenitore);
        preferiti.revalidate();
        preferiti.repaint();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        preferiti = new javax.swing.JScrollPane();
        modificaPreferiti = new javax.swing.JScrollPane();

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
                jButton1ActionPerformed(evt);
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
        jLabel9.setText("Pagina utente");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setMaximumSize(new java.awt.Dimension(50, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Dettagli utente");
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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Modifica dati");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel19.setText("Preferiti");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel21.setText("Recensioni");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Modifica recensioni");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
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
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
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
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(323, Short.MAX_VALUE))
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
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        cognome.setBackground(new java.awt.Color(204, 204, 204));
        cognome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome.setMaximumSize(new java.awt.Dimension(64, 22));
        cognome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cognomeActionPerformed(evt);
            }
        });

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
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

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
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posizione, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logout))
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
                                        .addComponent(eyePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
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
                .addComponent(logout)
                .addContainerGap(270, Short.MAX_VALUE))
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
        nome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome1ActionPerformed(evt);
            }
        });

        cognome1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome1.setMaximumSize(new java.awt.Dimension(64, 22));
        cognome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cognome1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("E-mail");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Password");

        email1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email1.setMaximumSize(new java.awt.Dimension(64, 22));

        password1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password1.setMaximumSize(new java.awt.Dimension(64, 22));
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });

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
                            .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posizione1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aggiorna))
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
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(aggiorna)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        pannelloDestra.add(modificaDati, "modifica");

        preferiti.setMaximumSize(new java.awt.Dimension(783, 620));
        preferiti.setMinimumSize(new java.awt.Dimension(783, 620));
        preferiti.setPreferredSize(new java.awt.Dimension(783, 620));
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        risList.setEnabled(true);
        this.dispose();
        risList.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eyePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePassActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            password.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePassActionPerformed

    private void cognomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cognomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cognomeActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    //Apre pagina dettagli utente se cliccato
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
    }//GEN-LAST:event_jLabel10MouseClicked

    //Apre pagina modifica dati utente se cliccato
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "modifica");
    }//GEN-LAST:event_jLabel11MouseClicked
    
    //Eventi per sottolineare label nel menù
    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        originale = jLabel10.getText();
        jLabel10.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setText(originale);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        originale = jLabel11.getText();
        jLabel11.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setText(originale);
    }//GEN-LAST:event_jLabel11MouseExited

    private void nome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome1ActionPerformed

    private void cognome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cognome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cognome1ActionPerformed

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

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
            gestore.getArchivioUtenti().aggiornaUtenti();
            
            nome.setText(nome1.getText());
            cognome.setText(cognome1.getText());
            email.setText(email1.getText());
            password.setText(password1.getText());
            username.setText(username1.getText());
            posizione.setText(posizione1.getText());
            
        
            JOptionPane.showMessageDialog(this, "Dati aggiornati con successo!");
            
            CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
            cl.show(pannelloDestra, "dettagli");
        }
        
        
       
        
    }//GEN-LAST:event_aggiornaActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        gestore.getArchivioUtenti().setUtenteAttuale(0);
        gestore.getArchivioPreferiti().getPreferiti().clear();
        risList.setEnabled(true);
        risList.dispose();
        Login LoginFrame = new Login(gestore);
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        originale = jLabel19.getText();
        jLabel19.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setText(originale);
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        mostraPreferiti();
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "preferiti");
    }//GEN-LAST:event_jLabel19MouseClicked

    private void modificaPreferitiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificaPreferitiMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "modificaPreferiti");
    }//GEN-LAST:event_modificaPreferitiMouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        originale = jLabel21.getText();
        jLabel21.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setText(originale);
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        originale = jLabel22.getText();
        jLabel22.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jLabel22.setText(originale);
    }//GEN-LAST:event_jLabel22MouseExited

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiorna;
    private javax.swing.JTextField cognome;
    private javax.swing.JTextField cognome1;
    private javax.swing.JPanel contenitore;
    private javax.swing.JPanel dettagliUtente;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JToggleButton eyePass;
    private javax.swing.JToggleButton eyePass1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel modificaDati;
    private javax.swing.JScrollPane modificaPreferiti;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nome1;
    private javax.swing.JPanel pannelloDestra;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField posizione;
    private javax.swing.JTextField posizione1;
    private javax.swing.JScrollPane preferiti;
    private javax.swing.JPanel testa;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables
}
