USE VehicleReservationSystem;

UPDATE Reservation SET user_number = FLOOR(RAND() * 6) + 1;

