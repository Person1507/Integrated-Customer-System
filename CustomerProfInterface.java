import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CustomerProfInterface {

    // database stores the database of profiles
    // store the file and Scanner
    private CustomerProfDB database;
    private String file;
    Scanner s;

    // constructor
    // takes in file, and uploads information from file
    public CustomerProfInterface(String fileName) throws FileNotFoundException{
        file = fileName;
        database = new CustomerProfDB(file);
        File f = new File(file);
        s = new Scanner(f);
        while(s.hasNextLine()){
            CustomerProf cp = createNewCustomerProf();
            database.insertNewProfile(cp);
        }
        s = new Scanner(System.in);
    }

    // loops through menu where user chooses what to do
    // input is text through scanner
    // calls appropriate methods
    public void getUserChoice() throws IOException{
        System.out.println("Menu:");
        System.out.println("Enter a new Customer Profile");
        System.out.println("Delete a customer");
        System.out.println("Find and display a Customer Profile");
        System.out.println("Modify a Customer Profile");
        System.out.println("Display all profiles in the database");
        System.out.println("Write to the database");
        System.out.println();
        System.out.print("What would you like to do? Type \"Exit\" to exit. ");
        String choice = s.nextLine();
        System.out.println("\n");
        while(!choice.equals("Exit")){
            if(choice.equals("Enter a new Customer Profile")){
                CustomerProf cp = createNewCustomerProf();
                database.insertNewProfile(cp);
            }
            else if(choice.equals("Delete a customer"))
                deleteCustomerProf();
            else if(choice.equals("Find and display a Customer Profile")){
                CustomerProf cp = findCustomerProf();
                if(cp == null){
                    System.out.println("Sorry! That customer profile cannot be found.");
                }
                else displayCustomerProf(cp);
            }
            else if(choice.equals("Modify a Customer Profile"))
                updateCustomerProf();
            else if(choice.equals("Display all profiles in the database"))
                displayAllCustomerProf();
            else if(choice.equals("Write to the database"))
                writeToDB();
            else {
                System.out.println("That is not a valid choice. Please try again.\n");
            }
            System.out.println("Menu:");
            System.out.println("Enter a new Customer Profile");
            System.out.println("Delete a customer");
            System.out.println("Find and display a Customer Profile");
            System.out.println("Modify a Customer Profile");
            System.out.println("Display all profiles in the database");
            System.out.println("Write to the database");
            System.out.println();
            System.out.print("What would you like to do? Type \"Exit\" to exit. ");
            choice = s.nextLine();
        }
    }

    // takes in adminID & last name, searches for profile, and removes from database
    // returns error message if profile doesn't exist
    private void deleteCustomerProf(){
        String adminID, lastName;
        System.out.print("What is your adminID? ");
        adminID = s.nextLine();
        System.out.print("What is the last name? ");
        lastName = s.nextLine();
        boolean deleted = database.deleteProfile(adminID, lastName);
        if(deleted) System.out.println("The customer profile has been deleted.");
        else System.out.println("The customer profile could not be deleted. This is because it was either not found or the adminID was invalid.");
        System.out.println();
    }

    // uses adminID & last name to find a customer profile in database
    private CustomerProf findCustomerProf(){
        String adminID, lastName;
        System.out.print("What is your adminID? ");
        adminID = s.nextLine();
        System.out.println();
        System.out.print("What is the last name? ");
        lastName = s.nextLine();
        System.out.println();
        System.out.println();
        CustomerProf cp = database.findProfile(adminID, lastName);
        return cp;
    }

    // updates requested field of a customer profile as requested by client
    private void updateCustomerProf(){
        CustomerProf cp = findCustomerProf();
        if(cp != null){
            System.out.println("What would you like to update? Choices are Address, Phone, Use, or Status. You can also update the Model, Year, Type, or Method of the vehicle. ");
            String choice = s.nextLine();
            System.out.println("\n");
            if(choice.equals("Address")){
                System.out.print("What is the new address? ");
                String address = s.nextLine();
                System.out.println();
                cp.updateAddress(address);
                System.out.println("The address has been updated!\n");
            }
            else if(choice.equals("Phone")){
                System.out.print("What is the new phone number? ");
                String phone = s.nextLine();
                System.out.println();
                cp.updatePhone(phone);
                System.out.println("The phone number has been updated!\n");
            }
            else if(choice.equals("Use")){
                System.out.print("What is the new use? ");
                String use = s.nextLine();
                System.out.println();
                cp.updateUse(use);
                System.out.println("The use has been updated!\n");
            }
            else if(choice.equals("Status")){
                System.out.print("What is the new address? ");
                String status = s.nextLine();
                System.out.println();
                cp.updateStatus(status);
                System.out.println("The status has been updated!\n");
            }
            else if(choice.equals("Model")){
                System.out.print("What is the new model? ");
                String model = s.nextLine();
                System.out.println();
                VehicleInfo vi = cp.getVehicleInfo();
                vi.updateModel(model);
                cp.updateVehicleInfo(vi);
                System.out.println("The model has been updated!\n");
            }
            else if(choice.equals("Year")){
                System.out.print("What is the new year? ");
                String year = s.nextLine();
                System.out.println();
                VehicleInfo vi = cp.getVehicleInfo();
                vi.updateYear(year);
                cp.updateVehicleInfo(vi);
                System.out.println("The year has been updated!\n");
            }
            else if(choice.equals("Type")){
                System.out.print("What is the new type?");
                String type = s.nextLine();
                System.out.println();
                VehicleInfo vi = cp.getVehicleInfo();
                vi.updateType(type);
                cp.updateVehicleInfo(vi);
                System.out.println("The type has been updated!\n");
            }
            else {
                System.out.print("What is the new method? ");
                String method = s.nextLine();
                System.out.println();
                VehicleInfo vi = cp.getVehicleInfo();
                vi.updateMethod(method);
                cp.updateVehicleInfo(vi);
                System.out.println("The method has been updated!\n");
            }
        }
        else System.out.println("Sorry! That profile cannot be found.\n");
    }

    // lays out a way to show attributes of a customer profile
    private void displayCustomerProf(CustomerProf cp){
        System.out.println("adminID: " + cp.getAdminID());
        System.out.println("First Name: " + cp.getFirstName());
        System.out.println("Last Name: " + cp.getLastName());
        System.out.println("Address: " + cp.getAddress());
        System.out.println("Phone Number: " + cp.getPhone());
        System.out.println("Income: " + cp.getIncome());
        System.out.println("Status: " + cp.getStatus());
        System.out.println("Use: " + cp.getUse());
        System.out.println();
        System.out.println("Vehicle Information:");
        System.out.println("Model:" + cp.getVehicleInfo().getModel());
        System.out.println("Year: " + cp.getVehicleInfo().getYear());
        System.out.println("Type: " + cp.getVehicleInfo().getType());
        System.out.println("Method:" + cp.getVehicleInfo().getMethod());
        System.out.println();
    }

    // displays all customer profiles
    // first gets first one, and then all subsequent ones (finds end if findNextProfile() returns null)
    // error message if no profiles
    private void displayAllCustomerProf(){
        CustomerProf cp = database.findFirstProfile();
        if(cp == null){
            System.out.println("There are no customers in the database.");
        }
        else{
            displayCustomerProf(cp);
            System.out.println();
            cp = database.findNextProfile();
            while(cp != null){
                displayCustomerProf(cp);
                System.out.println();
                cp = database.findNextProfile();
            }
        }
    }

    // writes all profiles to text file database
    // clears current file every time so that info is not just appended
    private void writeToDB() throws IOException{
        database.initializeDatabase(file);
        database.writeAllCustomerProf();
        System.out.println("The database has been updated!\n");
    }

    // creates customer profile object and calls vehicle info creator
    private CustomerProf createNewCustomerProf(){
        String adminID,firstName,lastName,address,phone,status,use;
        float income;
        System.out.print("What is your adminID? ");
        adminID = s.nextLine();
        System.out.println();
        System.out.print("What is the first name? ");
        firstName = s.nextLine();
        System.out.println();
        System.out.print("What is the last name? ");
        lastName = s.nextLine();
        System.out.println();
        System.out.print("What is the address? ");
        address = s.nextLine();
        System.out.println();
        System.out.print("What is the phone number? ");
        phone = s.nextLine();
        System.out.println();
        System.out.print("What is their income? ");
        income = Float.parseFloat(s.nextLine());
        System.out.println();
        System.out.print("What is the status? ");
        status = s.nextLine();
        System.out.println();
        System.out.print("What is the use? ");
        use = s.nextLine();
        System.out.println();
        VehicleInfo v = createNewVehicleInfo();
        CustomerProf cp = new CustomerProf(adminID, firstName, lastName, address, phone, income, status, use, v);
        return cp;
    }

    //creates VehicleInfo object
    private VehicleInfo createNewVehicleInfo(){
        String model, year, type, method;
        System.out.print("What is the model of the car? ");
        model = s.nextLine();
        System.out.println();
        System.out.print("What is the year of the car? ");
        year = s.nextLine();
        System.out.println();
        System.out.print("What is the type of the car? ");
        type = s.nextLine();
        System.out.println();
        System.out.print("What was the method the vehicle was acquired? ");
        method = s.nextLine();
        System.out.println();
        VehicleInfo v = new VehicleInfo(model, year, type, method);
        return v;
    }

    //main method to run the interface
    public static void main(String[] args) throws IOException{
        CustomerProfInterface cpi = new CustomerProfInterface("test.txt");
        cpi.getUserChoice();
        System.out.println("All set!");
    }
}