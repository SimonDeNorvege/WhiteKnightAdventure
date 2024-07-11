package Character;

import Sprite.Sprite;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Character {

    private int maxHealth; //La vie max du character TODO : bonus de vie?
    private int currHealth; //La vie modifiable du character
    private int attack; //Les dommages
    private int mana; //La Mana
    private Sprite sprites; //spCurrent spriteFamily of the Character


    public Character(int health, int attack, int mana)
    {
        this.maxHealth = health;
        this.currHealth = health;
        this.attack = attack;
        this.mana = mana;

    }

    /**
     * Verifie si ce personnage à ses points de vie en dessous de zéro
     * @return
     */
    public boolean isDead()
    {
        return (getCurrHealth() > 0);
    }

    /**
     * Permet au character de prendre des dégats
     * TODO : gestion de l'armure
     * @param damage
     * @return la vie après avoir pris les dégats
     */
    public int takeDamage(int damage)
    {
        setCurrHealth(currHealth - damage);
        return (getCurrHealth());
    }


    //SPRITES

    private Sprite SpMovement;
    private Sprite SpAttack;
    private Sprite SpJump;
    private Sprite spCurrent;


    public Sprite getSpMovement() {
        return this.SpMovement;
    }

    public Sprite getSpAttack() {
        return this.SpAttack;
    }

    public Sprite getSpJump() {
        return this.SpJump;
    }

    public Sprite getCurrent() {
        return (spCurrent);
    }

    protected void setSpMovement(Sprite sp) {
        this.SpMovement = sp;
    }


    protected void setSpAttack(Sprite sp) {
        this.SpAttack = sp;
    }


    protected void setSpJump(Sprite sp) {
        this.SpJump = sp;
    }

    protected void setSpCurrent(Sprite sp) {this.spCurrent = sp;}

    //GETTER
    /**
     * permet de retourner la valeur courante de la vie du character
     * @return
     */
    public int getCurrHealth() {
        return currHealth;
    }

    /**
     * permet de retourner la valeur de l'attaque du character
     * @return
     */
    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Sprite getSprites() {
        return sprites;
    }

    //SETTER
    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setSprites(Sprite spriteFamily) {
        this.sprites = spriteFamily;
    }
}
