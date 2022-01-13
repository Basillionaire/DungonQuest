package cs5004.finalproject;

import java.util.*;
/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */

/**
 * The BossRoom class extends Room and is room #8 in the map. The BossRoom is the final room of the dungeon containing all the other aspects of 
 * a room as well as a Monster Boss.
 */

public class BossRoom extends Room {

	private Monster boss;
	GameMusic musicObject = new GameMusic("Night-of-Fate.wav");
	GameMusic musicObject2 = new GameMusic("FFVII-Victory.wav");

	/**
	 * Constructs a BossRoom object. A BossRoom has a name, game, item, hero and boss.
	 * @param name A String representing the room's name
	 * @param game A Game object used to control music and move to different rooms
	 * @param item A Room item that is different depending on the room. A BossRoom can set this to null
	 * @param hero A hero who will explore the room and fight the Boss
	 * @param boss A Monster who is the final boss of the dungeon.
	 */
	public BossRoom(String name, Game game, Item item, Hero hero, Monster boss) {
		super(name, game, item, hero);
		this.boss=boss;
	}
	/**
	 * Setter which sets the Boss of the room
	 * @param boss the Monster object to be set as the boss
	 */
	public void setBoss(Monster boss) {
		this.boss=boss;
	}
	/**
	 * Getter which returns the Monster boss object
	 * @return the Monster boss of the room
	 */
	public Monster getBoss() {
		return boss;
	}
	
	@Override
	public String roomDescription() {
		return "The diabolical lair of the Demon King Dabura. Many adventurers have tried to make it here, but only you have been successful.\n" +
	"As you enter, the Demon King rises from his throne, smiles menacingly and challegnes you to an all out battle.";
	}
	/**
	 * Since this is the last room the player cannot choose a direction to go once they enter.
	 */
	@Override
	public void goNorth() {
		System.out.println("There's no running away");
		
	}
	/**
	 * Since this is the last room the player cannot choose a direction to go once they enter.
	 */
	@Override
	public void goSouth() {
		System.out.println("There's no running away");
		
	}
	/**
	 * Since this is the last room the player cannot choose a direction to go once they enter.
	 */
	@Override
	public void goEast() {
		System.out.println("There's no running away");
		
	}
	/**
	 * Since this is the last room the player cannot choose a direction to go once they enter.
	 */
	@Override
	public void goWest() {
		System.out.println("There's no running away");
		
	}
	/**
	 * Since this is the last room the player cannot choose any other commands once they enter.
	 */
	@Override
	public void roomOptions(Scanner in) {
		System.out.println("No option but to fight.");
		
	}
	/**
	 * A method for fighting a Monster that overrides the other monsterFight method. This one uses a boss instead of a Monster list.
	 */
	@Override
	public void monsterFight(LinkedList<Monster> MonsterList, Hero hero, Scanner in) {
		//getGame().getMusicObject().stopMusic();
		//musicObject.playMusic();
        int damage = 0; 
		System.out.println("This must be the Demon King, Dabura. Time to put everything on the line.");
		while(hero.isAlive() && boss.isAlive()) {
			hero.checkEquippedWeapon();
			if(hero.getEquippedStatus()==false){
				System.out.print("You don't have a weapon equipped. You attack with your fists");
				damage = hero.attack();
				System.out.println("\n" + hero.getName() + " hits " + boss.getName() + " for " + damage + "\n"); 
				boss.takeDamage(damage);
				}
			else {
				System.out.print("\nSelect a number for hero action?\n");
				System.out.println("1. Fight unarmed\n2. Fight with Weapon");
				int options = in.nextInt();
				while(options < 0 || options > 2) {
					System.out.println("Joking around during battle is generally not recommended");
					options=in.nextInt();
					}
				if(options == 1) {
					damage = hero.attack();
					System.out.println("\n" + hero.getName() + " hits " + boss.getName() + " for " + damage + "\n"); 
					boss.takeDamage(damage);
					}
				else {
					damage = hero.attackWithWeapon();
					System.out.println("\n" + hero.getName() + " hits " + boss.getName() + " for " + damage + "\n"); 
					boss.takeDamage(damage);
					}   	        
				}
			//Pause for 2 seconds
			try {
				Thread.sleep(2000);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			//Continues the loop so long as the monster is alive. 
			if (boss.isAlive()) {
				damage = boss.attack();
				System.out.println(boss.getName() + " hits " + hero.getName() + " for " + damage);
				hero.takeDamage(damage);
				}
			}
		//If the boss is still alive sets game over to true.
		if(boss.isAlive()) {
			System.out.print("As Dabura deals the final blow to you, you wish you had prepared more.\n" +
		"The darkness overtakes your vision, and you accept the cold embrace of death. Thanks for playing.");
			//musicObject.stopMusic();
			getGame().setGameOver(true);
			}
		//If the player is victorious stops fight music and plays victory song. Sets game over to True.
		else {
			//musicObject.stopMusic();
			//musicObject2.playMusic();
			System.out.println("You've done it!!! You've defeated the Demon King! The world will forever sing your praises\n" +
				"Thank you for playing my game. I really hope you had a great time.");
			try {
    			Thread.sleep(7000);
    			} 
    		catch (InterruptedException e) {
    			e.printStackTrace();
    			}
			//musicObject2.stopMusic();
			getGame().setGameOver(true);
			}
		}
}
