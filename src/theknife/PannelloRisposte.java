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
public final class PannelloRisposte extends JPanel{
    
    public PannelloRisposte(GestoreArchivi gestore, CommentiRistoranti commento){        
        // Layout verticale con margini
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        setBackground(new Color(254, 254, 254));
        
        // --- SEZIONE SCRITTE ---
        JPanel panelScritte = new JPanel();
        panelScritte.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
        panelScritte.setOpaque(false);
        
        JLabel nome = new JLabel();
        if(gestore.getArchivioUtenti().getUtenteAttuale().getRuoloUtente().equals("ristoratore")) {
            nome.setText("La tua risposta: ");
            nome.setFont(new Font("Arial", Font.BOLD, 15));
        } else {
            nome.setText("Risposta del ristoratore: ");
            nome.setFont(new Font("Arial", Font.BOLD, 15));
        }
        
        JLabel spazio = new JLabel(" ");
        spazio.setFont(new Font("Arial", Font.PLAIN, 10));
        
        JLabel testo = new JLabel("<html><p style='width: 600px'>" + commento.getTesto() + "</p></html>");
        testo.setFont(new Font("Arial", Font.PLAIN, 15));
        panelScritte.add(nome);
        panelScritte.add(spazio);
        panelScritte.add(testo);
        add(panelScritte, BorderLayout.NORTH);
        
        repaint();
        revalidate();
    }
}

