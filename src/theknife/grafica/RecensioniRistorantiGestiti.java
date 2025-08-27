/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.grafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import theknife.essenziali.CommentiRistoranti;
import theknife.essenziali.Ristorante;
import theknife.gestori.GestoreArchivi;

/**
 *
 * @author davim
 */

public class RecensioniRistorantiGestiti extends JPanel {

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
