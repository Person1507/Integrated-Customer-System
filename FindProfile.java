import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class FindProfile extends JFrame implements ActionListener {
    // JTextFields for the admin id and last name
    static JTextField t,tTwo;
    // JFrame to hold everything
    static JFrame f;
    // JButton for finding the profile
    static JButton b;
    // Label to display admin id and last name texts
    static JLabel l,lTwo;
    static JButton close;

    //CustomerProf Database to hold the one that
    //is passed down through the constructor
    private CustomerProfDB db3;

    //These two strings will hold the strings that
    // the user will enter to find the profile
    // they are looking for
    private String response;
    private String responseTwo;

    //Default constructor
    FindProfile(CustomerProfDB db)
    {
        db3 = db;
    }

    // main class
    public void main()
    {
        f = new JFrame("Find Profile");
        FindProfile fp = new FindProfile(db3); // new Find profile object for the button listener
        JPanel p = new JPanel();

        //AdminId section
        //--Asks user for Admin ID
        l = new JLabel("Enter AdminID:");
        l.setBounds(0,0,20,20);
        t = new JTextField(16);
        p.add(l);
        p.add(t);

        //Last Name section
        //--Asks user for the last name of the profile
        lTwo = new JLabel("Enter Last Name:");
        lTwo.setBounds(0,10,20,20);
        tTwo = new JTextField(16);
        p.add(lTwo);
        p.add(tTwo);

        //Find button for window
        b = new JButton("Find");
        b.addActionListener(fp);
        p.add(b);

        // add panel to frame
        f.add(p);
        // set the size of frame
        f.setSize(280, 300);
        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // This if statement gets the text from the
        // text fields we set up and checks to see if
        // the profile that the user entered the admin Id
        // and last name for actually exists. If it does
        // it makes a new CustomerProfile object and then
        // calls the main function in order to make the
        // actual window
        if (s.equals("Find")) {
            response = t.getText();
            responseTwo = (String) tTwo.getText();
            if (this.db3.findProfile( (String) response, (String) responseTwo) == null){
                JOptionPane.showMessageDialog(null,"This profile does not exist. Please try a different profile!","Error Message",1);
            }else {
                CustomerProfile cProfNew = new CustomerProfile(this.db3.findProfile( (String) response, (String) responseTwo));
                cProfNew.printProf();
            }

            // These set the text boxes to blank
            t.setText("");
            tTwo.setText("");
        }
    }
}
