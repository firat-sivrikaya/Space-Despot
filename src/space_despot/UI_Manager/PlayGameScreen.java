package space_despot.UI_Manager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import space_despot.Application_Logic.DrawObjectsService;
import space_despot.Application_Logic.GameResetterService;
import space_despot.Application_Logic.MusicManager;
import space_despot.Application_Logic.NewLevelSetterService;
import space_despot.Constants.Constants;
import space_despot.Game_Screen_Elements.Bullet;
import space_despot.Game_Screen_Elements.SpaceItem;
import space_despot.Game_Screen_Elements.SpaceMob;
import space_despot.Game_Screen_Elements.Spaceship;
import space_despot.Input_Manager.PauseGameController;
import space_despot.Input_Manager.SpaceshipMovementController;
import space_despot.Input_Manager.SpaceshipShootingController;
import space_despot.Input_Manager.SpaceshipUsingPowerUpController;
import space_despot.Interfaces.GameOverMakable;
import space_despot.Interfaces.GameStartable;
import space_despot.Interfaces.Helpable;
import space_despot.Interfaces.HighScorable;
import space_despot.Interfaces.KeysChangeable;
import space_despot.Interfaces.LevelPassable;
import space_despot.Interfaces.MainMenuBackable;
import space_despot.Interfaces.Pausable;
import space_despot.Interfaces.Repaintable;
import space_despot.Interfaces.Setable;
import space_despot.Interfaces.Soundable;

import space_despot.Time_Manager.TimeController;




