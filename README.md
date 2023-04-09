# Autonomous Vehicle Reservation System

- User requests new reservation, we promise **ATP** (Availability to Promise)

## Current functionality
- **[Complete]** User can query the vehicles by start time and end time, system will return a list from database
- **[Complete]** User can request to filter the vehicles based on proximity and vehicle type
- **[Building]** System can update new reservation to AWS RDS Database 

## Build Design
- Java Classes (OOD)
  - Reservation Class
  - Vehicle Class
  - Vehicle Database Class
  - Vehicle Reservation System (Main)
  - Vehicle Search Class
- Relational Databse
  - AWS RDS & Using Microsoft SQL Database Engine
    ![2023-04-09 下午6.20.51.png](https://s2.loli.net/2023/04/10/j3cybXZ8WK4sioV.png)
  - Client Side: Azure Data Studio
    ![2023-04-09 下午6.22.31.png](https://s2.loli.net/2023/04/10/vuUZCeotbMRDgW4.png)

## User Query Demo
```
The list of vehicles filtered by start and end time - Test: Vehicle 2,3,4 should return
---------------------------------------------------------------------------------------
Vehicle ID: 2
Vehicle State: Available
Vehicle Type: Sedan
Current Location: San Francisco
Proximity: 5.0
Battery Life: 70

Vehicle ID: 3
Vehicle State: Available
Vehicle Type: SUV
Current Location: Los Angeles
Proximity: 8.0
Battery Life: 90

Vehicle ID: 4
Vehicle State: Charging
Vehicle Type: Sedan
Current Location: Miami
Proximity: 20.0
Battery Life: 60

The list of vehicles filtered further by type and proximity - Test: Vehicle 2 should return
---------------------------------------------------------------------------------------
Sorted and filtered list of available vehicles:
Vehicle ID: 2
Vehicle State: Available
Vehicle Type: Sedan
Current Location: San Francisco
Proximity: 5.0
Battery Life: 70
```
