package space_despot.UI_Manager;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import space_despot.Application_Logic.HighscoreHolder;
import space_despot.Application_Logic.HighscoresManager;


@SuppressWarnings("serial")
public class ViewHighscoresScreen extends JPanel {
	
	// CONSTANTS
	private final ImageIcon backButtonIcon = new ImageIcon("resources/images/back-button.png");

	// PROPERTIES
    private JPanel contentPane;
    private BufferedImage backgroundImage;
    private HighscoresManager highscoresManager;
    private List<HighscoreHolder> highscores;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton backButton;
    private JTable table;
    private JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
    
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
        
        // set size
        setPreferredSize(new Dimension(700, 700));
        
        // construct components
        backButton = new JButton();
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setIcon(backButtonIcon);
        
        // set table
        String[] columnNames = {"Nickname",
                "Score"};
        
        highscoresManager = new HighscoresManager();
        highscores = highscoresManager.getHighscores();
        Object[][] data = new Object[10][10];

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);   
        

        // set layout
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
			CardLayout cardLayoutTwo = (CardLayout) contentPane.getLayout();
			cardLayoutTwo.show(contentPane, "Main Menu Screen");
		}  	
    }
    
    public void updateHighscores() {
    	DefaultTableModel model = (DefaultTableModel)table.getModel();

    	highscores = highscoresManager.getHighscores();
    	for (int i = 0; i < 10; i++) {
    		model.setValueAt(highscores.get(i).getNickname(), i, 0);
    		model.setValueAt(highscores.get(i).getScore(), i, 1);	
    	}  	
    }   
}
