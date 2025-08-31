/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import theknife.essenziali.*;
import theknife.gestori.GestoreArchivi;

/**
 * rappresenta un pannello grafico per visualizzare brevemente un ristorante.
 * <p>
 *  Il pannello mostra:
 *  <ul>
 *      <li>Il nome del ristorante.</li>
 *      <li>Il numero totale di recensioni e quante sono nuove da leggere.</li>
 *      <li>Un pulsante per mostrare tutti i commenti del ristorante.</li>
 *  </ul>
 * <p>
 * Quando si clicca il pulsante "Mostra Commenti":
 * <ul>
 *   <li>Le recensioni nuove vengono contrassegnate come lette.</li>
 *   <li>Viene aggiornata la vista del {@link JPanel} che contiene i commenti.</li>
 *   <li>Si mostrano tutti i commenti con eventuali risposte del ristoratore.</li>
 * </ul>
 * 
 * @see GestoreArchivi
 * @see Ristorante
 * @see CommentiRistoranti
 * @see PannelloRecDaRispondere
 * @see PannelloRispostaRistoratore
 * @see PaginaRistoratore
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */

public class RecensioniRistorantiGestiti extends JPanel {
    
    /**
     * Costruttore della classe RecensioniRistorantiGestiti.
     * Inizializza il pannello con il nome del ristorante, il numero di recensioni, e un pulsante per mostrare tutti i commenti.
     * 
     * @param gestore il {@link GestoreArchivi} utilizzato per gestire gli archivi.
     * @param r il {@link Ristorante} di cui mostrare le recensioni.
     * @param contenitoreCommenti il {@link JPanel} in cui saranno visualizzati i commenti.
     * @param pannelloDestra il {@link JPanel} contenente il layout a schede (CardLayout).
     * @param pagRisto la {@link PaginaRistoratore} associata, necessaria per i pannelli dei commenti.
     */
    public RecensioniRistorantiGestiti(GestoreArchivi gestore,Ristorante r,JPanel contenitoreCommenti,JPanel pannelloDestra,PaginaRistoratore pagRisto) {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setMaximumSize(new Dimension(750, 80));

        // Sezione sinistra: Nome ristorante
        JLabel nomeLabel = new JLabel(r.getNomeRis());
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nomeLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(nomeLabel, BorderLayout.WEST);

        // Conta le recensioni da leggere
        ArrayList<CommentiRistoranti> listaDaLeggere = new ArrayList<>();
        int numero = 0;

        for (CommentiRistoranti c : gestore.getArchivioCommenti().getListaCommenti()) {
            if (c.getIdRistorante() == r.getIdRis()) {
                numero++;
                if (c.isDaLeggere()) {
                    listaDaLeggere.add(c);
                }
            }
        }

        JLabel daLeggere = new JLabel("Hai " + listaDaLeggere.size() + " nuove recensioni da leggere su " + numero + " totali.");
        daLeggere.setFont(new Font("Arial", Font.ITALIC, 12));
        daLeggere.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(daLeggere, BorderLayout.SOUTH);

        // Sezione destra: Pulsante per mostrare recensioni
        JButton btnMostra = new JButton("Mostra Commenti");
        btnMostra.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnMostra.addActionListener(e -> {
            // Imposta come già lette
            for (CommentiRistoranti c : listaDaLeggere) {
                c.setDaLeggere(false);
            }
            gestore.getArchivioCommenti().aggiornaCommenti();

            // Cambia vista
            CardLayout cl = (CardLayout) pannelloDestra.getLayout();
            cl.show(pannelloDestra, "commenti");

            gestore.getArchivioRis().setRisAttuale(r);

            // Mostra commenti del ristorante
            ArrayList<CommentiRistoranti> lista = gestore.getArchivioCommenti().getRecensioniPer(r.getIdRis(), Integer.MAX_VALUE);
            contenitoreCommenti.removeAll();

            for (CommentiRistoranti c : lista) {
                contenitoreCommenti.add(new PannelloRecDaRispondere(gestore, c, pagRisto));
                if (c.haRisposta()) {
                    contenitoreCommenti.add(new PannelloRispostaRistoratore(gestore, c, pagRisto));
                }
                contenitoreCommenti.add(Box.createVerticalStrut(10));
            }

            contenitoreCommenti.revalidate();
            contenitoreCommenti.repaint();
        });

        JPanel panelBottoni = new JPanel();
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.X_AXIS));
        panelBottoni.setOpaque(false);

        panelBottoni.add(btnMostra);
        add(Box.createVerticalGlue());
        add(panelBottoni);
    }
}
