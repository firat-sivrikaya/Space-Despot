/**
 * 
 */
package space_despot.Game_Screen_Elements;

import space_despot.Constants.Constants;

/**
 * SpaceItem
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public abstract class SpaceItem extends SpaceObject{
	// Constants
	// Properties
	// Constructor
	public SpaceItem()
	{
		super();
		velocityX = 0;
		velocityY = Constants.POWER_UP_VELOCITY;
	}
	// Methods
	@Override
	public void move() {
		y = y + velocityY;
	}

}
