package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.*;



public class Spaceship extends SpaceObject {

	// CONSTANTS
    private final ImageIcon FIGHTER_ICON = new ImageIcon(
			this.getClass().getResource("/images/fighter.png"));
    	
    // PROPERTIES
    
    // CONSTRUCTOR
    public Spaceship () {   	
    	image = FIGHTER_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = Constants.SPACESHIP_INITIAL_VELOCITY;
		velocityY = Constants.SPACESHIP_INITIAL_VELOCITY;
    }  
}
