/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



/**
 *
 * @author davim
 */
public class RisList extends javax.swing.JFrame {
    private ImageIcon stellaVuota;
    private ImageIcon stellaPiena;
    private final GestoreArchivi gestore;
    private final ArrayList<PannelloRis> tuttiIPannelli = new ArrayList<>();
    private final ArrayList<PannelloRis> filtratore = new ArrayList<>();
    private Caricamento caricamentoFrame;
    private ImageIcon flagItalia;
    private ImageIcon flagCina;
    private ImageIcon flagFrancia;
    private ImageIcon flagGermania;
    private ImageIcon flagSpagna;
    private ImageIcon flagUSA;
    private ImageIcon flagGiappone;
    private ImageIcon flagMondo;
    private int pagina = 0;
    
    public RisList(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();

        caricamentoFrame = new Caricamento();
        caricamentoFrame.setLocationRelativeTo(null);
        caricamentoFrame.setVisible(true);

        contenitorePanel.setLayout(new BoxLayout(contenitorePanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(contenitorePanel);
        
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        scrollPaneDet.getVerticalScrollBar().setUnitIncrement(50);
        scrollPaneRec.getVerticalScrollBar().setUnitIncrement(50);
        
        creaImmagine();
        caricaPannelli();
        impaginazione(pagina);
        System.out.println(tuttiIPannelli.size());
        System.out.println(filtratore.size());
    }
    
    private void caricaPannelli() {

    ArrayList<Ristorante> lista = gestore.getArchivioRis().getRis();
    int totale = lista.size();
    //contenitorePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    SwingWorker<Void, Integer> worker = new SwingWorker<>() {
        @Override
        protected Void doInBackground() throws Exception {
            int count = 0;
            for (Ristorante r : lista) {
                ImageIcon icona = selezionaImmagine(r.getLocRis());

                PannelloRis p = new PannelloRis(RisList.this, gestore, r,dettaglioPanel, detNome, detCuis,detBan, detDes, detPref,icona);
                tuttiIPannelli.add(p);
                filtratore.add(p);

                count++;
                publish(count); // manda il progresso
            }
            return null;
        }
            private int counter = 0;
            @Override
            protected void process(java.util.List<Integer> chunks) {
                int ultimoValore = chunks.get(chunks.size() - 1);
                caricamentoFrame.aggiornaProgresso(ultimoValore, totale);
        }

        @Override
        protected void done() {
            caricamentoFrame.dispose();
            Login loginFrame = new Login(gestore);
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);
            
        }
    };

    worker.execute();
}
    
    private void filtraPannelli(String filtro) {
        pagina = 0;
        filtro = filtro.toLowerCase();
        filtratore.clear();
        contenitorePanel.removeAll();

        for (PannelloRis p : tuttiIPannelli) {
            Ristorante r = p.getRistorante();
            if (filtro.isEmpty() || r.getNomeRis().toLowerCase().contains(filtro)) {
                filtratore.add(p);
            }
        }
    }
    
