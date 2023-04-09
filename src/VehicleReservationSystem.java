import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

class VehicleReservationSystem {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        // FIXME: User Story: user is making a new reservation (this information should be found from the Reservation object)
        // In Database, there is a Camry vehicle has a reservation between "2022-01-01 09:00:00.000" and "2022-01-01 11:00:00.000", so this vehicle should be filtered out by time
        Reservation newReservation = new Reservation("Sedan", "New York", "2022-01-01 10:00:00.000", "2022-01-01 14:00:00.000");
        String requestedVehicleType = newReservation.requestVehicleType();
        String userLocation = newReservation.getUserLocation();
        int startTime = newReservation.getStartTime();
        int endTime = newReservation.getEndTime();
        // TODO: The key issue is how to update the proximity of vehicles relative to user in database in real-time
        int maxProximity = 15; // Maximum proximity in miles

        // Initialize the database with sample data filtered by start and end time
        VehicleDatabase vehicleDatabase = new VehicleDatabase(startTime, endTime);

        // Perform vehicle search
        VehicleSearch search = new VehicleSearch(vehicleDatabase);
        List<Vehicle> availableVehicles = search.findAvailableVehicles(requestedVehicleType, maxProximity);

        // Print results
        if (availableVehicles.isEmpty()) {
            System.out.println("No vehicles are available.");
        } else {
            System.out.println("Sorted and filtered list of available vehicles:");
            for (Vehicle vehicle : availableVehicles) {
                System.out.println(vehicle.toString());
            }
        }
    }
}
