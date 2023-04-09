import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class VehicleSearch {
    VehicleDatabase vehicleDatabase;

    // Constructor
    public VehicleSearch(VehicleDatabase vehicleDatabase) {
        this.vehicleDatabase = vehicleDatabase;
    }

    // Method to find available vehicles. This method filters out the cars that are not available at the time given in the reservation, or are too far away.
    public List<Vehicle> findAvailableVehicles(String requestedVehicleType, int maxProximity) {
        // Print out the list of vehicles filtered by start and end time
        System.out.println("The list of vehicles filtered by start and end time - Test: Vehicle 2,3,4 should return");
        System.out.println("---------------------------------------------------------------------------------------");
        for (Vehicle vehicle : vehicleDatabase.getVehicles()) {
            System.out.println(vehicle);
        }

        // Further filter the list by vehicle type and proximity
        List<Vehicle> availableVehicles = new ArrayList<>();

        System.out.println("The list of vehicles filtered further by type and proximity - Test: Vehicle 2 should return");
        System.out.println("---------------------------------------------------------------------------------------");
        for (Vehicle vehicle : vehicleDatabase.getVehicles()) {
            if (isVehicleAvailable(vehicle, requestedVehicleType, maxProximity)) {
                availableVehicles.add(vehicle);
            }
        }

        // Sort remaining vehicles by matching user requirements, based on prioritized vehicle data
        sortVehicles(availableVehicles);

        return availableVehicles;
    }

    // Method to check if a vehicle is available
    private boolean isVehicleAvailable(Vehicle vehicle, String requestedVehicleType, int maxProximity) {
        // Check availability of a type of vehicle
        if (!vehicle.getVehicleType().equals(requestedVehicleType)) {
            return false;
        }

        // Filter out vehicles that won't be available at this location and time
        // We have filtered the vehicle database by start and end time at passing in database stage
        if (!vehicle.getVehicleState().equals("Available")) {
            return false;
        }

        // Filter out vehicles outside the maximum proximity
        if (vehicle.getProximity() > maxProximity) {
            return false;
        }

        return true;
    }

    // Method to sort vehicles based on user requirements
    private void sortVehicles(List<Vehicle> vehicles) {
        // Sort Vehicle ID in ascending order
        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.getId() - v2.getId();
            }
        });
        // TODO: Sort vehicles based on prioritized vehicle data, e.g., battery life, proximity, etc.
    }
}

