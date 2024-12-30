package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazProzkoumejTest {

    private HerniPlan plan;
    private PrikazProzkoumej prikazProzkoumej;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        prikazProzkoumej = new PrikazProzkoumej(plan);
    }

    @AfterEach
    void tearDown() {
        plan = null;
        prikazProzkoumej = null;
    }

    @Test
    void prozkoumejJeskyneBezOdpovedi() {
        plan.setAktualniProstor(new Prostor("jeskyně", "Jeskyně s hádankou."));
        String vysledek = prikazProzkoumej.provedPrikaz();
        assertEquals("Hádanka: Jsem lehčí než pírko, ale žádný člověk mě neudrží déle než pár minut? \n \n Zadej odpověď pomocí 'prozkoumej [odpověď]'. \n Pokud odpověď neznáš, zkus se porozhlédnout v jednom ze zbylých prostorů.", vysledek);
    }

    @Test
    void prozkoumejJeskyneSOdpovedi() {
        plan.setAktualniProstor(new Prostor("jeskyně", "Jeskyně s hádankou."));
        String vysledek = prikazProzkoumej.provedPrikaz("dech");
        assertEquals("Správně! Dozvěděl ses o ztraceném městě. Dostaneš se k němu cestou přes řeku pomocí prkna. \n Jdi do prostoru řeka a použij prkno.", vysledek);
    }

    @Test
    void prozkoumejMesto() {
        plan.setAktualniProstor(new Prostor("město", "Ztracené město."));
        String vysledek = prikazProzkoumej.provedPrikaz();
        assertEquals("K odemčení brány potřebuješ klíč. Pokud ho máš tak ho použij. \n Pokud ne, tak ho najdi.", vysledek);
    }

    @Test
    void prozkoumejChram() {
        plan.setAktualniProstor(new Prostor("chrám", "Chrám skrytého pokladu, obklopený magickou bariérou."));
        String vysledek = prikazProzkoumej.provedPrikaz();
        assertEquals("Pro otevření chrámu potřebuješ artefakt. Pokud ho máš tak ho použij. \n Pokud ne, tak ho najdi.", vysledek);
    }

    @Test
    void prozkoumejProstorBezPredmetu() {
        plan.setAktualniProstor(new Prostor("brána", "Brána do ztraceného města."));
        String vysledek = prikazProzkoumej.provedPrikaz();
        assertEquals("Tady nic nehledej člověče!", vysledek);
    }

    @Test
    void prozkoumejProstorSPredmety() {
        Prostor les = new Prostor("les", "Les s vysokými stromy a hustým porostem");
        les.pridatPredmet("prkno");
        les.pridatPredmet("ovoce");
        plan.setAktualniProstor(les);
        String vysledek = prikazProzkoumej.provedPrikaz();
        assertEquals("V prostoru se nachází: prkno, ovoce", vysledek);
    }

    @Test
    void getNazev() {
        assertEquals("prozkoumej", prikazProzkoumej.getNazev());
    }
}