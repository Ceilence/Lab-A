/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 * Rappresenta un pannello grafico che mostra la risposta di un ristoratore a una recensione.
 * <p>
 *  All'interno del pannello vengono mostrati:
 *  <ul>
 *      <li>La dicitura "Risposta del ristoratore:".</li>
 *      <li>Il testo della risposta.</li>
 *  </ul>
 * 
 * @see CommentiRistoranti
 * @see GestoreArchivi
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class PannelloRisposta extends JPanel{
    
    /**
     * Costruttore della classe PannelloRisposta.
     * <p> Inizializza il pannello con la risposta del ristoratore relativa alla recensione fornita.
     *
     * @param gestore il {@link GestoreArchivi} che gestisce gli archivi del sistema.
     * @param commento il commento ({@link CommentiRistoranti}) contenente i dati della recensione a cui rispondere.
     */
    public PannelloRisposta(GestoreArchivi gestore, CommentiRistoranti commento) {
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
        nomeRisposta.setText("Risposta del ristoratore:");
        nomeRisposta.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel testoRisposta = new JLabel("<html><p style='width: 570px'>" + risposta.getTesto() + "</p></html>");
        testoRisposta.setFont(new Font("Arial", Font.PLAIN, 15));

        contenitoreScritte.add(nomeRisposta);
        contenitoreScritte.add(Box.createVerticalStrut(20));
        contenitoreScritte.add(testoRisposta);
        contenitoreScritte.add(Box.createVerticalStrut(10));

        pannelloRisposta.add(contenitoreScritte);

        add(pannelloRisposta);

        revalidate();
        repaint();
    }
}
