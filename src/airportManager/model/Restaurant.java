package airportManager.model;

public class Restaurant {
    private String name;
    private String specific;
    private String location;

    public Restaurant(String name, String specific, String location) {
        this.name = name;
        this.specific = specific;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", specific='" + specific + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
