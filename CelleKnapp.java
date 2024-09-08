import javax.swing.*;

public class CelleKnapp extends JButton {
    int rad;
    int kolonne;
    Rutenett rutenett;
    String statustegn;
    Celle celle;

    public CelleKnapp(int r, int k, Rutenett ruter) {
        statustegn = null;
        rad = r;
        kolonne = k;
        celle = ruter.rutene[rad][kolonne];

        this.setText(hentStatustegn());
    }
    private String hentStatustegn() {
        return String.valueOf(celle.hentStatusTegn());
    }
    public void oppdaterText() {
        this.setText(hentStatustegn());
    }
    public void inverterStatustegn() {
        if (celle.erLevende()) {
            celle.settDoed();
            this.setText(hentStatustegn());
        } else {
            celle.settLevende();
            this.setText(hentStatustegn());
        }
    }
}
