package server;

import gui.ServerFormaTable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import server.clienthandler.ClientHandler;



public class ServerListenhread extends Thread{
    
    
    private static ServerListenhread serverInThread;
    private final HashMap<String,Object> serverSesija ;
    ArrayList<String> listUsers = new ArrayList<>();

    public HashMap<String, Object> getServerSesija() {
        return serverSesija;
    }
    
    

    public ServerListenhread() {
        serverSesija = new HashMap<>();
     
        serverSesija.put("adminX", 0);
        serverSesija.put("adminY", 0);
        serverSesija.put("userA", 0);
        serverSesija.put("userY", 0);
        
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
        ServerSocket ssoket = new ServerSocket(9000);
        System.out.println("Otvoren server soket");
        serverSesija.put("niz", vratibrojeve());
        new ServerFormaTable().setVisible(true);
        
        while(true){
            Socket soket = ssoket.accept();
            ClientHandler serverKlijentNit =
                    new ClientHandler(soket);
            serverKlijentNit.start();
            System.out.println("Pokrenuta nit");
            
            
        }
    }
    
    public int[] vratibrojeve(){
        
         int[]  niz= new int[10];
  
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            niz[i]= random.nextInt((10));
        }
        
        return niz;
    }
    
    public synchronized void izbaciSaPozicije(int i) throws Exception{
        
        if( i<0 || i>9){
            throw new Exception("Niz nema tu poziciju");
        }
        System.out.println("Pristupio");
        
        int niz[] = (int[]) ServerListenhread.getServer().getServerSesija().get("niz");
        ServerListenhread.getServer().getServerSesija().put("izbacen", niz[i]);
        niz[i] = Integer.MAX_VALUE;
        if (vratiDeljive().length==0) {
            niz[i] = new Random().nextInt();
        }
        else{
            niz[i] = vratiMin(vratiDeljive());
        }
        ServerListenhread.getServer().getServerSesija().put("izbacen_poz", i);
        ServerListenhread.getServer().getServerSesija().put("novi", niz[i]);
        JTable jtable = (JTable)ServerListenhread.getServer().getServerSesija().get("tabela");
        jtable.setValueAt(niz[i], 0, i);
        
        
        
        
        
    }
    
    private int[] vratiDeljive (){
        
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
