package airportManager.services;

import airportManager.model.Flight;
import airportManager.utils.StorageHelper;

import java.util.*;

public class FlightService {
    private final String airportName;
    private final TreeSet<Flight> flights = new TreeSet<Flight>();
    private final StorageHelper storageHelper;


    public FlightService(String airportName) {
        this.airportName = airportName;
        this.storageHelper = StorageHelper.getInstance();
        this.initializeFlightsList();
    }

    private void initializeFlightsList() {
        try{
            ArrayList<String> initialFlights = storageHelper.readFromFile("FlightsCsv.txt");
            initialFlights.forEach(flightString ->{
                String[] constructorValues = flightString.split(",");
                if(constructorValues.length == 8){
                    this.addFlight(new Flight(Integer.parseInt(constructorValues[0]),Boolean.parseBoolean(constructorValues[1]),constructorValues[2],Float.parseFloat(constructorValues[3]),Integer.parseInt(constructorValues[4]),Integer.parseInt(constructorValues[5]),constructorValues[6], Arrays.asList(constructorValues[7].split("-"))));
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while initializing flights list");
        }
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
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
            if(flight.getFlightId() == flightID){
                isFlightIdUnique[0] = 1;
            }
        });
        if(isFlightIdUnique[0] == 1){
            System.out.println("A flight with this id already Exists");
            return;
        }
        scanner.nextLine();
        System.out.println("Air company name: ");
        String companyName = scanner.nextLine();
        List<String> crewMembers = addCrewMembers();
        int crewMembersNumber = crewMembers.size();
        String[] csvValuesForLine = new String[]{Integer.toString(seats),Boolean.toString(isFlightPrivate),this.airportName,Float.toString(fuel),Integer.toString(flightID),Integer.toString(crewMembersNumber),companyName,String.join("-",crewMembers)};
        this.saveFlightToCsv(csvValuesForLine);
        Flight newFlight = new Flight(seats,isFlightPrivate,this.airportName,fuel,flightID,crewMembersNumber,companyName,crewMembers);
        this.addFlight(newFlight);
    }

    private ArrayList<String> addCrewMembers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Flight crew members number: ");
        int crewMembersNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Crew members: ");
        ArrayList<String> crewMembers =  new ArrayList<String>();
        for(int i = 0; i < crewMembersNumber; i++){
            String crewMember = scanner.nextLine();
            crewMembers.add(crewMember);
        }
        return crewMembers;
    }

    public void printAllFlights(){
        this.flights.forEach(flight ->{
            System.out.println(flight.toString());
        });
    }

    private void saveFlightToCsv(String[] csvValuesForLine){
        String csvLine = String.join(",",csvValuesForLine);
        this.storageHelper.writeToFile(csvLine,"FlightsCsv.txt");
    }

    public Flight findFlightById(int id){
        for (Flight flight : this.flights) {
            if (flight.getFlightId() == id) {
                return flight;
            }
        }
        return null;
    }
}
