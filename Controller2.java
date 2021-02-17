// Controller 2: displays views 3 and 4
//               (displaying A and B components of the model)
// Offers two button: clear views and refresh views - see below.
// The refresh views button is required as views 3 and 4 do not yet
// subscribe properly to the model and are not notified when it changes.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller2 extends JFrame implements ActionListener {

    private Model model;
    private View3 view3;
    private View4 view4;
    private JButton clearViews;   // For direct message to views

    private JButton refreshViews; // To prompt them to refresh their contents from the model
    private JButton incB; // A button to increment database B

    // Constructor
    public Controller2(Model model, String frameTitle) {

        // Record reference to the model
        this.model = model;

        // Configure the window
        setTitle(frameTitle);
        setLocation(40, 200);
        setSize(350, 150);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());     // The default is that JFrame uses BorderLayout

        // Set up input GUI
        clearViews = new JButton("Clear views");
        window.add(clearViews);
        clearViews.addActionListener(this);

        incB = new JButton("Increment B");
        window.add(incB);
        incB.addActionListener(this);
        refreshViews = new JButton("Refresh views");
        window.add(refreshViews);
        refreshViews.addActionListener(this);

      //  refreshViews = new JButton("Refresh views");
      //  window.add(refreshViews);
      //  refreshViews.addActionListener(this);

        // Create views
        view3 = new View3(this, model);
        window.add(view3);
        view4 = new View4(this, model);
        window.add(view4);

        // Display the frame
        setVisible(true);

    } // constructor

    // Button click handling:
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearViews) {
            view3.clear();
            view4.clear();
        }

        if (e.getSource() == refreshViews) {
            view3.update();
            view4.update();
        }
        else if (e.getSource() == incB) {
            model.modifyB();
        }
        

    } // actionPerformed

} // class Controller2


