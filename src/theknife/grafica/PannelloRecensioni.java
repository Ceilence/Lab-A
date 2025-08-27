/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package theknife.grafica;
import theknife.essenziali.Utente;
import javax.swing.*;
import java.awt.*;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;


/**
 *
 * @author SSSSUGOI
 */
public final class PannelloRecensioni extends JPanel{
    
    public PannelloRecensioni(GestoreArchivi gestore, CommentiRistoranti commento) {
    
         Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
        
        JLabel testo = new JLabel("<html><p style='width: 590px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        panelScritte.add(nome);
        panelScritte.add(voto);
        panelScritte.add(Box.createVerticalStrut(20));
        panelScritte.add(titolo);
        panelScritte.add(Box.createVerticalStrut(20));
        panelScritte.add(testo);
        panelScritte.add(Box.createVerticalStrut(10));
        add(panelScritte, BorderLayout.NORTH);
        
        repaint();
        revalidate();
    }
}


//guest modifiche ai pulsanti (alla fine)
//modifiche recensioni e risposte (pagUtente e pagRistoratore)
//mettere campo ricerca in rislist che ricerca tra i filtrati


