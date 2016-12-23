/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_despot.UI_Manager;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import space_despot.Interfaces.MainMenuBackable;
import space_despot.Interfaces.Pausable;
import space_despot.UI_Manager.ViewHighscoresScreen.BackToMainMenuButtonListener;
/**
 *
 * @author Nylandre
 */
public class ViewHelpScreen extends javax.swing.JPanel {

    /**
     * Creates new form Help_Panel
     */
    // PROPERTIES
	private JPanel contentPane;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton general_tab;
    private JButton back_main_menu_button;
    private JButton space_mobs_tab;
    private JButton space_ship_tab;
    private JButton upgrades_tab;
    private JButton glossary_tab;
    private JLabel help_label;
    private JPanel help_text_panel;
    private JPanel help_panel;
    private JScrollPane jScrollPane2;
    private JTextArea help_text_area;
    // End of variables declaration//GEN-END:variables
    
    
    public ViewHelpScreen(JPanel contentPane) {
        super();
        this.contentPane= contentPane;
        
        help_label = new javax.swing.JLabel();
        help_text_panel = new javax.swing.JPanel();
        general_tab = new javax.swing.JButton();
        space_mobs_tab = new javax.swing.JButton();
        space_ship_tab = new javax.swing.JButton();
        upgrades_tab = new javax.swing.JButton();
        glossary_tab = new javax.swing.JButton();
        back_main_menu_button = new javax.swing.JButton();
        help_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        help_text_area = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(700, 700));

        help_label.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        help_label.setText("Help");
        help_label.setPreferredSize(new java.awt.Dimension(100, 60));

        help_text_panel.setLayout(null);

        general_tab.setText("General");
        help_text_panel.add(general_tab);
        general_tab.setBounds(0, 0, 190, 23);

        space_mobs_tab.setText("Space Mobs");
        help_text_panel.add(space_mobs_tab);
        space_mobs_tab.setBounds(0, 190, 190, 23);

        space_ship_tab.setText("SpaceShip");
        help_text_panel.add(space_ship_tab);
        space_ship_tab.setBounds(0, 150, 190, 23);

        upgrades_tab.setText("Upgrades");
        help_text_panel.add(upgrades_tab);
        upgrades_tab.setBounds(0, 170, 190, 23);

        glossary_tab.setText("Glossary");
        help_text_panel.add(glossary_tab);
        glossary_tab.setBounds(0, 210, 190, 23);

        back_main_menu_button.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        back_main_menu_button.setText("Back");
        back_main_menu_button.setPreferredSize(new java.awt.Dimension(110, 45));


        help_text_area.setColumns(20);
        help_text_area.setRows(5);
        help_text_area.setText("Lorem ipsum dolor sit amet, ad his decore intellegam suscipiantur, his in aliquid luptatum complectitur, elit vivendum ei qui. Sed evertitur intellegat forensibus no. Usu in eros tincidunt, ea sed quando diceret, ex primis consequuntur nec. Doctus dolorum nam id. Cum eu liber tation. Ea eum movet possim tamquam.\n\nEst honestatis cotidieque te, eos ei quaestio vituperatoribus, ferri liber graece cu usu. Sale feugait tibique cu ius, cu graece omnesque has. Oratio nullam alterum te mea, cu graeci scripta instructior quo. Recusabo quaerendum definitionem in has. Vix falli fabellas cu, ex mei error congue. Usu eu laoreet molestiae liberavisse.");
        jScrollPane2.setViewportView(help_text_area);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(help_panel);
        help_panel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(help_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(help_text_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(help_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(back_main_menu_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(help_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(help_text_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(back_main_menu_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        
        back_main_menu_button.addActionListener(new BackToMainMenuButtonListener());
        

        
    }
    
    public class BackToMainMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { 
			CardLayout cardLayoutTwo = (CardLayout) contentPane.getLayout();
			cardLayoutTwo.show(contentPane, "Main Menu Screen");
		}  	
    }
}


