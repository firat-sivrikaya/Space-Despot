/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_despot.UI_Manager;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
/**
 *
 * @author Nylandre
 */
@SuppressWarnings("serial")
public class ViewHelpScreen extends javax.swing.JPanel {

    /**
     * Creates new form Help_Panel
     */
	// CONSTANT
	private final ImageIcon backButtonIcon = new ImageIcon("resources/images/back-button.png");
	
    // PROPERTIES
	private JPanel contentPane;
	private BufferedImage backgroundImage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private JButton general_tab;
    private JButton back_main_menu_button;
//    private JButton space_mobs_tab;
//    private JButton space_ship_tab;
//    private JButton upgrades_tab;
//    private JButton glossary_tab;
//    private JTextArea help_text_area;
    // End of variables declaration//GEN-END:variables
    
    
    public ViewHelpScreen(JPanel contentPane) {
        super();
        this.contentPane= contentPane;
        try
        {
        	backgroundImage = ImageIO.read(new File("resources/images/help-background.png"));
        }
        catch(IOException e ){
        	e.printStackTrace();
        }
//        general_tab = new javax.swing.JButton();
//        space_mobs_tab = new javax.swing.JButton();
//        space_ship_tab = new javax.swing.JButton();
//        upgrades_tab = new javax.swing.JButton();
//        glossary_tab = new javax.swing.JButton();
        back_main_menu_button = new javax.swing.JButton();
//        help_text_area = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(225, Short.MAX_VALUE)
        			.addComponent(back_main_menu_button, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        			.addGap(225))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(549, Short.MAX_VALUE)
        			.addComponent(back_main_menu_button, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addGap(90))
        );
        this.setLayout(layout);
        
        back_main_menu_button.addActionListener(new BackToMainMenuButtonListener());
        back_main_menu_button.setOpaque(false);
        back_main_menu_button.setContentAreaFilled(false);
        back_main_menu_button.setBorderPainted(false);
        back_main_menu_button.setFocusable(false);
        back_main_menu_button.setIcon(backButtonIcon);

        
    }
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
    
    public class BackToMainMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { 
			CardLayout cardLayoutTwo = (CardLayout) contentPane.getLayout();
			cardLayoutTwo.show(contentPane, "Main Menu Screen");
		}  	
    }
}


