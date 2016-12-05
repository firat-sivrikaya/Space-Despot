package com.spacedespot.model;

import javax.swing.ImageIcon;

import com.spacedespot.commons.constants.Constants;


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
