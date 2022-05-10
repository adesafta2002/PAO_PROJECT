package airportManager.model;

public class Employee extends Person {
    protected float salary;
    protected String position;
    protected int experience;

    public Employee() {
        this.position = "";
    }

    public Employee(String firstName, String lastName, int age, int personId, float salary, String position, int experience) {
        super(firstName, lastName, age, personId);
        this.salary = salary;
        this.position = position;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", position='" + position + '\'' +
                ", experience=" + experience +
                '}';
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
