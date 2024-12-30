package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HerniPlanTest {

    private HerniPlan herniPlan;

    @BeforeEach
    void setUp() {
        herniPlan = new HerniPlan();
    }

    @AfterEach
    void tearDown() {
        herniPlan = null;
    }

    @Test
    void getAktualniProstor() {
        assertNotNull(herniPlan.getAktualniProstor());
        assertEquals("brána", herniPlan.getAktualniProstor().getNazev());
    }

    @Test
    void setAktualniProstor() {
        Prostor les = new Prostor("les", "Zelený les s vysokými stromy a hustým porostem");
        herniPlan.setAktualniProstor(les);
        assertEquals(les, herniPlan.getAktualniProstor());
    }

    @Test
    void getPredchoziProstor() {
        Prostor les = new Prostor("les", "Zelený les s vysokými stromy a hustým porostem");
        herniPlan.setAktualniProstor(les);
        assertEquals("brána", herniPlan.getPredchoziProstor().getNazev());
    }

    @Test
    void getInventar() {
        assertNotNull(herniPlan.getInventar());
    }
}