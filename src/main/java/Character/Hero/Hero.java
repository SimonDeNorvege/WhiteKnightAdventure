package Character.Hero;

import Character.Character;
import Sprite.*;

import java.io.IOException;



public class Hero extends Character {

    public Hero(String name, int health, int mana, int damage, String mvFilepath) throws IOException {
        super(health, damage, mana);
        setSpMovement(new Sprite(mvFilepath, 32, 32));

    }

    @Override
    public boolean isDead() {
        return this.getCurrHealth() == 0;
    }

    @Override
    public int takeDamage(int damage) {
        return 0;
    }
}