@SuppressWarnings("serial")
public class PlayGameScreen extends JPanel 
implements Repaintable, Pausable, LevelPassable, 
GameStartable, GameOverMakable, MainMenuBackable, KeysChangeable,HighScorable, Soundable,Setable,Helpable {
	  
    // PROPERTIES
	private JPanel contentPane;
	private BufferedImage backgroundImage;
	private BufferedImage movingBackgroundImage;
	private MusicManager musicManager;
	
	private int gameLevel;
    private Spaceship spaceship;
    
    private List<SpaceMob> spaceMobsInSpace; // asteroids and creatures
    private List<Bullet> bulletsInSpace; // spaceship bullets and creature bullets
    private List<SpaceItem> spaceItemsInSpace; // power-ups and coins
    
    private TimeController timeController;
    
    private SpaceshipMovementController spaceshipMovementKeyBindings;
    private SpaceshipShootingController spaceshipShootingKeyBindings;
    private SpaceshipUsingPowerUpController spaceshipUsingPowerUpKeyBindings;
    private PauseGameController pauseGameController;
    
    private boolean isGamePaused;
    
    private JPanel inGamePanel;
    
    // Properties of moving background
    private int yOffset;
    private int movingBackgroundY;
    
    // CONSTRUCTOR  
    public PlayGameScreen(JPanel contentPane) {
    	super();  	
    	this.contentPane = contentPane;
    	
    	try {
			backgroundImage = ImageIO.read(new File("resources/images/bg.png"));
			movingBackgroundImage = ImageIO.read(new File("resources/images/bg_moving.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	// Set the coordinates of moving background
        movingBackgroundY = 0;
    	yOffset = 0;
		// on create, before game starts, we are in the main menu
    	musicManager = MusicManager.getMusicManager();
		musicManager.startMenuBackgroundMusic();
    	
    	// set space
        setSize(Constants.SPACE_WIDTH, Constants.SPACE_HEIGHT);
        setBackground(new Color(240, 255, 255));
        setLayout(new GridBagLayout());
	
    	// game is ready
    	isGamePaused = false;

        // set level
        gameLevel = 1;
        
        // set spaceship and its start coordinates
        spaceship = new Spaceship();
        spaceship.setX(Constants.SPACE_WIDTH / 2 - spaceship.getWidth() / 2);
        spaceship.setY(Constants.SPACE_HEIGHT - spaceship.getHeight());
            
        // set key bindings for movement of spaceship
        spaceshipMovementKeyBindings = new SpaceshipMovementController(
        		spaceship, getInputMap(WHEN_IN_FOCUSED_WINDOW), getActionMap());
        spaceshipMovementKeyBindings.initMovementKeyBindings();

        // set bullets in space
        bulletsInSpace = new ArrayList<Bullet>();
        
        // set key bindings for shooting bullet with spaceship
        spaceshipShootingKeyBindings = new SpaceshipShootingController(
        		spaceship, bulletsInSpace, 
        		getInputMap(WHEN_IN_FOCUSED_WINDOW), getActionMap(), musicManager);
        spaceshipShootingKeyBindings.initShootingKeyBindings(KeyEvent.VK_X);
        
        // set key bindings for using power-ups with spaceship
        spaceshipUsingPowerUpKeyBindings = new SpaceshipUsingPowerUpController(
        		spaceship, bulletsInSpace, getInputMap(WHEN_IN_FOCUSED_WINDOW), getActionMap());
        spaceshipUsingPowerUpKeyBindings.initUsingPowerUpKeyBindings(KeyEvent.VK_SPACE);
        				
        // control pause
        pauseGameController = new PauseGameController(
        		getInputMap(WHEN_IN_FOCUSED_WINDOW), getActionMap(), this);
        pauseGameController.initPauseKeyBindings();
        
        // set space mobs
        spaceMobsInSpace = new ArrayList<SpaceMob>();
        
        // set power ups
        spaceItemsInSpace = new ArrayList<SpaceItem>();
             
        // set timer, each 15 ms    
        // Repaintable(this) is to do repaint from time controller
        timeController = new TimeController(spaceship,
        		spaceMobsInSpace, bulletsInSpace, spaceItemsInSpace, this, this, this);
              
        // set components
        inGamePanel = new JPanel();
    	inGamePanel.setLayout(new CardLayout());
    	add(inGamePanel);
    	
    	JPanel pausePanel = new PauseGamePanel(this,this,this,this, this);
    	JPanel nextLevelPanel = new NextLevelPanel(this, this, spaceship);
    	JPanel chooseSpaceshipTypePanel = new ChooseSpaceshipTypePanel(this, this, this, spaceship);
    	
    	inGamePanel.add(pausePanel, "Pause Panel"); 
    	inGamePanel.add(nextLevelPanel, "Next Level Panel");   	
    	inGamePanel.add(chooseSpaceshipTypePanel, "Choose Spaceship Type Panel");
    	
    	// in the opening, spaceship type selection will be done
    	CardLayout cardLayout = (CardLayout) inGamePanel.getLayout();
		cardLayout.show(inGamePanel, "Choose Spaceship Type Panel"); 	
    }	
    
    // METHODS
    @Override
    public void startGame() {
    	timeController.startTimer();
    	// make choose spaceship type panel unvisible
    	inGamePanel.setVisible(false);
    	
    	// stop menu music, start game music
    	musicManager.stopMenuBackgroundMusic();
    	musicManager.startGameBackgroundMusic();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(movingBackgroundImage, 0, movingBackgroundY, null);
        
        int yDelta = 4;
        
        yOffset += yDelta;
        if(yOffset > movingBackgroundImage.getHeight() )
        {
        	yOffset = 0;
        }
        int yPos = yOffset;
        while ( yPos > 0 )
        {
        	yPos -= movingBackgroundImage.getHeight();
        	g.drawImage(movingBackgroundImage, 0, yPos, this);
        }
        
        yPos = yOffset;
        while( yPos < movingBackgroundImage.getHeight() )
        {
        	g.drawImage(movingBackgroundImage, 0, yPos, this);
        	yPos += movingBackgroundImage.getHeight();
        }
        
        DrawObjectsService drawObjectsService = new DrawObjectsService(g, this, spaceship, 
    		   spaceMobsInSpace, bulletsInSpace, spaceItemsInSpace, this);
        drawObjectsService.drawObjects();
    }

    // other classes may request them
	@Override
	public void repaintRequest() {
		repaint();	
	}

	@Override
	public void pauseGame() {
		timeController.stopTimer();
		isGamePaused = true;
		CardLayout cardLayout = (CardLayout) inGamePanel.getLayout();
		cardLayout.show(inGamePanel, "Pause Panel");			
		inGamePanel.setVisible(true); 
	}

	@Override
	public void resumeGame() {
		timeController.startTimer();
		isGamePaused = false;
		inGamePanel.setVisible(false);	
	} 
	
	@Override
	public boolean isGamePaused() {
		return isGamePaused;
	}

	@Override
	public void finishLevel() {
		// stop game for next level menu
		timeController.stopTimer();
		
		// display next level menu
		CardLayout cardLayout = (CardLayout) inGamePanel.getLayout();		
		cardLayout.show(inGamePanel, "Next Level Panel");			
		inGamePanel.setVisible(true);     
		
		// prepare for next level meanwhile
		NewLevelSetterService newLevelSetterService = new NewLevelSetterService(
				spaceship, bulletsInSpace);
		newLevelSetterService.setNewLevel();	
	}

	@Override
	public void continueNextLevel() {
		gameLevel++;
	
		timeController.setCount(0);
		timeController.startTimer();
		inGamePanel.setVisible(false);      
	}
	
	// get game level
	@Override
	public int getGameLevel() {
		return gameLevel;
	}


	@Override
	public void makeGameOver() {
		// time stop
		timeController.stopTimer();
		timeController.setCount(0);
		
		// display game over panel at the middle of screen
		//JPanel gameOverPanel = new GameOverPanel(spaceship.getScore(),spaceship.getCoin(),this.getGameLevel(),this, this);
		JPanel gameOverPanel = new GameOverPanel(spaceship.getScore(),this);
		inGamePanel.add(gameOverPanel, "Game Over Panel");
		CardLayout cardLayout = (CardLayout) inGamePanel.getLayout();		
		cardLayout.show(inGamePanel, "Game Over Panel");			
		inGamePanel.setVisible(true); 
	}
	@Override
	public void showHelpMenu(){
	
		CardLayout cardLayout = (CardLayout) contentPane.getLayout();		
		cardLayout.show(contentPane, "View Help Screen");			
	}
	@Override
	public void showSettingsMenu(){
		CardLayout cardLayout = (CardLayout) contentPane.getLayout();		
		cardLayout.show(contentPane, "View Settings Screen");	
	}
	@Override
	public void showHighScoreMenu(){
		CardLayout cardLayout = (CardLayout) contentPane.getLayout();		
		cardLayout.show(contentPane, "View Highscores Screen");	
	}
	
	@Override
	public void backToMainMenuAfterGameOver() {		
		// reset game screen elements
		resetAll();
		
		// reset game level
		gameLevel = 1; // again
		
		// in the next opening, spaceship type selection will be done
		CardLayout cardLayoutOne = (CardLayout) inGamePanel.getLayout();
		cardLayoutOne.show(inGamePanel, "Choose Spaceship Type Panel"); 

		// quit game and display main menu
		CardLayout cardLayoutTwo = (CardLayout) contentPane.getLayout();
		cardLayoutTwo.show(contentPane, "Main Menu Screen");
		
		// stop game music, start menu music
		if(musicManager.isMenuBackgroundSoundActive())
			musicManager.stopMenuBackgroundMusic();
		if(musicManager.isGameBackgroundActive())
			musicManager.stopGameBackgroundMusic();
		musicManager.startMenuBackgroundMusic();
	}
	
	@Override
	public void changeShootingKey(int keyEvent) {
		spaceshipShootingKeyBindings.initShootingKeyBindings(keyEvent);
	}
	
	@Override
	public void changeUsingPowerUpKey(int keyEvent) {
		spaceshipUsingPowerUpKeyBindings.initUsingPowerUpKeyBindings(keyEvent);
	}
	
	private void resetAll() {
		GameResetterService gameResetterService = new GameResetterService(
				spaceship, spaceMobsInSpace, bulletsInSpace, spaceItemsInSpace);
		gameResetterService.resetGame();
	}
}
