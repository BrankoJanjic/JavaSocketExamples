
package transfer;

import java.io.Serializable;


public class TOKlijentZahtev implements Serializable{
    
private Object parametar;
private int zahtev;

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public int getZahtev() {
        return zahtev;
    }

    public void setZahtev(int zahtev) {
        this.zahtev = zahtev;
    }

}
