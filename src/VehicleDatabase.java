import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Class representing the vehicle database
class VehicleDatabase {
    // List of Vehicles Queried from Database
    List<Vehicle> vehicles;
    Connection connection;

    // Constructor - Establish Database Connection
    public VehicleDatabase() throws SQLException, ClassNotFoundException {
        createConnection();
    }

    // Constructor - Establish Database Connection & Obtain the List of Vehicle
    public VehicleDatabase(int startTime, int endTime) throws SQLException, ClassNotFoundException {
        createConnection();
        vehicles = new ArrayList<>();
        populateDataByTimePeriod(startTime, endTime);
    }

    // Method - Create Connection to MySQL Database
    private void createConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://database-1.csxdtihcei8o.us-east-1.rds.amazonaws.com:1433;DatabaseName=VehicleReservationSystem;encrypt=true;trustServerCertificate=true";
        String user = "admin";
        String password = "";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(url, user, password);
    }

    // Method - Obtain Data from MySQL Database - Filter by Start and End Time
    private void populateDataByTimePeriod(int startTime, int endTime) throws SQLException {
        // SQL Query that filtered out unavailable vehicles
        String query = "SELECT * FROM Vehicle " +
                "WHERE id NOT IN " +
                "(SELECT vehicle_id FROM Reservation " +
                "WHERE start_time_unix < " + endTime + " AND end_time_unix > " + startTime + ")";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int year = resultSet.getInt("year");
            int batteryLife = resultSet.getInt("battery");
            double proximity = resultSet.getInt("proximity");
            String vehicleType = resultSet.getString("type");
            String vehicleMake = resultSet.getString("make");
            String vehicleModel = resultSet.getString("model");
            String vehicleState = resultSet.getString("status");
            String currentLocation = resultSet.getString("current_location");
            // Other vehicle properties
            Vehicle vehicle = new Vehicle(id, year, proximity, vehicleType, vehicleMake, vehicleModel, currentLocation, batteryLife, vehicleState);
            vehicles.add(vehicle);
        }
        statement.close();
    }

    // Method to get all vehicles
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // TODO: Method - Update a new reservation to database
    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO Reservation (id, start_time, end_time, pickup_location, dropoff_location, vehicle_id, user_location, user_number) VALUES (COALESCE(MAX(id)+1,1), ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setTimestamp(2, reservation.getStartTime();
//        statement.setTimestamp(3, reservation.getEndTime();
//        statement.setString(4, reservation.getPickupLocation());
//        statement.setString(5, reservation.getDropoffLocation());
//        statement.setInt(6, reservation.getVehicleId());
//        statement.setString(7, reservation.getUserLocation());
//        statement.setInt(8, reservation.getUserNumber());
        statement.executeUpdate();
        statement.close();
    }

    // Method to close the connection
    public void close() throws SQLException {
        connection.close();
    }
}

