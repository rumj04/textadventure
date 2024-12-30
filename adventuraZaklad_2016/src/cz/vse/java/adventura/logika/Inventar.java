package cz.vse.java.adventura.logika;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Třída Inventar - třída spravující seznam sebraných předmětů hráče.
 *
 *  Tato třída je součástí logiky aplikace. Umožňuje hráči přidávat, odebírat a kontrolovat předměty v inventáři.
 *  Také poskytuje metodu pro výpis obsahu inventáře.
 *
 *  @autor      Jan Ruml
 *  @version    1.0
 *  @created    prosinec 2024
 */
public class Inventar {
    private List<String> predmety;

    /**jd
     * Konstruktor, který inicializuje prázdný inventář.
     */
    public Inventar() {
        this.predmety = new ArrayList<>();
    }

    /**
     * Přidá předmět do inventáře.
     * @param nazevPredmetu název předmětu
     */
    public void pridatPredmet(String nazevPredmetu) {
        predmety.add(nazevPredmetu);
    }

    public boolean obsahujePredmet(String nazevPredmetu) {
        return predmety.contains(nazevPredmetu);
    }

    public void odstranPredmet(String nazevPredmetu) {
        predmety.remove(nazevPredmetu);
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
            return "V inventáři máš: " + String.join(", ", predmety);
        }
    }
}
