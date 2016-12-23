/**
 * 
 */
package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;

/**
 * CreatureBullet
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class CreatureBullet extends Bullet {

	// CONSTANTS
	private final ImageIcon BULLET_ICON = new ImageIcon("resources/images/creature-bullet.png");
	
	// CONSTRUCTOR
	public CreatureBullet(int attackDamage) {
		super(attackDamage);
		image = BULLET_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = 0;
		velocityY = Constants.CREATURE_BULLET_INITIAL_VELOCITY;
	}	
	
	// METHODS
	@Override
	public void move() {
		y = y + velocityY;
	}
}
