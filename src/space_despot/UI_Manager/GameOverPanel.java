
/*
package space_despot.UI_Manager;

import space_despot.Game_Screen_Elements.Spaceship;
import space_despot.Interfaces.GameStartable;
import space_despot.Interfaces.MainMenuBackable;



public class GameOverPanel extends javax.swing.JPanel {
    
    
    public GameOverPanel(GameStartable gameStartableDelegate, MainMenuBackable  mainMenuBackableDelegate ) {
    	super();
    	
        this.gameStartableDelegate = gameStartableDelegate;
        this.mainMenuBackableDelegate= mainMenuBackableDelegate;      
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
        HighScoreScreen = new javax.swing.JDialog();
        congratulations_label = new javax.swing.JLabel();
        set_new_highscore_label = new javax.swing.JLabel();
        request_name_label = new javax.swing.JLabel();
        nick_name_field = new javax.swing.JTextField();
        game_over_panel_label = new javax.swing.JLabel();
        play_again_button = new javax.swing.JButton();
        back_to_main_menu_button = new javax.swing.JButton();
        quit_game_button = new javax.swing.JButton();
        score_label = new javax.swing.JLabel();
        coins_label = new javax.swing.JLabel();
        space_ship_label = new javax.swing.JLabel();
        level_label = new javax.swing.JLabel();
        level_text = new javax.swing.JTextField();
        coins_text = new javax.swing.JTextField();
        space_ship_text = new javax.swing.JTextField();
        score_text = new javax.swing.JTextField();

        HighScoreScreen.setTitle("New High Score");

        congratulations_label.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        congratulations_label.setText("CONGRATULATIONS!");

        set_new_highscore_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        set_new_highscore_label.setText("You set a new highscore");

        request_name_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        request_name_label.setText("Please enter your name: ");

        nick_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nick_name_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HighScoreScreenLayout = new javax.swing.GroupLayout(HighScoreScreen.getContentPane());
        HighScoreScreen.getContentPane().setLayout(HighScoreScreenLayout);
        HighScoreScreenLayout.setHorizontalGroup(
            HighScoreScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HighScoreScreenLayout.createSequentialGroup()
                .addGroup(HighScoreScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HighScoreScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HighScoreScreenLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(nick_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HighScoreScreenLayout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(set_new_highscore_label)
                            .addGap(56, 56, 56)))
                    .addGroup(HighScoreScreenLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(request_name_label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HighScoreScreenLayout.createSequentialGroup()
                .addGap(0, 98, Short.MAX_VALUE)
                .addComponent(congratulations_label)
                .addGap(95, 95, 95))
        );
        HighScoreScreenLayout.setVerticalGroup(
            HighScoreScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HighScoreScreenLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(congratulations_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(set_new_highscore_label, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(HighScoreScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(request_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nick_name_field))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(480, 383));

        game_over_panel_label.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        game_over_panel_label.setText("GAME OVER!");

        play_again_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        play_again_button.setText("Play Again");
        play_again_button.addActionListener(new java.awt.event.ActionListener(){
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_again_buttonActionPerformed(evt);
             }
        });

        back_to_main_menu_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        back_to_main_menu_button.setText("Back to Main Menu");
        back_to_main_menu_button.addActionListener(new java.awt.event.ActionListener(){
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_main_buttonActionPerformed(evt);
             }
        });

        quit_game_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quit_game_button.setText("Quit Game");
        quit_game_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quit_game_buttonActionPerformed(evt);
            }
        });

        score_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        score_label.setText("Score:");

        coins_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        coins_label.setText("Coins:");

        space_ship_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        space_ship_label.setText("Spaceship:");

        level_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        level_label.setText("Level:");

        level_text.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        level_text.setText(Integer.toString(game.getGameLevel()));
        level_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_textActionPerformed(evt);
            }
        });

        coins_text.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        coins_text.setText(Integer.toString(the_coin);
        coins_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coins_textActionPerformed(evt);
            }
        });

        space_ship_text.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        space_ship_text.setText(spaceship.getType().toString());
        space_ship_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                space_ship_textActionPerformed(evt);
            }
        });

        score_text.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        score_text.setText(Integer.toString(score);
        score_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                score_textActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(play_again_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back_to_main_menu_button, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(quit_game_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(space_ship_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(space_ship_text, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(level_label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(level_text, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(score_label)
                                        .addComponent(coins_label, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(coins_text, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(score_text, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(game_over_panel_label)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(game_over_panel_label, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(space_ship_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(space_ship_text, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(level_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level_label, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(score_label)
                    .addComponent(score_text, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coins_text, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(coins_label, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addComponent(play_again_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_to_main_menu_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quit_game_button)
                .addContainerGap())
        );
        
    }// </editor-fold>                        
   
    private void quit_game_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        System.exit(0);
    }
private void play_again_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       gameStartableDelegate.startGame();
    }
private void back_to_main_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       mainMenuBackableDelegate.backToMainMenuAfterGameOver();
    }


    private void nick_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO 
    }                                               

    private void level_textActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void coins_textActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void space_ship_textActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
    }                                               

    private void score_textActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JDialog HighScoreScreen;
    private javax.swing.JButton back_to_main_menu_button;
    private javax.swing.JLabel coins_label;
    private javax.swing.JTextField coins_text;
    private javax.swing.JLabel congratulations_label;
    private javax.swing.JLabel game_over_panel_label;
    private javax.swing.JLabel level_label;
    private javax.swing.JTextField level_text;
    private javax.swing.JTextField nick_name_field;
    private javax.swing.JButton play_again_button;
    private javax.swing.JButton quit_game_button;
    private javax.swing.JLabel request_name_label;
    private javax.swing.JLabel score_label;
    private javax.swing.JTextField score_text;
    private javax.swing.JLabel set_new_highscore_label;
    private javax.swing.JLabel space_ship_label;
    private javax.swing.JTextField space_ship_text;
    // End of variables declaration                   
    private GameStartable gameStartableDelegate;
    private MainMenuBackable mainMenuBackableDelegate;
    
}
*/


