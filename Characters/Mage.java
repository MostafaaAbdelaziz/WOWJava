/*
Mostafaa Abdelaziz B00875982
Assignment 3
 */
package Characters;
import java.awt.Point;
import Attacks.DamageSpell;
import Attacks.MeleeAttack;

/**
 * Mage class extending from the Caster class.This method will read in values typed in by the User and be initialized
 * to variables by "super" keyword.
 */
public class Mage extends Caster{
    public Mage(String name, int intellect, int maxHP,Point Position, int maxMana){
        super(name, intellect, maxHP,Position,maxMana);
        /*Adding the types of attack the user can choose from the list to attack the other player.
            4 values should be inserted for cost, name, damage,range
         */
        attackList.add(new MeleeAttack(0,"Staff",3,3));
        attackList.add(new DamageSpell(20,"Fire Ball",10,20));
        attackList.add(new DamageSpell(15,"Frost Ball",7,15));
        attackList.add(new DamageSpell(30,"Lightning",15,20));
    }

}
