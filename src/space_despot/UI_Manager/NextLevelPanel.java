package space_despot.UI_Manager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import space_despot.Application_Logic.MusicManager;
import space_despot.Enums.UpgradeType;
import space_despot.Game_Screen_Elements.Upgrade;
import space_despot.Interfaces.LevelPassable;
import space_despot.Interfaces.Repaintable;
import space_despot.Interfaces.UpgradableShip;


@SuppressWarnings("serial")
public class NextLevelPanel extends JPanel { 
	
	// PROPERTIES
    private LevelPassable passLevelDelegate;
    private Repaintable repaintDelegate;
    private UpgradableShip upgradeDelegate;
    private MusicManager musicManager;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton continueNextLevelButton;
    private JButton exitButton;
    private JLabel increaseMaxHPLabel;
    private JButton increaseMaxHPButton;
    private JLabel increaseAttackDamageLabel;
    private JButton increaseAttackDamageButton;
    private JLabel increaseMovementSpeedLabel;
    private JButton increaseMovementSpeedButton;

    // End of variables declaration//GEN-END:variables

    // CONSTRUCTOR
    public NextLevelPanel(LevelPassable passLevelDelegate, 
    		Repaintable repaintDelegate, UpgradableShip upgradeDelegate, MusicManager musicManager) {
        
        this.passLevelDelegate = passLevelDelegate;
        this.upgradeDelegate = upgradeDelegate;
        this.repaintDelegate = repaintDelegate;
        this.musicManager = musicManager;
        
        // construct components
              
        continueNextLevelButton = new JButton("Continue Next Level");    
        exitButton = new JButton("Exit Game");

        increaseMaxHPLabel = new JLabel("Increase Max HP");     
        increaseMaxHPButton = new JButton("+");      
        
        increaseAttackDamageLabel = new JLabel("Increase Attack Damage");     
        increaseAttackDamageButton = new JButton("+");
        
        increaseMovementSpeedLabel = new JLabel("Increase Movement Speed");     
        increaseMovementSpeedButton = new JButton("+");
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addComponent(continueNextLevelButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)                  
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(increaseMaxHPButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(increaseAttackDamageButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(increaseMovementSpeedButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(increaseMaxHPLabel)
                                    .addComponent(increaseAttackDamageLabel)
                                    .addComponent(increaseMovementSpeedLabel))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(increaseMaxHPLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(increaseMaxHPButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(increaseAttackDamageLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(increaseAttackDamageButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(increaseMovementSpeedLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(increaseMovementSpeedButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
             
                .addGap(50, 50, 50)
                .addComponent(continueNextLevelButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        
        continueNextLevelButton.addActionListener(new ContinueNextLevelButtonListener());
        increaseMaxHPButton.addActionListener(new IncreaseMaxHPButtonListener());
        
    }

    public class ContinueNextLevelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			passLevelDelegate.continueNextLevel();
		}    	
    }
    
    public class ViewSettingsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

		}    	
    }
    
    public class IncreaseMaxHPButtonListener implements ActionListener {
    	@Override
		public void actionPerformed(ActionEvent arg0) {
    		// set upgrade and do it for spaceship
			Upgrade upgrade = new Upgrade(UpgradeType.MAX_HP);
			upgradeDelegate.doUpgradeWithCoins(upgrade);
			// do sound
			musicManager.playUpgradeSound();
			// repaint for updates (coin, maxHP etc)
			repaintDelegate.repaintRequest();
			
		}   	
    }
}