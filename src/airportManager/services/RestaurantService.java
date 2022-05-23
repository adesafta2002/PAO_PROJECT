package airportManager.services;

import airportManager.model.Person;
import airportManager.model.Restaurant;
import airportManager.repositories.RestaurantRepository;
import airportManager.utils.StorageHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    private final List<Restaurant> restaurants = new ArrayList<Restaurant>();
    private final String airportName;
    private final StorageHelper storageHelper;
    RestaurantService(String airportName){
        this.airportName = airportName;
        this.storageHelper = StorageHelper.getInstance();
        this.initializeRestaurantList();
    }

    private void initializeRestaurantList() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        try{
            ArrayList<String> initialRestaurants = storageHelper.readFromFile("RestaurantsCsv.txt");
            initialRestaurants.forEach(restaurantString ->{
                String[] constructorValues = restaurantString.split(",");
                if(constructorValues.length == 3){
                    this.restaurants.add(new Restaurant(constructorValues[0],constructorValues[1],constructorValues[2]));
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while initializing restaurants list");
        }
        List<Restaurant> restaurants = restaurantRepository.getAll();
        this.restaurants.addAll(restaurants);
        this.storageHelper.logActivity("Initialized restaurant list");
    }

    public void addNewRestaurant() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new restaurant...");
        System.out.println("Restaurant name: ");
        String restaurantName = scanner.nextLine();
        System.out.println("Restaurant specific: ");
        String specific = scanner.nextLine();
        System.out.println("Restaurant location: ");
        String location = scanner.nextLine();
//        modified saving restaurants to database
//        String[] csvValuesForLine = new String[]{restaurantName, specific, location};
//        this.saveRestaurantsToCsv(csvValuesForLine);
        Restaurant restaurant = new Restaurant(restaurantName, specific, location);
        this.restaurants.add(restaurant);
        restaurantRepository.save(restaurant);
        this.storageHelper.logActivity("Added new restaurant");
    }

    private void saveRestaurantsToCsv(String[] csvValuesForLine){
        String csvLine = String.join(",",csvValuesForLine);
        this.storageHelper.writeToFile(csvLine,"RestaurantsCsv.txt");
    }

    public void printAllRestaurants() {
        this.restaurants.forEach(restaurant ->{
            System.out.println(restaurant.toString());
        });
        this.storageHelper.logActivity("Printed all restaurants");
    }

    public void deleteRestaurant(String name){
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        restaurantRepository.delete(name);
    }

    public void updateRestaurant( String name, String specific, String location){
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        restaurantRepository.update(name,specific,location);
    }
}
