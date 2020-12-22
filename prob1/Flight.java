package prob1;

	public class Flight {
		private double cost;
		private LocalDate date;
		private Airport destination;
		private double distance;
		private String number;
		private Airport origin;
		
		public Flight(String number, LocalDate date, Airport origin, Airport destination, double cost) {
			super();
			try{
				if(!isFlightNumberValid(number)) {
					throw new IllegalArgumentException();}
				
			this.number = number;
			this.date = date;
			this.origin = origin;
			this.destination = destination;
			this.cost = cost;}
			catch(IllegalArgumentException e){
				throw new IllegalArgumentException("flight number is invalid");
			}
		}
		public double getCost() {
			return cost;
		}
		public LocalDate getDate() {
			return date;
		}
		public Airport getDestination() {
			return destination;
		}
		public double getDistance() {
			double distance;
			DistanceCalculator calculator = new DistanceCalculator();
			distance = calculator.getDistance(origin.getLatitude(), origin.getLongitude(), destination.getLatitude(), destination.getLongitude());
		
			return distance;
		}
		public String getNumber() {
			return number;
		}
		public Airport getOrigin() {
			return origin;
		}
		public boolean isFlightNumberValid(String number) {
			if(number.length()!=4) {return false;}
			 for (char c : number.toCharArray())
			    {
			        if (!Character.isDigit(c)) return false;
			    
			   } return true;
		}
		
		@Override
		public String toString() {
			return "\n  Flight: " + number + ",  Date: " + date + 
					"\n    From: " + origin.getCode() + "-" + origin.getCity() + ",  " + origin.getState()+ 
					"\n      To: " + destination.getCode() + "-" + destination.getCity() + ",  " + destination.getState()+ 
					"\nDistance: " + Math.round(this.getDistance()) + " miles,  Cost: $" + cost + "\n";
		}
		
	}
