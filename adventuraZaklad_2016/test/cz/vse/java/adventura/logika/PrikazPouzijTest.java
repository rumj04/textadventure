package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazPouzijTest {

    private HerniPlan plan;
    private Inventar inventar;
    private PrikazPouzij prikazPouzij;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        inventar = new Inventar();
        prikazPouzij = new PrikazPouzij(plan, inventar);
    }

    @AfterEach
    void tearDown() {
        plan = null;
        inventar = null;
        prikazPouzij = null;
    }

    @Test
    void pouzijBezParametru() {
        String vysledek = prikazPouzij.provedPrikaz();
        assertEquals("Nevím, co mám použít. Zadej 'pouzij [predmet]'.", vysledek);
    }

    @Test
    void pouzijPredmetNeniVInventari() {
        String vysledek = prikazPouzij.provedPrikaz("prkno");
        assertEquals("Nemáš předmět 'prkno' v inventáři.", vysledek);
    }

    @Test
    void pouzijPrknoVReka() {
        inventar.pridatPredmet("prkno");
        plan.setAktualniProstor(new Prostor("řeka", "Řeka, kterou je třeba překonat."));
        String vysledek = prikazPouzij.provedPrikaz("prkno");
        assertEquals("Položil jsi prkno a vytvořil lávku přes řeku. Nyní můžeš jít do města.", vysledek);
        assertFalse(inventar.obsahujePredmet("prkno"));
    }

    @Test
    void pouzijPrknoJinde() {
        inventar.pridatPredmet("prkno");
        plan.setAktualniProstor(new Prostor("les", "Les s vysokými stromy a hustým porostem"));
        String vysledek = prikazPouzij.provedPrikaz("prkno");
        assertEquals("Prkno nelze použít zde.", vysledek);
    }

//    @Test
//    void pouzijArtefaktVChram() {
//        inventar.pridatPredmet("artefakt");
//        plan.setAktualniProstor(new Prostor("chrám", "Chrám skrytého pokladu, obklopený magickou bariérou."));
//        String vysledek = prikazPouzij.provedPrikaz("artefakt");
//        assertEquals("", vysledek);
//        assertFalse(inventar.obsahujePredmet("artefakt"));
//        assertTrue(inventar.obsahujePredmet("poklad"));
//    }

    @Test
    void pouzijArtefaktJinde() {
        inventar.pridatPredmet("artefakt");
        plan.setAktualniProstor(new Prostor("les", "Les s vysokými stromy a hustým porostem"));
        String vysledek = prikazPouzij.provedPrikaz("artefakt");
        assertEquals("Artefakt nelze použít zde.", vysledek);
    }

    @Test
    void provedPrikazKlicVMesto() {
        inventar.pridatPredmet("klíč");
        plan.setAktualniProstor(new Prostor("město", "Ztracené město."));
        String vysledek = prikazPouzij.provedPrikaz("klíč");
        assertEquals("Použil jsi klíč a odemkl jsi cestu do chrámu.", vysledek);
        assertFalse(inventar.obsahujePredmet("klíč"));
    }

    @Test
    void provedPrikazKlicJinde() {
        inventar.pridatPredmet("klíč");
        plan.setAktualniProstor(new Prostor("les", "Les s vysokými stromy a hustým porostem"));
        String vysledek = prikazPouzij.provedPrikaz("klíč");
        assertEquals("Klíč nelze použít zde.", vysledek);
    }

    @Test
    void getNazev() {
        assertEquals("použij", prikazPouzij.getNazev());
    }
}