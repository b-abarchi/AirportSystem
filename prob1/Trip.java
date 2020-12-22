package prob1;

import java.util.*;

public class Trip {
		private List<Flight> legs = new ArrayList<>();
		public Trip() {}
		public Trip(List<Flight> legs) {
			this.legs=legs;
		}
		public void addLeg(Flight leg) {
			List<Flight> notLegs = new ArrayList<>();
				if(!legs.isEmpty()) {
					Flight preceding = legs.get(legs.size()-1);
						if(preceding.getDestination().equals(leg.getOrigin()) && preceding.getDate().equals(leg.getDate())) {
								legs.add(leg);}
						else {	
								notLegs.add(leg);	
												}
					
												}
				else {
					legs.add(leg);
				}
		}
		public double getCost() {
			double totalCost = 0;
			for(Flight f: legs) {
				totalCost+=f.getCost();
			}
		return totalCost;}
		
		
		public Airport getOrigin() {
			Airport origin = legs.get(0).getOrigin();
				return origin;}
		public Airport getDestination() {
			Airport destination = legs.get(legs.size()-1).getDestination();
				return destination;}
		
		public double getDistance() {
			double totalDistance = 0;
			for(Flight f: legs) {
				totalDistance+=f.getDistance();
			}
		return Math.round(totalDistance);}
		
		public int getNumLegs() {
			return legs.size();
		}
		public LocalDate getDate() {
			return legs.get(0).getDate();
		}
		@Override
		public String toString() {
			String msg = "";
			msg = "Trip Date: " + legs.get(0).getDate( )+
					"\n     From: " + getOrigin().getCode() + "-" + getOrigin().getCity() + ",  " + getOrigin().getState()+ 
					"\n       To: " + getDestination().getCode() + "-" + getDestination().getCity() + ",  " + getDestination().getState()+ 
					"\n Distance: " + getDistance() + " miles,  Cost: $" + getCost()+ "\n\n";
			for(int i = 0; i< legs.size(); i++) {
			msg +="Leg "+ (i+1) +": "+  legs.get(i) + "\n";}
			return msg;
		}
	}
