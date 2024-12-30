package cz.vse.java.adventura.logika;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy  
 * SeznamPrikazu
 * 
 * @author    Luboš Pavlíček
 * @version   pro školní rok 2016/2017
 */
public class SeznamPrikazuTest {
    private PrikazKonec prKonec;
    private PrikazJdi prJdi;
    private SeznamPrikazu seznPrikazu;

    @BeforeEach
    public void setUp() {
        Hra hra = new Hra();
        prKonec = new PrikazKonec(hra);
        prJdi = new PrikazJdi(hra.getHerniPlan());
        seznPrikazu = new SeznamPrikazu();
    }

    @Test
    public void testVlozeniVybrani() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        assertNull(seznPrikazu.vratPrikaz("nápověda"));
    }

    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        assertTrue(seznPrikazu.jePlatnyPrikaz("konec"));
        assertTrue(seznPrikazu.jePlatnyPrikaz("jdi"));
        assertFalse(seznPrikazu.jePlatnyPrikaz("nápověda"));
        assertFalse(seznPrikazu.jePlatnyPrikaz("Konec"));
    }

    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertTrue(nazvy.contains("konec"));
        assertTrue(nazvy.contains("jdi"));
        assertFalse(nazvy.contains("nápověda"));
        assertFalse(nazvy.contains("Konec"));
    }

    @AfterEach
    public void tearDown() {
        seznPrikazu = null;
        prKonec = null;
        prJdi = null;
    }

    @Test
    void vlozPrikaz() {
        seznPrikazu.vlozPrikaz(prKonec);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
    }

    @Test
    void vratPrikaz() {
        seznPrikazu.vlozPrikaz(prJdi);
        assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        assertNull(seznPrikazu.vratPrikaz("nápověda"));
    }

    @Test
    void jePlatnyPrikaz() {
        seznPrikazu.vlozPrikaz(prKonec);
        assertTrue(seznPrikazu.jePlatnyPrikaz("konec"));
        assertFalse(seznPrikazu.jePlatnyPrikaz("nápověda"));
    }

    @Test
    void vratNazvyPrikazu() {
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertTrue(nazvy.contains("konec"));
        assertTrue(nazvy.contains("jdi"));
        assertFalse(nazvy.contains("nápověda"));
    }
}