package space_despot.UI_Manager;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import space_despot.Application_Logic.HighscoresManager;
import space_despot.Interfaces.MainMenuBackable;


@SuppressWarnings("serial")
public class GameOverPanel extends JPanel {
	
	private MainMenuBackable backToMainMenuDelegate;
	int finalScore;
	HighscoresManager highscoresManager;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton confirmButton;
    private JButton exitButton;
    private JLabel infoLabel;
    private JTextField nicknameField;
    // End of variables declaration//GEN-END:variables
    

	// CONSTRUCTOR
    public GameOverPanel(int finalScore, MainMenuBackable backToMainMenuDelegate) { 	
        this.finalScore = finalScore;
        this.backToMainMenuDelegate = backToMainMenuDelegate;
        highscoresManager = new HighscoresManager();
        
        // construct components
        confirmButton = new JButton();        
        exitButton = new JButton();
        infoLabel = new JLabel();
        nicknameField = new JTextField(30);

        confirmButton.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        confirmButton.setText("Confirm");

        infoLabel.setFont(new Font("Tahoma", 0, 50)); // NOI18N
        infoLabel.setText("Game Over!");
        infoLabel.setPreferredSize(new Dimension(410, 60));

        exitButton.setFont(new Font("Tahoma", 0, 30)); // NOI18N
        exitButton.setText("Exit");

        nicknameField.setFont(new Font("Tahoma", 0, 30)); // NOI18N

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
                            .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(nicknameField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)                      
                                .addGap(14, 14, 14))))))
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
                        .addComponent(nicknameField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))                 
                .addGap(50, 50, 50)
                .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        
        confirmButton.addActionListener(new ConfirmButtonListener());
        exitButton.addActionListener(new ExitButtonListener());
    }
	
    public class ConfirmButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// insert new score
			highscoresManager.insertNewScore(nicknameField.getText(), finalScore);
			
			// back to main menu then
			backToMainMenuDelegate.backToMainMenuAfterGameOver();		
		}
    }
    
    public class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			backToMainMenuDelegate.backToMainMenuAfterGameOver();
		}
    }

}

