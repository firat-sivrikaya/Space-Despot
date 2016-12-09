package space_despot.Input_Manager;

import java.awt.event.KeyEvent;

public class PauseGameController 
{
	private int pauseButton;
	
	public PauseGameController()
	{
		initPauseGameKeyBindings();
	}
	public void initPauseGameKeyBindings()
	{
		this.pauseButton = KeyEvent.VK_ESCAPE;
	}
	
	public int getPauseKey()
	{
		return pauseButton;
	}
	
	public void setPauseKey(int key)
	{
		this.pauseButton = key;
	}
}
