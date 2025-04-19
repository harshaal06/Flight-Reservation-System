import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;

public class WebServer {

    private static ReservationSystem reservationSystem = new ReservationSystem();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        port(4567);

        // Serve static files from frontend directory
        staticFiles.externalLocation("frontend");

        // Search flights endpoint
        get("/api/flights", (req, res) -> {
            String departure = req.queryParams("departure");
            String destination = req.queryParams("destination");
            if (departure == null || destination == null) {
                res.status(400);
                return gson.toJson(Map.of("error", "Missing departure or destination parameter"));
            }
            List<Flight> results = reservationSystem.searchFlights(departure, destination);
            res.type("application/json");
            return gson.toJson(results);
        });

        // Make reservation endpoint
        post("/api/reservations", (req, res) -> {
            Map<String, String> body = gson.fromJson(req.body(), Map.class);
            String flightNumber = body.get("flightNumber");
            if (flightNumber == null) {
                res.status(400);
                return gson.toJson(Map.of("error", "Missing flightNumber in request body"));
            }
            boolean success = reservationSystem.makeReservation(flightNumber);
            res.type("application/json");
            return gson.toJson(Map.of("success", success));
        });

        // Get all flights endpoint
        get("/api/flights/all", (req, res) -> {
            List<Flight> allFlights = reservationSystem.getAllFlights();
            res.type("application/json");
            return gson.toJson(allFlights);
        });
    }
}
