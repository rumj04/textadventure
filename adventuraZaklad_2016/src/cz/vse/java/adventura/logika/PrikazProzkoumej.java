package cz.vse.java.adventura.logika;

import java.util.List;

/**
 *  Třída PrikazProzkoumej - třída představující příkaz pro prozkoumání prostoru.

 *  Tato třída je součástí logiky aplikace. Zpracovává příkaz "prozkoumej",
 *  který umožňuje hráči prozkoumat aktuální prostor.
 *
 *  @autor      Jan Ruml
 *  @version    1.0
 *  @created    prosinec 2024
 */

public class PrikazProzkoumej implements IPrikaz {
    private static final String NAZEV = "prozkoumej";
    private final HerniPlan plan;

    public PrikazProzkoumej(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Prostor aktualniProstor = plan.getAktualniProstor();
        List<String> predmety = aktualniProstor.getPredmety();
        String odpoved;

        switch (aktualniProstor.getNazev()) {
            case "jeskyně":
                if (parametry.length == 0) {
                    return "Hádanka: Jsem lehčí než pírko, ale žádný člověk mě neudrží déle než pár minut? \n \n Zadej odpověď pomocí 'prozkoumej [odpověď]'. \n Pokud odpověď neznáš, zkus se porozhlédnout v jednom ze zbylých prostorů.";
                } else {
                    String odpovedNaHadanku = String.join(" ", parametry).toLowerCase();
                    if (odpovedNaHadanku.equals("dech")) {
                        return "Správně! Dozvěděl ses o ztraceném městě. Dostaneš se k němu cestou přes řeku pomocí prkna. \n Jdi do prostoru řeka a použij prkno.";
                    } else {
                        plan.ukoncitHru();
                        return "";
                    }
                }
            case "město":
                return "K odemčení brány potřebuješ klíč. Pokud ho máš tak ho použij. \n Pokud ne, tak ho najdi.";
            case "chrám":
                return "Pro otevření chrámu potřebuješ artefakt. Pokud ho máš tak ho použij. \n Pokud ne, tak ho najdi.";
            default:
                if (predmety.isEmpty()) {
                    return "Tady nic nehledej člověče!";
                } else {
                    return "V prostoru se nachází: " + String.join(", ", predmety);
                }
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}