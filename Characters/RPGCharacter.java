/*
Mostafaa Abdelaziz B00875982
Assignment 3
 */
package Characters;
import Attacks.Attack;
import java.util.ArrayList;
import java.awt.Point;

public abstract class RPGCharacter{
 //Constructors.
 private String name;
 private int maxHP;
 private Point position;

 protected int currentHP;
 protected int intellect;
 protected int strength;
 protected ArrayList<Attack> attackList;

    /**
     * This method will be the main most important method in the whole package as this is where the user
     * will have the variables being read and get initialized by using the "this" keyword.
     * @param name saves the String inputed by the user to name and initialized.
     * @param intellect saves the int inputed by the user to intellect and initialized.
     * @param strength saves the int inputed by the user to strength and initialized.
     * @param maxHP saves the int inputed by the user to maxHP and initialized.
     * @param position saves the Point inputed by the user to position of the character and initialized.
     */
 public RPGCharacter(String name, int intellect, int strength,int maxHP, Point position){
     this.name  = name;
     this.maxHP = maxHP;
     currentHP = maxHP;
     this.intellect = intellect;
     this.strength = strength;
     this.position = position;
     attackList = new ArrayList<>();
 }
    // No need for Java Docs.
    public int getCurrentHP() {
        return currentHP;
    }
    // No need for Java Docs.
    public Point getPosition() {
        return position;
    }
    // No need for Java Docs.
    public int getMaxHP() {
        return maxHP;
    }
    // No need for Java Docs.
    public String getName() {
        return name;
    }

    /**
     * This method will allow the player to move around his character within the game.
     * @param x the horizontal axis where the user decides to move left or right.
     * @param y the vertical axis where the user decides to move up or down.
     */
    public void move(int x, int y){
     position.translate(x,y);
    }

    /**
     * This method will deduct the health of the player as it's getting hit with the attacks.
     * @param damageTaken the damage taken by the other player.
     * @return currentHP of the player.
     */
    public boolean takeDamage(int damageTaken) {
     if(this.currentHP-damageTaken <=0){
         currentHP = 0;
         return false;
     }
     else{
         this.currentHP = currentHP -damageTaken;
         return true;
     }
    }

    /**
     * This method will be used when the user applies a healing spell or starts healing naturally.
     * @param healing the healing being gained by the spell or natural healing.
     * @return the currentHP of the player.
     */
    public boolean heal(int healing){
     if(this.currentHP + healing >= this.maxHP){
         currentHP = maxHP;
         return true;
     }
     else{
         currentHP +=healing;
         return false;
     }
    }

    /**
     * Abstract class for attack.
     * @param character
     * @param nbrs
     * @return
     */
    public abstract int attack(RPGCharacter character, int nbrs);

    /**
     * This method prints off to the user the different types of the attacks to use and select from 0-3.
     * @return The String of the attacks for the user to choose from.
     */
    public String getAttacks(){
        String text = "";
        for (int i = 0; i < attackList.size(); i++) {
            text +=(i + " - " +attackList.get(i).toString() + "\n");
        }
        return text;
    }
    // No need for Java Docs.
    public String toString(){
        return String.format("%s (%s) - %d/%d",
                this.getName(),
                this.getClass().getSimpleName(),
                this.getCurrentHP(),
                this.getMaxHP());
    }
}