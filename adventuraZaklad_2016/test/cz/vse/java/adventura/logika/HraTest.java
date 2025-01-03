package cz.vse.java.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

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
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @AfterEach
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("brána", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi les");
        assertFalse(hra1.konecHry());
        assertEquals("les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi křižovatka");
        assertFalse(hra1.konecHry());
        assertEquals("křižovatka", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("konec");
        assertTrue(hra1.konecHry());
    }

    @Test
    void vratUvitani() {
        String uvodniZprava = hra1.vratUvitani();
        assertNotNull(uvodniZprava);
        assertTrue(uvodniZprava.contains("Vítej, mladý dobrodruhu!"));
    }

    @Test
    void vratEpilog() {
        String epilog = hra1.vratEpilog();
        assertNotNull(epilog);
        assertEquals("Díky, že jste si zahráli.", epilog);
    }

    @Test
    void konecHry() {
        assertFalse(hra1.konecHry());
        hra1.setKonecHry(true);
        assertTrue(hra1.konecHry());
    }

    @Test
    void zpracujPrikaz() {
        String odpoved = hra1.zpracujPrikaz("neznámý_příkaz");
        assertEquals("Nevím co tím myslíš? Tento příkaz neznám. ", odpoved);
    }

    @Test
    public void testZpracujPrikazJdi() {
        hra1.zpracujPrikaz("jdi les");
        assertEquals("les", hra1.getHerniPlan().getAktualniProstor().getNazev());
    }

    @Test
    void setKonecHry() {
        hra1.setKonecHry(true);
        assertTrue(hra1.konecHry());
    }

    @Test
    void getHerniPlan() {
        assertNotNull(hra1.getHerniPlan());
    }
}
