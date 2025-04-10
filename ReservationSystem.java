import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private List<Flight> flights;

    public ReservationSystem() {
        this.flights = new ArrayList<>();
        initializeFlights();
    }

    private void initializeFlights() {
        // Nagpur routes
        flights.add(new Flight("NM10", "Nagpur", "Mumbai", 
                             "10:00 AM", "01:00 PM", 50, 499.99));
        flights.add(new Flight("NP11", "Nagpur", "Pune", 
                             "11:00 PM", "1:30 AM", 150, 399.99));
        flights.add(new Flight("ND09", "Nagpur", "Delhi", 
                             "9:00 AM", "2:00 PM", 100, 899.99));
        
        // Mumbai routes
        flights.add(new Flight("MD12", "Mumbai", "Delhi", 
                             "7:00 AM", "9:30 AM", 120, 599.99));
        flights.add(new Flight("MC14", "Mumbai", "Chennai", 
                             "5:00 PM", "7:00 PM", 90, 499.99));
        
        // Delhi routes
        flights.add(new Flight("DM15", "Delhi", "Mumbai", 
                             "8:00 AM", "10:30 AM", 110, 599.99));
        flights.add(new Flight("DN17", "Delhi", "Nagpur", 
                             "3:00 PM", "5:00 PM", 100, 549.99));
        
        // International flights
        flights.add(new Flight("ID20", "Delhi", "Dubai", 
                             "8:00 PM", "10:30 PM", 200, 1299.99));
        flights.add(new Flight("MS21", "Mumbai", "Singapore", 
                             "1:00 AM", "7:30 AM", 150, 1499.99));
    }

    public List<Flight> searchFlights(String departure, String destination) {
        List<Flight> results = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equalsIgnoreCase(departure) && 
                flight.getDestination().equalsIgnoreCase(destination) &&
                flight.getAvailableSeats() > 0) {
                results.add(flight);
            }
        }
        return results;
    }

    public boolean makeReservation(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber) && 
                flight.getAvailableSeats() > 0) {
                flight.setAvailableSeats(flight.getAvailableSeats() - 1);
                return true;
            }
        }
        return false;
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }
}
