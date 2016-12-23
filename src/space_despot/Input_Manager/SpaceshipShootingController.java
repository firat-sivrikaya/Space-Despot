package space_despot.Input_Manager;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import space_despot.Application_Logic.MusicManager;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.Spaceship;


public class SpaceshipShootingController {
	
	// PROPERTIES
	private Spaceship spaceship;
	private List<Bullet> bulletsInSpace;
	private InputMap inputMap; // panel where spaceship is painted
	private ActionMap actionMap; // panel where spaceship is painted
	private KeyStroke currentPressKeyStroke;
	private KeyStroke currentReleaseKeyStroke;
	private MusicManager musicManager;

	// CONSTRUCTOR
	public SpaceshipShootingController(Spaceship spaceship, List<Bullet> bulletsInSpace,
			InputMap inputMap, ActionMap actionMap, MusicManager musicManager) {
		this.spaceship = spaceship;
		this.bulletsInSpace = bulletsInSpace;
		this.inputMap = inputMap;
		this.actionMap = actionMap;
		this.musicManager = musicManager;
		currentPressKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, false); // X by default
		currentReleaseKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, true);
	}

	// METHOD
	public void initShootingKeyBindings(int keyEvent) {
		
		// delete old key strokes
		inputMap.remove(currentPressKeyStroke);
		inputMap.remove(currentReleaseKeyStroke);
	
		// key pressed
		currentPressKeyStroke = KeyStroke.getKeyStroke(keyEvent, 0, false);
        inputMap.put(currentPressKeyStroke, "shootingKey.pressed");
        actionMap.put("shootingKey.pressed", new BulletAction(true));
        
        
        // key release
        KeyStroke currentReleaseKeyStroke = KeyStroke.getKeyStroke(keyEvent, 0, true);
        inputMap.put(currentReleaseKeyStroke, "shootingKey.released");
        actionMap.put("shootingKey.released", new BulletAction(false));
	}
	
	// ACTION
	@SuppressWarnings("serial")
	public class BulletAction extends AbstractAction {
    	
    	private boolean isPressed;
    	
    	public BulletAction(boolean isPressed) {
    		this.isPressed = isPressed;
    	}
    
		@Override
		public void actionPerformed(ActionEvent e) {			
			// add new bullet to the space if x is pressed and if charge is ready
			if (isPressed && spaceship.isBulletReady()) {
				bulletsInSpace.add(spaceship.shootNewBullet());	
				musicManager.playFireSound();
			}				
			// refill bullet when it is released
			else if (!isPressed)
				spaceship.refillBullet();
		}
    }
=======
import java.awt.event.KeyEvent;


public class SpaceshipShootingController 
{
	private int shootKey;
	
	public SpaceshipShootingController()
	{
		initShootingKeyBindings();
	}
	
	public void initShootingKeyBindings()
	{
		this.shootKey = KeyEvent.VK_X;
	}
	
	public int getShootingKey()
	{
		return shootKey;
	}
	
	public void setShootingKey(int key)
	{
		this.shootKey = key;
	}
>>>>>>> origin/master
}
