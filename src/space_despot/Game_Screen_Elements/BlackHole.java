/**
 * 
 */
package space_despot.Game_Screen_Elements;

import java.util.Random;
import javax.swing.ImageIcon;
import space_despot.Constants.*;


public class BlackHole extends SpaceObstacle{
	
	// Constants
	private final ImageIcon BLACKHOLE_ICON = new ImageIcon("");
	// Properties
	// Constructor
	public BlackHole()
	{
		super();
		image = BLACKHOLE_ICON.getImage();
		
		Random random = new Random();
		// random.nextInt((max - min) + 1) + min;
		int randomNum = random.nextInt((Constants.SPACE_WIDTH - 0) + 1) + 0;
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
