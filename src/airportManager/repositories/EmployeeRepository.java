package airportManager.repositories;

import airportManager.config.DBConnection;
import airportManager.model.Employee;
import airportManager.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection connection;

    public EmployeeRepository() {
        try {
            this.connection = DBConnection.getInstance();
        } catch (SQLException e) {
            System.out.println("error when connecting to database");
            e.printStackTrace();
        }
    }

    public void save(Employee employee) {
        String query = "insert into employee values(?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employee.getPersonId());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getLastName());
            preparedStatement.setFloat(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPosition());
            preparedStatement.setInt(7, employee.getExperience());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String firstName, String lastName, int age, int id, float salary, String position, int experience) {
        String query = "update employee set age=?, firstName=?, lastName=?, salary=?, position=?, experience=? where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setFloat(4, salary);
            preparedStatement.setString(5, position);
            preparedStatement.setInt(6, experience);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        String query = "select * from employee";
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
                employees.add(new Employee(firstName, lastName, age, id,salary,position,experience));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void delete(int id) {
        String query = "delete from employee where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