    public void impaginazione(int pagina){
        int da = 100 * (pagina);
        int a = Math.min(filtratore.size(), 100 * pagina);
        for(int i = da; i < a; i++){
            contenitorePanel.add(filtratore.get(da));
            contenitorePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        
        contenitorePanel.revalidate();
        contenitorePanel.repaint();
        scrollPane.revalidate();
        scrollPane.repaint();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        contenitorePanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        panRicerca = new javax.swing.JPanel();
        cerca = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        campoRicerca = new javax.swing.JTextField();
        profiloUtente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollPaneDet = new javax.swing.JScrollPane();
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
        rec1 = new javax.swing.JLabel();
        recRisposta1 = new javax.swing.JLabel();
        recPan2 = new javax.swing.JPanel();
        nomeRec2 = new javax.swing.JLabel();
        valutazione2 = new javax.swing.JLabel();
        rec2 = new javax.swing.JLabel();
        recRisposta2 = new javax.swing.JLabel();
        recPan3 = new javax.swing.JPanel();
        nomeRec3 = new javax.swing.JLabel();
        valutazione3 = new javax.swing.JLabel();
        rec3 = new javax.swing.JLabel();
        recRisposta3 = new javax.swing.JLabel();
        scrollPaneRec = new javax.swing.JScrollPane();
        indietro = new javax.swing.JButton();
        avanti = new javax.swing.JButton();
        contatore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        contenitorePanel.setBackground(new java.awt.Color(255, 255, 255));
        contenitorePanel.setMaximumSize(null);
        contenitorePanel.setOpaque(false);
        contenitorePanel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout contenitorePanelLayout = new javax.swing.GroupLayout(contenitorePanel);
        contenitorePanel.setLayout(contenitorePanelLayout);
        contenitorePanelLayout.setHorizontalGroup(
            contenitorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
        contenitorePanelLayout.setVerticalGroup(
            contenitorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(contenitorePanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 4.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(logo, gridBagConstraints);

        panRicerca.setBackground(new java.awt.Color(255, 255, 255));
        panRicerca.setPreferredSize(new java.awt.Dimension(0, 0));
        panRicerca.setLayout(new java.awt.GridBagLayout());

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

        campoRicerca.setToolTipText("");
        campoRicerca.setMaximumSize(null);
        campoRicerca.setMinimumSize(new java.awt.Dimension(375, 40));
        campoRicerca.setPreferredSize(new java.awt.Dimension(375, 40));
        campoRicerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoRicercaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 1.0;
        panRicerca.add(campoRicerca, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(panRicerca, gridBagConstraints);

        profiloUtente.setText("jButton2");
        profiloUtente.setPreferredSize(new java.awt.Dimension(45, 45));
        profiloUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profiloUtenteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(profiloUtente, gridBagConstraints);

        jPanel2.setLayout(new java.awt.CardLayout());

        scrollPaneDet.setMaximumSize(null);
        scrollPaneDet.setMinimumSize(new java.awt.Dimension(600, 16));
        scrollPaneDet.setPreferredSize(new java.awt.Dimension(600, 2));

        dettaglioPanel.setBackground(new java.awt.Color(255, 255, 255));
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
        gridBagConstraints.weighty = 0.06;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        dettaglioPanel.add(detNome, gridBagConstraints);

        detCuis.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.03;
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
        gridBagConstraints.weighty = 0.02;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        dettaglioPanel.add(detPref, gridBagConstraints);

        labelRecensioni.setText("Recensioni:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.06;
        dettaglioPanel.add(labelRecensioni, gridBagConstraints);

        apriRecensioni.setText("Vedi tutte.");
        apriRecensioni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apriRecensioniMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        dettaglioPanel.add(apriRecensioni, gridBagConstraints);

        recensioni.setPreferredSize(new java.awt.Dimension(0, 0));
        recensioni.setLayout(new java.awt.GridBagLayout());

        recPan1.setBackground(new java.awt.Color(255, 255, 255));
        recPan1.setLayout(new java.awt.GridBagLayout());

        nomeRec1.setBackground(new java.awt.Color(255, 255, 255));
        nomeRec1.setText("RISTORANTE GAY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        recPan1.add(nomeRec1, gridBagConstraints);

        valutazione1.setText("4/10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        recPan1.add(valutazione1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recPan1.add(rec1, gridBagConstraints);

        recRisposta1.setText("Risposta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        recPan1.add(recRisposta1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recensioni.add(recPan1, gridBagConstraints);

        recPan2.setBackground(new java.awt.Color(255, 255, 255));
        recPan2.setLayout(new java.awt.GridBagLayout());

        nomeRec2.setBackground(new java.awt.Color(255, 255, 255));
        nomeRec2.setText("RISTORANTE GAY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        recPan2.add(nomeRec2, gridBagConstraints);

        valutazione2.setText("4/10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        recPan2.add(valutazione2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recPan2.add(rec2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        recPan2.add(recRisposta2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recensioni.add(recPan2, gridBagConstraints);

        recPan3.setBackground(new java.awt.Color(255, 255, 255));
        recPan3.setLayout(new java.awt.GridBagLayout());

        nomeRec3.setBackground(new java.awt.Color(255, 255, 255));
        nomeRec3.setText("RISTORANTE GAY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        recPan3.add(nomeRec3, gridBagConstraints);

        valutazione3.setText("4/10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        recPan3.add(valutazione3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recPan3.add(rec3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        recPan3.add(recRisposta3, gridBagConstraints);

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

        scrollPaneDet.setViewportView(dettaglioPanel);

        jPanel2.add(scrollPaneDet, "card2");
        jPanel2.add(scrollPaneRec, "card3");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.4;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel1.add(jPanel2, gridBagConstraints);

        indietro.setText("indietro");
        indietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(indietro, gridBagConstraints);

        avanti.setText("avanti");
        avanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avantiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(avanti, gridBagConstraints);

        contatore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contatore.setForeground(new java.awt.Color(255, 255, 255));
        contatore.setText("/100");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel1.add(contatore, gridBagConstraints);

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
        if (gestore.getArchivioPreferiti().esistePref()) {
            gestore.getArchivioPreferiti().rimuoviPreferito();
            aggiornaDetPref();
            gestore.getArchivioPreferiti().aggiornaPref();
        } else {
            gestore.getArchivioPreferiti().aggiungiPreferito();
            aggiornaDetPref();
            gestore.getArchivioPreferiti().aggiornaPref();
        }
    }//GEN-LAST:event_detPrefActionPerformed

    /**
     * 
     * 
     * @param evt 
     */
    private void profiloUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profiloUtenteActionPerformed
            PaginaUtente p = new PaginaUtente(gestore, this);
            p.setVisible(true);
            this.setEnabled(false);
            p.setLocationRelativeTo(null);
            
    }//GEN-LAST:event_profiloUtenteActionPerformed

    private void cercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercaActionPerformed
        filtraPannelli(campoRicerca.getText());
    }//GEN-LAST:event_cercaActionPerformed

    private void apriRecensioniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apriRecensioniMouseClicked
   
        
    }//GEN-LAST:event_apriRecensioniMouseClicked

    private void campoRicercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoRicercaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoRicercaActionPerformed

    private void avantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avantiActionPerformed
        // TODO add your handling code here:
        pagina++;
        impaginazione(pagina);
    }//GEN-LAST:event_avantiActionPerformed

    private void indietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroActionPerformed
        // TODO add your handling code here:
        pagina--;
        impaginazione(pagina);
    }//GEN-LAST:event_indietroActionPerformed

    //Metodo per cambiare il comportamento di vari componenti se l'utente loggato è un guest
    public void versioneGuest() {
        if (gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente() == 0) {
            detPref.setVisible(false);
        } else {
            detPref.setVisible(true);
        }
    }
    
    public void aggiornaDetPref() {
        if (gestore.getArchivioPreferiti().esistePref()) {
            detPref.setIcon(stellaPiena);
        } else {
            detPref.setIcon(stellaVuota);
        }
    }
    
     public void creaImmagine(){
        ImageIcon flagIT = new ImageIcon("src\\Flag_of_Italy.png");
        Image scaledImageItalia = flagIT.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconItalia = new ImageIcon(scaledImageItalia);
        this.flagItalia = scaledIconItalia; 
        
        ImageIcon flagCN = new ImageIcon("src\\Flag_of_China.png");
        Image scaledImageCina = flagCN.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconCina = new ImageIcon(scaledImageCina);
        this.flagCina = scaledIconCina; 
        
        ImageIcon flagJP = new ImageIcon("src\\Flag_of_Japan.png");
        Image scaledImageGiappone = flagJP.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGiappone = new ImageIcon(scaledImageGiappone);
        this.flagGiappone = scaledIconGiappone; 
        
        ImageIcon flagES = new ImageIcon("src\\Flag_of_Spain.png");
        Image scaledImageSpagna = flagIT.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSpagna = new ImageIcon(scaledImageSpagna);
        this.flagSpagna = scaledIconSpagna; 
        
        ImageIcon flagDE = new ImageIcon("src\\Flag_of_Germany.png");
        Image scaledImageGermania = flagDE.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGermania = new ImageIcon(scaledImageGermania);
        this.flagGermania = scaledIconGermania; 
        
        ImageIcon flagUSA = new ImageIcon("src\\Flag_of_United_States.png");
        Image scaledImageUSA = flagUSA.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconUSA = new ImageIcon(scaledImageUSA);
        this.flagUSA = scaledIconUSA; 
        
        ImageIcon flagFR = new ImageIcon("src\\Flag_of_France.png");
        Image scaledImageFrancia = flagFR.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconFrancia = new ImageIcon(scaledImageFrancia);
        this.flagFrancia = scaledIconFrancia; 
        
        ImageIcon flagWD = new ImageIcon("src\\Globe.png");
        Image scaledImageMondo = flagWD.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconMondo = new ImageIcon(scaledImageMondo);
        this.flagMondo = scaledIconMondo; 
        
        ImageIcon tkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\TheKnife.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        logo.setIcon(tk3);
        
        ImageIcon paIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Aggiungi.png"));
        Image pa1 = paIcon.getImage();
        Image pa2 = pa1.getScaledInstance(detPref.getWidth(), detPref.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pa3 = new ImageIcon(pa2);
        this.stellaVuota = pa3;
        
        ImageIcon ptIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Togli.png"));
        Image pt1 = ptIcon.getImage();
        Image pt2 = pt1.getScaledInstance(detPref.getWidth(), detPref.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pt3 = new ImageIcon(pt2);
        this.stellaPiena = pt3;
        
        
        
        
    }
     
     public ImageIcon selezionaImmagine(String nazione){
        if(nazione.contains("Italy"))
            return this.flagItalia;
        
        if(nazione.contains("France"))
            return this.flagFrancia;
        
        if(nazione.contains("Germany"))
            return this.flagGermania;
        
        if(nazione.contains("China"))
            return this.flagCina;
        
        if(nazione.contains("Japan"))
            return this.flagGiappone;
        
        if(nazione.contains("Spain"))
            return this.flagSpagna;
        
        if(nazione.contains("USA"))
            return this.flagUSA;
        
        return this.flagMondo;
    }
    
     
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apriRecensioni;
    private javax.swing.JButton avanti;
    private javax.swing.JTextField campoRicerca;
    private javax.swing.JButton cerca;
    private javax.swing.JLabel contatore;
    private javax.swing.JPanel contenitorePanel;
    private javax.swing.JLabel detBan;
    private javax.swing.JLabel detCuis;
    private javax.swing.JLabel detDes;
    private javax.swing.JLabel detNome;
    private javax.swing.JButton detPref;
    private javax.swing.JPanel dettaglioPanel;
    private javax.swing.JButton indietro;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelRecensioni;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nomeRec1;
    private javax.swing.JLabel nomeRec2;
    private javax.swing.JLabel nomeRec3;
    private javax.swing.JPanel panRicerca;
    private javax.swing.JButton profiloUtente;
    private javax.swing.JLabel rec1;
    private javax.swing.JLabel rec2;
    private javax.swing.JLabel rec3;
    private javax.swing.JPanel recPan1;
    private javax.swing.JPanel recPan2;
    private javax.swing.JPanel recPan3;
    private javax.swing.JLabel recRisposta1;
    private javax.swing.JLabel recRisposta2;
    private javax.swing.JLabel recRisposta3;
    private javax.swing.JPanel recensioni;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPaneDet;
    private javax.swing.JScrollPane scrollPaneRec;
    private javax.swing.JScrollPane scrollRecensioni;
    private javax.swing.JLabel valutazione1;
    private javax.swing.JLabel valutazione2;
    private javax.swing.JLabel valutazione3;
    // End of variables declaration//GEN-END:variables
}
