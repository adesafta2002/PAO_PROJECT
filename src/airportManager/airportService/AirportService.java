package airportManager.airportService;

import airportManager.*;

import java.util.*;

public class AirportService {
    private final String airportName;
    private final List<Flight> flights = new ArrayList<Flight>();
    private final List<Restaurant> restaurants = new ArrayList<Restaurant>();
    private final List<Ticket> tickets =  new ArrayList<Ticket>();
    private final Set<Person> persons =  new HashSet<Person>();
    private final List<Employee> employees =  new ArrayList<Employee>();

    public AirportService(String airportName) {
        this.airportName = airportName;
    }

    public void addNewFlight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new flight...");
        System.out.println("Total seats available: ");
        int seats = scanner.nextInt();
        System.out.println("Is flight private (true/false): ");
        boolean isFlightPrivate = scanner.nextBoolean();
        System.out.println("Fuel needed: ");
        float fuel = scanner.nextFloat();
        System.out.println("Flight ID (must be unique): ");
        int flightID = scanner.nextInt();
        int[] isFlightIdUnique = new int[1];
        flights.forEach((flight) -> {
            if(flight.getFlight_id() == flightID){
                isFlightIdUnique[0] = 1;
            }
        });
        if(isFlightIdUnique[0] == 1){
            System.out.println("A flight with this id already Exists");
            return;
        }
        System.out.println("Flight crew members number: ");
        int crewMembersNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Air company name: ");
        String companyName = scanner.nextLine();
        System.out.println("Crew members: ");
        List<String> crewMembers =  new ArrayList<String>();
        for(int i = 0; i < crewMembersNumber; i++){
            String crewMember = scanner.nextLine();
            crewMembers.add(crewMember);
        }
        Flight newFlight = new Flight(seats,isFlightPrivate,this.airportName,fuel,flightID,crewMembersNumber,companyName,crewMembers);
        this.flights.add(newFlight);
        Collections.sort(this.flights);
    }

    public void printAllFlights(){
        this.flights.forEach(flight ->{
            System.out.println(flight.toString());
        });
    }

    public Flight findFlightById(int id){
        for (Flight flight : this.flights) {
            if (flight.getFlight_id() == id) {
                return flight;
            }
        }
        return null;
    }

    public void addNewRestaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new restaurant...");

        System.out.println("Restaurant name: ");
        String restaurantName = scanner.nextLine();
        System.out.println("Restaurant specific: ");
        String specific = scanner.nextLine();
        System.out.println("Restaurant location: ");
        String location = scanner.nextLine();
        Restaurant restaurant = new Restaurant(restaurantName, specific, location);
        this.restaurants.add(restaurant);
    }

    public void printAllRestaurants() {
        this.restaurants.forEach(restaurant ->{
            System.out.println(restaurant.toString());
        });
    }

    public Person addNewPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new person...");
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Id: ");
        int id = scanner.nextInt();
        Person person = new Person(firstName,lastName,age,id);
        this.persons.add(person);
        return person;
    }

    public Person findPersonById(int id){
        for (Person person : this.persons) {
            if (person.getPerson_id() == id) {
                return person;
            }
        }
        return null;
    }

    public void printRegisteredPersons(){
        this.persons.forEach(person -> {
            System.out.println(person.toString());
        });
    }

    public void addNewTicket(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buying new Ticket...");
        System.out.println("Choose the ticket type: ");
        System.out.println("1-Economy Class-100EUR ");
        System.out.println("2-First Class-200EUR ");
        int ticketType = scanner.nextInt();
        System.out.println("Choose the flight from one of these, type only the flight id: ");
        this.printAllFlights();
        int flightId = scanner.nextInt();
        Flight flight = this.findFlightById(flightId);
        if(flight == null){
            System.out.println("Flight doesn't exist: ");
            return;
        }
        System.out.println("Baggage count: ");
        int baggageCount = scanner.nextInt();
        System.out.println("Is one way (true/false): ");
        boolean isOneway = scanner.nextBoolean();
        System.out.println("Seat number preferred: ");
        int seat = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you already registered? \n" +
                "Press 1 to enter your id \n" +
                "Press 2 to register.");
        int personOption = scanner.nextInt();
        Person person;
        if(personOption == 1){
            System.out.println("Your id: ");
            int id = scanner.nextInt();
            person = this.findPersonById(id);
        } else {
            person = this.addNewPerson();
        }
        if(person == null){
            System.out.println("Person doesn't exist: ");
            return;
        }
        scanner.nextLine();
        int ticketId;
        if(tickets.size() > 0){
            ticketId = this.tickets.get(this.tickets.size() - 1).getTicket_id() + 1;
        } else {
            ticketId = 1;
        }
        if(ticketType == 1){
            System.out.println("Preferred free meal: ");
            String freeMeal = scanner.nextLine();
            EconomyClass economyClass = new EconomyClass(baggageCount,isOneway,seat,person.getFirst_name(),person.getLast_name(),flightId,ticketId,100,2,freeMeal);
            tickets.add(economyClass);
        } else {
            FirstClass firstClass = new FirstClass(baggageCount,isOneway,seat,person.getFirst_name(),person.getLast_name(),flightId,ticketId,200,ticketId,"");
            tickets.add(firstClass);
        }
    }

    public void printAllTickets(){
        this.tickets.forEach(ticket ->{
            System.out.println(ticket.toString());
        });
    }

    public void addNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new employee... \n" +
                "If you want to add a pilot press 1 else press 0");
        int isPilot = scanner.nextInt();
        System.out.println("Salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Position: ");
        String position = scanner.nextLine();
        System.out.println("Years of experience: ");
        int experience = scanner.nextInt();
        System.out.println("Are you already registered? \n" +
                "Press 1 to enter your id \n" +
                "Press 2 to register.");
        int personOption = scanner.nextInt();
        Person person;
        if(personOption == 1){
            System.out.println("Your id: ");
            int id = scanner.nextInt();
            person = this.findPersonById(id);
        } else {
            person = this.addNewPerson();
        }
        if(person == null){
            System.out.println("Person doesn't exist: ");
            return;
        }
        if(isPilot == 1){
            System.out.println("Flight hours: ");
            float flightHours =  scanner.nextFloat();
            scanner.nextLine();
            System.out.println("License type: ");
            String licenseType = scanner.nextLine();
            Pilot pilot = new Pilot(person.getFirst_name(),person.getLast_name(),person.getAge(),person.getPerson_id(),salary,position,experience,flightHours,licenseType);
            employees.add(pilot);
            return;
        }
        Employee employee =  new Employee(person.getFirst_name(),person.getLast_name(),person.getAge(),person.getPerson_id(),salary,position,experience);
        employees.add(employee);
    }

    public void printAllEmployees() {
        this.employees.forEach(employee ->{
            System.out.println(employee.toString());
        });
    }
}
