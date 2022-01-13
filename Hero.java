/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
import java.util.*;
import java.util.stream.Collectors;

/** 
 * The Hero class extends the Character class and has access to all Character methods as well as specific methods only the hero will have.
 * The hero will be the character the player controls.
 */
public class Hero extends Character {
	
	public int level;
	public LinkedList<Item> inventory;
	public Weapon equippedWeapon;
	
	
	/**
	 * Constructor for the Hero class. Heroes have a name, HP, strength, exp, level, inventory, an equipped weapon and an equipped status
	 * that is initialized to true.
	 * @param name A string representing the Hero's name
	 * @param hitPoints An integer representing the character's hitPoints
	 * @param strength An integer representing how strong the character is
	 * @param exp An integer representing how much experience the hero has. Defeating monsters increases exp.
	 * @param level An integer representing the character's level
	 * @param inventory A list of Items that the hero will carry with them.
	 * @param equippedWeapon The weapon equipped to the hero. Can be changed throughout the course of the game
	 */
	public Hero(String name, int hitPoints, int strength, int exp, int level, LinkedList<Item> inventory, Weapon equippedWeapon) {
		super(name, hitPoints, strength, exp);
		this.level=level;
		this.inventory=inventory;
		this.equippedWeapon=equippedWeapon;
		}
	
		/**
		 * Sets the heros level. This game the hero will be between levels 1 and 5.
		 * @param an integer that will be used to set the heros level
		 */
		public void setLevel(int level) {
			this.level=level;
			}
		/**
		 * A method that will return the current level of the hero
		 * @return an integer representing level
		 */
		public int getLevel() {
			return level;
			}
		
		/**
		 * Sets the equippedWeapon of the hero. If the weapon trying to be equipped is broken will not be allowed to be equipped.
		 * If the weapon trying to be equipped is not broken sets equipped status to false and equips
		 * @param equippedWeapon The weapon trying to be equipped
		 */
		
		public void setEquippedWeapon(Weapon equippedWeapon) {
			if(equippedWeapon.getEquippable()==false) {
				System.out.println("Cannot equip this item.");
			}
			if(equippedWeapon.getDurability()<=0) {
				System.out.println("Cannot equip a broken weapon");
			}
			else {
				System.out.println("Equipped " + equippedWeapon.getName());
				this.equippedWeapon=equippedWeapon;
				equipped=true;
			}
		}
		/**
		 * Returns the weapon currently equipped to the hero
		 * @return the hero's current equipped weapon
		 */
		public Weapon getEquippedWeapon() {
			
			return equippedWeapon;
		}
			
		/**
		 * Checks if the hero's equipped weapon is broken or not. To be called after a fight.
		 */
		public void checkEquippedWeapon() {
			if(equippedWeapon==null) {
				setEquippedStatus(false);
			}
			
			else if(equippedWeapon.getDurability()<=0) {
				System.out.println("This weapon is done for, unequipping and removing from inventory");
				setEquippedStatus(false);
				inventory.remove(equippedWeapon);
				equippedWeapon=null;
				}
			}
		/**
		 * Setter for creating the hero's inventory
		 * @param inventory a List of items the hero will have access to
		 */
		public void setInventory(LinkedList<Item> inventory) {
			this.inventory=inventory;
			}
		/**
		 * A method that returns the hero's inventory
		 * @return a List of Items representing the hero's inventory
		 */
		public LinkedList<Item> getInventory(){
			return inventory;
		}
		/**
		 * A method that will list off the names of the items in the player's inventory using a stream.
		 * @param Inventory the players inventory
		 */
		public void viewInventory() {
			if(inventory.isEmpty()) {
				System.out.println("Nothing in your inventory");
			}
			else {
				System.out.println("You are carrying");
				System.out.println(inventory.stream().map(x -> x.getName()).collect(Collectors.toList()));
			}
		}
		/**
		 * A method that allows the hero to view the toString of the item that is passed in.
		 * @param item The item that is to be viewed
		 */
		public void viewItem(Item item) {
			System.out.println(item.toString());
		}
		/**
		 * A method that allows a Hero to use an item. Usable items are potions and keys.
		 * @param item The item that is being attempted to be used
		 */
		public void useItem(Item item) {
			if(item.getExpendable() == true) {
				if(item.getName().equals("Potion")) {
					setHitPoints(getHitPoints() + 20);
					System.out.println("You've recovered HP. You're health is now: " + getHitPoints());
					inventory.remove(item);
				}
				else if(item.getName().contains("Key")) {
					System.out.println("Are you sure this is the right key?");
				}
			}
			else {
				System.out.println("This item is not expendable");
			}
		}
		/**
		 * A method that adds the passed in item to the inventory if it is takable
		 * @param item
		 */
		public void addItem(Item item) {
			if(item.getTakable()==true) {
				getInventory().add(item);
				System.out.println("Took the " + item.getName());
			}
			else {
				System.out.println("Can't add this item or nothing to add.");
			}
		}
			
		/**
		 * A method for doing a weapon based attack.
			* @param weapon the weapon the hero will use
			* @return a weapon based attack
			*/
		
		public int attackWithWeapon() {
			if (equippedWeapon.getDurability() == 0) {
				System.out.println("This weapon is broken sorry.");
				return 0;
				}
			Random r1 = new Random();
			return r1.nextInt(strength-1) + 1 + equippedWeapon.weaponAttack();
			}
	/**
	 * Method for leveling up the hero it will increase strength and hp on each level up. Max level is 5
	 */
	public void LevelUp() {
		
		if (exp < 250) {
			setLevel(1);
			setStrength(20);
			setHitPoints(25);
			}
		else if(exp >= 250 && exp < 500) {
			setLevel(2);
			setStrength(30);
			setHitPoints(50);
			}
		else if(exp >= 500 && exp < 750) {
			setLevel(3);
			setStrength(38);
			setHitPoints(70);
			}
		else if(exp >= 750 && exp < 1000) {
			setLevel(4);
			setStrength(45);
			setHitPoints(85);
			}
		else {
			setLevel(5);
			setStrength(60);
			setHitPoints(100);
			}
		}
	
	@Override
	public String toString() {
	return name + " HitPoints: " + hitPoints + " Strength: " + strength + " EXP: " + exp + " Level: " + level;
	}
}
