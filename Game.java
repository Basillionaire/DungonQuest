/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;
import java.io.InputStream;
import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * A Game includes the method which will play the Game and methods that check if the game is over. A Game has a currentRoom, gameOver boolean and
 * musicObject that plays.
 */
public class Game {
	private int currentRoom;
	private boolean gameOver;
	private GameMusic musicObject;
	/**
	 * Sets the currentRoom to 0(Entrance), gameover to false and creates a musicObject for dungeon exploring music
	 */
	public Game(){
		currentRoom=0;
		gameOver=false;
		setMusicObject(new GameMusic("LOZ-Battle-Theme.wav"));
	}
	/**
	 * Setter which sets the current room number to whatever is passed
	 * @param currentRoom an integer which represents the currentRoom on the map
	 */
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom=currentRoom;
	}
	/**
	 * A getter which returns the number of the currentRoom.
	 * @return an integer representing the currentRoom being explored.
	 */
	
	public int getCurrentRoom() {
		return currentRoom;
	}
	/**
	 * A method which sets gameOver to true or false depending on if the game is over or not.
	 * @param gameOver a boolean representing if the game has ended.
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver=gameOver;
	}
	/**
	 * A getter which returns true or false depending on if the game is over or not.
	 * @return a boolean representing gameOver status
	 */
	public boolean getGameOver() {
		return gameOver;
	}
	/**
	 * A getter which returns the GameMusic of the Game
	 * @return a GameMusic object 
	 */
	public GameMusic getMusicObject() {
		return musicObject;
	}
	/**
	 * A setter which sets the MusicObject 
	 * @param musicObject the GameMusic to be set
	 */
	public void setMusicObject(GameMusic musicObject) {
		this.musicObject = musicObject;
	}
	
	/**
	 * A method for playing the game. Runs a while loop so long as gameOver is false.
	 * @param MonsterList A Linkedlist of Monsters that is used for the fightmonsters method
	 * @param hero A hero who is doing the exploring and controlled by the player
	 * @param map A List of Rooms in a certain order laid out as a map
	 * @param in A scanner that takes user input.
	 */
	public void playGame(LinkedList<Monster> MonsterList,Hero hero, List<Room> map, Scanner in) { 
		getMusicObject().loopMusic();
		System.out.println("Welcome to DungeonQuest, a game of my own design. I hope you enjoy.");
		
	    System.out.println("What is the name of our hero?");

	    String heroName = in.nextLine();
	    hero.setName(heroName);
	    System.out.println("Welcome hero: " + heroName);
	    System.out.println("These are your starting stats: " + hero);
	    
		while(getGameOver()==false) {
			if(getCurrentRoom()==0) {
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(0).toString());
				while(getCurrentRoom()==0) {
				map.get(0).roomOptions(in);
				}
			}
			else if(getCurrentRoom()==1) {
				map.get(1).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(1).toString());
				while(getCurrentRoom()==1) {
				map.get(1).roomOptions(in);
				}
			}
			
			else if(getCurrentRoom()==2) {
				map.get(2).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(2).toString());
				while(getCurrentRoom()==2) {
				map.get(2).roomOptions(in);
				}
			}
			
			else if(getCurrentRoom()==3) {
				map.get(3).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(3).toString());
				while(getCurrentRoom()==3) {
				map.get(3).roomOptions(in);
				}
			}
			
			else if(getCurrentRoom()==4) {
				map.get(4).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(4).toString());
				while(getCurrentRoom()==4) {
				map.get(4).roomOptions(in);
				}
			}
			else if(getCurrentRoom()==5) {
				map.get(5).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(5).toString());
				while(getCurrentRoom()==5) {
				map.get(5).roomOptions(in);
				}
			}
			else if(getCurrentRoom()==6) {
				map.get(6).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(6).toString());
				while(getCurrentRoom()==6) {
				map.get(6).roomOptions(in);
				}
			}
			
			else if(getCurrentRoom()==7) {
				map.get(7).monsterFight(MonsterList, hero, in);
				if(getGameOver()==true) {
					break;
					}
				System.out.println(map.get(7).toString());
				while(getCurrentRoom()==7) {
				map.get(7).roomOptions(in);
				}
			}
			else {
				System.out.println(map.get(8).toString());
				map.get(8).monsterFight(MonsterList, hero, in);	
			}
		}
	}
}
