/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;

import java.util.Random;

/**
 * A class representing a Weapon. A weapon extends Item and has a name, description, strength, and durability.
 */
public class Weapon extends Item {
	private int durability;
	private int strength;

	/**
	 * Constructs a Weapon object that has a String name, int strength, int durability, and Hero hero. Initializes expendable to false and
	 * equippable to true
	 * @param name the name of the weapon
	 * @param description the weapon's description
	 * @param strength the strength of the weapon
	 * @param durability the durability of the weapon. If durability hits 0 the weapon breaks and is unusable 
	 */
	
	public Weapon(String name, String description, int strength, int durability) {
		super(name, description);
		this.strength = strength;
		this.durability = durability;
		setExpendable(false);
		setEquippable(true);
	}
	/**
	 * Setter which sets the strength of the weapon
	 * @param strength An integer representing strength of the weapon.
	 */
	public void setStrength(int strength) {
		this.strength=strength;
		}
	
	/**
	 * Setter which sets the durability of the weapon
	 * @param durability An integer representing durability of the weapon.
	 */
	public void setDurability(int durability) {
		
		if (durability > 999) {
			this.durability=999;
			}
		
		else if (durability <= 0) {
			this.durability = 0; 
			}
		else {
			this.durability=durability;
			}
		}
	
	/**
	 * Getter which will return the Weapon's strength
	 * @return an Integer representing the Weapon's strength
	 */
	public int getStrength() {
		return strength;
		}
	
	/**
	 * Getter which will return the Weapon's durability
	 * @return an Integer representing the Weapon's durability
	 */
	public int getDurability() {
		return durability;
		}
	
	/**
	 * An attack method every weapon has does random damage between 1 and the weapon's strength. 
	 * Each use decreases durability. If durability becomes 0 the weapon does 0 damage. 
	 * @return damage an integer representing the amount of damage the weapon inflicts
	 */
	public int weaponAttack() {
		
		int damage = 0;
		
		Random r1 = new Random();
		
		if (durability > 0) {
			damage = r1.nextInt(strength-1) + 1;
			setDurability(durability - 1);
			if (durability == 0) {
				System.out.println("Your weapon broke, but the attack went through");
				}
			}
		
		else if (durability <= 0) {
			System.out.println("You can't fight with a broken weapon");
			damage = 0;	
			}
		
		return damage;
		}
	
	@Override
	public String toString() {
	return getName() + " " + getDescription() + " Strength: " + strength + " Durability: " + durability + "\n";
	}
}
