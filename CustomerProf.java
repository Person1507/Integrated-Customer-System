
import java.io.File;           //imports java file methods for Log file
import java.util.Date;         // imports the java date for recording time of testing.
import java.io.FileNotFoundException;

// Serializable is added so that it could be tested using the TestClass.java
public class CustomerProf{
    // remember to add vehicle info
    private String adminID,firstName,lastName,address,phone,status,use;
    private float income;
    private VehicleInfo vehicleInfo;

    public CustomerProf(String adminId,String FName,String LName,String Address,String phoneNum,float incomeAmt,String customerStatus,String vehicleUse, VehicleInfo vh){
        adminID = adminId;                     // sets the admin id variable
        firstName = FName;                     // sets the first name variable
        lastName = LName;                      // sets the last name variable
        address = Address;                     // sets the address of the customer profile
        phone = phoneNum;                      // sets the phone number of the profile
        income = incomeAmt;                    // sets the customers current income
        status = customerStatus;              // sets the customers active/inactive status
        use = vehicleUse;                     // sets the customer's preferred vehicle use
        vehicleInfo = vh;                     // sets the vechicle info of the customer profile
    }

    public String getAdminID(){          // this returns the admin id associated with the profile
        return adminID;
    }         // gets the current admin ID
    public String getFirstName(){        // this returns the first name of the customer associated with the profile
        return firstName;
    }     // gets the first name of profile
    public String getLastName(){         // this returns the last name of the customer associated with the profile
        return lastName;
    }       // gets the last name of profile
    public String getAddress(){          // this returns the address of the customer associated with the profile
        return address;
    }         // gets the associated address
    public String getPhone(){            // this returns the phone number of the customer associated with the profile
        return phone;
    }             // gets the profile's phone number
    public float getIncome(){            // this returns the income of the customer associated with the profile
        return income;
    }            // gets the income of profile
    public String getStatus(){           // this returns the current status of the customer associated with the profile
        return status;
    }           // gets the status inactive/active of customer
    public String getUse(){              // this returns the usage of the customer's vehicle associated with the profile
        return use;
    }                 // gets the usage of vehicle from profile
    public VehicleInfo getVehicleInfo(){return vehicleInfo;}
    public void updateFirstName(String name){         // this updates the current first name of the profile
        this.firstName = name;
    }
    public void updateLastName(String name ){         // this updates the current last name of the profile
        this.lastName = name;
    }
    public void updateAddress(String currAddress){      // this updates the current address of the profile
        this.address = currAddress;
    }
    public void updatePhone(String phoneNumber){        // this updates the phone number of the customer profile
        this.phone = phoneNumber;
    }
    public void updateIncome(float profIncome){         // this updates the income of the profile of the customer
        this.income = profIncome;
    }
    public void updateStatus(String currStatus){        // this updates the customer's profile status
        this.status = currStatus;
    }
    public void updateUse(String currUse){              // this updates the car's use
        this.use = currUse;
    }
    public void updateVehicleInfo(VehicleInfo vhInfo){
        vehicleInfo = vhInfo;
    }

}
