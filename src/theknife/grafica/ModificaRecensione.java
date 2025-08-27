/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife.grafica;

import theknife.grafica.PaginaUtente;
import theknife.grafica.RisList;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 *
 * @author davim
 */
public class ModificaRecensione extends javax.swing.JFrame {
    private GestoreArchivi gestore;
    private ImageIcon stellaVuota, stellaPiena;
    private int valutazione = 0;
    private final int MAX_CHAR =  400;
    private final int MAX_CHAR_TITOLO = 35;
    private RisList risList;
    private CommentiRistoranti commento;
    private PaginaUtente pagUtente;
    
    
    public ModificaRecensione(GestoreArchivi gestore, RisList risList, CommentiRistoranti commento, PaginaUtente pagUtente) {
        this.gestore = gestore;
        this.risList = risList;
        this.commento = commento;
        this.pagUtente = pagUtente;
        setUndecorated(true);
        initComponents();
        creaImmagini();
       
        aggiornaStelle(commento.getValutazione());
        areaTesto.setText(commento.getTesto());
        titoloRec.setText(commento.getTitolo());
        titoloRec.setTransferHandler(null);
        areaTesto.setTransferHandler(null);
    }

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
    
    public void clickStella(int numero) {
        if (valutazione == numero) {
            valutazione = 0;
        } else {
            valutazione = numero;
        }
        aggiornaStelle(valutazione);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scriviRecPannello = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        confermaButton = new javax.swing.JButton();
        areaTesto = new javax.swing.JTextArea();
        stella1 = new javax.swing.JLabel();
        stella2 = new javax.swing.JLabel();
        stella3 = new javax.swing.JLabel();
        stella4 = new javax.swing.JLabel();
        stella5 = new javax.swing.JLabel();
        titoloRec = new javax.swing.JTextField();
        titoloLabel = new javax.swing.JLabel();
        commentoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        conteggio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(558, 498));
        setResizable(false);

        scriviRecPannello.setBackground(new java.awt.Color(255, 255, 255));
        scriviRecPannello.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Valutazione:");
        jLabel2.setToolTipText("");

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

