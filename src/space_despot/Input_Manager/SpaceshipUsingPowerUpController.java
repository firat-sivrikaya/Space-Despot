package space_despot.Input_Manager;


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
				} else if (temp.getType() == PowerUpType.REPAIR) {
					spaceship.setHP(spaceship.getMaxHP());
				} else if (temp.getType() == PowerUpType.HYPER_DRIVE) {
					int initialVelocity = spaceship.getVelocityX();					
					spaceship.setVelocityX(initialVelocity + 1);
					spaceship.setVelocityY(initialVelocity + 1); 					
					// revert after two seconds
					new java.util.Timer().schedule( 
					        new java.util.TimerTask() {
					            @Override
					            public void run() {
					            	spaceship.setVelocityX(initialVelocity);
									spaceship.setVelocityY(initialVelocity); 
					            }
					        }, 
					        2000 
					);
				} else { // invulnerability
					
				}
			}
			
		} 
	}
}
