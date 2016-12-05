package space_despot.UI_Manager;

import java.awt.*;
import javax.swing.*;


public class GUIManager {

    private PlayGameScreen playGameScreen;

    private void displayGUI()
    {
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
     	frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(63, 134, 145)));
     	
        playGameScreen = new PlayGameScreen();
    
        frame.setContentPane(playGameScreen);     
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