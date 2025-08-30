/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como@author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.grafica;

import theknife.gestori.GestoreArchivi;
import theknife.essenziali.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;


/**
 * Finestra di dialogo per la selezione dei filtri dei ristoranti.
 * <p>
 * Permette di filtrare i ristoranti in base a vari criteri come stato, città, distanza massima dalla città selezionata, tipo di cucina, 
 * media stelle, fascia di prezzo, servizio delivery e servizio di prenotazione.
 * </p>
 * <p>
 * I filtri vengono applicati sulla lista di {@link PannelloRistorante} passata al costruttore.
 * </p>
 * 
 * @see RisList
 * @see PannelloRistorante
 * @see GestoreArchivi
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class Filtro extends JDialog{
    
    /** Gestore degli archivi dei dati (ristoranti, utenti, preferiti). {@code gestore}*/
    private final GestoreArchivi gestore;
    
    /** ComboBox per la selezione dello stato del ristorante. {@code stato}
     */
    private JComboBox<String> stato;
    
    /** ComboBox per la selezione della città del ristorante. {@code citta}
     */
    private JComboBox<String> citta;
    
    /** ComboBox per la selezione del tipo di cucina del ristorante. {@code tipoCucina}
    */
    private final JComboBox<String> tipoCucina;
    
    /** Campo di testo per inserire la distanza massima dalla città. {@code distanza}
    */
    private JTextField distanza;
    
    /** Array di JCheckBox per selezionare la media stelle del ristorante (da 1 a 5). {@code mediaStelle}
     */
    private final JCheckBox[] mediaStelle;
    
    /** Array di JCheckBox per selezionare la fascia di prezzo del ristorante (€ - €€€€). {@code fasciaPrezzo}
     */
    private final JCheckBox[] fasciaPrezzo;
    
    /** JCheckBox per il filtro del servizio delivery: sì/no. {@code deliverySi} {@code deliveryNo}
     */
    private final JCheckBox deliverySi, deliveryNo;
    
    /** JCheckBox per il filtro della prenotazione: sì/no. {@code prenotazioneSi} {@code prenotazioneNo}
     */
    private final JCheckBox prenotazioneSi, prenotazioneNo;
    
    /**
     * Costruisce il pannello filtri per i ristoranti.
     * <p>
     * Imposta tutti i componenti grafici, le JComboBox, i JTextField e le JCheckBox, e gestisce gli eventi per l'aggiornamento della città 
     * in base allo stato selezionato e l'abilitazione del campo distanza.
     * </p>
     * 
     * @param gestore istanza di {@link GestoreArchivi} contenente i dati di ristoranti e utenti
     * @param risList riferimento alla finestra principale {@link RisList} per aggiornare la lista filtrata
     * @param tuttiIPannelli lista di {@link PannelloRistorante} da filtrare
     */
    public Filtro(GestoreArchivi gestore, RisList risList, ArrayList<PannelloRistorante> tuttiIPannelli){
        this.gestore = gestore;
        
        JPanel pannelloFiltri = new JPanel();
        distanza = new JTextField();
        pannelloFiltri.setLayout(new BoxLayout(pannelloFiltri, BoxLayout.Y_AXIS));
        
        JLabel titolo = new JLabel("Pannello filtri");
        titolo.setFont(new Font("Arial", Font.BOLD, 24));
        titolo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        
        JButton indietro = new JButton("X");
        indietro.addActionListener(e -> {
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
        tipoCucina = new JComboBox<>(new String[]{"", "Afghan", "African", "Alpine", "Alsatian", "American", "American Contemporary", "Andalusian", "Apulian", "Argentinian", "Asian", "Asian Contemporary", "Asian Influences", "Asian and Western", "Asturian", "Australian Contemporary", "Austrian", "Balkan", "Barbecue", "Basque", "Beef", "Beijing Cuisine", "Belgian", "Brazilian", "Breton", "British Contemporary", "Bulgogi", "Burgundian", "Burmese", "Californian", "Cambodian", "Campanian", "Cantonese", "Cantonese Roast Meats", "Caribbean", "Castilian", "Catalan", "Central Asian", "Chao Zhou", "Chicken Specialities", "Chinese", "Chinese Contemporary", "Chueotang", "Classic Cuisine", "Classic French", "Colombian", "Contemporary", "Corsican", "Country cooking", "Crab Specialities", "Creative", "Creative British", "Creative French", "Croatian", "Cuban", "Cuisine from Abruzzo", "Cuisine from Basilicata", "Cuisine from Lazio", "Cuisine from Romagna", "Cuisine from South West France", "Cuisine from Valtellina", "Czech", "Danish", "Deli", "Dim Sum", "Duck Specialities", "Dumplings", "Dwaeji-gukbap", "Eastern European", "Emilian", "Emirati Cuisine", "English", "Ethiopian", "European", "European Contemporary", "Farm to table", "Filipino", "Finnish", "Flemish", "French", "French Contemporary", "Fugu / Pufferfish", "Fujian", "Fusion", "Galician", "Gastropub", "Gejang", "German", "Greek", "Grills", "Hainanese", "Hakkanese", "Hang Zhou", "Home Cooking", "Hotpot", "Huaiyang", "Hubei", "Hui Cuisine", "Hunanese", "Hungarian", "Indian", "Indian Vegetarian", "Indonesian", "Innovative", "International", "Irish", "Isan", "Israeli", "Italian", "Italian Contemporary", "Italian and Japanese", "Italian-American", "Izakaya", "Jamaican", "Japanese", "Japanese Contemporary", "Japanese Steakhouse", "Jiangzhe", "Jokbal", "Korean", "Korean Contemporary", "Kushiage", "Lao", "Latin American", "Lebanese", "Ligurian", "Lombardian", "Lyonnaise", "Macanese", "Malaysian", "Mandu", "Meats and Grills", "Meats and Seafood", "Mediterranean Cuisine", "Memil-guksu", "Mexican", "Middle Eastern", "Modern British", "Modern Cuisine", "Modern French", "Moroccan", "Naengmyeon", "Ningbo", "Noodles", "Noodles and Congee", "Northern Thai", "Norwegian", "Obanzai", "Oden", "Onigiri", "Organic", "Peranakan", "Persian", "Peruvian", "Piedmontese", "Pizza", "Pork", "Portuguese", "Proven al", "Puerto Rican", "Ramen", "Regional Cuisine", "Regional European", "Rice Dishes", "Roman", "Russian", "Sardinian", "Savoyard", "Scandinavian", "Seafood", "Seasonal Cuisine", "Seolleongtang", "Shandong", "Shanghainese", "Sharing", "Shojin", "Shun Tak", "Sichuan", "Sicilian", "Singaporean", "Small eats", "Sm rrebr d", "Soba", "South African", "South American", "South East Asian", "Southern", "Southern Thai", "Spanish", "Spanish Contemporary", "Sri Lankan", "Steakhouse", "Street Food", "Sushi", "Swedish", "Swiss", "Taiwanese", "Taiwanese contemporary", "Taizhou", "Tempura", "Teochew", "Teppanyaki", "Tex-Mex", "Thai", "Thai contemporary", "Thai-Chinese", "Tonkatsu", "Traditional British", "Traditional Cuisine", "Turkish", "Tuscan", "Udon", "Unagi / Freshwater Eel", "Vegan", "Vegetarian", "Venetian", "Vietnamese", "Vietnamese Contemporary", "World Cuisine", "Yakitori", "Yoshoku", "Zhejiang"});
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
        citta.setEnabled(false);
        pannelloFiltri.add(citta);
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
                citta.addItem("");
                for(String cittaDiStato : c) {
                    citta.addItem(cittaDiStato);
                }
                citta.setSelectedIndex(-1);
                citta.setEnabled(true);
            } else if(statoSelezionato == null || statoSelezionato.isEmpty()){
                citta.removeAllItems();
                citta.addItem("");
                citta.setSelectedItem("");
                citta.setEnabled(false);
                distanza.setEditable(false);
                distanza.setBackground(new Color(204,204,204));
            }
        });
        
        citta.addActionListener(e -> {
            String cittaSelezionata = (String) citta.getSelectedItem();
            if(cittaSelezionata == null || cittaSelezionata.isEmpty()){
                distanza.setEditable(false);
                distanza.setBackground(new Color(204,204,204));
                distanza.setText("");
            }else{
                distanza.setEditable(true);
                distanza.setBackground(Color.WHITE);
            }
        });
        
        JLabel labelDistanza = new JLabel("Distanza massima dalla città(km):");
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
        
        JButton applicaFiltri = new JButton("Applica filtri");
        applicaFiltri.setBackground(new Color(0,102,102));
        applicaFiltri.setForeground(Color.WHITE);
        pannelloFiltri.add(applicaFiltri);
        
        JScrollPane filtri = new JScrollPane(pannelloFiltri);
        add(filtri);
        filtri.getVerticalScrollBar().setUnitIncrement(15);
        
        
        stato.setSelectedIndex(-1);
        
        applicaFiltri.addActionListener(e -> {
            filtri.getVerticalScrollBar().setValue(0);
            risList.applicaFiltri();        
        });
        
        getRootPane().setDefaultButton(applicaFiltri);
        
        setUndecorated(true);
        setPreferredSize(new Dimension(500, 500));
        pannelloFiltri.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        filtri.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Applica i filtri selezionati dall'utente sulla lista di {@link PannelloRistorante}.
     * <p>
     * Filtra in base a: stato, città, distanza massima dalla città, tipo di cucina, media stelle, fascia di prezzo, servizio delivery e 
     * servizio di prenotazione.
     * </p>
     * <p>
     * I pannelli che soddisfano tutti i criteri vengono aggiunti alla lista pannelliFiltrati.
     * </p>
     * 
     * @param tuttiIPannelli la lista completa di {@link PannelloRistorante} su cui applicare i filtri
     * @param pannelliFiltrati la lista che verrà popolata con i pannelli filtrati
     * 
     * @see PannelloRistorante
     * @see Ristorante
     */
    public void filtra(ArrayList<PannelloRistorante> tuttiIPannelli, ArrayList<PannelloRistorante> pannelliFiltrati){
        Citta cittaFiltrata = gestore.getArchivioCitta().getCitta(gestore.getArchivioUtenti().getUtenteAttuale().getPosizioneUtente());
        
        if (citta.getSelectedItem() != null) {
            cittaFiltrata = gestore.getArchivioCitta().getCitta((String) citta.getSelectedItem());
        }
        
        String cittaScelta = (String) citta.getSelectedItem();
        String statoScelto = (String) stato.getSelectedItem();
        String cucinaScelta = (String) tipoCucina.getSelectedItem();
        Double distanzaMax = 0.0;
        
        
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
        
        for(PannelloRistorante p : tuttiIPannelli){
            Ristorante r = p.getRistorante();
            
            if(delivery != null && r.isDelivery() != delivery) {
                continue;
            }
            
            if(prenotazione != null && r.isPrenotaOnline() != prenotazione) {
                continue;
            }
            
            if(cucinaScelta != null && !cucinaScelta.isEmpty() && !r.getCuisRis().equals(cucinaScelta)){
                continue;
            }
            
            if(distanzaMax != null && distanzaMax > 0) {
                if(cittaFiltrata != null) {
                    double distanzaKm = gestore.getArchivioCitta().calcolaDistanza(cittaFiltrata.getLatCitta(), cittaFiltrata.getLonCitta(), r.getLatRis(), r.getLongRis());
                    cittaScelta = null;
                    statoScelto = null;
                    if(distanzaKm > distanzaMax) {
                        continue;
                    }
                }
            }
            
            if(statoScelto != null && !statoScelto.isEmpty() && !r.getStatoRis().equals(statoScelto)){
                continue;
            }
            
            if(cittaScelta != null && !cittaScelta.isEmpty() && !r.getLocRis().equals(cittaScelta)){
                continue;
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
            
            pannelliFiltrati.add(p);
        }
    }
    
    /**
     * Restituisce la JComboBox che contiene gli stati disponibili per il filtro.
     * 
     * @return la JComboBox stato
     */
    public JComboBox getStato(){
        return stato;
    }
    
    /**
     * Restituisce la JComboBox che contiene le città disponibili per il filtro.
     * 
     * @return la JComboBox citta
     */
    public JComboBox getCitta(){
        return citta;
    }
}
