package cz.vse.java.adventura.logika;

import java.util.List;

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

        if (aktualniProstor.getNazev().equals("jeskyně")) {
            if (parametry.length == 0) {
                return "Hádanka: Jsem lehčí než pírko, ale žádný člověk mě neudrží déle než pár minut? Zadej odpověď pomocí 'prozkoumej [odpověď]'.";
            } else {
                String odpovedNaHadanku = String.join(" ", parametry).toLowerCase();
                if (odpovedNaHadanku.equals("dech")) {
                    plan.odemkniVychodRekaMesto();
                    return "Správně! Dozvěděl ses o ztraceném městě. Dostaneš se k němu cestou přes řeku pomocí prkna.";
                } else {
                    plan.ukoncitHru();
                    return "Špatně. Zůstal jsi uvězněný v jeskyni.";
                }
            }
        } else if (parametry.length > 0) {
            return "Příkaz prozkoumej se zadává bez parametrů.";
        } else if (aktualniProstor.getNazev().equals("chrám")) {
            odpoved = "Pro otevření chrámu potřebuješ artefakt. Pokud ho máš tak ho použij. \n Pokud ne, tak ho najdi.";
        } else if (predmety.isEmpty()) {
            odpoved = "Tady nic nehledej člověče!";
        } else {
            odpoved = "V prostoru se nachází: " + String.join(", ", predmety);
        }

        return odpoved;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}