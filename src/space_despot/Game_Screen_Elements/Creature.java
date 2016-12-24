/**
 * 
 */
package space_despot.Game_Screen_Elements;

import java.util.Random;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;


public class Creature extends SpaceMob {
	
	// CONSTANTS
	private final ImageIcon CREATURE_BLUE_ICON = new ImageIcon("resources/images/creature-blue.png");
	private final ImageIcon CREATURE_ORANGE_ICON = new ImageIcon("resources/images/creature-orange.png");
	private final ImageIcon CREATURE_RED_ICON = new ImageIcon("resources/images/creature-red.png");
	private final ImageIcon[] icons = {CREATURE_BLUE_ICON, CREATURE_ORANGE_ICON, CREATURE_RED_ICON};
	    
	// CONSTRUCTOR
	public Creature(int level) {	
		super(level);
		maxHP = level * Constants.CREATURE_INITIAL_MAX_HP;
		HP = maxHP;
		attackDamage = level * Constants.CREATURE_INITIAL_ATTACK_DAMAGE;
		// assign random icon
		Random random = new Random();
		// random.nextInt((max - min) + 1) + min;
		int randomNum = random.nextInt((2 - 0) + 1) + 0;
		image = icons[randomNum].getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = Constants.CREATURE_INITIAL_X_VELOCITY;
		velocityY = Constants.CREATURE_INITIAL_Y_VELOCITY;
		y = 0; // initially at top
		isGoingLeft = Math.random() >= 0.5;
	}
	
	// METHODS
	@Override
	public void move() {
		y = y + velocityY;
		
		if (isGoingLeft)
			x = x - velocityX;
		else
			x = x + velocityX;
	}
	
	// shoot bullet
	public CreatureBullet shoot() {
	    // create the new bullet
		CreatureBullet bullet = new CreatureBullet(attackDamage);
	    
	    // bullet's initial coordinate will be creature's barrel coordinate
	    bullet.setX(x + width / 2 - bullet.getWidth() / 2);
	    bullet.setY(y + height);
	    
	    return bullet;
	}
}