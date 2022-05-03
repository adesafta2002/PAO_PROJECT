import airportManager.Flight;
import airportManager.airportService.AirportService;

public class Main {
    public static void main(String[] args) {
        AirportService airportService = new AirportService("TestAirport");
        airportService.addNewFlight();
        airportService.printAllFlights();
        System.out.println(airportService.findFlightById(1).toString());

        airportService.addNewRestaurant();
        airportService.printAllRestaurants();

        airportService.addNewTicket();
        airportService.printAllTickets();

        airportService.addNewEmployee();
        airportService.printAllEmployees();

        airportService.printRegisteredPersons();
    }
}
