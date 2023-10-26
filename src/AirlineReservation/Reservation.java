package AirlineReservation;

public class Reservation {
	private int reservationId;
	private Flight flight;
	private Passenger passenger;
	private boolean confirmed;
	
	public Reservation(int reservationId, Flight selectedflight, Passenger selectedpassenger) {
		this.reservationId = reservationId;
		this.flight = selectedflight;
		this.passenger = selectedpassenger;
		this.confirmed = false;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	public Flight getFlight() {
		return flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void confirmedReservation() {
		this.confirmed = true;
	}
	
		
	}

