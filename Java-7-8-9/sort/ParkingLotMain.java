package com.sort;

import java.util.*;

class ParkingSpot {
    public int row;
    public int col;
    private boolean isOccupied;
    private String vehicleType; // "car" or "motorcycle"
    private String vehicleId;

    public ParkingSpot(int row, int col, String vehicleType) {
        this.row = row;
        this.col = col;
        this.isOccupied = false;
        this.vehicleType = vehicleType;
        this.vehicleId = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy(String vehicleId) {
        this.isOccupied = true;
        this.vehicleId = vehicleId;
    }

    public void vacate() {
        this.isOccupied = false;
        this.vehicleId = null;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String toString() {
        return "(" + row + ", " + col + ")";
    }

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
    
}

class ParkingLot {
    private ParkingSpot[][] grid;
    private PriorityQueue<ParkingSpot> carQueue;
    private PriorityQueue<ParkingSpot> motorcycleQueue;

    public ParkingLot(int numRows, int numCols) {
        grid = new ParkingSpot[numRows][numCols];
        carQueue = new PriorityQueue<>(Comparator.comparingInt(a -> Math.abs(a.row - numRows / 2) + Math.abs(a.col - numCols / 2)));
        motorcycleQueue = new PriorityQueue<>(Comparator.comparingInt(a -> Math.abs(a.row - numRows / 2) + Math.abs(a.col - numCols / 2)));

        // Initialize the grid with parking spots
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i < numRows / 2) {
                    grid[i][j] = new ParkingSpot(i, j, "car");
                    carQueue.offer(grid[i][j]);
                } else {
                    grid[i][j] = new ParkingSpot(i, j, "motorcycle");
                    motorcycleQueue.offer(grid[i][j]);
                }
            }
        }
    }

    public String parkVehicle(String vehicleType, String vehicleId) {
        PriorityQueue<ParkingSpot> parkingQueue = (vehicleType.equals("car")) ? carQueue : motorcycleQueue;

        if (!parkingQueue.isEmpty()) {
            ParkingSpot spot = parkingQueue.poll();
            spot.occupy(vehicleId);
            return "Parked at " + spot.toString();
        } else {
            return "No available parking spots for " + vehicleType + "s";
        }
    }

    public String leaveParkingSpot(String vehicleType, String vehicleId) {
        for (ParkingSpot[] row : grid) {
            for (ParkingSpot spot : row) {
                if (spot.isOccupied() && spot.getVehicleType().equals(vehicleType) && spot.getVehicleId().equals(vehicleId)) {
                    spot.vacate();
                    PriorityQueue<ParkingSpot> parkingQueue = (vehicleType.equals("car")) ? carQueue : motorcycleQueue;
                    parkingQueue.offer(spot);
                    return "Left parking spot " + spot.toString();
                }
            }
        }
        return "Vehicle not found in the parking lot.";
    }
}

public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10, 10);

        // Park vehicles
        System.out.println(parkingLot.parkVehicle("car", "CAR001"));
        System.out.println(parkingLot.parkVehicle("motorcycle", "MOTO001"));
        System.out.println(parkingLot.parkVehicle("car", "CAR002"));
        
        // Leave vehicles
        System.out.println(parkingLot.leaveParkingSpot("car", "CAR001"));
        System.out.println(parkingLot.leaveParkingSpot("motorcycle", "MOTO001"));
    }
}

