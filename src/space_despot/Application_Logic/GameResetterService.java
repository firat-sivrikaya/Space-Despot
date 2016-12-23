package space_despot.Application_Logic;

import java.util.HashSet;
import java.util.List;

import space_despot.Constants.Constants;
import space_despot.Enums.Movement;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.SpaceItem;
import space_despot.Game_Screen_Elements.SpaceMob;
import space_despot.Game_Screen_Elements.Spaceship;


public class GameResetterService {

	// properties
	private Spaceship spaceship;
	private List<SpaceMob> spaceMobsInSpace;
	private List<Bullet> bulletsInSpace;
	private List<SpaceItem> spaceItemsInSpace;
		
	// constructor
	public GameResetterService(Spaceship spaceship, List<SpaceMob> spaceMobsInSpace, 
			List<Bullet> bulletsInSpace, List<SpaceItem> spaceItemsInSpace) {
		this.spaceship = spaceship;
		this.spaceMobsInSpace = spaceMobsInSpace;
		this.bulletsInSpace = bulletsInSpace;
		this.spaceItemsInSpace = spaceItemsInSpace;
	}
	
	public void resetGame() {
		spaceship.setHP(spaceship.getMaxHP());
        spaceship.setX(Constants.SPACE_WIDTH / 2 - spaceship.getWidth() / 2);
        spaceship.setY(Constants.SPACE_HEIGHT - spaceship.getHeight());
        spaceship.setMovements(new HashSet<Movement>());
        spaceship.setCurrentPowerUp(null);
        spaceship.setScore(0);
        spaceship.setCoin(0);
        
        bulletsInSpace.clear();
        spaceMobsInSpace.clear();
        spaceItemsInSpace.clear();
	}

}
