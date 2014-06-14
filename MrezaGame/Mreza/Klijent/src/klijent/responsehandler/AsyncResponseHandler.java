
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
        
        TOServerOdgovor tOServerOdgovor = null;
        
        ProtocolHandler handler = new ProtocolHandler();
        
        try {
            handler.proccessResponse(tOServerOdgovor, inputStream);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Igra je zavrsena. Pokrenite program za novu partiju!");
            System.exit(0);
            
           
            
        }
        
    }
    
    
    
}
