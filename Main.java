import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFlight Reservation System");
            System.out.println("1. Search Flights");
            System.out.println("2. Make Reservation");
            System.out.println("3. View All Flights");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Please enter a valid number (1-4)");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter departure city: ");
                    String departure = scanner.nextLine();
                    System.out.print("Enter destination city: ");
                    String destination = scanner.nextLine();
                    
                    List<Flight> results = system.searchFlights(departure, destination);
                    if (results.isEmpty()) {
                        System.out.println("No flights found for the given route.");
                    } else {
                        System.out.println("\nAvailable Flights:");
                        for (Flight flight : results) {
                            System.out.println(flight);
                            System.out.println("-------------------");
                        }
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter flight number to book: ");
                    String flightNumber = scanner.nextLine();
                    if (system.makeReservation(flightNumber)) {
                        System.out.println("Reservation successful!");
                    } else {
                        System.out.println("Reservation failed. Flight may be full or doesn't exist.");
                    }
                    break;
                    
                case 3:
                    List<Flight> allFlights = system.getAllFlights();
                    System.out.println("\nAll Available Flights:");
                    for (Flight flight : allFlights) {
                        System.out.println(flight);
                        System.out.println("-------------------");
                    }
                    break;
                    
                case 4:
                    System.out.println("Thank you for using the Flight Reservation System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
