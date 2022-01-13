package cs5004.finalproject;
/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */

/**
 * The BossDoor class extends Item. A BossDoor has a name, description, locked boolean, and Key which is needed to unlock the door. 
 */

public class BossDoor extends Item {
	private boolean locked;
	private Key key;

	/**
	 * The BossDoor has a String name, String description, and Key key. 
	 * @param name A string representing the name of the item
	 * @param description A string description of the item
	 * @param key The specific Key that goes to the lock of the BossDoor
	 */
	public BossDoor(String name, String description, Key key) {
		super(name, description);
		this.key=key;
		locked = true;
		setTakable(false);
		setExpendable(false);
	}
	
	/**
	 * A setter method which sets the locked boolean to true or false
	 * @param locked a boolean representing if the door is locked or not
	 */
	
	public void setLocked(boolean locked) {
		this.locked=locked; 
	}
	
	/**
	 * A getter method which returns the locked status of the BossDoor
	 * @return the locked boolean status
	 */
	public boolean getLocked() {
		return locked;
	}
	
	/**
	 * A setter method which sets the Key of the BossDoor
	 * @param key a Key representing the key needed by the BossDoor
	 */
	
	public void setKey(Key key) {
		this.key=key;
	}
	
	/**
	 * A getter method which returns the key of the BossDoor
	 * @return the Key of the BossDoor
	 */
	public Key getKey() {
		return key;
	}
	
	@Override
	public String getDescription() {
		return "A terrifying looking door, with pictures of demons torturing humans. Through this door Dabura awaits.";
	}
	
	/**
	 * A method that will change the locked status of the BossDoor to true if the appropriate key is located in the Hero's inventory.
	 * @param hero The hero whose inventory will be checked for the key.
	 */
	public void openDoor(Hero hero) {
		if (hero.getInventory().contains(key)) {
			locked = false;
			hero.getInventory().remove(key);
			System.out.println("You unlocked the door to the Boss Chamber. Time to finish the fight");
		}
	}
}
