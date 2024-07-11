package Character.Monster;

import Character.Character;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Monster extends Character {
    public Monster(String name, int health, int mana, int damage, String filePath) {
        super(health, damage, mana);
    }

    public Monster createZombie()
    {
        return (new Monster("Zombie", 100, 0, 1, "zombie.png"));
    }

    public Monster createGhost()
    {
        return (new Monster("Ghost", 50, 0, 2, "ghost.png"));
    }
}
