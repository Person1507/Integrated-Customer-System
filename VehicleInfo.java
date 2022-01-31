public class VehicleInfo {
    
    private String model;               // the model of the vehicle
    private String year;                // the year the vehicle was manufactured
    private String type;                // the type of vehicle
                                        // select from sedan, hatchback, luxury, sport, other
    private String method;              // the method the vehicle was acquired
                                        // select from new, certified pre-owned, used, other

    // constructs VehicleInfo object by setting variables to parameters
    public VehicleInfo(String model, String year, String type, String method){
        this.model = model;
        this.year = year;
        this.type = type;
        this.method = method;
    }

    // updates car model
    // sets global variable to parameter; this is done for rest of update methods
    public void updateModel(String model){
        this.model = model;
    }

    // updates year
    public void updateYear(String year){
        this.year = year;
    }

    // updates type
    public void updateType(String type){
        this.type = type;
    }

    // updates method
    public void updateMethod(String method){
        this.method = method;
    }

    // retrieves model
    public String getModel(){
        return model;
    }

    // retrieves year
    public String getYear(){
        return year;
    }

    // retrieves type
    public String getType(){
        return type;
    }

    // retrieves method
    public String getMethod(){
        return method;
    }
}
