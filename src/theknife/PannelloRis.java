/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package theknife;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author SSSSUGOI
 */
public final class PannelloRis extends JPanel{
    private GestoreArchivi gestore;
    private RisList rislist;
    private ImageIcon prefAdd;
    private ImageIcon prefRem;
    private ImageIcon flagItalia;
    private ImageIcon flagCina;
    private ImageIcon flagFrancia;
    private ImageIcon flagGermania;
    private ImageIcon flagSpagna;
    private ImageIcon flagUSA;
    private ImageIcon flagGiappone;
    private ImageIcon flagMondo;
    
    public PannelloRis(RisList risList, JScrollPane scrollPane, GestoreArchivi gestore, JPanel dettaglioPanel, JLabel dettaglioNome, JLabel dettaglioCucina, JLabel dettaglioImmagine, JLabel labelDescrizione, JButton detPref, Caricamento caricamentoFrame) {
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
       
        SwingWorker<Void, JPanel> worker = new SwingWorker<>(){
            @Override
            protected Void doInBackground() throws Exception {
                int loading = 0;
                for (Ristorante r : gestore.getArchivioRis().getRis()) {
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

                    JLabel titolo = new JLabel(r.getNomeRis());
                    titolo.setFont(new Font("Arial", Font.BOLD, 16));

                    JLabel cuis = new JLabel(r.getCuisRis());
                    titolo.setFont(new Font("Arial", Font.BOLD, 16));

                    //Aggiunta dei due label al panel
                    panelScritte.add(titolo);
                    panelScritte.add(cuis);

                    //Inserimento pannello in alto
                    pannello.add(panelScritte, BorderLayout.NORTH);

                    //Inserimento immagine nel pannello


                    JLabel immagine = new JLabel((selezionaImmagine(r.getLocRis())));
                    immagine.setPreferredSize(new Dimension(60, 40));
                    immagine.setOpaque(true);
                    immagine.setBackground(Color.WHITE);
                    immagine.setHorizontalAlignment(SwingConstants.CENTER);
                    pannello.add(immagine, BorderLayout.WEST);

                    pannello.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            gestore.getArchivioRis().setRisAttuale(r);
                            dettaglioNome.setText(r.getNomeRis());
                            dettaglioCucina.setText(r.getCuisRis());
                            labelDescrizione.setText("<html><p style='width:635px'>" + r.getDesRis() + "</p></html>");
                            dettaglioImmagine.setIcon(selezionaImmagine(r.getLocRis()));
                            
                            /**
                             * Cambia i valori del prpeferito attuale a quelli del ristorante cliccato e dell'utente attuale.
                             * Verifica se è già tra i preferiti e imposta l'icona del JButton detPref.
                            */
                            gestore.getArchivioPref().setPrefAttuale(r.getIdRis(), gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente());
                            risList.aggiornaDetPref();
                            
                            dettaglioPanel.revalidate();
                            dettaglioPanel.repaint();
                        }
                    });
                    
                        //Il pannello del ristorante viene aggiunto a quello principale
                        add(pannello);
                        //Crea uno spazio tra un pannello e l'altro
                        add(Box.createRigidArea(new Dimension(0, 10)));
                        
                        caricamentoFrame.aggiornaProgress(loading++);
                    }
                return null;
        }
        };
        
        worker.execute();
        
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
        ImageIcon paIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Aggiungi.png"));
        Image pa1 = paIcon.getImage();
        Image pa2 = pa1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon pa3 = new ImageIcon(pa2);
        this.prefAdd = pa3;
        
        ImageIcon ptIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\pref_Togli.png"));
        Image pt1 = ptIcon.getImage();
        Image pt2 = pt1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon pt3 = new ImageIcon(pt2);
        this.prefRem = pt3;
        
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
    
    public int getNumeroPannelli(){
        return gestore.getArchivioRis().getNumeroRis();
    }
}
