package space_despot.UI_Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import space_despot.Enums.SpaceshipType;
import space_despot.Interfaces.GameStartable;
import space_despot.Interfaces.MainMenuBackable;
import space_despot.Interfaces.Repaintable;
import space_despot.Interfaces.TypeChangeable;


@SuppressWarnings("serial")
public class ChooseSpaceshipTypePanel extends JPanel {
	
	// PROPERTIES
    private GameStartable startGameDelegate;
    private Repaintable repaintDelegate;
    private MainMenuBackable backToMainMenuDelegate;
    private TypeChangeable changeTypeDelegate;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton playButton;
    private JButton backButton;
    private JLabel infoLabel;
    private JLabel fighterLabel;
    private JLabel panzerLabel;
    private JLabel lightningLabel;
	private JRadioButton fighter;
	private JRadioButton panzer;
	private JRadioButton lightning;
    // End of variables declaration//GEN-END:variables
    
	// CONSTRUCTOR
    public ChooseSpaceshipTypePanel(GameStartable startGameDelegate, Repaintable repaintDelegate, 
    		MainMenuBackable backToMainMenuDelegate, TypeChangeable changeTypeDelegate) {    	
        
        this.startGameDelegate = startGameDelegate;
        this.repaintDelegate = repaintDelegate;     
        this.backToMainMenuDelegate = backToMainMenuDelegate;
        this.changeTypeDelegate = changeTypeDelegate;
        
        // construct components
        playButton = new JButton();
        infoLabel = new JLabel();
        backButton = new JButton();
        fighter = new JRadioButton();
        panzer = new JRadioButton();
        lightning = new JRadioButton();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fighter);
        buttonGroup.add(panzer);
        buttonGroup.add(lightning);
        fighterLabel = new JLabel();
        panzerLabel = new JLabel();
        lightningLabel = new JLabel();

        playButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        playButton.setText("Play");

        infoLabel.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        infoLabel.setText("Choose Your Ship!");
        infoLabel.setPreferredSize(new java.awt.Dimension(410, 60));

        backButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        backButton.setText("Back");

        fighterLabel.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        fighterLabel.setText("Fighter");

        panzerLabel.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        panzerLabel.setText("Panzer");

        lightningLabel.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lightningLabel.setText("Lightning");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(fighter, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panzer, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lightning, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(fighterLabel)
                                    .addComponent(panzerLabel)
                                    .addComponent(lightningLabel))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(fighterLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fighter, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(panzerLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panzer, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(lightningLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lightning, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(50, 50, 50)
                .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        playButton.addActionListener(new PlayButtonListener());
        backButton.addActionListener(new BackButtonListener());
        
        fighter.addItemListener(new RadioButtonListener());
        panzer.addItemListener(new RadioButtonListener());
        lightning.addItemListener(new RadioButtonListener());
        
        // default
        fighter.setSelected(true);
    }
	
	public class PlayButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			// START GAME
			startGameDelegate.startGame();
		}		
	}
	
	public class BackButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			// BACK TO MAIN MENU
			backToMainMenuDelegate.backToMainMenuAfterGameOver();
		}		
	}
	
	public class RadioButtonListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// update selection
			if (fighter.isSelected()) {
				changeTypeDelegate.changeType(SpaceshipType.FIGHTER);
			} else if (panzer.isSelected()) {
				changeTypeDelegate.changeType(SpaceshipType.PANZER);
			} else {
				changeTypeDelegate.changeType(SpaceshipType.LIGHTNING);
			}	
			
			// redraw
			repaintDelegate.repaintRequest();
		}		
	}
}




/*
package space_despot.UI_Manager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import space_despot.Enums.SpaceshipType;
import space_despot.Interfaces.GameStartable;
import space_despot.Interfaces.MainMenuBackable;
import space_despot.Interfaces.Repaintable;
import space_despot.Interfaces.TypeChangeable;


@SuppressWarnings("serial")
public class ChooseSpaceshipTypePanel extends JPanel {
	
	// PROPERTIES
    private GameStartable startGameDelegate;
    private Repaintable repaintDelegate;
    private MainMenuBackable backToMainMenuDelegate;
    private TypeChangeable changeTypeDelegate;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton playButton;
    private JButton backButton;
    private JLabel infoLabel;
    private JLabel fighterLabel;
    private JLabel panzerLabel;
    private JLabel lightningLabel;
	private JRadioButton fighter;
	private JRadioButton panzer;
	private JRadioButton lightning;
    // End of variables declaration//GEN-END:variables
    
	// CONSTRUCTOR
    public ChooseSpaceshipTypePanel(GameStartable startGameDelegate, Repaintable repaintDelegate, 
    		MainMenuBackable backToMainMenuDelegate, TypeChangeable changeTypeDelegate) {    	
        
        this.startGameDelegate = startGameDelegate;
        this.repaintDelegate = repaintDelegate;     
        this.backToMainMenuDelegate = backToMainMenuDelegate;
        this.changeTypeDelegate = changeTypeDelegate;
        
        // construct components
        playButton = new JButton();
        infoLabel = new JLabel();
        backButton = new JButton();
        fighter = new JRadioButton();
        panzer = new JRadioButton();
        lightning = new JRadioButton();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fighter);
        buttonGroup.add(panzer);
        buttonGroup.add(lightning);
        fighterLabel = new JLabel();
        panzerLabel = new JLabel();
        lightningLabel = new JLabel();

        playButton.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        playButton.setText("Play");

        infoLabel.setFont(new Font("Tahoma", 0, 50)); // NOI18N
        infoLabel.setText("Choose Your Ship!");
        infoLabel.setPreferredSize(new Dimension(410, 60));

        backButton.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        backButton.setText("Back");

        fighterLabel.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        fighterLabel.setText("Fighter");

        panzerLabel.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        panzerLabel.setText("Panzer");

        lightningLabel.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        lightningLabel.setText("Lightning");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(fighter, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panzer, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lightning, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(fighterLabel)
                                    .addComponent(panzerLabel)
                                    .addComponent(lightningLabel))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(fighterLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fighter, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(panzerLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panzer, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(lightningLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lightning, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(50, 50, 50)
                .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        playButton.addActionListener(new PlayButtonListener());
        backButton.addActionListener(new BackButtonListener());
        
        fighter.addItemListener(new RadioButtonListener());
        panzer.addItemListener(new RadioButtonListener());
        lightning.addItemListener(new RadioButtonListener());
        
        // default
        fighter.setSelected(true);
    }
	
	public class PlayButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			// START GAME
			startGameDelegate.startGame();
		}		
	}
	
	public class BackButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			// BACK TO MAIN MENU
			backToMainMenuDelegate.backToMainMenuAfterGameOver();
		}		
	}
	
	public class RadioButtonListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// update selection
			if (fighter.isSelected()) {
				changeTypeDelegate.changeType(SpaceshipType.FIGHTER);
			} else if (panzer.isSelected()) {
				changeTypeDelegate.changeType(SpaceshipType.PANZER);
			} else {
				changeTypeDelegate.changeType(SpaceshipType.LIGHTNING);
			}	
			
			// redraw
			repaintDelegate.repaintRequest();
		}		
	}
}
*/