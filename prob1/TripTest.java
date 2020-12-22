package prob1;

import java.util.List;

public class TripTest {

	public static void main(String[] args) {
		addLegTestValid();
		getCostTest();// includes all other six tests
		ToStringTest();//
		addLegTestInvalid();
		
		
		
	}
	public static void addLegTestValid() {
		System.out.println("addLegTestValid()");
		Trip t = new Trip();
		LocalDate date = new LocalDate("2020-10-24");
		Airport vld = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
		Airport mco = new Airport("MC0", 28.43 , 81.32, "Orlando" , "FL");
		Airport atl = new Airport("ATL", 33.65 , 84.42, "Atlanta" , "GA");

		Flight f1 = new Flight("4521", date, vld, atl, 100.50);
		Flight f2 = new Flight("0145", date, mco, vld, 100.50);
		

		t.addLeg(f2);
		t.addLeg(f1);

		System.out.println(t);
	}
	public static void addLegTestInvalid() {
		System.err.println("addLegTestInvalid()");

		Trip t = new Trip();
		LocalDate date = new LocalDate("2020-10-24");
		Airport vld = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
		Airport mco = new Airport("MC0", 28.43 , 81.32, "Orlando" , "FL");
		Airport atl = new Airport("ATL", 33.65 , 84.42, "Atlanta" , "GA");

		Flight f1 = new Flight("4521", date, vld, atl, 100.50);
		Flight f2 = new Flight("0145", date, mco, vld, 100.50);
		Flight f3 = new Flight("4145", date, mco, atl, 100.50);

		t.addLeg(f2);
		t.addLeg(f1);
		t.addLeg(f3);
		System.err.println(t);
	}
	
	
	public static void getCostTest() {
		System.out.println("\ngetCostTest()");

		Trip t = new Trip();
		LocalDate date = new LocalDate("2020-10-24");
		Airport vld = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
		Airport mco = new Airport("MC0", 28.43 , 81.32, "Orlando" , "FL");
		Airport atl = new Airport("ATL", 33.65 , 84.42, "Atlanta" , "GA");

		Flight f1 = new Flight("4521", date, vld, atl, 100.50);
		Flight f2 = new Flight("0145", date, mco, vld, 100.50);
	

		t.addLeg(f2);
		t.addLeg(f1);
	
		double total = t.getCost();
		System.out.println("$"+total);
		
		System.out.println("\ngetOriginTest()");
		Airport origin = t.getOrigin();
		System.out.println(origin);
		
		System.out.println("\ngetDestinationTest()");
		Airport destination = t.getDestination();
		System.out.println(destination);
		
		System.out.println("\ngetDistanceTest()");
		double distance = t.getDistance();
		System.out.println(distance);
		
		System.out.println("\ngetNumLegsTest()");
		int legs = t.getNumLegs();
		System.out.println("there is: " + legs + " legs");
		
		System.out.println("\ngetDateTest()");	
		LocalDate date1 = t.getDate();
		System.out.println(date1);
	}
	public static void ToStringTest() {
		System.out.println("\nToStringTest()");

		Trip t = new Trip();
		LocalDate date = new LocalDate("2020-10-24");
		Airport vld = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
		Airport mco = new Airport("MC0", 28.43 , 81.32, "Orlando" , "FL");
		Airport atl = new Airport("ATL", 33.65 , 84.42, "Atlanta" , "GA");

		Flight f1 = new Flight("4521", date, vld, atl, 100.50);
		Flight f2 = new Flight("0145", date, mco, vld, 100.50);
	

		t.addLeg(f2);
		t.addLeg(f1);
		System.out.println(t);}
}
