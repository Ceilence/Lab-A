/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.grafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 *
 * @author davim
 */
public class PannelloRisposta extends JPanel{
    
    public PannelloRisposta(GestoreArchivi gestore, CommentiRistoranti commento) {
        CommentiRistoranti risposta = gestore.getArchivioCommenti().getRisposta(commento);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(254, 254, 254));

        // Pannello che contiene il bordo e il margine per spostare a destra
        JPanel pannelloRisposta = new JPanel();
        pannelloRisposta.setLayout(new BoxLayout(pannelloRisposta, BoxLayout.Y_AXIS));
        pannelloRisposta.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0), BorderFactory.createLineBorder(new Color(0, 102, 102), 2)));
        pannelloRisposta.setOpaque(false);

        // Pannello interno con LineBorder
        JPanel contenitoreScritte = new JPanel();
        contenitoreScritte.setLayout(new BoxLayout(contenitoreScritte, BoxLayout.Y_AXIS));
        contenitoreScritte.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        contenitoreScritte.setOpaque(true);
        contenitoreScritte.setBackground(Color.WHITE);

        JLabel nomeRisposta = new JLabel();
        nomeRisposta.setText("Risposta del ristoratore:");
        nomeRisposta.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel testoRisposta = new JLabel("<html><p style='width: 570px'>" + risposta.getTesto() + "</p></html>");
        testoRisposta.setFont(new Font("Arial", Font.PLAIN, 15));

        contenitoreScritte.add(nomeRisposta);
        contenitoreScritte.add(Box.createVerticalStrut(20));
        contenitoreScritte.add(testoRisposta);
        contenitoreScritte.add(Box.createVerticalStrut(10));

        pannelloRisposta.add(contenitoreScritte);

        add(pannelloRisposta);

        revalidate();
        repaint();
    }
}
