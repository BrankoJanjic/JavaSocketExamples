package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.clienthandler.ClientHandler;



public class ServerListenhread extends Thread{
    
    
    private static ServerListenhread serverInThread;
    private final HashMap<String,Object> serverSesija ;
    ArrayList<String> listUsers = new ArrayList<>();
    ServerSocket ssoket;

    public ServerSocket getSsoket() {
        return ssoket;
    }
    
    
    public HashMap<String, Object> getServerSesija() {
        return serverSesija;
    }
    
    

    public ServerListenhread() {
        serverSesija = new HashMap<>();
   
        serverSesija.put("niz", new int[4]);
        serverSesija.put("uneto", 0);
        
    }
    
    
    private final ArrayList<ClientHandler> klijenti =
            new ArrayList<>();

    public ArrayList<ClientHandler> getKlijenti() {
        return klijenti;
    }

    public static ServerListenhread getServer() {
        if (serverInThread==null) {
            serverInThread = new ServerListenhread();
            
        }
        return serverInThread;
    }

   
    
    
    

    @Override
    public void run() {
        try {
            pokreniServerProgram();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerListenhread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void pokreniServerProgram() throws IOException, ClassNotFoundException {
        ssoket = new ServerSocket(9000);
        System.out.println("Otvoren server soket");

        while(true){
            Socket soket = ssoket.accept();
            ClientHandler serverKlijentNit =
                    new ClientHandler(soket);
            serverKlijentNit.start();
            System.out.println("Pokrenuta nit");
            
            
        }
    }
    
  
    
    private double dajAritmeticku(int[] niz) throws Exception{
        if (niz.length==0) {
            throw new Exception("Nema parnih brojeva");
        }
        double S= 0;
        for (int i : niz) {
            S= S+i;
        }
        
        return S/niz.length;
    }
    
    public synchronized void ubaci(int i) throws Exception{
        if (i<dajAritmeticku(vratiParne())) {
            int niz[] = (int[]) serverInThread.getServerSesija().get("niz");
            int novi[] = new int[niz.length+1];
            for (int j = 0; j < niz.length; j++) {
                novi[j]=niz[j];
            }
            novi[niz.length]=i;
            ServerListenhread.getServer().getServerSesija().put("niz", novi);
            System.out.println("Ubacio");
        }
        else
        {
            throw new Exception("Nisam ubacio");
        }
        

    }
    
    private int[] vratiParne (){
        
        int[] servNiz = (int[]) ServerListenhread.getServer().getServerSesija().get("niz");
        LinkedList<Integer> lista = new LinkedList<>();
        
        for (int i = 0; i < 10; i++) {
            if (servNiz[i]% 2==0) {
                lista.add(servNiz[i]);
            }
            
        }
        int ret[] = new int[lista.size()];
        
        for (int i = 0; i < lista.size(); i++) {
            ret[i] = lista.get(i);
        }
        return ret;
    }
    
    private int vratiMin(int [] niz) throws Exception {
    
        if (niz.length<=0) {
            throw new Exception("Nema brojeva");
        }
        int min = niz[0];
        for (int i = 0; i < niz.length; i++) {
            if (niz[i]<min){
                min=niz[i];
               
            }
        }
        return min;
}


   

}
