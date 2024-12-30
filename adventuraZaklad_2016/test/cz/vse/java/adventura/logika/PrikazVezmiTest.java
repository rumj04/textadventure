package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazVezmiTest {

    private HerniPlan plan;
    private Inventar inventar;
    private PrikazVezmi prikazVezmi;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        inventar = new Inventar();
        prikazVezmi = new PrikazVezmi(plan, inventar);
    }

    @AfterEach
    void tearDown() {
        plan = null;
        inventar = null;
        prikazVezmi = null;
    }

    @Test
    void vezmiBezParametru() {
        String vysledek = prikazVezmi.provedPrikaz();
        assertEquals("Nevím, co mám sebrat. Musíš zadat název předmětu.", vysledek);
    }

    @Test
    void vezmiPredmetNeexistuje() {
        Prostor les = new Prostor("les", "Les s vysokými stromy a hustým porostem");
        plan.setAktualniProstor(les);
        String vysledek = prikazVezmi.provedPrikaz("meč");
        assertEquals("Předmět 'meč' tu není.", vysledek);
    }

    @Test
    void vezmiPredmetExistuje() {
        Prostor les = new Prostor("les", "Les s vysokými stromy a hustým porostem");
        les.pridatPredmet("meč");
        plan.setAktualniProstor(les);
        String vysledek = prikazVezmi.provedPrikaz("meč");
        assertEquals("Sebral jsi předmět: meč", vysledek);
        assertTrue(inventar.obsahujePredmet("meč"));
    }

    @Test
    void vezmiTruhla() {
        Prostor les = new Prostor("les", "Les s vysokými stromy a hustým porostem");
        les.pridatPredmet("truhla");
        plan.setAktualniProstor(les);
        String vysledek = prikazVezmi.provedPrikaz("truhla");
        assertEquals("Otevřel jsi truhlu a našel jsi artefakt! Přidal jsi ho do inventáře.", vysledek);
        assertTrue(inventar.obsahujePredmet("artefakt"));
    }

    @Test
    void vezmiSvitek() {
        Prostor les = new Prostor("les", "Les s vysokými stromy a hustým porostem");
        les.pridatPredmet("svitek");
        plan.setAktualniProstor(les);
        String vysledek = prikazVezmi.provedPrikaz("svitek");
        assertEquals("Sebral jsi předmět: svitek\nNa svitku je napsáno: Odpověď na hádanku je 'dech'.", vysledek);
        assertTrue(inventar.obsahujePredmet("svitek"));
    }

    @Test
    void getNazev() {
        assertEquals("vezmi", prikazVezmi.getNazev());
    }
}