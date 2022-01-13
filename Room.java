package cs5004.finalproject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */

/**
 * An abstract class representing a Room. Every room has a name, takes in a Game object to control music, has a specific item to be found in each
 * room and has a Hero who is exploring the rooms. This class also holds the commands of the game and uses a boolean to check for valid commands. 
 */

abstract class Room {
	protected String name;
	protected Game game;
	protected Item item;
	protected Hero hero;
	protected boolean validCommand;
	GameMusic musicObject = new GameMusic("FFVII-Victory.wav");
	GameMusic musicObject2 = new GameMusic("Night-of-Fate.wav");
	
	/**
	 * Constructs a room object with a name, game, item, hero and sets validCommand to false.
	 * @param name A string representing the room's name
	 * @param game A Game object which is used for controlling which room the hero is in
	 * @param item A room Item that will differ depending on the room.
	 * @param hero A Hero who will explore the room
	 */
	public Room(String name, Game game, Item item, Hero hero) {
		this.name=name;
		this.game=game;
		this.item=item;
		this.hero=hero;
		validCommand=false;
	}
	
	/**
	 * A getter which returns the name of the room
	 * @return a String representing the room name.
	 */
	public String getName() {
        return name;
    }

	/**
	 * A setter which sets the room name.
	 * @param name A string that will update the room name value.
	 */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * A getter which will return the Game object
     * @return a Game object
     */
    public Game getGame() {
        return game;
    }

    /**
     * A setter which sets the Game being played
     * @param game A game object that is passed to the room.
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     * A setter which sets the Item of the room.
     * @param item the item to be put in the room.
     */
    public void setItem(Item item) {
    	this.item=item;
   }
    
    /**
     * A getter which returns the item of the room.
     * @return the item of the room
     */
   public Item getItem() {
    	return item;
    }
    
   /**
    * A setter which sets the hero who is exploring the room.
    * @param hero A hero object that is used.
    */
    public void setHero(Hero hero) {
    	this.hero=hero;
    }
    
    /**
     * A getter which returns the hero who is exploring the dungeon
     * @return a Hero object
     */
    public Hero getHero() {
    	return hero;
    }
    
    /**
     * Sets the validCommand boolean to true or false if valid input was used
     * @param validCommand a boolean that represents valid input from the player.
     */
    public void setValidCommand(boolean validCommand) {
    	this.validCommand=validCommand;
    }
    /**
     * A getter which returns the current status of ValidCommand
     * @return a boolean representing if a valid command was used.
     */
    public boolean getValidCommand() {
    	return validCommand;
    }
    
