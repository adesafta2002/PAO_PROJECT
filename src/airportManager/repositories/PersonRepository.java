package airportManager.repositories;

import airportManager.config.DBConnection;
import airportManager.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private Connection connection;

    public PersonRepository() {
        try {
            this.connection = DBConnection.getInstance();
        } catch (SQLException e) {
            System.out.println("error when connecting to database");
            e.printStackTrace();
        }
    }

    public void save(Person person) {
        String query = "insert into person values(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, person.getPersonId());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getFirstName());
            preparedStatement.setString(4, person.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String firstName, String lastName, int age,int id) {
        String query = "update person set age=?, firstName=?, lastName=? where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getAll() {
        List<Person> persons = new ArrayList<Person>();
        String query = "select * from person";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int age = resultSet.getInt(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                persons.add(new Person(firstName, lastName, age, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void delete(int id) {
        String query = "delete from person where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
