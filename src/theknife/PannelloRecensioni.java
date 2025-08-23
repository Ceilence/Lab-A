/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package theknife;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author SSSSUGOI
 */
public final class PannelloRecensioni extends JPanel{
    
    public PannelloRecensioni(GestoreArchivi gestore, CommentiRistoranti commento){    
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setBackground(Color.WHITE);
        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel(utente.getUsernameUtente() + " #" + utente.getIdUtente());
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        
        JLabel voto = new JLabel("Valutazione: " + commento.getValutazione() + "/5");
        voto.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel spazio1 = new JLabel(" ");
        spazio1.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel spazio2 = new JLabel(" ");
        spazio2.setFont(new Font("Arial", Font.PLAIN, 10));
        
         JLabel spazio3 = new JLabel(" ");
        spazio3.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel testo = new JLabel("<html><p style='width: 600px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        panelScritte.add(nome);
        panelScritte.add(voto);
        panelScritte.add(spazio1);
        panelScritte.add(titolo);
        panelScritte.add(spazio2);
        panelScritte.add(testo);
        panelScritte.add(spazio3);
        add(panelScritte, BorderLayout.NORTH);
        
        // --- SEZIONE PULSANTI ---
        if(gestore.getArchivioUtenti().getUtenteAttuale().getRuoloUtente().equals("ristoratore") && !commento.isRisposta() && !commento.haRisposta()) {
            JButton btnRispondi = new JButton("Rispondi");
            btnRispondi.addActionListener(e -> {
                ScriviRisposta wrRisposta = new ScriviRisposta(gestore, commento, btnRispondi);
                wrRisposta.setLocationRelativeTo(null);
                wrRisposta.pack();
                wrRisposta.setVisible(true);
            });
            add(btnRispondi, BorderLayout.SOUTH);
        }
        repaint();
        revalidate();
    }
    
    public PannelloRecensioni (GestoreArchivi gestore, CommentiRistoranti commento, PaginaUtente pagUtente) {
        Utente utente = gestore.getArchivioUtenti().getUtente(commento.getIdScrittore());
        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setBackground(Color.WHITE);
        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel(utente.getUsernameUtente() + " #" + utente.getIdUtente());
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        
        JLabel voto = new JLabel("Valutazione: " + commento.getValutazione() + "/5");
        voto.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel spazio1 = new JLabel(" ");
        spazio1.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel spazio2 = new JLabel(" ");
        spazio2.setFont(new Font("Arial", Font.PLAIN, 10));
        
         JLabel spazio3 = new JLabel(" ");
        spazio3.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel testo = new JLabel("<html><p style='width: 600px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        panelScritte.add(nome);
        panelScritte.add(voto);
        panelScritte.add(spazio1);
        panelScritte.add(titolo);
        panelScritte.add(spazio2);
        panelScritte.add(testo);
        panelScritte.add(spazio3);
        add(panelScritte, BorderLayout.NORTH);
        
        JPanel panelBottoni = new JPanel();
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.X_AXIS));
        panelBottoni.setOpaque(false);

        JButton modRecensione = new JButton("Modifica");
        modRecensione.addActionListener(e -> {
            ModificaRecensione mr = new ModificaRecensione(gestore, GestoreArchivi.RisListFrame, commento, pagUtente);
            mr.setVisible(true);
            mr.setLocationRelativeTo(null);
        });

        JButton elimRecensione = new JButton("Elimina");
        elimRecensione.addActionListener(e -> {
            int conferma = JOptionPane.showOptionDialog(this, "Vuoi davvero eliminare il commento?", "Conferma eliminazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sì", "No"}, "No");
            if (conferma == JOptionPane.YES_OPTION) {
                gestore.getArchivioCommenti().rimuoviCommento(commento);
                pagUtente.generaCommentiUtente();
                pagUtente.contenitoreRepaint();
            }
        });

        panelBottoni.add(modRecensione);
        panelBottoni.add(elimRecensione);
        add(panelBottoni, BoxLayout.Y_AXIS); 
        add(modRecensione, BoxLayout.Y_AXIS);
        repaint();
        revalidate();

    }
    
}


//guest modifiche ai pulsanti (alla fine)
//modifiche recensioni e risposte (pagUtente e pagRistoratore)
//mettere campo ricerca in rislist che ricerca tra i filtrati


