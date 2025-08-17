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
    // Icone (come prima)
    
    
    
    public PannelloRis(RisList risList, GestoreArchivi gestore, Ristorante r, JPanel dettaglioPanel,JLabel dettaglioNome,      
    JLabel dettaglioCucina,
    JLabel dettaglioImmagine,
    JLabel labelDescrizione,
    JButton detPref,
    ImageIcon iconaBandiera,
    JPanel contenitoreCommenti
) {
    this.ristorante = r;

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

    JLabel titolo = new JLabel(ristorante.getNomeRis());
    titolo.setFont(new Font("Arial", Font.BOLD, 16));

    JLabel cuis = new JLabel(ristorante.getCuisRis());
    cuis.setFont(new Font("Arial", Font.PLAIN, 14));

    panelScritte.add(titolo);
    panelScritte.add(cuis);

    add(panelScritte, BorderLayout.NORTH);

    // --- IMMAGINE ---
    JLabel immagine = new JLabel(iconaBandiera); // <-- uso immagine passata
    immagine.setPreferredSize(new Dimension(60, 40));
    immagine.setOpaque(true);
    immagine.setBackground(Color.WHITE);
    immagine.setHorizontalAlignment(SwingConstants.CENTER);
    add(immagine, BorderLayout.WEST);

    // --- LISTENER PER CLICK ---
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            gestore.getArchivioRis().setRisAttuale(ristorante);
            dettaglioNome.setText(ristorante.getNomeRis());
            dettaglioCucina.setText(ristorante.getCuisRis());
            labelDescrizione.setText("<html><p style='width:635px'>" + ristorante.getDesRis() + "</p></html>");
            dettaglioImmagine.setIcon(iconaBandiera); // <-- anche qui uso immagine già pronta

            gestore.getArchivioPreferiti().setPrefAttuale(
                ristorante.getIdRis(),
                gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente()
            );
            
            contenitoreCommenti.removeAll();
            int numero = 0;
            for(int i = gestore.getArchivioCommenti().getListaCommenti().size()-1; i >= 0; i--){
                if (gestore.getArchivioRis().getRisAttuale().getIdRis() == gestore.getArchivioCommenti().getListaCommenti().get(i).getIdRistorante() && numero < 3){
                    contenitoreCommenti.add(new PannelloRecensioni(gestore, gestore.getArchivioCommenti().getListaCommenti().get(i)));
                    numero++;
                }
                if (numero == 3)
                    break;
            }
            
            risList.aggiornaDetPref();

            dettaglioPanel.revalidate();
            dettaglioPanel.repaint();
            
            contenitoreCommenti.revalidate();
            contenitoreCommenti.repaint();
        }
    });
}
    public Ristorante getRistorante() {
        return ristorante;
    }

}
