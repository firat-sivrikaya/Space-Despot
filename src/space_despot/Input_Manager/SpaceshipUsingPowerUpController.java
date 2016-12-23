package space_despot.Input_Manager;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import space_despot.Enums.PowerUpType;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.PowerUp;
import space_despot.Game_Screen_Elements.Spaceship;


public class SpaceshipUsingPowerUpController {

	// PROPERTIES
	private Spaceship spaceship;
	private List<Bullet> bulletsInSpace;
	private InputMap inputMap; // panel where spaceship is painted
	private ActionMap actionMap; // panel where spaceship is painted
	private KeyStroke currentPressKeyStroke;

	// CONSTRUCTOR
	public SpaceshipUsingPowerUpController(Spaceship spaceship, List<Bullet> bulletsInSpace, 
			InputMap inputMap, ActionMap actionMap) {
		this.spaceship = spaceship;
		this.bulletsInSpace = bulletsInSpace;
		this.inputMap = inputMap;
		this.actionMap = actionMap;
		currentPressKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false); // space by default
	}
	
	// METHOD
	public void initUsingPowerUpKeyBindings(int keyEvent) {
		
		// delete old key strokes
		inputMap.remove(currentPressKeyStroke);
				
		// space pressed
        KeyStroke keyStrokeSpacePressed = KeyStroke.getKeyStroke(keyEvent, 0, false);
        inputMap.put(keyStrokeSpacePressed, "space.pressed");
        actionMap.put("space.pressed", new PowerUpAction());
	}
	
	// ACTION
	@SuppressWarnings("serial")
	public class PowerUpAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			PowerUp temp = spaceship.usePowerUp();
			if (temp != null) {
				if (temp.getType() == PowerUpType.LASER_GUN) {
					bulletsInSpace.add(spaceship.shootNewLaserBullet());
				}
			}
			
		} 
=======
import java.awt.event.KeyEvent;


public class SpaceshipUsingPowerUpController 
{
	private int powerUpKey;
	
	public SpaceshipUsingPowerUpController()
	{
		initUsingPowerUpKeyBindings();
	}
	
	public void initUsingPowerUpKeyBindings()
	{
		this.powerUpKey = KeyEvent.VK_SPACE;
	}
	
	public int getPowerUpKey()
	{
		return powerUpKey;
	}
	
	public void setPowerUpKey(int key)
	{
		this.powerUpKey = key;
>>>>>>> origin/master
	}
}
