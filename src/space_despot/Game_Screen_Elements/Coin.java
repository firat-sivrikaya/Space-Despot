/**
 * 
 */
package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;


public class Coin extends SpaceItem {
	
	// CONSTANTS
	private final ImageIcon COIN_ICON = new ImageIcon("resources/images/coin.png");
		
	// PROPERTIES
	private int value;
	
	// CONSTRUCTOR
	public Coin() {
		// set random value
		value = 100;
		
		image = COIN_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
	}

	// GETTERS AND SETTERS
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
