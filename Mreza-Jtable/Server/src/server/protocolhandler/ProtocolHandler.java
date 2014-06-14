package server.protocolhandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
        
          String user =
                            (String) zahtev.getParametar();
                    
                    if ( ServerListenhread.getServer().getServerSesija().get(user)!=null) {
                        int brojUlogovan =
                            (int) ServerListenhread.getServer().getServerSesija().get(user);
                        System.out.println("Trenutno korisnika sa imenom "+user+" ima : "+brojUlogovan);
                    if (brojUlogovan<2) {
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_OK);
                        o.setPoruka(util.Util.LOGOVAN);
                        ServerListenhread.getServer().getServerSesija().put(user, ++brojUlogovan);
                        Thread.currentThread().setName(user);
                       
                        ServerListenhread.getServer().getKlijenti().add((ClientHandler) Thread.currentThread());
                        
                        if (ServerListenhread.getServer().getKlijenti().size()==1 && ServerListenhread.getServer().getServerSesija().get("prvi")==null) {
                            JLabel label =
                                    (JLabel) ServerListenhread.getServer().getServerSesija().get("labelaprvi");
                            label.setVisible(true);
                            JLabel labeltime =
                                    (JLabel) ServerListenhread.getServer().getServerSesija().get("labelaprvi_time");
                            labeltime.setVisible(true);
                            labeltime.setText(hhmmss.format(Calendar.getInstance().getTime()));
                            ServerListenhread.getServer().getServerSesija().put("prvi", true);
                            ((JButton)ServerListenhread.getServer().getServerSesija().get("btn")).setEnabled(true);
                        }
                        
                        JLabel label =
                                    (JLabel) ServerListenhread.getServer().getServerSesija().get("labelaposlednji");
                            label.setVisible(true);
                            JLabel labeltime =
                                    (JLabel) ServerListenhread.getServer().getServerSesija().get("labelaposlednji_time");
                            labeltime.setVisible(true);
                            labeltime.setText(hhmmss.format(Calendar.getInstance().getTime()));
                        
                        
                        
                        
                        
                    }else{
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_NOT_OK);
                        o.setPoruka(util.Util.POSTOJE_DVA);
                        System.out.println("Izbacio");
                        Thread.currentThread().interrupt();
  
                    }
                    }else{
                      
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_NOT_OK);
                        o.setPoruka(util.Util.NE_POSTOJI_IME);
                        System.out.println("Izbacio");
                        Thread.currentThread().interrupt();
                    
                    }
        return o;
                
    }
    
    private void remove(TOKlijentZahtev zahtev) throws IOException{
        TOServerOdgovor o =
                new TOServerOdgovor();
        try {
                        int index = (int) zahtev.getParametar();
                        ServerListenhread.getServer().izbaciSaPozicije(index);
                        o = new TOServerOdgovor();
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_OK);
                        o.setPoruka(util.Util.IZBACIO);
                        
                        for (ClientHandler skn : ServerListenhread.getServer().getKlijenti()) {

                            skn.getOut().writeObject(o);
                        }
                        
                        int pozicija =
                                (int) ServerListenhread.getServer().getServerSesija().get("izbacen_poz");

                         int izbacen =
                                (int) ServerListenhread.getServer().getServerSesija().get("izbacen");

                          int novi =
                                (int) ServerListenhread.getServer().getServerSesija().get("novi");
                        o = new TOServerOdgovor();
                        o.setRezultat(Thread.currentThread().getName() + 
                                "je izbacio elemenat sa pozicije "+pozicija + "("+izbacen+") " +
                                "sada je na poziciji "+pozicija+" broj " +novi);

                        for (ClientHandler skn : ServerListenhread.getServer().getKlijenti()) {

                            skn.getOut().writeObject(o);
                        }


                       
                    } catch (Exception e) {
                        o = new TOServerOdgovor();
                        o.setStatusIzvrsenjaOperacije(util.Util.STATUS_IZVRSENJA_OPERACIJE_NOT_OK);
                        o.setPoruka(util.Util.IZBACIO);
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                        out.writeObject(o);
                     
                    }
    }
    
    public void proccessRequest(TOKlijentZahtev zahtev) throws IOException, ClassNotFoundException, InterruptedException{
        TOServerOdgovor o = new TOServerOdgovor();
        
        
        try {
            
            while ((zahtev=(TOKlijentZahtev) in.readObject())!=null) { 
            int zah = zahtev.getZahtev();    
            switch (zah){
                
                case util.Util.OPERACIJA_HELO:
                    out.writeObject(logUser(zahtev));
                    ((JComboBox) ServerListenhread.getServer().getServerSesija().get("combo")).setModel(
                          new DefaultComboBoxModel(  ServerListenhread.getServer().getKlijenti().toArray()));
                    break;
                   
                case util.Util.IZBACI_ZAHTEV:
                    remove(zahtev);
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
                
                if(ServerListenhread.getServer().getKlijenti().size()==0)
                    ((JButton)ServerListenhread.getServer().getServerSesija().get("btn")).setEnabled(false);
                
            }
            System.out.println("Izbacio");
            ((JComboBox) ServerListenhread.getServer().getServerSesija().get("combo")).setModel(
                          new DefaultComboBoxModel(  ServerListenhread.getServer().getKlijenti().toArray()));
            Thread.currentThread().interrupt();
        }
        
        
            
            
        }
    
        
    
}

