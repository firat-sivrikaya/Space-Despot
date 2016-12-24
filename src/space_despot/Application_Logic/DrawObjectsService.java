package space_despot.Application_Logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.List;

import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.SpaceItem;
import space_despot.Game_Screen_Elements.SpaceMob;
import space_despot.Game_Screen_Elements.SpaceObstacle;
import space_despot.Game_Screen_Elements.Spaceship;
import space_despot.Interfaces.LevelPassable;

public class DrawObjectsService {
	
	private Graphics2D g2;
	private ImageObserver imageObserver;	
	private Spaceship spaceship;
    private List<SpaceMob> spaceMobsInSpace; // asteroids and creatures
    private List<Bullet> bulletsInSpace; // spaceship bullets and creature bullets
    private List<SpaceItem> spaceItemsInSpace; // power-ups and coins
    private List<SpaceObstacle> spaceObstaclesInSpace;
    private LevelPassable passLevelDelegate;
      
    public DrawObjectsService(Graphics g, ImageObserver imageObserver,
    		Spaceship spaceship, List<SpaceMob> spaceMobsInSpace, 
    		List<Bullet> bulletsInSpace, List<SpaceItem> spaceItemsInSpace, List<SpaceObstacle> spaceObstaclesInSpace,
    		LevelPassable passLevelDelegate) {
    	
    	g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
		
        this.imageObserver = imageObserver;
        this.spaceship = spaceship;
		this.spaceMobsInSpace = spaceMobsInSpace;
		this.bulletsInSpace = bulletsInSpace;
		this.spaceItemsInSpace = spaceItemsInSpace;
		this.spaceObstaclesInSpace = spaceObstaclesInSpace;
		this.passLevelDelegate = passLevelDelegate;
	}

	public void drawObjects() {
    	// draw spaceship
        g2.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), 
        		spaceship.getWidth(), spaceship.getHeight(), imageObserver);
        
        // draw spaceship hp
        g2.setColor(new Color(153, 217, 234));
        
        // it is 0 hp now
    	g2.drawRect(10, 20, 100, 8);
    
    	// it is real hp now
    	g2.fillRect(10, 20, 100 * spaceship.getHP() / spaceship.getMaxHP(), 8);
    	
    	// type hp / maxHP
    	g2.drawString("" + spaceship.getHP() + "/" + spaceship.getMaxHP(), 10, 48);
    	
    	// draw attack damage
    	g2.drawString("Attack Damage: " + spaceship.getAttackDamage(), 10, 68);
    	
    	// draw power-up
    	if (spaceship.getCurrentPowerUp() != null)
        	g2.drawString("Power-up: " + spaceship.getCurrentPowerUp().getType().toString(), 10, 88);
        else
        	g2.drawString("Power-up: X", 10, 88);
    	
    	
        
        // draw score and coin and level
        g2.drawString("Score: " + spaceship.getScore(), 630, 20);
        g2.drawString("Coin: " + spaceship.getCoin(), 630, 40);
        g2.drawString("Level: " + passLevelDelegate.getGameLevel() , 630, 60);
        
         
        // draw mobs and their hp bars
        Iterator<SpaceMob> spaceMobIterator = spaceMobsInSpace.iterator();
        while (spaceMobIterator.hasNext()) {
        	SpaceMob spaceMob = spaceMobIterator.next();
        	
        	g2.drawImage(spaceMob.getImage(), spaceMob.getX(), spaceMob.getY(), 
        			spaceMob.getWidth(), spaceMob.getHeight(), imageObserver);
        	
        	g2.setColor(new Color(3, 169, 144));
        	
        	// it is 0 hp now
        	g2.drawRect(spaceMob.getX(), spaceMob.getY() - 20, spaceMob.getWidth(), 8);
        
        	// it is real hp now
        	g2.fillRect(spaceMob.getX(), spaceMob.getY() - 20, 
        			spaceMob.getWidth() * spaceMob.getHP() / spaceMob.getMaxHP(), 8);
        }    
        
        // draw bullets
        Iterator<Bullet> bulletIterator = bulletsInSpace.iterator();
        while (bulletIterator.hasNext()) {
        	Bullet bullet = bulletIterator.next();
        	g2.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), 
        			bullet.getWidth(), bullet.getHeight(), imageObserver);
        } 
        
        // draw power-ups
        Iterator<SpaceItem> spaceItemIterator = spaceItemsInSpace.iterator();
        while (spaceItemIterator.hasNext()) {
        	SpaceItem spaceItem = spaceItemIterator.next();
        	g2.drawImage(spaceItem.getImage(), spaceItem.getX(), spaceItem.getY(), 
        			spaceItem.getWidth(), spaceItem.getHeight(), imageObserver);
        }
        
        //draw obstacles
        Iterator<SpaceObstacle> spaceObstacleIterator = spaceObstaclesInSpace.iterator();
        while(spaceObstacleIterator.hasNext())
        {
        	SpaceObstacle obstacle = spaceObstacleIterator.next();
        	g2.drawImage(obstacle.getImage(), obstacle.getX(), obstacle.getY(),
        			obstacle.getWidth(), obstacle.getHeight(), imageObserver);
        }
    }

}
