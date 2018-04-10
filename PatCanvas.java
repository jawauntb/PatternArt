import java.awt.*;
import javax.swing.*;

class PatCanvas extends JPanel {

    private int canvasWidth;             
    private int rows;
    private String choice = "";          // The initial menu choice

    public PatCanvas(int w, int r) {
	canvasWidth = w;
	rows = r;
	setPreferredSize (new Dimension(w+1, w+1));
	setBackground(Color.white);
	setOpaque(true);
    }

    public synchronized void setChoice (String c) {
	choice = c;
    }

    public synchronized void setRows (int r) {
	rows = r;
    }

    public synchronized void paintComponent (Graphics g) {

	super.paintComponent(g);

	Dimension size = getSize();
	int canvasWidth = size.width;
	int canvasHeight = size.height;

	if (canvasHeight < canvasWidth) canvasWidth = canvasHeight;
	
	int columns = rows;             // and columns

	int width = canvasWidth / rows; // width of a cell

	g.setColor(Color.black);        // draw the grid
	for (int i=0; i<=rows; ++i)
	    g.drawLine(0,i*width,columns*width,i*width);
	for (int j=0; j<=columns; ++j)
	    g.drawLine(j*width,0,j*width,rows*width);

	g.setColor(Color.cyan);

	boolean[][] matrix = new boolean[rows][columns];

	Lab7.makePicture(matrix, choice);  // ask for the picture
		 
	for (int i=0; i<rows; ++i)         // draw it
	    for (int j=0; j<columns; ++j)
		if (matrix[i][j])
		    g.fillRect(j*width+1,i*width+1,width-1,width-1);
    }
}
		
		
