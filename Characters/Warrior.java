/*
Mostafaa Abdelaziz B00875982
Assignment 3
 */
package Characters;
import java.awt.Point;
import Attacks.MeleeAttack;

/**
 * Warrior class extending from the Melee class.This method will read in values typed in by the User and be initialized
 * to variables by "super" keyword.
 */
public class Warrior extends Melee {
    public Warrior(String name, int strength, int maxHP, Point Position, int maxMana) {
        super(name, strength, maxHP, Position, maxMana);
        /*Adding the types of attack the user can choose from the list to attack the other player.
            4 values should be inserted for cost, name, damage,range
         */
        attackList.add(new MeleeAttack(0, "Punch", 5, 3));
        attackList.add(new MeleeAttack(3, "Slam", 5, 3));
        attackList.add(new MeleeAttack(20, "Charge", 30, 15));
    }
}