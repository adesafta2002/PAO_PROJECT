package airportManager.model;

public class Pilot extends Employee{
    private float flightHours;
    private String licenseType;

    public Pilot(String firstName, String lastName, int age, int personId, float salary, String position, int experience, float flightHours, String licenseType) {
        super(firstName, lastName, age, personId, salary, position, experience);
        this.flightHours = flightHours;
        this.licenseType = licenseType;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", personId=" + personId +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", experience=" + experience +
                ", flightHours=" + flightHours +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }

    public float getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(float flightHours) {
        this.flightHours = flightHours;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }
}
