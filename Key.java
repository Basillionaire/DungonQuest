/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * A Key class which extends Item. Keys have a name, description and color. Keys are used to unlock either Treasure Chests or Doors.
 */
public class Key extends Item {
	private String color;

	/**
	 * Constructs a Key object with a name, description and color
	 * @param name A String representing the name of the Key
	 * @param description A String representing the description of the Key
	 * @param color A String representing the color of the Key
	 */
	public Key(String name, String description, String color) {
		super(name, description);
		this.color=color;
	}
	/**
	 * A Setter which sets the color of the Key
	 * @param color A string that will update the color of the Key
	 */
	public void setColor(String color) {
		this.color=color;
	}
	/**
	 * A getter which returns the color of the Key
	 * @return A string representing the Key's color
	 */
	public String getColor() {
		return color; 
	}
	
	@Override
	public String getDescription() {
		return "An old looking key made of " + getColor() + " It must go to a chest of the same type."; 
	}
	
	@Override
	public String toString() {
		return getName() + " " + getDescription() + " " + color;
	}
	
}
