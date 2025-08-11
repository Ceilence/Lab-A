/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author davim
 */
public class RisList extends javax.swing.JFrame {
    private final ImageIcon prefAdd;
    private final ImageIcon prefRem;
    private GestoreArchivi gestore;
    
    
    public RisList(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();
        Caricamento caricamentoFrame = new Caricamento(gestore);
        caricamentoFrame.setVisible(true);
        caricamentoFrame.pack();
        caricamentoFrame.setLocationRelativeTo(null);
                
        
        //Immagine per mostrare il logo ridimensionato ed applicato.
        ImageIcon tkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\TheKnife.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        logo.setIcon(tk3);
        
        ImageIcon paIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Aggiungi.png"));
        Image pa1 = paIcon.getImage();
        Image pa2 = pa1.getScaledInstance(detPref.getWidth(), detPref.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pa3 = new ImageIcon(pa2);
        this.prefAdd = pa3;
        
        ImageIcon ptIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Togli.png"));
        Image pt1 = ptIcon.getImage();
        Image pt2 = pt1.getScaledInstance(detPref.getWidth(), detPref.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pt3 = new ImageIcon(pt2);
        this.prefRem = pt3;
        
        
       
        PannelloRis pannelloDinamico = new PannelloRis(this, scrollPane, gestore, dettaglioPanel, detNome, detCuis, detBan, detDes, detPref, caricamentoFrame);
        scrollPane.setViewportView(pannelloDinamico);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        panRicerca = new javax.swing.JPanel();
        cerca = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dettaglioPanel = new javax.swing.JPanel();
        detBan = new javax.swing.JLabel();
        detNome = new javax.swing.JLabel();
        detCuis = new javax.swing.JLabel();
        detDes = new javax.swing.JLabel();
        detPref = new javax.swing.JButton();
        labelRecensioni = new javax.swing.JLabel();
        apriRecensioni = new javax.swing.JLabel();
        scrollRecensioni = new javax.swing.JScrollPane();
        recensioni = new javax.swing.JPanel();
        recPan1 = new javax.swing.JPanel();
        nomeRec1 = new javax.swing.JLabel();
        valutazione1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        recPan2 = new javax.swing.JPanel();
        nomeRec2 = new javax.swing.JLabel();
        valutazione2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        recPan3 = new javax.swing.JPanel();
        nomeRec3 = new javax.swing.JLabel();
        valutazione3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        profiloUtente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(770, 660));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(670, 560));
        jPanel1.setPreferredSize(new java.awt.Dimension(1370, 760));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        scrollPane.setMaximumSize(null);
        scrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollPane.setPreferredSize(new java.awt.Dimension(450, 2));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(null);
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 4.5;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 7);
        jPanel1.add(scrollPane, gridBagConstraints);

        logo.setText("logo");
        logo.setMinimumSize(new java.awt.Dimension(50, 50));
        logo.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel1.add(logo, gridBagConstraints);

        panRicerca.setBackground(new java.awt.Color(255, 255, 255));
        panRicerca.setPreferredSize(new java.awt.Dimension(0, 0));
        panRicerca.setLayout(new java.awt.GridBagLayout());

