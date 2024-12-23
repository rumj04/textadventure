package cz.vse.java.adventura.logika;


public class PrikazVezmi implements IPrikaz {
        private static final String NAZEV = "vezmi";
        private final HerniPlan plan;
        /**
         * Konstruktor třídy. Inicializuje herní plán a inventář.
         * @param plan herní plán, který obsahuje informace o aktuálním prostoru
         */

        public PrikazVezmi(HerniPlan plan) {
            this.plan = plan;
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
                    plan.getInventar().pridatPredmet("artefakt");
                    return "Otevřel jsi truhlu a našel jsi artefakt!";
                } else {
                    aktualniProstor.odstranPredmet(nazevPredmetu);
                    plan.getInventar().pridatPredmet(nazevPredmetu);
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

        /**
         * Metoda vrací seznam sebraných předmětů (inventář).
         */
        public void getInventar() {
            return ;
        }
    }
