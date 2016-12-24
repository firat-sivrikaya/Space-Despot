package space_despot.Time_Manager;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.List;

import space_despot.Game_Screen_Elements.BossBullet;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.Coin;
import space_despot.Game_Screen_Elements.CreatureBullet;
import space_despot.Game_Screen_Elements.LaserBullet;
import space_despot.Game_Screen_Elements.PowerUp;
import space_despot.Game_Screen_Elements.SpaceItem;
import space_despot.Game_Screen_Elements.SpaceMob;
import space_despot.Game_Screen_Elements.SpaceObstacle;
import space_despot.Game_Screen_Elements.Spaceship;
import space_despot.Game_Screen_Elements.SpaceshipBullet;


public class CollisionCheckerAndHandler {
	
	// properties
	private Spaceship spaceship;
    private List<SpaceMob> spaceMobsInSpace;
    private List<Bullet> bulletsInSpace;
    private List<SpaceItem> spaceItemsInSpace;
    private List<SpaceObstacle> spaceObstaclesInSpace;
    
	// constructor
    public CollisionCheckerAndHandler(Spaceship spaceship, List<SpaceMob> spaceMobsInSpace,
    		List<Bullet> bulletsInSpace, List<SpaceItem> spaceItemsInSpace, List<SpaceObstacle> spaceObstaclesInSpace) {
		this.spaceship = spaceship;
		this.spaceMobsInSpace = spaceMobsInSpace;
		this.bulletsInSpace = bulletsInSpace;
		this.spaceItemsInSpace = spaceItemsInSpace;
		this.spaceObstaclesInSpace = spaceObstaclesInSpace;
	}
    
	// check collision between spaceship bullets and mobs
	public void checkCollisionForBullets() {
		Iterator<Bullet> bulletIterator = bulletsInSpace.iterator();
		Rectangle rectSpaceship = spaceship.getBounds();
		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			
			// bullets from spaceship to the space mobs
			if (bullet instanceof SpaceshipBullet || bullet instanceof LaserBullet) {
				Rectangle rectBullet = bullet.getBounds();  
				
				Iterator<SpaceMob> spaceMobIterator = spaceMobsInSpace.iterator();
				while (spaceMobIterator.hasNext()) {
					SpaceMob spaceMob = spaceMobIterator.next();
					
					Rectangle rectSpaceMob = spaceMob.getBounds();
					
					if (rectBullet.intersects(rectSpaceMob)) {												
						spaceMob.setHP(spaceMob.getHP() - bullet.getAttackDamage());
						
						// we do not remove laser since it is piercing through all
						if (bullet instanceof SpaceshipBullet)
							bulletIterator.remove();
	                }	
				}
			}
			
			// incoming bullets from space mobs to the spaceship
			if (bullet instanceof CreatureBullet || bullet instanceof BossBullet) {
				Rectangle rectBullet = bullet.getBounds();  
				if (rectBullet.intersects(rectSpaceship) && !spaceship.isInvulnerable()) {						
					spaceship.setHP(spaceship.getHP() - bullet.getAttackDamage());
					bulletIterator.remove();
                }						
			}
			
		}		
	}

	// check collision between spaceship and space items (power up or coin)
	public void checkCollisionBetweenSpaceshipAndSpaceItems() {
		Rectangle rectSpaceship = spaceship.getBounds();
		
		Iterator<SpaceItem> spaceItemIterator = spaceItemsInSpace.iterator();
		while (spaceItemIterator.hasNext()) {
			SpaceItem spaceItem = spaceItemIterator.next();
	
			Rectangle rectSpaceItem = spaceItem.getBounds();
			
			// if spaceship intersects with power-up or coin
			if (rectSpaceship.intersects(rectSpaceItem)) {
				
				// if spaceship collects coin
				if (spaceItem instanceof Coin) {
					spaceship.pickCoin((Coin) spaceItem);
					spaceItemIterator.remove(); // remove collected coin
				} 
				
				// if spaceship collects power-up
				if (spaceItem instanceof PowerUp) {
					if (spaceship.pickPowerUp((PowerUp) spaceItem)) {
						spaceItemIterator.remove(); // remove collected power-up
					} else {
						// spaceship already has power-up, nothing to do
					}	
				}						
            }				
		}			
	}
	
	public void checkCollisionBetweenSpaceshipAndSpaceMobs()
	{
		Rectangle rectSpaceship = spaceship.getBounds();
		Iterator<SpaceMob> spaceMobIterator = spaceMobsInSpace.iterator();
		
		while(spaceMobIterator.hasNext())
		{
			SpaceMob mob = spaceMobIterator.next();
			Rectangle rectMob = mob.getBounds();
			
			if(rectSpaceship.intersects(rectMob) && !spaceship.isInvulnerable())
			{
				spaceship.setHP(spaceship.getHP() - mob.getAttackDamage());
				mob.setHP(0);
				spaceMobIterator.remove();
			}
		}
	}
	
	public void checkCollisionBetweenSpaceshipAndSpaceObstacles()
	{
		Rectangle rectSpaceship = spaceship.getBounds();
		Iterator<SpaceObstacle> spaceObstacleIterator = spaceObstaclesInSpace.iterator();
		
		while(spaceObstacleIterator.hasNext())
		{
			SpaceObstacle obstacle = spaceObstacleIterator.next();
			Rectangle rectObstacle = obstacle.getBounds();
			
			if(rectSpaceship.intersects(rectObstacle))
			{
				spaceship.setHP(0);
			}
		}
	}

	
}
