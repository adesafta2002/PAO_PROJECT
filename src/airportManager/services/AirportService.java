package airportManager.services;

import airportManager.model.*;

import java.util.*;

public class AirportService {
    public FlightService flightService;
    public RestaurantService restaurantService;
    public TicketService ticketService;
    public PersonService personService;
    public EmployeeService employeeService;
    private final String airportName;


    public AirportService(String airportName) {
        this.airportName = airportName;
        this.flightService = new FlightService(airportName);
        this.restaurantService = new RestaurantService(airportName);
        this.personService = new PersonService(airportName);
        this.ticketService = new TicketService(airportName, flightService, personService);
        this.employeeService = new EmployeeService(airportName, personService);
    }
}