        cerca.setText("jButton1");
        cerca.setMaximumSize(null);
        cerca.setMinimumSize(new java.awt.Dimension(40, 40));
        cerca.setPreferredSize(new java.awt.Dimension(40, 40));
        cerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        panRicerca.add(cerca, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setMaximumSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        panRicerca.add(jComboBox1, gridBagConstraints);

        jTextField1.setText("jTextField1");
        jTextField1.setMaximumSize(null);
        jTextField1.setMinimumSize(new java.awt.Dimension(375, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(375, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 1.0;
        panRicerca.add(jTextField1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanel1.add(panRicerca, gridBagConstraints);

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(600, 16));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 2));

        dettaglioPanel.setBackground(new java.awt.Color(255, 255, 255));
        dettaglioPanel.setMaximumSize(null);
        dettaglioPanel.setPreferredSize(new java.awt.Dimension(268, 1250));
        dettaglioPanel.setLayout(new java.awt.GridBagLayout());

        detBan.setText("Bandiera");
        detBan.setMinimumSize(new java.awt.Dimension(60, 60));
        detBan.setPreferredSize(new java.awt.Dimension(60, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        dettaglioPanel.add(detBan, gridBagConstraints);

        detNome.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 15.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        dettaglioPanel.add(detNome, gridBagConstraints);

        detCuis.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        dettaglioPanel.add(detCuis, gridBagConstraints);

        detDes.setBackground(new java.awt.Color(204, 204, 204));
        detDes.setText("Desc");
        detDes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        dettaglioPanel.add(detDes, gridBagConstraints);

        detPref.setBorderPainted(false);
        detPref.setPreferredSize(new java.awt.Dimension(40, 40));
        detPref.setRequestFocusEnabled(false);
        detPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detPrefActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        dettaglioPanel.add(detPref, gridBagConstraints);

        labelRecensioni.setText("Recensioni:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        dettaglioPanel.add(labelRecensioni, gridBagConstraints);

        apriRecensioni.setText("Vedi tutte.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 0.1;
        dettaglioPanel.add(apriRecensioni, gridBagConstraints);

        recensioni.setMaximumSize(null);
        recensioni.setPreferredSize(new java.awt.Dimension(0, 0));
        recensioni.setLayout(new java.awt.GridBagLayout());

        recPan1.setLayout(new java.awt.GridBagLayout());

        nomeRec1.setBackground(new java.awt.Color(255, 255, 255));
        nomeRec1.setText("RISTORANTE GAY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        recPan1.add(nomeRec1, gridBagConstraints);

        valutazione1.setText("4/10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        recPan1.add(valutazione1, gridBagConstraints);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.7;
        recPan1.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recensioni.add(recPan1, gridBagConstraints);

        recPan2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        recPan2.add(nomeRec2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        recPan2.add(valutazione2, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        recPan2.add(jScrollPane2, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recensioni.add(recPan2, gridBagConstraints);

        recPan3.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        recPan3.add(nomeRec3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        recPan3.add(valutazione3, gridBagConstraints);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        recPan3.add(jScrollPane4, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recensioni.add(recPan3, gridBagConstraints);

        scrollRecensioni.setViewportView(recensioni);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        dettaglioPanel.add(scrollRecensioni, gridBagConstraints);

        jScrollPane1.setViewportView(dettaglioPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.4;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        profiloUtente.setText("jButton2");
        profiloUtente.setPreferredSize(new java.awt.Dimension(45, 45));
        profiloUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profiloUtenteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel1.add(profiloUtente, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Verifica, tramite metodo esistePref(), che il ristorante visualizzato sia tra i preferiti dell'utente.
     * Imposta poi l'icona del JButton detPref con l'immagine appropriata,
     * nel caso in cui si voglia aggiungere o togliere il ristorante dalla lista preferiti.
     */
    private void detPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detPrefActionPerformed
        if (gestore.getArchivioPref().esistePref()) {
            gestore.getArchivioPref().rimuoviPreferito();
            aggiornaDetPref();
            gestore.getArchivioPref().aggiornaPref();
        } else {
            gestore.getArchivioPref().aggiungiPreferito();
            aggiornaDetPref();
            gestore.getArchivioPref().aggiornaPref();
        }
    }//GEN-LAST:event_detPrefActionPerformed

    private void profiloUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profiloUtenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profiloUtenteActionPerformed

    private void cercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercaActionPerformed
       
    }//GEN-LAST:event_cercaActionPerformed

    //Metodo per cambiare il comportamento di vari componenti se l'utente loggato è un guest
    public void versioneGuest() {
        if (gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente() == 0) {
            detPref.setVisible(false);
        } else {
            detPref.setVisible(true);
        }
    }
    
    //ETODOSKIBIBIOADIAJSFK
    public void aggiornaDetPref() {
        if (gestore.getArchivioPref().esistePref()) {
            detPref.setIcon(prefRem);
        } else {
            detPref.setIcon(prefAdd);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apriRecensioni;
    private javax.swing.JButton cerca;
    private javax.swing.JLabel detBan;
    private javax.swing.JLabel detCuis;
    private javax.swing.JLabel detDes;
    private javax.swing.JLabel detNome;
    private javax.swing.JButton detPref;
    private javax.swing.JPanel dettaglioPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelRecensioni;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nomeRec1;
    private javax.swing.JLabel nomeRec2;
    private javax.swing.JLabel nomeRec3;
    private javax.swing.JPanel panRicerca;
    private javax.swing.JButton profiloUtente;
    private javax.swing.JPanel recPan1;
    private javax.swing.JPanel recPan2;
    private javax.swing.JPanel recPan3;
    private javax.swing.JPanel recensioni;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollRecensioni;
    private javax.swing.JLabel valutazione1;
    private javax.swing.JLabel valutazione2;
    private javax.swing.JLabel valutazione3;
    // End of variables declaration//GEN-END:variables
}
