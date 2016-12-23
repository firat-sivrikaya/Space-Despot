package space_despot.Input_Manager;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import space_despot.Enums.Movement;
import space_despot.Game_Screen_Elements.Spaceship;


public class SpaceshipMovementController {
	
	// PROPERTIES
	private Spaceship spaceship;
	private InputMap inputMap; // panel where spaceship is painted
	private ActionMap actionMap; // panel where spaceship is painted

	// CONSTRUCTOR
	public SpaceshipMovementController(Spaceship spaceship, InputMap inputMap, ActionMap actionMap) {
		this.spaceship = spaceship;
		this.inputMap = inputMap;
		this.actionMap = actionMap;
	}

	// METHODS
	public void initMovementKeyBindings() {
		
    	// right pressed
        KeyStroke keyStrokeRightPressed = KeyStroke.getKeyStroke(
        		KeyEvent.VK_RIGHT, 0, false);
        inputMap.put(keyStrokeRightPressed, "right.pressed");
        actionMap.put("right.pressed", new SpaceshipMovementAction(
        		true, Movement.RIGHT));

        // right released
        KeyStroke keyStrokeRightReleased = KeyStroke.getKeyStroke(
        		KeyEvent.VK_RIGHT, 0, true);
        inputMap.put(keyStrokeRightReleased, "right.released");
        actionMap.put("right.released", new SpaceshipMovementAction(
        		false, Movement.RIGHT));

        // left pressed
        KeyStroke keyStrokeLeftPressed = KeyStroke.getKeyStroke(
        		KeyEvent.VK_LEFT, 0, false);
        inputMap.put(keyStrokeLeftPressed, "left.pressed");
        actionMap.put("left.pressed", new SpaceshipMovementAction(
        		true, Movement.LEFT));

        // left released
        KeyStroke keyStrokeLeftReleased = KeyStroke.getKeyStroke(
        		KeyEvent.VK_LEFT, 0, true);
        inputMap.put(keyStrokeLeftReleased, "left.released");
        actionMap.put("left.released", new SpaceshipMovementAction(
        		false, Movement.LEFT));    	
        
        // up pressed
        KeyStroke keyStrokeUpPressed = KeyStroke.getKeyStroke(
        		KeyEvent.VK_UP, 0, false);
        inputMap.put(keyStrokeUpPressed, "up.pressed");
        actionMap.put("up.pressed", new SpaceshipMovementAction(
        		true, Movement.UP));

        // up released
        KeyStroke keyStrokeUpReleased = KeyStroke.getKeyStroke(
        		KeyEvent.VK_UP, 0, true);
        inputMap.put(keyStrokeUpReleased, "up.released");
        actionMap.put("up.released", new SpaceshipMovementAction(
        		false, Movement.UP));    	
        
        // up pressed
        KeyStroke keyStrokeDownPressed = KeyStroke.getKeyStroke(
        		KeyEvent.VK_DOWN, 0, false);
        inputMap.put(keyStrokeDownPressed, "down.pressed");
        actionMap.put("down.pressed", new SpaceshipMovementAction(
        		true, Movement.DOWN));

        // up released
        KeyStroke keyStrokeDownReleased = KeyStroke.getKeyStroke(
        		KeyEvent.VK_DOWN, 0, true);
        inputMap.put(keyStrokeDownReleased, "down.released");
        actionMap.put("down.released", new SpaceshipMovementAction(
        		false, Movement.DOWN)); 
    }

	@SuppressWarnings("serial")
	public class SpaceshipMovementAction extends AbstractAction {

		private Movement movement;
	    private boolean isPressed;
	    
	    public SpaceshipMovementAction(boolean isPressed, Movement movement) {
	    	this.isPressed = isPressed;
	        this.movement = movement;           
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {      	
	        if (isPressed)
	        	spaceship.addMovement(movement);
	        else
	        	spaceship.removeMovement(movement);     
	    }
	}
}
