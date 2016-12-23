package space_despot.Time_Manager;

import java.util.Iterator;
import java.util.List;

import space_despot.Constants.Constants;
import space_despot.Game_Screen_Elements.Boss;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.Coin;
import space_despot.Game_Screen_Elements.PowerUp;
import space_despot.Game_Screen_Elements.SpaceItem;
import space_despot.Game_Screen_Elements.SpaceMob;
import space_despot.Game_Screen_Elements.Spaceship;
import space_despot.Interfaces.GameOverMakable;
import space_despot.Interfaces.LevelPassable;
import space_despot.Interfaces.Repaintable;

public class UpdateService {
	
	// properties
	private Spaceship spaceship;
	private List<SpaceMob> spaceMobsInSpace;
	private List<Bullet> bulletsInSpace;
	private List<SpaceItem> spaceItemsInSpace;
	private Repaintable repaintDelegate; // to make repaint request from here to panel
	private GameOverMakable makeGameOverDelegate;
    private LevelPassable passLevelDelegate;

	// constructor
    public UpdateService(Spaceship spaceship, List<SpaceMob> spaceMobsInSpace,
    		List<Bullet> bulletsInSpace, List<SpaceItem> spaceItemsInSpace, 
    		Repaintable repaintDelegate, GameOverMakable makeGameOverDelegate,
    		LevelPassable passLevelDelegate) {
		this.spaceship = spaceship;
		this.spaceMobsInSpace = spaceMobsInSpace;
		this.bulletsInSpace = bulletsInSpace;
		this.spaceItemsInSpace = spaceItemsInSpace;
		this.repaintDelegate = repaintDelegate;
		this.makeGameOverDelegate = makeGameOverDelegate;
		this.passLevelDelegate = passLevelDelegate;
	}
    
   
	public void updateObjects() {
		// spaceship moves
        spaceship.move();
       
        // spaceship should not go out of map
        if (spaceship.getX() < 0) 
        	spaceship.setX(0);
        else if ( spaceship.getX() > Constants.SPACE_WIDTH - spaceship.getWidth() - 2) 
        	spaceship.setX(Constants.SPACE_WIDTH - spaceship.getWidth() - 2); // -2 for border 
        
        // spaceship should not go out of map
        if (spaceship.getY() < 0) 
        	spaceship.setY(0);
        else if ( spaceship.getY() > Constants.SPACE_HEIGHT - spaceship.getHeight() - 2) 
        	spaceship.setY(Constants.SPACE_HEIGHT - spaceship.getHeight() - 2); // -2 for border
        
        // spaceship may die
        if (spaceship.getHP() <= 0) {
        	makeGameOverDelegate.makeGameOver();
        }
        	
        
        // some of mobs become out of map, some of mobs die, some of mobs still move
        Iterator<SpaceMob> mobIterator = spaceMobsInSpace.iterator();
        while (mobIterator.hasNext()) {
        	SpaceMob spaceMob = mobIterator.next();
        	
        	// if spaceMob is out of map 
        	if (spaceMob.getX() < 0 - spaceMob.getWidth() || spaceMob.getY() < 0
        			|| spaceMob.getX() > Constants.SPACE_WIDTH
        			|| spaceMob.getY() > Constants.SPACE_HEIGHT ){
        		mobIterator.remove();
        	}
        	// if the mob is destroyed, it will increase spaceship's score and
        	// it will be removed with a chance of dropping something 
        	else if (spaceMob.getHP() <= 0) {
        		
        		spaceship.setScore(spaceship.getScore() + passLevelDelegate.getGameLevel() * 20);
        		
        		// if destroyed mob is boss, pass next level
        		// but before, if level is 3, finish game
        		if (spaceMob instanceof Boss) {
        			if (spaceMob.getLevel() == 3) {
        				makeGameOverDelegate.makeGameOver();
        			} else {
        				passLevelDelegate.finishLevel();
        			}       			
        		}
        		
        		// if destroyed mob has coin, drop it
				if (spaceMob.getHasCoin()) {
					Coin coin = spaceMob.dropCoinIfItHas();
					spaceItemsInSpace.add(coin);
				}
				
				// if destroyed mob has power-up, drop it
				if (spaceMob.getHasPowerUp()) {
					PowerUp powerUp = spaceMob.dropPowerUpIfItHas();
					spaceItemsInSpace.add(powerUp);
				}	
				mobIterator.remove();
        	} 
        	else
        		spaceMob.move();
        }
        
        // some of bullets still move, some of bullets become out of map (top)
        Iterator<Bullet> bulletIterator = bulletsInSpace.iterator();
        while (bulletIterator.hasNext()) {
        	Bullet bullet = bulletIterator.next();
        	
        	// if it is out of map 
        	if (bullet.getX() < 0 || bullet.getY() < 0
        			|| bullet.getX() > Constants.SPACE_WIDTH
        			|| bullet.getY() > Constants.SPACE_HEIGHT)
        		bulletIterator.remove();
        	else
        		bullet.move();
        }
        
        // some of power-ups still move, some of power-ups become out of map 
        Iterator<SpaceItem> spaceItemIterator = spaceItemsInSpace.iterator();
        while (spaceItemIterator.hasNext()) {
        	SpaceItem spaceItem = spaceItemIterator.next();
        	
        	// if it is out of map 
        	if (spaceItem.getX() < 0 || spaceItem.getY() < 0
        			|| spaceItem.getX() > Constants.SPACE_WIDTH
        			|| spaceItem.getY() > Constants.SPACE_HEIGHT)
        		spaceItemIterator.remove();
        	else
        		spaceItem.move();
        }

        // check collisions
        CollisionCheckerAndHandler collisionCheckerService =
        		new CollisionCheckerAndHandler(spaceship, spaceMobsInSpace, 
        				bulletsInSpace, spaceItemsInSpace);
        collisionCheckerService.checkCollisionForBullets();
        collisionCheckerService.checkCollisionBetweenSpaceshipAndSpaceItems();
        
        repaintDelegate.repaintRequest(); // repaint request from panel	
	}
}
