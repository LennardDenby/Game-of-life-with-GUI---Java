import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GrafiskBrukergrensesnitt extends JFrame implements Brukergrensesnitt{
    private Kontroll kontroll;
    JPanel configPanel;
    JButton startButton;
    JButton avsluttButton;
    GamePanel spill;
    JLabel antLevende;

    @Override
    public void init(Kontroll k) {
        kontroll = k;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }

        configPanel = new JPanel();
        startButton = new JButton("Start");
        avsluttButton = new JButton("Avslutt");
        spill = new GamePanel(kontroll.modell);
        antLevende = new JLabel("Antall levende: " + spill.antallLevende());
        
        this.setTitle("Game Of Life");

        class Avslutt implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }
        avsluttButton.addActionListener(new Avslutt());


        class Start implements ActionListener {
            Timer timer;
            boolean timerRunning;

            public Start() {
                timer = new Timer(2000, this);
                timer.setRepeats(true);
                timerRunning = false;
            }
            @Override
            public void actionPerformed (ActionEvent e) {
                if (e.getSource() == timer) run();
                else {
                    if (timerRunning) {
                        stopp();
                    }
                    else {
                        start();
                    }
                }
            }
            private void run() {
                spill.oppdater();
                antLevende.setText("Antall levende: " + spill.antallLevende());
            }
            private void start() {
                startButton.setText("Stopp");
                timerRunning = true;
                timer.start();
            }
            private void stopp() {
                startButton.setText("Start");
                timerRunning = false;
                timer.stop();
            }
        }
        
        startButton.addActionListener(new Start());

        configPanel.add(antLevende, BorderLayout.NORTH);
        configPanel.add(startButton, BorderLayout.NORTH);
        configPanel.add(avsluttButton, BorderLayout.NORTH);

        this.add(spill, BorderLayout.SOUTH);
        this.add(configPanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
