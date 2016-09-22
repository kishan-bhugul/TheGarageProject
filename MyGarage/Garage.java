//Author: Kishan Bhugul
//Version: 1.0

import java.util.ArrayList;

public class Garage {

	int levelAmount;
	ArrayList<Parking> floorParking;
	
	public Garage(int parkingAmount) {
		
		floorParking = new ArrayList<Parking>();
		
		this.levelAmount = 0;
		floorParking.add(new Parking(parkingAmount));
	}
	
	public int getLevelAmount() {
		
		return this.levelAmount;
	}
	
	public void increaseParking(int level, int newParkingAmount) {
		
		if (level > this.levelAmount) {
			
			return;
		}else {
			
			floorParking.get(level).setAdditionalParking(newParkingAmount);
		}
	}
	
	public int getFreeParkingAmount() {
		
		int floorCount = 0;
		int freeParking=0;
		
		while (floorCount <= this.levelAmount) {
			
			int parkingAmount = floorParking.get(floorCount).parkingAmount;
			Parking parking = floorParking.get(floorCount);
			
			freeParking = freeParking + (parkingAmount - parking.filledParking);
			
			floorCount++;
			
		}

		return freeParking;
	}
	
	public void addFloor(int parkingAmount) {
		
		levelAmount ++;
		floorParking.add(new Parking(parkingAmount));
	}
	
	public int[] getVehicleLocation(Vehicle v) {
		
		int count = 0;
		int location;
		
		while (count <= this.levelAmount) {
			
			location = floorParking.get(count).getVehicleLocation(v);
			
			if (location != -1) {
				
				return new int[] {count, location};
			}
			
			count ++;
		}
		
		return new int[] {-1, -1};		
	}
	
	public boolean addVehicle(Vehicle v) {
		
		int count = 0;
		while (count <= this.levelAmount) {
			
			if (floorParking.get(count).addVehicle(v)){
				
				return true;
			}
			
			count ++;
			
		}
		
		return false;
	}
	
	public boolean removeVehicle(Vehicle v) {
		
		int count = 0;
		while (count <= this.levelAmount) {
			
			if (floorParking.get(count).removeVehicle(v)) {
				
				return true;
			}
			
			count ++;
		
		}
		return false;
	}
	
	public boolean isVehicleInGarage(Vehicle v) {
		
		int count = 0;
		int location;
		
		while (count <= this.levelAmount) {
			
			location = floorParking.get(count).getVehicleLocation(v);
			
			if (location != -1) {
				
				return true;
			}
			
			count ++;
		}
		
		return false;
	}
	
}
	
	
