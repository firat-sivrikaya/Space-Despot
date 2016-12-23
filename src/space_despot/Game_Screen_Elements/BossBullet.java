/**
 * 
 */
package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;

/**
 * BossBullet
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class BossBullet extends Bullet {

	// CONSTANTS
	private final ImageIcon BOSS_BULLET_ICON = new ImageIcon("resources/images/boss-bullet.png");
	
	// CONSTRUCTOR
	public BossBullet(int attackDamage) {
		super(attackDamage);
		image = BOSS_BULLET_ICON.getImage();
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