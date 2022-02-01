import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class CustomerProfile extends JFrame implements ActionListener {
    // Text field thats going to hold all of the values of a standard CustomerProfile Frame
    static JTextField tOne;
    // JFrame is the window
    static JFrame f;
    // JButton for the close feature
    static JButton b;
    // Label to display all of the different fields of a Profile
    static JLabel lOne;
    // CustomerProf object that will hold the passed down profile from FindProfile.java
    private CustomerProf pf2;


    CustomerProfile(CustomerProf pf)
    {
        pf2 = pf;
    }
    public void printProf(){

        f = new JFrame("Find Profile");
        CustomerProfile cProf = new CustomerProfile(pf2);
        JPanel p = new JPanel();

        // This String array choices holds all of the different fields for the frame
        String[] choices = { "Admin ID: ","First Name: ","Last Name: ", "Address: ","Phone: ","Income: ","Use: ","Status: ","Model: ","Year: ","Type: ","Method: "};

        // The string array gets all of the values from the customer Profile that was passed down from
        // FindProfile.java by calling the methods
        String[] texts = {pf2.getAdminID(),pf2.getFirstName(),pf2.getLastName(),pf2.getAddress(),pf2.getPhone(),Float.toString(pf2.getIncome()),pf2.getUse(),pf2.getStatus(),
                pf2.getVehicleInfo().getModel(), pf2.getVehicleInfo().getYear(),pf2.getVehicleInfo().getType(),pf2.getVehicleInfo().getMethod()};

        // For loop iterates through all of the choices and the values and all
        // of the labels and the Text fields along with setting the text fields
        // as not editable to prevent the user from altering the values in the
        // text areas
        for (int v = 0; v < choices.length; v++){
            lOne = new JLabel(choices[v]);
            lOne.setBounds(0,0,20,20);
            tOne = new JTextField(16);
            p.add(lOne);
            p.add(tOne);
            tOne.setText(texts[v]);
            tOne.setEditable(false);
        }
        //Customer Profile Close button
        b = new JButton("Close");
        b.addActionListener(cProf);
        p.add(b);

        // Add panel to frame
        f.add(p);
        // set the size of frame
        f.setSize(288, 450);
        f.show();
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        //If the close button is pressed,
        //the window showing the profile
        // will be closed
        if (s.equals("Close")) {
            f.setVisible(false);
            f.dispose();
        }
    }
}
