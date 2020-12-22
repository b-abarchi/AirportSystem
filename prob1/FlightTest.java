package prob1;

	public class FlightTest {
	
		public static void main(String[] args) {
			createFlightValidNumber();
			createFlightInvalidNumber();
		}
		public static void createFlightValidNumber() {
			System.out.println("createFlightValidNumber()");
			Airport airport2 = new Airport("CSG", 32.52 , 84.93, "Columbus" , "GA");
			Airport airport1 = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
			LocalDate date = new LocalDate("2020-11-27");
			Flight f3210 = new Flight("3210", date , airport1,airport2, 144.50);
			System.out.println(f3210);
		}
		
		public static void createFlightInvalidNumber() {
			System.out.println("createFlightInvalidNumber()");
			Airport airport2 = new Airport("CSG", 32.52 , 84.93, "Columbus" , "GA");
			Airport airport1 = new Airport("VLD", 30.78 , 83.28, "Valdosta" , "GA");
			LocalDate date = new LocalDate("2020-11-27");
			Flight f3210 = new Flight("310", date , airport1,airport2, 144.50);
			System.out.println(f3210);
			
		}
	}
