package cz.vse.java.adventura.logika;

/**
 *  Třída PrikazProzkoumej - třída představující příkaz pro prozkoumání prostoru.

 *  Tato třída je součástí logiky aplikace. Zpracovává příkaz "prozkoumej",
 *  který umožňuje hráči prozkoumat aktuální prostor.
 *
 *  @autor      Jan Ruml
 *  @version    1.0
 *  @created    prosinec 2024
 */

public class PrikazVypisInventar implements IPrikaz {
    private static final String NAZEV = "inventář";
    private final Inventar inventar;

    public PrikazVypisInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length > 0) {
            return "Příkaz inventar se zadává bez parametrů.";
        }
        return inventar.vypisInventar();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}