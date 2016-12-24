package space_despot.UI_Manager;


import java.awt.CardLayout;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;


@SuppressWarnings("serial")
public class ViewHighscoresScreen extends JPanel {
	
	// CONSTANTS
	private final ImageIcon backButtonIcon = new ImageIcon("resources/images/back-button.png");

	// PROPERTIES
    private JPanel contentPane;
    private BufferedImage backgroundImage;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton backButton;
    private JTable table;
    private JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
    public Boolean goToMainMenu=true;
    
    // CONSTRUCTOR
    public ViewHighscoresScreen(JPanel contentPane) {
    	super();
    	this.contentPane = contentPane;
    	     
        // background
        try {
			backgroundImage = ImageIO.read(new File("resources/images/highscores-background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        // construct components
        backButton = new JButton();

        String[] columnNames = {"Nickname",
                "Score"};
        
        Object[][] data = {
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	    {"Kathy", new Integer(5)},
        	};

        table = new JTable(data, columnNames);
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);   
        
        setPreferredSize(new Dimension(700, 700));

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setIcon(backButtonIcon);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                .addGap(249, 249, 249))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        
        backButton.addActionListener(new BackToMainMenuButtonListener());
    }
    
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
    
    public class BackToMainMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { 
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			cardLayout.show(contentPane, "Main Menu Screen");
		}  	
    }
    
}
