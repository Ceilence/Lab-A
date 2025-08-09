/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package theknife;

import java.awt.*;



/**
 *
 * @author Alefr
 */
public class TheKnife {

    public static void main(String[] args) {
        GraphicsDevice gd =GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dm = gd.getDisplayMode();
        int dpi = Toolkit.getDefaultToolkit ().getScreenResolution ();
        double scale = dpi / 96.0;
        System.setProperty ("sun.java2d.uiScale", String.valueOf(scale));
        
        GestoreArchivi gestore = new GestoreArchivi();
        
        
        gestore.getArchivioUtenti().leggiArchivio();
        gestore.getArchivioRis().leggiArchivio();
        gestore.getArchivioCitta().leggiArchivio();
        gestore.getArchivioPref().leggiArchivio();
        gestore.getArchivioRec().leggiArchivio();
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            gestore.getArchivioUtenti().aggiornaUtenti();
            gestore.getArchivioRis().aggiornaRis();
        }));
        
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login LoginFrame = new Login(gestore);
                LoginFrame.setVisible(true);
                LoginFrame.pack();
                LoginFrame.setLocationRelativeTo(null);
                
                GestoreArchivi.RisListFrame = new risList(gestore);
                GestoreArchivi.RisListFrame.setVisible(false);
                GestoreArchivi.RisListFrame.pack();
                GestoreArchivi.RisListFrame.setLocationRelativeTo(null);
            }
        });
    }
}






