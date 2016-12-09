package space_despot.Input_Manager;

import java.awt.event.KeyEvent;


public class SpaceshipShootingController 
{
	private int shootKey;
	
	public SpaceshipShootingController()
	{
		initShootingKeyBindings();
	}
	
	public void initShootingKeyBindings()
	{
		this.shootKey = KeyEvent.VK_X;
	}
	
	public int getShootingKey()
	{
		return shootKey;
	}
	
	public void setShootingKey(int key)
	{
		this.shootKey = key;
	}
}
