package space_despot.Game_Screen_Elements;

import java.util.HashSet;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;
import space_despot.Enums.Movement;
import space_despot.Enums.SpaceshipType;
import space_despot.Enums.UpgradeType;
import space_despot.Interfaces.TypeChangeable;
import space_despot.Interfaces.UpgradableShip;



public class Spaceship extends SpaceObject implements UpgradableShip, TypeChangeable {

	// Constants
    private final ImageIcon FIGHTER_ICON = new ImageIcon("resources/images/fighter.png");
    
    private final ImageIcon PANZER_ICON = new ImageIcon("resources/images/panzer.png");
    
    private final ImageIcon LIGHTNING_ICON = new ImageIcon("resources/images/lightning.png");
    	
    // Properties
    private SpaceshipType type;
    private int maxHP;
    private int HP;
    private int attackDamage;
	private boolean isBulletReady;
	private HashSet<Movement> movements;
	private PowerUp currentPowerUp;
	private int coin;
	private int score;
    
	// CONSTRUCTOR
	public Spaceship() {
		// fighter as default
		type = SpaceshipType.FIGHTER;
		maxHP = Constants.FIGHTER_MAX_HP;
		HP = maxHP;
		attackDamage = Constants.FIGHTER_ATTACK_DAMAGE;
		image = FIGHTER_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = Constants.FIGHTER_VELOCITY;
		velocityY = Constants.FIGHTER_VELOCITY;
		isBulletReady = true;
		movements = new HashSet<Movement>(); // no left or right initially
		currentPowerUp = null; // initially
		coin = 0; // initially
		score = 0; // initially
	}
    
    // Methods
	// adding movement is done by pressing right or left arrow key
	public void addMovement(Movement movement) {
		movements.add(movement);
	}
	
	public void removeMovement(Movement movement) {
		movements.remove(movement);
	}
	
	// move according to movements
	@Override
	public void move() {
		// if player presses both left and right arrow key
		// x coordinate will not change
		if (movements.contains(Movement.LEFT)) 
			x = x - velocityX;		   		
    	
        if (movements.contains(Movement.RIGHT)) 
        	x = x + velocityX;     
        
        // if player presses both up and down arrow key
     	// y coordinate will not change
        if (movements.contains(Movement.UP)) 
			y = y - velocityY;		   		
    	
        if (movements.contains(Movement.DOWN)) 
        	y = y + velocityY; 
	}
	
	// shoot current bullet
	public SpaceshipBullet shootNewBullet() {
	    // create the new bullet
		SpaceshipBullet bullet = new SpaceshipBullet(attackDamage);
	    
	    // bullet's initial coordinate will be spaceship's barrel coordinate
	    bullet.setX(x + width / 2 - bullet.getWidth() / 2);
	    bullet.setY(y - 6);
	    
	    // bullet will be sent so charge is empty now
	    isBulletReady = false;
	    
	    return bullet;
	}
	
	public LaserBullet shootNewLaserBullet() {
	    // create the new bullet
		LaserBullet laserBullet = new LaserBullet();			
	    
	    // bullet's initial coordinate will be spaceship's barrel coordinate
		// 30 is for display time
		laserBullet.setX(x + width / 2 - laserBullet.getWidth() / 2);
		laserBullet.setY(30);
		
		// height is from barrel to the up-end of space
		laserBullet.setHeight(y);
	    
	    return laserBullet;
	}
	
	// refill new bullet to the charge
	public void refillBullet() {
		isBulletReady = true;
	}
	
	// pick power-up
	public boolean pickPowerUp(PowerUp powerUp) {
		if (currentPowerUp == null) {
			currentPowerUp = powerUp;
			return true;
		} else {
			return false;
		}	
	}
	
	// use power-up
	public PowerUp usePowerUp() {
		if (currentPowerUp != null) {
			PowerUp temp = currentPowerUp;
			currentPowerUp = null;
			return temp;
		} else {
			return null;
		}
	}
	
	// pick coin
	public void pickCoin(Coin coin) {
		this.coin = this.coin + coin.getValue();
	}
	
	// use coins
	@Override
	public boolean doUpgradeWithCoins(Upgrade upgrade) {
		if (upgrade.getUpgradeType() == UpgradeType.MAX_HP) {			
			if (coin >= upgrade.getCost()) {
				maxHP = maxHP + ((maxHP * 10) / 100);
				coin = coin - upgrade.getCost();
				// set hp to max hp again
				HP = maxHP;
				return true;
			} else {
				return false;
			}			
		}
		
		return false;
	}

	// getters and setters
	public SpaceshipType getType() {
		return type;
	}

	@Override
	public void changeType(SpaceshipType type) {
		if (type == SpaceshipType.FIGHTER) {
			type = SpaceshipType.FIGHTER;
			maxHP = Constants.FIGHTER_MAX_HP;
			HP = maxHP;
			attackDamage = Constants.FIGHTER_ATTACK_DAMAGE;
			image = FIGHTER_ICON.getImage();
			width = image.getWidth(null);
			height = image.getHeight(null);	
			velocityX = Constants.FIGHTER_VELOCITY;
			velocityY = Constants.FIGHTER_VELOCITY;	
		} else if (type == SpaceshipType.PANZER) {
			type = SpaceshipType.PANZER;
			maxHP = Constants.PANZER_MAX_HP;
			HP = maxHP;
			attackDamage = Constants.PANZER_ATTACK_DAMAGE;
			image = PANZER_ICON.getImage();
			width = image.getWidth(null);
			height = image.getHeight(null);	
			velocityX = Constants.PANZER_VELOCITY;
			velocityY = Constants.PANZER_VELOCITY;	
		} else {
			type = SpaceshipType.LIGHTNING;
			maxHP = Constants.LIGHTNING_MAX_HP;
			HP = maxHP;
			attackDamage = Constants.LIGHTNING_ATTACK_DAMAGE;
			image = LIGHTNING_ICON.getImage();
			width = image.getWidth(null);
			height = image.getHeight(null);	
			velocityX = Constants.LIGHTNING_VELOCITY;
			velocityY = Constants.LIGHTNING_VELOCITY;	
		}
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public boolean isBulletReady() {
		return isBulletReady;
	}

	public void setBulletReady(boolean isBulletReady) {
		this.isBulletReady = isBulletReady;
	}

	public HashSet<Movement> getMovements() {
		return movements;
	}

	public void setMovements(HashSet<Movement> movements) {
		this.movements = movements;
	}

	public PowerUp getCurrentPowerUp() {
		return currentPowerUp;
	}

	public void setCurrentPowerUp(PowerUp currentPowerUp) {
		this.currentPowerUp = currentPowerUp;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}