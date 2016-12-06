/**
 * 
 */
package space_despot.Game_Screen_Elements;

/**
 * SpaceMob
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class SpaceMob extends SpaceObject{
	// Constants
	// Properties
	protected int level;
	protected int maxHP;
	protected int HP;
	protected int attackDamage;
	protected boolean hasCoin;
	protected boolean hasPowerUp;
	// Constructor
	public SpaceMob()
	{
		super();
	}
	// Methods
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
	public int getAttackDamage() {
		return attackDamage;
	}
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	public boolean hasCoin() {
		return hasCoin;
	}
	public void setHasCoin(boolean hasCoin) {
		this.hasCoin = hasCoin;
	}
	public boolean hasPowerUp() {
		return hasPowerUp;
	}
	public void setHasPowerUp(boolean hasPowerUp) {
		this.hasPowerUp = hasPowerUp;
	}
	
	public Coin dropCoin()
	{
		// to be implemented
		return new Coin(0);
	}
	
	public PowerUp dropPowerUp()
	{
		// to be implemented
		return new PowerUp(PowerUpType.HYPER_DRIVE);
	}
	
	

}
