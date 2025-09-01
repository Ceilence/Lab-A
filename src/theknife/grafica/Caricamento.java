/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como@author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.grafica;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

/**
 * Finestra grafica di caricamento dell'applicazione.
 * <p>
 *  Questa schermata mostra:
 *  <ul>
 *      <li>Un testo animato "Caricamento..." con puntini ciclici.</li>
 *      <li>Una {@link JProgressBar} per rappresentare lo stato di avanzamento.</li>
 *      <li>Un logo mostrato al centro della finestra.</li>
 *  </ul>
 *
 * <p>Il testo viene aggiornato ogni 500 millisecondi tramite un {@link Timer} Swing.
 *
 * @see Timer
 * @see JProgressBar
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */



public class Caricamento extends javax.swing.JFrame {
    /**Timer per scandire l'animazione dei puntini nella scritta "Caricamento". {@code timer}*/
    private Timer timer;
    
    /**Ciclicamente crea puntini sulla scritta in base al conto. {@code contaPuntini}*/
    private int contaPuntini = 0;
    
    /**
     * Costruttore della finestra di caricamento.
     * <p>
     *  Inizializza i componenti grafici e avvia il timer che anima il testo "Caricamento..." con un numero variabile di puntini.
     */
    public Caricamento() {
        initComponents();
        //Ridimensionamento icona logo.
        ImageIcon tkIcon = new ImageIcon(getClass().getResource("/theknife/resources/images/logo.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(iconaLogo.getWidth(), iconaLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        iconaLogo.setIcon(tk3);
        
        // Inizializza il timer per aggiornare i puntini ogni 500 ms
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contaPuntini = (contaPuntini + 1) % 4;  // 0,1,2,3 ciclicamente
                String dots = "";
                for (int i = 0; i < contaPuntini; i++) {
                    dots += ".";
                }
                jLabel1.setText("Caricamento" + dots);
            }
        });

        timer.start();
    }
    
    /**
     * Aggiorna lo stato della barra di progresso.
     *
     * @param valore  valore corrente del progresso.
     * @param massimo valore massimo della barra.
     */
    public void aggiornaProgresso(int valore, int massimo) {
    progressBar.setMaximum(massimo);
    progressBar.setValue(valore);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        iconaLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        progressBar.setBackground(new java.awt.Color(0, 102, 102));
        progressBar.setForeground(new java.awt.Color(255, 255, 255));

        iconaLogo.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(iconaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(iconaLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconaLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}

