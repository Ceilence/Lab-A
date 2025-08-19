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
    
    public PannelloRecensioni(GestoreArchivi gestore, CommentiRistoranti commento){    
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setBackground(Color.WHITE);
        if (commento.isRisposta()) {
           
            
        } else {
           
        }
        
        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel(utente.getUsernameUtente() + " #" + utente.getIdUtente());
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel spazio = new JLabel(" ");
        spazio.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel testo = new JLabel("<html><p style='width: 600px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        
        panelScritte.add(nome);
        panelScritte.add(titolo);
        panelScritte.add(spazio);
        panelScritte.add(testo);

        add(panelScritte, BorderLayout.NORTH);
    }
}

//controllo di utente 1 solo commento (sparisce tasto scrivi), se ci sono <= 3 commenti non c'è tasto vedi tutti
//campi vuoti commento e ristorante
//metodo haRisposta + creazione panel risposta, creazione metodo commento attuale
//rislist prima pagina = primo ristorantea