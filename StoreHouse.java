/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * The StoreHouse class extends Room and is room #4 in the map. The room item for this room is a Potion.
 */
public class StoreHouse extends Room {
	/**
	 * Being a room a StoreHouse has a String name, Game game, room item, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case a potion
	 * @param hero A Hero who explores the room. 
	 */
	public StoreHouse(String name, Game game, Item item, Hero hero) {
		super(name, game, item, hero);
		}
	
	/**
	 * A method for moving north on the map. There is nothing to the north so a message is printed saying so.
	 */
	
	@Override
	public void goNorth() {
		System.out.println("There isn't anything this way");
		} 
	
	/**
	 * A method for moving south on the map. There is nothing to the south so a message is printed saying so.
	 */
	
	@Override
	public void goSouth() {
		System.out.println("There isn't anything this way");
		}

	/**
	 * A method for moving east on the map. East of the StoreHouse is the BunkHouse.
	 */
	
	@Override
	public void goEast() {
		getGame().setCurrentRoom(5);
		}

	/**
	 * A method for moving west on the map. West of the StoreHouse is the KingBedChamber.
	 */
	
	@Override
	public void goWest() {
		getGame().setCurrentRoom(3);
		}

	@Override
	public String roomDescription() {
		return "This must be your lucky day. It looks like the monsters store all their potions here. On second glance though most don't seem to be\n" +
	"safe for human consumption. There is however one on a table to off to the side. To the west is an elaborate bedroom and to the east is a community\n"
				+"bunkhouse You can't go north or south from here.";
		}
}
