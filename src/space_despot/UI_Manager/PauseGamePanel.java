
package space_despot.UI_Manager;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import space_despot.Interfaces.Helpable;
import space_despot.Interfaces.HighScorable;
import space_despot.Interfaces.MainMenuBackable;
import space_despot.Interfaces.Pausable;
import space_despot.Interfaces.Setable;


@SuppressWarnings("serial")
public class PauseGamePanel extends JPanel {

	// Constants
	private final ImageIcon backToGameButtonIcon = new ImageIcon("resources/images/back-to-game-button.png");
    private final ImageIcon highscoresButtonIcon = new ImageIcon("resources/images/highscores-button.png");
    private final ImageIcon settingsButtonIcon = new ImageIcon("resources/images/settings-button.png");
    private final ImageIcon helpButtonIcon = new ImageIcon("resources/images/help-button.png");
    private final ImageIcon backToMainMenuButtonIcon = new ImageIcon("resources/images/back-to-main-menu-button.png");
    
    private Pausable pauseDelegate;
    private MainMenuBackable backToMainMenuDelegate;
    private Setable settingsMenuDelegate;
    private Helpable helpMenuDelegate;
    private HighScorable highScoreMenuDelegate;
    
    private BufferedImage backgroundImage;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton highscoresButton;
    private JButton settingsButton;
    private JButton helpButton;
    private JButton backToMainMenuButton;
    private JButton backToGameButton;
    private JLabel infoLabel;
    // End of variables declaration//GEN-END:variables
    
    // CONSTRUCTOR
    public PauseGamePanel(Pausable pauseDelegate, MainMenuBackable backToMainMenuDelegate,Setable settingsMenuDelegate,Helpable helpMenuDelegate,HighScorable highScoreMenuDelegate) { 
        
        this.pauseDelegate = pauseDelegate;
        this.backToMainMenuDelegate = backToMainMenuDelegate;
        this.settingsMenuDelegate = settingsMenuDelegate;
        this.helpMenuDelegate = helpMenuDelegate;
        this.highScoreMenuDelegate = highScoreMenuDelegate;
       
        // background
        try {
			backgroundImage = ImageIO.read(new File("resources/images/pause-game-background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        // construct components
        infoLabel = new JLabel();
        highscoresButton = new JButton();
        settingsButton = new JButton();
        helpButton = new JButton();
        backToMainMenuButton = new JButton();
        backToGameButton = new JButton();


        backToGameButton.setOpaque(false);
        backToGameButton.setContentAreaFilled(false);
        backToGameButton.setBorderPainted(false);
        backToGameButton.setFocusable(false);
        backToGameButton.setIcon(backToGameButtonIcon);

        
        highscoresButton.setOpaque(false);
        highscoresButton.setContentAreaFilled(false);
        highscoresButton.setBorderPainted(false);
        highscoresButton.setFocusable(false);
        highscoresButton.setIcon(highscoresButtonIcon);
        
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setFocusable(false);
        settingsButton.setIcon(settingsButtonIcon);
        
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        helpButton.setFocusable(false);
        helpButton.setIcon(helpButtonIcon);
        
        backToMainMenuButton.setOpaque(false);
        backToMainMenuButton.setContentAreaFilled(false);
        backToMainMenuButton.setBorderPainted(false);
        backToMainMenuButton.setFocusable(false);
        backToMainMenuButton.setIcon(backToMainMenuButtonIcon);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(backToGameButton, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                    .addComponent(highscoresButton, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToMainMenuButton, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(28, 28, 28)
                .addComponent(backToGameButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(highscoresButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backToMainMenuButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        
        backToGameButton.addActionListener(new BackToGameButtonListener());
        backToMainMenuButton.addActionListener(new BackToMainMenuButtonListener());
        settingsButton.addActionListener(new SettingsButtonListener());
        highscoresButton.addActionListener(new HighScoresButtonListener());
        helpButton.addActionListener(new HelpButtonListener());
        
    }

    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
    
    public class BackToGameButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pauseDelegate.resumeGame();	
		}	
    }
    
    public class BackToMainMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			// BACK TO MAIN MENU
			backToMainMenuDelegate.backToMainMenuAfterGameOver();
		}		
	}
     public class HighScoresButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			
			highScoreMenuDelegate.showHighScoreMenu();
		}		
	}
      public class SettingsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			
			settingsMenuDelegate.showSettingsMenu();
		}		
	}
       public class HelpButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {						
			// BACK TO MAIN MENU
			helpMenuDelegate.showHelpMenu();
		}		
	}
    
}

