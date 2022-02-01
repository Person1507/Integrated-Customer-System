import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateProfile extends JFrame {
    
    private JFrame f;

    public CreateProfile(CustomerProfDB database) {  
        //create frame
        f = new JFrame();

        // create title, labels for inputs, and input boxes themselves
        JLabel title = new JLabel("Create Profile");
        title.setBounds(100, 0, 200, 60);

        JLabel adminID = new JLabel("Admin ID:");
        adminID.setBounds(10, 50, 100, 30);

        JTextField aID = new JTextField();
        aID.setBounds(90, 50, 200, 30);
        
        JLabel firstName = new JLabel("First Name:");
        firstName.setBounds(10, 75, 100, 30);
        
        JTextField fName = new JTextField();
        fName.setBounds(90, 75, 200, 30);
        
        JLabel lastName = new JLabel("Last Name:");
        lastName.setBounds(10, 100, 100, 30);

        JTextField lName = new JTextField();
        lName.setBounds(90, 100, 200, 30);

        JLabel address = new JLabel("Address:");
        address.setBounds(10, 125, 100, 30);

        JTextField addr = new JTextField();
        addr.setBounds(90, 125, 200, 30);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(10, 150, 100, 30);

        JTextField pn = new JTextField();
        pn.setBounds(90, 150, 200, 30);

        JLabel income = new JLabel("Income:");
        income.setBounds(10, 175, 100, 30);

        JTextField inc = new JTextField();
        inc.setBounds(90, 175, 200, 30);
        
        JLabel use = new JLabel("Use:");
        use.setBounds(10, 200, 100, 30);

        // JComboBox = dropdown
        String[] uses = {"Personal", "Business"};
        JComboBox useMenu = new JComboBox(uses);
        useMenu.setBounds(90, 200, 200, 30);

        JLabel status = new JLabel("Status:");
        status.setBounds(10, 225, 100, 30);

        String[] statuses = {"Active", "Inactive"};
        JComboBox statusMenu = new JComboBox(statuses);
        statusMenu.setBounds(90, 225, 200, 30);

        JLabel model = new JLabel("Model:");
        model.setBounds(10, 250, 100, 30);
        
        JTextField m = new JTextField();
        m.setBounds(90, 250, 200, 30);

        JLabel year = new JLabel("Year:");
        year.setBounds(10, 275, 100, 30);

        JTextField yr = new JTextField();
        yr.setBounds(90, 275, 200, 30);

        JLabel type = new JLabel("Type:");
        type.setBounds(10, 300, 100, 30);

        String[] types = {"Sedan", "Hatchback", "Luxury", "Sport", "Other"};
        JComboBox typeMenu = new JComboBox(types);
        typeMenu.setBounds(90, 300, 200, 30);

        JLabel method = new JLabel("Method:");
        method.setBounds(10, 325, 100, 30);

        String[] methods = {"New", "Used", "Certified Pre-Owned"};
        JComboBox methodMenu = new JComboBox(methods);
        methodMenu.setBounds(90, 325, 200, 30);

        // submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(100, 375, 100, 50);

        // actionlistener for submit button
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                // create VehicleInfo object and pass in attributes
                VehicleInfo vi = new VehicleInfo(m.getText(), yr.getText(), (String)typeMenu.getSelectedItem(), (String)methodMenu.getSelectedItem());
                // error handling if invalid input for income (accepts float)
                // if input is valid
                try{
                    float i = Float.parseFloat(inc.getText());
                    // create CustomerProf object and pass in attributes
                    CustomerProf cp = new CustomerProf(aID.getText(), fName.getText(), lName.getText(), addr.getText(), pn.getText(), i, (String)statusMenu.getSelectedItem(), (String)useMenu.getSelectedItem(), vi);
                    database.insertNewProfile(cp);
                    f.setVisible(false);
                }
                // if input is invalid
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please do not enter any non-numerical characters in the income field.");
                }
            }
        });

        // add components to frame
        f.add(title);
        f.add(adminID);
        f.add(aID);
        f.add(firstName);
        f.add(fName);
        f.add(lastName);
        f.add(lName);
        f.add(address);
        f.add(addr);
        f.add(phone);
        f.add(pn);
        f.add(income);
        f.add(inc);
        f.add(use);
        f.add(useMenu);
        f.add(status);
        f.add(statusMenu);
        f.add(model);
        f.add(m);
        f.add(year);
        f.add(yr);
        f.add(type);
        f.add(typeMenu);
        f.add(method);
        f.add(methodMenu);
        f.add(submit);

        // set size, layout, visibility
        f.setSize(300, 500);
        f.setLayout(null);  
        f.setVisible(true);
        
    }
}