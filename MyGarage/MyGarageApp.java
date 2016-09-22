//Author: Kishan Bhugul
//Version: 1.0

import java.util.ArrayList;
import java.util.Scanner;

public class MyGarageApp {
	
	static ArrayList<Vehicle> VehicleList = new ArrayList<Vehicle>();
	static Scanner reader = new Scanner(System.in);
	static Garage garage = new Garage(20); //change value here to change default parking lots

	public static void main(String[] args) {
		int anOption = 0;
		
		System.out.println("");
		System.out.println("Please note that by default there is one floor with 20 parkings");
		
		while(anOption != 8){
		
			mainMenu();
			anOption = reader.nextInt();
			
			switch(anOption) {
			
			case 1: createNewVehicle();
			break;
			
			case 2: addVehicleToGarage();
			break;
			
			case 3: removeVehicleFromGarage();
			break;
			
			case 4: getLocationofVehicle();
			break;
			
			case 5: getFreeParkingLots();
			break;
			
			case 6: addFloorToGarage();
			break;
			
			case 7: addParkingToFloor();
			break;
			
			case 8: System.out.println("Program exiting...");
			break;
			
			default: System.out.println("Invalid Input");
			break;
			}
		}

	}
	
	public static void mainMenu() {
		
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("1) Create a new vehicle");
		System.out.println("2) Add an existing vehicle to the garage");
		System.out.println("3) Remove a vehicle from the garage");
		System.out.println("4) Get the location of a vehicle");
		System.out.println("5) Display the number of free parking lots");
		System.out.println("6) Add a floor to the garage");
		System.out.println("7) Add additional parkings to a floor");
		System.out.println("8) Exit");
		System.out.println("****************************************************");
		System.out.println(" Please choose an option from the list above ");
		
		
	}
	
	public static void createNewVehicle() {
		
		System.out.println("Please Enter the License Plate of the Vehicle");
		String licensePlate = reader.next();
		
		int count = 0;
		
		while (count < VehicleList.size()) {
			
			if (VehicleList.get(count).getLicensePlate().equals(licensePlate)) {
				
				System.out.println("Sorry, License Plate already exists");
				return;
				
			}
			
			count ++;
		}
		
		System.out.println("Please Enter 1 for car and 2 for motorbike");
		int option = reader.nextInt();
		
		if (option < 1 || option > 2) { 
			
			System.out.println("Invalid input");
			return;
		}
		
		Vehicle v;
		
		if (option==1) {
			
			v = new Car(licensePlate);
			
		}else {
			
			v = new Motorbike(licensePlate);
		}
		
		
		
		VehicleList.add(v);
		System.out.println("The vehicle has been created");
	}
	
	public static void addVehicleToGarage() {
		
		System.out.println("Please Enter the License Plate of the Vehicle");
		String licensePlate = reader.next();
		
		if (!doesVehicleExist(licensePlate)) {
			
			System.out.println("Vehicle does not exist");
			return;
		}
		
		Vehicle v;
		
		v = getVehicleObject(licensePlate);
				
		if(garage.isVehicleInGarage(v)){
					
			System.out.println("The vehicle is already in garage");
			return;
		} else{
			
			if (garage.addVehicle(v)) {
				System.out.println("The vehicle has been added to Garage");
				
			}else {
				
				System.out.println("Not enought space to add a vehicle");
			}
		}

	}
	
	public static void removeVehicleFromGarage() {
		
		System.out.println("Please Enter the License Plate of the Vehicle");
		String licensePlate = reader.next();
		
		if (!doesVehicleExist(licensePlate)) {
			
			System.out.println("Vehicle does not exist");
			return;
		}
		
		Vehicle v;
		
		v = getVehicleObject(licensePlate);
				
		if(garage.isVehicleInGarage(v)){			
			garage.removeVehicle(v);
			System.out.println("The vehicle has been removed from garage");
			return;
		} else {
			System.out.println("The vehicle is not in the garage");

		}

	}
	
	public static void getLocationofVehicle() {
		
		System.out.println("Please Enter the License Plate of the Vehicle");
		String licensePlate = reader.next();
		
		if (!doesVehicleExist(licensePlate)) {
			
			System.out.println("Vehicle does not exist");
			return;
		}
		
		Vehicle v;
		
		v = getVehicleObject(licensePlate);
				
		if(garage.isVehicleInGarage(v)){			
			int location[] = garage.getVehicleLocation(v);
			int floor = location[0]+1;
			int position = location[1]+1;
			System.out.println("The vehicle is on floor "+floor+" and position "+position);
			return;
		} else {
			System.out.println("The vehicle is not in the garage");

		}

	}
	
	public static void addFloorToGarage() {
		System.out.println("Please specify the number of additional floors to add");
		int additionalFloor = reader.nextInt();
		
		int count = 0;
		
		while (count < additionalFloor) {
			
			int newLevelAmount = garage.levelAmount +1;
			
			System.out.println("Please specify the number of parkings for floor: "+newLevelAmount);
			int parkingAmount = reader.nextInt();
			
			garage.addFloor(parkingAmount);
			
			System.out.println("One Additional floor added with "+parkingAmount+" Parkings");
			
			count ++;
		}
		
	}
	
	public static void addParkingToFloor() {
		
		System.out.println("Please specify the floor you would like to add more parkings");
		int floor = reader.nextInt();
		int floorLevel = floor -1;
		
		if (floorLevel > garage.getLevelAmount()) {
			
			System.out.println("There is no such floor");
			return;
		}else {
			System.out.println("Please specify the number of new parkings");
			int newParkingAmount = reader.nextInt();
			garage.increaseParking(floorLevel, newParkingAmount);
			System.out.println("New set of parkings have been added.");
		}
		
		
	}
	
	public static void getFreeParkingLots() {
		
		int freeParkings = garage.getFreeParkingAmount();
		
		System.out.println("Number of Free Parkings = "+freeParkings);
	}
	
	public static Vehicle getVehicleObject(String licensePlate) {
		
		int count = 0;
		
		while (count < VehicleList.size()) {
			
			if(VehicleList.get(count).getLicensePlate().equals(licensePlate)) {
				
				return VehicleList.get(count);
			}
			
			count ++;
		}
		
		return null;
		
	}
	
	public static boolean doesVehicleExist(String licensePlate) {
		
		int count = 0;
		
		while (count < VehicleList.size()) {
			
			if(VehicleList.get(count).getLicensePlate().equals(licensePlate)) {
				
				return true;
			}
			
			count ++;
		}
		
		return false;
	}

}
