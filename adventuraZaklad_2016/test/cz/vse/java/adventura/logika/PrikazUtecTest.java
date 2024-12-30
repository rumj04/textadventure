package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazUtecTest {

    private HerniPlan plan;
    private PrikazUtec prikazUtec;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        prikazUtec = new PrikazUtec(plan);
    }

    @AfterEach
    void tearDown() {
        plan = null;
        prikazUtec = null;
    }

    @Test
    void utecBezPredchozihoProstoru() {
        plan.setPredchoziProstor(null);
        String vysledek = prikazUtec.provedPrikaz();
        assertEquals("Nemáš kam utéct!", vysledek);
    }

    @Test
    void utecSPrechozimProstorem() {
        Prostor aktualniProstor = new Prostor("les", "Les s vysokými stromy a hustým porostem");
        Prostor predchoziProstor = new Prostor("město", "Město, kam se chceš dostat.");
        plan.setAktualniProstor(aktualniProstor);
        plan.setPredchoziProstor(predchoziProstor);

        String vysledek = prikazUtec.provedPrikaz();
        assertEquals("Utekl jsi zpět do prostoru: město", vysledek);
        assertEquals(predchoziProstor, plan.getAktualniProstor());
    }

    @Test
    void getNazev() {
        assertEquals("uteč", prikazUtec.getNazev());
    }
}