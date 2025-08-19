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
        GestoreArchivi gestore = new GestoreArchivi();
        
        
        gestore.getArchivioUtenti().leggiArchivio();
        gestore.getArchivioRis().leggiArchivio();
        gestore.getArchivioCitta().leggiArchivio();
        gestore.getArchivioPreferiti().leggiArchivio();
        gestore.getArchivioCommenti().leggiArchivio();       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestoreArchivi.RisListFrame = new RisList(gestore);
                GestoreArchivi.RisListFrame.setVisible(false);
                GestoreArchivi.RisListFrame.pack();
                GestoreArchivi.RisListFrame.setLocationRelativeTo(null);
            }
        });
    }
}






