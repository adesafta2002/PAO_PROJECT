package airportManager.services;

import airportManager.model.Employee;
import airportManager.model.Flight;
import airportManager.model.Person;
import airportManager.model.Pilot;
import airportManager.utils.StorageHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private final String airportName;
    private final PersonService personService;
    private final List<Employee> employees =  new ArrayList<Employee>();
    private final  StorageHelper storageHelper;

    public EmployeeService(String airportName, PersonService personService) {
        this.airportName = airportName;
        this.personService = personService;
        storageHelper = StorageHelper.getInstance();
        this.initializeEmployeeList();
    }

    private void initializeEmployeeList() {
        try{
            ArrayList<String> initialEmployees = storageHelper.readFromFile("EmployeesCsv.txt");
            initialEmployees.forEach(employeeString ->{
                String[] constructorValues = employeeString.split(",");
                if(constructorValues.length == 7){
                    this.employees.add(new Employee(constructorValues[0],constructorValues[1],Integer.parseInt(constructorValues[2]),Integer.parseInt(constructorValues[3]),Float.parseFloat(constructorValues[4]),constructorValues[5],Integer.parseInt(constructorValues[6])));
                }
                if(constructorValues.length == 9) {
                    this.employees.add(new Pilot(constructorValues[0],constructorValues[1],Integer.parseInt(constructorValues[2]),Integer.parseInt(constructorValues[3]),Float.parseFloat(constructorValues[4]),constructorValues[5],Integer.parseInt(constructorValues[6]),Float.parseFloat(constructorValues[7]),constructorValues[8]));
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while initializing employees list");
        }
    }

    public void addNewEmployee() {
        String[] csvValuesForLine;
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
            person = this.personService.findPersonById(id);
        } else {
            person = this.personService.addNewPerson();
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
            csvValuesForLine = new String[] {person.getFirstName(),person.getLastName(),Integer.toString(person.getAge()),Integer.toString(person.getPersonId()),Float.toString(salary),position,Integer.toString(experience),Float.toString(flightHours),licenseType};
            this.saveEmployeeToCsv(csvValuesForLine);
            Pilot pilot = new Pilot(person.getFirstName(),person.getLastName(),person.getAge(),person.getPersonId(),salary,position,experience,flightHours,licenseType);
            employees.add(pilot);
            return;
        }
        csvValuesForLine = new String[] {person.getFirstName(),person.getLastName(),Integer.toString(person.getAge()),Integer.toString(person.getPersonId()),Float.toString(salary),position,Integer.toString(experience)};
        this.saveEmployeeToCsv(csvValuesForLine);
        Employee employee =  new Employee(person.getFirstName(),person.getLastName(),person.getAge(),person.getPersonId(),salary,position,experience);
        employees.add(employee);
    }

    private void saveEmployeeToCsv(String[] csvValuesForLine){
        String csvLine = String.join(",",csvValuesForLine);
        this.storageHelper.writeToFile(csvLine,"EmployeesCsv.txt");
    }

    public void printAllEmployees() {
        this.storageHelper.logActivity("Printed all employees");
        this.employees.forEach(employee ->{
            System.out.println(employee.toString());
        });
    }
}
