/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;

import java.util.Random;

/** 
 * An abstract class that is the basis for every character. Characters have names, hitPoints, strength, experience and are alive
 * so long as their HP is above 0.
 */

abstract class Character {
	protected String name;
	protected int hitPoints;
	protected int strength;
	protected int exp;
	protected boolean alive;
	protected boolean equipped;

		/**
		* Construct a character object initializing all variables other than alive and equipped
		* @param name A string representing the character's name
		* @param hitPoints An integer representing the initial set of hitPoints for our character
		* @param strength An integer representing the initial strength of our character.
		* @param exp An integer representing the amount of experience points the Character has.  
		*/
	public Character(String name, int hitPoints, int strength, int exp) {
		alive = true;
		equipped = true;
		this.name=name;
		this.hitPoints=hitPoints;
		this.strength=strength;
		this.exp=exp;
		}
		
	/**
	* sets a character's HP between 1 and 999 if the HP is set to 0 the character is dead and alive status changes to false
	* @param hitPoints an integer representing how many HitPoints the character has.
	*/
	public void setHitPoints(int hitPoints) {
		
		if (hitPoints > 999) {
			this.hitPoints=999;
			}
			
		else if (hitPoints <=0) {
			this.hitPoints = 0; 
			alive = false;
			}
			
		else {
			this.hitPoints=hitPoints;
			}
		}
		
	/**
	* Sets the character's strength.
	* @param strength an integer representing the amount of strength the character has
	*/
	public void setStrength(int strength) {
		this.strength=strength;
		}
	/**
	* Sets the character's name
	* @param name a string representing the character's name 
	*/

	public void setName(String name) {
		this.name=name;
		}
	/**
	* Sets how much experience the character has. Heroes will gain exp from winning fights. Monsters will give exp to the hero.
	* @param exp an integer that will become the amount of experience the character has.
	*/
	public void setExp(int exp) {
		this.exp=exp;
		}
		
	/**
	* A method for returning the amount of HitPoints the character has
	* @return an integer representing how much HP the character has
	*/
	public int getHitPoints() {
		return hitPoints;
		}
		
	/**
	* A method for returning the character's name 
	* @return name a string representing the character's name 
	*/
	public String getName() {
		return name;
		}
		
	/**
	* A method for returning the strength the character has
	* @return an integer representing strength
	*/
	public int getStrength() {
		return strength; 
		}
		
	/**
	* A method for returning the experience the character has
	* @return an integer representing experience
	*/
	public int getExp() {
		return exp;
		}
	/**
	* A method that will return true or false based on if the character's HP is 0 or not
	* @return a boolean representing alive status
	*/
	public boolean isAlive() {
		return alive;
		}
	
	/**
	 * Setter which will set the equipped status of the hero
	 * @param equipped a boolean representing if the hero has a weapon equipped or not
	 */
	public void setEquippedStatus(boolean equipped) {
		this.equipped=equipped;
	}
		
	/**
	 * Getter which returns true or false based on equipped status. A false equipped status means the hero does not have an equipped weapon.
	 * @return a boolean representing equipped status
	 */

	public boolean getEquippedStatus() {
		
		return equipped;
		}
		
	/**
	* Represents an unarmed attack that does random damage between 1 and the character's strength.
	* @return A random damage amount.
	*/
		
	public int attack() {
		Random r1 = new Random();
		return r1.nextInt(strength-1) + 1;
		}
		
		
	/** 
	* Takes in a damage amount and deduct the character's HP accordingly
	* @param damage the amount of damage taken
	*/
	public void takeDamage(int damage) {
		setHitPoints(hitPoints - damage);
		}

	public String toString() {
		return name + " HitPoints: " + hitPoints + " Strength: " + strength + " EXP: " + exp;
		}
}
