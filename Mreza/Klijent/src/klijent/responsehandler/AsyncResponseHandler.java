
package klijent.responsehandler;

import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import klijent.requesthandler.RequestHandler;
import klijent.session.Sesija;
import klijent.protocolhandler.ProtocolHandler;
import transfer.TOServerOdgovor;


public class AsyncResponseHandler extends Thread{

    ObjectInputStream inputStream;

    public AsyncResponseHandler(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }
    @Override
    public void run() {
        
        RequestHandler k = (RequestHandler) Sesija.getSesija().getMapa().get("klijent");
        TOServerOdgovor tOServerOdgovor = null;
        
        ProtocolHandler handler = new ProtocolHandler();
        
        try {
            handler.proccessResponse(tOServerOdgovor, inputStream);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Izbaceni ste");
            System.exit(0);
            
           
            
        }
        
    }
    
    
    
}
