/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.grafica;

import java.awt.*;
import javax.swing.*;
import theknife.essenziali.Ristorante;
import theknife.essenziali.Utente;
import theknife.gestori.GestoreArchivi;

/**
 *
 * @author davim
 */
public class PannelloPreferiti extends JPanel{

    public PannelloPreferiti(GestoreArchivi gestore, Ristorante r, PaginaUtente paginaUtente, RisList risList, JPanel contenitore) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(new Color(245, 245, 245));
        setPreferredSize(new Dimension(750, 80));
        setMaximumSize(new Dimension(750, 80));

        Utente u = gestore.getArchivioUtenti().getUtenteAttuale();

        // infoPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));

        JLabel nomeRisto = new JLabel(r.getNomeRis());
        nomeRisto.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(nomeRisto);

        JLabel tipoCucina = new JLabel(r.getCuisRis());
        tipoCucina.setFont(new Font("Arial", Font.PLAIN, 14));
        tipoCucina.setForeground(Color.DARK_GRAY);
        infoPanel.add(tipoCucina);

        // rimuovi
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

        JPanel bottonePanel = new JPanel();
        bottonePanel.setOpaque(false);
        bottonePanel.setLayout(new BoxLayout(bottonePanel, BoxLayout.Y_AXIS));
        bottonePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        bottonePanel.add(rimuovi);

        add(infoPanel, BorderLayout.CENTER);
        add(bottonePanel, BorderLayout.EAST);
    }
}



