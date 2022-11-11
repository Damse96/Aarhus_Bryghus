package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProduktKategori implements Serializable {
    private String navn;
    private final ArrayList<Produkt> produkter = new ArrayList<>();

    public ProduktKategori(String navn) {
        this.navn = navn;
    }

    public void addProdukt(Produkt produkt){
        produkter.add(produkt);
    }

    public void removeProdukt(Produkt produkt){
        produkter.remove(produkt);
    }

    public ArrayList<Produkt>getProdukter(){
        return new ArrayList<>(produkter);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return navn+"";
    }
}
