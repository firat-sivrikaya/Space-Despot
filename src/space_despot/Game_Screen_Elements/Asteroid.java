
package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;


	
public class Asteroid extends SpaceMob {
	
	// CONSTANTS
	private final ImageIcon ASTEROID_GOING_LEFT_ICON = new ImageIcon("resources/images/asteroid-going-left.png");

	private final ImageIcon ASTEROID_GOING_RIGHT_ICON = new ImageIcon("resources/images/asteroid-going-right.png");
	
	// CONSTRUCTOR
	public Asteroid(int level) {
		super(level);
		maxHP = level * Constants.ASTEROID_INITIAL_MAX_HP;
		HP = maxHP;
		attackDamage = level * Constants.ASTEROID_INITIAL_ATTACK_DAMAGE;
		isGoingLeft = Math.random() >= 0.5;
		
		if (isGoingLeft)
			image = ASTEROID_GOING_LEFT_ICON.getImage();	
		else
			image = ASTEROID_GOING_RIGHT_ICON.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = Constants.ASTEROID_INITIAL_VELOCITY;
		velocityY = Constants.ASTEROID_INITIAL_VELOCITY;
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
}	