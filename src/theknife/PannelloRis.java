/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package theknife;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author SSSSUGOI
 */
public final class PannelloRis extends JPanel{
    private Ristorante ristorante;
    private final int ALTEZZA_PANNELLO = 100;
    private ImageIcon immagine;
    
    
    public PannelloRis(RisList risList, GestoreArchivi gestore, Ristorante r, JPanel contenitoreCommenti) {
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
                risList.resettaBarra();
                gestore.getArchivioRis().setRisAttuale(ristorante);
                gestore.getArchivioPreferiti().setPrefAttuale(ristorante.getIdRis(),gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente());
                gestore.getArchivioCommenti().generaCommenti(contenitoreCommenti, gestore, 3);

                risList.aggiornaLabel(r);
                risList.aggiornaDetPref();
                risList.aggiornaDettagli();
                risList.aggiornaTastoScrivi();
            }
        });

    }
        public Ristorante getRistorante() {
            return ristorante;
        }
}
