package space_despot.Input_Manager;

import java.awt.event.KeyEvent;


public class SpaceshipMovementController 
{
	private int moveUpKey;
	private int moveDownKey;
	private int moveRightKey;
	private int moveLeftKey;
	
	public SpaceshipMovementController()
	{
		initMovementKeyBindings();
	}
	
	public void initMovementKeyBindings()
	{
		this.moveUpKey = KeyEvent.VK_UP;
		this.moveDownKey = KeyEvent.VK_DOWN;
		this.moveRightKey = KeyEvent.VK_RIGHT;
		this.moveLeftKey = KeyEvent.VK_LEFT;
	}

	public int getMoveUpKey()
	{
		return moveUpKey;
	}
	
	public int getMoveDownKey()
	{
		return moveDownKey;
	}
	
	public int getMoveRightKey()
	{
		return moveRightKey;
	}

	public int getMoveLeftKey()
	{
		return moveLeftKey;
	}
	
	public void setMoveUpKey(int key)
	{
		this.moveUpKey = key;
	}
	
	public void setMoveDownKey(int key)
	{
		this.moveDownKey = key;
	}
	
	public void setMoveRightKey(int key)
	{
		this.moveRightKey = key;
	}
	
	public void setMoveLeftKey(int key)
	{
		this.moveLeftKey = key;
	}

}