        stella1.setBackground(new java.awt.Color(255, 255, 255));
        stella1.setForeground(new java.awt.Color(255, 255, 255));
        stella1.setMinimumSize(new java.awt.Dimension(30, 30));
        stella1.setPreferredSize(new java.awt.Dimension(25, 25));
        stella1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stella1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stella1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stella1MouseExited(evt);
            }
        });

        stella2.setBackground(new java.awt.Color(255, 255, 255));
        stella2.setMinimumSize(new java.awt.Dimension(30, 30));
        stella2.setPreferredSize(new java.awt.Dimension(25, 25));
        stella2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stella2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stella2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stella2MouseExited(evt);
            }
        });

        stella3.setBackground(new java.awt.Color(255, 255, 255));
        stella3.setMinimumSize(new java.awt.Dimension(30, 30));
        stella3.setPreferredSize(new java.awt.Dimension(25, 25));
        stella3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stella3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stella3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stella3MouseExited(evt);
            }
        });

        stella4.setBackground(new java.awt.Color(255, 255, 255));
        stella4.setMinimumSize(new java.awt.Dimension(30, 30));
        stella4.setPreferredSize(new java.awt.Dimension(25, 25));
        stella4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stella4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stella4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stella4MouseExited(evt);
            }
        });

        stella5.setBackground(new java.awt.Color(255, 255, 255));
        stella5.setMinimumSize(new java.awt.Dimension(30, 30));
        stella5.setPreferredSize(new java.awt.Dimension(25, 25));
        stella5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stella5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stella5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stella5MouseExited(evt);
            }
        });

        titoloRec.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        titoloRec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titoloRecKeyTyped(evt);
            }
        });

        titoloLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        titoloLabel.setText("Titolo:");

        commentoLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        commentoLabel.setText("Commento:");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        conteggio.setText("0/400");

        javax.swing.GroupLayout scriviRecPannelloLayout = new javax.swing.GroupLayout(scriviRecPannello);
        scriviRecPannello.setLayout(scriviRecPannelloLayout);
        scriviRecPannelloLayout.setHorizontalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titoloRec)
                            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(titoloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(commentoLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        scriviRecPannelloLayout.setVerticalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stella1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titoloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titoloRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentoLabel)
                .addGap(3, 3, 3)
                .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton)
                    .addComponent(conteggio))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scriviRecPannello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scriviRecPannello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        if (areaTesto.getText().isBlank() || titoloRec.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Inserisci i campi obbligatori");
        } else {
            commento.setTesto(areaTesto.getText());
            commento.setTitolo(titoloRec.getText());
            commento.setValutazione(valutazione);
            gestore.getArchivioCommenti().calcolaMediaPerRistorante(commento.getIdRistorante());
            gestore.getArchivioCommenti().aggiornaCommenti();
            pagUtente.generaCommentiUtente();
            risList.aggiornaPostModificheRecensioni();
            this.dispose();
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void stella1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella1MouseClicked
        clickStella(1);
    }//GEN-LAST:event_stella1MouseClicked

    private void stella1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella1MouseEntered
        aggiornaStelle(1);
    }//GEN-LAST:event_stella1MouseEntered

    private void stella1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella1MouseExited
        aggiornaStelle(valutazione);
    }//GEN-LAST:event_stella1MouseExited

    private void stella2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella2MouseClicked
        clickStella(2);
    }//GEN-LAST:event_stella2MouseClicked

    private void stella2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella2MouseEntered
        aggiornaStelle(2);
    }//GEN-LAST:event_stella2MouseEntered

    private void stella2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella2MouseExited
        aggiornaStelle(valutazione);
    }//GEN-LAST:event_stella2MouseExited

    private void stella3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella3MouseClicked
        clickStella(3);
    }//GEN-LAST:event_stella3MouseClicked

    private void stella3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella3MouseEntered
        aggiornaStelle(3);
    }//GEN-LAST:event_stella3MouseEntered

    private void stella3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella3MouseExited
        aggiornaStelle(valutazione);
    }//GEN-LAST:event_stella3MouseExited

    private void stella4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella4MouseClicked
        clickStella(4);
    }//GEN-LAST:event_stella4MouseClicked

    private void stella4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella4MouseEntered
        aggiornaStelle(4);
    }//GEN-LAST:event_stella4MouseEntered

    private void stella4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella4MouseExited
        aggiornaStelle(valutazione);
    }//GEN-LAST:event_stella4MouseExited

    private void stella5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella5MouseClicked
        clickStella(5);
    }//GEN-LAST:event_stella5MouseClicked

    private void stella5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella5MouseEntered
        aggiornaStelle(5);
    }//GEN-LAST:event_stella5MouseEntered

    private void stella5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stella5MouseExited
        aggiornaStelle(valutazione);
    }//GEN-LAST:event_stella5MouseExited

    private void areaTestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTestoKeyTyped
        if (areaTesto.getText().length() >= MAX_CHAR) {
            evt.consume(); 
        }
        conteggio.setText((areaTesto.getText().length()) + "/400");
    }//GEN-LAST:event_areaTestoKeyTyped

    private void titoloRecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titoloRecKeyTyped
        if (titoloRec.getText().length() >= MAX_CHAR_TITOLO) {
            evt.consume(); 
        }
    }//GEN-LAST:event_titoloRecKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void areaTestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTestoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_areaTestoKeyPressed

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
    private javax.swing.JLabel commentoLabel;
    private javax.swing.JButton confermaButton;
    private javax.swing.JLabel conteggio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel scriviRecPannello;
    private javax.swing.JLabel stella1;
    private javax.swing.JLabel stella2;
    private javax.swing.JLabel stella3;
    private javax.swing.JLabel stella4;
    private javax.swing.JLabel stella5;
    private javax.swing.JLabel titoloLabel;
    private javax.swing.JTextField titoloRec;
    // End of variables declaration//GEN-END:variables
}
