package space_despot.UI_Manager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class GUIManager {
	
	private JPanel contentPane;
    private MainMenuScreen mainMenuScreen;
    private PlayGameScreen playGameScreen;
    private ViewSettingsScreen viewSettingsScreen;
    private ViewHighscoresScreen viewHighscoresScreen;
    private ViewHelpScreen viewHelpScreen;
    private BufferedImage icon;

  
    private void displayGUI()
    {
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
     	frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(63, 134, 145)));
     	try {
			icon = ImageIO.read(new File("resources/images/icon.png"));
			frame.setIconImage(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
     	
     	
        contentPane = new JPanel();
        contentPane.setLayout(new CardLayout());
        
        mainMenuScreen = new MainMenuScreen(contentPane);
        playGameScreen = new PlayGameScreen(contentPane);
        viewSettingsScreen = new ViewSettingsScreen(contentPane, playGameScreen); // as KeysChangeable
        viewHighscoresScreen = new ViewHighscoresScreen(contentPane);
        viewHelpScreen = new ViewHelpScreen(contentPane);
        
        contentPane.add(mainMenuScreen, "Main Menu Screen"); 
        contentPane.add(playGameScreen, "Game Screen");
        contentPane.add(viewSettingsScreen, "View Settings Screen");
        contentPane.add(viewHighscoresScreen, "View Highscores Screen");
        contentPane.add(viewHelpScreen, "View Help Screen");

        frame.setContentPane(contentPane);

        
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUIManager().displayGUI();
            }
        });
    }
}