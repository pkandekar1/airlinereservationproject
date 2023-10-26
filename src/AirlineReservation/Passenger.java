package AirlineReservation;

public class Passenger {
	private int passengerId;
	private String name;
	private String email;
	
	public Passenger (int passengerId, String name, String email) {
		this.passengerId = passengerId;
		this.name = name;
		this.email = email;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public String getName() {
		return name;
	}

}
