/**
 * 
 */
package space_despot.Game_Screen_Elements;


public abstract class Bullet extends SpaceObject{
	
	// Constants
	
	// Properties
	protected int attackDamage;
	
	// Constructors
	public Bullet() {
		
	}
	
	public Bullet(int attackDamage)
	{
		this.attackDamage = attackDamage;
	}
	
	// Methods
	public int getAttackDamage()
	{
		return attackDamage;
	}
	
	public void setAttackDamage(int attackDamage)
	{
		this.attackDamage = attackDamage;
	}

}
