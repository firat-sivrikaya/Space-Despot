package space_despot.Time_Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.SpaceItem;
import space_despot.Game_Screen_Elements.SpaceMob;
import space_despot.Game_Screen_Elements.SpaceObstacle;
import space_despot.Game_Screen_Elements.Spaceship;
import space_despot.Interfaces.GameOverMakable;
import space_despot.Interfaces.LevelPassable;
import space_despot.Interfaces.Repaintable;


public class TimeController implements ActionListener {

	// properties
	private Spaceship spaceship;
	private List<SpaceMob> spaceMobsInSpace;
	private List<Bullet> bulletsInSpace;
	private List<SpaceItem> spaceItemsInSpace;
	private List<SpaceObstacle> spaceObstaclesInSpace;
	
	private Repaintable repaintDelegate; // to make repaint request from here to panel
	private LevelPassable passLevelDelegate;
	private GameOverMakable makeGameOverDelegate;
	
	private SpaceMobSenderService spaceMobSenderService;
	private SpaceObstacleSenderService spaceObstacleSenderService;
	
	private Timer timer;
	private int count;

	private boolean isBossTime;
	
	// CONSTRUCTOR
	public TimeController(Spaceship spaceship, List<SpaceMob> spaceMobsInSpace, 
			List<Bullet> bulletsInSpace, List<SpaceItem> spaceItemsInSpace, 
			List<SpaceObstacle> spaceObstaclesInSpace,
			Repaintable repaintDelegate, LevelPassable passLevelDelegate, 
			GameOverMakable makeGameOverDelegate) {
		this.spaceship = spaceship;
		this.spaceMobsInSpace = spaceMobsInSpace;
		this.bulletsInSpace = bulletsInSpace;
		this.spaceItemsInSpace = spaceItemsInSpace;
		this.spaceObstaclesInSpace = spaceObstaclesInSpace;
		this.repaintDelegate = repaintDelegate;
		this.passLevelDelegate = passLevelDelegate;
		this.makeGameOverDelegate = makeGameOverDelegate;
		
		spaceMobSenderService = new SpaceMobSenderService();
		spaceObstacleSenderService = new SpaceObstacleSenderService();

		isBossTime = false;
		
		timer = new Timer(15, this);
	}

	// start timer
	public void startTimer() {
		timer.start();
	}
	
	public void stopTimer() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// reset isBossTime at the beginning
		if (count == 1) {
			isBossTime = false;
		}

		// increase score each 300 ms
		if (count%20 == 0 && !isBossTime) {
			spaceship.setScore(spaceship.getScore() + 1);
		}			
		
		// send creature each 600 ms
        if (count%40 == 0 && !isBossTime) {
        	spaceMobsInSpace.add(spaceMobSenderService
        			.sendCreature(passLevelDelegate.getGameLevel()));
        }
        
        // send asteroid each 900 ms
        if (count%60 == 0 && !isBossTime) {
        	spaceMobsInSpace.add(spaceMobSenderService
        			.sendAsteroid(passLevelDelegate.getGameLevel()));
        	spaceObstaclesInSpace.add(spaceObstacleSenderService.sendStar());
        }
        
        // send bullets from all creatures each 900 ms
        if (count%60 == 0) {
        	SpaceMobsShootingService spaceMobsShootingService = new SpaceMobsShootingService(
    				spaceMobsInSpace, bulletsInSpace);
        	spaceMobsShootingService.sendBulletsFromMobs(); 		
        }       
        //send blackhole
        if(count == 300)
        	spaceObstaclesInSpace.add(spaceObstacleSenderService.sendBlackhole());
        
        // boss time for first level
        if (count == 600) {
        	isBossTime = true;
        }
        	
        // send boss
        if (count == 750) {        	
        	// create boss
        	spaceMobsInSpace.add(spaceMobSenderService.sendBoss(passLevelDelegate.getGameLevel()));
        }            
        
        // do updates which also include collision handles
        UpdateService updateService = new UpdateService(spaceship, spaceMobsInSpace,
				bulletsInSpace, spaceItemsInSpace, spaceObstaclesInSpace, repaintDelegate, 
				makeGameOverDelegate, passLevelDelegate);
        updateService.updateObjects();
        
        count++;
	}

	// setter for count
	public void setCount(int count) {
		this.count = count;
	}
}
