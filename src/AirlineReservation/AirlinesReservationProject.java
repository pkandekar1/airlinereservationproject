package AirlineReservation;
import java.util.*;



public class AirlinesReservationProject {
	private static List<Airline> airlines = new ArrayList<>();
	private static List<Flight> flights = new ArrayList<>();
	private static List<Passenger> passengers = new ArrayList<>();
	private static List<Reservation> reservations = new ArrayList<>();
	private static int flightCounter = 1;
	private static int passengerCounter = 1;
	private static int reservationCounter = 1;
	
	public static void main(String[] args) {
		initializeAirlines();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			displayMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			
	       switch(choice) {
	       case 1:
	    	   addFlight(sc);
	    	   break;
	       case 2:
	    	   addPassenger(sc);
	    	   break;
	       case 3:
               addReservation(sc);
               break;
           case 4:
               confirmReservation(sc);
               break;
           case 5:
               displayReservations();
               break;
		   case 6:
			   deleteFlight(sc);
			   break;
           case 7:
               System.out.println("Log Out");
               sc.close();
               System.exit(0);
			   break;
           default:
               System.out.println("Invalid choice. Please select again.");
	       
	       }
		}	
	}
	private static void initializeAirlines() {
		Airline airline1 = new Airline("Air India");
		airline1.addDestination("Pune");
		airline1.addDestination("Chennai");
		airline1.addDestination("Amritsar");
		
		Airline airline2 = new Airline("SpiceJet");
		airline2.addDestination("Mumbai");
		airline2.addDestination("Kolkata");
		airline2.addDestination("Banglore");
		
		airlines.add(airline1);
		airlines.add(airline2);
	}
	private static void displayMenu() {
		 System.out.println("Airline Reservation System");
	        System.out.println("1. Add Flight(Air India or SpiceJet)");
	        System.out.println("2. Add Passenger");
	        System.out.println("3. Make Reservation");
	        System.out.println("4. Confirm Reservation");
	        System.out.println("5. Display Reservations");
			System.out.println("6. Delete Flight");
	        System.out.println("7. Exit");
	        System.out.print("Select an option: ");
	}
	private static void addFlight(Scanner sc) {
		System.out.print("Enter Airline Name");
		String airlineName = sc.nextLine();
		System.out.print("Enter Origin: ");
		String origin = sc.nextLine();
		
		Airline selectedAirline = null;
		for(Airline airline : airlines) {
			if(airline.getName().equalsIgnoreCase(airlineName)) {
				selectedAirline = airline;
				break;
			}
		}
		if(selectedAirline == null) {
			selectedAirline = new Airline(airlineName);
			airlines.add(selectedAirline);
		}
		
		Flight selectedflight = new Flight(flightCounter++, selectedAirline.getName(),origin,null);
		flights.add(selectedflight);
		
		System.out.println("Available Destination for "+selectedAirline.getName()+":");
		List<String> destinations = selectedAirline.getDestinations();
		for(int i=0; i< destinations.size();i++) {
			System.out.println((i+1)+ "."+ destinations.get(i));
		}
		System.out.print("Select destination (enter Number):");
		int destinationChoice = sc.nextInt();
		sc.nextLine();
		
		if(destinationChoice >= 1 && destinationChoice <= destinations.size()) {
			String destination = destinations.get(destinationChoice - 1);
			selectedflight.setDestination(destination);
			System.out.println("Flight added Successfully.");
		}else {
			System.out.println("Invalid destination choice.Fligth not added.");
		}
	}
	
	private static void addPassenger(Scanner sc) {
		System.out.println("Enter Passenger Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Passenger Email: ");
		String email = sc.nextLine();
		
		Passenger selectedpassenger = new Passenger(passengerCounter++,name,email);
		passengers.add(selectedpassenger);
		System.out.println("Passenger added Successfully. ");
	}
	
	private static void addReservation(Scanner sc) {
		if(flights.isEmpty()|| passengers.isEmpty()) {
			System.out.println("No flight or passenger available. Add flights and passengers");
			return;
		}
		System.out.println("Available Flights: ");
		for(Flight flight: flights) {
			System.out.println("Flight "+ flight.getFlightNumber()+ ": "+flight.getAirline()
			+ " from "+ flight.getOrigin()+" to "+flight.getDestination());
		}
		System.out.println("Enter flight Number: ");
		int flightNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Avilable Passengers: ");
		for(Passenger passenger : passengers) {
			System.out.println("Passenger "+passenger.getPassengerId()+ " : "+passenger.getName());
		}
		System.out.print("Enter Passenger ID: ");
		int passengerId = sc.nextInt();
		sc.nextLine();
		
		Flight selectedFlight = null;
		for(Flight flight : flights) {
			if(flight.getFlightNumber() == flightNumber) {
				selectedFlight = flight;
				break;
			}
		}
		Passenger selectedPassenger = null;
		for(Passenger passenger: passengers) {
			if(passenger.getPassengerId() == passengerId) {
				selectedPassenger = passenger;
				break;
			}
		}
		if(selectedFlight != null && selectedPassenger != null) {
			Reservation reservation = new Reservation(reservationCounter++, selectedFlight, selectedPassenger);
			reservations.add(reservation);
			System.out.println("Reservation made successfully");
		}else {
			System.out.println("Invalid Flight Number of Passenger Id");
		}
	}
	 
	private static void confirmReservation(Scanner sc) {
		System.out.println("Enter Reservation Id to confirm: ");
		int reservationId = sc.nextInt();
		
		for(Reservation reservation : reservations) {
			if(reservation.getReservationId()== reservationId) {
				reservation.confirmedReservation();
				System.out.println("Reservation Confirmed");
				return;
			}
		}
		System.out.println("Reservation not found");
	}
	
	public static void displayReservations(){
		if(reservations.isEmpty()) {
			System.out.println("No reservation available");
			return;
		}
		
		System.out.println("All Reservation");
		for(Reservation reservation : reservations) {
			System.out.println("Reservation ID: "+ reservation.getReservationId());
			System.out.println("Flight: "+reservation.getFlight().getAirline()+
					" ("+reservation.getFlight().getFlightNumber()+")");
			System.out.println("Passenger: "+reservation.getPassenger().getName());
			System.out.println("Confirmed: "+(reservation.isConfirmed()?"Yes":"No"));
			System.out.println();
		}
	}

	public static void deleteFlight(Scanner sc) {
		System.out.print("Enter the flight number to delete: ");
		int flightNumberToDelete = sc.nextInt();
		sc.nextLine();  
	
		Flight flightToDelete = null;
		for (Flight flight : flights) {
			if (flight.getFlightNumber() == flightNumberToDelete) {
				flightToDelete = flight;
				break;
			}
		}
	
		if (flightToDelete != null) {
			flights.remove(flightToDelete);
			System.out.println("Flight " + flightNumberToDelete + " has been deleted.");
		} else {
			System.out.println("Flight not found. No flights were deleted.");
		}
	}

}
