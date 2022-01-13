package cs5004.finalproject;
/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */

/**
 * The BlueHall class extends Room and is room #6 in the map. The room item for this room is a FallenHero.
 */

public class BlueHall extends Room {
	/**
	 * Being a room a BlueHall has a String name, Game game, room item in this case a FallenHero, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case FallenHero
	 * @param hero A Hero who explores the room. 
	 */

	public BlueHall(String name, Game game, FallenHero item, Hero hero) {
		super(name, game, item, hero);
	}
	
	/**
	 * A method that moves north on the map. North of the BlueHall is the BunkHouse.
	 */
	@Override
	public void goNorth() {
		getGame().setCurrentRoom(5);
		
	}

	/**
	 * A method that moves south on the map. South of the BlueHall is the Armory.
	 */
	@Override
	public void goSouth() {
		getGame().setCurrentRoom(7);	
	}

	/**
	 * A method that moves east on the map. There is nothing east of the BlueHall so a message prints out saying so.
	 */
	@Override
	public void goEast() {
		System.out.println("There isn't anything this way");	
	}

	/**
	 * A method that moves west on the map. There is nothing west of the BlueHall so a message prints out saying so.
	 */
	@Override
	public void goWest() {
		System.out.println("There isn't anything this way");	
	}

	@Override
	public String roomDescription() {
		return "A hallway with blue tapestries decorating the walls, though now they look purple from all the bloodshed. Off to the left wall is the\n" +
	"body of one of the three heroes who came before you. To the north is a bunk house, to the south is an armory, but you can't go east or west.";
	}
}
