package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;

public class LaserBullet extends Bullet {
	
	// CONSTANTS
	private final ImageIcon BULLET_ICON = new ImageIcon("resources/images/laser.png");
	
	// CONSTRUCTOR
	public LaserBullet() {
		super();
		attackDamage = 300;
		image = BULLET_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = 0;
		velocityY = Constants.CREATURE_BULLET_INITIAL_VELOCITY;
	}	
	
	// METHODS
	@Override
	public void move() {
		y = y - velocityY;
	}
}
