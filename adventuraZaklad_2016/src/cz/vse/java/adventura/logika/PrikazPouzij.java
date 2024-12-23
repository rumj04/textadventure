    package cz.vse.java.adventura.logika;



    public class PrikazPouzij implements IPrikaz {
        private static final String NAZEV = "použij";
        private final HerniPlan plan;
        private Inventar inventar;

        /**
         * Konstruktor třídy. Přijímá herní plán a inventář.
         * @param plan herní plán, který obsahuje informace o aktuálním prostoru
         */
        public PrikazPouzij(HerniPlan plan) {
            this.plan = plan;
        }

        /**
         * Provádí příkaz "pouzij [predmet] na [lokace]". Ověřuje, zda hráč má předmět
         * v inventáři a zda ho může použít v aktuální lokaci.
         * @param parametry očekávají se dva parametry: název předmětu a lokace
         * @return zpráva pro hráče
         */
        @Override
        public String provedPrikaz(String... parametry) {
            if (parametry.length < 2) {
                return "Nevím, [co] mám použít a [kde].";
            }

            String nazevPredmetu = parametry[0];
            String nazevLokace = parametry[1];
            Prostor aktualniProstor = plan.getAktualniProstor();


            // Kontrola, zda hráč má předmět v inventáři
            if (!inventar.vypisInventar().contains(nazevPredmetu)) {
                return "Nemáš předmět '" + nazevPredmetu + "' v inventáři.";
            }

            // Kontrola, zda je hráč ve správném prostoru
            if (!aktualniProstor.getNazev().equals(nazevLokace)) {
                return "Nejsi v lokaci '" + nazevLokace + "'.";
            }

            // Specifická logika pro použití předmětu
            if (nazevPredmetu.equals("prkno") && nazevLokace.equals("řeka")) {
                return "Položil jsi prkno a vytvořil lávku přes řeku.";
            } else if (nazevPredmetu.equals("artefakt") && nazevLokace.equals("chram")) {
                return "Odemkl jsi chrám a našel poklad! Gratuluji, dokončil jsi hru!";
            } else {
                return "Předmět '" + nazevPredmetu + "' nelze použít v prostoru '" + nazevLokace + "'.";
            }
        }


        @Override
        public String getNazev() {
            return NAZEV;
        }
    }

