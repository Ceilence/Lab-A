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
public class PannelloRis extends JPanel{
    public PannelloRis(JScrollPane scrollPane) {
        //Imposta layout in mdo che ogni panel viene creato uno sotto l'altro.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Aggiunge spazio dai bordi del panel
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        int numeroPannello = 20;
        int altezzaPannello = 100;
        //Spazio tra ogni pannello
        int spazioPannelli = 10;
        
        //Ottiene altezza complessiva del pannello, 
        int altezzaTotale = numeroPannello * altezzaPannello + (numeroPannello - 1) * spazioPannelli;
        
        //Override getPreferredSize per adattarsi a scrollpane
        this.setPreferredSize(new Dimension(0, 0));

        for (int i = 1; i <= numeroPannello; i++) {
            
            //Crea pannello con bordo grigio e allineato a sinistra
            JPanel pannello = new JPanel(new BorderLayout());
            pannello.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            pannello.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            //La larghezza viene modificata nelle righe finali per adattarsi allo scrollpane
            //L'altezza è fissa
            pannello.setMaximumSize(new Dimension(Integer.MAX_VALUE, altezzaPannello));
            pannello.setPreferredSize(new Dimension(0, altezzaPannello));
            pannello.setMinimumSize(new Dimension(0, altezzaPannello));
            
            //Crea titolo con font e grandezza. è posizionato in alto
            JPanel panelScritte = new JPanel();
            panelScritte.setLayout(new BoxLayout(panelScritte, BoxLayout.Y_AXIS));
            //il panel è invisibile
            panelScritte.setOpaque(false);
            
            JLabel titolo = new JLabel("Ristorante " + i);
            titolo.setFont(new Font("Arial", Font.BOLD, 16));
            
            JLabel cuis = new JLabel("Tipo cucina " + i);
            titolo.setFont(new Font("Arial", Font.BOLD, 16));
            
            //Aggiunta dei due label al panel
            panelScritte.add(titolo);
            panelScritte.add(cuis);
            
            //Inserimento pannello in alto
            pannello.add(panelScritte, BorderLayout.NORTH);
            
            JLabel immagine = new JLabel("IMG");
            immagine.setPreferredSize(new Dimension(60, 60));
            immagine.setOpaque(true);
            immagine.setBackground(Color.LIGHT_GRAY);
            immagine.setHorizontalAlignment(SwingConstants.CENTER);
            pannello.add(immagine, BorderLayout.WEST);
            
            /*
            JButton bottone = new JButton("Azione");
            int finalI = i;
            bottone.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Hai cliccato su Elemento " + finalI)
            );
            card.add(bottone, BorderLayout.EAST);
            */
            
            //Il pannello del ristorante viene aggiunto a quello principale
            add(pannello);
            //Crea uno spazio tra un pannello e l'altro
            add(Box.createRigidArea(new Dimension(0, 10)));
        }
        
        // Imposta la dimensione in base all'altezza calcolata
        int larghezza = scrollPane.getViewport().getWidth(); // iniziale (potrebbe essere 0)
        setPreferredSize(new Dimension(larghezza, altezzaTotale));
        
        // Aggiorna larghezza dinamicamente quando lo scrollPane viene ridimensionato
        scrollPane.getViewport().addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int nuovaLarghezza = scrollPane.getViewport().getWidth();
                setPreferredSize(new Dimension(nuovaLarghezza, altezzaTotale));
                revalidate();
            }
        });
    }
}
