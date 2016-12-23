package space_despot.Time_Manager;

import java.util.Iterator;
import java.util.List;

import space_despot.Game_Screen_Elements.Boss;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.Creature;
import space_despot.Game_Screen_Elements.SpaceMob;

public class SpaceMobsShootingService {
	
	// PROPERTIES
	private List<SpaceMob> spaceMobsInSpace;
	private List<Bullet> bulletsInSpace;
	
	// CONSTRUCTOR
	public SpaceMobsShootingService(List<SpaceMob> spaceMobsInSpace, List<Bullet> bulletsInSpace) {
		this.spaceMobsInSpace = spaceMobsInSpace;
		this.bulletsInSpace = bulletsInSpace;
	}
	
	// METHODS
	public void sendBulletsFromMobs() {
		Iterator<SpaceMob> iterator = spaceMobsInSpace.iterator();
		while (iterator.hasNext()) {
			SpaceMob spaceMob = iterator.next();
			if (spaceMob instanceof Creature) {
				bulletsInSpace.add(((Creature) spaceMob).shoot());
			}
			else if (spaceMob instanceof Boss) {
				bulletsInSpace.add(((Boss) spaceMob).shoot());
			}
		}		
	}
}
