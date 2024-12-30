package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazNapovedaTest {

    private SeznamPrikazu platnePrikazy;
    private PrikazNapoveda prikazNapoveda;

    @BeforeEach
    void setUp() {
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazJdi(new HerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazKonec(new Hra()));
        prikazNapoveda = new PrikazNapoveda(platnePrikazy);
    }

    @AfterEach
    void tearDown() {
        platnePrikazy = null;
        prikazNapoveda = null;
    }

    @Test
    void provedPrikaz() {
        String expectedOutput = "Tvým úkolem je najít ztracené město a získat artefakt,\n"
                + "který odemkne přístup k tajemnému chrámu s pokladem.\n"
                + "\n"
                + "Můžeš zadat tyto příkazy:\n"
                + "jdi konec ";
        String vysledek = prikazNapoveda.provedPrikaz();
        assertEquals(expectedOutput, vysledek);
    }

    @Test
    void getNazev() {
        assertEquals("nápověda", prikazNapoveda.getNazev());
    }
}