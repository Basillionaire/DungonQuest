/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * A Monster extends Character and has a name, hitPoints, strength and experience. Monsters will be the type of Character the Hero will fight
 */
public class Monster extends Character {
	private Weapon equippedWeapon;

	/**
	 * Constructs a Monster. A monster has a name, hitPoints, strength and experience.
	 * @param name A string representing the Monster's name
	 * @param hitPoints An integer representing the amount of life a monster has
	 * @param strength An integer representing the strength of the monster.
	 * @param exp An integer representing how much experience the monster will give if defeated.
	 */
	public Monster(String name, int hitPoints, int strength, int exp) {
		super(name, hitPoints, strength, exp);
		setEquippedStatus(false);
	}
	/**
	 * Constructs a Monster. A monster has a name, hitPoints, strength and experience, and equippedWeapon.
	 * @param name A string representing the Monster's name
	 * @param hitPoints An integer representing the amount of life a monster has
	 * @param strength An integer representing the strength of the monster.
	 * @param exp An integer representing how much experience the monster will give if defeated.
	 * @param equippedWeapon A weapon that is equipped to the Monster.
	 */
	public Monster(String name, int hitPoints, int strength, int exp, Weapon equippedWeapon) {
		super(name, hitPoints, strength, exp);
		this.equippedWeapon=equippedWeapon;
	}
	/**
	 * Returns a random element from the list of taunts the monster will say before attacking.
	 * @return a String taunt the monster has to the hero
	 */
	public String taunt() { 
	    
		List<String> tauntList = new ArrayList<>();
	    tauntList.add("Give up already");
	    tauntList.add("Weakling");
	    tauntList.add("You can't beat me");
	    tauntList.add("Time to die");
	    tauntList.add("You've already lost");
	    tauntList.add("Worthless peon");
	    tauntList.add("Fall to my might");
	    tauntList.add("I thought you were supposed to be strong");
	    Random rand = new Random();
	    
	    return tauntList.get(rand.nextInt(tauntList.size()));
	}
	/**
	 * The attack method of the Monster. Before attacking they say a taunt then attack with a random amount from 1 to their strength
	 */
	@Override
	public int attack()
	{
		System.out.println(taunt());
		Random r1 = new Random();
		return r1.nextInt(strength-1) + 1;
	}
	
	public int attackWithWeapon() {
		System.out.println(taunt());
		if (equippedWeapon.getDurability() == 0) {
			System.out.println("This weapon is broken sorry.");
			return 0;
			}
		Random r1 = new Random();
		return r1.nextInt(strength-1) + 1 + equippedWeapon.weaponAttack();
		}
	
	@Override
	public String toString()
	{
		return name + " HitPoints: " + hitPoints + " Strength :" + strength + " Exp :" + exp;
	}


	
}
