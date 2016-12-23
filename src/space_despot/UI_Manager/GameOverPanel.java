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

import space_despot.Interfaces.MainMenuBackable;


@SuppressWarnings("serial")
public class GameOverPanel extends JPanel {
	
	private MainMenuBackable backToMainMenuDelegate;	

	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton confirmButton;
    private JButton exitButton;
    private JLabel infoLabel;
    private JTextField nicknameField;
    // End of variables declaration//GEN-END:variables

	// CONSTRUCTOR
    public GameOverPanel(int finalScore, MainMenuBackable backToMainMenuDelegate) { 	
        
        this.backToMainMenuDelegate = backToMainMenuDelegate;

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
