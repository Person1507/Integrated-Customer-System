import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    
    private JFrame frame;
    private CustomerProfDB database;

    public MainMenu() {
        frame = new JFrame();
        database = new CustomerProfDB("test.txt");

        // page title
        JLabel title = new JLabel("Integrated Customer System");
        title.setBounds(40, 0, 200, 60);

        // all of the buttons that select the functionality the client wants to use

        JRadioButton opt1 = new JRadioButton("Create Profile");
        opt1.setBounds(50, 50, 200, 30);

        JRadioButton opt2 = new JRadioButton("Delete Profile");
        opt2.setBounds(50, 75, 200, 30);

        JRadioButton opt3 = new JRadioButton("Update Profile");
        opt3.setBounds(50, 100, 200, 30);

        JRadioButton opt4 = new JRadioButton("Find/Display Profile");
        opt4.setBounds(50, 125, 200, 30);

        JRadioButton opt5 = new JRadioButton("Display All Profiles");
        opt5.setBounds(50, 150, 200, 30);

        // put all buttons in a button group so it looks cohesive
        ButtonGroup bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);
        bg.add(opt5);

        // add title and options to frame
        frame.add(title);
        frame.add(opt1);
        frame.add(opt2);
        frame.add(opt3);
        frame.add(opt4);
        frame.add(opt5);

        // select button to go to functionality
        JButton select = new JButton("Select");
        select.setBounds(75, 200, 100, 50);

        // add ActionListener to select button so that it does something
        select.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // generate objects when a certain button is selected
                if(opt1.isSelected()) new CreateProfile(database);
                else if(opt2.isSelected()) new DeleteProfile(database);
            }
        });

        // add select button to frame
        frame.add(select);

        // set window size and visibility
        // make Java runner close upon clicking X button
        frame.setSize(300, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public static void main(String[] args){
        new MainMenu();
    }
}