import java.io.*;                    // imports all of the java.io
import java.util.ArrayList;             // imports the ArrayList data structure and its operations

public class CustomerProfDB {

    private int numCustomer;                   // number of total customers
    private int currentCustomerIndex;
    private String fileName;
    private ArrayList<CustomerProf> customerList;

    public CustomerProfDB(String f){
        fileName = f;                  // this holds the filename of the file holding all of the profile data
        customerList = new ArrayList<CustomerProf>();     // initializing the list of customer profiles
        numCustomer = 0;
        currentCustomerIndex = 0;
    }

    //This method adds a new profile to the customerList private variable
    public void insertNewProfile(CustomerProf cProf){
        customerList.add(cProf);                                           // the arraylist add method adds the customer profile object given as an argument
        numCustomer++;
        currentCustomerIndex = customerList.size() - 1;
    }

    //this methods finds the profile specified by the admin id and the last name and then deletes it
    public boolean deleteProfile(String adId, String lastName){
        for (int n = 0; n < customerList.size();n++){
            if (customerList.get(n).getAdminID().equals(adId) && customerList.get(n).getLastName().equals(lastName)){
                numCustomer--;
                currentCustomerIndex = n;
                return customerList.remove(customerList.get(n));               //arraylist remove method removes the specific object from the arraylist
            }
        }
        return false;
    }

    // this method finds a specific profile when given the admin who made it and the last name of the customer
    public CustomerProf findProfile(String adID, String lName){
        for (int n = 0; n < customerList.size();n++){
            if (customerList.get(n).getAdminID().equals(adID) && customerList.get(n).getLastName().equals(lName)){
                currentCustomerIndex = n;
                return customerList.get(n);
            }
        }
        return null;
    }


    public CustomerProf findFirstProfile(){
        if(numCustomer == 0) return null;
        currentCustomerIndex = 0;
        return customerList.get(0);
    }                                 // These methods need the interface working

    public CustomerProf findNextProfile(){
        if (currentCustomerIndex == customerList.size() - 1){
            return null;
        }
        currentCustomerIndex++;
        return customerList.get(currentCustomerIndex);
    }

    // the function below writes all of the objects to the ProfileData file
    // this still needs some work it has issues
    // the File once an object is written to it becomes un-openable

    public void writeAllCustomerProf() throws IOException {
        FileWriter DBWrite = new FileWriter(fileName,true);  //file writer initialized
        for (int n = 0; n < customerList.size();n++){
            DBWrite.write(customerList.get(n).getAdminID() + ", " + customerList.get(n).getFirstName() + ", " + customerList.get(n).getLastName() + ", " +
                    customerList.get(n).getAddress() + ", " + customerList.get(n).getPhone() + ", " + customerList.get(n).getIncome() + ", " + customerList.get(n).getStatus()
                    + ", " + customerList.get(n).getUse() + ", " + customerList.get(n).getVehicleInfo().getModel() + ", " + customerList.get(n).getVehicleInfo().getYear() + ", " + customerList.get(n).getVehicleInfo().getType() + ", " + customerList.get(n).getVehicleInfo().getMethod() + "\n");
        }
        DBWrite.close();
    }

    // the function below checks to see if the database file  exists and it it doesn't it will make one
    // will wipe file if file exists so that new data won't just be appended
    public void initializeDatabase(String file) throws FileNotFoundException{
        File f = new File(file);
        if (!f.exists()){
            try{
                f.createNewFile();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            PrintWriter pw = new PrintWriter(file);
            pw.close();
        }
    }


}
