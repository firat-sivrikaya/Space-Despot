/**
 * 
 */
package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;

/**
 * SpaceshipBullet
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class SpaceshipBullet extends Bullet {

	// CONSTANTS
	private final ImageIcon BULLET_ICON = new ImageIcon("resources/images/spaceship-bullet.png");
	
	// CONSTRUCTOR
	public SpaceshipBullet(int attackDamage) {	
		super(attackDamage);
		image = BULLET_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = 0;
		velocityY = Constants.SPACESHIP_BULLET_INITIAL_VELOCITY;
	}
	
	// METHODS
	@Override
	public void move() {
		y = y - velocityY;
	}
}