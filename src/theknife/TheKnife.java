/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package theknife;



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
            }
        });
    }
}






