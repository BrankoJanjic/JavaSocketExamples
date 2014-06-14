package transfer;

import java.io.Serializable;

public class TOServerOdgovor implements Serializable{
    private Object rezultat; // odgovor servera
    private int statusIzvrsenjaOperacije;
    private int poruka;

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public int getStatusIzvrsenjaOperacije() {
        return statusIzvrsenjaOperacije;
    }

    public void setStatusIzvrsenjaOperacije(int statusIzvrsenjaOperacije) {
        this.statusIzvrsenjaOperacije = statusIzvrsenjaOperacije;
    }

    public int getPoruka() {
        return poruka;
    }

    public void setPoruka(int poruka) {
        this.poruka = poruka;
    }
    
    
    
}
