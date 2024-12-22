package cz.vse.java.adventura.logika;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Třída Inventar spravuje seznam sebraných předmětů hráče.
 */
public class Inventar {
    private List<String> predmety;

    /**
     * Konstruktor, který inicializuje prázdný inventář.
     */
    public Inventar() {
        this.predmety = new ArrayList<>();
    }

    /**
     * Přidá předmět do inventáře.
     * @param predmet název předmětu
     */
    public void pridatPredmet(String predmet) {
        predmety.add(predmet);
    }

    /**
     * Zkontroluje, zda je inventář prázdný.
     * @return true pokud je inventář prázdný, jinak false
     */
    public boolean jePrazdny() {
        return predmety.isEmpty();
    }

    /**
     * Vrátí seznam předmětů jako formátovaný řetězec.
     * @return obsah inventáře jako řetězec
     */
    public String vypisInventar() {
        if (jePrazdny()) {
            return "Tvůj inventář je prázdný.";
        } else {
            return "V inventáři máš: " + predmety.stream().collect(Collectors.joining(", "));
        }
    }
}
