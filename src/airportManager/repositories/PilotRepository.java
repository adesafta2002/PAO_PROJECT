package airportManager.repositories;

import airportManager.config.DBConnection;
import airportManager.model.Employee;
import airportManager.model.Pilot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotRepository {
    private Connection connection;

    public PilotRepository() {
        try {
            this.connection = DBConnection.getInstance();
        } catch (SQLException e) {
            System.out.println("error when connecting to database");
            e.printStackTrace();
        }
    }

    public void save(Pilot pilot) {
        String query = "insert into pilot values(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pilot.getPersonId());
            preparedStatement.setInt(2, pilot.getAge());
            preparedStatement.setString(3, pilot.getFirstName());
            preparedStatement.setString(4, pilot.getLastName());
            preparedStatement.setFloat(5, pilot.getSalary());
            preparedStatement.setString(6, pilot.getPosition());
            preparedStatement.setInt(7, pilot.getExperience());
            preparedStatement.setFloat(8, pilot.getFlightHours());
            preparedStatement.setString(9, pilot.getLicenseType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String firstName, String lastName, int age, int id, float salary, String position, int experience, float flightHours, String licenseType) {
        String query = "update pilot set age=?, firstName=?, lastName=?, salary=?, position=?, experience=?, flightHours=?, licenseType=? where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setFloat(4, salary);
            preparedStatement.setString(5, position);
            preparedStatement.setInt(6, experience);
            preparedStatement.setFloat(7, flightHours);
            preparedStatement.setString(8, licenseType);
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pilot> getAll() {
        List<Pilot> pilots = new ArrayList<Pilot>();
        String query = "select * from pilot";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int age = resultSet.getInt(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                float salary = resultSet.getFloat(5);
                String position = resultSet.getString(6);
                int experience = resultSet.getInt(7);
                float flightHours = resultSet.getInt(8);
                String licenseType = resultSet.getString(9);
                pilots.add(new Pilot(firstName, lastName, age, id,salary,position,experience,flightHours,licenseType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pilots;
    }

    public void delete(int id) {
        String query = "delete from pilot where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
