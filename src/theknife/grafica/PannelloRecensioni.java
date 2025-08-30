/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */

package theknife.grafica;
import theknife.essenziali.Utente;
import javax.swing.*;
import java.awt.*;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;


/**
 * Rappresenta un pannello grafico che mostra una singola recensione scritta da un utente.
 * <p>
 *  All'interno del pannello vengono visualizzati:
 *  <ul>
 *      <li>Il nome e l'ID dell'utente che ha scritto la recensione.</li>
 *      <li>Il voto assegnato dall'utente (su 5).</li>
 *      <li>Il titolo della recensione.</li>
 *      <li>Il testo della recensione.</li>
 *  </ul>
 * <p>
 * 
 * @see CommentiRistoranti
 * @see Utente
 * @see GestoreArchivi
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public final class PannelloRecensioni extends JPanel{
    /**
     * Costruttore della classe PannelloRecensioni.
     * <p>
     * Inizializza il pannello mostrando le informazioni della recensione.
     *
     * @param gestore il {@link GestoreArchivi} che gestisce gli archivi del sistema.
     * @param commento il commento ({@link CommentiRistoranti}) contenente i dati della recensione.
     */
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


