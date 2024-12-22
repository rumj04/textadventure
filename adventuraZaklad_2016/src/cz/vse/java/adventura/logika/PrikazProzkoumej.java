package cz.vse.java.adventura.logika;

import java.util.stream.Collectors;

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
        String vychody = aktualniProstor.getVychody().stream()
                .map(Prostor::getNazev)
                .collect(Collectors.joining(", "));

        return "Jsi v prostoru: " + aktualniProstor.getNazev() +
                "\nMůžeš se vydat do: " + vychody;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
