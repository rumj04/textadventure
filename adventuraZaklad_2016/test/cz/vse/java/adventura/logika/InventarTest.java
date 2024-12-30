package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarTest {

    private Inventar inventar;

    @BeforeEach
    void setUp() {
        inventar = new Inventar();
    }

    @AfterEach
    void tearDown() {
        inventar = null;
    }

    @Test
    void pridatPredmet() {
        inventar.pridatPredmet("meč");
        assertTrue(inventar.obsahujePredmet("meč"));
    }

    @Test
    void obsahujePredmet() {
        inventar.pridatPredmet("štít");
        assertTrue(inventar.obsahujePredmet("štít"));
        assertFalse(inventar.obsahujePredmet("luk"));
    }

    @Test
    void odstranPredmet() {
        inventar.pridatPredmet("mapa");
        assertTrue(inventar.obsahujePredmet("mapa"));
        inventar.odstranPredmet("mapa");
        assertFalse(inventar.obsahujePredmet("mapa"));
    }

    @Test
    void jePrazdny() {
        assertTrue(inventar.jePrazdny());
        inventar.pridatPredmet("brnění");
        assertFalse(inventar.jePrazdny());
    }

    @Test
    void vypisInventar() {
        assertEquals("Tvůj inventář je prázdný.", inventar.vypisInventar());
        inventar.pridatPredmet("prkno");
        assertEquals("V inventáři máš: prkno", inventar.vypisInventar());
        inventar.pridatPredmet("meč");
        assertEquals("V inventáři máš: prkno, meč", inventar.vypisInventar());
    }
}