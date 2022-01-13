/**
 * Basil Coughlan
 * Fall 2021 CS5004
 * 12/12/21
 * Final Project DungeonQuest
 */
package cs5004.finalproject;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * A class which will help to control the music in the game. Utilizes the Clip interface to play, stop and loop music
 *  This is my researched topic and the music will play throughout the game.
 *
 */
public class GameMusic {

	private Clip clip;
    /**
     * Constructs a GameMusic object with a String fileName of the file that will be played. 
     * @param fileName The file of the audio file that will be played.
     */
	public GameMusic(String fileName) {
		//Try/Catch blocks to catch any errors the audio file could throw.
		
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else {
                throw new RuntimeException("Audio file not found. " + fileName);
            }
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Audio file type is not supported." + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Encountered I/O Error." + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Line Unavailable need to end first instance of audio " + e);
        }
 
    }
	/**
	 * Plays an AudioClip from the beginning.
	 */
    public void playMusic(){
        clip.setFramePosition(0);
        clip.start();
    }
    /**
     * Loops the audio clip repeatedly until stopMusic is called
     */
    public void loopMusic(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    /**
     * Stops the audio clip.
     */
    public void stopMusic(){
            clip.stop();
        }
    }