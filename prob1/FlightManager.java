package prob1;

import java.io.File;
import java.util.*;

public class FlightManager {
		private AirportManager airportManager;
		private Map<String,Flight> flights = new HashMap<>();
		public FlightManager(AirportManager airportManager) {
			super();
			this.airportManager = airportManager;
		}
		
		
		
		public boolean addFlight(Flight flight) {
			if(!flights.containsKey(flight.getNumber())) {
				flights.put(flight.getNumber(), flight);
				return true;
			}
		return false;}
		public boolean addFlight(String number, LocalDate date,  String origin,  String destination, double cost){
			if (airportManager.getAirport(origin)!=null && airportManager.getAirport(destination)!=null) {
				Airport a1 = airportManager.getAirport(origin);
				Airport a2 = airportManager.getAirport(destination);
				Flight f = new Flight(number, date, a1, a2, cost);
			if(addFlight(f)) {
				return true;
			}}
		return false;}
		public Flight getFlight(String number) {

			if(flights.containsKey(number)) {
				return flights.get(number);
			}
		return null;}
		public List<Flight> getFlightsByOrigin(String originCode){
			List<Flight> returned = new ArrayList<>();
			
				for(Flight f: flights.values()) {
					if(f.getOrigin().getCode().equals(originCode)){
						returned.add(f);
					}
				}
			
		return returned;}
		public List<Flight> getFlightsByOrigin(String originCode, String date){
			List<Flight> returned = new ArrayList<>();
			LocalDate targetDate = new LocalDate(date);
				for(Flight f: flights.values()) {
					if((f.getOrigin().getCode().equals(originCode)) && (f.getDate().equals(targetDate))){
						returned.add(f);
					}
				}
			
		return returned;}
		public List<Flight> getFlightsByOrigin(String originCode, String destinationCode, String date){
			List<Flight> returned = new ArrayList<>();
			LocalDate targetDate = new LocalDate(date);
				for(Flight f: flights.values()) {
					if((f.getOrigin().getCode().equals(originCode)) && (f.getDate().equals(targetDate)) && (f.getDestination().getCode().equals(destinationCode))){
						returned.add(f);
					}
				}
			
		return returned;}
		public int getnumFlights() {
			return flights.size();
		}
		public Flight removeFlight(String number) {
			
			if(flights.containsKey(number)) {
				return flights.remove(number);
			}
		return null;}
		public List<Trip> getTripsByOriginAndDestination(String originCode, String destinationCode,  String date){
			List<Trip> returnedTrips = new ArrayList();
			Trip t = new Trip();
			for(Flight f: flights.values()) {
				t.addLeg(f);
				
			}
			returnedTrips.add(t);
			return returnedTrips;
			
		}
		public List<Flight> AllFlights(){
			List<Flight> flightList = new ArrayList<>();
			for(Flight f: flights.values()) {
			flightList.add(f);}
		return flightList;}
	}
