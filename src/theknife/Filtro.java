/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Alefr
 */
public class Filtro extends JDialog{
    private GestoreArchivi gestore;
    private RisList risList;
    private JComboBox<String> stato;
    private JComboBox<String> citta;
    private JComboBox<String> tipoCucina;
    private JTextField distanza;
    private JCheckBox[] mediaStelle;
    private JCheckBox[] fasciaPrezzo;
    private JCheckBox deliverySi, deliveryNo;
    private JCheckBox prenotazioneSi, prenotazioneNo;
    private JButton applicaFiltri;
    private final ArrayList<Ristorante> r = new ArrayList<>();
    
    public Filtro(GestoreArchivi gestore, RisList risList){
        this.gestore = gestore;
        this.risList = risList;
        
        
        JPanel pannelloFiltri = new JPanel();
        distanza = new JTextField();
        pannelloFiltri.setLayout(new BoxLayout(pannelloFiltri, BoxLayout.Y_AXIS));
        
        JLabel titolo = new JLabel("Pannello filtri");
        titolo.setFont(new Font("Arial", Font.BOLD, 24));
        titolo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        
        JButton indietro = new JButton("X");
        indietro.addActionListener(e -> {
            risList.setPreferitoVisualizzato();
            risList.aggiornaDetPref();
            risList.setEnabled(true);
            setVisible(false);
            risList.setVisible(true);
        });

        JPanel pannelloTitolo = new JPanel();
        pannelloTitolo.setLayout(new BoxLayout(pannelloTitolo, BoxLayout.X_AXIS));
        pannelloTitolo.add(titolo);
        pannelloTitolo.add(Box.createHorizontalGlue());
        pannelloTitolo.add(indietro);
        pannelloTitolo.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloTitolo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        pannelloFiltri.add(pannelloTitolo);
        
        stato = new JComboBox<>(new String[] {"","Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam"});
        citta= new JComboBox<>(new String[] {""});
        tipoCucina = new JComboBox<>(new String[]{""});
        JLabel labelStato = new JLabel("Stato: ");
        labelStato.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelStato.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelStato);
        stato.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloFiltri.add(stato);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        JLabel labelCitta = new JLabel("Città: ");
        labelCitta.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelCitta.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelCitta);
        citta.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloFiltri.add(citta);
        citta.setEnabled(false);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        stato.addActionListener(e -> {
            String statoSelezionato = (String) stato.getSelectedItem();
            if(statoSelezionato != null && !statoSelezionato.isEmpty()) {
                Set<String> c = new TreeSet<>();
                for(Ristorante r : gestore.getArchivioRis().getRis()) {
                    if(r.getStatoRis().equals(statoSelezionato)) {
                        c.add(r.getLocRis());
                    }
                }

                citta.removeAllItems();
                for(String cittaDiStato : c) {
                    citta.addItem(cittaDiStato);
                }
                citta.setSelectedIndex(-1);
                citta.setEnabled(true);
            }else {
                citta.removeAllItems();
                citta.setEnabled(false);
            }
        });
        
        /*JLabel labelDistanza2 = new JLabel("Distanza massima dalla città selezionata (km):");
        labelDistanza2.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelDistanza2.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelDistanza2);
        distanzaFiltro.setAlignmentX(Component.LEFT_ALIGNMENT);
        distanzaFiltro.setBackground(new Color(153,153,153));
        pannelloFiltri.add(distanzaFiltro);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        
        citta.addActionListener(e -> {
            Object scelta = citta.getSelectedItem();
            if(scelta != null && !scelta.toString().trim().isEmpty()) {
                distanzaFiltro.setEditable(true);
                distanzaFiltro.setBackground(Color.WHITE);
            }else {
                distanzaFiltro.setEditable(false);
                distanzaFiltro.setBackground(new Color(153, 153, 153));
                distanzaFiltro.setText("");
            }
        });
        */
        
        JLabel labelDistanza = new JLabel("Distanza massima dalla tua città(km):");
        labelDistanza.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelDistanza.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelDistanza);
        distanza.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloFiltri.add(distanza);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        JLabel labelCucina = new JLabel("Tipo di cucina:");
        labelCucina.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelCucina.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelCucina);
        tipoCucina.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloFiltri.add(tipoCucina);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        JLabel labelStelle = new JLabel("Media stelle:");
        labelStelle.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelStelle.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelStelle);
        mediaStelle = new JCheckBox[5];
        mediaStelle[0] = new JCheckBox("1 stella");
        mediaStelle[1] = new JCheckBox("2 stelle");
        mediaStelle[2] = new JCheckBox("3 stelle");
        mediaStelle[3] = new JCheckBox("4 stelle");
        mediaStelle[4] = new JCheckBox("5 stelle");
        for (JCheckBox s : mediaStelle) s.setAlignmentX(Component.LEFT_ALIGNMENT);
        for (JCheckBox s : mediaStelle) pannelloFiltri.add(s);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        JLabel labelPrezzo = new JLabel("Fascia di prezzo:");
        labelPrezzo.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPrezzo.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelPrezzo);
        fasciaPrezzo = new JCheckBox[4];
        fasciaPrezzo[0] = new JCheckBox("€");
        fasciaPrezzo[1] = new JCheckBox("€€");
        fasciaPrezzo[2] = new JCheckBox("€€€");
        fasciaPrezzo[3] = new JCheckBox("€€€€");
        for (JCheckBox c : fasciaPrezzo) c.setAlignmentX(Component.LEFT_ALIGNMENT);
        for (JCheckBox c : fasciaPrezzo) pannelloFiltri.add(c);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        JLabel labelDelivery = new JLabel("Servizio delivery:");
        labelDelivery.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelDelivery.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelDelivery);
        deliverySi = new JCheckBox("Sì");
        deliveryNo = new JCheckBox("No");
        deliverySi.setAlignmentX(Component.LEFT_ALIGNMENT);
        deliveryNo.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloFiltri.add(deliverySi);
        pannelloFiltri.add(deliveryNo);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        JLabel labelPrenotazione = new JLabel("Servizio di prenotazione:");
        labelPrenotazione.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPrenotazione.setFont(new Font("Arial", Font.BOLD, 18));
        pannelloFiltri.add(labelPrenotazione);
        prenotazioneSi = new JCheckBox("Sì");
        prenotazioneNo = new JCheckBox("No");
        prenotazioneSi.setAlignmentX(Component.LEFT_ALIGNMENT);
        prenotazioneNo.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloFiltri.add(prenotazioneSi);
        pannelloFiltri.add(prenotazioneNo);
        pannelloFiltri.add(Box.createVerticalStrut(15));
        
        applicaFiltri = new JButton("Applica filtri");
        applicaFiltri.setBackground(new Color(0,102,102));
        applicaFiltri.setForeground(Color.WHITE);
        pannelloFiltri.add(applicaFiltri);
        
        JScrollPane filtri = new JScrollPane(pannelloFiltri);
        add(filtri);
        filtri.getVerticalScrollBar().setUnitIncrement(15);
        
        
        stato.setSelectedIndex(-1);
        
        applicaFiltri.addActionListener(e -> { 
        });
        
        setUndecorated(true);
        setPreferredSize(new Dimension(500, 500));
        pannelloFiltri.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        filtri.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pack();
        setLocationRelativeTo(null);
    }
    
    public ArrayList<PannelloRis> filtra(ArrayList<PannelloRis> tuttiIPannelli){
        ArrayList<PannelloRis> filtrati = new ArrayList<>();
        Citta cittaUtente = gestore.getArchivioCitta().getCitta(gestore.getArchivioUtenti().getUtenteAttuale().getPosizioneUtente());
        Citta cittaFiltrata = gestore.getArchivioCitta().getCitta(gestore.getArchivioUtenti().getUtenteAttuale().getPosizioneUtente());
        if(citta.getSelectedItem() != null){
            cittaFiltrata = gestore.getArchivioCitta().getCitta((String) citta.getSelectedItem());
        }
        
        String cittaScelta = (String) citta.getSelectedItem();
        String statoScelto = (String) stato.getSelectedItem();
        Double distanzaMax = 0.0;
        Double distanzaMax2 = 0.0;
        
        Boolean delivery = null;
        if(deliverySi.isSelected()){
            delivery = true;
        }
        else if(deliveryNo.isSelected()){
            delivery = false;
        }
        
        Boolean prenotazione = null;
        if(prenotazioneSi.isSelected()){
            prenotazione = true;
        }
        else if(prenotazioneNo.isSelected()){
            prenotazione = false;
        }
        
        if(!distanza.getText().trim().isEmpty()) {
            distanzaMax = Double.parseDouble(distanza.getText().trim());
        }
        
       /* if(!distanzaFiltro.getText().trim().isEmpty()){
            distanzaMax2 = Double.parseDouble(distanzaFiltro.getText().trim());
        }*/
        
        ArrayList<Integer> stelleSelezionate = new ArrayList<>();
        for(int i = 0; i < mediaStelle.length; i++) {
            if(mediaStelle[i].isSelected()) {
                stelleSelezionate.add(i + 1);
            }
        }
        
        ArrayList<Integer> fasciaPrezzoSelezionata = new ArrayList<>();
        for(int i = 0; i < fasciaPrezzo.length; i++) {
            if(fasciaPrezzo[i].isSelected()) {
                fasciaPrezzoSelezionata.add(i + 1);
            }
        }   
        
        for(PannelloRis p : tuttiIPannelli){
            Ristorante r = p.getRistorante();
            
            if(delivery != null && r.isDelivery() != delivery) {
                continue;
            }
            
            if(prenotazione != null && r.isPrenotaOnline() != prenotazione) {
                continue;
            }
            
            if(statoScelto != null && !statoScelto.isEmpty() && !r.getStatoRis().equals(statoScelto)){
            continue;
            }
            
            if(cittaScelta != null && !cittaScelta.isEmpty() && !r.getLocRis().equals(cittaScelta)){
            continue;
            }
            
            /*if(distanzaMax2 != null && distanzaMax2 > 0) {
                if(cittaFiltrata != null) {
                    double distanzaKm2 = gestore.getArchivioCitta().calcolaDistanza(cittaFiltrata.getLatCitta(), cittaFiltrata.getLonCitta(), r.getLatRis(), r.getLongRis());
                    if(distanzaKm2 > distanzaMax2) {
                        continue;
                    }
                }
            }*/
            
            if(distanzaMax != null && distanzaMax > 0) {
                if(cittaUtente != null) {
                    double distanzaKm = gestore.getArchivioCitta().calcolaDistanza(cittaUtente.getLatCitta(), cittaUtente.getLonCitta(), r.getLatRis(), r.getLongRis());
                    if(distanzaKm > distanzaMax) {
                        continue;
                    }
                }
            }
            
            if(!stelleSelezionate.isEmpty()) {
                int media = (int) r.getMediaStelleRis();
                if(!stelleSelezionate.contains(media)) {
                    continue;
                }
            }
            
            if(!fasciaPrezzoSelezionata.isEmpty()){
                int fascia = r.getPriceRis().trim().length();
                if(!fasciaPrezzoSelezionata.contains(fascia)){
                    continue;
                }
            }
            
            filtrati.add(p);
        }
        return filtrati;
    }
    
    public JButton getApplicaFiltri(){
        return applicaFiltri;
    }
}
