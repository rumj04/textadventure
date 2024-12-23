package cz.vse.java.adventura.logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private final Inventar inventar;
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        this.inventar = new Inventar();
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory

        Prostor brana = new Prostor("brána", "Vstupní brána do pralesa, která otevírá cestu do neznáma");
        Prostor les = new Prostor("les", "Zelený les s vysokými stromy a hustým porostem");
        Prostor krizovatka = new Prostor("křižovatka", "Křižovatka, kde se sbíhají různé cesty vedoucí do pralesa");
        Prostor udoli = new Prostor("údolí", "Temné údolí plné nebezpečných hadů");
        Prostor vpravo = new Prostor("vpravo", "Cesta vpravo, zde jsou nebezpeční hadi");
        Prostor vlevo = new Prostor("vlevo", "Cesta vlevo, možná tu najdeš něco zajímavého");
        Prostor chyse = new Prostor("chýše", "Opuštěná chýše, která skrývá tajemství");
        Prostor poust = new Prostor("poušť", "Malá poušť, kde se nejspíš nic nenachází... \n nejspíš");
        Prostor reka = new Prostor("řeka", "Divoká řeka, u které se nachází skrytá jeskyně");
        Prostor jeskyne = new Prostor("jeskyně", "Skrytá jeskyně s tajemnou bytostí, která klade hádanky");
        Prostor mesto = new Prostor("město", "Ztracené město pokryté mechem a rostlinami");
        Prostor chram = new Prostor("chrám", "Chrám skrytého pokladu, obklopený magickou bariérou");

        brana.setVychod(les);
        les.setVychod(brana);
        les.setVychod(krizovatka);
        les.vlozPredmet("prkno");
        krizovatka.setVychod(les);
        krizovatka.setVychod(udoli);
        krizovatka.setVychod(chyse);
        udoli.setVychod(krizovatka);
        udoli.setVychod(vpravo);
        udoli.setVychod(vlevo);
        vpravo.setVychod(udoli);
        vlevo.setVychod(udoli);
        vlevo.vlozPredmet("klíč");
        chyse.setVychod(krizovatka);
        krizovatka.setVychod(poust);
        poust.setVychod(krizovatka);
        poust.setVychod(reka);
        poust.vlozPredmet("truhla");
        reka.setVychod(poust);
        reka.setVychod(jeskyne);
        jeskyne.setVychod(reka);
        jeskyne.setVychod(mesto);
        mesto.setVychod(jeskyne);
        mesto.setVychod(chram);
        chram.vlozPredmet("zamčený poklad");

        aktualniProstor = brana;  // hra začíná v domečku
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
        System.out.println(inventar.vypisInventar());
    }

    public Inventar getInventar() {
        return inventar;
    }
}
