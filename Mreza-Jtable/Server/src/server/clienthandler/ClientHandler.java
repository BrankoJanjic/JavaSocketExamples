/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.clienthandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.protocolhandler.ProtocolHandler;
import transfer.TOKlijentZahtev;

/**
 *
 * @author janjic
 */
public class ClientHandler extends Thread{
    
    
    private Socket socket;
    private ObjectInputStream in;
    private  ObjectOutputStream out;
    private String username;
    private final SimpleDateFormat hhmm  = new SimpleDateFormat("hh:mm");
    ProtocolHandler protocolHandler;
    private final SimpleDateFormat hhmmss  = new SimpleDateFormat("hh:mm:ss");
    

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        protocolHandler = new ProtocolHandler(in,out);
        
        
    }


    @Override
    public void run() {
        try {
            try {
                protocolHandler.proccessRequest(new TOKlijentZahtev());
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  

    public Socket getSocket() {
        return socket;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
    
        
        
    }
    

