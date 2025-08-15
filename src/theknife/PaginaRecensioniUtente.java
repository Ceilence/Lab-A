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
public class PaginaRecensioniUtente extends javax.swing.JFrame {
    private GestoreArchivi gestore;
    private final ImageIcon stellaVuota;
    private final ImageIcon stellaPiena;
    private String originale;
    private int valutazione = 0;
    
    
    
    public PaginaRecensioniUtente(GestoreArchivi gestore) {
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

        contenitore = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        recensioni = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scriviRecensione = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        pannelloDestra = new javax.swing.JPanel();
        pannelloRecensioni = new javax.swing.JScrollPane();
        scriviRecPannello = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        confermaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTesto = new javax.swing.JTextArea();
        stella1 = new javax.swing.JLabel();
        stella2 = new javax.swing.JLabel();
        stella3 = new javax.swing.JLabel();
        stella4 = new javax.swing.JLabel();
        stella5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        contenitore.setBackground(new java.awt.Color(0, 102, 102));
        contenitore.setMinimumSize(new java.awt.Dimension(800, 500));
        contenitore.setPreferredSize(new java.awt.Dimension(800, 500));

        menu.setBackground(new java.awt.Color(255, 255, 255));

        recensioni.setBackground(new java.awt.Color(255, 255, 255));
        recensioni.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        recensioni.setText("Recensioni");
        recensioni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recensioniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recensioniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recensioniMouseExited(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        scriviRecensione.setBackground(new java.awt.Color(255, 255, 255));
        scriviRecensione.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scriviRecensione.setText("Scrivi recensione");
        scriviRecensione.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scriviRecensione.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scriviRecensioneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scriviRecensioneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scriviRecensioneMouseExited(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Modifica recensione");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(scriviRecensione, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(menuLayout.createSequentialGroup()
                                .addComponent(recensioni, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recensioni, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scriviRecensione, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pannelloDestra.setBackground(new java.awt.Color(255, 255, 255));
        pannelloDestra.setLayout(new java.awt.CardLayout());

        pannelloRecensioni.setBackground(new java.awt.Color(255, 255, 255));
        pannelloDestra.add(pannelloRecensioni, "recensioni");

        scriviRecPannello.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
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
        areaTesto.setLineWrap(true);
        areaTesto.setRows(5);
        areaTesto.setWrapStyleWord(true);
        areaTesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jScrollPane1.setViewportView(areaTesto);

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

        javax.swing.GroupLayout scriviRecPannelloLayout = new javax.swing.GroupLayout(scriviRecPannello);
        scriviRecPannello.setLayout(scriviRecPannelloLayout);
        scriviRecPannelloLayout.setHorizontalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confermaButton)
                .addGap(16, 16, 16))
        );

        pannelloDestra.add(scriviRecPannello, "scrivi");

        javax.swing.GroupLayout contenitoreLayout = new javax.swing.GroupLayout(contenitore);
        contenitore.setLayout(contenitoreLayout);
        contenitoreLayout.setHorizontalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenitoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pannelloDestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenitoreLayout.setVerticalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pannelloDestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenitore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenitore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scriviRecensioneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scriviRecensioneMouseEntered
        originale = scriviRecensione.getText();
        scriviRecensione.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_scriviRecensioneMouseEntered

    private void scriviRecensioneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scriviRecensioneMouseExited
        scriviRecensione.setText(originale);
    }//GEN-LAST:event_scriviRecensioneMouseExited

    private void scriviRecensioneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scriviRecensioneMouseClicked
        CardLayout cl = (CardLayout) (pannelloDestra.getLayout());
        cl.show(pannelloDestra, "scrivi");
    }//GEN-LAST:event_scriviRecensioneMouseClicked

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

    private void recensioniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recensioniMouseClicked
        CardLayout cl = (CardLayout) (pannelloDestra.getLayout());
        cl.show(pannelloDestra, "recensioni");
    }//GEN-LAST:event_recensioniMouseClicked

    private void recensioniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recensioniMouseEntered
        originale = recensioni.getText();
        recensioni.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_recensioniMouseEntered

    private void recensioniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recensioniMouseExited
        recensioni.setText(originale);
    }//GEN-LAST:event_recensioniMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTesto;
    private javax.swing.JButton confermaButton;
    private javax.swing.JPanel contenitore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel pannelloDestra;
    private javax.swing.JScrollPane pannelloRecensioni;
    private javax.swing.JLabel recensioni;
    private javax.swing.JPanel scriviRecPannello;
    private javax.swing.JLabel scriviRecensione;
    private javax.swing.JLabel stella1;
    private javax.swing.JLabel stella2;
    private javax.swing.JLabel stella3;
    private javax.swing.JLabel stella4;
    private javax.swing.JLabel stella5;
    // End of variables declaration//GEN-END:variables
}
