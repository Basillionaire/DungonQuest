/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * The MonsterLounge class extends Room and is room #1 in the map. The room item for this room is a Bronze Treasure Chest.
 */
public class MonsterLounge extends Room {

	/**
	 * Being a room a MonsterLounge has a String name, Game game, room item in this case TreasureChest, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case TreasureChest
	 * @param hero A Hero who explores the room. 
	 */
	public MonsterLounge(String name, Game game, TreasureChest item, Hero hero) {
		super(name,game, item, hero);
		}
	
	@Override
	public String roomDescription() {
		return "Monster Lounge" + "\nThis looks like a lounge where monsters gather after a long day of torturing heroes.\n"
				+ "There is a bronze chest in the center of the room.\n"
				+ "To the north is a red hallway and to the east is the entrance. Looks like you can't go west or south from here.";
		}
	
	/**
	 * A method for moving north on the map. North of the MonsterLounge is the RedHall.
	 */
	@Override
	public void goNorth() {
		getGame().setCurrentRoom(2);
		}
	
	/**
	 * A method for moving south on the map. There is nothing to the south so a message is printed saying so.
	 */
	
	@Override
	public void goSouth() {
		System.out.println("There isn't anything this way");
		}
	/**
	 * A method for moving east on the map. East of the MonsterLounge is the Entrance.
	 */
	
	@Override
	public void goEast() {
		getGame().setCurrentRoom(0);
		}
	
	/**
	 * A method for moving west on the map. There is nothing to the west so a message is printed saying so.
	 */
	
	@Override
	public void goWest() {
		System.out.println("There isn't anything this way");
		}
}
