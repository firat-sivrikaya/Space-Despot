/**
 * 
 */
package space_despot.Game_Screen_Elements;

import java.util.Random;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;


public class Star extends SpaceObstacle{
	
	// Constants
	private final ImageIcon YELLOW_STAR_ICON = new ImageIcon("resources/images/yellow-star.png");
	private final ImageIcon RED_STAR_ICON = new ImageIcon("resources/images/red-star.png");
	private final ImageIcon GREEN_STAR_ICON = new ImageIcon("resources/images/green-star.png");
	private final ImageIcon BLUE_STAR_ICON = new ImageIcon("resources/images/blue-star.png");
	private final ImageIcon icons[] = {YELLOW_STAR_ICON, RED_STAR_ICON, GREEN_STAR_ICON, BLUE_STAR_ICON};
	// Properties
	// Constructor
	public Star()
	{
		super();
		
		Random random = new Random();
		// random.nextInt((max - min) + 1) + min;
		int randomNum = random.nextInt((Constants.SPACE_WIDTH - 0) + 1) + 0;
		int randomColor = random.nextInt((3 - 0) + 1) + 0;
		image = icons[randomColor].getImage();
		x = randomNum;
		y = 0;
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = 0;
		velocityY = Constants.OBSTACLE_VELOCITY_Y;
	}
	// Methods
	@Override
	public void move()
	{
		y = y + velocityY;
	}

}
