import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Update extends JFrame implements ActionListener{
    // Text Field for the new value we want to update
    static JTextField t;
    // JFrame is the window
    static JFrame f;
    // JButton
    static JButton b;
    // Labels to display text
    static JLabel l,lTwo,lThree;
    //Customer Prof object that will store the profile passed down from UpdateProfile.java
    public CustomerProf pf2;

    // These variables store the ID, Last name and chosen field variables passed down
    public String Id;
    public String lName;
    public String currField;

    // Class Constructor
    Update(CustomerProf pf,String field)
    {
        pf2 = pf;
        currField = field;

    }
    public void makeFrame(String adId, String lastName, String field){
        Id = adId;
        lName = lastName;
        currField = field;

        //Standard frame and panel setup
        f = new JFrame("Update");
        Update up = new Update(pf2,currField);
        JPanel p = new JPanel();
        GridLayout gL = new GridLayout(3,2);

        //AdminId Text
        l = new JLabel("AdminID - " + adId);
        l.setBounds(0,0,20,20);
        p.add(l);
        //Last Name Text
        lTwo = new JLabel("Last Name - " + lastName);
        lTwo.setBounds(0,10,20,20);
        p.add(lTwo);
        //Update field
        lThree = new JLabel(field);
        lThree.setBounds(0,20,20,20);
        t = new JTextField(16);
        p.add(lThree);
        p.add(t);
        //Submit Button
        b = new JButton("Submit");
        b.addActionListener(up);
        p.add(b);
        // add panel to frame
        f.add(p);
        // set the size of frame
        f.setSize(280, 300);
        f.show();
        //This add Key Listener checks to see if the user
        // is entering a value that is not a number
        // for income, it keeps giving error messages until
        // a number is entered
        if (currField == "Income"){
            t.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String value = t.getText();
                    int l = value.length();
                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyChar() == '\b' ) {
                        t.setEditable(true);
                    } else {
                        JOptionPane.showMessageDialog(null,"Enter only numbers for income please!","Error Message",1);
                    }
                }
            });
        }
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        VehicleInfo vfCurr = pf2.getVehicleInfo();  // this holds the Vehicle Info of the current profile
        if (s.equals("Submit")) {
            //"First Name","Last Name", "Address","Phone","Income","Use","Status","Model","Year","Type","Method"

            //The code below sets the new value to
            // the field that was specified
            // if any errors are found the code asks
            // the user to try again after giving error messages

            if (currField == "First Name"){
                pf2.updateFirstName(t.getText());
                t.setText("");
            }else if (currField == "Last Name"){
                pf2.updateLastName(t.getText());
                t.setText("");
            }else if (currField == "Address"){
                pf2.updateAddress(t.getText());
                t.setText("");
            }else if (currField == "Phone"){
                pf2.updatePhone(t.getText());
                t.setText("");
            }else if (currField == "Income"){
                pf2.updateIncome(Float.parseFloat(t.getText()));
                t.setText("");
            }else if (currField == "Use"){
                pf2.updateUse(t.getText());
                t.setText("");
                System.out.println("New use: " + pf2.getUse());
            }else if (currField == "Status"){
                String input = t.getText();
                if (input.compareTo("Inactive") == 0 || input.compareTo("Active")==0){
                    pf2.updateStatus(t.getText());
                }else{
                    JOptionPane.showMessageDialog(null,"It must be Active or Inactive! Enter The value again!","Error Message",1);
                }
                t.setText("");
            }else if (currField == "Model"){
                vfCurr.updateModel(t.getText());
                t.setText("");
            }else if (currField == "Year"){
                vfCurr.updateYear(t.getText());
                t.setText("");
            }else if (currField == "Type"){
                vfCurr.updateType(t.getText());
                t.setText("");
            }else{
                vfCurr.updateMethod(t.getText());
                t.setText("");
            }
        }
    }

}

