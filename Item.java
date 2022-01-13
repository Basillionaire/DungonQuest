/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * A class representing the items of the game. Items have a name and description as well as the ability to be taken, expended or equipped.
 */
public class Item {
	
	private String name;
    private String description;
    private boolean takable;
    private boolean expendable;
    private boolean equippable;
/**
 * Constructs an Item with a String name and String description.
 * @param name A string representing the Item's name
 * @param description A string representing the Item's description.
 */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        takable = true;
        expendable = true;
        equippable = false;
    }

    /**
     * A getter which will return the name of the Item
     * @return A string representing the Item's name
     */
    public String getName() {
        return name; 
    }

    /**
     * A setter which sets the name of the Item
     * @param name A string to be passed that will update the name of the Item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter which will return the String description of the Item
     * @return a String representing the description of the Item.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Setter which will update the description of the Item
     * @param description A string representing the Item's description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * A setter which will update an item's takability boolean.
     * @param takable a boolean representing if an item can be taken or not.
     */
    public void setTakable(boolean takable) {
    	this.takable = takable;
    }
    /**
     * Returns a boolean representing if the item can be taken or not
     * @return a boolean
     */
    public boolean getTakable() {
    	return takable;
    }
    /**
     * Setter which sets an Item's ability to be expended
     * @param expendable a boolean representing the item's ability to be expended
     */
    public void setExpendable(boolean expendable) {
    	this.expendable = expendable;
    }
    /**
     * Getter which returns if the item can be expended or not
     * @return a boolean representing the item's ability to be expended
     */
    public boolean getExpendable() {
    	return expendable;
    }
    /**
     * Getter which returns if the item can be equipped or not
     * @return a boolean representing the item's ability to be equipped
     */
    public boolean getEquippable() {
    	return equippable;
    }
    /**
     * Setter which sets an Item's ability to be equipped
     * @param equippable a boolean representing the item's ability to be equipped
     */
    public void setEquippable(boolean equippable) {
    	this.equippable = equippable;
    }
    
    
    public String toString() {
		return name + " " + description + "\n";
	}
}
