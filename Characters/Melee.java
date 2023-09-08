/*
Mostafaa Abdelaziz B00875982
Assignment 3
 */
package Characters;
import Attacks.Attack;
import java.awt.Point;

public abstract class Melee extends RPGCharacter {
    //Constructors;
    private int maxEnergy;
    private int currentEnergy;

    /**
     * This method will read in values typed in by the User and be initialized to variables by "super" keyword and
     * maxEnergy by "this" keyword.
     * @param name saves the String inputed by the user to name and initialized.
     * @param strength saves the int inputed by the user to strength and initialized.
     * @param maxHP saves the int inputed by the user to maxHP and initialized.
     * @param position saves the Point inputed by the user to position of the character and initialized.
     * @param maxEnergy saves the int inputed by the user to maxEnergy and initialized.
     */
    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, 1, strength, maxHP, position);
        this.maxEnergy = maxEnergy;
        currentHP = maxHP;
        currentEnergy = maxEnergy;
    }
    // No need for Java Docs
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * This method will check whether the attack method is within the ArrayList
     * @param character Information about the character from the RPGCharacter class.
     * @param attackType attack method which will check from the Point class. Depending on the index it will
     *                   calculate which should it return.
     * @return  either -1,-2,-3 (attack method)
     */
    public int attack(RPGCharacter character, int attackType) {
        if (attackType < 0 || attackType > attackList.size()) {
            return -1;
        }
        else if ( attackList.get(attackType).getRange()<getPosition().distance(character.getPosition())) {
            return -2;
        }
        else if (attackList.get(attackType).getCost() > currentEnergy  || currentEnergy <= 0) {
            return -3;
        }
        Attack attacker = attackList.get(attackType);
        currentEnergy -= attacker.getCost();
        attacker.interactWithTarget(character, strength);
        return character.getCurrentHP();
    }
    @Override
    public String toString() {
        return String.format("%s \nEnergy: - %d/%d", super.toString(), currentEnergy, maxEnergy);
    }
}


