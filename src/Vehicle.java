import java.util.List;

// Class representing a vehicle
class Vehicle {
    // Local Variables
    private int vehicleID;
    private int year;
    private double proximity;
    private String vehicleType;
    private String vehicleMake;
    private String vehicleModel;
    private String currentLocation;
    private int batteryLife;
    public String vehicleState;

    private int reservationObjectID;
    private String reservationObjectUserLocation;
    private List<Reservation> reservation;

    public Vehicle(int vehicleID, int year, double proximity, String vehicleType, String vehicleMake, String vehicleModel, String currentLocation, int batteryLife, String vehicleState) {
        this.vehicleID = vehicleID;
        this.year = year;
        this.proximity = proximity;
        this.vehicleType = vehicleType;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.currentLocation = currentLocation;
        this.batteryLife = batteryLife;
        this.vehicleState = vehicleState;
    }

    // Getters
    public String getVehicleType() {
        return this.vehicleType;
    }

    public int getId() {
        return this.vehicleID;
    }

    public int getProximity() {
        // TODO: Method that calculates proximity
        return (int) this.proximity;
    }

    public String getVehicleState() {
        return this.vehicleState;
    }

    // Setters
    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public void setVehicleReservation(int reservationObjectID) {
        this.reservationObjectID = reservationObjectID;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + this.vehicleID +
                "\nVehicle State: " + this.vehicleState +
                "\nVehicle Type: " + this.vehicleType +
                "\nCurrent Location: " + this.currentLocation +
                "\nProximity: " + this.proximity +
                "\nBattery Life: " + this.batteryLife +
                "\n";
    }
}



