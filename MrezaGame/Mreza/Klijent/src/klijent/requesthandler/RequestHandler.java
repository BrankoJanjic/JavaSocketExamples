
package klijent.requesthandler;

import klijent.session.Sesija;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import klijent.responsehandler.AsyncResponseHandler;
import transfer.TOKlijentZahtev;

public class RequestHandler {
    
    Socket ksoket;
    ObjectOutputStream out;
    ObjectInputStream in;
    private boolean pogodio;

    public void setPogodio(boolean pogodio) {
        this.pogodio = pogodio;
    }

    
    
    public Socket getKsoket() {
        return ksoket;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public ObjectInputStream getIn() {
        return in;
    }
    
    


    public void poveziSeSaServerom(String ip, int port) throws IOException {
         ksoket = new Socket(ip, port);
         out = new ObjectOutputStream(ksoket.getOutputStream());
         in = new ObjectInputStream(ksoket.getInputStream());
         Sesija.getSesija().getMapa().put("klijent", this);
         pogodio=false;
        
    }
    
    public void pocetnaKomunikacija(String s) throws UnknownHostException, IOException, ClassNotFoundException{
        
        TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
        //predstavi se
        klijentZahtev.setZahtev(util.Util.OPERACIJA_HELO);
        klijentZahtev.setParametar(s);
        out.writeObject(klijentZahtev);
        new AsyncResponseHandler(in).start();
        
    }

    public boolean isPogodio() {
        return pogodio;
    }
    
    public void pogodi (int i) throws IOException, ClassNotFoundException{
        
        TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
        klijentZahtev.setZahtev(util.Util.POGADJANJE);
        klijentZahtev.setParametar(i);
        out.writeObject(klijentZahtev);
        
    }
    
   

    
    
    
   
}
