/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
/**
 * The KingBedChamber class extends Room and is room #3 in the map. The room item for this room is a Gold Treasure Chest.
 */
public class KingBedChamber extends Room {
	/**
	 * Being a room a KingBedChamber has a String name, Game game, room item in this case TreasureChest, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case TreasureChest
	 * @param hero A Hero who explores the room. 
	 */
	public KingBedChamber(String name, Game game, TreasureChest item, Hero hero) {
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
	 * A method for moving south on the map. South of the KingBedChamber is the RedHall
	 */
	@Override
	public void goSouth() {
		getGame().setCurrentRoom(2);
		}
	/**
	 * A method for moving east on the map. East of the KingBedChamber is the StoreHouse.
	 */
	@Override
	public void goEast() {
		getGame().setCurrentRoom(4);
		}

	/**
	 * A method for moving west on the map. There is nothing to the west so a message is printed saying so.
	 */
	@Override
	public void goWest() {
		System.out.println("There isn't anything this way");
		}

	@Override
	public String roomDescription() {
		return "This looks like the bed chamber of the Demon King Dabura. Despite his vile deeds his room is stunningly beautiful.\n"
				+ "You've never seen so much gold in your life and in the corner appears to be a gold treasure chest. To the south is\n"
				+ "a red hallway and to the east is a store house of some sort";
		}
}
