    package cz.vse.java.adventura.logika;



    public class PrikazPouzij implements IPrikaz {
        private static final String NAZEV = "použij";
        private final HerniPlan plan;
        private final Inventar inventar;

        /**
         * Konstruktor třídy. Přijímá herní plán a inventář.
         *
         * @param plan herní plán, který obsahuje informace o aktuálním prostoru
         */
        public PrikazPouzij(HerniPlan plan, Inventar inventar) {
            this.plan = plan;
            this.inventar = inventar;
        }

        /**
         * Provádí příkaz "pouzij [predmet]". Ověřuje, zda hráč má předmět v inventáři
         * a zda ho může použít v aktuální lokaci.
         * @param parametry očekává se název předmětu
         * @return zpráva pro hráče
         */
        @Override
        public String provedPrikaz(String... parametry) {
            if (parametry.length == 0) {
                return "Nevím, co mám použít. Zadej 'pouzij [predmet]'.";
            }

            String nazevPredmetu = parametry[0];
            Prostor aktualniProstor = plan.getAktualniProstor();

            // Kontrola, zda hráč má předmět v inventáři
            if (!inventar.obsahujePredmet(nazevPredmetu)) {
                return "Nemáš předmět '" + nazevPredmetu + "' v inventáři.";
            }

            // Specifická logika pro použití předmětů v aktuálním prostoru
            switch (nazevPredmetu) {
                case "prkno":
                    if (aktualniProstor.getNazev().equals("řeka")) {
                        inventar.odstranPredmet("prkno");
                        plan.odemkniVychodRekaMesto();
                        return "Položil jsi prkno a vytvořil lávku přes řeku. Nyní můžeš jít do města.";
                    } else {
                        return "Prkno nelze použít zde.";
                    }
                case "artefakt":
                    if (aktualniProstor.getNazev().equals("chrám")) {
                        inventar.odstranPredmet("artefakt");
                        aktualniProstor.pridatPredmet("poklad");
                        return "Odemkl jsi chrám a našel poklad! Gratuluji, dokončil jsi hru!";
                    } else {
                        return "Artefakt nelze použít zde.";
                    }
                default:
                    return "Předmět '" + nazevPredmetu + "' nelze použít.";
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