package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2016/2017
 */
public class ProstorTest {
    private Prostor prostor1;
    private Prostor prostor2;
    private Prostor prostor3;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @BeforeEach
    public void setUp() {
        prostor1 = new Prostor("brána", "vstupní brána do hradu");
        prostor2 = new Prostor("les", "temný les plný nebezpečí");
        prostor3 = new Prostor("křižovatka", "křižovatka cest v lese");
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @AfterEach
    public void tearDown() {
        prostor1 = null;
        prostor2 = null;
        prostor3 = null;
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public void testLzeProjit() {
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor3);
        assertEquals(prostor2, prostor1.vratSousedniProstor("les"));
        assertNull(prostor1.vratSousedniProstor("křižovatka"));
    }


    @Test
    void setVychod() {
        prostor1.setVychod(prostor2);
        assertTrue(prostor1.getVychody().contains(prostor2));
    }

    @Test
    void testEquals() {
        Prostor prostor4 = new Prostor("brána", "jiný popis");
        assertEquals(prostor1, prostor4);
        assertNotEquals(prostor1, prostor2);
    }

    @Test
    void testHashCode() {
        Prostor prostor4 = new Prostor("brána", "jiný popis");
        assertEquals(prostor1.hashCode(), prostor4.hashCode());
    }

    @Test
    void getNazev() {
        assertEquals("brána", prostor1.getNazev());
        assertEquals("les", prostor2.getNazev());
        assertEquals("křižovatka", prostor3.getNazev());
    }

    @Test
    void dlouhyPopis() {
        assertTrue(prostor1.dlouhyPopis().contains("vstupní brána do hradu"));
        assertTrue(prostor2.dlouhyPopis().contains("temný les plný nebezpečí"));
        assertTrue(prostor3.dlouhyPopis().contains("křižovatka cest v lese"));
    }

    @Test
    void vratSousedniProstor() {
        prostor1.setVychod(prostor2);
        assertEquals(prostor2, prostor1.vratSousedniProstor("les"));
        assertNull(prostor1.vratSousedniProstor("křižovatka"));
    }

    @Test
    void getVychody() {
        prostor1.setVychod(prostor2);
        prostor1.setVychod(prostor3);
        assertTrue(prostor1.getVychody().contains(prostor2));
        assertTrue(prostor1.getVychody().contains(prostor3));
    }

    @Test
    void getPredmety() {
        prostor1.pridatPredmet("klíč");
        assertTrue(prostor1.getPredmety().contains("klíč"));
    }

    @Test
    void pridatPredmet() {
        prostor1.pridatPredmet("klíč");
        assertTrue(prostor1.obsahujePredmet("klíč"));
    }

    @Test
    void obsahujePredmet() {
        prostor1.pridatPredmet("klíč");
        assertTrue(prostor1.obsahujePredmet("klíč"));
        assertFalse(prostor1.obsahujePredmet("meč"));
    }

    @Test
    void odstranPredmet() {
        prostor1.pridatPredmet("klíč");
        prostor1.odstranPredmet("klíč");
        assertFalse(prostor1.obsahujePredmet("klíč"));
    }

    @Test
    void jeTruhla() {
        assertTrue(prostor1.jeTruhla("truhla"));
        assertFalse(prostor1.jeTruhla("klíč"));
    }
}