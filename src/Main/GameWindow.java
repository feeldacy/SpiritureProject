package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {

    public GameWindow(GamePanel gamePanel){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // kl keluar berhenti
        add(gamePanel);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setVisible(true);
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }
        });
    }
}
