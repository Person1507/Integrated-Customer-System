import java.awt.event.*;
import java.awt.*;
import javax.swing.*;




public class DisplayAllProfiles extends JFrame implements ActionListener {


    // JTextField for the admin Id that the user will enter
    static JTextField t;
    // JFrame that will be the window
    static JFrame f;
    // JButton that will have the 'Display' button
    static JButton b;
    // Label to display the text asking for admin ID
    static JLabel l;

    // This button will be the close button for the window
    static JButton close;

    //CustomerProf Database that will hold the DB we got
    // from the constructor
    public CustomerProfDB db3;

    // String that will hold the admin ID entered by the user
    private String response;

    // Default Constructor
    DisplayAllProfiles(CustomerProfDB db)
    {
        db3 = db;
    }

    // main class
    public void main()
    {
        f = new JFrame("Display All Profiles");
        DisplayAllProfiles dap = new DisplayAllProfiles(db3);   // Class Object for Listener
        JPanel p = new JPanel();

        //AdminId section
        //--Asks user for Admin ID
        l = new JLabel("Enter AdminID:");
        l.setBounds(0,0,20,20);
        t = new JTextField(16);
        p.add(l);
        p.add(t);

        //This Sets up our 'Display' button
        b = new JButton("Display");
        b.addActionListener(dap);


        //This sets up our 'Close' button
        close = new JButton("Close");
        CloseListener cl = new CloseListener();
        close.addActionListener(cl);

        //Adds both buttons to the window
        p.add(b);
        p.add(close);

        // add panel to frame
        f.add(p);
        // set the size of frame
        f.setSize(280, 300);
        f.show();
    }
    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        //The below if section will check for the display button being
        // pushed, if it is: It will get the admin id from the text
        // box and check to see if there are any profiles in the db container
        // if there are then the AllProfileViewer is called and opens a window
        // for the viewing of all profiles
        if (s.equals("Display")) {
            response = t.getText();
            if (this.db3.findFirstProfile() == null){
                JOptionPane.showMessageDialog(null,"There are no profiles available right now!","Error Message",1);
            }else {
                AllProfileViewer apv = new AllProfileViewer(this.db3.findFirstProfile(),this.db3,(String) response);
                apv.printAllProfs();
            }

            // These set the text boxes to blank
            t.setText("");
        }
    }

}
