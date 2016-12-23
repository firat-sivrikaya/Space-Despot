package space_despot.Input_Manager;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import space_despot.Interfaces.Pausable;


public class PauseGameController {

	// PROPERTIES
	private InputMap inputMap; // panel where spaceship is painted
	private ActionMap actionMap; // panel where spaceship is painted
	private Pausable pauseDelegate; // to make pause request from here to panel

	
	// CONSTRUCTOR
	public PauseGameController(InputMap inputMap, ActionMap actionMap, Pausable pauseDelegate) {
		this.inputMap = inputMap;
		this.actionMap = actionMap;
		this.pauseDelegate = pauseDelegate;

	}

	// METHOD
	public void initPauseKeyBindings() {
		
		// ESC KEY
		KeyStroke keyStrokeEscPressed = KeyStroke.getKeyStroke(
        		KeyEvent.VK_ESCAPE, 0, false);
        inputMap.put(keyStrokeEscPressed, "esc.pressed");
        actionMap.put("esc.pressed", new PauseAction());
        

	}
	
	@SuppressWarnings("serial")
	public class PauseAction extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent e) {

				if (!pauseDelegate.isGamePaused()) { // pause request
					pauseDelegate.pauseGame();
				}
				else { // resume request
					pauseDelegate.resumeGame();
				}	
			}
	}
}
