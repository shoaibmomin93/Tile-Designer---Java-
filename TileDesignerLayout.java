/**
 * *********************************************************
 * Progammer: MOMIN,SHOAIB  

 * Date Created: November 9, 2016
 *
 * Purpose: This program demonstrates the concept of Graphics. This implements Tile Program.
 ***********************************************************
 */
package tiledesigner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

/*
This is the class that sets up the layout and GUI for the application.

 */
public class TileDesignerLayout extends JPanel implements ActionListener {

    // declare the required variables
    static final String[] IMAGESTRINGNAMEA = {"pat1.gif", "pat2.gif", "pat3.gif", "pat4.gif", "pat5.gif"};	//holds names of patches
    static Image[] imageA = new Image[5];	 //image array to hold 5 images that are loaded
    JButton patch1btn, patch2btn, patch3btn, patch4btn, patch5btn; //buttons for each image
    JButton resetBtn; // this button is used to reset the grid
    final TileCanvas centerTileCanvas1 = new TileCanvas(); //call class to make    center grid
    // this is the constructor 

    public TileDesignerLayout() {
        super.setLayout(new BorderLayout()); // set up border layout
        super.add(centerTileCanvas1, BorderLayout.CENTER); //Adding centerPanel to outerFrame.
        centerTileCanvas1.resetGridTile(); //call methods in other class to set stuff up		
        centerTileCanvas1.createMouseListener();
        LineBorder lineBorder;
        lineBorder = (LineBorder) BorderFactory.createLineBorder(Color.blue);
        centerTileCanvas1.setBorder(lineBorder);
        
        //    (adding panel with reset button to SOUTH)
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        super.add(panelSouth, BorderLayout.SOUTH);
        resetBtn = new JButton("RESET"); // button is used to reset the grid
        panelSouth.add(resetBtn); // add this button to the panel
        centerTileCanvas1.loadImageArray(); // load the image array 
        JToolBar tileToolBar = new JToolBar();	//create a tool bar							
        patch1btn = new JButton(new ImageIcon(imageA[0]));
        tileToolBar.add(patch1btn); //add 1 button to toolbar
        patch2btn = new JButton(new ImageIcon(imageA[1]));
        tileToolBar.add(patch2btn); // add the 2nd button
        patch3btn = new JButton(new ImageIcon(imageA[2]));
        tileToolBar.add(patch3btn);  // add the 3rd button
        patch4btn = new JButton(new ImageIcon(imageA[3]));
        tileToolBar.add(patch4btn);  // add 4th button
        patch5btn = new JButton(new ImageIcon(imageA[4]));
        tileToolBar.add(patch5btn);  // add 5th button to the toolbar
        super.add(tileToolBar, BorderLayout.NORTH);

        addListeners(); // add listeners for all the buttons

    } // END CONSTRUCTOR
    // find the source of event and perform the appropriate action.

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetBtn) { // reset the grid when reset button is pressed
            centerTileCanvas1.resetGridTile();
            centerTileCanvas1.selectedTile = -1;
        }
        // select appropriate image and when the button is pressed  
        // this selected value is then used in mouse listener 
        if (e.getSource() == patch1btn) {
            centerTileCanvas1.selectedTile = 0;
        }
        if (e.getSource() == patch2btn) {
            centerTileCanvas1.selectedTile = 1;
        }
        if (e.getSource() == patch3btn) {
            centerTileCanvas1.selectedTile = 2;
        }
        if (e.getSource() == patch4btn) {
            centerTileCanvas1.selectedTile = 3;
        }
        if (e.getSource() == patch5btn) {
            centerTileCanvas1.selectedTile = 4;
        }
    } // end of actionPerformed
    // Add Action listeners to all the buttons .

    private void addListeners() {
        // add a listener for every button
        patch1btn.addActionListener(this);
        patch2btn.addActionListener(this);
        patch3btn.addActionListener(this);
        patch4btn.addActionListener(this);
        patch5btn.addActionListener(this);
        resetBtn.addActionListener(this);
    } // end of addListeners

} // end of class
