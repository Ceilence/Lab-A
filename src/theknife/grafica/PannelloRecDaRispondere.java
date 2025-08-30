/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import theknife.essenziali.CommentiRistoranti;
import theknife.essenziali.Utente;
import theknife.gestori.GestoreArchivi;

/**
 * Rappresenta un pannello grafico che mostra un commento lasciato da un utente su un ristorante, al quale può essere aggiunta una risposta da parte del ristoratore.
 * <p>
 *  Il pannello visualizza:
 *  <ul>
 *      <li>Nome e ID dell’utente che ha scritto il commento.</li>
 *      <li>La valutazione data (da 1 a 5).</li>
 *      <li>Il titolo e il testo del commento.</li>
 *      <li>Un pulsante "Rispondi" (solo se il commento non ha già ricevuto risposta).</li>
 *  </ul>
 *
 * <p>
 *  Quando viene premuto il pulsante "Rispondi", si apre una finestra {@link ScriviRisposta} che permette al ristoratore di scrivere e salvare la risposta.
 *
 * @see CommentiRistoranti
 * @see GestoreArchivi
 * @see PaginaRistoratore
 * @see ScriviRisposta
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class PannelloRecDaRispondere extends JPanel{
        
        /**
        * Costruisce un nuovo pannello che rappresenta un commento da parte di un utente.
        *
        * @param gestore   il {@link GestoreArchivi} usato per recuperare informazioni su utenti e commenti.
        * @param commento  il commento ({@link CommentiRistoranti}) da mostrare.
        * @param pagRisto  la {@link PaginaRistoratore} che ospita il pannello e gestisce le risposte.
        */
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