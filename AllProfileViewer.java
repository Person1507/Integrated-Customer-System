import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;




public class AllProfileViewer extends JFrame implements ActionListener {

    // All of our text fields that hold all of the values in each customer profile
    static JTextField tOne,tTwo,tThree,tFour,tFive,tSix,tSeven,tEight,tNine,tTen,tEleven,tTwelve;
    //JPanel for the window
    private JPanel p;
    // JFrame for the window
    static JFrame f;
    // JButton for the window to get the next profile
    static JButton b;
    // Labels to display all of the fields for each profile
    static JLabel lOne,lTwo,lThree,lFour,lFive,lSix,lSeven,lEight,lNine,lTen,lEleven,lTwelve;
    
    // pf3, db3, and ID hold the different variables passed down
    // through the default constructor further below
    public CustomerProf pf3;
    public CustomerProfDB db3;
    private String ID;

    //private int count = 0;

    // Default Constructor
    AllProfileViewer(CustomerProf pf, CustomerProfDB db,String adid2)
    {
        pf3 = pf;
        db3 = db;
        ID = adid2;
    }

    // This ChangePanel Function will
    // be called whenever the Next Profile
    // button is pressed
    private int changePanel(String id){
        pf3 = db3.findNextProfile();       // Calls the next profile

        // If the pf3 is null we are at the end of the list
        // so we return 1 which signals the program to
        // tell the user that no other ones are available
        if (pf3 == null){
            return 1;
        }

        // This Checks to see if the admin ID of the current
        // customer profile matches the one whe are looking for
        // if it doesn't then the next profile is accessed,
        // This will continue until you get to one that
        // matches or the next profile is null
        // if the profile is null then the return statement
        // returns a 1 and notifies the user
        while (pf3.getAdminID().compareTo(id) != 0){
            pf3 = db3.findNextProfile();
            if (pf3 == null){
                return 1;
            }
        }

        // This string array gets the different values of the
        // new profile we changed to from the old one
        String[] texts = {pf3.getAdminID(),pf3.getFirstName(),pf3.getLastName(),pf3.getAddress(),pf3.getPhone(),Float.toString(pf3.getIncome()),pf3.getUse(),pf3.getStatus(),
                pf3.getVehicleInfo().getModel(), pf3.getVehicleInfo().getYear(),pf3.getVehicleInfo().getType(),pf3.getVehicleInfo().getMethod()};

        // Sets the new value for text field 1
        tOne.setEditable(true);
        tOne.setText(texts[0]);
        tOne.setEditable(false);

        // Sets the new value for text field 2
        tTwo.setEditable(true);
        tTwo.setText(texts[1]);
        tTwo.setEditable(false);

        // Sets the new value for text field 3
        tThree.setEditable(true);
        tThree.setText(texts[2]);
        tThree.setEditable(false);

        // Sets the new value for text field 4
        tFour.setEditable(true);
        tFour.setText(texts[3]);
        tFour.setEditable(false);

        // Sets the new value for text field 5
        tFive.setEditable(true);
        tFive.setText(texts[4]);
        tFive.setEditable(false);

        // Sets the new value for text field 6
        tSix.setEditable(true);
        tSix.setText(texts[5]);
        tSix.setEditable(false);

        // Sets the new value for text field 7
        tSeven.setEditable(true);
        tSeven.setText(texts[6]);
        tSeven.setEditable(false);

        // Sets the new value for text field 8
        tEight.setEditable(true);
        tEight.setText(texts[7]);
        tEight.setEditable(false);

        // Sets the new value for text field 9
        tNine.setEditable(true);
        tNine.setText(texts[8]);
        tNine.setEditable(false);

        // Sets the new value for text field 10
        tTen.setEditable(true);
        tTen.setText(texts[9]);
        tTen.setEditable(false);

        // Sets the new value for text field 11
        tEleven.setEditable(true);
        tEleven.setText(texts[10]);
        tEleven.setEditable(false);

        // Sets the new value for text field 12
        tTwelve.setEditable(true);
        tTwelve.setText(texts[11]);
        tTwelve.setEditable(false);
        return 0;
    }

