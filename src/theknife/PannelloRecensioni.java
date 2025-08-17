/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package theknife;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author SSSSUGOI
 */
public final class PannelloRecensioni extends JPanel{
    private CommentiRistoranti commento;
    private final int ALTEZZA_PANNELLO = 100;
    
    public PannelloRecensioni(GestoreArchivi gestore, CommentiRistoranti commento){    
        this.commento = commento;
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, ALTEZZA_PANNELLO));
        setPreferredSize(new Dimension(0, ALTEZZA_PANNELLO));
        setMinimumSize(new Dimension(0, ALTEZZA_PANNELLO));

        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        JLabel nome = new JLabel(utente.getUsernameUtente() + " #" + utente.getIdUtente());
        nome.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel testo = new JLabel(commento.getTesto());
        testo.setFont(new Font("Arial", Font.BOLD, 16));
        
        panelScritte.add(nome);
        panelScritte.add(testo);

        add(panelScritte, BorderLayout.NORTH);
    }
}

//graficamente pannelli belli, controllo di utente 1 solo commento (sparisce tasto scrivi), se ci sono <= 3 commenti non c'è tasto vedi tutti
