/*
Mostafaa Abdelaziz B00875982
Assignment 3
 */
package Characters;
import java.awt.Point;
import Attacks.DamageSpell;
import Attacks.MeleeAttack;
import Attacks.HealingSpell;
import Attacks.Resurrection;

/**
 * Priest class extending from the Caster class.This method will read in values typed in by the User and be initialized
 * to variables by "super" keyword.
 */
public class Priest extends Caster{
    public Priest(String name, int intellect, int maxHP,Point Position, int maxMana){
        super(name, intellect, maxHP,Position,maxMana);
        /*Adding the types of attack the user can choose from the list to attack the other player.
            4 values should be inserted for cost, name, damage,range
         */
        attackList.add(new MeleeAttack(0, "Wand", 3,3));
        attackList.add(new DamageSpell(10, "Smite", 10,7));
        attackList.add(new HealingSpell(20,"Flash Heal",15,15));
        attackList.add(new Resurrection());
    }

}
