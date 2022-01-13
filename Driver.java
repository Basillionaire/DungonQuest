/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;

import java.util.*;

public class Driver {
	Weapon w1, w2, w3, w4, w5;
	Monster m1, m2, m3, m4, m5;
	LinkedList<Monster> MonsterList;
	Key k1, k2, k3, k4;
	Item p1, p2;
	TreasureChest t1, t2, t3;
	BossDoor d1;
	LinkedList<Item> Inventory, Inventory1, Inventory2, Inventory3;
	Hero h1;
	FallenHero f1, f2, f3;
	Game g1;
	List<Room> map;
	Room r1, r2, r3, r4, r5, r6, r7, r8, r9;	
	

	public static void main(String[] args) {
		//Create Scanner object
		Scanner in = new Scanner(System.in);
		
		//The weapons of the game
		Weapon w1 = new Weapon("Dagger","A worn out Dagger", 15, 20);
		Weapon w2 = new Weapon("Excalibur", "The mighty sword of Kings", 30, 50);
		Weapon w3 = new Weapon("Axe", "A large great Axe for fighting monsters", 20, 30);
		Weapon w4 = new Weapon("Sword", "Your sword you've had for quite some time, not as sharp as it used to be", 10, 10);
		Weapon w5 = new Weapon("Club", "The Ogre's great club", 20, 10);
		//Monsters who are in your way. Linked list and you'll always fight the monster in pos 0.
		Monster m1 = new Monster("Gobby Goblin", 20, 10, 250);
		Monster m2 = new Monster("Tobias the Troll", 35, 20, 250);
		Monster m3 = new Monster("Viktor the Vampire", 45, 25, 250);
		Monster m4 = new Monster("Boss Ogre", 60, 30, 250, w5);
		Monster m5 = new Monster("Demon King Dabura", 80, 45, 250);
		LinkedList<Monster> MonsterList = new LinkedList<>();
		MonsterList.add(m1);
		MonsterList.add(m2);
		MonsterList.add(m3);
		MonsterList.add(m4);
		
		//Create the Keys to be used to unlock treasure chests or boss doors
		Key k1 = new Key("BronzeKey", "A bronze key look for the equivalent chest", "bronze");
		Key k2 = new Key("SilverKey", "A silver key look for the equivalent chest", "silver");
		Key k3 = new Key("GoldKey", "A gold key look for the equivalent chest", "gold");
		Key k4 = new Key("BossKey", "The key that opens the boss door", "black");
		
		//Create the items
		Item p1 = new Item("Potion", "A magical red vial that restores HP. Use this item to gain 20 HP"); 
		Item p2 = new Item("Potion","A magical red vial that restores HP. Use this item to gain 20 HP");
		TreasureChest t1 = new TreasureChest("BronzeChest", "A bronze chest something good must be inside", "bronze", p1, k1);
		TreasureChest t2 = new TreasureChest("SilverChest", "A silver chest something good must be inside", "silver", w2, k2);
		TreasureChest t3 = new TreasureChest("GoldChest", "A gold chest something good must be inside", "gold", k4, k3);
		BossDoor d1 = new BossDoor("Boss Chamber", "The final room, home of the demon king", k4);
		
		//Create the dead heroes who came before and the hero of this journey. Initialize inventories
		LinkedList<Item> Inventory = new LinkedList<Item>();
		LinkedList<Item> Inventory1 = new LinkedList<Item>();
		LinkedList<Item> Inventory2 = new LinkedList<Item>();
		LinkedList<Item> Inventory3 = new LinkedList<Item>();
		Hero h1 = new Hero("Unknown Hero", 25, 20, 0, 1, Inventory, w4);
		FallenHero f1 = new FallenHero("Athos", "One of the three heroes who came before you",Inventory1);
		FallenHero f2 = new FallenHero("Porthos", "One of the three heroes who came before you",Inventory2);
		FallenHero f3 = new FallenHero("Aramis", "One of the three heroes who came before you",Inventory3);
		Game g1 = new Game();
		
		
		//Adding items to dead hero inventories they can be looted when the body is found in the room
		Inventory.add(w4); //Player Hero starts with a Sword
		Inventory1.add(k1); //Athos has a BronzeKey
		Inventory1.add(w1); //Athos has a Dagger
		Inventory2.add(k2); // Porthos has a SilverKey
		Inventory2.add(w3); // Porthos has a Axe
		Inventory3.add(k3); // Aramis has a GoldKey
		
		//Create the map of rooms
		List<Room> map = new ArrayList<>();

		Room r1 = new Entrance("Entrance", g1, d1, h1);
		Room r2 = new MonsterLounge("Monster Lounge",g1, t1, h1);
		Room r3 = new RedHall("Red Hall", g1, f1, h1);
		Room r4 = new KingBedChamber("King Bed Chamber", g1, t3, h1);
		Room r5 = new StoreHouse("Store House", g1, p2, h1);
		Room r6 = new BunkHouse("Monster Bunk House", g1, f2, h1);
		Room r7 = new BlueHall("Blue Hall", g1, f3, h1);
		Room r8 = new Armory("Weapon Armory", g1, t2, h1);
		Room r9 = new BossRoom("Boss Room", g1, null, h1, m5);
				
				
		map.add(r1);
		map.add(r2);
		map.add(r3);
		map.add(r4);
		map.add(r5);
		map.add(r6);
		map.add(r7);
		map.add(r8);
		map.add(r9);
		
		
		g1.playGame(MonsterList, h1, map, in);
		
	    in.close(); 
	}
}

