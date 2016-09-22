
public class Motorbike implements Vehicle{
	
	String licensePlate;
	
	public Motorbike(String licensePlate) {
		
		this.licensePlate = licensePlate;
	}

	@Override
	public String getLicensePlate() {
		// TODO Auto-generated method stub
		return this.licensePlate;
	}

}
