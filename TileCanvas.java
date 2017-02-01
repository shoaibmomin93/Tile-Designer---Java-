/**
 * *********************************************************
 * Progammer: MOMIN,SHOAIB  

 * Date Created: November 9, 2016
 *
 * Purpose: This program demonstrates the concept of Graphics. This implements Tile Program.
 ***********************************************************
 */
package tiledesigner;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

// This class is where all the painting takes place. Initial grid is drawn, images are drawn.
public class TileCanvas extends JPanel implements MouseListener {

    public int selectedTile = -1; //this is set in other class with button clicks
    static final int SQUARE_SIDE = 25;
    final int GRID_ROWS = 5;  // declare the required variables .
    final int GRID_COLS = 5;
    int gridWidth, gridHeight, startX, startY;
    Image[][] gif2dArray = new Image[GRID_ROWS][GRID_COLS];// drawn on grid when we paint

// this method stores the images in the array .
    public void loadImageArray() {
        for (int i = 0; i < TileDesignerLayout.imageA.length; i++) {
            // image names are stored are in imageStringNameA. Get the images and store them in the Image array
            TileDesignerLayout.imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(TileDesignerLayout.IMAGESTRINGNAMEA[i]);
        } // end for
    } // end loadImageArray

    // This method resets the grid. All the  images are cleared off the grid
    public void resetGridTile() {
        for (int i = 0; i < GRID_ROWS; i++) {
            for (int j = 0; j < GRID_COLS; j++) {
                gif2dArray[i][j] = null; // set the display images array to null
            }
        } // end for
        this.repaint();  // repaint the screen

    } // end resetGridTile

    public void createMouseListener() {
        addMouseListener(this);
    }

    /*
    This method is executed when you click the mouse. This is action that will be performed when you click a mouse
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //here we get  a position of the click of mouse –x,y
        if (selectedTile >= 0) { // only when the selected value greater than or equal to 0, some action should be performed
            int x = e.getX();
            int y = e.getY();
            //if it was a valid click in grid
            if (x >= startX && x <= startX + gridWidth && y >= startY && y <= startY + gridHeight) {
                int xIndex = (x - startX) / SQUARE_SIDE; //will be an integer of square clicked
                int yIndex = (y - startY) / SQUARE_SIDE; //wil be an integer of squear clicked
                gif2dArray[xIndex][yIndex] = TileDesignerLayout.imageA[selectedTile]; // load the image to the appropriate position
                this.repaint();  //show new grid
            }
        } // end selectedTile if
    } // end mouseClicked

    /* This method is used to draw or paint on sceen. Grid and pictures are drawn on the canvas
     using this method */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gridWidth = GRID_COLS * SQUARE_SIDE;  // declare the required variables and initialize them as required
        gridHeight = GRID_ROWS * SQUARE_SIDE;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        startX = (panelWidth - gridWidth) / 2;//get starting point to draw grid based 
        startY = (panelHeight - gridHeight) / 2;
        int row, col;
        //Drawing empty grid of 5*5 with an inner outer loop
        for (row = 0; row < GRID_ROWS; row++) {
            for (col = 0; col < GRID_COLS; col++) {
                // use drawRect method to draw grids on the screen
                g.drawRect(startX + (SQUARE_SIDE * row), startY + (SQUARE_SIDE * col), SQUARE_SIDE, SQUARE_SIDE);
            }
        } // end for

        //copy gif image array over to the drawing grid with inner outer loop
        for (row = 0; row < GRID_ROWS; row++) {
            for (col = 0; col < GRID_COLS; col++) {
                // use drawImage to draw the image in the appropriate grid
                g.drawImage(gif2dArray[row][col], startX + (SQUARE_SIDE * row), startY + (SQUARE_SIDE * col), this);
            }
        } // end image for
    } // end paintComponent

    /* The below methods are a part of MouseListener. Since we do not need them in this program, they are empty.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
