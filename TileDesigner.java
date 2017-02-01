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
import javax.swing.JFrame;

// This class sets up the Frame for the Tile Application. It calls the TileDesignLayout that builds the initial 
//GUI layout of the application
public class TileDesigner extends JFrame {

    public static void main(String[] args) {
        createAndShowGUI();
        // call this method to set up the GUI of the game .
    }

    public static void createAndShowGUI() {
        TileDesigner td1 = new TileDesigner();  // call the constructor of TileDesign
        td1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        td1.setSize(400, 400);  // set the initial values 
        td1.setVisible(true);
    }

    // This is the constructor . 
    public TileDesigner() {
        super("Tile Application");  // call the super method and send Tile Application to the base class 
        TileDesignerLayout tiledesign = new TileDesignerLayout(); // this object sets up the layout where actions can be performed.
        super.setLayout(new BorderLayout());  // set up a border layout and this to the center
        super.add(tiledesign, BorderLayout.CENTER);
    } // end of constructor

} // end of class
