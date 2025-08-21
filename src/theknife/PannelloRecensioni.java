/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package theknife;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
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
        if (commento.isRisposta()) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }
        
        JPanel panelStelle = new JPanel();
        panelStelle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0)); // orizzontale, poco spazio tra le stelle
        panelStelle.setBorder(new LineBorder(Color.BLACK, 5));
        panelStelle.setPreferredSize(new Dimension(200,25));
        panelStelle.setMaximumSize(new Dimension(200,25));
        panelStelle.setOpaque(false);

        // Creo 5 label "stella"
        JLabel stella1 = creaStellina();
        JLabel stella2 = creaStellina();
        JLabel stella3 = creaStellina();
        JLabel stella4 = creaStellina();
        JLabel stella5 = creaStellina();

        // Le aggiungo al pannellino
        panelStelle.add(stella1);
        panelStelle.add(stella2);
        panelStelle.add(stella3);
        panelStelle.add(stella4);
        panelStelle.add(stella5);

       
        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setBorder(new LineBorder(Color.BLACK, 5));
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel(utente.getUsernameUtente() + " #" + utente.getIdUtente());
        nome.setBorder(new LineBorder(Color.BLACK, 5));
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        
        JLabel titolo = new JLabel(commento.getTitolo());
        titolo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel spazio = new JLabel(" ");
        spazio.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel testo = new JLabel("<html><p style='width: 600px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        panelScritte.add(nome);
        panelScritte.add(titolo);
        panelScritte.add(panelStelle);
        panelScritte.add(spazio);
        panelScritte.add(testo);
        add(panelScritte, BorderLayout.NORTH);
        
        // --- SEZIONE PULSANTI ---
        if(gestore.getArchivioUtenti().getUtenteAttuale().getRuoloUtente().equals("ristoratore") && !commento.isRisposta()) {
            JButton btnRispondi = new JButton("Rispondi");
            btnRispondi.addActionListener(e -> {
            ScriviRisposta pagRec = new ScriviRisposta(gestore, commento);
            pagRec.setLocationRelativeTo(null);
            pagRec.pack();
            pagRec.setVisible(true);
            });
             
            add(btnRispondi, BorderLayout.SOUTH);
        }
        repaint();
        revalidate();
    }
    
    private JLabel creaStellina() {
    JLabel stella = new JLabel();
    stella.setPreferredSize(new Dimension(15, 15));
    stella.setOpaque(true);
    stella.setBackground(Color.YELLOW); // colore giallo come "stella"
    return stella;
}
}

//controllo di utente 1 solo commento (sparisce tasto scrivi), se ci sono <= 3 commenti non c'è tasto vedi tutti
//campi vuoti commento e ristorante
//metodo haRisposta + creazione panel risposta, creazione metodo commento attuale
//rislist prima pagina = primo ristorantea
//guest modifiche ai pulsanti (alla fine)
//risposte spostate verso destra leggermente

