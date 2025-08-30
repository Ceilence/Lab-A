/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.*;
import javax.swing.*;
import theknife.essenziali.Ristorante;
import theknife.essenziali.Utente;
import theknife.gestori.GestoreArchivi;

/**
/**
 *  Mostra le informazioni di un ristorante presente nella lista dei preferiti di un utente.
 * <p>
 *  Ogni pannello visualizza il nome del ristorante, il tipo di cucina e un pulsante "Rimuovi" che consente all'utente di eliminare quel ristorante dai preferiti. Dopo la rimozione, la lista dei preferiti e l'interfaccia grafica vengono aggiornate.
 *
 * @see Ristorante
 * @see Utente
 * @see GestoreArchivi
 * @see RisList
 * @see PaginaUtente
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class PannelloPreferiti extends JPanel{
    /**
     * costruisce un pannello grafico che rappresenta un ristorante preferito, può creare più pannelli se inserito in opportune istruzioni cicliche.
     * 
     * @param gestore il {@link GestoreArchivi} che gestisce gli  archivi di utenti, preferiti e ristoranti
     * @param r il {@link Ristorante} da visualizzare come preferito.
     * @param paginaUtente la {@link PaginaUtente}, usata in una finestra di opzioni.
     * @param risList l'oggetto {@link RisList} che contiene la lista dei ristoranti preferiti, aggiornata dopo una rimozione.
     * @param contenitore il contenitore grafico che ospita il pannello. Viene aggiornato anch'esso dopo una rimozione di un ristorante.
     */
    public PannelloPreferiti(GestoreArchivi gestore, Ristorante r, PaginaUtente paginaUtente, RisList risList, JPanel contenitore) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(new Color(245, 245, 245));
        setPreferredSize(new Dimension(750, 80));
        setMaximumSize(new Dimension(750, 80));
        
        /**recupera l'utente attualmente loggato.*/
        Utente u = gestore.getArchivioUtenti().getUtenteAttuale();

        // infoPanel
        /** Pannello informazioni de ristorante (contiene il nome e il tipo del ristorante).*/
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
        
        /*Etichetta che mostra il nome del ristorante.*/
        JLabel nomeRisto = new JLabel(r.getNomeRis());
        nomeRisto.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(nomeRisto);
        
        /** Etichetta che mostra il tipo di cucina del ristorante.*/
        JLabel tipoCucina = new JLabel(r.getCuisRis());
        tipoCucina.setFont(new Font("Arial", Font.PLAIN, 14));
        tipoCucina.setForeground(Color.DARK_GRAY);
        infoPanel.add(tipoCucina);

        // rimuovi
        /**Pulsante che consente di rimuovere il ristorante selezionato dai preferiti.*/
        JButton rimuovi = new JButton("Rimuovi");
        rimuovi.setPreferredSize(new Dimension(80, 10));
        rimuovi.setFocusPainted(false);
        rimuovi.setBackground(new Color(0, 102, 102));
        rimuovi.setForeground(Color.WHITE);
        rimuovi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        rimuovi.addActionListener(e -> {
            int conferma = JOptionPane.showOptionDialog(paginaUtente,"Vuoi davvero rimuovere " + r.getNomeRis() + " dai preferiti?","Conferma",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, new Object[]{"Sì", "No"}, "No");

            if (conferma == JOptionPane.YES_OPTION) {
                gestore.getArchivioPreferiti().setPrefAttuale(r.getIdRis(), u.getIdUtente());
                gestore.getArchivioPreferiti().rimuoviPreferito();
                gestore.getArchivioPreferiti().aggiornaPref();
                risList.aggiornaDetPref();

                contenitore.remove(this);
                contenitore.revalidate();
                contenitore.repaint();
            }
        });
        
        /**pannello che contiene il pulsante "Rimuovi".*/
        JPanel bottonePanel = new JPanel();
        bottonePanel.setOpaque(false);
        bottonePanel.setLayout(new BoxLayout(bottonePanel, BoxLayout.Y_AXIS));
        bottonePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        bottonePanel.add(rimuovi);

        add(infoPanel, BorderLayout.CENTER);
        add(bottonePanel, BorderLayout.EAST);
    }
}



