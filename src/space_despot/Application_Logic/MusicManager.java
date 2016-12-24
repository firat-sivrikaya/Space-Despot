
package space_despot.Application_Logic;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class MusicManager {
	
	//Sound variables
	
	private static MusicManager musicManager = new MusicManager();
	
	//Menu background sound
	private  File menuBackgroundSound;
	private  AudioInputStream createMenuBackgroundSound;
	private  Clip playMenuBackgroundSound;
	
	//Game background sound
	private  File gameBackgroundSound;
	private  AudioInputStream createGameBackgroundSound;
	private  Clip playGameBackgroundSound;
	
	//Fire sound
	private  File fireSound;
	private  AudioInputStream createFireSound;
	private  Clip playFireSound;
	//Upgrade sound
	private  File upgradeSound;
	private  AudioInputStream createUpgradeSound;
	private  Clip playUpgradeSound;
	//Button sound
	private  File buttonSound;
	private  AudioInputStream createButtonSound;
	private  Clip playButtonSound;
	
	//Collision sound
	private  File collisionSound;
	private  AudioInputStream createCollisionSound;
	private  Clip playCollisionSound;
	
	//Game over sound
	//private  File gameOverSound;
	//private  AudioInputStream createGameOverSound;
	//private  Clip playGameOverSound;
	
	
	//Play menu background sound
	public  void startMenuBackgroundMusic() {
		menuBackgroundSound = new File("resources/musics/music_mainmenu.wav");
		//menuBackgroundSound = new File("resources/musics/Main_Menu.wav");
		createMenuBackgroundSound = null;
		playMenuBackgroundSound = null;

		try {
			createMenuBackgroundSound = AudioSystem
					.getAudioInputStream(menuBackgroundSound);
			
			try {
				playMenuBackgroundSound = AudioSystem.getClip();

			} catch (LineUnavailableException e) {

				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			playMenuBackgroundSound.open(createMenuBackgroundSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FloatControl gainControl = 
			    (FloatControl) playMenuBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-5.0f);
		playMenuBackgroundSound.loop(999999999);
		
	}
	
	public static MusicManager getMusicManager()
	{
		return musicManager;
	}
	
	//Stop menu background sound
	public  void stopMenuBackgroundMusic() {
		if (playMenuBackgroundSound != null && playMenuBackgroundSound.isRunning())
			playMenuBackgroundSound.stop();
	}
	
	//Play game background sound
	public void startGameBackgroundMusic(){
		gameBackgroundSound = new File("resources/musics/music_game.wav");
		//gameBackgroundSound = new File("resources/musics/Game.wav");
		createGameBackgroundSound = null;
		playGameBackgroundSound = null;

		try {
			createGameBackgroundSound = AudioSystem
					.getAudioInputStream(gameBackgroundSound);
			
			try {
				playGameBackgroundSound = AudioSystem.getClip();

			} catch (LineUnavailableException e) {

				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			playGameBackgroundSound.open(createGameBackgroundSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FloatControl gainControl = 
			    (FloatControl) playGameBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-5.0f);
		playGameBackgroundSound.loop(999999999);	
	}
	//Stop game background sound
	public void stopGameBackgroundMusic(){
		if (playGameBackgroundSound != null && playGameBackgroundSound.isRunning())
			playGameBackgroundSound.stop();	
	}
	
	//Play fire sound		
	public void playFireSound(){
		fireSound = new File("resources/musics/fire.wav");
		
		try {
			createFireSound	 =  AudioSystem.getAudioInputStream(fireSound);
			try {
				playFireSound = AudioSystem.getClip();
				
				
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			  
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		try {
			playFireSound.open(createFireSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playFireSound.start();
	}
	
	//Play upgrade sound
	public void playUpgradeSound(){
	upgradeSound = new File("resources/musics/Upgrade.wav");
	
	try {
		createUpgradeSound	 =  AudioSystem.getAudioInputStream(upgradeSound);
		try {
			playUpgradeSound = AudioSystem.getClip();
			
			
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
		}
	} catch (UnsupportedAudioFileException e) {
		  
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	} 
	
	try {
		playUpgradeSound.open(createUpgradeSound);
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	playUpgradeSound.start();
}
	
	//Play button sound
	public void playButtonSound(){

	buttonSound = new File("sounds/buttonSound.wav");
	
	try {
		createButtonSound	 =  AudioSystem.getAudioInputStream(buttonSound);
		try {
			playButtonSound = AudioSystem.getClip();
			
			
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
		}
	} catch (UnsupportedAudioFileException e) {
		  
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	} 
	
	try {
		playButtonSound.open(createButtonSound);
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	playButtonSound.start();
}
	
	//Play collision sound
	public void playCollisionSound(){
		collisionSound = new File("resources/musics/collision.wav");
		
		try {
			createCollisionSound	 =  AudioSystem.getAudioInputStream(collisionSound);
			try {
				playCollisionSound = AudioSystem.getClip();
				
				
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			  
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		try {
			playCollisionSound.open(createCollisionSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playCollisionSound.start();
		
	}
	
	public void changeMenuBackgroundSound(float amount)
	{
		if(playMenuBackgroundSound != null)
		{		
			if(playMenuBackgroundSound != null){
				FloatControl gainControl = 	(FloatControl) playMenuBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
				float decibel = (float) (Math.log(amount) / Math.log(10.0f) * 20.0);
				gainControl.setValue(decibel);	
			}
		}
	}
	
	public void changeGameBackground(float amount)
	{
		if(playGameBackgroundSound != null)
		{
			if(isGameBackgroundActive())
			{
				FloatControl gainControl = 	(FloatControl) playGameBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
				float decibel = (float) (Math.log(amount) / Math.log(10.0f) * 20.0);
				gainControl.setValue(decibel);	
			}
		}
	}
	
	public boolean isMenuBackgroundSoundActive()
	{
		if(playMenuBackgroundSound != null)
		{
			if(playMenuBackgroundSound.isActive())
				return true;
			else
				return false;
		}
		return false;
	}
	
	public boolean isGameBackgroundActive()
	{
		
		if(playGameBackgroundSound != null)
		{
			if(playGameBackgroundSound.isActive())
				return true;
			else
				return false;
		}
		return false;
	}
	
	//Play game-over sound
/*
	public void playgameOverSound(){
		gameOverSound = new File(".wav");
		
		try {
			createGameOverSound	 =  AudioSystem.getAudioInputStream(gameOverSound);
			try {
				playGameOverSound = AudioSystem.getClip();
				
				
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			  
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		try {
			playGameOverSound.open(createGameOverSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playGameOverSound.start();
		
	}
*/
	}

	

	

