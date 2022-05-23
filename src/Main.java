import airportManager.services.AirportService;

public class Main {
    public static void main(String[] args) {
        AirportService airportService = new AirportService("TestAirport");
        airportService.flightService.addNewFlight();
        airportService.flightService.printAllFlights();
//        System.out.println(airportService.flightService.findFlightById(1).toString()); #commented because it
//        generates error if flight id 1 doesn't exist

        airportService.restaurantService.addNewRestaurant();
        airportService.restaurantService.printAllRestaurants();

        airportService.ticketService.addNewTicket();
        airportService.ticketService.printAllTickets();

        airportService.employeeService.addNewEmployee();
        airportService.employeeService.printAllEmployees();

        airportService.personService.printRegisteredPersons();
    }
}
