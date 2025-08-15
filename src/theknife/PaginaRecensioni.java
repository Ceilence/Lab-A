/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author davim
 */
public class PaginaRecensioni extends javax.swing.JFrame {
    private GestoreArchivi gestore;
    private final ImageIcon stellaVuota;
    private final ImageIcon stellaPiena;
    private String originale;
    private int valutazione = 0;
    
    
    
    public PaginaRecensioni(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();
        
        ImageIcon svIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Aggiungi.png"));
        Image sv1 = svIcon.getImage();
        Image sv2 = sv1.getScaledInstance(stella1.getWidth(), stella1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sv3 = new ImageIcon(sv2);
        this.stellaVuota = sv3;
        
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Togli.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(stella1.getWidth(), stella1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        this.stellaPiena = sp3;
        
        
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
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
        areaTesto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaTesto.setLineWrap(true);
        areaTesto.setRows(5);
        areaTesto.setWrapStyleWord(true);
        areaTesto.setAutoscrolls(false);
        areaTesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));

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

        jLabel1.setText("100/300");

        javax.swing.GroupLayout scriviRecPannelloLayout = new javax.swing.GroupLayout(scriviRecPannello);
        scriviRecPannello.setLayout(scriviRecPannelloLayout);
        scriviRecPannelloLayout.setHorizontalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        scriviRecPannelloLayout.setVerticalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stella1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(confermaButton)
                .addGap(16, 16, 16))
            .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scriviRecPannelloLayout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
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
        if (!areaTesto.getText().isBlank()) {
            gestore.getArchivioCommenti().aggiungiCommento(new CommentiRistoranti(gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente(), areaTesto.getText(), gestore.getArchivioCommenti().creaID(), valutazione, true));
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTesto;
    private javax.swing.JButton confermaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel scriviRecPannello;
    private javax.swing.JLabel stella1;
    private javax.swing.JLabel stella2;
    private javax.swing.JLabel stella3;
    private javax.swing.JLabel stella4;
    private javax.swing.JLabel stella5;
    // End of variables declaration//GEN-END:variables
}
