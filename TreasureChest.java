/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * A TreasureChest extends Item and has a name, description, color, loot inside and appropriate key. 
 */
public class TreasureChest extends Item {
	private String color;
	private Item loot;
	private Key key;
	private boolean locked;
	
	/**
	 * Constructs a TreasureChest with a name, description, color, loot and key 
	 * @param name A String representing the name of the TreasureChest
	 * @param description A String representing the description of the TreasureChest
	 * @param color A String representing the color of the TreasureChest
	 * @param loot An item that is inside the TreasureChest
	 * @param key A key that is used to unlock the treasure chest if they are the same color
	 */
	public TreasureChest(String name, String description, String color, Item loot, Key key) {
		super(name, description);
		this.color=color;
		this.loot=loot;
		this.key=key;
		setTakable(false);
		setExpendable(false);
		locked=true;
		} 
	/**
	 * Setter which sets the TreasureChest's color
	 * @param color A string representing the TreasureChest's color
	 */
	
	public void setColor(String color) {
		this.color=color;
		}
	
	/**
	 * A getter which returns the color of the TreasureChest
 	 * @return A string representing the color of the TreasureChest
	 */
	
	public String getColor() {
		return color;
		}
	
	/**
	 * A setter which sets the loot of the TreasureChest
	 * @param loot An item that the TreasureChest is holding.
	 */
	
	public void setLoot(Item loot) {
		this.loot=loot;
		}
	
	/**
	 * A getter which returns the Loot of the TreasureChest
 	 * @return An Item representing the loot of the TreasureChest
	 */
	
	public Item getLoot() {
		return loot;
		}
	
	/**
	 * A setter which sets the Key of the TreasureChest
	 * @param key A Key that belongs to the TreasureChest.
	 */
	public void setKey(Key key) {
		this.key=key;
		}
	
	/**
	 * A getter which returns the Key of the TreasureChest
 	 * @return the Key of the TreasureChest
	 */
	
	public Key getKey() {
		return key;
		}
	/**
	 * A setter which sets the locked status of the TreasureChest
	 * @param locked a boolean that represents the lock status of the TreasureChest.
	 */
	public void setLocked(boolean locked) {
		this.locked=locked;
		}
	/**
	 * A getter which returns the locked status of the TreasureChest
	 * @return a boolean representing the locked status of the TreasureChest
	 */
	public boolean getLocked() {
		return locked;
		}
	/**
	 * Opens the TreasureChest by changing the locked status to false, removes the key from the hero's inventory and says the loot inside
	 * @param hero The hero whose inventory the Key will be removed from
	 * @param key The key that's color will be compared to the color of the chest.
	 */
	public void openChest(Hero hero, Key key) {

		if(key.getColor()==this.getColor()) {
			setLocked(false);
			hero.getInventory().remove(key);
			System.out.println("You unlocked the chest. Inside you find " + loot.getName());
			}
		else {
			System.out.println("You need to find the correct key to this chest first, hero");
			}
		}

	@Override
	public String getDescription() {
			System.out.println("A beautiful " + getColor() + " Treasure Chest.");
			if(getLocked()==true) {
				return "You don't know what treasure is inside. You'll need to unlock it first.";
				}
			else {
				return "You already opened this chest.";
				}
			}
	
	@Override
	public String toString() {
		return getName() + " " + getDescription();
		}
}
