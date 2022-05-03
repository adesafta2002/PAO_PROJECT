package airportManager;

public class Employee extends Person {
    private float salary;
    private String position;
    private int experience;

    public Employee() {
        super();
        this.salary = 0;
        this.position = "";
        this.experience = 0;
    }

    public Employee(String first_name, String last_name, int age, int person_id, float salary, String position, int experience) {
        super(first_name, last_name, age, person_id);
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
