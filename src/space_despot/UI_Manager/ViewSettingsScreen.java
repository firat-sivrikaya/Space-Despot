package space_despot.UI_Manager;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;

import space_despot.Interfaces.KeysChangeable;


@SuppressWarnings("serial")
public class ViewSettingsScreen extends JPanel {
	
	// CONSTANTS
	private final ImageIcon backButtonIcon = new ImageIcon("resources/images/back-button.png");
	
	// PROPERTIES
    private JPanel contentPane;
    private BufferedImage backgroundImage;
    	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton backButton;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSlider jSlider1;
    private JSlider jSlider2;
    private JTabbedPane jTabbedPane1;
    private JComboBox<String> shootingKey;
    private JComboBox<String> usingPowerUpKey;
    // End of variables declaration//GEN-END:variables
    
    private KeysChangeable changeKeysDelegate;
    
    // CONSTRUCTOR
    public ViewSettingsScreen(JPanel contentPane, 
    		KeysChangeable changeKeysDelegate) {
    	super();
    	this.contentPane = contentPane;
    	this.changeKeysDelegate = changeKeysDelegate;   	
        
        // background
        try {
			backgroundImage = ImageIO.read(new File("resources/images/settings-background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        
        // construct components
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        String[] shootingKeyChoices = {"C", "D", "X"};
        shootingKey = new JComboBox<String>(shootingKeyChoices);
        String[] usingPowerUpKeyChoices = {"V", "B", "Space"};
        usingPowerUpKey = new JComboBox<String>(usingPowerUpKeyChoices);
        jPanel2 = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jSlider1 = new JSlider();
        jSlider2 = new JSlider();
        backButton = new JButton();

        jTabbedPane1.setFont(new Font("Tahoma", 0, 15)); // NOI18N

        jPanel1.setPreferredSize(new Dimension(500, 230));

        jLabel3.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Set Activate Power Up Key");

        jLabel4.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Set Shooting Key");

        shootingKey.setSelectedIndex(2); // X key by default
        usingPowerUpKey.setSelectedIndex(2); // Space key by default

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(shootingKey, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usingPowerUpKey, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(shootingKey)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usingPowerUpKey)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50))
        );

        jTabbedPane1.addTab("Game Settings", jPanel1);

        jLabel8.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Music Volume");

        jLabel9.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("FX Volume");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Audio Settings", jPanel2);

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setIcon(backButtonIcon);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)                   
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)         
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        shootingKey.addItemListener(new ShootingKeyListener());
        usingPowerUpKey.addItemListener(new UsingPowerUpKeyListener());
        
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
    
    public class ShootingKeyListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
           if (event.getStateChange() == ItemEvent.SELECTED) {
        	   Object item = event.getItem();
        	   if (item.toString().equals("C")) {
        		   changeKeysDelegate.changeShootingKey(KeyEvent.VK_C);
        	   } else if (item.toString().equals("D")) {
        		   changeKeysDelegate.changeShootingKey(KeyEvent.VK_D);
        	   } else if (item.toString().equals("X")) {
        		   changeKeysDelegate.changeShootingKey(KeyEvent.VK_X);
        	   }    	   
           }
        }       
    }
    
    public class UsingPowerUpKeyListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
           if (event.getStateChange() == ItemEvent.SELECTED) {
        	   Object item = event.getItem();
        	   if (item.toString().equals("V")) {
        		   changeKeysDelegate.changeUsingPowerUpKey(KeyEvent.VK_V);
        	   } else if (item.toString().equals("B")) {
        		   changeKeysDelegate.changeUsingPowerUpKey(KeyEvent.VK_B);
        	   } else if (item.toString().equals("Space")) {
        		   changeKeysDelegate.changeUsingPowerUpKey(KeyEvent.VK_SPACE);
        	   }    	   
           }
        }       
    }
}