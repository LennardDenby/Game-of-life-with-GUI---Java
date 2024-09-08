public class Verden {
    int rader;
    int kolonner;
    int genNr;
    Rutenett rutenett;

    public Verden(int rader, int kolonner) {
        this.rader = rader;
        this.kolonner = kolonner;
        this.genNr = 0;
        this.rutenett = new Rutenett(rader, kolonner);

        this.rutenett.fyllMedTilfeldigeCeller();
        this.rutenett.kobleAlleCeller();
    }
    public void tegn() {
       this.rutenett.tegnRutenett();
       System.out.println("Antall levende: " + this.rutenett.antallLevende());
       System.out.println("Generasjon nmr: " + this.genNr);
    }
    public void oppdatering() {
        for (int i = 0; i < this.rader; i++) {
            for (int j = 0; j < this.kolonner; j++) {
                this.rutenett.hentCelle(i, j).tellLevendeNaboer();
            }
        }
        for (int i = 0; i < this.rader; i++) {
            for (int j = 0; j < this.kolonner; j++) {
                this.rutenett.hentCelle(i, j).oppdaterStatus();
            }
        }
        this.genNr++;
    }
}
