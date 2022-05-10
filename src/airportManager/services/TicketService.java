package airportManager.services;

import airportManager.model.*;
import airportManager.utils.StorageHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketService {
    private final FlightService flightService;
    private final PersonService personService;
    private final List<Ticket> tickets =  new ArrayList<Ticket>();
    private final String airportName;
    private final StorageHelper storageHelper;

    public TicketService(String airportName, FlightService flightService, PersonService personService) {
        this.airportName = airportName;
        this.flightService = flightService;
        this.personService = personService;
        storageHelper = StorageHelper.getInstance();
        this.initializeTicketsList();
    }

    private void initializeTicketsList() {
        try{
            ArrayList<String> initialTickets = storageHelper.readFromFile("RestaurantsCsv.txt");
            initialTickets.forEach(ticketString ->{
                String[] constructorValues = ticketString.split(",");
                if(constructorValues[constructorValues.length-1].equals("FC")){
                    this.tickets.add(new FirstClass(Integer.parseInt(constructorValues[0]),Boolean.parseBoolean(constructorValues[1]),Integer.parseInt(constructorValues[2]),constructorValues[3],constructorValues[4],Integer.parseInt(constructorValues[5]),Integer.parseInt(constructorValues[6]),Integer.parseInt(constructorValues[7]),Integer.parseInt(constructorValues[8]),constructorValues[9]));
                }
                if(constructorValues[constructorValues.length-1].equals("EC")){
                    this.tickets.add(new EconomyClass(Integer.parseInt(constructorValues[0]),Boolean.parseBoolean(constructorValues[1]),Integer.parseInt(constructorValues[2]),constructorValues[3],constructorValues[4],Integer.parseInt(constructorValues[5]),Integer.parseInt(constructorValues[6]),Integer.parseInt(constructorValues[7]),Integer.parseInt(constructorValues[8]),constructorValues[9]));
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while initializing restaurants list");
        }
    }


    public void addNewTicket(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buying new Ticket...");
        System.out.println("Choose the ticket type: ");
        System.out.println("1-Economy Class-100EUR ");
        System.out.println("2-First Class-200EUR ");
        int ticketType = scanner.nextInt();
        System.out.println("Choose the flight from one of these, type only the flight id: ");
        this.flightService.printAllFlights();
        int flightId = scanner.nextInt();
        Flight flight = this.flightService.findFlightById(flightId);
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
            person = this.personService.findPersonById(id);
        } else {
            person = this.personService.addNewPerson();
        }
        if(person == null){
            System.out.println("Person doesn't exist: ");
            return;
        }
        scanner.nextLine();
        int ticketId;
        if(tickets.size() > 0){
            ticketId = this.tickets.get(this.tickets.size() - 1).getTicketId() + 1;
        } else {
            ticketId = 1;
        }
        if(ticketType == 1){
            System.out.println("Preferred free meal: ");
            String freeMeal = scanner.nextLine();
            String[] csvValuesForLine = new String[]{Integer.toString(baggageCount),Boolean.toString(isOneway),Integer.toString(seat),person.getFirstName(),person.getLastName(),Integer.toString(flightId),Integer.toString(ticketId),"100","2",freeMeal,"EC"};
            this.saveTicketsToCsv(csvValuesForLine);
            EconomyClass economyClass = new EconomyClass(baggageCount,isOneway,seat,person.getFirstName(),person.getLastName(),flightId,ticketId,100,2,freeMeal);
            tickets.add(economyClass);
        } else {
            String[] csvValuesForLine = new String[]{Integer.toString(baggageCount),Boolean.toString(isOneway),Integer.toString(seat),person.getFirstName(),person.getLastName(),Integer.toString(flightId),Integer.toString(ticketId),"200",Integer.toString(ticketId),"","FC"};
            this.saveTicketsToCsv(csvValuesForLine);
            FirstClass firstClass = new FirstClass(baggageCount,isOneway,seat,person.getFirstName(),person.getLastName(),flightId,ticketId,200,ticketId,"");
            tickets.add(firstClass);
        }
    }

    private void saveTicketsToCsv(String[] csvValuesForLine){
        String csvLine = String.join(",",csvValuesForLine);
        this.storageHelper.writeToFile(csvLine,"TicketsCsv.txt");
    }

    public void printAllTickets(){
        this.tickets.forEach(ticket ->{
            System.out.println(ticket.toString());
        });
    }
}
