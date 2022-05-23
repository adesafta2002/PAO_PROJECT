package airportManager.model;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected int personId;

    public Person(){
        this.firstName = "";
        this.lastName = "";
    }

    public Person(String firstName, String lastName, int age, int personId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", personId=" + personId +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
