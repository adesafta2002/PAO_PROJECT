package airportManager.services;

import airportManager.model.Employee;
import airportManager.model.Person;
import airportManager.model.Pilot;
import airportManager.repositories.PersonRepository;
import airportManager.utils.StorageHelper;

import java.util.*;

public class PersonService {
    private final String airportName;
    private final Set<Person> persons = new HashSet<Person>();
    private final StorageHelper storageHelper;

    public PersonService(String airportName) {
        this.airportName = airportName;
        storageHelper = StorageHelper.getInstance();
        this.initializePersonList();
    }

    private void initializePersonList() {
        PersonRepository personRepository = new PersonRepository();
        try {
            ArrayList<String> initialPersons = storageHelper.readFromFile("PersonsCsv.txt");
            initialPersons.forEach(personString -> {
                String[] constructorValues = personString.split(",");
                if (constructorValues.length == 4) {
                    this.persons.add(new Person(constructorValues[0], constructorValues[1], Integer.parseInt(constructorValues[2]), Integer.parseInt(constructorValues[3])));
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while initializing persons list");
        }
        List<Person> persons = personRepository.getAll();
        this.persons.addAll(persons);
        this.storageHelper.logActivity("Initialized persons list");
    }

    public Person addNewPerson() {
        PersonRepository personRepository = new PersonRepository();
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
//         persons are now saved to database
//        String[] csvValuesForLine = new String[]{firstName,lastName,Integer.toString(age),Integer.toString(id)};
//        this.savePersonsToCsv(csvValuesForLine);
        Person person = new Person(firstName, lastName, age, id);
        this.persons.add(person);
        personRepository.save(person);
        this.storageHelper.logActivity("Added new person");
        return person;
    }

    public Person findPersonById(int id) {
        for (Person person : this.persons) {
            if (person.getPersonId() == id) {
                return person;
            }
        }
        this.storageHelper.logActivity("Searched person by id: " + Integer.toString(id));
        return null;
    }

    private void savePersonsToCsv(String[] csvValuesForLine) {
        String csvLine = String.join(",", csvValuesForLine);
        this.storageHelper.writeToFile(csvLine, "PersonsCsv.txt");
    }

    public void printRegisteredPersons() {
        this.persons.forEach(person -> {
            System.out.println(person.toString());
        });
        this.storageHelper.logActivity("Printed all persons");
    }

    public void deletePerson(int id) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.delete(id);
    }

    public void updatePerson(String firstName, String lastName, int age, int id) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.update(firstName, lastName, age, id);
    }
}
