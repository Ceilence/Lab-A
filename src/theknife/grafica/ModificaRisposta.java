/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 * Finestra grafica che consente al ristoratore di modificare una risposta ad una recensione di un utente.
 * <p>
 * Mostra la recensione originale (titolo, testo, valutazione a stelle) e permette
 * di modificare e salvare il testo della risposta associata
 * </p>
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class ModificaRisposta extends javax.swing.JFrame {
    
    /**
     * Gestore degli archivi utilizzato per accedere ai dati di utenti e ristoranti.
     * {@code gestore}
     */
    private GestoreArchivi gestore;
    
    /**
     * Icone rappresentanti stella vuota o stella piena
     * {@code stellaVuota} 
     * {@code stellaPiena} 
     */
    private ImageIcon stellaVuota, stellaPiena;
    
    /**
     * Valutazione iniziale settata a 0.
     * {@code valutazione}
     */
    private final int valutazione = 0;
    
    /**
     * Numero massimo di caratteri consentiti nel testo della risposta.
     * {@code MAX_CHAR}
     */
    private final int MAX_CHAR =  400;
    
    /**
     * Commento originale a cui il ristoratore risponde e risposta del ristoratore.
     * {@code commento} {@code risposta}
     */
    private final CommentiRistoranti commento, risposta;
    
    /**
     * Riferimento alla pagina principale del ristoratore, usata per aggiornare la vista al termine della modifica. {@link PaginaRistoratore} {@code pagRisto}
     */
    private final PaginaRistoratore pagRisto;
   
    
    
    /**
     * Costruisce la finestra per modificare la risposta del ristoratore ad una recensione utente.
     *
     * @param gestore  il {@link GestoreArchivi} utilizzato per accedere ai dati
     * @param commento il {@link CommentiRistoranti} originale scritto dall'utente
     * @param risposta il {@link CommentiRistoranti} contenente la risposta del ristoratore
     * @param pagRisto la pagina {@link PaginaRistoratore} da aggiornare al termine
     */
    public ModificaRisposta(GestoreArchivi gestore, CommentiRistoranti commento, CommentiRistoranti risposta, PaginaRistoratore pagRisto) {
        this.gestore = gestore;
        this.commento = commento;
        this.pagRisto = pagRisto;
        this.risposta = risposta;
        setUndecorated(true);
        initComponents();
        creaImmagini();
        aggiornaStelle(commento.getValutazione());
        nomeRec.setText("Recensione scritta da: " +  gestore.getArchivioUtenti().getUtente(commento.getIdScrittore()).getUsernameUtente() + " #" + commento.getIdScrittore());
        titoloRec.setText(commento.getTitolo());
        testoRec.setText(commento.getTesto());
        areaTesto.setText(risposta.getTesto());
        areaTesto.setTransferHandler(null);
    }

    /**
     * Aggiorna le icone delle stelle in base al punteggio della recensione.
     *
     * @param finoA numero di stelle da riempire (valutazione)
     */
    private void aggiornaStelle(int finoA) {
        JLabel[] stelle = {stella1, stella2, stella3, stella4, stella5};
        for (int i = 0; i < stelle.length; i++) {
            if (i < finoA) {
                stelle[i].setIcon(stellaPiena);
            } else {
                stelle[i].setIcon(stellaVuota);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scriviRecPannello = new javax.swing.JPanel();
        confermaButton = new javax.swing.JButton();
        areaTesto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        conteggio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeRec = new javax.swing.JLabel();
        stella1 = new javax.swing.JLabel();
        stella2 = new javax.swing.JLabel();
        stella3 = new javax.swing.JLabel();
        stella4 = new javax.swing.JLabel();
        stella5 = new javax.swing.JLabel();
        titoloRec = new javax.swing.JLabel();
        testoRec = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(558, 498));
        setResizable(false);

        scriviRecPannello.setBackground(new java.awt.Color(255, 255, 255));
        scriviRecPannello.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));

        confermaButton.setBackground(new java.awt.Color(0, 102, 102));
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        areaTesto.setColumns(20);
        areaTesto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        areaTesto.setLineWrap(true);
        areaTesto.setRows(5);
        areaTesto.setWrapStyleWord(true);
        areaTesto.setAutoscrolls(false);
        areaTesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        areaTesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areaTestoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaTestoKeyTyped(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        conteggio.setText("0/400");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Rispondi:");

        nomeRec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomeRec.setText("Recensione di:");
        nomeRec.setEnabled(false);

        stella1.setBackground(new java.awt.Color(255, 255, 255));
        stella1.setForeground(new java.awt.Color(255, 255, 255));
        stella1.setMinimumSize(new java.awt.Dimension(30, 30));
        stella1.setPreferredSize(new java.awt.Dimension(25, 25));

        stella2.setBackground(new java.awt.Color(255, 255, 255));
        stella2.setForeground(new java.awt.Color(255, 255, 255));
        stella2.setMinimumSize(new java.awt.Dimension(30, 30));
        stella2.setPreferredSize(new java.awt.Dimension(25, 25));

        stella3.setBackground(new java.awt.Color(255, 255, 255));
        stella3.setForeground(new java.awt.Color(255, 255, 255));
        stella3.setMinimumSize(new java.awt.Dimension(30, 30));
        stella3.setPreferredSize(new java.awt.Dimension(25, 25));

        stella4.setBackground(new java.awt.Color(255, 255, 255));
        stella4.setForeground(new java.awt.Color(255, 255, 255));
        stella4.setMinimumSize(new java.awt.Dimension(30, 30));
        stella4.setPreferredSize(new java.awt.Dimension(25, 25));

        stella5.setBackground(new java.awt.Color(255, 255, 255));
        stella5.setForeground(new java.awt.Color(255, 255, 255));
        stella5.setMinimumSize(new java.awt.Dimension(30, 30));
        stella5.setPreferredSize(new java.awt.Dimension(25, 25));

        titoloRec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titoloRec.setText("   ");
        titoloRec.setEnabled(false);

        testoRec.setEditable(false);
        testoRec.setColumns(20);
        testoRec.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        testoRec.setForeground(new java.awt.Color(255, 255, 255));
        testoRec.setLineWrap(true);
        testoRec.setRows(5);
        testoRec.setWrapStyleWord(true);
        testoRec.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        testoRec.setDragEnabled(true);
        testoRec.setEnabled(false);
        testoRec.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout scriviRecPannelloLayout = new javax.swing.GroupLayout(scriviRecPannello);
        scriviRecPannello.setLayout(scriviRecPannelloLayout);
        scriviRecPannelloLayout.setHorizontalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testoRec)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scriviRecPannelloLayout.createSequentialGroup()
                        .addComponent(nomeRec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1))
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                                .addComponent(stella1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titoloRec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        scriviRecPannelloLayout.setVerticalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(nomeRec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stella1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titoloRec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testoRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conteggio)
                    .addComponent(confermaButton))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scriviRecPannello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scriviRecPannello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento associato al pulsante "Conferma". Salva la risposta modificata,
     * aggiorna la pagina del ristoratore e chiude la finestra.
     *
     * @param evt evento generato dal click sul pulsante
     */
    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        if (areaTesto.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Inserisci un testo valido");
        } else {
            risposta.setTesto(areaTesto.getText());
            pagRisto.cambiaCard();
            this.dispose();
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    /**
     * Evento associato alla digitazione di un carattere nel campo testo.
     *  <ul>
     *      <li>Impedisce di superare {@code MAX_CHAR} caratteri.</li>
     *      <li>Aggiorna il contatore di caratteri mostrato.</li>
     *  </ul>
     *
     * @param evt evento generato dalla digitazione di un carattere
     */
    private void areaTestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTestoKeyTyped
       if (areaTesto.getText().length() >= MAX_CHAR) {
            evt.consume(); 
        }
        conteggio.setText((areaTesto.getText().length()) + "/400");
    }//GEN-LAST:event_areaTestoKeyTyped

     /**
     * Evento associato al pulsante "Annulla".
     * Chiude la finestra e ritorna alla pagina del ristoratore.
     *
     * @param evt evento generato dal click sul pulsante
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pagRisto.cambiaCard();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Evento associato alla pressione di un tasto nell'area testo.
     * <br>Viene disabilitato l'inserimento del tasto INVIO per evitare a capo.
     *
     * @param evt evento generato dalla pressione di un tasto
     */
    private void areaTestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTestoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_areaTestoKeyPressed

    /**
     * Crea e ridimensiona le icone delle stelle (vuota e piena) 
     * a partire dai file presenti nella cartella resources/images.
     */
    private void creaImmagini() {
        ImageIcon svIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\pref_Aggiungi.png"));
        Image sv1 = svIcon.getImage();
        Image sv2 = sv1.getScaledInstance(stella1.getWidth(), stella1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sv3 = new ImageIcon(sv2);
        this.stellaVuota = sv3;
        
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\pref_Togli.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(stella1.getWidth(), stella1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        this.stellaPiena = sp3;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTesto;
    private javax.swing.JButton confermaButton;
    private javax.swing.JLabel conteggio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nomeRec;
    private javax.swing.JPanel scriviRecPannello;
    private javax.swing.JLabel stella1;
    private javax.swing.JLabel stella2;
    private javax.swing.JLabel stella3;
    private javax.swing.JLabel stella4;
    private javax.swing.JLabel stella5;
    private javax.swing.JTextArea testoRec;
    private javax.swing.JLabel titoloRec;
    // End of variables declaration//GEN-END:variables
}
