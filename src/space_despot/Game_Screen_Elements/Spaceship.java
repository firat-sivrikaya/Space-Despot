package space_despot.Game_Screen_Elements;

import java.io.File;

import javax.swing.ImageIcon;

import space_despot.Constants.*;



public class Spaceship extends SpaceObject {

	// Constants
    private final ImageIcon FIGHTER_ICON = new ImageIcon("resources/image/fighter.png");
    	
    // Properties
    private SpaceshipType spaceshipType;
    private int maxHP;
    private int HP;
    private int attackDamage;
    private PowerUp currentPowerUp;
    private int currentCoin;
    
    // Constructor
    public Spaceship () {   	
    	image = FIGHTER_ICON.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = Constants.SPACESHIP_INITIAL_VELOCITY;
		velocityY = Constants.SPACESHIP_INITIAL_VELOCITY;
    }
    
    // Methods

	public SpaceshipType getSpaceshipType() {
		return spaceshipType;
	}

	public void setSpaceshipType(SpaceshipType spaceshipType) {
		this.spaceshipType = spaceshipType;
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

	public PowerUp getCurrentPowerUp() {
		return currentPowerUp;
	}

	public void setCurrentPowerUp(PowerUp currentPowerUp) {
		this.currentPowerUp = currentPowerUp;
	}

	public int getCurrentCoin() {
		return currentCoin;
	}

	public void setCurrentCoin(int currentCoin) {
		this.currentCoin = currentCoin;
	} 
	
	public void changeType(SpaceshipType s)
	{
		spaceshipType = s;
	}
	
	public void shoot()
	{
		// to be implemented
	}
	
	public void pickCoin(Coin c)
	{
		// to be implemented
	}
	
	public boolean pickPowerUp(PowerUp p)
	{
		// to be implemented
		return true;
	}
	
	public boolean usePowerUp()
	{
		// to be implemented
		return true;
	}
	
	public boolean doUpgradeWithCoins(Upgrade u)
	{
		// to be implemented
		return true;
	}
    
}
