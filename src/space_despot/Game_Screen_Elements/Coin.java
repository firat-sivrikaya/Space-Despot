/**
 * 
 */
package space_despot.Game_Screen_Elements;

/**
 * Coin
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class Coin extends SpaceItem{
	// Constants
	// Properties
	private int value;
	// Constructor
	public Coin(int value)
	{
		this.value = value;
	}
	// Methods
	public int getCoin()
	{
		return value;
	}
	
	public void setCoin(int value)
	{
		this.value = value;
	}
}
