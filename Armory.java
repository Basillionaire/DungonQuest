package cs5004.finalproject;
/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */

/**
 * The Armory class extends Room and is room #7 in the map. The room item for this room is a Silver Treasure Chest.
 */
public class Armory extends Room {

	/**
	 * Being a room an Armory has a String name, Game game, room item in this case TreasureChest, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case TreasureChest
	 * @param hero A Hero who explores the room. 
	 */
	public Armory(String name, Game game, TreasureChest item, Hero hero) {
		super(name, game, item, hero);
	}

	/**
	 * A method that moves north on the map. North of the Armory is the BlueHall.
	 */
	
	@Override
	public void goNorth() {
		getGame().setCurrentRoom(6);	
	}
	
	/**
	 * A method that moves south on the map. There is nothing south of the Armory so a message prints out saying so.
	 */
	
	@Override
	public void goSouth() {
		System.out.println("There isn't anything this way");	
	}

	/**
	 * A method that moves east on the map. There is nothing east of the Armory so a message prints out saying so.
	 */
	
	@Override
	public void goEast() {
		System.out.println("There isn't anything this way");	
	}
	
	/**
	 * A method that moves west on the map. West of the Armory is the Entrance.
	 */

	@Override
	public void goWest() {
		getGame().setCurrentRoom(0);	
	}
	
	@Override
	public String roomDescription() {
		return "This appears to be an armory where all the monsters store their weapons to take down adventurers.\n" +
	"One of the former heroes must have started a fire because there is nothing left, but ashes, and a silver treasure chest in the room's center.\n" +
				"To the north is a blue hallway and to the west is the entrance. Looks like you can't go East or South";
	}
}
