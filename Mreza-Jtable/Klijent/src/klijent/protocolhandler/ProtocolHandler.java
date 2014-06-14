/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package klijent.protocolhandler;

import java.io.IOException;
import java.io.ObjectInputStream;
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
                            k.setLogavan(true);
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            JOptionPane.showMessageDialog(null, "Logovani ste");
                            break;
                            
                        }
                        else{
                            k.setLogavan(false);
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            break;
                        }
                    case util.Util.NE_POSTOJI_IME:
                        k.setLogavan(false);
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            JOptionPane.showMessageDialog(null, "Ne postoji ime");
                        break;
                        
                   
                    case util.Util.POSTOJE_DVA:
                            k.setLogavan(false);
                            Sesija.getSesija().getMapa().put("pristupio", true);
                            JOptionPane.showMessageDialog(null, "Dva korisnika sa tim imenom su vec logovana !");
                        break;
                    
                    case util.Util.IZBACIO:
                        if (tOServerOdgovor.getStatusIzvrsenjaOperacije()== util.Util.STATUS_IZVRSENJA_OPERACIJE_OK) {
                            tOServerOdgovor = ((TOServerOdgovor)inputStream.readObject());
                            JTextField field=
                                    (JTextField) Sesija.getSesija().getMapa().get("status");
                            field.setText((String)tOServerOdgovor.getRezultat());
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Niste izbacili");
                            break;
                        }
                    
                    default:
                        break;
                }
                
            }
        } catch (Exception  ex) {           
            throw ex;
        }
        
    }
    
}
