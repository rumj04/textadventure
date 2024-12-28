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
    private Prostor predchoziProstor;
    private final Inventar inventar;
    private Prostor reka;
    private Prostor mesto;
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        inventar = new Inventar();
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
        Prostor vpravo = new Prostor("vpravo", "Cesta vpravo - narazil jsi na nebezpečné hady, jediná možnost je utéct");
        Prostor vlevo = new Prostor("vlevo", "Cesta vlevo - možná tu najdeš něco zajímavého");
        Prostor chyse = new Prostor("chýše", "Opuštěná chýše, která skrývá tajemství");
        Prostor poust = new Prostor("poušť", "Malá poušť, kde se nejspíš nic nenachází \n nebo že by...");
        reka = new Prostor("řeka", "Divoká řeka, u které se nachází skrytá jeskyně");
        Prostor jeskyne = new Prostor("jeskyně", "Skrytá jeskyně s tajemnou bytostí, která klade hádanky. Pokud na hádanku odpovíš správně, otevře se ti cesta do ztraceného města. Pokud ne, zůstaneš uvězněný v jeskyni a tvé dobrodružství zde skončí");
        mesto = new Prostor("město", "Ztracené město pokryté mechem a rostlinami");
        Prostor chram = new Prostor("chrám", "Chrám skrytého pokladu, obklopený magickou bariérou");

        brana.setVychod(les);
        les.setVychod(brana);
        les.setVychod(krizovatka);
        les.pridatPredmet("prkno");
        krizovatka.setVychod(les);
        krizovatka.setVychod(udoli);
        krizovatka.setVychod(chyse);
        udoli.setVychod(krizovatka);
        udoli.setVychod(vpravo);
        udoli.setVychod(vlevo);
        vlevo.setVychod(udoli);
        vlevo.pridatPredmet("klíč");
        chyse.setVychod(krizovatka);
        chyse.pridatPredmet("svitek");
        krizovatka.setVychod(poust);
        poust.setVychod(krizovatka);
        poust.setVychod(reka);
        poust.pridatPredmet("truhla");
        reka.setVychod(poust);
        reka.setVychod(jeskyne);
        jeskyne.setVychod(reka);
        mesto.setVychod(chram);
        chram.setVychod(mesto);

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
        predchoziProstor = aktualniProstor;
        aktualniProstor = prostor;
        System.out.println(inventar.vypisInventar());
    }

    public Prostor getPredchoziProstor() {
        return predchoziProstor;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void odemkniVychodRekaMesto() {
        reka.setVychod(mesto);
        mesto.setVychod(reka);
    }

    public void ukoncitHru() {
        System.out.println("Tady tvá cesta končí - můžeš to zkusit znovu");
        System.exit(0);
    }
}
