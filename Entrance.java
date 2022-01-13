/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;

import java.util.LinkedList;
import java.util.Scanner;
/**
 * The Entrance of the Dungeon extends Room and is room number 0 on the map. The room item for the Entrance is a BossDoor 
 *
 */
public class Entrance extends Room {
	public BossDoor item;
	/**
	 * Being a room an Entrance has a String name, Game game, room item in this case BossDoor, and Hero who explores the room
	 * @param name A string representing the name of the room.
	 * @param game A Game object the room is a part of.
	 * @param item A room item in this case BossDoor
	 * @param hero A Hero who explores the room. 
	 */
	public Entrance(String name, Game game, BossDoor item, Hero hero) {
		super(name, game, item, hero);
		this.item=item;
	}
	
	public String roomDescription() {
		return "You are in the Entrance of the Demon King Dabura's dungeon. There are bound to be lots of monsters past this room, but\n" +
	"this room appears safe. To the north is a terrifying looking door, with pictures of demons torturing humans. That must be where Dabura awaits.\n" +
				"To the East and West are open rooms to explore and to the South is the exit, but heroes don't leave until the work is done.";
	}

	/**
	 * A method for moving north on the map. North of the Entrance is the BossRoom but the player can only go north is the door is unlocked.
	 */
	@Override
	public void goNorth() {
		System.out.println(getItem().getDescription());
		item.openDoor(hero);
		if(item.getLocked()==true) {
			System.out.println("Unfortunately the door is locked without the key");	
		}
		else {
			getGame().setCurrentRoom(8);
		}
	}

	/**
	 * A method for moving south on the map. There is nothing to the south so a message is printed saying so.
	 */
	@Override
	public void goSouth() {
		System.out.println("The exit is the only thing to the South. A hero never walks away from a challenge. You choose to stay put.");
	}

	/**
	 * A method for moving east on the map. East of the entrance is the Armory.
	 */
	@Override
	public void goEast() {
		getGame().setCurrentRoom(7);
	}

	/**
	 * A method for moving west on the map. West of the entrance is the Monster Lounge.
	 */
	@Override
	public void goWest() {
		getGame().setCurrentRoom(1);
	}
	/**
	 * Overrides the monster fight method of Room. No fight will occur as the entrance is a safe zone.
	 */
	@Override
	public void monsterFight(LinkedList<Monster> MonsterList, Hero hero, Scanner in) {
		System.out.println("This is a safe area no Monsters in sight");
	}
}

