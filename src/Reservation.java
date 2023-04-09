/*
 * Reservation Class is for demo purpose only
 * ATP component should receive reservation
 * object from Reservation component
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Reservation {
    private String requestVehicleType;
    private String userLocation;
    private int startTimeUnix;
    private int endTimeUnix;

    // Constructor - New Reservation Request from User
    public Reservation(String requestVehicleType, String userLocation, String startTime, String endTime) throws ParseException {
        this.requestVehicleType = requestVehicleType;
        this.userLocation = userLocation;
        this.startTimeUnix = datetimeToUnix(startTime);
        this.endTimeUnix = datetimeToUnix(endTime);
        System.out.println("User requested time ---> startTimeUnix is: " + startTimeUnix + " ; endTimeUnix is: " + endTimeUnix + "\n");
    }

    // Method - Convert String Date&Time into unixTime in int
    public static int datetimeToUnix(String datetime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("UTC")); // Set timezone to UTC
        Date date = format.parse(datetime);
        long unixTime = date.getTime() / 1000;
        return (int) unixTime;
    }

    // Getters
    public String requestVehicleType() {
        return requestVehicleType;
    }

    public String getUserLocation() { return userLocation; }

    public int getStartTime() { return startTimeUnix; }

    public int getEndTime() { return endTimeUnix; }
}
