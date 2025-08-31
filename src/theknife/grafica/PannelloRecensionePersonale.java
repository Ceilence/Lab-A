/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;
import theknife.grafica.ScriviRisposta;
import theknife.essenziali.Utente;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 * Rappresenta un componente grafico che mostra una recensione scritta da un utente per un ristorante.
 * <p>
 *  All'interno del pannello vengono visualizzate le informazioni principali della recensione:
 *  <ul>
 *      <li>il nome del ristorante recensito,</li>
 *      <li>la valutazione numerica assegnata,</li>
 *      <li>il titolo della recensione,</li>
 *      <li>il testo della recensione.</li>
 *  </ul>
 *
 * Inoltre, il pannello fornisce due pulsanti che permettono all'utente di:
 * <ul>
 *   <li>Modifica: aprire una finestra per modificare la recensione,</li>
 *   <li>Elimina: rimuovere definitivamente la recensione dopo la richiesta di una conferma.</li>
 * </ul>
 *
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public final class PannelloRecensionePersonale extends JPanel{
    /**
     * Costruisce un nuovo pannello che mostra la recensione personale di un utente.
     *
     * @param gestore    il {@link GestoreArchivi} usato per gestire i dati e le operazioni sugli archivi.
     * @param commento   il commento ({@link CommentiRistoranti}) che rappresenta la recensione da visualizzare.
     * @param pagUtente  la {@link PaginaUtente} a cui appartiene il pannello.
     * @param risList    l'oggetto {@link RisList} che gestisce la lista dei ristoranti.
     */
    public PannelloRecensionePersonale(GestoreArchivi gestore, CommentiRistoranti commento, PaginaUtente pagUtente, RisList risList){    
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setBackground(Color.WHITE);

        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel("Recensione per: "  + gestore.getArchivioRis().getRistorante(commento.getIdRistorante()).getNomeRis());
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        
        JLabel voto = new JLabel("Valutazione: " + commento.getValutazione() + "/5");
        voto.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel testo = new JLabel("<html><p style='width: 580px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        
        panelScritte.add(nome);
        panelScritte.add(voto);
        panelScritte.add(Box.createVerticalStrut(5));
        panelScritte.add(titolo);
        panelScritte.add(Box.createVerticalStrut(5));
        panelScritte.add(testo);
        panelScritte.add(Box.createVerticalStrut(5));
        panelScritte.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(panelScritte);
        
        JPanel panelBottoni = new JPanel();
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.X_AXIS));
        panelBottoni.setOpaque(false);

        /**
         * Pulsante di modifica.
         * 
         * Permette all'utente di modificare la recensione esistente. Quando cliccato, apre una finestra {@link ModificaRecensione} e aggiorna i componenti generali di {@link RisList}.
         */
        JButton modRecensione = new JButton("Modifica");
        modRecensione.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modRecensione.addActionListener(e -> {
            ModificaRecensione mr = new ModificaRecensione(gestore, GestoreArchivi.RisListFrame, commento, pagUtente);
            GestoreArchivi.RisListFrame.aggiornaComponentiGenerali(gestore.getArchivioRis().getRisAttuale());
            mr.setVisible(true);
            mr.setLocationRelativeTo(null);
        });

        /**
         * Pulsante elimina.
         * 
         * Permette all'utente di eliminare la recensione. Mostra un {@link JOptionPane} per la conferma. Se confermato, rimuove la recensione dall'archivio e aggiorna sia la pagina utente sia {@link RisList}.
         */
        JButton elimRecensione = new JButton("Elimina");
        elimRecensione.setCursor(new Cursor(Cursor.HAND_CURSOR));
        elimRecensione.addActionListener(e -> {
            int conferma = JOptionPane.showOptionDialog(this, "Vuoi davvero eliminare il commento?", "Conferma eliminazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sì", "No"}, "No");
            if (conferma == JOptionPane.YES_OPTION) {
                gestore.getArchivioCommenti().rimuoviCommento(commento);
                pagUtente.generaCommentiUtente();
                GestoreArchivi.RisListFrame.aggiornaComponentiGenerali(gestore.getArchivioRis().getRisAttuale());
            }
        });
       
        panelBottoni.add(modRecensione);
        panelBottoni.add(elimRecensione);
        panelBottoni.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        add(panelBottoni);
        
        repaint();
        revalidate();
    }
}

