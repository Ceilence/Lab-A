/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
/**
 *
 * @author SSSSUGOI
 */
public class PannelloRis extends JPanel{
    private GestoreArchivi gestore;
    private ImageIcon flagItalia;
    private ImageIcon flagCina;
    private ImageIcon flagFrancia;
    private ImageIcon flagGermania;
    private ImageIcon flagSpagna;
    private ImageIcon flagUSA;
    private ImageIcon flagGiappone;
    private ImageIcon flagMondo;
    
    public PannelloRis(JScrollPane scrollPane, GestoreArchivi gestore) {
        this.gestore = gestore;
        //Imposta layout in mdo che ogni panel viene creato uno sotto l'altro.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Aggiunge spazio dai bordi del panel
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        creaImmagine();
        
        int numeroPannello = gestore.getArchivioRis().getNumeroRis();
        int altezzaPannello = 100;
        //Spazio tra ogni pannello
        int spazioPannelli = 10;
        
        //Ottiene altezza complessiva del pannello, 
        int altezzaTotale = numeroPannello * altezzaPannello + (numeroPannello - 1) * spazioPannelli;
        
        //Override getPreferredSize per adattarsi a scrollpane
        this.setPreferredSize(new Dimension(0, 0));
        
        //Passaggio dell'immagine come path
       

        for (int i = 1; i <= numeroPannello; i++) {
            if(gestore.getArchivioRis().getRistorante(i) != null){
                //Crea pannello con bordo grigio e allineato a sinistra
                JPanel pannello = new JPanel(new BorderLayout());
                pannello.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                pannello.setAlignmentX(Component.LEFT_ALIGNMENT);
                pannello.setBackground(Color.WHITE);


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

                JLabel titolo = new JLabel(gestore.getArchivioRis().getRistorante(i).getNomeRis());
                titolo.setFont(new Font("Arial", Font.BOLD, 16));

                JLabel cuis = new JLabel(gestore.getArchivioRis().getRistorante(i).getCuisRis());
                titolo.setFont(new Font("Arial", Font.BOLD, 16));

                //Aggiunta dei due label al panel
                panelScritte.add(titolo);
                panelScritte.add(cuis);

                //Inserimento pannello in alto
                pannello.add(panelScritte, BorderLayout.NORTH);

                //Inserimento immagine nel pannello


                JLabel immagine = new JLabel(selezionaImmagine(gestore.getArchivioRis().getRistorante(i).getLocRis()));
                immagine.setPreferredSize(new Dimension(60, 40));
                immagine.setOpaque(true);
                immagine.setBackground(Color.WHITE);
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
    
    public void creaImmagine(){
        ImageIcon flagIT = new ImageIcon("src\\Flag_of_Italy.png");
        Image scaledImageItalia = flagIT.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconItalia = new ImageIcon(scaledImageItalia);
        this.flagItalia = scaledIconItalia; 
        
        ImageIcon flagCN = new ImageIcon("src\\Flag_of_China.png");
        Image scaledImageCina = flagCN.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconCina = new ImageIcon(scaledImageCina);
        this.flagCina = scaledIconCina; 
        
        ImageIcon flagJP = new ImageIcon("src\\Flag_of_Japan.png");
        Image scaledImageGiappone = flagJP.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGiappone = new ImageIcon(scaledImageGiappone);
        this.flagGiappone = scaledIconGiappone; 
        
        ImageIcon flagES = new ImageIcon("src\\Flag_of_Spain.png");
        Image scaledImageSpagna = flagIT.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSpagna = new ImageIcon(scaledImageSpagna);
        this.flagSpagna = scaledIconSpagna; 
        
        ImageIcon flagDE = new ImageIcon("src\\Flag_of_Germany.png");
        Image scaledImageGermania = flagDE.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGermania = new ImageIcon(scaledImageGermania);
        this.flagGermania = scaledIconGermania; 
        
        ImageIcon flagUSA = new ImageIcon("src\\Flag_of_United_States.png");
        Image scaledImageUSA = flagUSA.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconUSA = new ImageIcon(scaledImageUSA);
        this.flagUSA = scaledIconUSA; 
        
        ImageIcon flagFR = new ImageIcon("src\\Flag_of_France.png");
        Image scaledImageFrancia = flagFR.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconFrancia = new ImageIcon(scaledImageFrancia);
        this.flagFrancia = scaledIconFrancia; 
        
        ImageIcon flagWD = new ImageIcon("src\\Globe.png");
        Image scaledImageMondo = flagWD.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconMondo = new ImageIcon(scaledImageMondo);
        this.flagMondo = scaledIconMondo; 
    }
    
    public ImageIcon selezionaImmagine(String nazione){
        if(nazione.contains("Italy"))
            return this.flagItalia;
        
        if(nazione.contains("France"))
            return this.flagFrancia;
        
        if(nazione.contains("Germany"))
            return this.flagGermania;
        
        if(nazione.contains("China"))
            return this.flagCina;
        
        if(nazione.contains("Japan"))
            return this.flagGiappone;
        
        if(nazione.contains("Spain"))
            return this.flagSpagna;
        
        if(nazione.contains("USA"))
            return this.flagUSA;
        
        return this.flagMondo;
    }
    
}
