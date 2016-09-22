import java.util.ArrayList;

public class Parking {
	
	int filledParking = 0;
	int parkingAmount;
	ArrayList<Vehicle> vehiclesParked;
	
	public Parking(int parkingAmount) {
		
		this.parkingAmount = parkingAmount;
		vehiclesParked = new ArrayList<Vehicle>();
	}
	
	public void setAdditionalParking(int newParkingAmount) {
		
		this.parkingAmount = newParkingAmount + this.parkingAmount;
	}
	
	public boolean addVehicle(Vehicle v) {
		
		if (filledParking != parkingAmount) {
			
			filledParking ++;
			vehiclesParked.add(v);
			return true;
		}else {
			
			return false;
		}
	}
	
	public boolean removeVehicle (Vehicle v) {
		
		if (filledParking != 0) {
			
			filledParking --;
			vehiclesParked.remove(v);
			return true;
		}else {
			
			return false;
		}
	}
	
	public boolean containVehicle(Vehicle v) {
		
		return vehiclesParked.contains(v);
	}
	
	public int getVehicleLocation (Vehicle v) {
		
		if (containVehicle(v)) {
			
			return vehiclesParked.indexOf(v);
		}else {
			
			return -1;
		}
	}
 
}
