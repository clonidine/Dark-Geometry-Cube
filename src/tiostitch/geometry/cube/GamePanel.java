package tiostitch.geometry.cube;

import tiostitch.geometry.cube.controllers.CharController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final ImageIcon background = new Main().getBackDraw();
    private final CharController player = new Main().getPlayer();

    private static final int GAME_FPS = 60;
    private static final int GAME_UPDATE_DELAY = 1000;

    public GamePanel() {
        startGameTicks();
    }

    private void startGameTicks() {
        new Timer(GAME_UPDATE_DELAY / GAME_FPS, e -> updateGame()).start();
    }

    private void updateGame() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (player.getY() <= -40) {
            final Font font = new Font("BOLD", Font.BOLD, 60);

            g2.setFont(font);
            g2.setColor(Color.RED);
            g2.drawString("VOCÊ GANHOU!", 20, 160);

            removeKeyListener(new Main().getKeyController());
            return;
        }

        g2.drawImage(background.getImage(), 0, 0, 510, 408, null);

        g2.setColor(new Color(104, 255, 61));
        g2.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }
}
