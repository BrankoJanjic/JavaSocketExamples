package klijent.session;

import java.util.HashMap;

/**
 *
 * @author janjic
 */
public class Sesija {
 
  private  HashMap<String, Object> mapa = new HashMap<String, Object>();

    public HashMap<String, Object> getMapa() {
        return mapa;
    }
  
  
  private static Sesija sesija;

    public static Sesija getSesija() {
        
        if (sesija==null) {
            sesija = new Sesija();
        }
        return sesija;
    }
  
  
    
}
