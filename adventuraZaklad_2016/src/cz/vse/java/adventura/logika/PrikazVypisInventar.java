package cz.vse.java.adventura.logika;

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