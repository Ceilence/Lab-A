/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 * Rappresenta un pannello grafico che mostra la risposta a una recensione di un cliente nell'interfaccia del ristoratore.
 * <p>
 *  Il pannello visualizza:
 *  <ul>
 *      <li>La dicitura fissa "La tua risposta:".</li>
 *      <li>Il testo della risposta fornita dal ristoratore.</li>
 *      <li>Pulsanti per modificare o eliminare la risposta.</li>
 *  </ul>
 * </p>
 * La classe permette l'interazione con il {@link GestoreArchivi} per modificare o rimuovere la risposta e aggiorna la {@link PaginaRistoratore} di conseguenza.
 * 
 * @see CommentiRistoranti
 * @see GestoreArchivi
 * @see PaginaRistoratore
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class PannelloRispostaRistoratore extends JPanel{
    /**
     * Costruttore della classe PannelloRispostaRistoratore.
     * 
     * Inizializza il pannello con la risposta di un ristoratore relativa alla recensione fornita.
     *
     * @param gestore il {@link GestoreArchivi} che gestisce gli archivi del sistema.
     * @param commento il commento ({@link CommentiRistoranti}) a cui la risposta è collegata.
     * @param pagRisto la {@link PaginaRistoratore} che visualizza i pannelli delle recensioni.
     */
    public PannelloRispostaRistoratore(GestoreArchivi gestore, CommentiRistoranti commento, PaginaRistoratore pagRisto) {
        CommentiRistoranti risposta = gestore.getArchivioCommenti().getRisposta(commento);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(254, 254, 254));

        // Pannello che contiene il bordo e il margine per spostare a destra
        JPanel pannelloRisposta = new JPanel();
        pannelloRisposta.setLayout(new BoxLayout(pannelloRisposta, BoxLayout.Y_AXIS));
        pannelloRisposta.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // margine sinistro 20 px
        pannelloRisposta.setOpaque(false);

        // Pannello interno con LineBorder
        JPanel contenitoreScritte = new JPanel();
        contenitoreScritte.setLayout(new BoxLayout(contenitoreScritte, BoxLayout.Y_AXIS));
        contenitoreScritte.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        contenitoreScritte.setOpaque(true);
        contenitoreScritte.setBackground(Color.WHITE);

        JLabel nomeRisposta = new JLabel();
        nomeRisposta.setText("La tua risposta:");
        nomeRisposta.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel testoRisposta = new JLabel("<html><p style='width: 570px'>" + risposta.getTesto() + "</p></html>");
        testoRisposta.setFont(new Font("Arial", Font.PLAIN, 15));

         JPanel panelBottoni = new JPanel();
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.X_AXIS));
        panelBottoni.setOpaque(false);

        JButton modRecensione = new JButton("Modifica");
        modRecensione.addActionListener(e -> {
            ModificaRisposta mr = new ModificaRisposta(gestore, commento, risposta, pagRisto);
            pagRisto.cambiaCard();
            mr.setVisible(true);
            mr.setLocationRelativeTo(null);
        });

        JButton elimRecensione = new JButton("Elimina");
        elimRecensione.addActionListener(e -> {
            int conferma = JOptionPane.showOptionDialog(this, "Vuoi davvero eliminare il commento?", "Conferma eliminazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sì", "No"}, "No");
            if (conferma == JOptionPane.YES_OPTION) {
                commento.setHaRisposta(false);
                gestore.getArchivioCommenti().rimuoviRisposta(risposta);
                pagRisto.cambiaCard();
            }
        });
       
        panelBottoni.add(modRecensione);
        panelBottoni.add(elimRecensione);
        panelBottoni.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenitoreScritte.add(nomeRisposta);
        contenitoreScritte.add(Box.createVerticalStrut(20));
        contenitoreScritte.add(testoRisposta);
        contenitoreScritte.add(Box.createVerticalStrut(10));

        pannelloRisposta.add(contenitoreScritte);

        pannelloRisposta.add(panelBottoni);
        add(pannelloRisposta);
        

        revalidate();
        repaint();
    }
}
