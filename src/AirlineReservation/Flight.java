package AirlineReservation;

public class Flight {
	private int flightNumber;
	private String airline;
	private String origin;
	private String destination;
	
	public Flight(int fligthNumber, String airline, String origin, String destination) {
		this.flightNumber = fligthNumber;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public String getOrigin() {
		return origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void add(Flight flight) {
		
		
	}
	

}
