//Author: Kishan Bhugul
//Version 1.0

public class Car implements Vehicle{
	
	String licensePlate;
	
	public Car(String licensePlate) {
		
		this.licensePlate = licensePlate;
	}

	@Override
	public String getLicensePlate() {
		// TODO Auto-generated method stub
		return this.licensePlate;
	}

}
