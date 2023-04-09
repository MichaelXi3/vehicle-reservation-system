USE VehicleReservationSystem;

ALTER TABLE Reservation
ADD start_time_unix BIGINT NOT NULL DEFAULT 0,
    end_time_unix BIGINT NOT NULL DEFAULT 0;

UPDATE Reservation
SET start_time_unix = DATEDIFF(second, '1970-01-01 00:00:00', start_time),
    end_time_unix = DATEDIFF(second, '1970-01-01 00:00:00', end_time)
