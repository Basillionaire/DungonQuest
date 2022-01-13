/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * The RedHall class extends Room and is room #2 in the map. The room item for this room is a FallenHero.
 */
public class RedHall extends Room {
	/**
	 * Being a room a RedHall has a String name, Game game, room item in this case a FallenHero, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case FallenHero
	 * @param hero A Hero who explores the room. 
	 */
	public RedHall(String name, Game game, FallenHero item, Hero hero) {
		super(name, game, item, hero);
		}
	
	/**
	 * A method for moving north on the map. North of the RedHall is the KingBedChamber.
	 */
	
	@Override
	void goNorth() {
		getGame().setCurrentRoom(3);
		}
	
	/**
	 * A method for moving south on the map. South of the RedHall is the MonsterLounge.
	 */
	
	@Override
	void goSouth() {
		getGame().setCurrentRoom(1);
		}

	/**
	 * A method for moving east on the map. There is nothing to the east so a message is printed saying so.
	 */
	@Override
	void goEast() {
		System.out.println("There isn't anything this way");
		}

	/**
	 * A method for moving west on the map. There is nothing to the west so a message is printed saying so.
	 */
	@Override
	void goWest() {
		System.out.println("There isn't anything this way");
		}

	@Override
	String roomDescription() {
		return "A hallway covered in red tapestries and carpets. You can pretend any blood shed here was just part of the decorum.\n"
				+ "On the right hand wall is the body of one of the former heroes who came before you. To the north is an elaborate\n" +
				"bedroom, to the south is a lounge area. Looks like you can't go west or east from here.";
		}
}
