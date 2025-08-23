/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 *
 * @author davim
 */
public class GeneratorePannelli {
    private final GestoreArchivi gestore;
    
    public GeneratorePannelli(GestoreArchivi gestore) {
        this.gestore = gestore;
    }
    
        public void generaCommenti(JPanel contenitoreCommenti, int conto){
        contenitoreCommenti.removeAll();
        int numero = 0;
        
        for (int i = gestore.getArchivioCommenti().getListaCommenti().size() - 1; i >= 0; i--){
            CommentiRistoranti commento = gestore.getArchivioCommenti().getListaCommenti().get(i);
            if (gestore.getArchivioRis().getRisAttuale().getIdRis() == commento.getIdRistorante() && numero < conto){
                contenitoreCommenti.add(new PannelloRecensioni(gestore, commento));
                if (commento.haRisposta()){
                    contenitoreCommenti.add(new PannelloRisposte(gestore, gestore.getArchivioCommenti().getRisposta(commento)));
                    contenitoreCommenti.add(Box.createRigidArea(new Dimension(0, 10)));
                } else {
                    contenitoreCommenti.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                numero++;
            }
        }
        contenitoreCommenti.revalidate();
        contenitoreCommenti.repaint();
    }
    
}
