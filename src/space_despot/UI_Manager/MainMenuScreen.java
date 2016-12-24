package space_despot.UI_Manager;


import java.awt.CardLayout;
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
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenuScreen extends JPanel { 
	
	// Constants
    private final ImageIcon playGameButtonIcon = new ImageIcon("resources/images/play-game-button.png");
    private final ImageIcon upgradesButtonIcon = new ImageIcon("resources/images/upgrades-button.png");
    private final ImageIcon highscoresButtonIcon = new ImageIcon("resources/images/highscores-button.png");
    private final ImageIcon settingsButtonIcon = new ImageIcon("resources/images/settings-button.png");
    private final ImageIcon helpButtonIcon = new ImageIcon("resources/images/help-button.png");
    private final ImageIcon exitButtonIcon = new ImageIcon("resources/images/exit-button.png");
    
	// PROPERTIES
    private JPanel contentPane;
    private BufferedImage backgroundImage;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton upgradesButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JButton playGameButton;
    private JButton helpButton;
    private JButton highscoresButton;
    

    // End of variables declaration//GEN-END:variables

    // CONSTRUCTOR
    public MainMenuScreen(JPanel contentPane) 
    {
        this.contentPane = contentPane;
     
        // background
        try {
			backgroundImage = ImageIO.read(new File("resources/images/main-menu-background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        // construct components
        upgradesButton = new JButton();
        settingsButton = new JButton();
        exitButton = new JButton();
        playGameButton = new JButton();
        helpButton = new JButton();
        highscoresButton = new JButton();

        playGameButton.setOpaque(false);
        playGameButton.setContentAreaFilled(false);
        playGameButton.setBorderPainted(false);
        playGameButton.setFocusable(false);
        playGameButton.setIcon(playGameButtonIcon);
        
        upgradesButton.setOpaque(false);
        upgradesButton.setContentAreaFilled(false);
        upgradesButton.setBorderPainted(false);
        upgradesButton.setFocusable(false);
        upgradesButton.setIcon(upgradesButtonIcon);
        
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
        
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusable(false);
        exitButton.setIcon(exitButtonIcon);
        

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(upgradesButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(playGameButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(highscoresButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(playGameButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(upgradesButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(highscoresButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        

        playGameButton.addActionListener(new PlayGameButtonListener()); 
        upgradesButton.addActionListener(new UpgradesButtonListener());
        settingsButton.addActionListener(new ViewSettingsButtonListener());      
        highscoresButton.addActionListener(new ViewHighscoresButtonListener());
        helpButton.addActionListener(new ViewHelpButtonListener());
        exitButton.addActionListener(new ExitButtonListener());
        
    }

    
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}


	public class PlayGameButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();		
			cardLayout.show(contentPane, "Game Screen");
		}    	
    }
	public class UpgradesButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();		
			cardLayout.show(contentPane, "Upgrades Screen");
		}    	
    }
    
    public class ViewSettingsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();	
			cardLayout.show(contentPane, "View Settings Screen");
		}    	
    }
    
    public class ViewHighscoresButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			((ViewHighscoresScreen) contentPane.getComponent(3)).updateHighscores();
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();	
			cardLayout.show(contentPane, "View Highscores Screen");
		}    	
    }
    
    public class ViewHelpButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();	
			cardLayout.show(contentPane, "View Help Screen");
		}    	
    }
    
    public class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}    	
    }
}