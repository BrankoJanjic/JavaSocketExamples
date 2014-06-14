package server.protocolhandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import server.ServerListenhread;
import server.clienthandler.ClientHandler;
import transfer.TOKlijentZahtev;
import transfer.TOServerOdgovor;

/**
 *
 * @author janjic
 */
public class ProtocolHandler {

    private ObjectInputStream in;
    private  ObjectOutputStream out;
    private final SimpleDateFormat hhmm  = new SimpleDateFormat("hh:mm");
   
    private final SimpleDateFormat hhmmss  = new SimpleDateFormat("hh:mm:ss");

   

    public ProtocolHandler(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    
    
    public TOServerOdgovor logUser  (TOKlijentZahtev zahtev){
        TOServerOdgovor o =
                new TOServerOdgovor();
        
                        String hello =
                            (String) zahtev.getParametar();
          o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_OK);
                        o.setPoruka(util.Util.LOGOVAN);
                       
                        ServerListenhread.getServer().getKlijenti().add((ClientHandler) Thread.currentThread());
                    
        return o;
                
    }
    
    
    
    public void proccessRequest(TOKlijentZahtev zahtev) throws IOException, ClassNotFoundException, InterruptedException{
        ClientHandler clientHandler = (ClientHandler) Thread.currentThread();
        int niz[] = (int[]) ServerListenhread.getServer().getServerSesija().get("niz");
        try {
            
            while ((zahtev=(TOKlijentZahtev) in.readObject())!=null) { 
            int zah = zahtev.getZahtev();    
           
            switch (zah){
                
                case util.Util.OPERACIJA_HELO:
                    out.writeObject(logUser(zahtev));
                    break;
                    
                case util.Util.POGADJANJE:
                    int param = (int) zahtev.getParametar();
                    TOServerOdgovor o =
                            new TOServerOdgovor();
                    int brojPogodjenih = clientHandler.getBrojPogodjenih();
                    int brojPromasenih = clientHandler.getBrojPromasenih();
                    boolean pogodjen = false;
                    for (int i : niz) {
                        if (i==param) {
                            pogodjen = true;
                            clientHandler.setBrojPogodjenih(++brojPogodjenih);
                            break;
                        }
                    }
                    
                    if (!pogodjen) {
                        o =
                            new TOServerOdgovor();
                        clientHandler.setBrojPromasenih(++brojPromasenih);
                        o.setPoruka(util.Util.POGADJANJE);
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_NOT_OK);
                        out.writeObject(o);
                        
                    }else{
                        o =
                            new TOServerOdgovor();
                        o.setPoruka(util.Util.POGADJANJE);
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_OK);
                        out.writeObject(o);
                    }
                    int br = clientHandler.getBrPokusaja();
                    clientHandler.setBrPokusaja(++br);
                    
                    if (clientHandler.getBrojPromasenih()==4) {
                        
                        ServerListenhread.getServer().getKlijenti().remove((ClientHandler) Thread.currentThread()); 
            
                       clientHandler.getSocket().close();
   
                       System.out.println("Izbacio");
       
                       Thread.currentThread().interrupt();
                    }
                    
                    if (clientHandler.getBrojPogodjenih()==4) {
                        
                        o =
                            new TOServerOdgovor();
                        o.setPoruka(util.Util.GAME_OVER);
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_OK);
                        out.writeObject(o);
                        
                       ServerListenhread.getServer().getKlijenti().remove((ClientHandler) Thread.currentThread()); 
            
                       clientHandler.getSocket().close();
   
                       System.out.println("Izbacio");
       
                       Thread.currentThread().interrupt();
                    }
                    break;


                default:
                    break;
            }
                    
            }
            
        } 
        //klijent izlazi
        catch (SocketException e) {
            ServerListenhread.getServer().getKlijenti().remove((ClientHandler) Thread.currentThread()); 
            
            if (ServerListenhread.getServer().getServerSesija().get(Thread.currentThread().getName())!=null) {
                int broj = (int) ServerListenhread.getServer().getServerSesija().get(Thread.currentThread().getName());
                
                if (broj>0) {
                    ServerListenhread.getServer().getServerSesija().put(Thread.currentThread().getName(), --broj);
                }
                
              
            System.out.println("Izbacio");
       
            Thread.currentThread().interrupt();
        }
   
        }
    }
    
    
 
}

