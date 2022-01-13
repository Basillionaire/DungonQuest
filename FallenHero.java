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
 * A FallenHero extends Item and has a name and description as well as a Linked List of Items representing their inventory. FallenHeroes can be looted
 * by the hero for items.
 */
public class FallenHero extends Item {
	private LinkedList<Item> inventory;

	/**
	 * Constructs a FallenHero with a String name, String description and LinkedList inventory 
	 * @param name a String representing the FallenHero's name
	 * @param description a String representing a description of the fallen hero.
	 * @param inventory a LinkedList inventory of Items that can be looted by the Hero
	 */
	public FallenHero(String name, String description, LinkedList<Item> inventory) {
		super(name, description);
		this.inventory=inventory; 
		setTakable(false);
		setExpendable(false);
	}
	
	/**
	 * A setter which sets the inventory of the FallenHero
	 * @param inventory a LinkedList which will update the Inventory of the Fallenhero
	 */
	public void setInventory(LinkedList<Item> inventory) {
		this.inventory=inventory;
	}
	/**
	 * A getter which returns a LinkedList representing the FallenHero's inventory
	 * @return a LinkedList of Items
	 */
	public LinkedList<Item> getInventory(){
		return inventory;
	}
	/**
	 * A method which returns a String description of the FallenHero including their name and what they were carrying.
	 */
	@Override
	public String getDescription() {

		System.out.println("One of the three heroes who came before you, " + getName());
		if(getInventory().isEmpty()) {
			return "You already took his items. Be sure to use them wisely";
		}
		return "He must be looking out for you beyond the grave. On his body you find " + getInventory().stream().map(x -> x.getName()).collect(Collectors.toList());
	}

}
