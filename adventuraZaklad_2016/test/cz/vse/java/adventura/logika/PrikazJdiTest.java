package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazJdiTest {

    private HerniPlan plan;
    private PrikazJdi prikazJdi;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        prikazJdi = new PrikazJdi(plan);
    }

    @AfterEach
    void tearDown() {
        plan = null;
        prikazJdi = null;
    }

    @Test
    void jdiBezParametru() {
        String vysledek = prikazJdi.provedPrikaz();
        assertEquals("Kam mám jít? Musíš zadat jméno východu", vysledek);
    }

    @Test
    void jdiNeexistujiciProstor() {
        String vysledek = prikazJdi.provedPrikaz("neexistujici");
        assertEquals("Tam se odsud jít nedá!", vysledek);
    }

    @Test
    void jdiExistujiciProstor() {
        Prostor les = new Prostor("les", "Zelený les s vysokými stromy a hustým porostem");
        plan.getAktualniProstor().setVychod(les);
        String vysledek = prikazJdi.provedPrikaz("les");
        String expectedOutput = "Jsi v prostoru Zelený les s vysokými stromy a hustým porostem.\n" + "východy: křižovatka brána";
        assertEquals(expectedOutput, vysledek);
        assertEquals(les, plan.getAktualniProstor());
    }

    @Test
    void getNazev() {
        assertEquals("jdi", prikazJdi.getNazev());
    }
}