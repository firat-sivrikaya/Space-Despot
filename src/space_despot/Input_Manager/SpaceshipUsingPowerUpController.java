package space_despot.Input_Manager;

import java.awt.event.KeyEvent;


public class SpaceshipUsingPowerUpController 
{
	private int powerUpKey;
	
	public SpaceshipUsingPowerUpController()
	{
		initUsingPowerUpKeyBindings();
	}
	
	public void initUsingPowerUpKeyBindings()
	{
		this.powerUpKey = KeyEvent.VK_SPACE;
	}
	
	public int getPowerUpKey()
	{
		return powerUpKey;
	}
	
	public void setPowerUpKey(int key)
	{
		this.powerUpKey = key;
	}
}
