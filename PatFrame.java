import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatFrame extends JFrame implements ActionListener{

    private PatCanvas myCanvas;  // These are instance variables
    private JTextField squares;    // variables that are part of the frame
    private JLabel sLabel;         // object and are not local to a method.
    private JComboBox choice;
    private int rows = 25;

    public final int canvasWidth = 400;

    PatFrame () {
	super();
	setLocation(100, 100);
	addWindowListener(new MyWindowAdapter());

	myCanvas = new PatCanvas(canvasWidth, rows);
	sLabel   = new JLabel ("Squares per side");
	squares  = new JTextField(rows+"");

	String[] choices = Patterns.getChoices();
	choice = new JComboBox(choices);
	choice.setSelectedIndex(0);
	choice.addActionListener(this);
	squares.addActionListener(this);     /* hitting enter in the text
						field will cause
						actionPerformed to be called */

	setLayout(new FlowLayout());   /* this says how to arrange things */
      
	add(myCanvas);                 /* we add components to the frame */  
	add(sLabel);
	add(squares);
	add(choice);

	setVisible(true);
	setSize (canvasWidth + 50, canvasWidth + 100);
    }

    public void actionPerformed (ActionEvent e) {
	if (e.getSource() == choice) {
	    JComboBox cb = (JComboBox)e.getSource();
	    myCanvas.setChoice((String)cb.getSelectedItem());
	    myCanvas.repaint();
	}
	else if (e.getSource() ==  squares) {
	    try {
		int r = Integer.parseInt(squares.getText());
		rows = r;
	    }
	    catch (NumberFormatException ex) {
		squares.setText(rows+"");
	    }
	    myCanvas.setRows(rows);
	    myCanvas.repaint();
	}
    }

    private class MyWindowAdapter extends WindowAdapter {

	public void windowClosing (WindowEvent e) {
	    dispose();    // this method is called if the window is closed
	    System.exit(0);
	}
    }
}