    //This makePanel function sets up the first customer profile
    // that has the matching admin Id that is requested by
    // the user
    public int makePanel(String id){

        // If the pf3 is null , this means that
        // there are no profiles in the list that
        // matches the admin ID you specified
        // and the user is notified
        if (pf3 == null){
            return 1;
        }

        // This Checks to see if the admin ID of the current
        // customer profile matches the one whe are looking for
        // if it doesn't then the next profile is accessed,
        // This will continue until you get to one that
        // matches or the next profile is null
        // if the profile is null then the return statement
        // returns a 1 and notifies the user
        while (pf3.getAdminID().compareTo(id) != 0){
            pf3 = db3.findNextProfile();
            if (pf3 == null){
                return 1;
            }
        }

        p = new JPanel(); // new Panel to hold all of the customer profiles from this point on
        AllProfileViewer aProf = new AllProfileViewer(pf3,db3,ID); // Class object for button listener

        // Choices holds all the Profile fields
        String[] choices = { "Admin ID: ","First Name: ","Last Name: ", "Address: ","Phone: ","Income: ","Use: ","Status: ","Model: ","Year: ","Type: ","Method: "};

        // Texts holds all of the current values for
        // each of the fields we care about
        String[] texts = {pf3.getAdminID(),pf3.getFirstName(),pf3.getLastName(),pf3.getAddress(),pf3.getPhone(),Float.toString(pf3.getIncome()),pf3.getUse(),pf3.getStatus(),
                pf3.getVehicleInfo().getModel(), pf3.getVehicleInfo().getYear(),pf3.getVehicleInfo().getType(),pf3.getVehicleInfo().getMethod()};

        // Sets up the Admin ID field and the text box
        lOne = new JLabel(choices[0]);
        lOne.setBounds(0,0,20,20);
        tOne = new JTextField(16);
        p.add(lOne);
        p.add(tOne);
        tOne.setText(texts[0]);
        tOne.setEditable(false);

        // Sets up the First Name field and the text box
        lTwo = new JLabel(choices[1]);
        lTwo.setBounds(0,0,20,20);
        tTwo = new JTextField(16);
        p.add(lTwo);
        p.add(tTwo);
        tTwo.setText(texts[1]);
        tTwo.setEditable(false);

        // Sets up the Last Name field and the text box
        lThree = new JLabel(choices[2]);
        lThree.setBounds(0,0,20,20);
        tThree = new JTextField(16);
        p.add(lThree);
        p.add(tThree);
        tThree.setText(texts[2]);
        tThree.setEditable(false);

        // Sets up the Address field and the text box
        lFour = new JLabel(choices[3]);
        lFour.setBounds(0,0,20,20);
        tFour = new JTextField(16);
        p.add(lFour);
        p.add(tFour);
        tFour.setText(texts[3]);
        tFour.setEditable(false);

        // Sets up the Phone field and the text box
        lFive = new JLabel(choices[4]);
        lFive.setBounds(0,0,20,20);
        tFive = new JTextField(16);
        p.add(lFive);
        p.add(tFive);
        tFive.setText(texts[4]);
        tFive.setEditable(false);

        // Sets up the Income field and the text box
        lSix = new JLabel(choices[5]);
        lSix.setBounds(0,0,20,20);
        tSix = new JTextField(16);
        p.add(lSix);
        p.add(tSix);
        tSix.setText(texts[5]);
        tSix.setEditable(false);

        // Sets up the Use field and the text box
        lSeven = new JLabel(choices[6]);
        lSeven.setBounds(0,0,20,20);
        tSeven = new JTextField(16);
        p.add(lSeven);
        p.add(tSeven);
        tSeven.setText(texts[6]);
        tSeven.setEditable(false);

        // Sets up the Status field and the text box
        lEight = new JLabel(choices[7]);
        lEight.setBounds(0,0,20,20);
        tEight = new JTextField(16);
        p.add(lEight);
        p.add(tEight);
        tEight.setText(texts[7]);
        tEight.setEditable(false);

        // Sets up the Model field and the text box
        lNine = new JLabel(choices[8]);
        lNine.setBounds(0,0,20,20);
        tNine = new JTextField(16);
        p.add(lNine);
        p.add(tNine);
        tNine.setText(texts[8]);
        tNine.setEditable(false);

        // Sets up the Year field and the text box
        lTen = new JLabel(choices[9]);
        lTen.setBounds(0,0,20,20);
        tTen = new JTextField(16);
        p.add(lTen);
        p.add(tTen);
        tTen.setText(texts[9]);
        tTen.setEditable(false);

        // Sets up the Type field and the text box
        lEleven = new JLabel(choices[10]);
        lEleven.setBounds(0,0,20,20);
        tEleven = new JTextField(16);
        p.add(lEleven);
        p.add(tEleven);
        tEleven.setText(texts[10]);
        tEleven.setEditable(false);

        // Sets up the Method field and the text box
        lTwelve = new JLabel(choices[11]);
        lTwelve.setBounds(0,0,20,20);
        tTwelve = new JTextField(16);
        p.add(lTwelve);
        p.add(tTwelve);
        tTwelve.setText(texts[11]);
        tTwelve.setEditable(false);
        /*
        if (count == 0 ){
            b = new JButton("NextProfile");
            b.addActionListener(aProf);
            p.add(b);
            f.getContentPane().add(p);
            f.setSize(275, 400);
            f.show();
            count++;
        }
         */

        //Next Profile Button
        b = new JButton("Next Profile");
        b.addActionListener(aProf);
        p.add(b);
        //Adds the panel to the frame
        f.getContentPane().add(p);
        // Sets frame size
        f.setSize(288, 450);
        f.show();
        return 0;
    }

    //This is the main Function which is called by the DisplayAllProfiles.java
    // It will call the makePanel and check to see if there are any profiles that
    // have the adminId at all
    public int printAllProfs(){
        f = new JFrame("Profile Display");
        if (makePanel(ID) == 1){
            JOptionPane.showMessageDialog(null,"There are no profiles with that Admin ID","Error Message",1);
        }
        return 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // When the next profile button is clicked,
        // It will call the change panel function
        // if there are no profiles left to view,
        // it will alert the user
        if (s.equals("Next Profile")) {
            if (changePanel(ID) == 1){
                JOptionPane.showMessageDialog(null,"No more Profiles are available!","Error Message",1);
            }
        }
    }
}
