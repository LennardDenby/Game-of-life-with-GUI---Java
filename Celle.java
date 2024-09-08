public class Celle {
    boolean levende;
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle() {
        this.levende = false;
        this.naboer = new Celle[8];
        this.antNaboer = 0;
        this.antLevendeNaboer = 0;
    }
    public void settDoed() {
        this.levende = false;
    }
    public void settLevende() {
        this.levende = true;
    }
    public boolean erLevende() {
        return this.levende;
    }
    public char hentStatusTegn() {
        return (this.levende) ? 'O': '.';
    }
    public void leggTilNabo(Celle nyNabo) {
        this.naboer[this.antNaboer] = nyNabo;
        this.antNaboer++;
    }
    public char inverterStatus() {
        if (erLevende()) settDoed();
        else settLevende();
        
        return hentStatusTegn();
    }
    public void tellLevendeNaboer() {
        int levendeNaboer = 0;
        for (int i = 0; i < this.antNaboer; i++) {
            if (this.naboer[i].erLevende()) {
                levendeNaboer++;
            }
        }
        this.antLevendeNaboer = levendeNaboer;
    }
    public void oppdaterStatus() {
        if (this.erLevende()) {
            if ((this.antLevendeNaboer < 2) || (this.antLevendeNaboer > 3)) {
                this.settDoed();
            }
        } else {
            if (this.antLevendeNaboer == 3) {
                this.settLevende();
            }
        }
    }
}
