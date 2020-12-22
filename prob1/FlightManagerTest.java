package prob1;

import java.io.File;
import java.util.List;
import java.util.Map;

public class FlightManagerTest {
	static final String path = "src/";
	static final String airportsSmallFileName = path + "airportsSmall.txt";
	static final String airportsMediumFileName = path + "airportsMedium.txt";

	static final String airportsSameCitiesFileName = path + "airportsSameCities.txt";
	static final String airportsAllFileName = path + "airports.txt";
	static final File airportsSmallFile = new File(airportsSmallFileName);
	static final File airportsMediumFile = new File(airportsMediumFileName);
	static final File airportsSameCitiesFile = new File(airportsSameCitiesFileName);
	static final File airportsAllFile = new File(airportsAllFileName);
	
	static Airport airport2 = new Airport("CSG", 32.52 , 84.93, "Columbus" , "GA");
	static Airport airport1 = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
	static Airport airport3 = new Airport("MC0", 28.43 , 81.32, "Orlando" , "FL");
	static Airport airport4 = new Airport("ANB", 33.58 , 85.85, "Anniston" , "AL");
	static LocalDate date = new LocalDate("2020-11-27");
		public static void main(String[] args) {
			addFlightTest();
     		addFlightTest2();
			getFlightValid();
			getFlightInvalid();
			getFlightsByOriginTest();
			getFlightsByOriginTest2();
			getFlightsByOriginAndDestinationTest();
			getNumFlights();
			removeFlightTest();
			getTripsByOriginAndDestinationTest();
		}
		public static void addFlightTest() {
			System.out.println("addFlightTest()");
			Airport airport2 = new Airport("CSG", 32.52 , 84.93, "Columbus" , "GA");
		    Airport airport1 = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			Flight f3210 = new Flight("3210", date , airport1,airport2, 144.50);
			boolean t = manager.addFlight(f3210);
			//ADD the same flight should return false
			boolean f = manager.addFlight(f3210);
			System.out.println(f3210);
			System.err.println(t + ", Added\n");
			System.out.println(f3210);
			System.err.println(f + ", already exist");
			
		}
		public static void addFlightTest2() {
			System.out.println("\naddFlightTest2()");
		    AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			boolean t = manager.addFlight("1245", date , "VLD", "MIA", 244.50);
			System.err.println(t + ", Added");
		}
		public static void getFlightValid() {
			System.out.println("\ngetFlightValid()");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			Airport airport2 = new Airport("CSG", 32.52 , 84.93, "Columbus" , "GA");
		    Airport airport1 = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
		    FlightManager manager = new FlightManager(m);
			Flight f3210 = new Flight("3210", date , airport1,airport2, 144.50);
			boolean t = manager.addFlight(f3210);
			Flight f = manager.getFlight("3210");
			System.out.println(f);
		}
		public static void getFlightInvalid() {
			System.out.println("\ngetFlightInvalid()");
		    AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
		    Airport airport2 = new Airport("CSG", 32.52 , 84.93, "Columbus" , "GA");
		    Airport airport1 = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
			FlightManager manager = new FlightManager(m);
			Flight f3210 = new Flight("3210", date , airport1,airport2, 144.50);
			boolean t = manager.addFlight(f3210);
			Flight f = manager.getFlight("320");
			System.out.println(f);
		}
		public static void getFlightsByOriginTest() {
			System.out.println("\ngetFlightsByOriginTest()");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			manager.addFlight("3210", date , "MCO", "CSG", 144.50);
			manager.addFlight("7541", date ,"MCO", "VLD", 112.00);
			manager.addFlight("0014", date ,"CSG", "ANB", 94.99);
			List <Flight> f = manager.getFlightsByOrigin("MCO");
			System.out.println(f);
		}
		public static void getFlightsByOriginTest2() {
			System.out.println("\ngetFlightsByOriginTest2()");
			LocalDate date2 = new LocalDate("2020-10-24");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			manager.addFlight("3210", date , "MCO", "CSG", 144.50);
			manager.addFlight("7541", date2 ,"MCO", "VLD", 112.00);
			manager.addFlight("0014", date ,"CSG", "ANB", 94.99);
			List <Flight> f = manager.getFlightsByOrigin("MCO", "2020-10-24");
			System.out.println(f);
		} 
		public static void getFlightsByOriginAndDestinationTest() {
			System.out.println("\ngetFlightsByOriginAndDestinationTest()");
			LocalDate date2 = new LocalDate("2020-10-24");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			manager.addFlight("3210", date , "MCO", "CSG", 144.50);
			manager.addFlight("7541", date2 ,"MCO", "VLD", 112.00);
			manager.addFlight("7814", date ,"CSG", "ANB", 64.99);
			manager.addFlight("0115", date2 ,"ATL", "MCO", 194.99);
			manager.addFlight("6514", date ,"CSG", "SEM", 100.99);
			List <Flight> f = manager.getFlightsByOrigin("ATL","MCO" ,"2020-10-24");
			System.out.println(f);
		} 
		public static void getNumFlights() {
			System.out.println("\ngetNumFlights()");
			LocalDate date2 = new LocalDate("2020-10-24");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			manager.addFlight("3210", date , "MCO", "CSG", 144.50);
			manager.addFlight("7541", date2 ,"MCO", "VLD", 112.00);
			manager.addFlight("7814", date ,"CSG", "ANB", 64.99);
			manager.addFlight("0115", date2 ,"ATL", "MCO", 194.99);
			manager.addFlight("6514", date ,"CSG", "SEM", 100.99);
			manager.addFlight("0514", date ,"TCL", "GNV", 100.99);
			manager.addFlight("5114", date ,"MOB", "CSG", 100.99);
			manager.addFlight("4114", date ,"MCO", "FLL", 100.99);
			int n = manager.getnumFlights();
			System.out.println("there are "+ n + " flights");
		} 
		public static void removeFlightTest() {
			System.out.println("\nremoveFlightTest()");
			LocalDate date2 = new LocalDate("2020-10-24");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			manager.addFlight("3210", date , "MCO", "CSG", 144.50);
			manager.addFlight("7541", date2 ,"MCO", "VLD", 112.00);
			manager.addFlight("7814", date ,"CSG", "ANB", 64.99);
			manager.addFlight("0115", date2 ,"ATL", "MCO", 194.99);
			manager.addFlight("6514", date ,"CSG", "SEM", 100.99);
			System.out.println("before removeFlight()-------> " + manager.getnumFlights());
			Flight f = manager.removeFlight("7541");
			System.out.println(f);
			System.out.println("after removeFlight()-------> " + manager.getnumFlights());		
			
		} 
		public static void getTripsByOriginAndDestinationTest() {
			System.out.println("\ngetTripsByOriginAndDestinationTest()");
			LocalDate date2 = new LocalDate("2020-10-24");
			AirportManager m = AirportManagerTest.getAirportManager(airportsMediumFile);
			FlightManager manager = new FlightManager(m);
			manager.addFlight("3210", date , "MCO", "ATL", 144.50);
			manager.addFlight("7541", date2 ,"MCO", "VLD", 112.00);
			manager.addFlight("7814", date ,"CSG", "ANB", 64.99);
			manager.addFlight("0115", date2 ,"ATL", "MCO", 194.99);
			manager.addFlight("6514", date ,"ANB", "MCO", 100.99);
			manager.addFlight("0514", date ,"TCL", "GNV", 100.99);
			manager.addFlight("5114", date ,"MOB", "CSG", 100.99);
			manager.addFlight("4114", date2 ,"VLD", "ATL", 100.99);
			List<Trip> n = manager.getTripsByOriginAndDestination("MCO", "ATL", "2020-10-24");
			System.out.println(n);
		} 
 
	}

