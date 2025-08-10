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
        gestore.getArchivioPref().leggiArchivio();
        gestore.getArchivioRec().leggiArchivio();
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Caricamento CaricamentoFrame = new Caricamento(gestore);
                CaricamentoFrame.setVisible(true);
                CaricamentoFrame.pack();
                CaricamentoFrame.setLocationRelativeTo(null);
                
                GestoreArchivi.RisListFrame = new RisList(gestore);
                GestoreArchivi.RisListFrame.setVisible(false);
                GestoreArchivi.RisListFrame.pack();
                GestoreArchivi.RisListFrame.setLocationRelativeTo(null);
            }
        });
    }
}






