package cz.vse.java.adventura.logika;


public class PrikazVezmi implements IPrikaz {
        private static final String NAZEV = "vezmi";
        private final HerniPlan plan;
        private final Inventar inventar;
        /**
         * Konstruktor třídy. Inicializuje herní plán a inventář.
         * @param plan herní plán, který obsahuje informace o aktuálním prostoru
         */

        public PrikazVezmi(HerniPlan plan, Inventar inventar) {
            this.plan = plan;
            this.inventar = inventar;
        }

        /**
         * Provádí příkaz "vezmi [předmět]". Zkontroluje, zda je předmět v aktuálním prostoru.
         * Pokud ano, přidá jej do inventáře a odstraní z prostoru.
         * @param parametry očekává se název předmětu
         * @return zpráva pro hráče
         */
        @Override
        public String provedPrikaz(String... parametry) {
            if (parametry.length == 0) {
                return "Nevím, co mám sebrat. Musíš zadat název předmětu.";
            }

            String nazevPredmetu = parametry[0];
            Prostor aktualniProstor = plan.getAktualniProstor();

            if (aktualniProstor.obsahujePredmet(nazevPredmetu)) {
                if (aktualniProstor.jeTruhla(nazevPredmetu)) {
                    aktualniProstor.odstranPredmet(nazevPredmetu);
                    inventar.pridatPredmet("artefakt");
                    return "Otevřel jsi truhlu a našel jsi artefakt! Přidal jsi ho do inventáře.";
                } else {
                    aktualniProstor.odstranPredmet(nazevPredmetu);
                    inventar.pridatPredmet(nazevPredmetu);
                    if (nazevPredmetu.equals("svitek")) {
                        return "Sebral jsi předmět: " + nazevPredmetu + "\nNa svitku je napsáno: Odpověď na hádanku je 'dech'.";
                    }
                    return "Sebral jsi předmět: " + nazevPredmetu;
                }
            } else {
                return "Předmět '" + nazevPredmetu + "' tu není.";
            }
        }

        /**
         * @return název příkazu (slovo, které hráč používá k vyvolání tohoto příkazu)
         */
        @Override
        public String getNazev() {
            return NAZEV;
        }

    }
