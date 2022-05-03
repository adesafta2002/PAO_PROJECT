package airportManager;

public class Pilot extends Employee{
    private float flight_hours;
    private String license_type;

    public Pilot(String first_name, String last_name, int age, int person_id, float salary, String position, int experience, float flight_hours, String license_type) {
        super(first_name, last_name, age, person_id, salary, position, experience);
        this.flight_hours = flight_hours;
        this.license_type = license_type;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "flight_hours=" + flight_hours +
                ", license_type='" + license_type + '\'' +
                '}';
    }

    public float getFlight_hours() {
        return flight_hours;
    }

    public void setFlight_hours(float flight_hours) {
        this.flight_hours = flight_hours;
    }

    public String getLicense_type() {
        return license_type;
    }

    public void setLicense_type(String license_type) {
        this.license_type = license_type;
    }
}
