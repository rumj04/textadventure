package cz.vse.java.adventura.logika;

public class PrikazUtec implements IPrikaz {
    private static final String NAZEV = "uteč";
    private final HerniPlan plan;

    public PrikazUtec(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Prostor predchoziProstor = plan.getPredchoziProstor();
        if (predchoziProstor == null) {
            return "Nemáš kam utéct!";
        }
        plan.setAktualniProstor(predchoziProstor);
        return "Utekl jsi zpět do prostoru: " + predchoziProstor.getNazev();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
