/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.grafica;
import theknife.grafica.ScriviRisposta;
import theknife.essenziali.Utente;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;
/**
 *
 * @author davim
 */
public final class PannelloRecensionePersonale extends JPanel{
    
    public PannelloRecensionePersonale(GestoreArchivi gestore, CommentiRistoranti commento, PaginaUtente pagUtente, RisList risList){    
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(750, Integer.MAX_VALUE));

        
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
        
        JLabel testo = new JLabel("<html><p style='width: 600px'>" + commento.getTesto() + "</p></html>");
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

        JButton modRecensione = new JButton("Modifica");
        modRecensione.addActionListener(e -> {
            ModificaRecensione mr = new ModificaRecensione(gestore, GestoreArchivi.RisListFrame, commento, pagUtente);
            GestoreArchivi.RisListFrame.aggiornaComponentiGenerali(gestore.getArchivioRis().getRisAttuale());
            mr.setVisible(true);
            mr.setLocationRelativeTo(null);
        });

        JButton elimRecensione = new JButton("Elimina");
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
         
        add(Box.createVerticalGlue());
        add(panelBottoni);
        
        repaint();
        revalidate();
    }
}

