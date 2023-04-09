USE VehicleReservationSystem;

-- Insert sample data into Vehicle table
INSERT INTO Vehicle (id, make, model, year, battery, proximity, type, status, current_location)
VALUES 
  (1, 'Toyota', 'Camry', 2021, 80, 10, 'Sedan', 'Available', 'New York'),
  (2, 'Honda', 'Accord', 2019, 70, 5, 'Sedan', 'Available', 'San Francisco'),
  (3, 'Jeep', 'Cherokee', 2020, 90, 8, 'SUV', 'Available', 'Los Angeles'),
  (4, 'Ford', 'Fusion', 2018, 60, 20, 'Sedan', 'Charging', 'Miami');

-- Insert sample data into Reservation table
INSERT INTO Reservation (id, start_time, end_time, pickup_location, dropoff_location, vehicle_id, user_location, user_number)
VALUES
  (1, '2022-01-01 09:00:00', '2022-01-01 11:00:00', '123 Main St', 'New York', 1, '123 Main St', '1'),
  (2, '2022-02-01 10:00:00', '2022-02-01 12:00:00', '456 Elm St', 'San Francisco', 2, '456 Elm St', '1'),
  (3, '2022-03-01 11:00:00', '2022-03-01 13:00:00', '789 Oak St', 'Los Angeles', 3, '789 Oak St', '1'),
  (4, '2022-04-01 12:00:00', '2022-04-01 14:00:00', '321 Maple St', 'Miami', 4, '321 Maple St', '1');
