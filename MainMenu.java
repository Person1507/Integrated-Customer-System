import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    
    private JFrame frame;
    private CustomerProfDB database;

    public MainMenu() {
        //create JFrame and create database to store customer information
        frame = new JFrame();
        database = new CustomerProfDB("test.txt");

        // create title and buttons to select options at home screen
        JLabel title = new JLabel("Integrated Customer System");
        title.setBounds(40, 0, 200, 60);

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

        // create button group so buttons look cohesive
        ButtonGroup bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);
        bg.add(opt5);

        // add titles and options to frame
        frame.add(title);
        frame.add(opt1);
        frame.add(opt2);
        frame.add(opt3);
        frame.add(opt4);
        frame.add(opt5);

        // select button
        JButton select = new JButton("Select");
        select.setBounds(75, 200, 100, 50);

        // ActionListener for select button
        // if an option is selected, go to that page
        select.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(opt1.isSelected()) new CreateProfile(database);
                else if(opt2.isSelected()) new DeleteProfile(database);
                else if(opt3.isSelected()) new UpdateProfile(database).main();
                else if(opt4.isSelected()) new FindProfile(database).main();
                else new DisplayAllProfiles(database).main();
            }
        });

        //add select button to frame
        frame.add(select);

        // set size, layout, visibility, and have application close entirely upon clicking X
        frame.setSize(300, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    // main method to create main menu
    public static void main(String[] args){
        new MainMenu();
    }
}