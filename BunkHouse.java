package cs5004.finalproject;
/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */

/**
 * The BunkHouse class extends Room and is room #5 in the map. The room item for this room is a FallenHero.
 */

public class BunkHouse extends Room {
	
	/**
	 * Being a room a BunkHouse has a String name, Game game, room item in this case a FallenHero, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case FallenHero
	 * @param hero A Hero who explores the room. 
	 */

	public BunkHouse(String name, Game game, FallenHero item, Hero hero) {
		super(name, game, item, hero); 
		}

	/**
	 * Goes north on the map if there is a room available. Otherwise prints a message saying so.
	 */
	@Override
	public void goNorth() {
		System.out.println("There isn't anything this way");
		}

	/**
	 * Goes south on the map if there is a room available. South of the BunkHouse is the BlueHall.
	 */
	@Override
	public void goSouth() {
		getGame().setCurrentRoom(6);
		}

	/**
	 * Goes east on the map if there is a room available. Otherwise prints a message saying so.
	 */
	@Override
	public void goEast() {
		System.out.println("There isn't anything this way");
		}

	/**
	 * Goes west on the map if there is a room available. West of the BunkHouse is the StoreHouse.
	 */
	@Override
	public void goWest() {
		getGame().setCurrentRoom(4);
		}

	@Override
	public String roomDescription() {
		return "This looks like the bunk house where all the monsters go to sleep for the night. You see 4 beds, so besides the Demon King there must\n" +
	"be 4 other monsters residing here. On the ground laying face down is the body of one of the heroes who came before you. To the west is\n"
	+ "a storehouse of some sort, to the south is a blue hallway, but you can't go north or east from here";
	}
}
