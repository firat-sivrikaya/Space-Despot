package space_despot.Application_Logic;

import java.util.HashSet;
import java.util.List;

import space_despot.Constants.Constants;
import space_despot.Enums.Movement;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.Spaceship;

public class NewLevelSetterService {

	// properties
	private Spaceship spaceship;
	private List<Bullet> bulletsInSpace;

		
	// constructor
	public NewLevelSetterService(Spaceship spaceship, List<Bullet> bulletsInSpace) {
		this.spaceship = spaceship;
		this.bulletsInSpace = bulletsInSpace;
	}
	
	public void setNewLevel() {
		spaceship.setHP(spaceship.getMaxHP());
        spaceship.setX(Constants.SPACE_WIDTH / 2 - spaceship.getWidth() / 2);
        spaceship.setY(Constants.SPACE_HEIGHT - spaceship.getHeight());
        spaceship.setMovements(new HashSet<Movement>());
        spaceship.setCurrentPowerUp(null);
        
        bulletsInSpace.clear();
	}

}
