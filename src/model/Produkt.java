package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Produkt implements Serializable {
    private String navn;
    private double pantPris;
    private final ArrayList<Pris> priser = new ArrayList<>();
    private final ArrayList<OrdreLinje> ordreLinjer = new ArrayList<>();
    private ProduktKategori produktKategori;
    private ProduktMedPant produktMedPant;
    private final ArrayList<Rundvisning>rundvisninger = new ArrayList<>();

    public Produkt(String navn) {
        this.navn = navn;
        this.produktKategori = produktKategori;
    }

    public double getPantPris() {
        return pantPris;
    }

    public void setPantPris(double pantPris) {
        this.pantPris = pantPris;
    }

    public ProduktMedPant getProduktMedPant() {
        return produktMedPant;
    }

    public void setProduktMedPant(ProduktMedPant produktMedPant) {
        this.produktMedPant = produktMedPant;
    }

    public ArrayList <OrdreLinje> getOrdreLinjer() {
        return new ArrayList<>(ordreLinjer);
    }

    public ProduktKategori getProduktKategori() {
        return produktKategori;
    }

    public void setProduktKategori(ProduktKategori produktKategori) {
        this.produktKategori = produktKategori;
    }

    public ArrayList<Rundvisning>getRundvisninger(){
        return new ArrayList<>(rundvisninger);
    }

    public Rundvisning CreateRundvisning(String navn, int antalDeltagelser, LocalDateTime dato) {
        Rundvisning rundvisning = new Rundvisning(dato,antalDeltagelser, navn);
        rundvisninger.add(rundvisning);
        rundvisning.produkt = this;
        return rundvisning;
    }


    public String getNavn() {
        return navn;
    }

    public ArrayList<Pris> getPriser() {
        return new ArrayList<>(priser);
    }

    /** Pre: The pris is not connected to a produkt. */
    public void addPris (Pris pris) {
        priser.add(pris);
        pris.produkt = this;
    }


    /** Pre: The pris is connected to this produkt. */
    public void removePris (Pris pris) {
        priser.remove(pris);
        pris.produkt = null;
    }

    /** Pre: The ordreLinje is not connected to a produkt. */
    public void addOrdreLinje (OrdreLinje ordreLinje) {
        ordreLinjer.add(ordreLinje);
        ordreLinje.setProdukt(this);
    }

    /** Pre: The ordreLinje is connected to this produkt. */
    public void removeOrdreLinje (OrdreLinje ordreLinje) {
        ordreLinjer.remove(ordreLinje);
    }

    public double produktPris () {
        double p = 0.0;
        for (Pris k : priser){
            p = k.getBel??b();
        }
        return p;
    }


    @Override
    public String toString() {
        return "Navn: " + navn+" Pris: "+produktPris();}

}
