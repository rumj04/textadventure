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
        if (parametry.length > 0) {
            return "Příkaz prozkoumej se zadává bez parametrů.";
        }

        Prostor aktualniProstor = plan.getAktualniProstor();
        List<String> predmety = aktualniProstor.getPredmety();
        String odpoved;

        if (aktualniProstor.getNazev().equals("jeskyně")) {
            if (parametry.length == 0) {
                return "Hádanka: Co má čtyři nohy ráno, dvě odpoledne a tři večer? Zadej odpověď pomocí 'prozkoumej [odpověď]'.";
            } else {
                String odpovedNaHadanku = String.join(" ", parametry).toLowerCase();
                if (odpovedNaHadanku.equals("člověk")) {
                    plan.odemkniVychodRekaMesto();
                    return "Správně! Dozvěděl ses o ztraceném městě. Dostaneš se k němu cestou přes řeku pomocí prkna.";
                } else {
                    return "Špatná odpověď. Zkus to znovu.";
                }
            }
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