    /**
     * A method which will initiate a monster fight. This method will stop the game music currently playing and replace it with battle music
     * and also play a different clip for winning a battle. There is a 50% chance of encountering a monster and the hero always faces the weakest 
     * monster available from the linked list of Monsters.
     * @param MonsterList A Linked List of monsters that supplies the opponents to fight. The weakest monster is always selected.
     * @param hero A hero who fights the monsters
     * @param in A scanner which is used for selecting which fight option the hero is using. 
     */
    public void monsterFight(LinkedList<Monster> MonsterList, Hero hero, Scanner in) {
    	int encounter = 0;

		Random r1 = new Random();
		
		encounter=r1.nextInt(100 - 1) + 1;
        int damage = 0; 
		
        //So long as the list is not empty a fight will occur if the encounter is 50 or lower
		if(MonsterList.isEmpty()==false) {
			if (encounter <= 50) {
				getGame().getMusicObject().stopMusic();
				System.out.println("A monster appeared. Time to fight");
				musicObject2.playMusic();
				while(hero.isAlive() && MonsterList.getFirst().isAlive()) {
					hero.checkEquippedWeapon();
					if(hero.getEquippedStatus()==false){
	        			System.out.print("You don't have a weapon equipped. You attack with your fists");
	        			damage = hero.attack();
	         			System.out.println("\n" + hero.getName() + " hits " + MonsterList.getFirst().getName() + " for " + damage + "\n"); 
	         			MonsterList.getFirst().takeDamage(damage);
					}
					else {
						System.out.print("\nSelect a number for hero action?\n");
	        			System.out.println("1. Fight unarmed\n2. Fight with Weapon");
	        	        int options = in.nextInt();
	        	        
	        	        while(options < 0 || options > 2) {
	        	        	System.out.println("Joking around during battle is generally not recommended");
	        	        	System.out.print("\nSelect a number for hero action?\n");
		        			System.out.println("1. Fight unarmed\n2. Fight with Weapon");
	        	        	options=in.nextInt();
	        	        }
	        	        
	        	        if(options == 1) {
	        	        	damage = hero.attack();
	             			System.out.println("\n" + hero.getName() + " hits " + MonsterList.getFirst().getName() + " for " + damage + "\n"); 
	             			MonsterList.getFirst().takeDamage(damage);
	             			}
	        	        
	        	        else {
	        	        	damage = hero.attackWithWeapon();
	             			System.out.println("\n" + hero.getName() + " hits " + MonsterList.getFirst().getName() + " for " + damage + "\n"); 
	             			MonsterList.getFirst().takeDamage(damage);
	             			}   	        
	        		}
					//Two second pause
	        		try {
	        			Thread.sleep(2000);
	        			} 
	        		catch (InterruptedException e) {
	        			e.printStackTrace();
	        			}
	        		
	        		//Checks if the monster is still alive and equipped or not
	        		if (MonsterList.getFirst().isAlive()) {
	        			if(MonsterList.getFirst().getEquippedStatus()==true) {
	        				damage = MonsterList.getFirst().attackWithWeapon();
	        			}
	        			else {
	        			damage = MonsterList.getFirst().attack();
	        			}
	 					System.out.println(MonsterList.getFirst().getName() + " hits " + hero.getName() + " for " + damage);
	 					hero.takeDamage(damage);
	 					}
	        		}
				//If the winner is the monster ends the game and stops the music
				if(MonsterList.getFirst().isAlive()) {
					System.out.print("As the monster deals the final blow to you, you wish you had prepared more.\n" +
				"The darkness overtakes your vision, and you accept the cold embrace of death. Thanks for playing.");
					musicObject2.stopMusic();
					getGame().setGameOver(true);
				}
				//If the hero is alive plays victory music and displays level up stats. Takes a 7 second break so the user can read.
				else {
					musicObject2.stopMusic();
					
					musicObject.playMusic();
					System.out.println("You've defeated the foul beast! You can feel yourself getting stronger.");
					hero.setExp(hero.getExp()+ MonsterList.getFirst().getExp());
					MonsterList.removeFirst();
					hero.LevelUp();
					System.out.println("You've leveled up " + hero.toString());
					
					try {
	        			Thread.sleep(7000);
	        			} 
	        		catch (InterruptedException e) {
	        			e.printStackTrace();
	        			}
					musicObject.stopMusic();
					getGame().getMusicObject().loopMusic();
				}
			}
			else {
				System.out.println("\nLooks like there's no Monsters here now, but be cautious.");
			}
		}
    }
    /**
     * A method for choosing the direction the hero goes if the command is valid the direction method of the specific room will be used. 
     * @param in A scanner object that is used to take user input
     * @param command A string which will be updated based on what is passed into the scanner
     */
    public void chooseDir(Scanner in, String command) {
    	
    	if(command.toUpperCase().equals("N")|| command.toUpperCase().equals("NORTH")) {
    		setValidCommand(true);
			goNorth();
		}
		else if(command.toUpperCase().equals("S") || command.toUpperCase().equals("SOUTH")) {
			setValidCommand(true);
			goSouth();
		}
		else if(command.toUpperCase().equals("W") || command.toUpperCase().equals("WEST")) {
			setValidCommand(true);
			goWest();
		}
		else if(command.toUpperCase().equals("E") || command.toUpperCase().equals("EAST")) {
			setValidCommand(true);
			goEast();
		}
    }
    /**
     * A command for viewing items or viewing the inventory. If the command is valid will update valid command to true. Uses an iterator to
     * go through the hero's inventory to find the item they want to view.
     * @param in A scanner that takes user input
     * @param command A string that will be updated based on what's passed to the scanner. 
     */
    public void viewCommand(Scanner in, String command) {
    	
    	if (command.toUpperCase().equals("VIEW")) {
    		setValidCommand(true);
			System.out.println("View what? Type either Inventory or Item");
			String viewer = in.nextLine();
			
			if(viewer.toUpperCase().equals("INVENTORY") || viewer.toUpperCase().equals("VIEW INVENTORY")){
				getHero().viewInventory();
			}
			else if(viewer.toUpperCase().equals("ITEM") || viewer.toUpperCase().equals("VIEW ITEM")) {
				System.out.println("Here are the list of viewable items");
				System.out.println("Room items: " + item.getName() + "\nInventory items: " + getHero().getInventory().stream().map(x -> x.getName()).collect(Collectors.toList()));
				System.out.println("Which item are you viewing? Type the name exactly as seen.");
				String itemViewer = in.nextLine();
				
				//If the item is the room item
				if(itemViewer.equals(item.getName())) {
					System.out.println(item.getDescription());
				}
				// If the item is in the hero's inventory
				else if(getHero().getInventory().stream().filter(o -> o.getName().equals(itemViewer)).findFirst().isPresent()==true){
					Iterator<Item> iterator = getHero().getInventory().iterator();
					while (iterator.hasNext()) {
				        Item founditem = iterator.next();
				        if (founditem.getName().equals(itemViewer)) {
				            getHero().viewItem(founditem);
				            }
				        }
					}
				else {
					System.out.println("I either can't view this or the spelling is off.");
					}
				}
			else {
				System.out.println("I either can't view this or the spelling is off.");
				}
			}
    	}
    /**
     * The equip command which will allow the hero to equip an item that is in their inventory has a equippable status of true. 
     * @param in A scanner that takes user input
     * @param command A string that will be updated based on what's passed to the scanner.
     */
    public void equipCommand(Scanner in, String command) {
    	
    	if(command.toUpperCase().equals("EQUIP") || command.toUpperCase().equals("EQUIP ITEM")) {
    		setValidCommand(true);
			System.out.println("Here are the items in your inventory. If an item can be equipped it will be added to the Hero.");
			getHero().viewInventory();
			System.out.println("Which item are you equipping? Type the name exactly as seen.");
			String itemViewer = in.nextLine();
			if(getHero().getInventory().stream().filter(o -> o.getName().equals(itemViewer)).findFirst().isPresent()==true) {
				Iterator<Item> iterator = getHero().getInventory().iterator();
				while (iterator.hasNext()) {
			        Item founditem = iterator.next();
			        if (founditem.getName().equals(itemViewer)&& founditem.getEquippable()==true) {
			            getHero().setEquippedWeapon((Weapon) founditem);
			            }
			        else if(founditem.getName().equals(itemViewer)&& founditem.getEquippable()==false) {
			        	System.out.println("Can't equip this item");
			        	}
			        }
				}
			else {
				System.out.println("I either can't equip this or the spelling is off.");
				}
			}
    	}
    /**
     * A method that will take an item in a room and add it to the hero's inventory makes a check if the room's item is a Fallenhero, TreasureChest 
     * or just an item. 
     * @param in A scanner that takes user input
     * @param command A string that will be updated based on what's passed to the scanner.
     */
    public void takeCommand(Scanner in, String command) {
    	if(command.toUpperCase().equals("TAKE") || command.toUpperCase().equals("TAKE ITEM")){
    		setValidCommand(true);
    		if(item.getClass()==FallenHero.class) {
    			System.out.println("Take what?");
    			String itemViewer = in.nextLine();
    			if(((FallenHero) item).getInventory().stream().filter(o -> o.getName().equals(itemViewer)).findFirst().isPresent()==true) {
    				Iterator<Item> iterator = ((FallenHero) item).getInventory().iterator();
    				while (iterator.hasNext()) {
    					Item founditem = iterator.next();
    					if (founditem.getName().equals(itemViewer)) {
    						getHero().addItem(founditem);
    						((FallenHero) item).getInventory().remove(founditem);
    						break;
    						}
    					}
    				}
    			else {
    				System.out.println("I either can't take this or the spelling is off.");
    				}
    			}
    	
    	else if(item.getClass()==TreasureChest.class) {
    		if(((TreasureChest) item).getLocked()==false) {
    			System.out.println("Take what?");
    			String itemViewer = in.nextLine();
    			if(itemViewer.equals(((TreasureChest) item).getLoot().getName())) {
    				getHero().addItem(((TreasureChest) item).getLoot());
    				((TreasureChest) item).getLoot().setTakable(false);
    				}
    			else {
    				System.out.println("I either can't take this or the spelling is off.");
    				}
    			}
    		else {
				System.out.println("Can't take anything until the chest is unlocked.");
				}
    		}
    	
    	else if(item.getClass()==Item.class) {
    		System.out.println("Take what?");
			String itemViewer = in.nextLine();
			if(itemViewer.equals(item.getName())) {
				hero.addItem(item);
				item.setTakable(false);
			}
			else {
				System.out.println("I can't take that or the spelling is off.");
				}
			}
    	else {
    		System.out.println("Nothing to take here");
    		}
    	}
    }
    /**
     * A method that will use an item by calling the hero's use item method. If the used item is a key will check if the room contains a treasure
     * chest and that the key is the right key to unlock.
     * @param in A scanner object which will take user input
     * @param command A string which will be the command passed by the scanner
     */
    public void useCommand(Scanner in, String command) {
    	if(command.toUpperCase().equals("USE") || command.toUpperCase().equals("USE ITEM")) {
    		setValidCommand(true);
			System.out.println("Here are the items in your inventory. If an item can be used it will be removed.");
			hero.viewInventory();
			System.out.println("Which item are you using? Type the name exactly as seen.");
			String itemViewer = in.nextLine();
			if(getHero().getInventory().stream().filter(o -> o.getName().equals(itemViewer)).findFirst().isPresent()==true) {
				Iterator<Item> iterator = getHero().getInventory().iterator();
				while (iterator.hasNext()) {
			        Item founditem = iterator.next();
			        if (founditem.getName().equals(itemViewer)) {
			        	if(item.getClass()==TreasureChest.class) {
			        		if(founditem.getName().contains("Key")) {
			        		((TreasureChest) item).openChest(getHero(), (Key) founditem);
			        		break;
			        			}
			        		else {
			        			getHero().useItem(founditem);
			        			break;
			        			}
			        		}
			        	else if(item.getClass()==BossDoor.class) {
			        		if(founditem.getName().toUpperCase().equals("BOSSKEY")) {
				        		((BossDoor) item).openDoor(hero);
				        		break;
				        		}
			        		else {
			        			hero.useItem(founditem);
					            break;
			        			}
			        		}
			        	else {
			            getHero().useItem(founditem);
			            break;
			            }
			        }
				}
			}
			else {
				System.out.println("I either can't use this or the spelling is off.");
				}
			}
    	}
    /**
     * Takes in a Scanner object and runs the various command methods. If no valid command was typed will print out a message saying so.
     * @param in The scanner object that will be used to access the commands.
     */
    public void roomOptions(Scanner in) {
		System.out.println("What do you want to do?");
		System.out.println("Actions are N, S, E, W, View, Use, Equip, and Take");
		String command = in.nextLine();
		
		chooseDir(in, command);
		viewCommand(in, command);
		equipCommand(in, command);
		takeCommand(in, command);
		useCommand(in, command);
		
		if(getValidCommand()==false) {
			System.out.println("Sorry I don't understand.");
		}
		setValidCommand(false);
	}
    /**
     * Returns a string representation of the room
     */
    public String toString() {
    	return "\nLocation: " + name + "\n" + roomDescription();
    }
	
    /**
	 * Goes north on the map if there is a room available. Otherwise prints a message saying so.
	 */
	abstract void goNorth();
	
	/**
	 * Goes south on the map if there is a room available. Otherwise prints a message saying so.
	 */
	abstract void goSouth();
	
	/**
	 * Goes east on the map if there is a room available. Otherwise prints a message saying so.
	 */
	abstract void goEast();
	
	/**
	 * Goes west on the map if there is a room available. Otherwise prints a message saying so.
	 */
	abstract void goWest();
	
	/**
	 * A method which returns a String containing the description of the particular room.
	 */
	abstract String roomDescription();
}
