package space_despot.Time_Manager;

import java.util.Random;

import space_despot.Constants.Constants;
import space_despot.Game_Screen_Elements.Asteroid;
import space_despot.Game_Screen_Elements.Boss;
import space_despot.Game_Screen_Elements.Creature;
import space_despot.Game_Screen_Elements.SpaceMob;

public class SpaceMobSenderService {

	// method
	public Asteroid sendAsteroid(int gameLevel) {
		// create a new asteroid
     	Asteroid asteroid = new Asteroid(gameLevel);
     	
     	// its y coordinate is certain
        // decide random y coordinate for asteroid
     	Random random = new Random();
     	int minimumY = 1 * Constants.SPACE_HEIGHT / 10;
     	int maximumY = 9 * Constants.SPACE_HEIGHT / 10;
     	int randomCoordinate = random.nextInt(maximumY-minimumY) + minimumY;

     	// set coordinate Y
     	asteroid.setY(randomCoordinate);

     	// set coordinate X
     	if (asteroid.isGoingLeft())
     		asteroid.setX(Constants.SPACE_WIDTH);
     	else
     		asteroid.setX(0);
     	
     	return asteroid;	
	}
	
	// method
	public Creature sendCreature(int gameLevel) {
     	// create a new meteor
		Creature creature = new Creature(gameLevel);
     	
     	// its y coordinate is certain
        // decide random x coordinate for meteor
     	Random random = new Random();
     	int minimumX = 0;
     	int maximumX = Constants.SPACE_WIDTH - creature.getWidth();
     	int randomCoordinate = random.nextInt(maximumX-minimumX) + minimumX;
     	
     	// set coordinate
     	creature.setX(randomCoordinate);
     	
     	// add it to the meteors in the space
     	return creature;		
	}

	public SpaceMob sendBoss(int gameLevel) {
		Boss boss = new Boss(gameLevel);
		return boss;
	}
}
