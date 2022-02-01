import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class UpdateProfile extends JFrame implements ActionListener{
    // JTextFields for adminId and last name
    static JTextField t,tTwo;
    // JFrame for the entire window
    static JFrame f;
    // JButton for
    static JButton b;
    // Labels to display text
    static JLabel l,lTwo,lThree;
    //Drop down menu for choices
    static JComboBox dropDown;
    //CustomerProf Database for profiles
    public CustomerProfDB db1;
    //String holds the admin ID
    private String response;
    //String holds the Last Name of profile
    private String responseTwo;

    //Constructor
    UpdateProfile(CustomerProfDB db)
    {
        db1 = db;
    }

    // main class
    public void main()
    {
        f = new JFrame("Update Profile");         //creates a new frame
        UpdateProfile up = new UpdateProfile(db1);     // Update profile object for button listener
        JPanel p = new JPanel();                      //new panel

        //AdminId section
        l = new JLabel("Enter AdminID:");
        l.setBounds(0,0,20,20);
        t = new JTextField(16);
        p.add(l);
        p.add(t);

        //Name section
        lTwo = new JLabel("Enter Last Name:");
        lTwo.setBounds(0,10,20,20);
        tTwo = new JTextField(16);
        p.add(lTwo);
        p.add(tTwo);

        //Update field with Drop Down Menu
        lThree = new JLabel("Update Field:");
        lThree.setBounds(0,20,20,20);
        String[] choices = { "First Name","Last Name", "Address","Phone","Income","Use","Status","Model","Year","Type","Method"};
        dropDown = new JComboBox<String>(choices);
        dropDown.setVisible(true);
        p.add(lThree);
        p.add(dropDown);

        //Find Button is below adding its Action Listener
        b = new JButton("Find");
        b.addActionListener(up);
        p.add(b);

        // Adds panel to frame
        f.add(p);
        // set the size of frame
        f.setSize(350, 300);
        f.show();
    }

    // if the button is pressed this actionPerformed function does the things we want!
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        //gets the string we labeled the button and if it matches
        if (s.equals("Find")) {

            response = t.getText(); //gets admin ID from text field
            responseTwo = (String) tTwo.getText();  // gets last name from text field
            var responseThree = dropDown.getSelectedItem();  // gets the selected choice from drop down

            // This if..else checks to see if profile exists and if it does
            // it calls the update class opening the actual window where
            // the update will be entered!
            if (this.db1.findProfile( (String) response, (String) responseTwo) == null){
                //ErrorWindow e1 = new ErrorWindow();
                //e1.bringError("This profile does not exist, enter a different one!");
            }else {
                Update upNew = new Update(this.db1.findProfile( (String) response, (String) responseTwo),(String) responseThree);
                upNew.makeFrame( (String) response, (String) responseTwo, (String) responseThree);
            }

            // Sets Text fields to blank!
            t.setText("");
            tTwo.setText("");
        }
    }
}
