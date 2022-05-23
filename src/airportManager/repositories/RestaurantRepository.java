package airportManager.repositories;

import airportManager.config.DBConnection;
import airportManager.model.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private Connection connection;

    public RestaurantRepository() {
        try{
            this.connection = DBConnection.getInstance();
        }catch (SQLException e) {
            System.out.println("error when connecting to database");
            e.printStackTrace();
        }
    }

    public void save(Restaurant restaurant) {
        String query = "insert into restaurant values(?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setString(2, restaurant.getSpecific());
            preparedStatement.setString(3, restaurant.getLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String name, String specific, String location) {
        String query = "update restaurant set rspecific=?, location=? where name=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, specific);
            preparedStatement.setString(2, location);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "select * from restaurant";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String name = resultSet.getString(1);
                String specific = resultSet.getString(2);
                String location = resultSet.getString(3);
                restaurants.add(new Restaurant(name, specific, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public void delete(String name){
        String query = "delete from restaurant where name=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
