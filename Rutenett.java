public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;

    public Rutenett(int rader, int kolonner) {
        this.antRader = rader;
        this.antKolonner = kolonner;
        this.rutene = new Celle[rader][kolonner];
    }
    public void lagCelle(int rad, int kolonne) {
        Celle nyCelle = new Celle();
        if (Math.random() <= 0.3333) {
            nyCelle.settLevende();
        }
        this.rutene[rad][kolonne] = nyCelle;
    }
    public void fyllMedTilfeldigeCeller() {
        for (int i=0; i < this.antRader; i++) {
            for (int j=0; j < this.antKolonner; j++) {
                this.lagCelle(i, j);
            }
        }
    }
    public Celle hentCelle(int rad, int kolonne) {
        if ((rad >= this.antRader) || (rad < 0)) {
            return null;
        }
        if ((kolonne >= this.antKolonner) || (kolonne < 0)) {
            return null;
        }
        return this.rutene[rad][kolonne];
    }
    public void tegnRutenett() {
        for (int i = 0; i<10; i++) {
            System.out.println();
        }
        for (Celle[] rad : this.rutene) {
            String linje = "";
            for (Celle celle : rad) {
                linje += celle.hentStatusTegn();
            }
            System.out.println(linje);
        }
    }
    public void settNaboer(int rad, int kolonne) {
        int[][] offsets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] offset : offsets) {
            Celle nabo = hentCelle(rad + offset[0], kolonne + offset[1]);
            if (nabo != null) {
                this.rutene[rad][kolonne].leggTilNabo(nabo);
            }
        }
    }
    public void kobleAlleCeller() {
        for (int i=0; i < this.antRader; i++) {
            for (int j=0; j < this.antKolonner; j++) {
                this.settNaboer(i, j);
            }
        }
    }
    public int antallLevende() {
        int antLevende = 0;
        for (int i=0; i < this.antRader; i++) {
            for (int j=0; j < this.antKolonner; j++) {
                if (this.rutene[i][j].erLevende()) {
                    antLevende++;
                }
            }
        }
        return antLevende;
    }

}
