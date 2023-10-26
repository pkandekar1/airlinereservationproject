package AirlineReservation;
import java.util.*;

public class Airline {
	private String name;
	private List<String>destinations;
	
	public Airline(String name) {
		this.name = name;
		this.destinations = new ArrayList<>();
	}
	public void addDestination(String destination) {
		destinations.add(destination);
		
	}
	public List<String> getDestinations(){
		return destinations;
	}
	public String getName() {
		return name;
	}

}
