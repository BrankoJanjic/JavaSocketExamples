/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package klijent.protocolhandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import klijent.requesthandler.RequestHandler;
import klijent.session.Sesija;
import transfer.TOServerOdgovor;

/**
 *
 * @author janjic
 */
public class ProtocolHandler {
    
    public void proccessResponse(TOServerOdgovor tOServerOdgovor,ObjectInputStream inputStream) throws IOException, ClassNotFoundException{
        RequestHandler k = (RequestHandler) Sesija.getSesija().getMapa().get("klijent");
        try {
            while ((tOServerOdgovor = ((TOServerOdgovor)inputStream.readObject()))!=null) {
                int poruka = tOServerOdgovor.getPoruka();
                int status = tOServerOdgovor.getStatusIzvrsenjaOperacije();
                switch (poruka){
                    
                    case util.Util.LOGOVAN:
                        if (status== util.Util.STATUS_IZVRSENJA_OPERACIJE_OK) {
                            k.setPogodio(true);
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            JOptionPane.showMessageDialog(null, "Logovani ste");
                            break;
                            
                        }
                        else{
                            k.setPogodio(false);
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            break;
                        }
                    
                    case util.Util.POGADJANJE:
                        
                        if (status== util.Util.STATUS_IZVRSENJA_OPERACIJE_OK) {
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            k.setPogodio(true);

                           JOptionPane.showMessageDialog(null, "Pogodili ste");
                            break;
                            
                        }
                        else{
                            Sesija.getSesija().getMapa().put("pristupio", false);
                            k.setPogodio(false);
                            break;
                        }
                    
                    case util.Util.GAME_OVER:
                        JLabel jLabel=
                                (JLabel) Sesija.getSesija().getMapa().get("labela");
                        jLabel.setVisible(true);

                    default:
                        break;
                }
                
            }
        } catch (Exception  ex) {           
            throw ex;
        }
        
    }
    
}
