import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePanel extends JPanel {
    Verden verden;
    Celle[][] brett;
    int rader;
    int kolonner;
    CelleKnapp[][] cellButtons;

    public GamePanel (Verden v) {
        verden = v;
        brett = verden.rutenett.rutene;
        rader = brett.length;
        kolonner = brett[0].length;
        cellButtons = new CelleKnapp[rader][kolonner];

        GridLayout grid = new GridLayout(rader, kolonner);
        this.setLayout(grid);
        addButtons();
    }

    private void addButtons() {
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                CelleKnapp button = new CelleKnapp(i, j, verden.rutenett);

                class OppdaterKnapp implements ActionListener {
                    @Override
                    public void actionPerformed (ActionEvent e) {
                        button.inverterStatustegn();
                    }
                }

                button.addActionListener(new OppdaterKnapp());
                cellButtons[i][j] = button;
                this.add(button);
            }
        }
    }
    public void oppdater() {
        verden.oppdatering();
        oppdaterKnapper();
    }
    private void oppdaterKnapper() {
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                cellButtons[i][j].oppdaterText();
            }
        }
    }
    public int antallLevende() {
        return verden.rutenett.antallLevende();
    }

}
