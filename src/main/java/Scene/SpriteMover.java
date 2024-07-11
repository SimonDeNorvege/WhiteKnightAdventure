package Scene;

import Character.Hero.Hero;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


import static Sprite.testRead.testImg;

public class SpriteMover {
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(createAndShowGUI());
    }

    private static Runnable createAndShowGUI() throws IOException {
        // Créer la fenêtre principale
        JFrame frame = new JFrame("Jeu avec Sprite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre

        // Créer le panneau où le sprite sera affiché
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        // Ajouter un écouteur pour les événements de touche
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gamePanel.handleKeyPress(e);
            }
        });

        // Rendre la fenêtre visible
        frame.setVisible(true);
        return null;
    }
}

class GamePanel extends JPanel {

    public BufferedImage spriteImage;
    private ArrayList<Character> actors;
    private int spriteX, spriteY;
    private final int spriteSpeed = 5;

    public GamePanel() throws IOException {

        //marche pas encore
        Hero soma = new Hero("Soma", 100, 10, 10, "peanut/movement.png");
        spriteImage = soma.getSpMovement().getFrameList().get(0);
        actors = new ArrayList<Character>();


        try {
            // Charger l'image du sprite
            spriteImage = ImageIO.read(getClass().getResource("/peanut/movement.png"));  // Assurez-vous que le fichier est dans le dossier resources
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Initialiser la position du sprite
        spriteX = 100;
        spriteY = 100;

        // Créer un timer pour redessiner le panneau
        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e, characters, soma) {
                repaint();  // Redessiner le panneau toutes les 16 ms (environ 60 FPS)
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner le sprite
        g.drawImage(spriteImage, spriteX, spriteY, null);
    }

    public void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                soma.setSpCurrent() = soma.get
                spriteX -= spriteSpeed;  // Déplacer le sprite vers la gauche
                break;
            case KeyEvent.VK_RIGHT:
                spriteX += spriteSpeed;  // Déplacer le sprite vers la droite
                break;
            case KeyEvent.VK_UP:
                spriteY -= spriteSpeed;  // Déplacer le sprite vers le haut
                break;
            case KeyEvent.VK_DOWN:
                spriteY += spriteSpeed;  // Déplacer le sprite vers le bas
                break;
        }
        repaint();  // Redessiner le panneau après le déplacement du sprite
    }

    public ArrayList<Character> getActors() {
        return actors;
    }
}
