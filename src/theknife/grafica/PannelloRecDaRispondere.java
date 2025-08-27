/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import theknife.essenziali.CommentiRistoranti;
import theknife.essenziali.Utente;
import theknife.gestori.GestoreArchivi;

/**
 *
 * @author davim
 */
public class PannelloRecDaRispondere extends JPanel{
    
        public PannelloRecDaRispondere(GestoreArchivi gestore, CommentiRistoranti commento, PaginaRistoratore pagRisto) {
    
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 2),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setBackground(Color.WHITE);
        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel(utente.getUsernameUtente() + " #" + utente.getIdUtente());
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        
        JLabel voto = new JLabel("Valutazione: " + commento.getValutazione() + "/5");
        voto.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel spazio1 = new JLabel(" ");
        spazio1.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel spazio2 = new JLabel(" ");
        spazio2.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel spazio3 = new JLabel(" ");
        spazio3.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel testo = new JLabel("<html><p style='width: 550px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        
        panelScritte.add(nome);
        panelScritte.add(voto);
        panelScritte.add(spazio1);
        panelScritte.add(titolo);
        panelScritte.add(spazio2);
        panelScritte.add(testo);
        panelScritte.add(spazio3);
        add(panelScritte);
        
        // --- SEZIONE PULSANTI ---
        if (!commento.haRisposta()) {
            JButton btnRispondi = new JButton("Rispondi");
            btnRispondi.addActionListener(e -> {
                ScriviRisposta wrRisposta = new ScriviRisposta(gestore, commento, btnRispondi, pagRisto);
                wrRisposta.setLocationRelativeTo(null);
                wrRisposta.pack();
                wrRisposta.setVisible(true);
            });
            add(btnRispondi);
        }
        revalidate();
        repaint();
    }
}