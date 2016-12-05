package com.spacedespot.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.spacedespot.commons.constants.Constants;
import com.spacedespot.model.Spaceship;

@SuppressWarnings("serial")
public class PlayGameScreen extends JPanel {
	  
    // PROPERTIES
	private Spaceship spaceship; 
	
    // CONSTRUCTOR  
    public PlayGameScreen() {
    	super();  		
    	// set space
        setSize(Constants.SPACE_WIDTH, Constants.SPACE_HEIGHT);
        setBackground(new Color(240, 255, 255));
        
        // set spaceship and its start coordinates
        spaceship = new Spaceship();
        spaceship.setX(Constants.SPACE_WIDTH / 2 - spaceship.getWidth() / 2);
        spaceship.setY(Constants.SPACE_HEIGHT - spaceship.getHeight());
    }	
    
    // METHODS
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        
        // draw spaceship
        g2.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), 
        		spaceship.getWidth(), spaceship.getHeight(), this);
    }
}
