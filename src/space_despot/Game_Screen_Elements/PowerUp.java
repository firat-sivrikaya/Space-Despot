/**
 * 
 */
package space_despot.Game_Screen_Elements;

import java.util.Random;

import javax.swing.ImageIcon;

import space_despot.Enums.PowerUpType;


public class PowerUp extends SpaceItem {
	
	// CONSTANTS
	private final ImageIcon INVULNERABILITY_ICON = new ImageIcon("resources/images/invulnerability.png");
	
	private final ImageIcon LASER_GUN_ICON = new ImageIcon("resources/images/laser-gun.png");
	
	private final ImageIcon HYPER_DRIVE_ICON = new ImageIcon("resources/images/hyper-drive.png");
	
	private final ImageIcon REPAIR_ICON = new ImageIcon("resources/images/repair.png");
	
	private final ImageIcon[] icons = {INVULNERABILITY_ICON, LASER_GUN_ICON, HYPER_DRIVE_ICON, REPAIR_ICON};
	
	// PROPERTIES
	private PowerUpType type;

	// CONSTRUCTOR
	public PowerUp() {
		super();
		
		// set random type (a number from 0 to 3)
		Random random = new Random();
		// random.nextInt((max - min) + 1) + min;
		int randomNum = random.nextInt((3 - 0) + 1) + 0;
		
		type = PowerUpType.values()[randomNum];	
		image = icons[randomNum].getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
	}

	// GETTERS AND SETTERS
	public PowerUpType getType() {
		return type;
	}

	public void setType(PowerUpType type) {
		this.type = type;
	}
}