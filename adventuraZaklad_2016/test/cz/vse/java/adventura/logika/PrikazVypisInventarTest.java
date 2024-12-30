package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazVypisInventarTest {

    private Inventar inventar;
    private PrikazVypisInventar prikazVypisInventar;

    @BeforeEach
    void setUp() {
        inventar = new Inventar();
        prikazVypisInventar = new PrikazVypisInventar(inventar);
    }

    @AfterEach
    void tearDown() {
        inventar = null;
        prikazVypisInventar = null;
    }

    @Test
    void vypisInventar() {
        String vysledek = prikazVypisInventar.provedPrikaz();
        assertEquals("Tvůj inventář je prázdný.", vysledek);
    }

    @Test
    void vypisInventarSParametry() {
        String vysledek = prikazVypisInventar.provedPrikaz("něco");
        assertEquals("Příkaz inventar se zadává bez parametrů.", vysledek);
    }

    @Test
    void vypisInventarSVecmi() {
        inventar.pridatPredmet("meč");
        inventar.pridatPredmet("štít");
        String vysledek = prikazVypisInventar.provedPrikaz();
        assertEquals("V inventáři máš: meč, štít", vysledek);
    }

    @Test
    void getNazev() {
        assertEquals("inventář", prikazVypisInventar.getNazev());
    }
}