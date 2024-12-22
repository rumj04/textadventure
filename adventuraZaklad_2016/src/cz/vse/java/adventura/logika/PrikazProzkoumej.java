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
        if (predmety.isEmpty()) {
            odpoved = "Tady nic nehledej člověče!";
        } else {
            odpoved = "V místnosti je možné prozkoumat tyto předměty: " + String.join(", ", predmety);
        }

        return odpoved;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
