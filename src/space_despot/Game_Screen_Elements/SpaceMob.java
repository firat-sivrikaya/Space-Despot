/**
 * 
 */
package space_despot.Game_Screen_Elements;



public abstract class SpaceMob extends SpaceObject {

	// PROPERTIES
	protected int level;
	protected int maxHP;
	protected int HP;
	protected int attackDamage;
	protected boolean isGoingLeft;
	protected boolean hasCoin;
	protected boolean hasPowerUp;

		
	// CONSTRUCTOR
	public SpaceMob(int level) {
		super();	
		
		this.level = level;
		
		// if space mob has coin, it cant have power-up
		hasCoin = Math.random() >= 0.5;
		
		if (hasCoin) {
			hasPowerUp = false;
		} else {
			hasPowerUp = Math.random() >= 0.5;
		}		
	}

	// METHODS
	public Coin dropCoinIfItHas() {
		if (hasCoin) {
			// create the new coin
			Coin coin = new Coin();
							    
			// coin's initial coordinate will be asteroid's coordinate
			coin.setX(x + width / 2 - coin.getWidth() / 2);
			coin.setY(y);
			return coin;
		} else {
			return null;
		}
	}
	
	public PowerUp dropPowerUpIfItHas() {
		if (hasPowerUp) {
			// create the new power-up
			PowerUp powerUp = new PowerUp();
				    
			// power-up's initial coordinate will be asteroid's coordinate
			powerUp.setX(x + width / 2 - powerUp.getWidth() / 2);
			powerUp.setY(y);	
			return powerUp;
		} else {
			return null;
		}
	}

	// GETTERS AND SETTERS
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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
	
	public boolean isGoingLeft() {
		return isGoingLeft;
	}

	public void setGoingLeft(boolean isGoingLeft) {
		this.isGoingLeft = isGoingLeft;
	}

	public boolean getHasPowerUp() {
		return hasPowerUp;
	}

	public void setHasPowerUp(boolean hasPowerUp) {
		this.hasPowerUp = hasPowerUp;
	}

	public boolean getHasCoin() {
		return hasCoin;
	}

	public void setHasCoin(boolean hasCoin) {
		this.hasCoin = hasCoin;
	}
	
	public int getAttackDamage()
	{
		return this.attackDamage;
	}
}