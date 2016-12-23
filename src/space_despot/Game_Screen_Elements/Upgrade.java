/**
 * 
 */
package space_despot.Game_Screen_Elements;

import space_despot.Constants.Constants;
import space_despot.Enums.UpgradeType;

/**
 * Upgrade
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class Upgrade {
	
	private UpgradeType upgradeType;
	private int cost;
	
	public Upgrade(UpgradeType upgradeType) {
		super();
		this.upgradeType = upgradeType;
		
		if (upgradeType == UpgradeType.MAX_HP) {
			cost = Constants.MAX_HP_UPGRADE_COST;
		}

	}
	
	public UpgradeType getUpgradeType() {
		return upgradeType;
	}
	public void setUpgradeType(UpgradeType upgradeType) {
		this.upgradeType = upgradeType;
	}
	public int getCost() {
		return cost;
	}	
}