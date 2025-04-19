public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int availableSeats;
    private double price;

    public Flight(String flightNumber, String departure, String destination, 
                 String departureTime, String arrivalTime, int availableSeats, double price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    // Getters and setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + ": " + departure + " -> " + destination + 
               " (" + departureTime + "-" + arrivalTime + ")\n" +
               "Available Seats: " + availableSeats + " | Price: Rs. " + price;
    }
}
