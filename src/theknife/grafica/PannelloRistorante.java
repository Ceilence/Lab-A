/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */

package theknife.grafica;
import theknife.grafica.RisList;
import theknife.essenziali.Ristorante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import theknife.gestori.GestoreArchivi;

/**
 * Rappresenta un pannello grafico che mostra le informazioni principali di un ristorante.
 * <p>
 *  Il pannello visualizza:
 *  <ul>
 *      <li>Il nome del ristorante.</li>
 *      <li>Il tipo di cucina.</li>
 *      <li>Un'icona associata alla nazione a cui appartiene il ristorante.</li>
 *  </ul>
 * <p>
 * La classe fornisce anche un listener per il click sul pannello, che permette di aggiornare i componenti generali della {@link RisList} relativa al ristorante selezionato.
 * 
 * @see Ristorante
 * @see RisList
 * @see GestoreArchivi
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public final class PannelloRistorante extends JPanel{
    
    /**
     * Il ristorante associato a questo pannello. {@code ristorante}
     */
    private Ristorante ristorante;
    
    /**
     * Altezza fissa del pannello in pixel. {@code ALTEZZA_PANNELLO}
     */
    private final int ALTEZZA_PANNELLO = 100;
    
     /**
     * Immagine rappresentativa dello stato del ristorante. {@code immagine}
     */
    private ImageIcon immagine;
    
    /**
     * Costruttore della classe PannelloRistorante.
     * 
     * Inizializza il pannello con nome, tipo di cucina e immagine del ristorante.
     * Imposta un listener per il click che aggiorna i componenti della {@link RisList}.
     *
     * @param risList la lista di ristoranti {@link RisList} che gestisce i componenti.
     * @param gestore il {@link GestoreArchivi} utilizzato per gestire gli archivi.
     * @param r il {@link Ristorante} da visualizzare nel pannello.
     * @param contenitoreCommenti il {@link JPanel} che conterrà eventuali commenti (non usato direttamente).
     */
    public PannelloRistorante(RisList risList, GestoreArchivi gestore, Ristorante r, JPanel contenitoreCommenti) {
        this.ristorante = r;
        immagine = risList.selezionaImmagine(r.getStatoRis());
        
        // Layout verticale con margini
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, ALTEZZA_PANNELLO));
        setPreferredSize(new Dimension(0, ALTEZZA_PANNELLO));
        setMinimumSize(new Dimension(0, ALTEZZA_PANNELLO));

        // Sezione scritte
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);

        JLabel titolo = new JLabel(ristorante.getNomeRis());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel cuis = new JLabel(ristorante.getCuisRis());
        cuis.setFont(new Font("Arial", Font.PLAIN, 14));

        panelScritte.add(titolo);
        panelScritte.add(cuis);

        add(panelScritte, BorderLayout.NORTH);

        // Immagine
        JLabel bandiera = new JLabel(immagine);
        bandiera.setPreferredSize(new Dimension(60, 40));
        bandiera.setOpaque(true);
        bandiera.setBackground(Color.WHITE);
        bandiera.setHorizontalAlignment(SwingConstants.CENTER);
        add(bandiera, BorderLayout.WEST);

        // Listener per click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                risList.aggiornaComponentiGenerali(ristorante);
            }
        });

    }
    
     /**
     * Restituisce il {@link Ristorante} associato a questo pannello.
     *
     * @return il ristorante visualizzato nel pannello
     */
    public Ristorante getRistorante() {
        return ristorante;
    }     
}
