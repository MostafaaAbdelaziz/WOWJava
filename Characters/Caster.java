/*
Mostafaa Abdelaziz B00875982
Assignment 3
 */

package Characters;
import java.awt.Point;
import Attacks.*;
import java.util.ArrayList;

/**
 * Abstract class Caster which extends from RPGCharacter.
 */
public abstract class Caster extends RPGCharacter {
    // Constructors.
    private int maxMana;
    private int currentMana;

    /**
     * This method will read in values typed in by the User and be initialized to variables by "super" keyword and
     * maxMana by "this" keyword.
     * @param name saves the String inputed by the user to name and initialized.
     * @param intellect  saves the int inputed by the user to intellect and initialized.
     * @param maxHP saves the int inputed by the user to maxHP and initialized.
     * @param position  saves the Point inputed by the user to position of the character and initialized.
     * @param maxMana  saves the int inputed by the user to maxMana and initialized.
     */
    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1, maxHP, position);
        this.currentMana = maxMana;
        currentHP = maxHP;
        attackList = new ArrayList<>(4);
    }
    // No need Java docs
    public int getCurrentMana() {
        return currentMana;
    }

    /**
     *This method will check whether the attack method is within the ArrayList
     * @param character Information about the character from the RPGCharacter class.
     * @param attackIndex attack method which will check from the Point class. Depending on the index it will
     *                    calculate which should it return.
     * @return either -1,-2,-3 (attack method)
     */
    public int attack(RPGCharacter character, int attackIndex){
        if(attackIndex<0 || attackIndex>attackList.size()){
            return -1;
        }
        if(getPosition().distance(character.getPosition())>attackList.get(attackIndex).getRange()){
            return -2;
        }
        if(currentMana<attackList.get(attackIndex).getCost()){
            return -3;
        }
        Attack attacker = attackList.get(attackIndex);
        currentMana -= attacker.getCost();

        if(attacker instanceof HealingSpell){
            attacker.interactWithTarget(this,intellect);
        }
        else if(attacker instanceof MeleeAttack){
            attacker.interactWithTarget(character,0);
        }
        else{
            attacker.interactWithTarget(character,intellect);
        }
        return character.getCurrentHP();
    }
    // No need for Java Docs.
    @Override
    public String toString(){
        return String.format("%s\nMana: %d/%d", super.toString(), currentMana, getMaxHP());
    }
}
